package ru.avalon.java.actions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileRenameAction implements Action {

    /**
     * Действие, которое переименовывает файлы.
     */
    private final Path source;
    private final Path destenation;

    public FileRenameAction(String source, String destenation) {
        this.source = Paths.get(source);
        this.destenation = Paths.get(destenation);
    }

    @Override
    public void run() {
        try {
            if (Files.exists(source)) {
                if (!Files.isDirectory(source)) {
                        if (!Files.isDirectory(destenation)) {
                            Files.move(source, destenation);
                            System.out.println("Файл переименован");
                        } else {
                            System.out.println("Ошибка ввода пути имени файла");
                        }
                } else {
                    System.out.println("Указанна директория, а не файл");
                }
            } else {
                System.out.println("Файл не найден");
            }

        } catch (Exception e) {
            System.out.println("Не удалось переименовать файл");
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        Action.super.close();
    }
}
