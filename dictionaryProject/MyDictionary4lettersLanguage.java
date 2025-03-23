package dictionaryProject;
import java.io.File;

public class MyDictionary4lettersLanguage extends MyTranslateDictionaryCore {

    MyDictionary4lettersLanguage(File file){
        patternForKey = "[a-zA-Z]{4}";
        openAndReadOrCreateFile(file);
        name = "Алглобуквенный словарь";
    }
}
