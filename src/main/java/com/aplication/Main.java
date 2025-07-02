package com.aplication;

import br.com.crud.dao.UserDAO;
import br.com.crud.exception.EmptyStorageException;
import br.com.crud.exception.UserNotFoundException;
import br.com.crud.exception.ValidatorException;
import br.com.crud.model.MenuOption;
import br.com.crud.model.UserModel;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static br.com.crud.validator.UserValidator.verifyModel;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private final static UserDAO dao = new UserDAO();

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Bem vindo ao cadastro de usuários, selecione a operação desejada");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar por identificador");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");
            int inputOption = scanner.nextInt();
            MenuOption selectedOption = MenuOption.values()[inputOption -1];
            switch (selectedOption) {
                case SAVE -> {
                    try {
                        UserModel user = dao.save(requestToSave());
                        System.out.printf("Usuário salvo %s", user);
                    } catch (ValidatorException ex) {
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }
                }
                case UPDATE -> {
                    try {
                        UserModel user = dao.update(requestToUpdate());
                        System.out.printf("Usuário atualizado %s", user);
                    } catch (UserNotFoundException |EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    } catch (ValidatorException ex) {
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    } finally {
                        System.out.println("================");
                    }
                }
                case DELETE -> {
                    try {
                        dao.delete(requestId());
                        System.out.printf("Usuár removido");
                    } catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    } finally {
                        System.out.println("================");
                    }
                }
                case FIND_BY_ID -> {
                    try {
                        var id = requestId();
                        var user = dao.findById(id);
                        System.out.println("Usuários cadastrados");
                        System.out.println(user);
                    } catch (UserNotFoundException |EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case FIND_ALL -> {
                    try {
                        var users = dao.findAll();
                        System.out.println("======== COMEÇO ========");
                        System.out.println("Usuários cadastrados: ");
                        System.out.println("======== FIM ========");
                        users.forEach(System.out::println);

                    } catch (UserNotFoundException |EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case EXIT -> System.exit(0);
            }

        }


    }

    private static long requestId() {
        System.out.println("Digite o identificado do Usuário: ");
        return scanner.nextLong();
    }

    private static UserModel requestToSave() throws ValidatorException {
        System.out.println("Digite o nome do Usuário: ");
        String nome = scanner.next();
        System.out.println("Digite o email do Usuário: ");
        String email = scanner.next();
        System.out.println("Data de nascimento: (dd/MM/yyyy)");
        String dataNascimentoString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoString, formatter);
        return validateInput(0, nome, email, dataNascimento);

    }

    private static UserModel validateInput(final long id, final String nome,
                                           final String email, final LocalDate dataNascimento) throws ValidatorException {
        var user = new UserModel(0, nome, email, dataNascimento);
        verifyModel(user);
        return user;
    }


    private static UserModel requestToUpdate() throws ValidatorException {
        System.out.println("Digite o identificado do Usuário: ");
        long id = scanner.nextLong();
        System.out.println("Digite o nome do Usuário: ");
        String nome = scanner.next();
        System.out.println("Digite o email do Usuário: ");
        String email = scanner.next();
        System.out.println("Data de nascimento: (dd/MM/yyyy)");
        String dataNascimentoString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoString, formatter);
        return validateInput(0, nome, email, dataNascimento);
    }

}