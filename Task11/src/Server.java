import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Виталий on 28.04.2017.
 */
public class Server implements Runnable{
    public ServerSocket ss;//объявляем серверный сокет
    public Server() { //конструктор класса Сервер
       try {
           ss=new ServerSocket(10800); //создаем серверный сокет, порт такой же, как в клиенте
           Socket socket =ss.accept(); //создаем сокет, производный от серверного сокета
           System.out.println("Connecting to some client"); //просто некое сообщение

           InputStream is=socket.getInputStream(); //создаем входящий поток
           int summ=0; //объявляем переменную, которая будет суммировать все принятые числа
           int y;//объявляем переменную, в которую будут записываться числа из входящего потока
           while((y=is.read())!=0){//пишем в y значения, полученные из входящего потока. Условия прекращения цикла - пока Клиент не пришлет 0
               System.out.println("Server got from client "+y);
               summ=summ+y;//суммируем полученные числа
               System.out.println("Summ now is "+summ);
            };
           System.out.println("Server: calculate: " + summ);//печатаем результат от имени сервера
           OutputStream os=socket.getOutputStream();//создаем исходящий поток
           os.write(summ);//пишем значение суммы в исходящий поток

       }catch (IOException ex){
           System.out.println("Server: exception thown " + ex);
       };
      /*  new Thread(new Runnable(){

            @Override
            public void run() {
            new Server();
            }
        });*/
    }


    @Override
    public void run() {
        new Server();
    }
}
