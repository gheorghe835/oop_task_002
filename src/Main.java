import market.Market;
import market.Person;

public class Main {
    public static void main(String[] args) {

       Market market = new Market();
        Person person1 = new Person("Monika");
        Person person2 = new Person("Egor");
        Person person3 = new Person("David");

        market.enqueue(person1);
        market.enqueue(person2);
        market.enqueue(person3);

        market.update();
        
    }
}