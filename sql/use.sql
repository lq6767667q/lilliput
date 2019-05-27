-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('小人国库存', '3', '1', '/system/xrgStore', 'C', '0', 'system:xrgStore:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '小人国库存菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('小人国库存查询', @parentId, '1',  '#',  'F', '0', 'system:xrgStore:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('小人国库存新增', @parentId, '2',  '#',  'F', '0', 'system:xrgStore:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('小人国库存修改', @parentId, '3',  '#',  'F', '0', 'system:xrgStore:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('小人国库存删除', @parentId, '4',  '#',  'F', '0', 'system:xrgStore:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('小人国库存补货', @parentId, '5',  '#',  'F', '0', 'system:xrgStore:addin',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('小人国库存出货', @parentId, '6',  '#',  'F', '0', 'system:xrgStore:sell',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
