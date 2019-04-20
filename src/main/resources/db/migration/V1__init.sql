create table users (
    id bigint not null auto_increment primary key ,
    name varchar(50) not null ,
    surname varchar(50) not null ,
    username varchar(50) unique not null ,
    email varchar(50) unique not null ,
    password varchar(60) not null ,
    expired boolean not null default false,
    locked boolean not null default false,
    credentials_expired boolean not null default false,
    enabled boolean not null default false,
    activation_token_id bigint not null unique
);

create table roles (
    id bigint not null auto_increment primary key ,
    name varchar(20) unique not null
);

create table user_roles(
    user_id bigint not null ,
    role_id bigint not null ,

    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id),
    primary key (user_id, role_id)
);

create table activation_tokens (
    id bigint not null primary key auto_increment,
    value varchar(32) not null unique ,
    creation_date datetime not null ,
    expiration_date datetime not null
)