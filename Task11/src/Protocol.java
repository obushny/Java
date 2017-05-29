/**
 * Created by Виталий on 28.04.2017.
 */
//приложение демонстрирует клиент-серверное взаимодействие. Клиент передает на сервер ряд чисел,
//сервер обрабатывает их (суммирует), сообщает сумму (печатает в консоль), потом передает результат обратно клиенту.
//Клиент тоже печатает результат в консоль
public class Protocol {
    public static void main(String[] args) {
//Создаем сервер в новом потоке
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Server();
            }
        }).start();

//создаем клиент в новом потоке
       new Thread(new Runnable() {
            @Override
            public void run() {
                new Client();
            }
        }).start();
    }
}
