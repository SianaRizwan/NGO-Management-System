-----------------------------------------------------------------------designation------
drop table designation;
create table designation(
id varchar2(10) primary key,
designation_name varchar2(100),
type varchar2(15) not null,
amount number,
constraint desig_type check (type in ('Doctor','Employee'))
);

insert into designation(designation_name,amount,type) values ('aaaa',1000,'Doctor');
insert into designation(designation_name,amount,type) values ('a2aa',1000,'Doctor');
insert into designation(designation_name,amount,type) values ('ewwa',3000,'Employee');
insert into designation(designation_name,amount,type) values ('gtrha',5000,'Employee');
insert into designation(designation_name,amount,type) values ('a28a',1900,'Doctor');
commit;
select * from designation;

-------------------------------- generate designation_id
set serveroutput on;
CREATE OR REPLACE FUNCTION GET_designation_id(dtype varchar2)
RETURN varchar2
IS
d_ID varchar2(10);
tp varchar2(2);
id number;
aa number;
BEGIN
SELECT  max(ID) INTO d_ID FROM designation;

dbms_output.put_line(d_id);
if dtype='Doctor' then tp:='D';
else tp:='E';
end if;


IF d_ID IS NULL --- Does not exist
THEN
	id := 1001;

ELSE
select max(substr(id,2)) into id from designation ;

	id := id + 1;

END IF;

RETURN NVL((tp||id),-1); --- -1 IS THE ERROR FLAG

END;
/

------------------------- Calling this from a trigger

CREATE OR REPLACE TRIGGER TRG_GEN_desig_ID
BEFORE INSERT ON designation
FOR EACH ROW
BEGIN

:NEW.ID := get_designation_id(:NEW.type);

END;
/




-----------------------------------------------------------------------------------------employee
create TABLE EMPLOYEE(
emp_id number ,
name varchar2(100) not null,
password  varchar2(100) not null,
email varchar2(50) not null,
dob date ,
gender varchar2(10) ,
address varchar2(200) ,
phone varchar2(20),
DESIGNATION varchar2(50),
constraint emp_gender check (gender in ('Male','Female','Others')),
CONSTRAINT EMP_ID_PK PRIMARY KEY(EMP_ID)
);
--insert into employee(name,email,password) values('a','q@d.cpm','q');
--SELECT  max(emp_ID) FROM employee;

------------------------------- generate emp_id
set serveroutput on;
CREATE OR REPLACE FUNCTION GET_Employee_ID(emp_name varchar2,email_p varchar2)
RETURN number
IS
V_ID number;
yr number;
mn number;

BEGIN
SELECT  max(emp_ID) INTO V_ID
FROM employee;

dbms_output.put_line(v_id);

select substr(extract (year from sysdate),-2,2) into yr from dual;

select extract (month from sysdate) into mn from dual;

IF V_ID IS NULL --- Does not exist
THEN
	V_ID := to_number(TO_CHAR( yr) || TO_CHAR(mn) || '1001');

ELSE
	V_ID := V_ID + 1;

END IF;

RETURN NVL(V_ID,-1); --- -1 IS THE ERROR FLAG

END GET_Employee_ID;
/

----------------------------------- Calling this from a trigger

CREATE OR REPLACE TRIGGER TRG_GEN_emp_ID
BEFORE INSERT ON employee
FOR EACH ROW
BEGIN

:NEW.emp_ID := GET_Employee_ID(:NEW.name,:NEW.email);

END;
/


--------------------------------------------------------------------------------------doctor
CREATE TABLE DOCTOR(
DOCTOR_ID varchar2(10) PRIMARY KEY,
name varchar2(100) not null,
email varchar2(50) not null,
dob date not null,
gender varchar2(10) not null,
address varchar2(200) not null,
phone varchar2(20) not null,
 speciality varchar2(50) NOT NULL,
  Available_hr varchar2(20),
QUALIFICATION VARCHAR2(100) not null,
constraint doctor_gender check (gender in ('Male','Female','Others'))
);


--------------------------- generate doctor_id
set serveroutput on;
CREATE OR REPLACE FUNCTION GET_doctor_id
RETURN varchar2
IS
d_ID varchar2(10);
yr number;
id number;
mn number;

BEGIN
SELECT  max(doctor_ID) INTO d_ID FROM doctor;

