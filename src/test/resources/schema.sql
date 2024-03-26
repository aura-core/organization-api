create table departments (
    id uuid not null,
    name varchar(80) not null,
    description varchar(80),
    user_id uuid,
    status varchar(255) not null check (status in ('ACTIVE','INACTIVE','DELETED')),
    contact_phone_number varchar(40),
    contact_email varchar(80),
    contact_description varchar(255),
    created_at timestamp(6) not null,
    created_by varchar(255) not null,
    updated_at timestamp(6) not null,
    updated_by varchar(255) not null,
    primary key (id)
);

create table job_position_entity_roles (
    job_position_entity_id uuid not null,
    roles varchar(80) not null
);

create table possitions (
    id uuid not null,
    name varchar(80) not null,
    description varchar(80),
    status varchar(255) not null check (status in ('ACTIVE','INACTIVE','DELETED')),
    created_at timestamp(6) not null,
    created_by varchar(255) not null,
    updated_at timestamp(6) not null,
    updated_by varchar(255) not null,
    primary key (id)
)

create table sectors (
    id uuid not null,
    name varchar(80) not null,
    description varchar(80),
    user_id uuid,
    contact_phone_number varchar(40),
    contact_email varchar(80),
    contact_description varchar(255),
    status varchar(255) not null check (status in ('ACTIVE','INACTIVE','DELETED')),
    created_at timestamp(6) not null,
    created_by varchar(255) not null,
    updated_at timestamp(6) not null,
    updated_by varchar(255) not null,
    primary key (id)
)

create table teams (
    id uuid not null,
    name varchar(80) not null,
    description varchar(80),
    user_id uuid,
    status varchar(255) not null check (status in ('ACTIVE','INACTIVE','DELETED')),
    contact_phone_number varchar(40),
    contact_email varchar(80),
    contact_description varchar(255),
    created_at timestamp(6) not null,
    created_by varchar(255) not null,
    updated_at timestamp(6) not null,
    updated_by varchar(255) not null,
    primary key (id)
)

create table units (
    id uuid not null,
    name varchar(80) not null,
    description varchar(80),
    user_id uuid,
    status varchar(255) not null check (status in ('ACTIVE','INACTIVE','DELETED')),
    address_street varchar(80),
    address_city varchar(60),
    address_number integer,
    address_neighborhood varchar(60),
    address_complement varchar(60),
    address_cep varchar(10),
    address_country_acronym varchar(2),
    address_country varchar(60),
    address_state varchar(60),
    contact_phone_number varchar(40),
    contact_email varchar(80),
    contact_description varchar(255),
    created_at timestamp(6) not null,
    created_by varchar(255) not null,
    updated_at timestamp(6) not null,
    updated_by varchar(255) not null,
    primary key (id)
);

create table users (
    id uuid not null,
    name varchar(80) not null,
    login varchar(40) not null unique,
    email varchar(80) not null unique,
    status varchar(255) not null check (status in ('ACTIVE','INACTIVE','PENDING','BLOCKED','DELETED')),
    created_at timestamp(6) not null,
    created_by varchar(255) not null,
    updated_at timestamp(6) not null,
    updated_by varchar(255) not null,
    contact_phone_number varchar(40),
    contact_email varchar(80),
    contact_description varchar(255),
    primary key (id)
);

alter table if exists departments
   add constraint departments_user_id
   foreign key (user_id)
   references users;

alter table if exists job_position_entity_roles
   add constraint job_position_entity_roles_job_position_entity_id
   foreign key (job_position_entity_id)
   references possitions;

alter table if exists sectors
   add constraint sectors_user_id
   foreign key (user_id)
   references users;

alter table if exists teams
   add constraint teams_user_id
   foreign key (user_id)
   references users;

alter table if exists units
   add constraint units_user_id
   foreign key (user_id)
   references users;