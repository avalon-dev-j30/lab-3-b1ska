package ru.avalon.java.actions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Действие, которое копирует файлы в пределах дискового пространства.
 */
public class FileCopyAction implements Action {

    /**
     * {@inheritDoc}
     */
    private final Path source;
    private final Path destenation;

    public FileCopyAction(String source, String destenation) {
        this.source = Paths.get(source);
        this.destenation = Paths.get(destenation);
    }

    @Override

    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileCopyAction
         */

        try {

            if (Files.exists(source)) {
                if (!Files.isDirectory(source)) {
                    if (Files.notExists(destenation)) {
                        Files.copy(source, destenation);
                        System.out.println("Копия файла создана");
                    } else {
                        System.out.println("Указанный файл уже существует, копирование невозможно");
                    }

                } else {
                    System.out.println("Указанна директория, а не файл");
                }
            } else {
                System.out.println("Файл не найден");
            }

        } catch (Exception e) {
            System.out.println("Возникла ошибка при копировании, указанный путь к месту копирования не существует");;
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */
        Action.super.close();
    }
}
