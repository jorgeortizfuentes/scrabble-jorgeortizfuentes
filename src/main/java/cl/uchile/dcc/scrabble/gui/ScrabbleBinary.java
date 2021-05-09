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
    public ScrabbleString asString(){
        return new ScrabbleString(this.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContent());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleBinary) {
            var o = (ScrabbleBinary) obj;
            return o.getContent().equals(this.content);

        }
        return false;
    }


}


