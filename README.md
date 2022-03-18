# Controle de Estoques

Projeto com fim de gerir inicialmente um estoque de bebidas.

###Foi utilizado

Spring Boot<br>
Banco de dados h2<br>
JPA Repository<br>
Lombok<br><br>
Eclipse<br>
Postman<br>


## Utilização
Após iniciar o sistema no eclipse, utilizar alguma ferramenta de requisições como o postman.<br><br>


O Path padrão do projeto é: http://localhost:8081/<br>
Então estarão disponiveis as operações principais (GET, POST, DELETE) atravez do path padrão mais o nome de cada entidade. <br>
Ex: Consulta todos com método GET "/productType"<br>
Consulta por ID com método GET "/productType/{idDrinkType}<br>
Cadastro com método POST "/productType"<br><br>

O banco da dados é criado com alguns dados iniciais informados pelo Cliente, como o estoque, as seções, e os tipos de bebidas.<br>
Console disponível em "/h2".<br><br>

A operação que relaciona as entidades e adiciona ou remove bebidas ao estoque é DrinkMoviment
Podendo ser manipulada pelo path "/sale" com os respectivos métodos e queries.<br>
Informando o id da bebida, o id da seção em que será adicionada, responsavel pela movimentação, e o volume movimentado.<br><br>

Considere a proposta do arquivo "Desafio.pdf".
