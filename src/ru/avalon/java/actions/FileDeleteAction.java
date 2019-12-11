package ru.avalon.java.actions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author b1ska
 */
public class FileDeleteAction implements Action {

    private final Path source;


    public FileDeleteAction(String source) {
        this.source = Paths.get(source);
    }

    @Override
    public void run() {

        try {
            if (Files.exists(source)) {
                if (!Files.isDirectory(source)) {
                     Files.delete(source);
                     System.out.println("Файл удален");
                } else {
                    System.out.println("Указанна директория, а не файл");
                }
            } else {
                System.out.println("Файл не найден");
            }
        } catch (Exception e) {
            System.out.println("Возникла ошибка при удалении файла");
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        Action.super.close();
    }

}
