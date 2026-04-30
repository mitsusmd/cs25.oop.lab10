import java.util.ArrayList;
import java.util.List;

class Animal {
    private String name;
    public Animal(String name) { this.name = name; }
    @Override
    public String toString() { return name; }
}

public class Zoo<T extends Animal> {
    // Төрлийн аюулгүй байдлыг хангасан шилжүүлэг
    public void transferAnimals(List<? extends T> source, List<? super T> destination) {
        for (T animal : source) {
            destination.add(animal);
        }
    }

    public static void main(String[] args) {
        Zoo<Animal> myZoo = new Zoo<>();
        List<Animal> source = new ArrayList<>();
        source.add(new Animal("Arslan"));
        source.add(new Animal("Togruu"));
        
        List<Animal> destination = new ArrayList<>();
        myZoo.transferAnimals(source, destination);
        
        // Гаралт: Arslan, Togruu
        for (int i = 0; i < destination.size(); i++) {
            System.out.print(destination.get(i) + (i < destination.size() - 1 ? ", " : ""));
        }
    }
}