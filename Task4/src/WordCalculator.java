import java.io.CharConversionException;
import java.io.Console;
import java.util.Scanner;



/**
 * Created by Vet on 22.03.2017.
 */
public class WordCalculator {
    public static void main(String[] args) {
        boolean inWord=false;//флаг, проверяющий, находится ли сивмол в слове, или он за его пределами
        int wordNumber=0;//количество слов
        int charNumber=0;//количество символов
        int punctNumber=0;//количество символов-разделителей
        int letterNumber=0;//количество букв
        Scanner sc = new Scanner(System.in);//создаем сканнер
        System.out.println("Enter the string");
        String s = sc.nextLine();//сканируем введенную строку
        char[] str = s.toCharArray();//преобразуем строку в массив символов
        for(int i=0;i<str.length;i++){
            if(Punctuation.isPunct(str[i])==false){//если символ не знак-разделитель (то есть если он буква)
                if(inWord==false){//если до этого находились вне слова
                    inWord=true;//отмечаем, что мы находимся в слове
                    wordNumber++;
                }
                letterNumber++;
                charNumber++;
            }
            else {//если сивмол является символом разделителем
                inWord=false;//отмечаем, что мы находимся вне слова
                punctNumber++;
                charNumber++;
            }
        }
        //печатаем результат
        System.out.println("word number is: "+wordNumber);
        System.out.println("punctuation char number is: "+punctNumber);
        System.out.println("char number is: "+charNumber);
        System.out.println("letter number is: "+letterNumber);
    }
}




