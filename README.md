Documentação da API Todostec
Introdução
A API Todostec fornece funcionalidades para gerenciar usuários, postagens e mensagens em um sistema de chat. Ela permite a criação, atualização, exclusão e busca de informações de usuários, postagens e mensagens.

Base URL
A URL base para acessar os endpoints da API Todostec é: http://seuservidor.com/api/todostec

Endpoints
Listar Usuários
URL: /selecionar
Método HTTP: GET
Descrição: Retorna a lista de todos os usuários cadastrados no sistema.
Resposta de Exemplo:
[
  {
    "ncdusuario": 1,
    "cnome": "Nome do Usuário",
    "cusername": "username",
    "ctelefone": "123456789",
    "cemail": "usuario@email.com",
    "ncontaativa": "1",
    "ncdpronome": 1,
    "ncdgenero": 1,
    "ncdsexualidade": 1,
    "cdescricao": "Descrição do usuário",
    "clinksite": "https://website.com",
    "clinkfoto": "https://avatar.com/avatar.jpg"
  },
  // Outros usuários
]
Buscar Usuário por Username
URL: /selecionar/username/{cusername}
Método HTTP: GET
Parâmetros: cusername (username do usuário)
Descrição: Retorna informações do usuário com o username especificado.
Resposta de Exemplo:
{
  "ncdusuario": 1,
  "cnome": "Nome do Usuário",
  "cusername": "username",
  "ctelefone": "123456789",
  "cemail": "usuario@email.com",
  "ncontaativa": "1",
  "ncdpronome": 1,
  "ncdgenero": 1,
  "ncdsexualidade": 1,
  "cdescricao": "Descrição do usuário",
  "clinksite": "https://website.com",
  "clinkfoto": "https://avatar.com/avatar.jpg"
}
Verificar Disponibilidade de Username
URL: /selecionar/verificarUsername/{cusername}
Método HTTP: GET
Parâmetros: cusername (username a verificar)
Descrição: Verifica se o username especificado está disponível para registro.


Resposta de Exemplo:

{
  "mensagem": "Username liberado",
  "status": "sucesso"
}
Criar Usuário
URL: /inserir
Método HTTP: POST
Corpo da Requisição: Dados do usuário a ser criado.
Descrição: Cria um novo usuário no sistema.
Exemplo de Corpo da Requisição:
{
  "cnome": "Nome do Usuário",
  "cusername": "username",
  "csenha": "senhadousuario",
  "ctelefone": "123456789",
  "cemail": "usuario@email.com",
  "ncdpronome": 1,
  "ncdgenero": 1,
  "ncdsexualidade": 1,
  "cdescricao": "Descrição do usuário",
  "clinksite": "https://website.com",
  "clinkfoto": "https://avatar.com/avatar.jpg"
}
Postagens
Listar Postagens
URL: /selecionar
Método HTTP: GET
Descrição: Retorna a lista de todas as postagens cadastradas no sistema.
Resposta de Exemplo:
[
  {
    "ncdpost": 1,
    "ctexto": "Conteúdo da postagem",
    "ncdusuario": 1,
    "usuario": {
      "ncdusuario": 1,
      "cnome": "Nome do Usuário",
      "cusername": "username",
      "clinksite": "https://website.com"
    }
  },
  // Outras postagens
]
Listar Postagens Aleatórias
URL: /selecionar/random
Método HTTP: GET
Descrição: Retorna uma lista de postagens aleatórias, incluindo uma postagem paga com link.
Resposta de Exemplo:



[
  {
    "ncdpost": 1,
    "ctexto": "Conteúdo da postagem",
    "ncdusuario": 1,
    "usuario": {
      "ncdusuario": 1,
      "cnome": "Nome do Usuário",
      "cusername": "username",
      "clinksite": "https://website.com"
    }
  },
  // Outras postagens
]
Buscar Postagens por Username
URL: /selecionar/{cusername}
Método HTTP: GET
Parâmetros: cusername (username do usuário)
Descrição: Retorna uma lista de postagens do usuário com o username especificado.
Resposta de Exemplo:
[
  {
    "ncdpost": 1,
    "ctexto": "Conteúdo da postagem",
    "ncdusuario": 1,
    "usuario": {
      "ncdusuario": 1,
      "cnome": "Nome do Usuário",
      "cusername": "username",
      "clinksite": "https://website.com"
    }
  },
  // Outras postagens do usuário
]
Inserir Postagem
URL: /inserir
Método HTTP: POST
Corpo da Requisição: Dados da postagem a ser criada.
Descrição: Cria uma nova postagem no sistema.
Exemplo de Corpo da Requisição:

{
  "ctexto": "Conteúdo da postagem",
  "ncdusuario": 1
}
Chat
Listar Mensagens do Chat
URL: /findall/mongo
Método HTTP: GET
Descrição: Retorna a lista de mensagens do chat armazenadas no MongoDB.
Resposta de Exemplo:
[
  {
    "nomeChat": "Nome do Chat",
    "username": "username",
    "message": "Mensagem de chat"
  },
  // Outras mensagens de chat
]
