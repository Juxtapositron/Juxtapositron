import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

public class advent3{
    public static void main(String[] args) {


        try {
            BufferedReader br = new BufferedReader(new FileReader("advent3.txt"));


            int[] positiveBitsCount = new int[12];
            int[] negativeBitsCount = new int[12];

            String line;
            while ((line = br.readLine()) != null) {
            //for (String line : data.split("\n")) {
                String[] lineArr = line.split("");
                int i = 0;
                for (String s : lineArr) {
                    if (s.equals("1")) {
                        positiveBitsCount[i]++;
                    } else {
                        negativeBitsCount[i]++;
                    }
                    i++;
                }
            }

            String most = "";
            String least = "";
            for (int i = 0; i < positiveBitsCount.length; i++) {
                if (positiveBitsCount[i] > negativeBitsCount[i]) {
                    most += "1";
                    least += "0";
                } else {
                    most += "0";
                    least += "1";
                }
            }

            BigInteger mostNumber = new BigInteger(most, 2);
            BigInteger leastNumber = new BigInteger(least, 2);

            System.out.println(mostNumber.intValue() * leastNumber.intValue());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
