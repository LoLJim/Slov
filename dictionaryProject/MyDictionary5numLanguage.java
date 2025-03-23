package dictionaryProject;
import java.io.File;

public class MyDictionary5numLanguage extends MyTranslateDictionaryCore {

    MyDictionary5numLanguage(File file){
        patternForKey = "\\d{5}";
        openAndReadOrCreateFile(file);
        name = "Цифровой словарь";
    }
}
