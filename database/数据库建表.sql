
/**/
create table user (
	user_id int unsigned not null auto_increment comment '用户ID' ,

	user_name varchar(32) not null comment '用户名昵称',
	
	user_sex varchar(5) comment '用户性别',
	
	user_phone int(11)  comment '用户手机号',
	
	user_password varchar(20) not null comment '用户密码',
	
	user_email varchar(64) not null comment '用户电子邮件',
	
	user_qq varchar(11) comment '用户qq',

	user_says varchar(255) comment '用户个性签名',

	user_register_time date comment '用户注册时间',

	user_birth date comment '用户出生日期',

	user_address varchar(255) comment '用户地址',

	user_image blob comment '用户头像',

	user_mark mediumint unsigned not null default 0 comment '用户积分',

	user_rank smallint not null default 0 comment '用户等级',

	user_lock tinyint(3) not null default 0 comment '是否锁定，0为不锁定，1为锁定',
 	
 	user_freeze tinyint(3)  not null default 0 comment '是否冻结，0为不冻结，1为冻结',

 	primary key (user_id)
 	
 
)engine=Innodb default charset=utf8 
/*用户好友表*/

create table friend (
	fre_id smallint unsigned not null auto_increment comment '自增ID,系统中有多少好友',
	user_id int unsigned not null comment '用户ID',
	user_friend_id int unsigned not null comment '用户好友ID',
	primary key (fre_id),
	foreign key (user_id) references user(user_id),
	foreign key (user_friend_id) references user(user_id)

) engine=Innodb default charset=utf8
/*角色表*/
create table role (
	role_id tinyint unsigned not null auto_increment comment '角色ID',
	role_name varchar(32) not null comment '角色名',
	role_valid tinyint not null default 0 comment '角色有效标志，0表示有效，1无效',
	role_date date comment '创建日期',
	primary key (role_id)
)engine=Innodb default charset=utf8 

/*权限表*/
create table power(
	power_id tinyint unsigned not null auto_increment comment '权限ID',
	power_name varchar(32) not null comment '权限名称',
	power_url varchar(255) not null comment '可以访问的url',
	primary key (power_id )
)engine=Innodb default charset=utf8 

/*用户角色关联表*/
create table user_role (
	user_id int unsigned not null comment '用户ID',
	role_id tinyint unsigned not null comment '角色ID',
	primary key (user_id,role_id),
	foreign key (user_id) references user(user_id),
	foreign key (role_id) references role(role_id)	
)

/*角色权限关联表*/
create table role_power (
	role_id tinyint unsigned not null comment '角色ID',
	power_id tinyint unsigned not null auto_increment comment '权限ID',
	primary key (role_id,power_id),
	foreign key (role_id) references role(role_id),
	foreign key (power_id) references power(power_id)
)



/*系统分类表*/
create table sort (
	sort_id int unsigned not null auto_increment comment '分类ID',
	sort_name varchar(32) not null comment '分类名称',
	primary key (sort_id)
) engine=Innodb default charset=utf8


/*用户个人分类表*/
create table category (
	category_id tinyint unsigned not null auto_increment comment '个人分类ID',
	category_name varchar(32) not null comment '个人分类名称',
	user_id int unsigned not null comment '分类所属用户',	
	primary key (category_id),
	foreign key (user_id) references user(user_id)
)engine=Innodb default charset=utf8 

/*文章表*/
create table article (
	article_id int unsigned not null auto_increment comment '文章ID',
	article_time  date not null comment '发布时间',	
	article_title varchar(128) not null comment '文章标题',
	article_content text comment '文章的类容',	
	article_permission int(2) not null default 0 comment '0：私有，1：公开',	
	article_read int not null default 0 comment '阅读人数',
	article_agree int unsigned not null default 0 comment '点赞数',
	article_disagree int unsigned not null default 0 comment '踩数',
	
	category_id tinyint unsigned not null default 0 comment '文章的个人分类，0表示默认分类',
	sort_id int unsigned not null comment '文章系统分类',
	user_id int unsigned not null comment'文章的作者',
	
	primary key (article_id),
	foreign key (category_id) references category(category_id), 
	foreign key (sort_id) references sort(sort_id),
	foreign key (user_id) references user(user_id)
) engine=Innodb default charset=utf8 



user_fans mediumint unsigned default 0 comment '用户粉丝数',

	user_follow smallint unsigned default 0 comment '用户关注数',*/