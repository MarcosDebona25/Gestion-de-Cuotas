
create table cuota (
                       id bigint not null auto_increment,
                       estado enum ('PENDIENTE','PAGADA','VENCIDA'),
                       fecha date,
                       cuota_social_id bigint,
                       pago_id bigint,
                       socio_id bigint,
                       primary key (id)
) engine=InnoDB;;

create table cuota_disciplina (
                                  fk_cuota bigint not null,
                                  fk_disciplina bigint not null
) engine=InnoDB;

create table cuota_social (
                              id bigint not null auto_increment,
                              fecha_inicio date,
                              monto float(53) not null,
                              primary key (id)
) engine=InnoDB;

create table disciplina (
                            id bigint not null auto_increment,
                            descripcion varchar(255),
                            nombre varchar(255),
                            tarifa_id bigint,
                            primary key (id)
) engine=InnoDB;

create table pago (
                      id bigint not null auto_increment,
                      fecha_pago date,
                      metodo_pago enum ('EFECTIVO','TARJETA_CREDITO','TARJETA_DEBITO','TRANSFERENCIA'),
                      monto_pagado float(53) not null,
                      primary key (id)
) engine=InnoDB;

create table socio (
                       id bigint not null auto_increment,
                       activo bit not null,
                       apellido varchar(255),
                       dni varchar(255),
                       email varchar(255),
                       fecha_alta date,
                       nombre varchar(255),
                       telefono varchar(255),
                       primary key (id)
) engine=InnoDB;

create table tarifa (
                        id bigint not null auto_increment,
                        descripcion varchar(255),
                        monto float(53) not null,
                        primary key (id)
) engine=InnoDB;

alter table cuota
drop index UK_c5vjyho59nfbq15rngjfyi69r;
    
alter table cuota
    add constraint UK_c5vjyho59nfbq15rngjfyi69r unique (pago_id);
    
alter table cuota_disciplina
drop index UK_6y3o7tus6wy1gueoitrc8a9gc;
    
alter table cuota_disciplina
    add constraint UK_6y3o7tus6wy1gueoitrc8a9gc unique (fk_disciplina);
    
alter table disciplina
drop index UK_93vcolqei23bhs8e00i68cljl;
    
alter table disciplina
    add constraint UK_93vcolqei23bhs8e00i68cljl unique (tarifa_id);
    
alter table cuota
    add constraint FK905qg6wal2kkw92ldyoqpig3g
        foreign key (cuota_social_id)
            references cuota_social (id);
    
alter table cuota
    add constraint FK2scsr6kub5gepf6gxci8v8r9k
        foreign key (pago_id)
            references pago (id);
    
alter table cuota
    add constraint FKfmawua0s433vcpehc9kqyx7pv
        foreign key (socio_id)
            references socio (id);
    
alter table cuota_disciplina
    add constraint FKlvmoi6h7bkq9wraurb58au4sf
        foreign key (fk_disciplina)
            references disciplina (id);
    
alter table cuota_disciplina
    add constraint FKeisni0rppifbpqrkl888ad63j
        foreign key (fk_cuota)
            references cuota (id);
    
alter table disciplina
    add constraint FKesmhv28ekerb5iih780a7wnjk
        foreign key (tarifa_id)
            references tarifa (id)