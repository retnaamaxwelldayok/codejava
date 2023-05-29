package arraysnacks;

public class CreditCardValidator {

    private int[] digitsArrayOfCreditCardNumber;
    private int creditCardNumberLength;
    private String creditCardNumber;
    private boolean isCreditCardNumberAllNumericDigits = true;
    private String cardType;

    public CreditCardValidator(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
        creditCardNumberLength = creditCardNumber.length();
        digitsArrayOfCreditCardNumber = new int[creditCardNumberLength];
    }

    public int getCreditCardDigitLength() {
        return digitsArrayOfCreditCardNumber.length;
    }

    public void populateArrayWithCreditCardNumbers() {
        if (isCreditCardNumberAllNumericDigits())
            for (int index = 0; index < creditCardNumberLength; index++){
                digitsArrayOfCreditCardNumber[index] = Character.getNumericValue(creditCardNumber.charAt(index));
            }
    }

    public void validateCreditCardType() {
        validateIfVisaCard();
        validateIfMasterCard();
        validateIfAmericanExpressCard();
        validateIfDiscoveryCard();
        validateIfAnInvalidCard();
        validateCreditCardNumberHasNoLetter();
    }

    private void validateIfAnInvalidCard() {
        boolean isAnInValidCard = !((digitsArrayOfCreditCardNumber[0] == 6 ||
                (digitsArrayOfCreditCardNumber[0] == 3 && digitsArrayOfCreditCardNumber[1] == 7) ||
                digitsArrayOfCreditCardNumber[0] == 5 || digitsArrayOfCreditCardNumber[0] == 4));
        if (isAnInValidCard) cardType = "Invalid Card";
    }

    private void validateIfDiscoveryCard() {
        boolean isDiscoverCard = digitsArrayOfCreditCardNumber[0] == 6;
        if (isDiscoverCard) cardType = "Discover Card";
    }

    private void validateIfAmericanExpressCard() {
        boolean isAmericanExpressCard = digitsArrayOfCreditCardNumber[0] == 3 &&
                digitsArrayOfCreditCardNumber[1] == 7;
        if (isAmericanExpressCard) cardType = "American Express Card";
    }

    private void validateIfMasterCard() {
        boolean isMasterCard = digitsArrayOfCreditCardNumber[0] == 5;
        if (isMasterCard) cardType = "Master Card";
    }

    private void validateIfVisaCard() {
        boolean isVisaCard = digitsArrayOfCreditCardNumber[0] == 4;
        if (isVisaCard) cardType = "Visa Card";
    }

    private void validateCreditCardNumberHasNoLetter() {
        boolean isAnAlphabet;
        for ( int index = 0; index < creditCardNumber.length(); index++) {
            isAnAlphabet = !(Character.isDigit(creditCardNumber.charAt(index)));
            if (isAnAlphabet) {
                cardType = "Invalid Card";
                isCreditCardNumberAllNumericDigits = false;
                break;
            }
        }
    }

    public String tellCardType() {
        return cardType;
    }

    public boolean isCreditCardNumberAllNumericDigits() {
        return isCreditCardNumberAllNumericDigits;
    }

    public String getCreditCardStatus() {
        return null;
    }
}
