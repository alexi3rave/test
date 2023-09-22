package ru.alexi3rave;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class PracticeFormTestsComments extends TestBase {


    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        sleep(3000);
        System.out.println("Real size: " + WebDriverRunner.getWebDriver().manage().window().getSize());

        //ввод в поле имя Bad
        $("#firstName").setValue("Bad");
        //ввод в поле фамилия Boy
        $("#lastName").setValue("Boy");
        //ввод в поле емейл aaa@aa.aa
        $("#userEmail").setValue("aaa@aa.aa");

        //Чекбокс пол, выбор пола "М"
        //$("#gender-radio-1").doubleClick();
        $("#genterWrapper").$(byText("Male")).click();
        //ввод в поле номер
        $("#userNumber").setValue("9764524345");
        //ввод в поле адресс shape str, 99
        $("#currentAddress").setValue("shape str, 99");
        //Загрузка картинки, через добавление файла в ресурс проекта
        new File("gradle/src/test/resources/test.png");
        $("#uploadPicture").uploadFromClasspath("test.png");
        //Выбор для ввода обьекта из перечня, выбираем "Артс" с предвыбором по вводу символов
        $("#subjectsInput").setValue("art").pressEnter();
        //+Выбор для ввода обьекта из перечня, выбираем ",biology" с предвыбором по вводу символов
        $("#subjectsInput").setValue("b").pressEnter();
        //выбор в выпадающем меню штата и города. Выбираем штат НЦР и город Нойда

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).scrollTo().click();

        actions().moveToElement($("#hobbies-checkbox-1")).click().perform();
        //+чекбокс хобби, выбор музыка
        actions().moveToElement($("#hobbies-checkbox-3")).click().perform();

        //установка даты в датапикер
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day.react-datepicker__day--003").click();

        $("#submit").click();
        //время на осмотр результата
        sleep(3000);

    }

}