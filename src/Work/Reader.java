package Work;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Reader {

    private Scanner x;
    private Scanner sc;

    //ArrayList to store the words
    private ArrayList<String> wordList = new ArrayList<>();
    //ArrayList to store the definitions
    private ArrayList<String> definitionsList = new ArrayList<>();
    //ArrayList to store the cards
    private ArrayList<Card> cardList = new ArrayList<>();

    //Simple scanner collects user input
    public String getFileName(){
        sc = new Scanner(System.in);
        return sc.nextLine();
    }

    //Method to open the file and throw an exception if failed
    public void OpenWordFile(){
        try{
            x = new Scanner(new File("Words.txt"));
        }
        catch (Exception e){
            System.out.println("could not find file");
        }
    }

    //Method to open the file and throw an exception if failed
    public void OpenDefFile(){
        try{
            x = new Scanner(new File("Definitions.txt"));
        }
        catch (Exception e){
            System.out.println("could not find file");
        }
    }

    //Assigns each line to a Array
    public void readFile(ArrayList<String> e){
        while(x.hasNext()){
            e.add(x.nextLine());
        }
    }

    //Closes file
    public void closeFile(){
        x.close();
    }

    //Returns the wordlist
    public ArrayList<String> getWordList(){
        return wordList;
    }

    //Returns Definitionlist
    public ArrayList<String> getDefinitionsList(){
        return definitionsList;
    }

    //Returns cardList
    public ArrayList<Card> getCardList(){
        return cardList;
    }

    public void cardSetter(ArrayList<Card> c){
        c = cardList;
    }
    public ArrayList<Card> addTerms(ArrayList<Card> c, int q, ArrayList<String> word, ArrayList<String> def){
        for (int i = 0; i<q; i++){
            c.add(new Card(word,def,i));
        }
        return c;
    }
}
