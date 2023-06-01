alter table cad_cafe_coco
add ativo tinyint not null
default 1;

alter table cad_cafe_beneficiado
add ativo tinyint not null
default 1;

alter table cad_cafe_maquina
add ativo tinyint not null
default 1;