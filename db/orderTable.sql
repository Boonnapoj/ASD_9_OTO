/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  diamo
 * Created: Jun 8, 2020
 */

CREATE TABLE ORDERS
(
ORDERID int GENERATED ALWAYS AS IDENTITY (START WITH 10, INCREMENT BY 1) primary key,
EMAIL varchar(30),
DEVICEID int,
ORDERDATE varchar(50),
AMOUNT int,
STATUS int
);

ALTER TABLE ORDERS
ADD FOREIGN KEY (DEVICEID)
REFERENCES DEVICES(Id);

INSERT INTO ORDERS (EMAIL, DEVICEID, ORDERDATE, AMOUNT, STATUS)
VALUES
('xu@uts.edu.au', 1001, '2011-12-30', 1, 0),
('xu@uts.edu.au', 1002, '2011-08-15', 1, 1),
('feli@uts.edu.au', 1001, '2009-01-05', 1, 1),
('feli@uts.edu.au', 1003, '2010-07-07', 3, 1),
('feli@uts.edu.au', 1004, '2010-07-07', 2, 0);
('xu@uts.edu.au', 1005, '2011-12-30', 6, 1),
('xu@uts.edu.au', 1001, '2011-08-15', 4, 1),
('feli@uts.edu.au', 1001, '2009-01-05', 1, 1),
('feli@uts.edu.au', 1003, '2010-07-07', 2, 4),
('feli@uts.edu.au', 1004, '2010-07-07', 3, 0);
('xu@uts.edu.au', 1001, '2011-12-30', 1, 0),
('xu@uts.edu.au', 1001, '2011-08-15', 1, 1),
('feli@uts.edu.au', 1001, '2009-01-05', 1, 1),
('feli@uts.edu.au', 1003, '2010-07-07', 1, 4),
('vans@uts.edu.au', 1004, '2010-07-07', 1, 4);
('xu@uts.edu.au', 1005, '2011-12-30', 1, 4),
('xu@uts.edu.au', 1001, '2011-08-15', 1, 1),
('vans@uts.edu.au', 1005, '2009-01-05', 1, 1),
('vans@uts.edu.au', 1003, '2010-07-07', 1, 0),
('vans@uts.edu.au', 1004, '2010-07-07', 1, 4);

SELECT * FROM ORDERS;