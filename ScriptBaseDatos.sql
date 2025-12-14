create database SistemaBancario;
use SistemaBancario;
create table cuentasUsuario(
id int primary key auto_increment,
usuario varchar(50) not null unique,
clave varchar(50) not null,
monto decimal not null check(monto>=0),
historialTransacciones varchar(2000) default 'Ninguna'
);

insert into cuentasUsuario(usuario,clave,monto) values('root','admin123',1000.00);