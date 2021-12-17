import java.util.ArrayList;
public class Nicholas{

public static boolean check (int a){
if (a % 5 == 0){
return true;
}
if (a%1000 - a%100 == 500 || a%100 - a%10 == 50){
return true;
}
return false;
}

public static int[] removeAnyDigit(int a){
      int x = 0;
      while (Math.pow(10, x) < Math.abs(a)){
        x++;
      }
      int[] ans = new int[x];
      for (int i = 0; i<x; i++){
        ans[i] = (int)a%(Math.pow(10, x+1)) - (int)a%(Math.pow(10, x));
      }
      return ans;
}

  public static void main(String[] args){
    int ans = 0;
    boolean a = true;
    for (int i = 1; i<2022; i++){
      if (check(i)){
        for (int j = 0; j < removeAnyDigit(i).length; j++){
            if (!check(removeAnyDigit(i)[j])){
              a = false;
            }
        }
      }
      if (a){
        ans++;
      }
    }
    System.out.print(a);
  }
}
