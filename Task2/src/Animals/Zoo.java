package Animals;

/**
 * Created by Vet on 19.03.2017.
 */
public class Zoo {
    public static void main(String[] args) {

        Cats a = new Cats();
        Cats b = new Cats();
        Dogs c = new Dogs();
        Bears d = new Bears();
        //создаем массив бизовых классов Млекопитающиеся и присваиваем значения различных потомков
        Mammals[] x= new Mammals[4];
        x[0]=a;
        x[1]=b;
        x[2]=c;
        x[3]=d;
        //вызываем метод cry для всех Млекопитающих в Зоопарке
        for(int i=0;i<4;i++)
        {
            x[i].cry();
        }

    }

}
