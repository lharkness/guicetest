package com.leeharkness.guicetest;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main
{
    public static void main( String[] args ) {
        Injector injector = Guice.createInjector();

        TestService testService = injector.getInstance(TestService.class);
        System.out.println(testService.doWork(42));
    }
}
