package market;

import java.util.LinkedList;
import java.util.Queue;



public class Market implements QueueBehaviour, MarketBehaviour{
    private Queue<Person> queue;
    private Queue<Person> insideMarket;

    public Market() {
        this.queue = new LinkedList<>();
        this.insideMarket = new LinkedList<>();
    }

    // QueueBehaviour interface methods
    @Override
    public void enqueue(Person person) {
        queue.add(person);
        System.out.println(person + " joined the queue.");   
    }

    @Override
    public Person dequeue() {
        Person person = queue.poll();
        if (person != null) {
            System.out.println(person + " got out of the queue.");
        }
        return person;
    }

    @Override
    public int size() {
        return queue.size();
    }

    // MarketBehaviour interface methods
    @Override
    public void enterMarket(Person person) {
        insideMarket.add(person);
        System.out.println(person + " walked into the shop.");
    }

    @Override
    public void exitMarket(Person person) {
        if (insideMarket.remove(person)) {
            System.out.println(person + " walked out of the shop.");
        }
    }

    @Override
    public void update() {
        System.out.println("Updating the status of the shop...");
        while (!queue.isEmpty()) {
            Person person = dequeue();
            if (person != null) {
                enterMarket(person);
                // Simulation of receiving and giving orders
                System.out.println(person + " shops.");
                exitMarket(person);
            }
        }
        System.out.println("Shop status updated.");


    }
}
