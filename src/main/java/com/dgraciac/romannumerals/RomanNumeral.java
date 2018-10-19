package com.dgraciac.romannumerals;

public class RomanNumeral {
    public String translateFromDecimal(int decimalNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        if (decimalNumber % 1000 == 0) {
            return translateDecimalDivisibleBy1000(decimalNumber, stringBuilder);
        }

        if (decimalNumber % 500 == 0) {
            return translateDecimalDivisibleBy500(decimalNumber, stringBuilder);
        }

        if(decimalNumber % 100 == 0) {
            int hundreds = decimalNumber / 100;
            if(hundreds < 4) {
                for (int i = 0; i < hundreds; i++) stringBuilder.append("C");
                return stringBuilder.toString();
            }

            if(hundreds > 5 && hundreds < 9) {
                stringBuilder.append('D');
                for (int i = 5; i < hundreds; i++) stringBuilder.append('C');
                return stringBuilder.toString();
            }
            if (decimalNumber == 400) return "CD";
            if (decimalNumber == 900) return "CM";
            if (decimalNumber == 1100) return "MC";
        }

        if (decimalNumber == 1) return "I";
        if (decimalNumber == 10) return "X";


        if (decimalNumber == 2) return "II";
        if (decimalNumber == 20) return "XX";


        if (decimalNumber == 4) return "IV";
        if (decimalNumber == 40) return "XL";

        if (decimalNumber == 5) return "V";
        if (decimalNumber == 50) return "L";

        if (decimalNumber == 6) return "VI";
        if (decimalNumber == 60) return "LX";

        if (decimalNumber == 7) return "VII";
        if (decimalNumber == 70) return "LXX";

        if (decimalNumber == 8) return "VIII";
        if (decimalNumber == 80) return "LXXX";

        if (decimalNumber == 9) return "IX";
        if (decimalNumber == 90) return "XC";

        return null;
    }

    private String translateDecimalDivisibleBy500(int decimalNumber, StringBuilder stringBuilder) {
        int fiveHundreds = decimalNumber / 500;
        if(fiveHundreds == 1) return "D";
        return translateDecimalDivisibleBy500GreaterThan500(stringBuilder, fiveHundreds);
    }

    private String translateDecimalDivisibleBy500GreaterThan500(StringBuilder stringBuilder, int fiveHundreds) {
        stringBuilder.append('M');
        for (int i = 3; i < fiveHundreds; i += 2) stringBuilder.append('M');
        stringBuilder.append('D');
        return stringBuilder.toString();
    }

    private String translateDecimalDivisibleBy1000(int decimalNumber, StringBuilder stringBuilder) {
        int thousands = decimalNumber / 1000;
        for (int i = 0; i < thousands; i++) stringBuilder.append('M');
        return stringBuilder.toString();
    }
}
