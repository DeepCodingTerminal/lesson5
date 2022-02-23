package tatisosh.com.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestForTheForthLesson {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void shouldHaveJUnitCodeInSoftAssertions() {

        // Пререйти по URL https://github.com/selenide/selenide
        open("https://github.com/selenide/selenide");
        // Кликнуть по вкладке Wiki
        $("#wiki-tab").click();
        // Проверить, что в списке страниц (Pages) есть страница SoftAssertions
        $("#repo-content-pjax-container").shouldHave(Condition.text("Soft assertions"));
        //Кликнуть на ссылку Soft assertions
        $(".Layout-main").$(withText("Soft assertions")).click();
        // Проверить, что на странице есть пример кода для JUnit5
        $("#wiki-wrapper").shouldHave(Condition.text("Using JUnit5 extend test class:"));
    }

    @Test
    void dragAndDrop() {
        // Перейти по URL https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //перенести с места на место прямоугольники А и В
        $("#column-a").dragAndDropTo($("#column-b"));
        // проверить, что прямоугольники корректно перенесены
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }
}
