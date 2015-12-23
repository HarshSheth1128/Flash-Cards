package Work;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Random;

public class Controller extends Main{

    Random rand = new Random();
    private int Random;
    //Makes the rand instance variable int so that the def class can use it

    public Button wordBox;
    public Label defBox;

    private Reader r;

    public void getWordClick(){
        r = send();
        Random = rand.nextInt(r.getCardList().size());
        wordBox.setText(r.getCardList().get(Random).dispWord());
        defBox.setText("");
    }


    public void getDefClick(){
        defBox.setText(r.getCardList().get(Random).dispDef());

    }

    public void goNext(){
        int nextInt;
        if (Random == (r.getCardList().size() - 1)){
            nextInt = 0;
            wordBox.setText(r.getCardList().get(nextInt).dispWord());
            defBox.setText(r.getCardList().get(nextInt).dispDef());
        } else {
            nextInt = Random + 1;
            wordBox.setText(r.getCardList().get(nextInt).dispWord());
            defBox.setText(r.getCardList().get(nextInt).dispDef());
        }
    }

    public void goPrev(){
        int prevInt;
        if (Random == 0){
            prevInt = r.getCardList().size() - 1;
            wordBox.setText(r.getCardList().get(prevInt).dispWord());
            defBox.setText(r.getCardList().get(prevInt).dispDef());
        } else {
            prevInt = Random - 1;
            wordBox.setText(r.getCardList().get(prevInt).dispWord());
            defBox.setText(r.getCardList().get(prevInt).dispDef());
        }
    }

}
