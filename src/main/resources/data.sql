insert into users (id)
values  (1),
        (2);

insert into activity (id)
values  (1),
        (2);

insert into time_report (id, user_id, activity_id, date, duration, date_reported)
values  (1, 1, 1, '2025-09-23', 5000, '2025-09-24'),
        (2, 1, 1, '2025-09-24', 10000, '2025-09-24');