dbms_output.put_line(d_id);
select substr(extract (year from sysdate),-2,2) into yr from dual;

select extract (month from sysdate) into mn from dual;

IF d_ID IS NULL --- Does not exist
THEN
	id := to_number(TO_CHAR( yr) || TO_CHAR(mn) || '101');

ELSE
select max(substr(Doctor_id,2)) into id from doctor ;

	id := id + 1;

END IF;

RETURN NVL(('D'||id),-1); --- -1 IS THE ERROR FLAG

END;
/

------------------------------- Calling this from a trigger

CREATE OR REPLACE TRIGGER TRG_GEN_doctor_ID
BEFORE INSERT ON doctor
FOR EACH ROW
BEGIN

:NEW.doctor_ID := get_doctor_id();

END;
/

------------------------------------------------------------------------get designation for reg
create or replace function get_designation(idf number)
return varchar2
is
desig varchar2(100);
des varchar2(100);
pos varchar2(100);
begin
select designation into pos from employee where emp_id=idf;
if pos is null then desig:='N/A';
else select designation_name into desig from designation,employee where employee.designation=designation.designation_name and emp_id=idf;

end if;
return desig;
end;
/
------------------------------------------------------------------------------------------------donor table
CREATE TABLE Donor(
Donor_ID varchar2(10) PRIMARY KEY,
name varchar2(100) not null,
email varchar2(50) not null,
gender varchar2(10) not null,
address varchar2(200) ,
phone varchar2(20) not null,
occupation varchar2(20),
constraint donor_gender check (gender in ('Male','Female','Others'))
);

------------------------------------------------ generate donor_id
set serveroutput on;
CREATE OR REPLACE FUNCTION GET_donor_id
RETURN varchar2
IS
d_ID varchar2(10);
yr number;
id number;
mn number;

BEGIN
SELECT  max(donor_ID) INTO d_ID FROM donor;

dbms_output.put_line(d_id);
select substr(extract (year from sysdate),-2,2) into yr from dual;

select extract (month from sysdate) into mn from dual;

IF d_ID IS NULL --- Does not exist
THEN
	id := to_number(TO_CHAR( yr) || TO_CHAR(mn) || '1001');

ELSE
select max(substr(Donor_id,2)) into id from donor ;

	id := id + 1;

END IF;

RETURN NVL(('Don'||id),-1); --- -1 IS THE ERROR FLAG

END;
/

----------------------------------------------- Calling this from a trigger

CREATE OR REPLACE TRIGGER TRG_GEN_donor_ID
BEFORE INSERT ON donor
FOR EACH ROW
BEGIN

:NEW.donor_ID := get_donor_id();

END;
/
------------------------------------------------------------------------------------------------volunteer
CREATE TABLE volunteer(
volunteer_ID varchar2(10) PRIMARY KEY,
name varchar2(100) not null,
email varchar2(50) not null,
gender varchar2(10) not null,
address varchar2(200) ,
phone varchar2(20) not null,
occupation varchar2(20),
constraint volunteer_gender check (gender in ('Male','Female','Others'))
);

------------------------------------ generate volunteer_id
set serveroutput on;
CREATE OR REPLACE FUNCTION GET_volunteer_id
RETURN varchar2
IS
d_ID varchar2(10);
yr number;
id number;
mn number;

BEGIN
SELECT  max(volunteer_ID) INTO d_ID FROM volunteer;

dbms_output.put_line(d_id);
select substr(extract (year from sysdate),-2,2) into yr from dual;

select extract (month from sysdate) into mn from dual;

IF d_ID IS NULL --- Does not exist
THEN
	id := to_number(TO_CHAR( yr) || TO_CHAR(mn) || '1001');

ELSE
select max(substr(volunteer_id,2)) into id from volunteer ;

	id := id + 1;

END IF;

RETURN NVL(('Vol'||id),-1); --- -1 IS THE ERROR FLAG

END;
/

------------------------------------------- Calling this from a trigger

CREATE OR REPLACE TRIGGER TRG_GEN_volunteer_ID
BEFORE INSERT ON volunteer
FOR EACH ROW
BEGIN

:NEW.volunteer_ID := get_donor_id();

END;
/


select * from employee;
select * from designation;
select * from doctor;


----------------------drop schemas-------------------------
drop table doctor;
drop table employee;
drop table designation;
drop sequence emp_SEQ;
drop sequence doctor_SEQ;