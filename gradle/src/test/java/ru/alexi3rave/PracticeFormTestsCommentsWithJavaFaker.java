package ru.alexi3rave;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static ru.alexi3rave.TestData.email;

public class PracticeFormTestsCommentsWithJavaFaker extends TestBase {

    //Faker faker = new Faker();
    Faker faker = new Faker(new Locale("RU"));
String firstName = faker.name().firstName();
String lastName = faker.name().lastName();
String streetAddress = faker.address().streetAddress();

    @Test
    void fillFormTest() {
        registrationPage.openPage();
        sleep(3000);
        System.out.println("Real size: " + WebDriverRunner.getWebDriver().manage().window().getSize());

        //ввод в поле имя Bad
        $("#firstName").setValue(firstName);
        //ввод в поле фамилия Boy
        $("#lastName").setValue(lastName);

                //ввод в поле емейл aaa@aa.aa
        $("#userEmail").setValue(email);

        //Чекбокс пол, выбор пола "М"
        //$("#gender-radio-1").doubleClick();
        $("#genterWrapper").$(byText("Male")).click();
        //ввод в поле номер
        $("#userNumber").setValue("9764524345");
        //ввод в поле адресс shape str, 99
        $("#currentAddress").setValue(streetAddress);
        //Загрузка картинки, через добавление файла в ресурс проекта
        new File("gradle/src/test/resources/test.png");
        $("#uploadPicture").uploadFromClasspath("test.png");
        //Выбор для ввода обьекта из перечня, выбираем "Артс" с предвыбором по вводу символов
        $("#subjectsInput").setValue("art").pressEnter();
        //+Выбор для ввода обьекта из перечня, выбираем ",biology" с предвыбором по вводу символов
        $("#subjectsInput").setValue("b").pressEnter();
        //установка даты в датапикер
        registrationPage.calendar.setDate("030", "July", "2001");
        /*
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day.react-datepicker__day--003").click();
          */
                //выбор в выпадающем меню штата и города. Выбираем штат НЦР и город Нойда
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).scrollTo().click();
        //чекбокс хобби, выбор
        actions().moveToElement($("#hobbies-checkbox-1")).click().perform();
        //+чекбокс хобби, выбор музыка
        actions().moveToElement($("#hobbies-checkbox-3")).click().perform();

        $("#submit").click();
        //время на осмотр результата
        registrationPage.checkResultsValue("Student Name", firstName + " "+ lastName)
                        .checkResultsValue("Email", email);
        $(".table-responsive").shouldHave(Condition.text(streetAddress));

        sleep(5000);

    }

}