package com.ajhw.service;


import com.ajhw.tickets.Ticket;
import com.ajhw.user.Admin;
import com.ajhw.user.Client;
import com.ajhw.utils.StadiumSector;


import java.lang.reflect.Method;
import java.math.BigDecimal;

public class TicketService {

    public static void main(String[] args) {

        System.out.println("Creating null ticket:");
        Ticket nullTicket = new Ticket();
        //Under construction!!! will fix next time
        //System.out.println(nullTicket);
        System.out.println();



        System.out.println("Creating full ticket, and sharing it");
        Ticket fullTicketExample = new Ticket(123, "Stadium", 123, 123L, true, StadiumSector.B, 10.53f, BigDecimal.valueOf(149.99));
        fullTicketExample.shared(12345,"email");
        System.out.println(fullTicketExample);
        System.out.println();

        System.out.println("Creating limited ticket and sharing it");
        //Overloaded constructor for limited ticket
        Ticket limitedTicketExample = new Ticket("Square",1233, 123L, BigDecimal.valueOf(9.99));
        limitedTicketExample.shared(12345);
        System.out.println(limitedTicketExample);
        System.out.println();


        System.out.println("Creating admin and user objects");
        Admin administrator = new Admin();
        Client customer = new Client();

        System.out.println("Methods of Admin class:");
        Method[] adminMethods = administrator.getClass().getDeclaredMethods();
        for (Method method : adminMethods) {
            System.out.println(method.getName());
        }
        System.out.println();
        System.out.println("And their outputs:");
        administrator.printRole();
        administrator.checkTicket();
        System.out.println();

        System.out.println("Methods of User class:");
        Method[] customerMethods = customer.getClass().getDeclaredMethods();
        for (Method method : customerMethods) {
            System.out.println(method.getName());
        }
        System.out.println();
        System.out.println("And their outputs:");
        customer.printRole();
        customer.getTicket();




    }
}
