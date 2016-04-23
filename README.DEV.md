## When starting this project for the first time.


### Create new database in MySQL DB

$ mysql -u root -p

mysql> USE mysql;

mysql> CREATE DATABASE IF NOT EXISTS demo
 DEFAULT CHARACTER SET = utf8
 DEFAULT COLLATE = utf8_unicode_ci;

mysql> GRANT ALL ON demo.* TO 'root'@'localhost' IDENTIFIED BY 'admin';

mysql> exit;


### Configure REAL Mail or FAKE Mail server

##### FAKE mail servers used only during development

 - www.mailtrap.io
