package io.example;

import io.example.domain.Apple;

import java.io.File;
import java.util.List;

public interface BehaviorParameterization {

    File[] getHiddenFiles(String path);

    List<Apple> filterGreenApples(List<Apple> inventory);
    
}
