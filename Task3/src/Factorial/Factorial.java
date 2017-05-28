package Factorial;

import java.util.Scanner;

/**
 * Created by Vet on 19.03.2017.
 */
//Функция, вычитающая факториал целого числа
public class Factorial {
    public static int fact(int val) {

        int f = 1;
        int j = val;
        while (j > 0) {

            f *= j;
            j--;

        };
        return f;
    }

    }

       /*Нижележащий комментарий читать не надо
       Scanner a= new Scanner(System.in);
       public static int StringToInt(String val)

        {try
        {
            return Integer.parseInt(val);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Enter the ingeger positive number!");

        }
         }

    }*/


