package Animals;

/**
 * Created by Vet on 19.03.2017.
 */
//Класс кошки, являющийся потомком от Кошачьи
public class Cats extends Felidae {
    public void cry()
    {
        System.out.println("Meaou"+":cat say");//переопределяем метод cry, определеннй в родительском для всех классе Млекопитающиеся
    }
}
