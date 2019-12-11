package ru.avalon.java;

import java.io.BufferedReader;
import ru.avalon.java.console.ConsoleUI;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.avalon.java.actions.*;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "Программирование на платформе Java. Разработка многоуровневых
 * приложений"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность"
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Lab3 extends ConsoleUI<Commands> {

    /**
     * Точка входа в приложение.
     *
     * @param args
     */
    String source;
    String destenation;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        new Lab3().run();
    }

    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием перечисления
     * {@link Commands}.
     */
    Lab3() {
        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {

        switch (command) {
            case copy:
                /*
                 * TODO №6 Обработайте команду copy
                 */

                System.out.println("введите путь к файлу копирования");
                source = reader.readLine();
                System.out.println("введите путь к файлу назначния");
                destenation = reader.readLine();
                FileCopyAction copyAct = new FileCopyAction(source, destenation);
                copyAct.run();

                break;
            case move:
                /*
                 * TODO №7 Обработайте команду move
                 */

                System.out.println("введите путь к файлу для перемещения");
                source = reader.readLine();
                System.out.println("введите путь куда переместить файл");
                destenation = reader.readLine();
                FileMoveAction moveFile = new FileMoveAction(source, destenation);
                moveFile.run();
                break;
               

            case delete:
                System.out.println("введите путь к файлу который хотите удалить");
                source = reader.readLine();
                FileDeleteAction fdelete = new FileDeleteAction(source);
                fdelete.run();
              
                break;
            case rename:
                
               System.out.println("введите путь к файлу который хотите переименовать");
                source = reader.readLine();
                System.out.println("введите путь и новое имя файла");
                destenation = reader.readLine();
                FileRenameAction frename = new FileRenameAction(source, destenation);
                frename.run();
                break;

            case exit:
                close();
                break;

            /*
                 * TODO №9 Обработайте необработанные команды
             */
        }
    }

}
