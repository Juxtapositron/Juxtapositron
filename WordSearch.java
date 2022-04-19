import java.util.*;
import java.io.*;

public class WordSearch{
    private char[][]data;
    private static int seed;
    private Random rng;
    private ArrayList<String>wordsToAdd = new ArrayList<>();
    private ArrayList<String>wordsAdded = new ArrayList<>();

    public static void main(String[] args) {
      try {
        WordSearch a;
        boolean answer = false;
        if (args.length >= 5) {
          seed = Integer.parseInt(args[4]);
        } else {
          Random rng = new Random();
          seed = rng.nextInt();
        }
        if (args.length >= 4) {
          if (args[3].equals("1")){
            answer = true;
          } else if (!args[3].equals("0"))
          error();
        }

        if (args.length <= 3) {
          System.out.println("Insufficient number of inputs");
          error();
        }
        System.out.println(a = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],seed,answer));
      }
      catch(Exception e) {
        error();
      }
      /*catch(NumberFormatException e) {
        System.out.println("row, col, and seed must all be integer numbers");
        error();
      }
      catch(NegativeArraySizeException e) {
        System.out.println("row and col must be positive integers");
        error();
      }
      */
    }

    public WordSearch( int rows, int cols, String fileName, int randSeed, boolean answer) throws FileNotFoundException{
      Scanner in = new Scanner(new File(fileName));
      while (in.hasNextLine()) {
        wordsToAdd.add(in.nextLine());
      }

      data = new char[rows][cols];

      clear();
      rng = new Random(randSeed);
      addAllWords();
      if (!answer) {
        fillInRandomLetters();
      }
    }


    public String toString(){
      String a = "";
      for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[i].length; j++) {
          if (j == data[i].length - 1) {
            if (data[i][j] == '_') {
              a += ' ' + "\n";
            }
            else {
              a += data[i][j] + "\n";
            }
          }
          else {
            if (data[i][j] == '_') {
              a += "  ";
            }
            else {
              a += data[i][j] + " ";
            }
          }
        }
      }
      a = a.substring(0, a.length() - 1);
      a +=  "\nwords: " + wordsAdded + "\nseed: " + seed ;
      return a;
    }

    private void clear(){
      for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[i].length; j++) {
          data[i][j] = '_';
        }
      }
    }

    private boolean addWord(String word, int r, int c, int rowIncrement, int colIncrement) {
      char[][] test = copyArray();
      int index = 0;
      while (index < word.length()) {
        if (r > -1 && r < test.length && c > -1 && c < test[0].length) {
          if (test[r][c] == '_') {
            test[r][c] = word.charAt(index);
          }
          if (test[r][c] != word.charAt(index)) {
            return false;
          }
          else {
            index++;
            r += rowIncrement;
            c += colIncrement;
          }
        }
        else {
          return false;
        }
      }
      data = test;
      return true;
    }

    private char[][] copyArray() {
      char[][] f = new char[data.length][data[0].length];
      for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[i].length; j++) {
          f[i][j] = data[i][j];
        }
      }
      return f;
    }

    private void addAllWords() {
      for (int i = 0; i < wordsToAdd.size(); i+= 0) {
        String word = wordsToAdd.get(abs(rng.nextInt()) % wordsToAdd.size());
        int h = (abs(rng.nextInt()) % 3) - 1;
        int v = (abs(rng.nextInt()) % 3) - 1;
        if (h == 0 && v == 0) {
          h = 1;
        }
        int x = 100;
        while (x > 0) {
          if (addWord(word, abs(rng.nextInt()) % data.length, abs(rng.nextInt()) % data[0].length, h, v)) {
            x = -1;
            wordsToAdd.remove(word);
            wordsAdded.add(word);
          }
          x -= 1;
        }
        wordsToAdd.remove(word);
      }
    }

    private void fillInRandomLetters() {
      for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[0].length; j++) {
          if (data[i][j] == '_' || data[i][j] == ' ') {
            data[i][j] = (char)('A' + abs(rng.nextInt())%25);
          }
        }
      }

    }

    private static int abs(int input) {
      if (input < 0) {
        input*= -1;
      }
      return input;
    }

    public static void error() {
      System.out.println("Please follow the following format:\njava WordSearch rows cols filename seed mode\nseed and mode (0 for normal, 1 for key) are optional");
      System.exit(1);
    }
}
