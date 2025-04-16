package dictionaryProject;

// Объявление интерфейса IDictionary, который определяет методы для работы со словарем
interface IDictionary {

    // Метод для вывода всех пар "ключ-значение" в словаре
    void printAll();

    // Метод для добавления слова и перевода в словарь
    void addWordAndTranslation(String wordKey, String translationWord);

    // Метод для вывода всех пар "ключ-значение" в словаре
    void removeByKey(String keyWord);

    // Метод для поиска перевода по ключу и возвращения его
    String findByKey(String wordKey);

    // Метод для сохранения текущего состояния словаря в файл
    void saveIntoFile(boolean f1);

}
