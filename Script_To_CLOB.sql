DECLARE
  str varchar2(32767);
BEGIN
  str := 'Very_long_string_value';
  UPDATE NM_CRM.EVENT_TABLE
  SET
  IN_MSG = str
  WHERE ID = '312';
END;