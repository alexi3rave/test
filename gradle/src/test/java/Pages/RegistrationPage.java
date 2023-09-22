package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    //locators & elements
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable = $(".table-responsive");

    //actions
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(Condition.text("Student Registration Form"));

    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
    return this;
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }
    public RegistrationPage checkResultsValue (String key, String value) {
        resultsTable.shouldHave(Condition.text(value));
    return this;
    }
}
