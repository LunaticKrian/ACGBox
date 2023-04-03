# ACGBox 半个二次元盒子

## 模块划分：

- 🚩 WebSite 网站导航模块（开发中......）



### ACGBox-WebSite 模块：

<p>
数据库建表语句:
</p>

- acgbox_website_site

```sql
create table `acgbox_website_site`(
    `site_id` bigint not null comment '站点主键ID',
    `menu_id` bigint not null default 0 comment '站点分类菜单ID',
    `user_id` bigint not null comment '站点用户ID',
    `site_name` varchar(50) not null comment '站点名称',
    `site_logo_path` varchar(100) null comment '站点logo图片地址',
    `site_description` varchar(300) null comment '站点描述信息',
    `site_url` varchar(300) not null comment '站点URL地址',
    `click_count` int not null default 0 comment '站点点击量',
    `order_num` int not null default 0 comment '站点显示顺序',
    `create_time` datetime not null default now() comment '新增记录时间',
    `update_time` datetime not null default now() comment '修改记录时间',
    `create_by` bigint not null comment '新增记录用户ID',
    `update_by` bigint not null comment '跟新记录用户ID',
    `delete_status` tinyint(1) not null default 0 comment '逻辑删除状态：0 正常，1 删除',
    `status` int(1) not null default 0 comment '记录状态：0 正常，1 删除，-1 禁止',
    primary key (`user_id`, `menu_id`, `site_id`),
    unique (`site_id`),
    index (`site_name`)
) comment '网站导航网站记录表' engine = innodb default charset = utf8mb4 collate = utf8mb4_general_ci;
```

<p>查看当前数据表索引</p>

```sql
show index from `acgbox_website_site`;
```

- acgbox_website_menu

```sql
create table `acgbox_website_menu`(
    `menu_id` bigint not null comment '站点分类菜单ID',
    `user_id` bigint not null comment '站点用户ID',
    `menu_name` varchar(50) not null comment '站点菜单名称',
    `menu_icon` varchar(50) null comment '站点菜单分类图标',
    `parent_id` bigint not null default 0 comment '站点分类菜单父级ID',
    `order_number` int not null default 0 comment '站点分类菜单显示顺序',
    `create_time` datetime not null default now() comment '新增记录时间',
    `update_time` datetime not null default now() comment '修改记录时间',
    `create_by` bigint not null comment '新增记录用户ID',
    `update_by` bigint not null comment '跟新记录用户ID',
    `delete_status` tinyint(1) not null default 0 comment '逻辑删除状态：0 正常，1 删除',
    `status` int(1) not null default 0 comment '记录状态：0 正常，1 删除，-1 禁止',
    primary key (`user_id`, `menu_id`),
    unique (`menu_id`)
) comment '网站导航站点分类菜单表' engine = innodb default charset = utf8mb4 collate = utf8mb4_general_ci;
```

<p>查看当前数据表索引</p>

```sql
show index from `acgbox_website_menu`;
```

