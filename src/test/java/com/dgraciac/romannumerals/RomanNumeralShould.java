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

/*                "1000,M","2000,MM","3000,MMM","4000,MMMM",
                        "500,D","1500,MD","2500,MMD","3500,MMMD","4500,MMMMD",
                        "100,C","200,CC","300,CCC","400,CD","600,DC","700,DCC","800,DCCC","900,CM",
                        "1100,MC",
                        "1200,MCC","1300,MCCC","1400,MCD","1600,MDC","1700,MDCC","1800,MDCCC","2100,MMC","3100,MMMC","4100,MMMMC",
                        ,"10,X",
                        ,"20,XX",
                        "4,IV","40,XL",
                        "5,V","50,L",
                        "6,VI","60,LX",
                        "7,VII","70,LXX",
                        "8,VIII","80,LXXX",
                        "9,IX","90,XC"*/

    @Test
    @Parameters({
            "1,I", "2,II", "3,III", "4,IV", "5,V", "6,VI", "7,VII", "8,VIII", "9,IX", "10,X",
            "11,XI", "12,XII", "13,XIII", "14,XIV", "15,XV", "16,XVI","17,XVII","18,XVIII","19,XIX","20,XX",
            "21,XXI","23,XXIII","24,XXIV","25,XXV","26,XXVI","28,XXVIII","29,XXIX","30,XXX",
            "31,XXXI","33,XXXIII","34,XXXIV","35,XXXV","36,XXXVI","38,XXXVIII","39,XXXIX","40,XL",
            "41,XLI","42,XLII","43,XLIII","44,XLIV","45,XLV","46,XLVI","48,XLVIII","49,XLIX","50,L"
    })
    public void translateProperly(int decimalNumber, String romanNumber) {
        assertThat(romanNumeral.translateFromDecimal(decimalNumber)).isEqualTo(romanNumber);
    }
}
