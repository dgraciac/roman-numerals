package com.dgraciac.romannumerals;

public class RomanNumeral {
    private static final String ROMAN_ONE = "I";
    private static final String ROMAN_FIVE = "V";
    private static final String ROMAN_TEN = "X";
    private static final String ROMAN_FIFTY = "L";
    private final StringBuilder stringBuilder;

    public RomanNumeral() {
        stringBuilder = new StringBuilder();
    }

    public String translateFromDecimal(int decimalNumber) {
        if (decimalNumber < 11) translateFromDecimalLesserThan11(decimalNumber);
        else if (decimalNumber < 21) {
            stringBuilder.append(ROMAN_TEN);
            translateFromDecimalLesserThan11(decimalNumber - 10);
        } else if (decimalNumber < 31) {
            stringBuilder.append(ROMAN_TEN).append(ROMAN_TEN);
            translateFromDecimalLesserThan11(decimalNumber - 20);
        } else if (decimalNumber < 41) {
            stringBuilder.append(ROMAN_TEN);
            if (decimalNumber < 40) {
                stringBuilder.append(ROMAN_TEN).append(ROMAN_TEN);
                translateFromDecimalLesserThan11(decimalNumber - 30);
            } else stringBuilder.append(ROMAN_FIFTY);
        } else if(decimalNumber < 50){
            stringBuilder.append(ROMAN_TEN).append(ROMAN_FIFTY);
            translateFromDecimalLesserThan11(decimalNumber - 40);
        } else stringBuilder.append(ROMAN_FIFTY);
        return stringBuilder.toString();
    }

    private void translateFromDecimalLesserThan11(int decimalNumber) {
        if (decimalNumber <= 4) {
            stringBuilder.append(ROMAN_ONE);
            if (decimalNumber < 4) for (int i = 1; i < decimalNumber; i++) stringBuilder.append(ROMAN_ONE);
            else stringBuilder.append(ROMAN_FIVE);
        } else if (decimalNumber < 9) {
            stringBuilder.append(ROMAN_FIVE);
            if (decimalNumber > 5) for (int i = 0; i < decimalNumber - 5; i++) stringBuilder.append(ROMAN_ONE);
        } else if (decimalNumber <= 10) {
            if (decimalNumber == 9) stringBuilder.append(ROMAN_ONE);
            stringBuilder.append(ROMAN_TEN);
        }
    }
}
