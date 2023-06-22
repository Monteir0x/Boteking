package com.boteking.boteking.services.exceptions;

import java.io.Serial;

public class DatabaseExceptions extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public DatabaseExceptions(String message){
        super(message);
    }
}
