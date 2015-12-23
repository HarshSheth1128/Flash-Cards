package Work;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application{

    //Makes a reader
    static Reader q = null;

    //Initialises the stage
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Scene.fxml"));
        primaryStage.setTitle("FlashCards");

        Scene scene = new Scene(root, 600, 400, Color.GREY);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }


    public static void main (String[] args){

        Reader r = new Reader();
        ArrayList<String> wordList = r.getWordList();
        ArrayList<String> definitionList = r.getDefinitionsList();

        //Initialises the Arraylist and reads the file adding them to arraylist

        r.OpenWordFile();
        r.readFile(wordList);
        r.closeFile();

        //Initialises the Definitions Arraylist and reads the file adding them

        r.OpenDefFile();
        r.readFile(definitionList);
        r.closeFile();


        //Card for each word and def is made
        ArrayList<Card> c = r.getCardList();
        r.cardSetter(r.addTerms(c, wordList.size(), wordList, definitionList));


        //Loops through and displays the word and defs
        for (Card i : c){
            System.out.printf("%s : %s\n",i.dispWord(),i.dispDef());
        }

        //Sets the reader to an instance variable
        q = r;

        //Displays the window
        launch(args);
    }

    public Reader send(){
        return q;
    }

}
