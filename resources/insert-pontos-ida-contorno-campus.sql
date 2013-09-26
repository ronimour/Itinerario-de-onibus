insert into linha (codigoLinha,inicio,fim,tarifa,qtdOnibus,distancia)
values("500","ECT","LAUT/DCA",0,7,5);

insert into ponto (descricao,latitude,longitude)
values ("Escola de Ciência e Tecnologia",-5.843648,-35.19971),
("Centro de Biociências",-5.842087, -35.203240),
("Reitoria UFRN",-5.838573,-35.201628),
("Departamento de Educação Física",-5.836524,-35.201915),
("Restaurante Universitário/Escola de Enfermagem",-5.833178,-35.202983),
("Piscina Olímpica/Acesso Ginásio Poliesportivo",-5.834128,-35.201105),
("Setor de Aulas 5",-5.837375,-35.197162),
("Prédio de Geofísica",-5.839707,-35.195663),
("Departamento de Geologia",-5.841717,-35.195231),
("Laboratório de Automação em Petrólio/Departamento de Engenharia de Computação e Automação",-5.84387,-35.197111);

insert into linha_pontosida 
values((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Escola de Ciência e Tecnologia")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Centro de Biociências")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Reitoria UFRN")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Departamento de Educação Física")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Restaurante Universitário/Escola de Enfermagem")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Piscina Olímpica/Acesso Ginásio Poliesportivo")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Setor de Aulas 5")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Prédio de Geofísica")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Departamento de Geologia")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Laboratório de Automação em Petrólio/Departamento de Engenharia de Computação e Automação"));








