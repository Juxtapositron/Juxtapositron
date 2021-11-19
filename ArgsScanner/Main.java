import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    String text = "This is a sample\nOf how to read\ntext!";

    // creates a Scanner object to read throug the String
    Scanner input = new Scanner(text);

    //you don't want a for loop here unless you know the size of the data set

    //Run EITHER loop:
    while(input.hasNext()){
      System.out.println(input.next());
    }

    //while(input.hasNextLine()){
    //  System.out.println(input.nextLine());
    //}
  }
}
