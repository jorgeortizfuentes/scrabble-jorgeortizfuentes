package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class ScrabbleString extends AbstractScrabbleType {
    protected String content;

    public ScrabbleString(String javaStr){
        this.content = javaStr;
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public String toString(){
        return this.content;
    }

    public ScrabbleString asString(){
        return new ScrabbleString(this.content);
    }

    @Override
    public int hashCode() {
         return Objects.hash(getContent());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleString) {
            var o = (ScrabbleString) obj;
            return o.getContent().equals(this.content);

        }
        return false;
    }


}
