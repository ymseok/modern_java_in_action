package io.example;

import io.example.BehaviorParameterization;
import io.example.modern.BehaviorParameterizationImpl;

public class BehaviorParameterizationFactory {

    public static enum TYPE { MODERN, TRADITIONAL };

    public static BehaviorParameterization newBehaviorParameterization(TYPE type){

        switch (type){
            case MODERN:
                return new io.example.modern.BehaviorParameterizationImpl();
            case TRADITIONAL:
                return new io.example.traditional.BehaviorParameterizationImpl();
            default :
                System.out.println("type isn't match");
                return null;
        }
    }
}