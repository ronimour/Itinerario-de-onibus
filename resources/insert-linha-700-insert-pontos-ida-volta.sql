insert into linha (codigoLinha,inicio,fim,tarifa,qtdOnibus,distancia)
values("700","Av. Hermes da Fonseca", "R. Ceará Mirim, 259-321 - Tirol",2.20,12,27);

insert into ponto (descricao,latitude,longitude)
values
#pontos de ida
("Av. Hermes da Fonseca, 2715-2753 - Petrópolis",-5.785789,-35.195272),
("R. Traíri, 663-725 - Petrópolis",-5.786734,-35.195658),
("Av. Hermes da Fonseca, 2457-2599 - Petrópolis",-5.787887,-35.196049),
("Av. Hermes da Fonseca, 2249-2311 - Tirol",-5.789541,-35.19665),
("Av. Hermes da Fonseca, 2051-2119 - Tirol",-5.79103,-35.197214),
("Av. Hermes da Fonseca, 1677-1865 - Tirol",-5.793016,-35.19797),
("Av. Hermes da Fonseca, 1483-1615 - Tirol",-5.794905,-35.198651),
("Av. Hermes da Fonseca, 1219-1289 - Tirol",-5.797349,-35.19952),
("Av. Hermes da Fonseca, 1023-1097 - Tirol",-5.798785,-35.200105),
("Av. Hermes da Fonseca, 781-1021 - Tirol",-5.800813,-35.200883),
("R. Joaquim Fagundes, 699-741 - Tirol",-5.80076,-35.202133),
("R. Joaquim Fagundes, 689-691 - Tirol",-5.800327,-35.203286),
("Av. Prudente de Morais, 2295-2353 - Barro Vermelho",-5.799297,-35.205551),
#pontos de volta
("Av. Prudente de Morais, 2073-2161 - Barro Vermelho",-5.79776,-35.204982),
("Av. Prudente de Morais, 1649-1829 - Tirol",-5.795359,-35.204092),
("Av. Prudente de Morais, 1116 - Lagoa Nova",-5.793,-35.203244),
("R. Apodi, 270-430 - Tirol",-5.790395,-35.203662),
("R. Apodi, 256 - Cidade Alta",-5.789787,-35.205327),
("R. Apodi, 176 - Cidade Alta",-5.788762,-35.207943),
("Av. Rio Branco, 820-854 - Cidade Alta",-5.789819,-35.208533),
("R. Mermoz, 115-243 - Cidade Alta",-5.791612,-35.20805),
("R. Mermoz, 314-366 - Cidade Alta",-5.792882,-35.206999),
("R. Ceará Mirim, 105-257 - Tirol",-5.793106,-35.205497),
("R. Ceará Mirim, 259-321 - Tirol",-5.793704,-35.203984);

insert into linha_pontosida
values
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "Av. Hermes da Fonseca, 2715-2753 - Petrópolis")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "R. Traíri, 663-725 - Petrópolis")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "Av. Hermes da Fonseca, 2457-2599 - Petrópolis")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "Av. Hermes da Fonseca, 2249-2311 - Tirol")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "Av. Hermes da Fonseca, 2051-2119 - Tirol")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "Av. Hermes da Fonseca, 1677-1865 - Tirol")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "Av. Hermes da Fonseca, 1483-1615 - Tirol")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "Av. Hermes da Fonseca, 1219-1289 - Tirol")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "Av. Hermes da Fonseca, 1023-1097 - Tirol")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "Av. Hermes da Fonseca, 781-1021 - Tirol")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "R. Joaquim Fagundes, 699-741 - Tirol")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "R. Joaquim Fagundes, 689-691 - Tirol")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "Av. Prudente de Morais, 2295-2353 - Barro Vermelho"));
insert into linha_pontosvolta
values
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "Av. Prudente de Morais, 2073-2161 - Barro Vermelho")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "Av. Prudente de Morais, 1649-1829 - Tirol")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "Av. Prudente de Morais, 1116 - Lagoa Nova")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "R. Apodi, 270-430 - Tirol")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "R. Apodi, 256 - Cidade Alta")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "R. Apodi, 176 - Cidade Alta")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "Av. Rio Branco, 820-854 - Cidade Alta")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "R. Mermoz, 115-243 - Cidade Alta")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "R. Mermoz, 314-366 - Cidade Alta")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "R. Ceará Mirim, 105-257 - Tirol")),
((select id from linha where codigoLinha = "700"),(select id from ponto where descricao = "R. Ceará Mirim, 259-321 - Tirol"));



