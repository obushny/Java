package newpackage;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vet
 */
public class WordCalculator {
    
      
        
    
    
    
        public static int[] calculateAll(String s){
        int[] res;
        res = new int[2];
        int wordNumber=0;//количество слов
        int letterNumber=0;//количество букв
        boolean inWord=false;//флаг, проверяющий, находится ли сивмол в слове, или он за его пределами
        char[] str = s.toCharArray();//преобразуем строку в массив символов
        for(int i=0;i<str.length;i++){
            if(Punctuation.isPunct(str[i])==false){//если символ не знак-разделитель (то есть если он буква)
                if(inWord==false){//если до этого находились вне слова
                    inWord=true;//отмечаем, что мы находимся в слове
                    wordNumber++;
                }
                letterNumber++;
                
            }            else {//если сивмол является символом разделителем
                inWord=false;//отмечаем, что мы находимся вне слова

            }
        }
        res[0]=wordNumber;
        res[1]=letterNumber;
        return res;
            };
            
    public static void main(String[] args) {
       
        int[] result=new int[2];

       /* Scanner sc = new Scanner(System.in);//создаем сканнер
        System.out.println("Enter the string");
        String s = sc.nextLine();//сканируем введенную строку
        */
       String s="    xxx,    xx x   x";
        result=calculateAll(s);
        
        System.out.println("word number is: "+result[0]);
        System.out.println("letter number is: "+result[1]);


        
        }
        //печатаем результат

    
}
