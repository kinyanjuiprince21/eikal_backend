select
    d.name as dep_name, f.name as fac_name, f.type, concat(a.first_name, ' ', a.last_name)  as emp_name, e.title, a.gender, a.role
from
    department as d, facility as f, employee as e, app_user as a
where
    f.id=d.facility_id and d.created_by=e.id and e.app_user_id = a.id;
