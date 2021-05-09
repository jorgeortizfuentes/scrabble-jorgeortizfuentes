package cl.uchile.dcc.scrabble.gui;

public class Main {
    public static void main(String[] args) {
        ScrabbleInt intScr;
        int exampleInt1 = 10;
        String exampleStrInt1 = "10";
        intScr = new ScrabbleInt(exampleInt1);
        System.out.println(intScr.toString().getClass());

        int exampleInt2 = 10;
        System.out.println(exampleInt1 == exampleInt2);

    }
}
