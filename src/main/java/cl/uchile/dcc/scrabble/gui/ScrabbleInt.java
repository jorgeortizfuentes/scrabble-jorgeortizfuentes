package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class ScrabbleInt extends AbstractScrabbleType{
    protected int content;

    public ScrabbleInt(int javaInt){
        this.content = javaInt;
    }

    public int getContent() {
        return this.content;
    }

    @Override
    public String toString(){
        return Integer.toString(this.content);
    }

    public ScrabbleString asString(){
        String str = this.toString();
        return new ScrabbleString(str);
    }

    public ScrabbleFloat asFloat(){
        double n_float = this.content;
        return new ScrabbleFloat(n_float);
    }

    public ScrabbleInt asInt(){
        return new ScrabbleInt(this.content);
    }

    public ScrabbleBinary asBinary(){
        String b_int = BinUtilities.intToBinary(this.content);
        return new ScrabbleBinary(b_int);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleInt.class, content);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleInt) {
            var o = (ScrabbleInt) obj;
            return o.getContent() == this.content;
        }
        return false;
    }


}
