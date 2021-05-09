package cl.uchile.dcc.scrabble.gui;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        ScrabbleBinary scrBin;

        String str = "01010101";
        scrBin = new ScrabbleBinary(str);
        System.out.println("Resultados");


        String errorString = RandomStringUtils.random(10);
        new ScrabbleBinary(errorString);


    }
}
