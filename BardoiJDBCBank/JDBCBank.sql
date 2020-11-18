create schema if not exists jdbcbank authorization dunkin;

set search_path to jdbcbank;

create table "Customers" (
	"USER_ID" serial primary key,
	firstname varchar(30) not null,
	lastname varchar(30) not null,
	address varchar(50) not null,
	email varchar(30) not null,
	phone varchar(20) not null,
	username varchar(30) unique not null,
	password varchar(30) not null
);

create table "Accounts" (
	"BANK_ACCOUNT_ID" serial primary key,
	"USER_ID" int not null,
	accountType varchar(30) not null,
	balance numeric(100,2) not null,
	foreign key ("USER_ID") references "Customers"("USER_ID") on delete cascade
);