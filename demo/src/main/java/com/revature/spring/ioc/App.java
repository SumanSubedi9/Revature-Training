package com.revature.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MessageService messageService = context.getBean("messageService", MessageService.class);
        messageService.printMessage();
        messageService.init();
        messageService.destroy();
        ((ClassPathXmlApplicationContext) context).close();


        
        
    }
}
