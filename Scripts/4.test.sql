

select *from employee;
select titleNo, titleName from title;
select *from department;

CREATE OR REPLACE VIEW 
VW_EMPLOYEE
as
SELECT e.empNo, 
	   e.empName, 
	   t.titleNo, 
	   t.titleName , 
	   e.manager , 
	   m.empname as managerName , 
	   e.salary,
	   d.deptNo ,
	   d.deptName ,
	   d.floor ,
	   e.hiredate 
FROM EMPLOYEE e JOIN TITLE t ON e.TITLE = t.titleNo 
	LEFT JOIN EMPLOYEE m ON e.MANAGER = m.EMPNO
	JOIN DEPARTMENT d ON e.dept = d.DEPTNO ;
