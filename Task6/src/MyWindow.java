import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * Created by Vet on 02.04.2017.
 */
public class MyWindow extends JFrame{
    private int color1=255;
    private int color2=255;
    private int color3=255;
    private int n=0;
    MyWindow(){

        JFrame testFrame = new JFrame();    //создаем фрейм
        JPanel panel = new JPanel();    //создаем панель-контейнер
        setContentPane(panel);  //определяем панель как контейнер
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setLayout(null);  //указываем, что работаем без менеджера-компановщика
        Color cl = new Color(color1,color2,color3); //создаем цвет по умолчанию
        panel.setBackground(cl);    //устанавливаем цвет панели по умолчанию
        setResizable(false);

        //создаем кнопку
        JButton button1 = new JButton();    //констуктор кнопки
        button1.setText("Кнопка");  //надпись кнопки
        panel.add(button1); //добавляем кнопку на панель
        button1.setSize(100,50);    //задаем размер кнопки
        button1.setLocation(10,10); //задаем начальное положение кнопки


        //создаем обработчик событий для кнопки
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            n++;    //счетчик нажатий
            button1.setText(Integer.toString(n));   //выводим количество нажатий на гадпись кнопки

            }
        });


        //создаем 1-ю радиокнопку
        JRadioButton radioButton1 = new JRadioButton(); //конструктор радиокнопки
        panel.add(radioButton1);    //добавляем радиокнопку на панель
        radioButton1.setSize(140,50);   //устанавливаем размер
        radioButton1.setLocation(10,70);    //устанавливаем начальное положение
        radioButton1.setText("Всего нажатий");  //текст радиокнопки
        radioButton1.setBackground(cl); //устанавливаем цвет радиокнопки по умолчанию

        //устанавливаем обработчик события "Нжание на кнопку
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            n=0;    //обнуляем значение счетчика нажатий
            button1.setText("Кнопка");  //устанавливаем на кнупку первоначальную надпись
            }
        });

        //повторяем для радиокнопки 2 те же действия, что и для радиокнопки 1
        JRadioButton radioButton2 = new JRadioButton();
        panel.add(radioButton2);
        radioButton2.setSize(140,50);
        radioButton2.setLocation(10,110);
        radioButton2.setText("Нажатий в сек.");
        radioButton2.setBackground(cl);

        //обработчик событий для ражиокнопки 2 (такой же, как для радиокнопки 2
        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                n=0;
                button1.setText("Кнопка");
            }
        });

        //создаем группировщик радиокнопок 1 и 2, теперь нажатыми будут или 1, или 2
        ButtonGroup bg1 = new ButtonGroup();    //конструктор группировщика радиокнопок
        bg1.add(radioButton1);  //добавляем в группировщик радиокнопку 1
        bg1.add(radioButton2);  //добавляем в группировщик радиокнопку 2
        radioButton1.setSelected(true); //устанавливаем включенной по умолчанию радиокнопку 1


        //создаем радиокнопку 3
        JRadioButton radioButton3 = new JRadioButton(); //конструктор радиокнопки
        panel.add(radioButton3);    //добавляем радиокнопку на панель
        radioButton3.setSize(140,50);   //устанавливаем размер
        radioButton3.setLocation(10,150);   //устанавливаем первоначальное положение
        radioButton3.setText("RGB");    //устанавливаем надпись
        radioButton3.setBackground(cl); //устанавливаем цвет

        //создаем радиокнопку 4
        JRadioButton radioButton4 = new JRadioButton(); //конструктор радиокнопки
        panel.add(radioButton4);    //добавляем радиокнопку на панель
        radioButton4.setSize(140,50);   //устанавливаем размер
        radioButton4.setLocation(10,190);   //устанавливаем первоначальное положение
        radioButton4.setText("HSB");    //устанавливаем надпись
        radioButton4.setBackground(cl); //устанавливаем цвет

        //создаем группировщик радиокнопок 3 и 4, теперь нажатыми будут или 3, или 4
        ButtonGroup bg2 = new ButtonGroup();    //конструктор группировщика радиокнопок
        bg2.add(radioButton3);  //добавляем в группировщик радиокнопку 3
        bg2.add(radioButton4);  //добавляем в группировщик радиокнопку 4
        radioButton3.setSelected(true); //устанавливаем включенной по умолчанию радиокнопку 3


        //создаем зону текста
        JTextArea textArea = new JTextArea();   //конструктор зоны текста
        textArea.setSize(400,350);  //устанавливаем размер
        textArea.setLocation(170,10);   //устанавливаем начальное положение

        //создаем панель прокрутки, на которую добавим зону текста.
        // Теперь при длинном тексте появятся автоматически полосы прокрутки
        JScrollPane scrollPane = new JScrollPane(textArea); //констуктор панели прокрутки (в качестве аргумента - зона текста)
        scrollPane.setSize(400,350);    //устанавливаем размер
        scrollPane.setLocation(170,10); //устанавливаем положение
        panel.add(scrollPane);  //добавляем на основную панель нашу панель прокрутки

        //создаем ползунок
        JScrollBar scrollBar = new JScrollBar();    //констуктор ползунка
        scrollBar.setSize(20,350);  //устанавливаем размер
        scrollBar.setLocation(150,10);  //устанавливаем местоположение
        panel.add(scrollBar);   //добавляем ползунок на панель
        scrollBar.setMinimum(0);    //устанавливаем значение-минимум для ползунка
        scrollBar.setMaximum(255);  //устанавливаем значение-максимум для ползунка
        scrollBar.setValue(color1);    //устанавливаем значение по умолчанию

