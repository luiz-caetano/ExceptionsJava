package br.com.crud.validator;

import br.com.crud.exception.ValidatorException;
import br.com.crud.model.UserModel;

public class UserValidator {

    private UserValidator() {

    }

    public static void verifyModel(final UserModel model) throws ValidatorException {
        if (stringIsBlank(model.getName()))
            throw new ValidatorException("Informe um nome válido.");
        if (model.getEmail().length() <= 2)
            throw new ValidatorException("Seu nome não pode ter menos que 2 caracteres.");
        if (stringIsBlank(model.getEmail()))
            throw new ValidatorException("Você deve inserir um email.");
        if ((!model.getEmail().contains("@")) || (!model.getEmail().contains(".")))
            throw new ValidatorException("Email inválido.");
    }


    private static boolean stringIsBlank(final String value){
        return value == null || value.isBlank();
    }

}
