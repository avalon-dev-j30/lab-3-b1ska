package ru.avalon.java.actions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Действие, которое перемещает файлы в пределах дискового пространства.
 */
public class FileMoveAction implements Action {

    /**
     * {@inheritDoc}
     */

    private final Path source;
    private final Path destenation;

    public FileMoveAction(String source, String destenation) {
        this.source = Paths.get(source);
        this.destenation = Paths.get(destenation);
    }

    @Override
    public void run() {

        try {
            if (Files.exists(source)) {
                if (!Files.isDirectory(source)) {
                    if (Files.exists(destenation)) {
                        Files.move(source, destenation);
                        System.out.println("Файл перемещен");
                    } else {
                        System.out.println("Указанна не верный путь к файлу назначения, возможно дирректория не существует");
                    }

                } else {
                    System.out.println("Указанна директория, а не файл");
                }
            } else {
                System.out.println("Файл не найден");
            }

        } catch (Exception e) {
            System.out.println("Возникла ошибка при перемещении файла");
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №5 Реализуйте метод close класса FileMoveAction
         */
        Action.super.close();
    }

}
