package subClasses;

public interface ConfigData {

        String GOOGLE_LINK = "https://www.google.com/";

        String SEARCH_FIELD = "//input[@title=\"Пошук\"]";

        String FIRST_PAGE = "//div[@role=\"navigation\" and @id=\"foot\"]//tr/td[2]";

        String RESULT_FIELD = "//a[@href=\"https://en.wikipedia.org/wiki/Bicycle\"]/h3";

        String RESULT_TEXT = "Bicycle - Wikipedia";

        String LAST_ELEMENT_OF_PAGE_LIST = "//div[@role=\"navigation\" and @id=\"foot\"]//tr/td[last()-1]";

        String RESULT_TEXT_SECOND = "Bicycle";

        String Text_FOR_THIRD_TEST = "Dragon";

}
