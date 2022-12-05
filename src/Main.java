import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random=new Random();
        LinkedList<Animals> animals = new LinkedList<>();
        LinkedList<Animals> cats = new LinkedList<>();

        for (int i = 0; i < 50; i++) {
            animals.add(new Cat(random.nextInt(1, 5)));
            animals.add(new Dog(random.nextInt(1, 7)));
            Collections.shuffle(animals);
        }

        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getClass().equals(Cat.class)) {
                animals.remove(i);
                i += 4;
            }
        }
        int counter = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getClass().equals(Dog.class)) {
                counter++;
                if (counter == 4) {
                    animals.add(i, new Mouse(random.nextInt(1, 3)));
                    counter = 0;
                }
            }
        }
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i).getClass().equals(Mouse.class)) {
                    i--;
                    if (animals.get(i).getClass().equals(Cat.class)) {
                        cats.add(animals.get(i));
                        animals.remove(i);
                    }
                    i += 2;
                    if (animals.get(i).getClass().equals(Cat.class)) {
                        cats.add(animals.get(i));
                        animals.remove(i);
                    }
                }
            }
        }
        ArrayList<Animals> animalsArray = new ArrayList<>(animals);

        int ages = 0;
        for (Animals animals1 : animalsArray) {
            ages += animals1.getAge();
        }
        System.out.println("All animals \n"+animalsArray);
        System.out.println("Cats:\n"+cats);
        System.out.println("The total amount of the animals: " + ages);
    }
}