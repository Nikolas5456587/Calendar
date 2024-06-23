package com.example.calendar.service;

public class SelfFriendException extends RuntimeException {

    public SelfFriendException() {
        super("Cannot add self as friend.");
    }
}