insert into course(id,name,CREATED_DATE,LAST_UPDATED_DATE) values (10001,'AEM',sysdate(),sysdate());
insert into course(id,name,CREATED_DATE,LAST_UPDATED_DATE) values (10002,'Angular',sysdate(),sysdate());
insert into course(id,name,CREATED_DATE,LAST_UPDATED_DATE) values (10003,'Spring Boot',sysdate(),sysdate());

insert into Passport(id,name) values (40001,'E123456');
insert into Passport(id,name) values (40002,'N123456');
insert into Passport(id,name) values (40003,'L123456');

insert into Student(id,name,PASSPORT_ID) values (20001,'Ranga',40001);
insert into Student(id,name,PASSPORT_ID) values (20002,'Adam',40002);
insert into Student(id,name,PASSPORT_ID) values (20003,'Jane',40003);



insert into Review(id,description,rating,course_id) values (50001,'awesome',5,10001);
insert into Review(id,description,rating,course_id) values (50002,'great',4,10001);
insert into Review(id,description,rating,course_id) values (50003,'good',4,10003);

insert into STUDENT_COURSE( STUDENT_ID,COURSE_ID) values (20001,10001);
insert into STUDENT_COURSE( STUDENT_ID,COURSE_ID) values (20002,10001);
insert into STUDENT_COURSE( STUDENT_ID,COURSE_ID) values (20003,10001);
insert into STUDENT_COURSE( STUDENT_ID,COURSE_ID) values (20001,10003);
