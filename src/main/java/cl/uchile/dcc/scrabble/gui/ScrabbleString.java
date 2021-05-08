package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class ScrabbleString extends AbstractScrabbleType {
    protected String content;

    public ScrabbleString(String javastr){
        this.content = javastr;
    }

    @Override
    public String toString(){
        return this.content;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleString.class);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleString) {
            var o = (ScrabbleString) obj;
            return o.content.equals(this.content);

        }
        return false;
    }
}
