package io.example.modern;

import io.example.BehaviorParameterization;

import java.io.File;
import java.io.FileFilter;
import java.util.Optional;

public class BehaviorParameterizationImpl implements BehaviorParameterization {

    public File[] getHiddenFiles(String path){

        path = path == null ? "." : path;

        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        return hiddenFiles;
    }

}
