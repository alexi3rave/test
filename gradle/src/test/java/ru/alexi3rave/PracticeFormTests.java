package ru.alexi3rave;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1600x900";

    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");

        System.out.println("Real size: " + WebDriverRunner.getWebDriver().manage().window().getSize());

        $("#firstName").setValue("Bad");
        $("#lastName").setValue("Boy");
        $("#userEmail").setValue("aaa@aa.aa");
        $("#gender-radio-1").doubleClick();
        $("#hobbies-checkbox-2").doubleClick();
        $("#userNumber").setValue("1234567890");
        setDateByName();
        $("#currentAddress").setValue("shape str, 99");
        new File("gradle/src/test/resources/test.png");
        $("#uploadPicture").uploadFromClasspath("test.png");

        sleep(5000);
    }

    void setDateByName() {
        executeJavaScript(
                String.format("$('[name=\"%s\"]').val('%s')",
                        $("#dateOfBirthInput"), "2007.07.06")
        );

            }

}