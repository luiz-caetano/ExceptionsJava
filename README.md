
# Estudo de Exceções em Java 🎯

![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge\&logo=java\&logoColor=white)

Projeto de console simples criado com o propósito de **aprender sobre exceções em Java**, realizando operações CRUD sobre usuários em memória e manipulando erros com exceções personalizadas.


## 📂 Estrutura do Projeto

* `Main.java`: menu interativo via console.
* `UserDAO`: operações CRUD com armazenamento em memória.
* `UserModel`: modelo com `id`, `nome`, `email`, `data de nascimento`.
* `UserValidator`: valida dados, lança `ValidatorException`.
* `MenuOption`: enum (`SAVE`, `UPDATE`, `DELETE`, `FIND_BY_ID`, `FIND_ALL`, `EXIT`).
* Exceções:

  * `ValidatorException`: dados inválidos.
  * `UserNotFoundException`: usuário não encontrado.
  * `EmptyStorageException`: armazenamento vazio.

 

## 🎓 Objetivo

Este projeto foi criado para aprofundar o entendimento sobre:

* Como **lançar** exceções personalizadas em Java.
* Fluxo de **tratamento de exceções** nos métodos CRUD.
* Uso de boas práticas com `try-catch`, `finally` e mensagens de erro.

 

## 🧠 Pré-requisitos

* Java **JDK 11** ou superior
* IDE ou editor de código (IntelliJ IDEA, Eclipse, VS Code…)

 

## 🚀 Como executar

1. Clone o repositório:

   ```bash
   git clone <url_do_repositório>
   cd <diretório_do_projeto>
   ```
2. Compile e execute:

   * Pelo terminal:

     ```bash
     javac -d out src/com/aplication/Main.java
     java -cp out com.aplication.Main
     ```
   * Ou use o botão **Run** da sua IDE.

 

## 🛠️ Como usar

1. Ao iniciar, será exibido:

   ```
   Bem vindo ao cadastro de usuários...
   1 - Cadastrar
   2 - Atualizar
   3 - Excluir
   4 - Buscar por identificador
   5 - Listar
   6 - Sair
   ```
2. Escolha uma opção (1–6) e pressione Enter.
3. Insira dados conforme solicitado:

   * Nome
   * Email
   * Data de nascimento (`dd/MM/yyyy`)
4. O programa exibe:

   * ✅ Sucesso (detalhes do usuário)
   * 🚫 Mensagem de erro (se uma exceção for lançada)

 

## 🧩 Fluxo de validação e exceções

```text
Main.requestToSave() or requestToUpdate()
        ⇓
Create UserModel
        ⇓
UserValidator.verifyModel(user) → lança ValidatorException se inválido
        ⇓
UserDAO → pode lançar UserNotFoundException ou EmptyStorageException
        ⇓
Main trata exceções e mostra mensagens apropriadas
```

 

## 🏁 Conclusão

Este projeto é um excelente ponto de partida para:

* **Criar** e lançar exceções personalizadas
* Compreender o **fluxo de erros** usando `try-catch-finally`
* Seguir boas práticas de validação e tratamento de erros

Sinta-se à vontade para expandir com testes, interface gráfica, persistência real e mais! 🚀

 
