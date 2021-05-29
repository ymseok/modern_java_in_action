package io.example.traditional;

import io.example.BehaviorParameterization;

import java.io.File;
import java.io.FileFilter;

public class BehaviorParameterizationImpl implements BehaviorParameterization {

    public File[] getHiddenFiles(String path){

        File[] hiddenFiles = new File(".").listFiles(new FileFilter(){
            public boolean accept(File file){
                return file.isHidden();
            }
        });
        return hiddenFiles;
    }

}
