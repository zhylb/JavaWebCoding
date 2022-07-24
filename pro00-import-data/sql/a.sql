# 第三章 基本的select 语句

#1 SQL的分类
/*
三条主线
DDL：数据定义语言 CREATE\ ALTER\DROP\RENAME\TRUNCATE

DML：数据操作语言 INSERT \ DELETE \ UPDATE \ SELECT (重中之重)

DCL：数据控制语言 COMMIT \ ROLLBACK \ SAVEPOINT \ GRANT\ REVOKE 

由于SELECT 过于庞大 有人定义为 DQL 数据查询语言
还有把 COMMIT \ ROLLBACK 定义为TCL 事务控制语言

思想 ：大处着眼 小处着手
*/

/*
2.1 SQL的规则 --必须要遵守


2.2 SQL的规范 --建议要遵守



3 mysql注释的三种方式
单行
多行 

*/
SELECT * FROM employees\g -- \g是转置的意思，只能在命令行使用

/*
4. 导入现有的数据表、表的数据。
方式1：source 文件的全路径名
举例：source d:\atguigudb.sql;


方式2：基于具体的图形化界面的工具可以导入数据
比如：SQLyog中 选择 “工具” -- “执行sql脚本” -- 选中xxx.sql即可。
*/

SHOW DATABASES;
#5.0 最基本的select语句
SELECT 1 + 1, 3 *2;
SELECT 1 + 1, 3 *2
FROM DUAL; # DUAL 伪表
USE atguigudb;
SELECT * FROM employees;


SELECT employee_id, first_name, last_name FROM employees;
##### 6 列的别名
-- 这里先说一下规范的事情，要严格遵守
-- 1 字符串使用单引号
-- 2 别名使用双引号
-- 3 mysql确实不区分大小写，但是字符串区分大小写
-- 4 上面三种情况在mysql中不会报错，mysql也不会字符串大小写 没有遵循规范 属于是方言

-- 别名
-- -- 使用as关键字，可以省略
-- -- 建议别名使用双引号引起来，可以不引，但是对于别名中有空格那肯定需要
-- -- 
SELECT
	last_name AS "姓",
	first_name AS "名",
	salary "工 资" 
FROM
	employees;








