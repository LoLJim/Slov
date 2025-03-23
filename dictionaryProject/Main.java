package dictionaryProject;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyTranslateDictionaryCore myDictionary = new MyTranslateDictionaryCore();
        myDictionary.setFilePath(); // Установка пути к файлу
        myDictionary.openAndReadOrCreateFile(); // Открытие или создание файла

        MyDictionary4lettersLanguage m4lDict = new MyDictionary4lettersLanguage();
        MyDictionary5numLanguage m5nDict = new MyDictionary5numLanguage();
        MyTranslateDictionaryCore supportDict = m5nDict;
        MyTranslateDictionaryCore usingDict = m4lDict;
        String actionNum = "";
        Scanner in = new Scanner(System.in);
        while (true){
            //System.out.println("\033[H\033[J");
            System.out.println("Команды для работы со словарём:");
            System.out.println("1. Сменить словарь. Сейчас используется - "+usingDict.getName());
            System.out.println("2. Добавить запись в словарь");
            System.out.println("3. Удалить запись из словаря по ключу");
            System.out.println("4. Найти запись по ключу");
            System.out.println("5. Вывести содержимое словарей");
            System.out.println("6. Сохранить значения в файл");
            System.out.println("7. Выйди из программы");
            if (usingDict instanceof MyDictionary4lettersLanguage)
            {
                System.out.println("Вы используете словарь из 4 символов.");
            }
            else if (usingDict instanceof MyDictionary5numLanguage)
            {
                System.out.println("Вы используете словарь из 5 символов.");
            }
            System.out.print("Введите номер желаемого действия: ");
            while(actionNum.equals("")){
                actionNum = in.nextLine();
            }
            switch (actionNum){
                case ("1"):{
                    MyTranslateDictionaryCore changer = usingDict;
                    usingDict = supportDict;
                    supportDict = changer;
                    break;
                }
                case ("2"):{
                    System.out.println("Введите слово: ");
                    String word = in.next();
                    System.out.println("Введите перевод: ");
                    String translation = in.next();
                    if (MyTranslateDictionaryCore.isCyrillic(translation)) {
                        usingDict.addWordAndTranslation(word, translation);
                    }
                    break;
                }
                case ("3"):{
                    System.out.println("Введите слово для удаления: ");
                    String word = in.next();
                    usingDict.removeByKey(word);
                    break;
                }
                case ("4"):{
                    System.out.println("Введите слово для поиска: ");
                    String word = in.next();
                    System.out.println("Найденное значение: "+usingDict.findByKey(word));
                    break;
                }
                case ("5"):{
                    usingDict.printAll();
                    supportDict.printAll();
                    break;
                }
                case ("6"):{
                    //MyTranslateDictionaryCore.clearFile();
                    usingDict.saveIntoFile();
                    supportDict.saveIntoFile();
                    break;
                }
                case ("7"):{
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
            actionNum="";
        }
    }
}

