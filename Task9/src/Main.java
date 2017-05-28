import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vet on 24.04.2017.
 */
public class Main {


    public static void main(String[] args) {



        JFrame mainFrame = new JFrame();                            //создаем новое окно
        mainFrame.setLayout(new BorderLayout());                    //задаем менеджер компановки
       JPanel panel = new JPanel();                                  //создаем главную панель
       JPanel southPanel = new JPanel();                             //создаем панель, которая будет снизу от графика
       paintPanel myPanel=new paintPanel();                         //создаем панель, на которой будем рисовать график
        JTextField textField=new JTextField();                      //текстовое поле, в которое будем вводить размер единичного отрезка
        JButton button = new JButton("Построить график");       //кнопка, которая будет перерисовывать график при изменении единичного отрезка
        mainFrame.add(panel);                                       //добавляем основную панель во фрейм
        southPanel.setLayout(new BorderLayout());                    //устанавливаем для нижнюю панель
        southPanel.add(textField,BorderLayout.CENTER);               //добавляем в центр нижней панели текстовое поле
        southPanel.add(button,BorderLayout.EAST);                   //добавляем на нижнюю панель кнупку
        panel.setLayout(new BorderLayout());                         //устанавливаем на главную панель менеджер компановки
        panel.add(southPanel,BorderLayout.SOUTH);                   //размещаем внизу главной панели нашу нижнюю панель
        panel.add(myPanel,BorderLayout.CENTER);                     //в центре главной панели помещаем панель для рисования

        //обработчик нажатия на кнопку
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            myPanel.setCoordinateStep(Integer.parseInt(textField.getText()));   //преобразуем введенное в текстовое поле значене в число, присваиваем его переменной с размером единичного отрезка
            mainFrame.repaint();                                                //перерисовываем окно
            }
        });
        ;


        mainFrame.setSize(800,600);                             //задаем начальные размеры окна
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  //задаем поведение программы при закрытии окна
        mainFrame.setVisible(true);                                         //делаем окно видимым

    }
}
