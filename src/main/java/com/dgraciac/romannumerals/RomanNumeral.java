package com.dgraciac.romannumerals;

public class RomanNumeral {
    private static final String ROMAN_ONE = "I";
    private static final String ROMAN_FIVE = "V";
    private static final String ROMAN_TEN = "X";
    private static final String ROMAN_FIFTY = "L";
    private static final String ROMAN_HUNDRED = "C";
    private static final String ROMAN_FIVE_HUNDRED = "D";
    private static final String ROMAN_THOUSAND = "M";

    private final StringBuilder stringBuilder;

    public RomanNumeral() {
        stringBuilder = new StringBuilder();
    }

    public String translateFromDecimal(int decimalNumber) {
        if (decimalNumber < 1000) translateFromDecimalLesserThan1000(decimalNumber);
        else if (decimalNumber < 2000) {
            stringBuilder.append(ROMAN_THOUSAND);
            if (decimalNumber > 1000) translateFromDecimalLesserThan1000(decimalNumber - 1000);
        } else if (decimalNumber < 3000) {
            stringBuilder.append(ROMAN_THOUSAND).append(ROMAN_THOUSAND);
            if (decimalNumber > 2000) translateFromDecimalLesserThan1000(decimalNumber - 2000);
        } else if (decimalNumber < 4000) {
            stringBuilder.append(ROMAN_THOUSAND).append(ROMAN_THOUSAND).append(ROMAN_THOUSAND);
            if (decimalNumber > 3000) translateFromDecimalLesserThan1000(decimalNumber - 3000);
        }
        return stringBuilder.toString();
    }

    private void translateFromDecimalLesserThan1000(int decimalNumber) {
        if (decimalNumber < 900) translateFromDecimalLesserThan900(decimalNumber);
        else if (decimalNumber < 1000) {
            stringBuilder.append(ROMAN_HUNDRED).append(ROMAN_THOUSAND);
            if (decimalNumber > 900) translateFromDecimalLesserThan900(decimalNumber - 900);
        }
    }

    private void translateFromDecimalLesserThan900(int decimalNumber) {
        if (decimalNumber < 400) translateFromDecimalLesserThan400(decimalNumber);
        else if (decimalNumber < 500) {
            stringBuilder.append(ROMAN_HUNDRED).append(ROMAN_FIVE_HUNDRED);
            if (decimalNumber > 400) translateFromDecimalLesserThan100(decimalNumber - 400);
        } else if (decimalNumber < 900) {
            stringBuilder.append(ROMAN_FIVE_HUNDRED);
            if (decimalNumber > 500) translateFromDecimalLesserThan400(decimalNumber - 500);
        }
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

    private void translateFromDecimalLesserThan40(int decimalNumber) {
        if (decimalNumber < 11) translateFromDecimalLesserThan11(decimalNumber);
        else if (decimalNumber < 21) {
            stringBuilder.append(ROMAN_TEN);
            translateFromDecimalLesserThan11(decimalNumber - 10);
        } else if (decimalNumber < 31) {
            stringBuilder.append(ROMAN_TEN).append(ROMAN_TEN);
            translateFromDecimalLesserThan11(decimalNumber - 20);
        } else if (decimalNumber < 40) {
            stringBuilder.append(ROMAN_TEN).append(ROMAN_TEN).append(ROMAN_TEN);
            translateFromDecimalLesserThan11(decimalNumber - 30);
        }
    }

    private void translateFromDecimalLesserThan100(int decimalNumber) {
        if (decimalNumber < 40) translateFromDecimalLesserThan40(decimalNumber);
        else if (decimalNumber < 41) stringBuilder.append(ROMAN_TEN).append(ROMAN_FIFTY);
        else if (decimalNumber < 50) {
            stringBuilder.append(ROMAN_TEN).append(ROMAN_FIFTY);
            translateFromDecimalLesserThan11(decimalNumber - 40);
        } else if (decimalNumber < 90) {
            stringBuilder.append(ROMAN_FIFTY);
            if (decimalNumber > 50) translateFromDecimalLesserThan40(decimalNumber - 50);
        } else if (decimalNumber < 100) {
            stringBuilder.append(ROMAN_TEN).append(ROMAN_HUNDRED);
            if (decimalNumber > 90) translateFromDecimalLesserThan11(decimalNumber - 90);
        }
    }

    private void translateFromDecimalLesserThan400(int decimalNumber) {
        if (decimalNumber < 100) translateFromDecimalLesserThan100(decimalNumber);
        else if (decimalNumber < 200) {
            stringBuilder.append(ROMAN_HUNDRED);
            if (decimalNumber > 100) translateFromDecimalLesserThan100(decimalNumber - 100);
        } else if (decimalNumber < 300) {
            stringBuilder.append(ROMAN_HUNDRED).append(ROMAN_HUNDRED);
            if (decimalNumber > 200) translateFromDecimalLesserThan100(decimalNumber - 200);
        } else if (decimalNumber < 400) {
            stringBuilder.append(ROMAN_HUNDRED).append(ROMAN_HUNDRED).append(ROMAN_HUNDRED);
            if (decimalNumber > 300) translateFromDecimalLesserThan100(decimalNumber - 300);
        }
    }
}
