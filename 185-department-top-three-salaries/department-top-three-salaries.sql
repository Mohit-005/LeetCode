# Write your MySQL query statement below
select d.name as Department, t1.name as Employee, t1.salary as Salary
from 
(select *
from
(select *, dense_rank() over(partition by departmentId order by salary desc) as rnk
from employee) t
where t.rnk<= 3 ) t1 join department d on t1.departmentId= d.id