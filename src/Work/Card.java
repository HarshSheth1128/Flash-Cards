package Work;

import java.util.ArrayList;

public class Card {

    private String word;
    private String definition;

    public Card(ArrayList<String> Word,ArrayList<String> Definition, int i){
        word = Word.get(i);
        definition = Definition.get(i);
    }

    public String dispWord(){
        return word;
    }

    public String dispDef(){
        return definition;
    }

}
