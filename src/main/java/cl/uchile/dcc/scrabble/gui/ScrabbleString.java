package cl.uchile.dcc.scrabble.gui;

public class ScrabbleString extends AbstractScrabbleType {
    private String content;

    public ScrabbleString(String javastr){
        this.content = javastr;
    }

    @Override
    public String toString(){
        return this.content;
    }

    @Override
    public boolean equals(Object obj) {
        if obj instanceof ScrabbleString{
            var o = (ScrabbleString) obj;
            return o.content == content;

        }

    }
}
