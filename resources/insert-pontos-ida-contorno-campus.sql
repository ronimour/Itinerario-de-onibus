insert into linha (codigoLinha,inicio,fim,tarifa,qtdOnibus,distancia)
values("500","ECT","LAUT/DCA",0,7,5);

insert into ponto (descricao,latitude,longitude)
values ("Escola de Ci�ncia e Tecnologia",-5.843648,-35.19971),
("Centro de Bioci�ncias",-5.842087, -35.203240),
("Reitoria UFRN",-5.838573,-35.201628),
("Departamento de Educa��o F�sica",-5.836524,-35.201915),
("Restaurante Universit�rio/Escola de Enfermagem",-5.833178,-35.202983),
("Piscina Ol�mpica/Acesso Gin�sio Poliesportivo",-5.834128,-35.201105),
("Setor de Aulas 5",-5.837375,-35.197162),
("Pr�dio de Geof�sica",-5.839707,-35.195663),
("Departamento de Geologia",-5.841717,-35.195231),
("Laborat�rio de Automa��o em Petr�lio/Departamento de Engenharia de Computa��o e Automa��o",-5.84387,-35.197111);

insert into linha_pontosida 
values((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Escola de Ci�ncia e Tecnologia")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Centro de Bioci�ncias")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Reitoria UFRN")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Departamento de Educa��o F�sica")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Restaurante Universit�rio/Escola de Enfermagem")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Piscina Ol�mpica/Acesso Gin�sio Poliesportivo")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Setor de Aulas 5")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Pr�dio de Geof�sica")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Departamento de Geologia")),
((select id from linha where codigoLinha = "500"),(select id from ponto where descricao = "Laborat�rio de Automa��o em Petr�lio/Departamento de Engenharia de Computa��o e Automa��o"));








