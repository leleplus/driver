
-- 默认角色
INSERT INTO sys_role
(role_id, role_name, role_key, role_sort, data_scope, status, del_flag, create_by, create_time, update_by, update_time, remark)
VALUES (1, '管理员', 'ADMIN', 1, 1, '0', '0', 'witt', now(), 'witt', now(), '管理员'),
       (2, '教练', 'COACH', 2, 2, '0', '0', 'witt', now(), 'witt', now(), '教练'),
       (3, '学员', 'STUDENT', 3, 3, '0', '0', 'witt', now(), 'witt', now(), '学员');
