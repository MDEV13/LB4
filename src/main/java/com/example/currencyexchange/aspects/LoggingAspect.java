package com.example.currencyexchange.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(public * com.example.currencyexchange.controllers.MainController.mainPage(org.springframework.ui.Model))")
    public void beforeChange()
    {
        System.out.println("[ LOGGING MESSAGE ] Start to process opening \"mainPage\"");
    }

    @After("execution(public * com.example.currencyexchange.controllers.MainController.mainPage(org.springframework.ui.Model)))")
    public void afterChange()
    {
        System.out.println("[ LOGGING MESSAGE ] End to the process");
    }
}
