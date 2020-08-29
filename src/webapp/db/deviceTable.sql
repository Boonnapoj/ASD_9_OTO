/**
 * Author:  apple
 * Created: 2020-6-2
 */

-- DROP TABLE DEVICES;

CREATE TABLE DEVICES
(
Id int GENERATED ALWAYS AS IDENTITY (START WITH 1000, INCREMENT BY 1) primary key,
Name varchar(15),
Price double,
Type varchar(10),
stock int
);

INSERT INTO DEVICES (NAME, PRICE, TYPE, STOCK)
VALUES
('macbook Air', 1140.99, 'laptop', 4000),
('macbook Pro', 1580.99, 'laptop', 3500),
('razor', 40.99, 'mouse', 8500);

SELECT * FROM DEVICES;

-- UPDATE IOTUSER.DEVICES SET NAME = 'wire80', PRICE = 6.99 ,TYPE = 'wire',STOCK = 1200 WHERE ID =1002;
-- 
-- SELECT ID FROM DEVICES;
