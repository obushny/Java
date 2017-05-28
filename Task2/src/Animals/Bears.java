package Animals;

/**
 * Created by Vet on 19.03.2017.
 */
//класс Медведи, являющийся потомком от Хищники
public class Bears extends Carnivora{
    public void cry()
    {
        System.out.println("Grrrrr!"+": bear say");//переопределяем метод cry, определеннй в родительском для всех классе Млекопитающиеся

    }
}
