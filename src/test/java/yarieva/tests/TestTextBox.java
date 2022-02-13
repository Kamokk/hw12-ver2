package yarieva.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestTextBox extends TestBase {


    @Test
    void fillTextBox() {
        Faker faker = new Faker(new Locale("en"));
        String userName = faker.name().firstName();
        String userEmail = faker.internet().emailAddress();
        String currentAddress = faker.address().streetAddress();
        String permanentAddress = faker.address().streetAddress();

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу", () ->
                open("https://demoqa.com/text-box"));
        step("Заполняем поле Full Name", () ->
                $("#userName").setValue(userName));
        step("Заполняем поле Email", () ->
                $("#userEmail").setValue(userEmail));
        step("Заполняем поле Current Address", () ->
                $("#currentAddress").setValue(currentAddress));
        step("Заполняем поле Permanent Address", () ->
                $("#permanentAddress").setValue(permanentAddress));
        step("Отправляем значения на форму", () ->
                $("#submit").click());
        step("Проверяем отправленное значение для UserName", () ->
                $("#name").shouldHave(Condition.text(userName)));

        step("Проверяем отправленное значение для userEmail", () ->
                $("#email").shouldHave(Condition.text(userEmail)));

        step("Проверяем отправленное значение для currentAddress", () ->
                $("#output").$("#currentAddress").shouldHave(Condition.text(currentAddress)));

        step("Проверяем отправленное значение для permanentAddress", () ->
                $("#output").$("#permanentAddress").shouldHave(Condition.text(permanentAddress)));



    }
}