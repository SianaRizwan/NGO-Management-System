--------------designation------
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

---- generate designation_id
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

--- Calling this from a trigger

CREATE OR REPLACE TRIGGER TRG_GEN_desig_ID
BEFORE INSERT ON designation
FOR EACH ROW
BEGIN

:NEW.ID := get_designation_id(:NEW.type);

END;
/




-------------employee
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

---- generate emp_id
set serveroutput on;
CREATE OR REPLACE FUNCTION GET_Employee_ID(emp_name varchar2,email_p varchar2)
RETURN number
IS
V_ID number;
yr number;
mn number;
dd varchar2(10);
BEGIN
SELECT  max(emp_ID) INTO V_ID
FROM employee;

dbms_output.put_line(v_id);

select substr(to_char(sysdate,'YYYYMMDD'),3,4) into dd from dual;

IF V_ID IS NULL --- Does not exist
THEN
	V_ID := to_number(dd || '1001');

ELSE
	select max(substr(emp_id,-4)) into mn from employee ;

	mn:=mn+1;
	v_id := to_number(dd||mn);

END IF;

RETURN NVL(V_ID,-1); --- -1 IS THE ERROR FLAG

END GET_Employee_ID;
/
delete from employee where name='ee';
commit;

--- Calling this from a trigger

CREATE OR REPLACE TRIGGER TRG_GEN_emp_ID
BEFORE INSERT ON employee
FOR EACH ROW
BEGIN

:NEW.emp_ID := GET_Employee_ID(:NEW.name,:NEW.email);

END;
/


