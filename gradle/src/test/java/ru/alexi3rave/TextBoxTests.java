package ru.alexi3rave;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize="1366x768";

    }
    @Test
     void fillFormTest() {
        open ("https://demoqa.com/text-box");

        System.out.println("Real size: " + WebDriverRunner.getWebDriver().manage().window().getSize());

        $("#userName").setValue("Bad name");
        $("#userEmail").setValue("Some@mail.com");
        $("#currentAddress").setValue("shape str, 99");
        $("#permanentAddress").setValue("gulp str, 99");
        $("#submit").scrollTo();
        $("#submit").click();

        $("#output #name").shouldHave(text("Bad name"));
        $("#userEmail").shouldHave(text("Some@mail.com"));
        $("#currentAddress").shouldHave(text("shape str, 99"));
        $("#permanentAddress").shouldHave(text("gulp str, 99"));

        $("#output").shouldHave(text("Bad name"), text("Some@mail.com"),
                text("shape str, 99"), text("gulp str, 99"));
    }
}
