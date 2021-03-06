package kz.TELE2.pages;

import kz.TELE2.Base;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

public class NumberPortingPageTest extends Base {

    @Test
    //определение оператора по номеру
    public void yourOperatorAltel() {
        anyPage.clickNumberPortingPage();
        String textPage = numberPortingPage.textNumberPorting();
        Assert.assertEquals("Перенос номера", textPage);
        numberPortingPage
                .clickButtonBlockDefintionOperatorCodeNumber()
                .choiseBlockOperatorDefintionCodePhoneNumber("1")
                .inputDefintionPhoneNumberField("1231231")
                .clickDefintionButton();
        String text = numberPortingPage.errorDefintionPhoneNumber();
        Assert.assertEquals("Ваш оператор Altel", text);
        System.out.println("TEST yourOperatorAltel: Pass");
    }

    @Test
    //определение оператора по номеру
    public void alert_Unable_to_find_information_on_this_number() {
        anyPage.clickNumberPortingPage();
        String textPage = numberPortingPage.textNumberPorting();
        Assert.assertEquals("Перенос номера", textPage);
        numberPortingPage
                .clickButtonBlockDefintionOperatorCodeNumber()
                .choiseBlockOperatorDefintionCodePhoneNumber("2")
                .inputDefintionPhoneNumberField("1231231")
                .clickDefintionButton();
        String text = numberPortingPage.errorDefintionPhoneNumber();
        Assert.assertEquals("Не удалось найти информацию по данному номеру", text);
        System.out.println("TEST alert_Unable_to_find_information_on_this_number: Pass");
    }

    @Test
    //определение оператора по номеру
    public void yourOperatorTele2() {
        anyPage.clickNumberPortingPage();
        String textPage = numberPortingPage.textNumberPorting();
        Assert.assertEquals("Перенос номера", textPage);
        numberPortingPage
                .clickButtonBlockDefintionOperatorCodeNumber()
                .choiseBlockOperatorDefintionCodePhoneNumber("5")
                .inputDefintionPhoneNumberField("1231231")
                .clickDefintionButton();
        String text = numberPortingPage.errorDefintionPhoneNumber();
        Assert.assertEquals("Ваш оператор Tele2", text);
        System.out.println("TEST yourOperatorTele2: Pass");
    }

    @Test
    //Предварительная заявка на перенос номера успешно принята (Позитивный тест)
    public void applicationAcceptedPositive() {
        anyPage.clickNumberPortingPage();
        String textPage = numberPortingPage.textNumberPorting();
        Assert.assertEquals("Перенос номера", textPage);
        numberPortingPage
                .scrollOnFormNumberPorting()
                .inputPhoneNumber("7778899")
                .clickBlockPhoneCodeNumber()
                .choiceBlockOperatorCodePhoneNumber("1");
        numberPortingPage
                .clickBlockButtonCityKaz()
                .choiseBlockCityKaz("3");
        numberPortingPage
                .inputFirstName("Alex")
                .inputLastname("Cross")
                .inputMiddleName("Franckovich")
                .inputContactPhone("0634447777")
                .inputEmail("ii@ll.com")
                .selectCheckBox();
        numberPortingPage.clickSaidButton();
        String forma = numberPortingPage.formOnPortingPage();
        Assert.assertEquals("Спасибо!\n" +
                "Предварительная заявка на перенос номера успешно принята! " +
                "Для завершения процесса необходимо подписать оригинал заявления в офисах продаж TELE2.", forma);
        numberPortingPage.clickCloseAlert();
        System.out.println("TEST applicationAcceptedPositive: Pass");

    }

