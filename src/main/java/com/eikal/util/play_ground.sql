select
    d.name as dep_name, f.name as fac_name, f.type, concat(a.first_name, ' ', a.last_name)  as emp_name, e.title, a.gender, a.role
from
    department as d, facility as f, employee as e, app_user as a
where
    f.id=d.facility_id and d.created_by=e.id and e.app_user_id = a.id;


select
    concat(u1.first_name, ' ', u1.last_name) as `First User`, concat(u2.first_name, ' ', u2.last_name) as `Second User`, r.type
from
    user as u1, user as u2, relationship as r
where
    u1.id = r.user1_id and u2.id = r.user2_id and r.is_next_of_kin_of <> -1;