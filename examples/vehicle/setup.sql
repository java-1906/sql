create table end_user (
    end_user_id number(10) primary key,
    username varchar2(255) not null unique,
    password varchar2(255) not null,
    is_admin number(1) not null
);

CREATE SEQUENCE end_user_seq
    start with 1
    increment by 1;
    
CREATE OR REPLACE TRIGGER end_user_trigger_id 
BEFORE INSERT ON end_user
FOR EACH ROW
BEGIN 
    IF :new.end_user_id IS NULL THEN
    SELECT end_user_seq.nextval INTO :new.end_user_id from dual;
    END IF;
END;    
/

CREATE OR REPLACE PROCEDURE addEndUser(username IN varchar2, password IN varchar2, is_admin number, end_user_id out number)
IS
BEGIN
    INSERT INTO end_user (username, password, is_admin) 
    VALUES(username, password, is_admin);
    end_user_id := end_user_seq.currval;
    commit;
END;
/

CREATE OR REPLACE PROCEDURE login(username IN varchar2, password IN varchar2, is_admin out number, end_user_id out number) IS
    users_password varchar2;
    user_isAdmin number;
    user_id number;
BEGIN
    select password into users_password, is_admin, end_user_id from end_user where username = username;
    
    if users_password = password then 
        
    end if;
END;
/

declare
    username varchar2(255);
    password varchar2(255);
begin
    username := 'quinn';
    select password into password, is_admin, end_user_id from end_user where username = username;
end;
