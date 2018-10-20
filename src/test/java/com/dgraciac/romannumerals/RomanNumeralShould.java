package com.dgraciac.romannumerals;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RomanNumeralShould {
    private RomanNumeral romanNumeral;

    @Before
    public void initialize() {
        romanNumeral = new RomanNumeral();
    }

    @Test
    @Parameters({
            "1,I", "2,II", "3,III", "4,IV", "5,V", "6,VI", "7,VII", "8,VIII", "9,IX", "10,X",
            "11,XI", "12,XII", "13,XIII", "14,XIV", "15,XV", "16,XVI","17,XVII","18,XVIII","19,XIX","20,XX",
            "21,XXI","23,XXIII","24,XXIV","25,XXV","26,XXVI","28,XXVIII","29,XXIX","30,XXX",
            "31,XXXI","33,XXXIII","34,XXXIV","35,XXXV","36,XXXVI","38,XXXVIII","39,XXXIX","40,XL",
            "41,XLI", "42,XLII", "43,XLIII", "44,XLIV", "45,XLV", "46,XLVI", "47,XLVII", "48,XLVIII", "49,XLIX", "50,L",
            "51,LI", "53,LIII", "54,LIV", "55,LV", "56,LVI", "58,LVIII", "59,LIX", "60,LX",
            "61,LXI", "70,LXX",
            "71,LXXI", "80,LXXX",
            "81,LXXXI", "89,LXXXIX", "90,XC",
            "91,XCI", "99,XCIX", "100,C",
            "101,CI", "139,CXXXIX", "140,CXL", "199,CXCIX", "200,CC",
            "201,CCI", "299,CCXCIX", "300,CCC",
            "301,CCCI", "399,CCCXCIX", "400,CD",
            "401,CDI", "499,CDXCIX", "500,D", "899,DCCCXCIX", "900,CM",
            "901,CMI", "999,CMXCIX", "1000,M",
            "1001,MI", "1999,MCMXCIX", "2000,MM",
            "2001,MMI", "2999,MMCMXCIX", "3000,MMM",
            "3001,MMMI", "3999,MMMCMXCIX", "4000,MMMM",
            "4001,MMMMI", "4999,MMMMCMXCIX"
    })
    public void translateProperly(int decimalNumber, String romanNumber) {
        assertThat(romanNumeral.translateFromDecimal(decimalNumber)).isEqualTo(romanNumber);
    }
}
