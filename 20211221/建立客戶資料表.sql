CREATE TABLE `sakila`.`customers` (
  `customerid` CHAR(5) NOT NULL,
  `companyname` VARCHAR(45) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `phonbe` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`customerid`))
COMMENT = '客戶資料表';
