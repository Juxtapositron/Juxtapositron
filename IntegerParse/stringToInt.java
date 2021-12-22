public class stringToInt{

  public static int valueOfDigit(char c){
    if (c - 48 <= -1 && c - 48 < 9){
      throw new IllegalArgumentException("Numeric Values Only!");
    } else return c - 48;
  }

  public static int stringToInt(String s){
    int x = 0;
    for (int i = s.length()-1; i>0; i--){
      x+= (valueOfDigit(s.charAt(s.length() - i - 1)) * Math.pow(10, i));
    }
    x+=valueOfDigit(s.charAt(s.length()-1));
    return x;
  }

  public static void main(String[] args){
    System.out.println(valueOfDigit('0'));
    System.out.println(valueOfDigit('1'));
    System.out.println(valueOfDigit('2'));
    System.out.println(valueOfDigit('3'));
    System.out.println(valueOfDigit('4'));
    System.out.println(valueOfDigit('5'));
    System.out.println(valueOfDigit('6'));
    System.out.println(valueOfDigit('7'));
    System.out.println(valueOfDigit('8'));
    System.out.println(valueOfDigit('9'));
    String s = "123443522536";
    System.out.print(stringToInt(s));
  }
}
