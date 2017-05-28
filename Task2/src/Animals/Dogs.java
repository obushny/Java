package Animals;

/**
 * Created by Vet on 19.03.2017.
 */
//Класс собаки, являющийся потомком от Хищников
public class Dogs extends Carnivora {
    public void cry()
    {
        System.out.println("Arf-arf!"+": dog say");//переопределяем метод cry, определеннй в родительском для всех классе Млекопитающиеся
    }
}
