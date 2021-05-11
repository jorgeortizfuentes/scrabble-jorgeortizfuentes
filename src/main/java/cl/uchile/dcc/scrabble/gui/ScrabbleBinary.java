package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScrabbleBinary extends AbstractScrabbleType {
    protected String content;

    public ScrabbleBinary(String javaStr){

        Pattern pattern = Pattern.compile("[^0-1]");
        Matcher matcher = pattern.matcher(javaStr);
        boolean isBinary = !matcher.find();
        if (!isBinary) throw new AssertionError("The string is not a binary.");
        this.content = javaStr;

    }

    public String getContent() {
        return this.content;
    }

    @Override
    public String toString(){
        return this.content;
    }

    @Override
    public ScrabbleString asString(){
        return new ScrabbleString(this.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleBinary.class, content);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleBinary) {
            var o = (ScrabbleBinary) obj;
            return o.getContent().equals(this.content);

        }
        return false;
    }

    public int toInt(String binary) {
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }

    private int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }

    private int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }


}


