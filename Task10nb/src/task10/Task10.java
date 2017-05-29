
package task10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Task10 {

    private String query ="SELECT * FROM students";//строка запроса SELECT по умолчанию (можно не писать)
    private String modifyQuery ="";//строка запросов INSERT и UPDATE
    ResultSet result; //переменная результатов запросов SELECT
    
    //свойство, позволяющее устанавливать запросы SELECT из других классов
    public void setQuery(String query){
        this.query=query;
    };
    
    //свойство, позволяющее устанавливать запросы INSERT и UPDATE из других классов
    public void setModifyQuery(String modifyQuery){
        this.modifyQuery=modifyQuery;
    };
    
    //это лишнее. Пытался преобразовать результаты запроса в таблицу
    public ResultSet getResult(){
    return result;
    };
    
    
    //тело метода, обрабатывающего запрос SELECT
public void selectQuery(){
        try{
    Class.forName("com.mysql.jdbc.Driver");//указываем драйвер, который будет работать с базой данных. Чтобы эта строка работала,
    //нужно добавить в соответствующий драйвер в библиотеке
    String url = "jdbc:mysql://localhost:3306/sqlcoursedatabase";//строка, содержащая путь к базе данных
    String login = "vet";//строка с именем пользователя
    String password = "qwerty";//строка с паролем пользователя
    Connection con = DriverManager.getConnection(url,login,password);//создаем соединение через DriverManager
    Statement stmt = con.createStatement();// на основе соединения создаем Statement
    result =stmt.executeQuery(query);//методом executeQuery выполняем запрос, результат присваеваем переменной result
    
    int columnNumber=   result.getMetaData().getColumnCount();//находим количество столбцов в запросе
    
    //пока не закончатся строки в результате запроса, цикл будет копировать данные в строки и выводить их на экран
    while(result.next()){ 
                String str="";//инициируем строковую переменную или обнуляем старые значения
                //пробегаем по каждому столбцу, записываем его значение в строку
                for(int i=1;i<=columnNumber;i++){
                 str=str+result.getString(i)+ ": ";//добавляем к сформированной строке значение очередного столбца и разделяем его двоеточием
                };
                str=str+'\n';//добавляем символ новой строки после формирования строки
                        
        System.out.println("results:" + str);//выводим очередную строку на экран
    
        };
        result.close();//закрываем результат
        stmt.close();//закрываем Statemant
        con.close();//закрываем соединение
        }
        catch(Exception e){//какое-то исключение
        e.printStackTrace();
        }
        
        };


//тело метода, обрабатывающего запросы INSERT и  UPDATE
public void modifyData(){
        try{
    Class.forName("com.mysql.jdbc.Driver");//указываем драйвер, который будет работать с базой данных. Чтобы эта строка работала,
    //нужно добавить в соответствующий драйвер в библиотеке
    String url = "jdbc:mysql://localhost:3306/sqlcoursedatabase";//строка, содержащая путь к базе данных
    String login = "vet";//строка с именем пользователя
    String password = "qwerty";//строка с паролем пользователя
    Connection con = DriverManager.getConnection(url,login,password);//создаем соединение через DriverManager
    Statement stmt = con.createStatement();// на основе соединения создаем Statement
    stmt.execute(modifyQuery);//исполняем запрос на модификацию

        //result.close();
        stmt.close();//закрываем Statemant
        con.close();//закрываем соединение
        }
        catch(Exception e){//какое-то исключение
        e.printStackTrace();
        }
        
        }

    
}




