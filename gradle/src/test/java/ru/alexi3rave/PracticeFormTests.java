package ru.alexi3rave;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1299x739";

    }

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
        $("#gender-radio-1").doubleClick();
        //$("#genterWrapper").$(byText("Male")).click(); не работает


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
        //выбор в выпадающем меню штата и города. Выбираем штат НЦР и город Дели
        //Офсет по Y (-50) - 1 штат, (-10) - 2 штат, (0) 3 штат, (50) - 4 штат
        actions().moveToElement($("#state")).click().moveByOffset(0, -50).click().perform();
        //Офсет по Y (-25) - 1 город, (0) - 2 город, (50) 3 город
        actions().moveToElement($("#city")).click().moveByOffset(0,50).click().perform();
        //чекбокс хобби, выбор спорт
        actions().moveToElement($("#hobbies-checkbox-1")).click().perform();
        //+чекбокс хобби, выбор музыка
        actions().moveToElement($("#hobbies-checkbox-3")).click().perform();

        //установка даты в датапикер
        //setDateByName(); не работает
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        //$(".react-datepicker__day react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        //$(".react-datepicker__day react-datepicker__day--014").click();

        //actions().moveToElement($("#submit")).click().perform();
        $("#submit").click();
        //время на осмотр результата
        sleep(3000);

    }

    void setDateByName() {
        executeJavaScript(
                String.format("$('[name=\"%s\"]').val('%s')",
                        $("#dateOfBirthInput"), "2007.05.13")
        );

            }

}