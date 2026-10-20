# Write your MySQL query statement below
with t as(select d.name as Department, e.name as Employee, e.salary as Salary,
dense_rank()over (partition by e.departmentId order by e.salary desc)as rk
from employee e join department d on e.DepartmentId=d.id)
select Department, Employee, Salary from t where rk=1;