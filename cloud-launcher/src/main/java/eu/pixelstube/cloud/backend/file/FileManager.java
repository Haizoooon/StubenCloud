package eu.pixelstube.cloud.backend.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * This file was created by Max H. (Haizoooon)
 * Date: 22.05.2021
 * Copyright© 2021 Max H.
 **/
public class FileManager {

    public void createFolders(String... files){
        Arrays.stream(files).forEach(s -> {
            if(!new File(s).exists()){
                new File(s).mkdirs();
            }
        });
    }

    public void createFile(String folder, String file){
        if(!new File(folder, file).exists()){
            try {
                new File(folder, file).createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void copyDirectory(String sourceDirectoryLocation, String destinationDirectoryLocation) {

        try {
            Files.walk(Paths.get(sourceDirectoryLocation))
                    .forEach(source -> {
                        Path destination = Paths.get(destinationDirectoryLocation, source.toString()
                                .substring(sourceDirectoryLocation.length()));
                        try {
                            Files.copy(source, destination);

                        } catch (IOException ignored) {

                        }
                    });
        } catch (IOException ignored) {
        }
    }

    public void copyFileOutOfJar(File file, String name){
        InputStream inputStream = getClass().getResourceAsStream(name);
        File parent = file.getParentFile();
        parent.mkdirs();
        if(new File(name).exists()){
            return;
        }
        try {
            file.createNewFile();
            FileUtils.copyInputStreamToFile(inputStream, file);
        } catch (IOException ignored) {
        }
    }

    public void deleteFiles(File folderName){
        if(folderName.exists()){
            try {
                FileUtils.deleteDirectory(folderName);
            } catch (IOException ignored) {
            }
        }
    }

    public boolean copyFile(String from, String to){
        try {
            Files.copy(new File(from).toPath(), new File(to).toPath());
            return true;
        } catch (IOException ignored) {
            return false;
        }
    }

    public boolean createFolder(String folderName){
        try {
            new File(folderName).mkdirs();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean folderExist(String folderName){
        return new File(folderName).exists();
    }

    public boolean fileExist(String folderName, String fileName){
        try {
            return new File(folderName, fileName).exists();
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteTempOrder(){
        deleteFiles(new File("temp"));
    }

}
