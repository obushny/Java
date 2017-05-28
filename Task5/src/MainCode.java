import Chek.Bracket;

import java.util.Scanner;

/**
 * Created by Vet on 26.03.2017.
 */
public class MainCode {
    public static void main(String[] args) {
        String formula="";/*="(a(b)c)d)"*/;
        Scanner sc=new Scanner(System.in);
        while ( true) {
            formula = sc.nextLine();
            if (formula.compareTo("end") == 0) {
                break;
            } else {
            Bracket.checkBracket(formula);
        }
        }
    }
}
