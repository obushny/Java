import javax.swing.*;
import java.awt.*;

/**
 * Created by Vet on 25.04.2017.
 */
//Класс для рисование графика
public class paintPanel extends JComponent {

    private int high;               //переменная, куда считывается высота панели для рисования
    private int width;              //переменная, куда считывается длина панели для рисования
    private int startPositionX;     //переменная начала координатs X рисования. Вообще-то она равна 0, но на будущее пусть будет.
    private int startPositionY;     //аналонично
    private int zeroX;              //координата Х начала координат графика
    private int zeroY;              //координата Y начала координат графика
    private int coordinateStep=100; //шаг графика, в пикселах. То есть это длина единицы в пикселах
    private int separatorHigh;      //размер черточки-разделителя на графике

    //свойство поля coordinateStep, для того, чтобы мы могли менять шаг координат
    public void setCoordinateStep(int step){
        set: coordinateStep=step;
    };

    //Функция, которая считывает размеры окна и задает соответствующие координаты
    public void getCoorinate(){
        high=this.getHeight();  //присваиваем переменной значение высоты
        width=this.getWidth();  //присваиваем переменной значение длины
        //System.out.println("high is "+high);
        //System.out.println("width is "+width);
    };

    ///////////////////////////////////////////////////////////////
    //функция, которую мы строим
    private float y(float x){
        return (float)(1/(0.4*Math.sqrt(2*Math.PI))*(Math.exp(-(x-1)*(x-1)/(2*0.16)    )));
        //return (float) Math.exp(x);
        //return (float)(2*Math.sin(x));
        //return (float)(Math.tan(x));
        //return (float)1/(x);
        //return (float)((x-2)*(x-2)-3);
        //return (float)((x)*(x)*(x));
    };
    //////////////////////////////////////////////////////////////




    //метод, которым мы рисуем
    public void paint(Graphics g){
        getCoorinate();                     //считываем размер окна. Считывается каждый раз при перерисовке окна
        Graphics2D g2 = (Graphics2D) g;     //создаем рисовалку
        startPositionX=0;                   //задаем начальное значение координат
        startPositionY=0;                   //задаем начальное значение координат
        zeroY=high/2;                       //график берет начало из середины экрана
        zeroX=width/2;                      //аналогично
        separatorHigh=2;                    //задаем высоту рисочки-разделителя



        //width=800;

            //Разбиваем каждую ось на две части для удобства переноса центра координат
            // Ось Y

        g2.drawLine(startPositionX,zeroY,width,zeroY);  //рисуем ось X
        g2.drawLine(zeroX,startPositionY,zeroX,high);   //рисуем ось Y
        //рисуем разделители и цифры на оси X
        for(int i=1;i<=width/2/coordinateStep;i++){     //цикл от начала координат до конца панели с шагом coordinateStep
            g2.drawLine(zeroX+i*coordinateStep,zeroY-separatorHigh,zeroX+i*coordinateStep,zeroY+separatorHigh); //рисуем на оси X в положительную сторону
            g2.drawLine(zeroX-i*coordinateStep,zeroY-separatorHigh,zeroX-i*coordinateStep,zeroY+separatorHigh); //рисуем на оси X в отрицательную сторону
            g2.drawString(Integer.toString(i),zeroX+i*coordinateStep-4,zeroY-4);    //рисуем цифры на оси х со смещением в 4 пиксела в положительную сторону
            g2.drawString(Integer.toString(-i),zeroX-i*coordinateStep-4,zeroY-4);   //аналогично рисуем цифры о отрицательную сторону
        };
        //цикл, делает то же самое, что и цикл выше, только для оси Y
        for(int i=1;i<=high/2/coordinateStep;i++){
            g2.drawLine(zeroX-separatorHigh,zeroY+i*coordinateStep,zeroX+separatorHigh,zeroY+i*coordinateStep);
            g2.drawLine(zeroX-separatorHigh,zeroY-i*coordinateStep,zeroX+separatorHigh,zeroY-i*coordinateStep);
            g2.drawString(Integer.toString(i),zeroX+4,zeroY-i*coordinateStep+4);
            g2.drawString(Integer.toString(-i),zeroX+4,zeroY+i*coordinateStep+4);
        };
        //меняем цвет, которым будем рисовать график
        g2.setColor(new Color(0,255,0));
        //задаем начальные координаты X и Y и сами переменные X и Y
        float xPrev=-width/2/coordinateStep;        //переменная с предыдущим значением X
        int coordinateXPrev=startPositionX;         //переменная с предыдущей координатой Х. Изначально это самая левая точка
        float yPrev=y(xPrev);                       //переменная с предыдущим значением Y
        int coordinateYPrev=zeroY-(int)yPrev*coordinateStep;        //Переменная с предыдущим значением Y.
        float xCurr=xPrev;                          //переменная текущим значением X
        int coordinateXCurr=0;                      //переменная с текущим значением координаты X
        float yCurr=yPrev;                          //переменная с текущим значением Y
        int coordinateYCurr=coordinateYPrev;        //переменная с текущим значением координаты Y

        //try{
        //цикл пробегает каждый пиксель вдоль оси X, находит значение координат новой точке (X,Y) и соединяет
        //его ее линией с предыдущей построенной точкой.
        for(int i=1;i<width;i++){

           g2.drawLine(coordinateXPrev,coordinateYPrev,coordinateXCurr,coordinateYCurr);        //соединяем предыдущую точку с текущей
            xPrev=xCurr;            //после отрисовки линии присваиваем предыдущему значению X значение текущего X
            yPrev=yCurr;            //после отрисовки линии присваиваем предыдущему значению Y значение текущего Y
            coordinateXPrev=coordinateXCurr;        //после отрисовки линии присваиваем предудущей точке значение текущей точки
            coordinateYPrev=coordinateYCurr;        //после отрисовки линии присваиваем предудущей точке значение текущей точки
            xCurr=-(float)width/2/(float)coordinateStep+(float)i/(float)coordinateStep;     //меняем значение текущего X
            yCurr=y(xCurr);     //меняем значение текущего Y
            coordinateXCurr=i;      //задаем текущее значение координаты X
            coordinateYCurr=(int)(zeroY-y(xCurr)*(float)coordinateStep);        //Задаем текущее значение координаты Y;
            System.out.println("coordinate x is "+coordinateXCurr+" coordinate y is "+coordinateYCurr);     //эти строчки для отладки
            System.out.println("x is "+xCurr+" y is "+yCurr);       //эти строчки для отладки
        }

    }
}
