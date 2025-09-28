insert into users (first_name, last_name, user_role)
values  ('Alexander', 'DeGreat', 'MANAGER'),
        ('Cassandra','Hippopotamos', 'REGULAR');

insert into activity (name)
values  ('Hunting'),
        ('Gathering');

insert into time_report ( user_id, activity_id, date, duration, date_reported)
values  ( 1, 1, '2025-09-23', 5000, '2025-09-24'),
        ( 1, 1, '2025-09-24', 10000, '2025-09-24');