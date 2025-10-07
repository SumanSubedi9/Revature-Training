package com.revature.spring.ioc;

public class MessageService {
    /**
     * Return the message content.
     */
    public void printMessage(){
        System.out.println("Message:");
    };

    public void init(){
        System.out.println("Init Method called");
    }

    public void destroy(){
        System.out.println("Destroy Method called");
    }

   
}
