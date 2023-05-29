package arraysnacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardNumberValidatorTest {
    CreditCardValidator creditCardValidator;

    @Test public void creditCardNumberValidatorExistTest(){
        creditCardValidator = new CreditCardValidator("4388576018402626");
        assertNotNull(creditCardValidator);
    }

    @Test public void calculateCreditCardNumberLengthTest(){
        creditCardValidator = new CreditCardValidator("4388576018402626");

        creditCardValidator.populateArrayWithCreditCardNumbers();

        assertEquals(16, creditCardValidator.getCreditCardDigitLength());
    }

    @Test public void VisaCardNumberTest(){
        creditCardValidator = new CreditCardValidator("4388576018402626");
        creditCardValidator.populateArrayWithCreditCardNumbers();

        creditCardValidator.validateCreditCardType();

        assertEquals("Visa Card", creditCardValidator.tellCardType());
    }

    @Test public void AMasterCardNumberTest(){
        creditCardValidator = new CreditCardValidator("5388576018402626");
        creditCardValidator.populateArrayWithCreditCardNumbers();

        creditCardValidator.validateCreditCardType();

        assertEquals("Master Card", creditCardValidator.tellCardType());
    }

    @Test public void AmericanExpressCardNumberTest(){
        creditCardValidator = new CreditCardValidator("3788576018402626");
        creditCardValidator.populateArrayWithCreditCardNumbers();

        creditCardValidator.validateCreditCardType();

        assertEquals("American Express Card", creditCardValidator.tellCardType());
    }

    @Test public void DiscoveryCardNumberTest(){
        creditCardValidator = new CreditCardValidator("678857601840226");
        creditCardValidator.populateArrayWithCreditCardNumbers();

        creditCardValidator.validateCreditCardType();

        assertEquals("Discover Card", creditCardValidator.tellCardType());
    }

    @Test public void notAValidCardNumberTest(){
        creditCardValidator = new CreditCardValidator("0788576018402626");
        creditCardValidator.populateArrayWithCreditCardNumbers();

        creditCardValidator.validateCreditCardType();

        assertEquals("Invalid Card", creditCardValidator.tellCardType());
    }

    @Test public void noAlphabetsInCreditCardNumberTest(){
        creditCardValidator = new CreditCardValidator("67888576018402626");

        creditCardValidator.validateCreditCardType();

        assertTrue(creditCardValidator.isCreditCardNumberAllNumericDigits());
    }

    @Test public void creditCardNumberIsForAValidCardType_ButHasAlphabetTest(){
        creditCardValidator = new CreditCardValidator("678857A01840226");

        creditCardValidator.validateCreditCardType();

        assertEquals("Invalid Card", creditCardValidator.tellCardType());
    }
    @Test public void sumDoubledSecondDigitsFromLeftToRight_IfDoubledDigitResultToTwoDigitNumber_AddNumbersSingleDigitsToGerASingleDigitTest(){
        creditCardValidator = new CreditCardValidator("4388576018402626");
        creditCardValidator.validateCreditCardType();

        creditCardValidator.populateArrayWithCreditCardNumbers();

        assertEquals("Invalid", creditCardValidator.getCreditCardStatus());
    }
}
