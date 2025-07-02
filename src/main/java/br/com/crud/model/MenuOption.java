package br.com.crud.model;

import br.com.crud.dao.UserDAO;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public enum MenuOption {

    SAVE,
    UPDATE,
    DELETE,
    FIND_BY_ID,
    FIND_ALL,
    EXIT;



}
