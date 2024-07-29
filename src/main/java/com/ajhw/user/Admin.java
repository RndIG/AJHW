package com.ajhw.user;

public class Admin extends User{

    public void checkTicket() {
        System.out.println("Checked a ticket!");
    }

    @Override
    public void printRole() {
        System.out.println("Administrator");
    }
}