-----------------------------------------------------------------------------------doctor
drop table doctor;
CREATE TABLE DOCTOR(
DOCTOR_ID varchar2(12) PRIMARY KEY,
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

---insert into doctor(name,email,dob,gender,address,phone,speciality,available_hr,qualification) values('a','a',TO_DATE('01/10/2000', 'dd/mm/yyyy'),'Male','11','1q','q','q','p');
--commit;
--------------------------- generate doctor_id
set serveroutput on;
CREATE OR REPLACE FUNCTION GET_doctor_id
RETURN varchar2
IS
d_ID varchar2(12);
yr number;
id number;
mn number;
dd varchar2(12);
BEGIN
SELECT  max(doctor_ID) INTO d_ID FROM doctor;

dbms_output.put_line(d_id);
select substr(to_char(sysdate,'YYYYMMDD'),3,4) into dd from dual;

IF d_ID IS NULL --- Does not exist
THEN
	id := to_number(dd || '101');

ELSE
select max(substr(Doctor_id,-3)) into mn from doctor ;

	mn:=mn+1;
	id := to_number(dd||mn);

END IF;

RETURN NVL(('D'||id),-1); --- -1 IS THE ERROR FLAG

END;
/

--- Calling this from a trigger

CREATE OR REPLACE TRIGGER TRG_GEN_doctor_ID
BEFORE INSERT ON doctor
FOR EACH ROW
BEGIN

:NEW.doctor_ID := get_doctor_id();

END;
/

-----------------------------------get designation for reg
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




----------------------------------------------------------------------------donor
drop table donor;
CREATE TABLE DOnor(
DOnor_ID varchar2(15) PRIMARY KEY,
name varchar2(100) not null,
email varchar2(50) not null,
gender varchar2(10) not null,
address varchar2(200) ,
phone varchar2(20) not null,
occupation varchar2(20),
constraint donor_gender check (gender in ('Male','Female','Others'))
);


---- generate donor_id
set serveroutput on;
CREATE OR REPLACE FUNCTION GET_donor_id
RETURN varchar2
IS
d_ID varchar2(15);
yr number;
id number;
mn number;
dd varchar2(10);

BEGIN
SELECT  max(donor_ID) INTO d_ID FROM donor;

dbms_output.put_line(d_id);

select substr(to_char(sysdate,'YYYYMMDD'),3,4) into dd from dual;

IF d_ID IS NULL --- Does not exist
THEN
	id := to_number(dd || '1001');

ELSE
select max(substr(donor_id,-4)) into mn from donor ;
mn:=mn+1;
	id := to_number(dd||mn);

END IF;

RETURN NVL(('Don'||id),-1); --- -1 IS THE ERROR FLAG

END;
/

--- Calling this from a trigger

CREATE OR REPLACE TRIGGER TRG_GEN_donor_ID
BEFORE INSERT ON donor
FOR EACH ROW
BEGIN

:NEW.donor_ID := get_donor_id();

END;
/
select * from employee;
-------------------------------------------volunteer
drop table volunteer;
CREATE TABLE volunteer(
volunteer_ID varchar2(15) PRIMARY KEY,
name varchar2(100) not null,
email varchar2(50) not null,
gender varchar2(10) not null,
address varchar2(200) ,
phone varchar2(20) not null,
occupation varchar2(50),
constraint volunteer_gender check (gender in ('Male','Female','Others'))
);


---- generate volunteer_id
set serveroutput on;
CREATE OR REPLACE FUNCTION GET_volunteer_id
RETURN varchar2
IS
d_ID varchar2(15);
yr number;
id number;
mn number;
dd varchar2(10);

BEGIN
SELECT  max(volunteer_ID) INTO d_ID FROM volunteer;

dbms_output.put_line(d_id);

select substr(to_char(sysdate,'YYYYMMDD'),3,4) into dd from dual;

IF d_ID IS NULL --- Does not exist
THEN
	id := to_number(dd || '1001');

ELSE
select max(substr(volunteer_id,-4)) into mn from volunteer ;
mn:=mn+1;
	id := to_number(dd||mn);

END IF;

RETURN NVL(('Vol'||id),-1); --- -1 IS THE ERROR FLAG

END;
/

--- Calling this from a trigger

CREATE OR REPLACE TRIGGER TRG_GEN_volunteer_ID
BEFORE INSERT ON volunteer
FOR EACH ROW
BEGIN

:NEW.volunteer_ID := get_volunteer_id();

END;
/


--------------------------------------------
--------------------------------------------
---------------------SUPPLY DETAILS

--------FOOD
drop table food;
CREATE TABLE FOOD(
ID VARCHAR2(15) PRIMARY KEY,
NAME VARCHAR2(30) NOT NULL,
PURCHASE_DATE DATE NOT NULL,
EXPIRE_DATE DATE,
QTY NUMBER NOT NULL,
SUPPLIER VARCHAR2(30) NOT NULL,
UNIT_PRICE NUMBER NOT NULL
);


------GENERATE FOOD ID
set serveroutput on;
CREATE OR REPLACE FUNCTION GET_FOOD_id(F_DATE DATE)
RETURN varchar2
IS
d_ID varchar2(15);
id varchar2(15);
vv number;
dd varchar2(10);

BEGIN
SELECT  max(ID) INTO d_ID FROM FOOD;

dbms_output.put_line(f_date);
select substr(to_char(f_date,'YYYYMMDD'),5) into dd from dual;

 dbms_output.put_line(dd);


IF d_ID IS NULL --- Does not exist
THEN
    id :=  dd || '10001' ;

ELSE
select max(substr(id,-5)) into vv from FOOD ;
    vv := vv + 1;
	id :=  dd || to_char(vv);

END IF;

RETURN NVL( ('F' || id) , -1); --- -1 IS THE ERROR FLAG

END;
/
select max(substr(id,-5)) from FOOD ;
rollback;
--- Calling this from a trigger

CREATE OR REPLACE TRIGGER TRG_GEN_FOOD_ID
BEFORE INSERT ON FOOD
FOR EACH ROW
BEGIN

:NEW.ID := get_FOOD_id(:NEW.PURCHASE_DATE);

END;
/




---------------------------HEALTH_PRODUCT
CREATE TABLE HEALTH_PRODUCT(
ID VARCHAR2(15) PRIMARY KEY,
NAME VARCHAR2(30) NOT NULL,
PURCHASE_DATE DATE NOT NULL,
EXPIRE_DATE DATE NOT NULL,
QTY NUMBER NOT NULL,
SUPPLIER VARCHAR2(30) NOT NULL,
MANUFACTURER VARCHAR2(30) NOT NULL,
UNIT_PRICE NUMBER NOT NULL,
TYPE NUMBER NOT NULL --1:MED,2:VACC,3:EMERGENCY
);

------GENERATE HEALTH_PRODUCT ID
set serveroutput on;
CREATE OR REPLACE FUNCTION GET_HEALTH_PRODUCT_id(F_DATE DATE,f_type number)
RETURN varchar2
IS
d_ID varchar2(15);
id varchar2(15);
vv number;
dd varchar2(10);
types varchar2(2);

BEGIN
SELECT  max(ID) INTO d_ID FROM HEALTH_PRODUCT;
if f_type=1 then types:='M';
elsif f_type=2 then types:='V';
elsif f_type=3 then types:='E';
end if;
dbms_output.put_line(f_date);
select substr(to_char(f_date,'YYYYMMDD'),5) into dd from dual;

 dbms_output.put_line(dd);


IF d_ID IS NULL --- Does not exist
THEN
    id :=  dd || '10001' ;

ELSE
select max(substr(id,-5)) into vv from HEALTH_PRODUCT ;
    vv := vv + 1;
	id :=  dd || to_char(vv);

END IF;

RETURN NVL( (types || id) , -1); --- -1 IS THE ERROR FLAG

END;
/


--- Calling this from a trigger

CREATE OR REPLACE TRIGGER TRG_GEN_HEALTH_PRODUCT_ID
BEFORE INSERT ON HEALTH_PRODUCT
FOR EACH ROW
BEGIN

:NEW.ID := get_HEALTH_PRODUCT_id(:NEW.PURCHASE_DATE,:new.type);

END;
/

-------------Donation History
create table donation_history(
id varchar2(20) primary key,
don_date date ,
amount number,
donor_id varchar2(15),
type number,--1:regular,2: non regular
constraint don_history_fk foreign key (donor_id) references donor(donor_id)
);

select max(substr(donor_id,4)) from donor;
---- generate donation_id
set serveroutput on;
CREATE OR REPLACE FUNCTION GET_donation_id(ftype number)
RETURN varchar2
IS
d_ID varchar2(20);
id number;
dd varchar2(10);

BEGIN
SELECT  max(ID) INTO d_ID FROM donation_history;

dbms_output.put_line(d_id);
if ftype=1 then dd:='RE';
elsif ftype=2 then dd:='NR';
end if;

IF d_ID IS NULL --- Does not exist
THEN
	id := 10000001;
	
ELSE
select max(substr(id,2)) into id from donation_history ;

	id := id+1;
	
END IF;

RETURN NVL((dd||id),-1); --- -1 IS THE ERROR FLAG

END;
/

--- Calling this from a trigger

CREATE OR REPLACE TRIGGER TRG_GEN_donation_ID
BEFORE INSERT ON donation_history
FOR EACH ROW
BEGIN

:NEW.ID := GET_donation_id(:new.type);

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
