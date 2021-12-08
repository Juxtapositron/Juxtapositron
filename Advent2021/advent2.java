import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class advent2{
	public static void main(String[] args) {
			try {
					File file = new File("advent2.txt");
					Scanner input = new Scanner(file);
					int depth = 0;
					int hor = 0; //part1
					int aim = 0;
					if (args[0].equals("1")){
					while (input.hasNextLine()) {
							String line = input.nextLine();
							int x = Integer.parseInt(line.substring(line.length()-1));
							if (line.indexOf("forward") != -1){
								hor += x;
							}
							if (line.indexOf("up") != -1){
								depth -= x;
							}
							if (line.indexOf("down") != -1){
								depth += x;
							}
					}
					System.out.println(hor*depth);
					input.close();
				}
					if (args[0].equals("2")){ //part2
					while (input.hasNextLine()) {
							String line = input.nextLine();
							int x = Integer.parseInt(line.substring(line.length()-1));
							int y = aim;
							if (line.indexOf("forward") != -1){
								hor += x;
								depth += (x * y);
							}
							if (line.indexOf("up") != -1){
								aim -= x;
							}
							if (line.indexOf("down") != -1){
								aim += x;
							}
					}
					System.out.println(hor*depth);
					input.close();
				}
			} catch (FileNotFoundException ex) {
					System.out.println("You failed, dumbass!");
			}
	}
}