    @Test
    //номер пренадлежит абоненту ТЕЛЕ2
    public void the_specified_number_is_already_owned_by_the_subscriberst() {
        anyPage.clickNumberPortingPage();
        String textPage = numberPortingPage.textNumberPorting();
        Assert.assertEquals("Перенос номера", textPage);
        numberPortingPage
                .scrollOnFormNumberPorting()
                .inputPhoneNumber("7778899")
                .clickBlockPhoneCodeNumber()
                .choiceBlockOperatorCodePhoneNumber("5");
        numberPortingPage
                .clickBlockButtonCityKaz()
                .choiseBlockCityKaz("3");
        numberPortingPage
                .inputFirstName("Alex")
                .inputLastname("Cross")
                .inputMiddleName("Vasilievich")
                .inputContactPhone("0634447777")
                .inputEmail("ii@ll.com")
                .selectCheckBox();
        numberPortingPage.clickSaidButton();
        String forma = numberPortingPage.formOnPortingPage();
        Assert.assertEquals("Ошибка!\n" +
                "Указанный номер уже принадлежит абоненту Tele2", forma);
        numberPortingPage.clickCloseAlert();
        System.out.println("TEST the_specified_number_is_already_owned_by_the_subscriberst: Pass");
    }

    @Test
    //некорректный номер телефона
    public void wrongPhoneNumber() {
        anyPage.clickNumberPortingPage();
        numberPortingPage
                .scrollOnFormNumberPorting()
                .inputPhoneNumber("333")
                .clickBlockPhoneCodeNumber()
                .choiceBlockOperatorCodePhoneNumber("3");
        String alert = numberPortingPage.errorPhoneNumberEnteredIsNotCorrect();
        Assert.assertEquals("Номер телефона введен не корректно", alert);
        System.out.println("TEST wrongPhoneNumber: Pass");
    }

    @Test
    //пустое поле номера телефона
    public void emptyPhoneNumber() {
        anyPage.clickNumberPortingPage();
        numberPortingPage
                .scrollOnFormNumberPorting()
                .inputPhoneNumber("7778899")
                .clearallPhoneNumberField()
                .clickBlockPhoneCodeNumber();
        String alert = numberPortingPage.errorFieldMustNotBeEmpty();
        Assert.assertEquals("Поле не должно быть пустым", alert);
        System.out.println("TEST emptyPhoneNumber: Pass");
    }

    @Test
    //пустое поле "Имя"
    public void emptyFirstNameField() {
        anyPage.clickNumberPortingPage();
        numberPortingPage
                .inputFirstName("Alex")
                .clearAllFirstNameField()
                .inputLastname("");
        String alert = numberPortingPage.errorFieldMustNotBeEmpty();
        Assert.assertEquals("Поле не должно быть пустым", alert);
        System.out.println("TEST emptyFirstNameField: Pass");
    }

    @Test
    //пустое поле "Фамилия"
    public void emptyLastNameField() {
        anyPage.clickNumberPortingPage();
        numberPortingPage
                .inputLastname("Tele")
                .clearAllLastNameField()
                .inputFirstName("");
        String alert = numberPortingPage.errorFieldMustNotBeEmpty();
        Assert.assertEquals("Поле не должно быть пустым", alert);
        System.out.println("TEST emptyLastNameField: Pass");
    }

    @Test
    //пустое поле email
    public void emptyEmailField() {
        anyPage.clickNumberPortingPage();
        numberPortingPage
                .inputEmail("alexTele@gmail.com")
                .clearAllEmailField()
                .inputContactPhone("7076427723");
        String alert = numberPortingPage.errorFieldMustNotBeEmpty();
        Assert.assertEquals("Поле не должно быть пустым", alert);
        System.out.println("TEST emptyEmailField: Pass");
    }

    @Test
    //пустое поле email
    public void inCorrectEmailField() {
        anyPage.clickNumberPortingPage();
        numberPortingPage
                .inputEmail("alexTele@")
                .inputContactPhone("7076427723");
        String alert = numberPortingPage.errorEnterValidEmailAdress();
        Assert.assertEquals("Введите корректный email", alert);
        System.out.println("TEST inCorrectEmailField: Pass");
    }
}
