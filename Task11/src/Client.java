import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Виталий on 28.04.2017.
 */
public class Client implements Runnable{
public Client()  {
    try {
        Socket clientSocket = new Socket("localhost", 10800); //Создаем сокет, параметры - хост и порт. В данном случае хост - локальный компьютер, вместо него может быть IP
        OutputStream os = clientSocket.getOutputStream(); //создаем исходящий поток
        //производим действия, которые будут передаваться в исходящий поток
        int [] mySet = new int[]{10,20,30,60,0};//объявляем массив со значенниями
        for(int x:mySet){//цикл: перебираем все значения из массива
            os.write(x); //пишем значения в исходящий поток
        };
        //блок, принимаещий информацию из входящего потока
        InputStream is = clientSocket.getInputStream(); //создаем входящий поток
        System.out.println("Client get: summ is "+is.read()); //печатаем полученный результат

    } catch (IOException ex){
        System.out.println("Something wrong: "+ex);
    }
   /* new Thread(new Runnable() {
        @Override
        public void run() {
            new Client();
        }
    });
*/
    }

    @Override
    public void run() {
        new Client();
    }
}
