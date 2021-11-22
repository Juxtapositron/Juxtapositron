
  import java.io.File;
  import java.io.FileNotFoundException;
  import java.util.Scanner;
  public class ReadFile {
    public static void main(String[] args) {
        try {
            File file = new File("data.txt");
            int lineNumber = 0;
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
            input.close();

        } catch (FileNotFoundException ex) {
            System.out.println("You failed, dumbass!");
        }
    }
}
