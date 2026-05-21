package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private final Engine engine;

    //dependency injection through constructor
    public Car(Engine engine){
        this.engine = engine;
    }

    public void drive(){
        engine.start();
        System.out.println("car is running");
    }


}
