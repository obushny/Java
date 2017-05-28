
import java.util.Scanner;

import static Factorial.Factorial.fact;

/**
 * Created by Vet on 19.03.2017.
 */

public class Calculate {
    public static void main(String[] args) {
        int i=-1;//присваиваем i безопасное значение
        int f;
        boolean mistake=true;//флаг ошибки ввода. Если он истинный, то мы ввели некорректное значение
        while(mistake) {
            System.out.println("Enter integer number");
            Scanner sc = new Scanner(System.in);//сканируем введенные символы
            try {//пропуем преобразовать введенную строку в целое число
                i = sc.nextInt();//пребразуем строку в число
            } catch (java.util.InputMismatchException e) {//если ввели не число, а текстовую строку
                System.out.println("You enter not integer number");
            }
            ;

            if (i < 0) {//если введенное число отрицательное
                System.out.println("Enter positive integer number");
            } else {//если введенное число положительное, присваиваем переменной значение функции
                f = fact(i);
                System.out.println(i + "!=" + f);
                mistake=false;
            }
        }
    }
}
