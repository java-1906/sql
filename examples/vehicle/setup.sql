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

create or replace procedure attempt_login(users_username in varchar2, ppassword in varchar2, pass out number, id out number, isAdmin out number) as
    users_password varchar2(200);
    userId number(10);
    user_is_admin number(10);
begin
    select password, end_user_id, is_admin into users_password, userId, user_is_admin from end_user where username = users_username;
    if users_password = ppassword then
        pass := 1;
        id := userId;
        isAdmin := user_is_admin;
    else
        pass := 0;
        id := 0;
        isAdmin := 0;
    end if;
end;

