package dictionaryProject;

// Объявление интерфейса IDictionary, который определяет методы для работы со словарем
interface IDictionary {

    // Метод для вывода всех пар "ключ-значение" в словаре
    void printAll();

    // Метод для добавления нового слова и его перевода
    void addWordAndTranslation(String wordKey, String translationWord);

    // Метод для удаления записи по ключу
    void removeByKey(String keyWord);

    // Метод для поиска перевода по ключу и возвращения его
    String findByKey(String wordKey);

    // Метод для сохранения текущего состояния словаря в файл
    void saveIntoFile();

}