package dictionaryProject;

import java.io.File;
import java.util.Scanner;


public class Main {
    MyTranslateDictionaryCore usingDict;


    public static void main(String[] args) {
        MyTranslateDictionaryCore myDictionary = new MyTranslateDictionaryCore();
        File file = myDictionary.setFilePath(); // Установка пути к файлу
        myDictionary.openAndReadOrCreateFile(file); // Открытие или создание файла

        boolean dict4 = true;

        MyTranslateDictionaryCore usingDict;
        Scanner in = new Scanner(System.in);

        System.out.println("Выберите словарь:");
        System.out.println("1. Англоязычный словарь");
        System.out.println("2. Цифровой словарь");

        int dictChoice = in.nextInt();
        in.nextLine();

        if (dictChoice == 1) {
            usingDict = new MyDictionary4lettersLanguage(file);
            dict4 = true;
        } else if (dictChoice == 2) {
            usingDict = new MyDictionary5numLanguage(file);
            dict4 = false;
        } else {
            System.out.println("Неверный выбор. По умолчанию выбран словарь языка 1.");
            usingDict = new MyDictionary4lettersLanguage(file);
            dict4 = true;
        }

//        MyDictionary4lettersLanguage m4lDict = new MyDictionary4lettersLanguage(file);
//        MyDictionary5numLanguage m5nDict = new MyDictionary5numLanguage(file);
//        MyTranslateDictionaryCore supportDict = m5nDict;
//        MyTranslateDictionaryCore usingDict = m4lDict;
        String actionNum = "";
        in = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("1. Сменить словарь. Сейчас используется - " + usingDict.getName());
            System.out.println("2. Добавить запись в словарь");
            System.out.println("3. Удалить запись из словаря по ключу");
            System.out.println("4. Найти запись по ключу");
            System.out.println("5. Вывести содержимое словарей");
            System.out.println("6. Сохранить значения словаря");
            System.out.println("7. Выйди из программы");
            if (usingDict instanceof MyDictionary4lettersLanguage) {
                System.out.println("Вы используете словарь из 4 символов.");
            } else if (usingDict instanceof MyDictionary5numLanguage) {
                System.out.println("Вы используете словарь из 5 символов.");
            }
            System.out.print("Введите номер желаемого действия: ");
            while (actionNum.equals("")) {
                actionNum = in.nextLine();
            }
            switch (actionNum) {
                case ("1"): {
                    if (dict4)
                        usingDict = new MyDictionary5numLanguage(file);
                    else
                        usingDict = new MyDictionary4lettersLanguage(file);
                    dict4 = !dict4;
                    break;
                }
                case ("2"): {
                    System.out.println("Введите слово: ");
                    String word = in.next();
                    System.out.println("Введите перевод: ");
                    String translation = in.next();
                    if (MyTranslateDictionaryCore.isCyrillic(translation)) {
                        usingDict.addWordAndTranslation(word, translation);
                    }
                    break;
                }
                case ("3"): {
                    System.out.println("Введите слово для удаления: ");
                    String word = in.next();
                    usingDict.removeByKey(word);
                    break;
                }
                case ("4"): {
                    System.out.println("Введите слово для поиска: ");
                    String word = in.next();
                    System.out.println("Найденное значение: " + usingDict.findByKey(word));
                    break;
                }
                case ("5"): {
                    usingDict.printAll();
                    break;
                }
                case ("6"): {
                    MyTranslateDictionaryCore dopDict;
                    if (dict4)
                        dopDict = new MyDictionary5numLanguage(file);
                    else
                        dopDict = new MyDictionary4lettersLanguage(file);
                    usingDict.saveIntoFile(false);
                    dopDict.saveIntoFile(true);
                    break;
                }
                case ("7"): {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
            actionNum = "";
        }
    }

    // private static void saver(MyTranslateDictionaryCore usingDict) {
    // usingDict.saveIntoFile();
    // }
}