//обработчик события перемещения ползунка
        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                color1 = scrollBar.getValue();  //присваиваем значению цвета значение положения ползунка
                color2 = color1;    //приравниваем все три цвета одному значению
                color3 = color1;    //аналогично
                Color cl = new Color(color1, color2, color3);   //создаем новый цвет

                //меняем цветовую схему в зависимости от положения радиокнопок 3 и 4
                if (radioButton3.isSelected() == true) {    //если включена радиокнопка 3, применяем схему RGB
                    panel.setBackground(cl);    //цвет панели
                    radioButton1.setBackground(cl); //цвет радиокнопки 1
                    radioButton2.setBackground(cl); //цвет радиокнопки 2
                    radioButton3.setBackground(cl); //цвет радиокнопки 3
                    radioButton4.setBackground(cl); //цвет радиокнопки 4
                } else {    //если включена радиокнопка 4, применяем схему HSB
                    panel.setBackground(Color.getHSBColor(color1, color1, 255)); //цвет панели
                    radioButton1.setBackground(Color.getHSBColor(color1, color2, 255)); //цвет радиокнопки 1
                    radioButton2.setBackground(Color.getHSBColor(color1, color2, 255)); //цвет радиокнопки 2
                    radioButton3.setBackground(Color.getHSBColor(color1, color2, 255)); //цвет радиокнопки 3
                    radioButton4.setBackground(Color.getHSBColor(color1, color2, 255)); //цвет радиокнопки 4
                }

            }
        });

        //обработчик события переключерния радиокнопки 4
        radioButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //меняем цвета элементов по схеме HSB
                color1 = scrollBar.getValue();
                panel.setBackground(Color.getHSBColor(color1, color1, 255));
                radioButton1.setBackground(Color.getHSBColor(color1, color1, 255));
                radioButton2.setBackground(Color.getHSBColor(color1, color1, 255));
                radioButton3.setBackground(Color.getHSBColor(color1, color1, 255));
                radioButton4.setBackground(Color.getHSBColor(color1, color1, 255));
            }
        });

        //обработчик события переключения радиокнопки 3
        radioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //меняем цвета элементов по схеме RGB
                color1 = scrollBar.getValue();
                color2 = color1;
                color3 = color1;
                Color cl = new Color(color1, color2, color3);
                panel.setBackground(cl);
                radioButton1.setBackground(cl);
                radioButton2.setBackground(cl);
                radioButton3.setBackground(cl);
                radioButton4.setBackground(cl);
            }
        });


        setSize(600,400);   //устанавливаем размер панели
        setMinimumSize(new Dimension(600,400)); //лишний код
        setPreferredSize(new Dimension(600,400));   //лишний код
        setMinimumSize(panel.getPreferredSize());   //лишний код
        setVisible(true);   //устанавливаем видимость панели



    }
}
