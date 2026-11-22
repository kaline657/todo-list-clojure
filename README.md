
# Todo List em Clojure

## 1. Identificacao

**Disciplina:** Programacao em Clojure  
**Professor:** Sergio Costa  
**Instituicao:** Universidade Federal do Maranhao (UFMA)

**Integrantes:**
- Kaline Maria Carvalho
- [Nome do segundo integrante, se houver]

## 2. Descricao do projeto

Este projeto consiste no desenvolvimento de uma
aplicacao Todo List utilizando a linguagem Clojure
e o banco de dados SQLite.

A aplicacao permite gerenciar tarefas por meio
de um menu interativo executado no terminal.

## 3. Funcionalidades

- Adicionar novas tarefas
- Listar tarefas cadastradas
- Editar o titulo de uma tarefa
- Marcar tarefas como concluidas
- Reabrir tarefas concluidas
- Excluir tarefas
- Armazenar os dados no SQLite
- Manter os dados apos reiniciar a aplicacao

## 4. Tecnologias utilizadas

- Clojure
- Java JDK 21
- SQLite
- JDBC
- Git e GitHub
- Visual Studio Code

## 5. Estrutura do projeto

```text
todo-list-clojure/
├── src/
│   └── todo/
│       ├── core.clj
│       ├── db.clj
│       └── teste.clj
├── deps.edn
├── .gitignore
└── README.md
```

O arquivo todo.db e criado automaticamente na
primeira execucao da aplicacao.

## 6. Pre-requisitos

Para executar o projeto, e necessario ter:

- Java JDK 21 instalado
- Clojure CLI instalado
- Acesso a internet na primeira execucao para
  baixar as dependencias

## 7. Como executar

1. Extraia o arquivo ZIP do projeto.
2. Abra a pasta do projeto no VS Code.
3. Abra o terminal na raiz do projeto.
4. Execute o comando:

```powershell
clojure -M -m todo.core
```

O banco de dados sera inicializado automaticamente.

## 8. Como utilizar

O sistema apresenta as seguintes opcoes:

1 - Adicionar tarefa  
2 - Listar tarefas  
3 - Editar tarefa  
4 - Concluir/Reabrir tarefa  
5 - Excluir tarefa  
0 - Sair

Digite o numero da opcao desejada e pressione Enter.

O sistema permite voltar ao menu apos visualizar
o resultado de cada operacao.

## 9. Persistencia dos dados

O projeto utiliza o SQLite para armazenar as
tarefas em um arquivo local chamado todo.db.

Cada tarefa possui:

- ID: identificador unico
- Titulo: descricao da tarefa
- Concluida: estado da tarefa (0 ou 1)

Os registros permanecem armazenados mesmo depois
que o programa e encerrado.

## 10. Testes realizados

Foram realizados testes manuais de:

- Cadastro de tarefas
- Consulta das tarefas cadastradas
- Edicao de titulos
- Alteracao do estado de conclusao
- Exclusao de tarefas
- Persistencia dos dados apos reinicializacao
- Navegacao pelo menu interativo

## 11. Repositorio GitHub

https://github.com/kaline657/todo-list-clojure

O repositorio contem o historico incremental
de desenvolvimento da aplicacao.

## 12. Video de apresentacao

Nao disponibilizado.

## 13. Conclusao

A aplicacao implementa as operacoes fundamentais
de gerenciamento de tarefas utilizando Clojure,
com persistencia em banco de dados SQLite.

O projeto demonstra a utilizacao de funcoes,
estruturas de controle, entrada de dados e
integracao com banco de dados relacional.

