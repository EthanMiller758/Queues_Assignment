package Queues;

import java.util.LinkedList;
import java.util.Queue;

class AnimalShelter {
    private static class Animal {
        String name;
        int arrivalTime;

        Animal(String name) {
            this.name = name;
        }
    }

    private Queue<Animal> catQueue = new LinkedList<>();
    private Queue<Animal> dogQueue = new LinkedList<>();
    private int arrivalTime = 0;

    public void enqueue(Animal animal) {
        animal.arrivalTime = arrivalTime++;
        if (animal.name.equals("Cat")) {
            catQueue.offer(animal);
        } else if (animal.name.equals("Dog")) {
            dogQueue.offer(animal);
        }
    }

    public Animal dequeueAny() {
        if (catQueue.isEmpty()) {
            return dogQueue.poll();
        } else if (dogQueue.isEmpty()) {
            return catQueue.poll();
        } else {
            return (catQueue.peek().arrivalTime < dogQueue.peek().arrivalTime)
                    ? catQueue.poll()
                    : dogQueue.poll();
        }
    }

    public Animal dequeueCat() {
        return catQueue.poll();
    }

    public Animal dequeueDog() {
        return dogQueue.poll();
    }

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(new Animal("Cat"));
        shelter.enqueue(new Animal("Dog"));
        shelter.enqueue(new Animal("Cat"));
        shelter.enqueue(new Animal("Dog"));

        System.out.println("Adopted animal: " + shelter.dequeueAny().name);
        System.out.println("Adopted cat: " + shelter.dequeueCat().name);
        System.out.println("Adopted dog: " + shelter.dequeueDog().name);
    }
}
