import.java.util.ArrayList;
public class WordPairList{

    private ArrayList<WordPair> allPairs;

     public WordPairList(String[] words){
          allPairs = new ArrayList<WordPair>();
           for (int i = 0; i < words.length - 1; i++){
             for (int j = i+1; j < words.length; j++){
               allPairs.add(new WordPair(words[i], words[j]));
             }
           }
     }
     // constructor

     public int numsMatch(){
       int x = 0;
       return x;
     }
}
