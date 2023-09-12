package ru.alexi3rave;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize="1600x900";

    }
    @Test
    void fillFormTest() {
        open ("https://demoqa.com/automation-practice-form");

        System.out.println("Real size: " + WebDriverRunner.getWebDriver().manage().window().getSize());

        $("#firstName").setValue("Bad");
        $("#lastName").setValue("Boy");
        $("#userEmail").setValue("aaa@aa.aa");
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue("1234567890");
        setDateByName("16.09.2009");
        $("#currentAddress").setValue("shape str, 99");
                  }

    void setDateByName(String date) {
        executeJavaScript(String.format("$('[name=\"%s\"]').val('%s')",
                "#dateOfBirthInput", date));
    }
}