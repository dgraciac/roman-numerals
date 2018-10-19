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
            "1000,M","2000,MM","3000,MMM","4000,MMMM",
            "500,D","1500,MD","2500,MMD","3500,MMMD","4500,MMMMD",
            "100,C","200,CC","300,CCC","400,CD","600,DC","700,DCC","800,DCCC","900,CM",
            "1100,MC",
//            "1200,MCC","1300,MCCC","1400,MCD","1600,MDC","1700,MDCC","1800,MDCCC","2100,MMC","3100,MMMC","4100,MMMMC",
            "1,I","10,X",
            "2,II","20,XX",
            "4,IV","40,XL",
            "5,V","50,L",
            "6,VI","60,LX",
            "7,VII","70,LXX",
            "8,VIII","80,LXXX",
            "9,IX","90,XC"
    })
    public void translate_properly(int decimalNumber, String romanNumber) {
        assertThat(romanNumeral.translateFromDecimal(decimalNumber)).isEqualTo(romanNumber);
    }
}
