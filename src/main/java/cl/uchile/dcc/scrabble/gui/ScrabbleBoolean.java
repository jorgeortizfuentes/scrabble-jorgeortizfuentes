package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class ScrabbleBoolean extends AbstractScrabbleType {
    protected boolean content;

    public ScrabbleBoolean(boolean javaBoolean){
        this.content = javaBoolean;
    }

    public boolean getContent() {
        return this.content;
    }

    @Override
    public String toString(){
        return Boolean.toString(this.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleBoolean.class);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleBoolean) {
            var o = (ScrabbleBoolean) obj;
            return o.getContent() == this.content;

        }
        return false;
    }


}