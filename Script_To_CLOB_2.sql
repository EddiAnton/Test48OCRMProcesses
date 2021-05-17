DECLARE
  str1 varchar2(32767);
  str2 varchar2(32767);
BEGIN
  str1 := 'Very_long_string_value_1';
  str2 := 'Very_long_string_value_2';
  UPDATE NM_CRM.EVENT_TABLE
  SET
  IN_MSG = to_clob(str1) || to_clob(str2)
  WHERE ID = '7';
END;