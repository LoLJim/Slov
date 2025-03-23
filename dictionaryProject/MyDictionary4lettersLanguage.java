package dictionaryProject;

public class MyDictionary4lettersLanguage extends MyTranslateDictionaryCore {

    MyDictionary4lettersLanguage(){
        patternForKey = "[a-zA-Z]{4}";
        openAndReadOrCreateFile();
        name = "Алглобуквенный словарь";
    }
}
