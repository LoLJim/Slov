package dictionaryProject;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class MyTranslateDictionaryCore implements IDictionary {
    HashMap<String, String> dictKeyWord = new HashMap<>();; // Словарь
    File file; // Объект File, указывающий на файл словаря
    String patternForKey = "";  // Регулярное выражение для проверки ключей словаря
    String name = ""; // Имя словаря
    static boolean appendSavingFile = false; // Флаг для указания, нужно ли добавлять данные в конец файла

    // Метод для установки пути к файлу
    public File setFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу словаря: ");
        String filePath = scanner.nextLine();
        file = new File(filePath);
        return file;
    }

    protected void openAndReadOrCreateFile(File file){
        // Создание или открытие файла
        try {
            this.file = file;
            if (file.createNewFile()) // Если файл не существует, создаем его
                System.out.println("Файл словаря создан");
            else{ // Если файл уже существует
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                boolean keyFounded = false; // Флаг для отслеживания, найден ли ключ

                String line = reader.readLine();
                while (line != null) {
                    char[] lineArray = line.toCharArray();
                    String key =""; // Переменная для хранения ключа
                    String word = ""; // Переменная для хранения перевода
                    for (char ch:lineArray) {
                        if (!keyFounded){
                            if (ch!='\t'){
                                key+=ch;
                            }
                            else{
                                keyFounded=true;
                            }
                        }
                        else{
                            word+=ch;
                        }
                    }
                    if (key.matches(patternForKey)){
                        dictKeyWord.put(key, word);
                    }
                    keyFounded = false;
                    line = reader.readLine();
                }
                System.out.println("Файл открыт и загружен");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Метод для вывода всех пар "ключ-значение" в словаре
    public void printAll(){
        for (HashMap.Entry entry: dictKeyWord.entrySet()) {
            System.out.println(entry);
        }
    }

    // Метод для добавления нового слова и его перевода
    public void addWordAndTranslation(String wordKey, String translationWord) {
        if (wordKey.matches(patternForKey)){
            dictKeyWord.put(wordKey, translationWord);
        }
    }

    // Метод для поиска перевода по ключу
    public String findByKey(String keyWord) {
        return dictKeyWord.get(keyWord);
    }

    // Метод для удаления записи по ключу
    public void removeByKey(String keyWord) {
        dictKeyWord.remove(keyWord);
    }

    // Метод для сохранения словаря в файл
    public void saveIntoFile() {
        try(FileWriter writer = new FileWriter(file, appendSavingFile))
        {
            // Перебор всех записей в словаре
            for (HashMap.Entry entry: dictKeyWord.entrySet()) {
                String keyForSave = entry.getKey().toString(); // Получение ключа для сохранения
                String translationForSave = entry.getValue().toString(); // Получение перевода для сохранения
                String strForSave = keyForSave +'\t'+translationForSave+"\r\n"; // Формирование строки для записи
                writer.write(strForSave); // Запись строки в файл
            }
            appendSavingFile=!appendSavingFile;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    // Метод для получения имени словаря
    public String getName(){
        return name;
    }

    // Метод для проверки, состоит ли строка только из русских символов
    public static boolean isCyrillic(String str) {
        return str.matches("[а-яА-Я]+");
    }
}
