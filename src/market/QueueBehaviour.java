package market;

public interface QueueBehaviour {
    void enqueue(Person person);
    Person dequeue();
    int size();
}
