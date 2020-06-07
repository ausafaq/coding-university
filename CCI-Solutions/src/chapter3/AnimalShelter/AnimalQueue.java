package chapter3.AnimalShelter;

import java.util.LinkedList;

public class AnimalQueue {

    private LinkedList<Dog> dogs;
    private LinkedList<Cat> cats;
    private static int order = 0; // acts as timestamp

    public AnimalQueue() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }

    public void enqueue(Animal animal) {
        /**
         * Using order to maintain the insertion order
         */
        animal.setOrder(order);
        order++;
        if(animal instanceof Dog) dogs.addLast((Dog) animal);
        else if(animal instanceof Cat) cats.addLast((Cat) animal);
    }

    public Animal dequeueAny() {
        if(dogs.size() == 0) {
            dequeueCats();
        } else if (cats.size() == 0) {
            dequeueDogs();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlderThan(cat)) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Cat dequeueCats() {
        return cats.poll();
    }


}
