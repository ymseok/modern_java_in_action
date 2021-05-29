package io.example.traditional;

import io.example.BehaviorParameterization;
import io.example.domain.Apple;
import io.example.domain.Color;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class BehaviorParameterizationImpl implements BehaviorParameterization {

    public File[] getHiddenFiles(String path){

        File[] hiddenFiles = new File(".").listFiles(new FileFilter(){
            public boolean accept(File file){
                return file.isHidden();
            }
        });
        return hiddenFiles;
    }

    @Override
    public List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple : inventory){
            if(Color.GREEN.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

}
