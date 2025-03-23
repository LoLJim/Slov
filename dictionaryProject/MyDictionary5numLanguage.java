package dictionaryProject;

public class MyDictionary5numLanguage extends MyTranslateDictionaryCore {

    MyDictionary5numLanguage(){
        patternForKey = "\\d{5}";
        openAndReadOrCreateFile();
        name = "Цифровой словарь";
    }
}
