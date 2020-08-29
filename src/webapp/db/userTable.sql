/**
 * Author:  apple
 * Created: 2020-6-2
 */

--DROP TABLE USERS;

CREATE TABLE USERS
(
Email varchar(50),
Name varchar(10),
Password varchar(20),
Gender varchar(10),
Favcol varchar(10),
DOB date,
Permission varchar(15),
PRIMARY KEY(Email));

INSERT INTO USERS (EMAIL, NAME, PASSWORD, GENDER, FAVCOL, DOB, PERMISSION)
VALUES
('hong@uts.edu.au', 'Hong Kung', '112233', 'male', 'Red', '1997-04-08', 'staff'),
('xu@uts.edu.au', 'George Xu', '123456', 'male', 'Blue', '1998-05-21', 'customer'),
('feli@uts.edu.au', 'Felipe Macedo', '234567', 'male', 'green', '1998-01-21', 'customer');


SELECT * FROM USERS;

