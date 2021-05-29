package io.example.modern;

import io.example.BehaviorParameterization;
import io.example.domain.Apple;
import io.example.domain.Color;

import java.io.File;
import java.io.FileFilter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BehaviorParameterizationImpl implements BehaviorParameterization {

    public File[] getHiddenFiles(String path){

        path = path == null ? "." : path;

        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        return hiddenFiles;
    }

    @Override
    public List<Apple> filterGreenApples(List<Apple> inventory) {
        return inventory.stream().filter(p -> Color.GREEN.equals(p.getColor())).collect(Collectors.toList());
    }

}
