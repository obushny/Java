package newpackage;

public class Bracket {
    public static boolean checkBracket(String var) {
        int bracketIndex = 0;
        //boolean isAnyBracket=false;
        char[] str;
        str = var.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (bracketIndex < 0) {
                //System.out.println("Закрывающая скобка раньше открывающей!");
                break;
            }
            if (str[i] == ')') {
                bracketIndex--;
               // isAnyBracket=true;
            } else if (str[i] == '(') {
                bracketIndex++;
              //  isAnyBracket=true;
            }
        };
        return(bracketIndex==0);
        /*if (bracketIndex != 0) {
            System.out.println("Скобки расставлены неправильно!");
            return false;
        } else {
            if(isAnyBracket){
                System.out.println("Со скобками все впорядке");
                return true;
            }  else {
                System.out.println("В выражении нет скобок!");
                return true;
            }
        }*/
        
    
};
}
