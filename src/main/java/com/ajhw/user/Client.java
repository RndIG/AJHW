package com.ajhw.user;

public class Client extends User{

    public void getTicket() {
        System.out.println("Got a ticket!");
    }

    @Override
    public void printRole() {
        System.out.println("Client");
    }
}
