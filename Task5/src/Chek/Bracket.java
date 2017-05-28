package Chek;

/**
 * Created by Vet on 25.03.2017.
 */
public class Bracket {
    public static void checkBracket(String var) {
        int bracketIndex = 0;
        boolean isAnyBracket=false;
        char[] str;
        str = var.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (bracketIndex < 0) {
                System.out.println("Закрывающая скобка раньше открывающей!");
                break;
            }
            if (str[i] == ')') {
                bracketIndex--;
                isAnyBracket=true;
            } else if (str[i] == '(') {
                bracketIndex++;
                isAnyBracket=true;
            }
        }
        if (bracketIndex != 0) {
            System.out.println("Скобки расставлены неправильно!");
        } else {
            if(isAnyBracket){
                System.out.println("Со скобками все впорядке");}
            else {
                System.out.println("В выражении нет скобок!");
            }
        }
        ;

    }
}
