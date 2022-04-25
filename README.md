# Find n' Bytes
A proposta desse repositório é ter como exemplo, como consultar texto dentro de bytes utilizando funções do Oracle/Oracle Text usando Java com Spring.

## Motivação
Um tempo atrás recebi um desafio bastante curioso, e resolvi criar esse repositório em memória dele. A proposta do desafio era a seguinte:

1. O usuário pode fazer o upload de um arquivo com as seguintes extensões: csv, pdf, txt, doc, docx, xls, xlsx, xml;
2. O usuário pode baixar qualquer arquivo enviado;
3. Deve haver uma forma de pesquisar dentro do arquivo com uma palavra e retornar um trecho em que ela se encontra.

## Restrições
Deveria ser uma API Rest utilizando Java com Spring e se conectando ao banco de dados Oracle.
Não deve utilizar nenhum mecanismo de busca ou analise como por exemplo Elasticsearch, etc.

## Get Started

### Primeiros Passos
Resolvi começar pelo "simples", receber o arquivo do usuário e salvar no banco como BLOB para que eu consiga baixar novamente, dessa forma não preciso manter o arquivo em nenhum diretório ou algo do tipo.


## Documentação da API 

http://localhost:8080/swagger-ui/index.html