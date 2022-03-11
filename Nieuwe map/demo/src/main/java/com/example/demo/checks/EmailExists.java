package com.example.demo.checks;

public class EmailExists extends Throwable {

    public EmailExists(final String message) {
        super(message);
    }
}