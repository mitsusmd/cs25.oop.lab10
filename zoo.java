import java.util.List;

public class Zoo<T extends Animal> {
    // source-оос destination руу бүх амьтдыг шилжүүлэх [cite: 8]
    public void transferAnimals(List<? extends T> source, List<? super T> destination) {
        for (T animal : source) {
            destination.add(animal); // Төрлийн аюулгүй байдлыг хангана [cite: 9]
        }
        source.clear();
    }
}