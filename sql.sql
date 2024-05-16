

use AcadamiaNova;

create table endereco (

	id int not null auto_increment,
    idUsu varchar(60) not null,
    endereço varchar(100),
    primary key(id)
    
);

insert into endereco (idUsu, endereço) values (5, 'Rosa');

update usuario set idade = 29 where id = 2;

select * from usuario LEFT join endereco
on usuario.id = endereco.idUsu;