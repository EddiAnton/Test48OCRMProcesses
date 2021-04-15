DECLARE
   MESSAGE              SYS.aq$_jms_text_message;
   enqueue_options      DBMS_AQ.ENQUEUE_OPTIONS_T;
   message_properties   DBMS_AQ.MESSAGE_PROPERTIES_T;
   msgid                RAW (16);
   text                 CLOB;
BEGIN
    select IN_MSG into text from NM_CRM.EVENT_TABLE where ID = '9';
   MESSAGE := sys.aq$_jms_text_message.construct;
   MESSAGE.set_text (text);
   DBMS_AQ.enqueue (queue_name           => 'Q_CFT_CLIENTDATA_UPDATE_IN',
                    enqueue_options      => enqueue_options,
                    message_properties   => message_properties,
                    payload              => MESSAGE,
                    msgid                => msgid);
   COMMIT;
END;