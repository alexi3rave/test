package ru.alexi3rave;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase {


    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        sleep(3000);
        System.out.println("Real size: " + WebDriverRunner.getWebDriver().manage().window().getSize());

        $("#firstName").setValue("Bad");
        $("#lastName").setValue("Boy");
        $("#userEmail").setValue("aaa@aa.aa");


        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue("9764524345");
        $("#currentAddress").setValue("shape str, 99");
        new File("gradle/src/test/resources/test.png");
        $("#uploadPicture").uploadFromClasspath("test.png");
        $("#subjectsInput").setValue("art").pressEnter();
        $("#subjectsInput").setValue("b").pressEnter();
        actions().moveToElement($("#state")).click().moveByOffset(0,5).click().perform();
        actions().moveToElement($("#city")).click().moveByOffset(0,5).click().perform();
        actions().moveToElement($("#hobbies-checkbox-1")).click().perform();
         actions().moveToElement($("#hobbies-checkbox-3")).click().perform();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $("#submit").click();
        sleep(3000);

    }

    void setDateByName() {
        executeJavaScript(
                String.format("$('[name=\"%s\"]').val('%s')",
                        $("#dateOfBirthInput"), "2007.05.13")
        );

            }

}