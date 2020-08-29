/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lantianxiang
 * Created: 04/06/2020
 */
Create Table paymentDetail(
id varchar(30),
bankCard varchar(30),
cvv varchar(5),
expiryDate varchar(20),
PRIMARY KEY (id)
);

INSERT INTO paymentDetail (id,bankCard,cvv,expiryDate)
VALUES
('09090','1234567812345678','123','19/3/20'),
('12345','8765432187654321','456','21/3/20')


