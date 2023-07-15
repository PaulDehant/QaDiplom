package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import data.DataHelper;
import data.DataHelperSQL;
import page.PaymentPage;
import page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static data.DataHelperSQL.cleanDataBase;

public class PaymentPageTest {
    PaymentPage paymentPage = new PaymentPage();
    StartPage startPage = new StartPage();

    @BeforeEach
    void CleanDataBaseAndOpenWeb() {
        cleanDataBase();
        startPage = open("http://localhost:8080", StartPage.class);
        startPage.buyPaymentByCard();
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Description

    @Test
    void shouldApproveFirstCard() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutSuccessfulPayment();
        val expected = DataHelper.getStatusFirstCard();
        val actual = DataHelperSQL.getPurchaseByDebitCard();
        assertEquals(expected, actual);
    }

    @Description

    @Test
    void shouldApproveOwnerNameWithLetter() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getLetter();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutSuccessfulPayment();
        val expected = DataHelper.getStatusFirstCard();
        val actual = DataHelperSQL.getPurchaseByDebitCard();
        assertEquals(expected, actual);
    }

    @Description

    @Test
    void shouldApproveDoubleNameOfOwner() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getDoubleNameOfOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutSuccessfulPayment();
        val expected = DataHelper.getStatusFirstCard();
        val actual = DataHelperSQL.getPurchaseByDebitCard();
        assertEquals(expected, actual);
    }

    @Description

    @Test
    void shouldApproveSecondCard() {
        val cardNumber = DataHelper.getSecondCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutUnsuccessfulPaymentRefused();
        val expected = DataHelper.getStatusSecondCard();
        val actual = DataHelperSQL.getPurchaseByDebitCard();
        assertEquals(expected, actual);
    }

    @Description

    @Test
    void shouldLessThan16DigitsInCard() {
        val cardNumber = DataHelper.getLessThan16DigitsInCard();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutIncorrectDataFormat();
    }

    @Description

    @Test
    void shouldMoreThan16DigitsInCard() {
        val cardNumber = DataHelper.getMoreThan16DigitsInCard();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutIncorrectDataFormat();
    }

    @Description

    @Test
    void should16ZerosInCard() {
        val cardNumber = DataHelper.get16ZerosInCard();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutUnsuccessfulPaymentRefused();
    }

    @Description

    @Test
    void shouldLettersSymbolsTextInCard() {
        val cardNumber = DataHelper.getSymbolsText();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutIncorrectDataFormat();
    }

    @Description

    @Test
    void shouldEmptyFieldInCard() {
        val cardNumber = DataHelper.getEmptyFieldInCard();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutIncorrectDataFormat();
    }

    @Description

    @Test
    void shouldLettersSymbolsTextInMonth() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getSymbolsTextInMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutIncorrectDataFormat();
    }

    @Description

    @Test
    void shouldMonthNumberMore12() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getMonthNumberMore12();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutIncorrectCardExpirationDate();
    }

    @Description

    @Test
    void shouldMonthFieldEmpty() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getMonthFieldEmpty();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutIncorrectDataFormat();
    }

    @Description

    @Test
    void shouldYearFieldPrevious() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getYearFieldPrevious();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutCardExpiration();
    }

    @Description

    @Test
    void shouldYearMoreThan6YearsOfTheCurrentYear() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getMoreThan6YearsOfTheCurrentYear();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutIncorrectCardExpirationDate();
    }

    @Description

    @Test
    void shouldYearZero() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getYearZero();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutCardExpiration();
    }

    @Description

    @Test
    void shouldLettersSymbolsTextInYear() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getSymbolsTextInYear();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutIncorrectDataFormat();
    }

    @Description

    @Test
    void shouldYearFieldEmpty() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getYearFieldEmpty();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutIncorrectDataFormat();
    }

    @Description

    @Test
    void shouldOnlyNameOwner() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getOnNameOwnerOnly();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutSuccessfulPayment();
    }


    @Description

    @Test
    void shouldLettersSymbolsTextInOwner() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getSymbolsTextInOwner();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutSuccessfulPayment();
    }

    @Description

    @Test
    void shouldOwnerFieldEmpty() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getOwnerFieldEmpty();
        val cvc = DataHelper.getValidCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutTheMandatoryFillingInOfTheField();
    }

    @Description

    @Test
    void shouldCvcZero() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getCvcZero();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutSuccessfulPayment();
    }

    @Description

    @Test
    void shouldLettersSymbolsTextInCvc() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getSymbolsTextInCvc();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutIncorrectDataFormat();
    }

    @Description

    @Test
    void shouldEmptyFieldInCvc() {
        val cardNumber = DataHelper.getFirstCardNumber();
        val month = DataHelper.getValidMonth();
        val year = DataHelper.getValidYear();
        val owner = DataHelper.getValidOwner();
        val cvc = DataHelper.getCvcFieldEmpty();
        paymentPage.fillOutLine(cardNumber, month, year, owner, cvc);
        paymentPage.messageAboutIncorrectDataFormat();
    }
}