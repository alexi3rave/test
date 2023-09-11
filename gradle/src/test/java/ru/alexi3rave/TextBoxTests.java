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
        $("#userEmail").setValue("aaa@aa.aa");
        $("#currentAddress").setValue("shape str, 99");
        $("#permanentAddress").setValue("gulp str, 99");
        $("#submit").scrollTo();
        $("#submit").click();

        $("#output").shouldHave(text("Bad name"), text("aaa@aa.aa"),
         text("shape str, 99"), text("gulp str, 99"));

    }
}
