import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name, category;
    private double price;
    public Product(String n, String c, double p) { name = n; category = c; price = p; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    @Override
    public String toString() { return name + " (" + (int)price + ")"; }
}

public class ProductAnalyzer {
    public static void main(String[] args) {
        List<Product> products = List.of(
            new Product("GUtal", "Huvtsas", 1500),
            new Product("Tsamts", "Huvtsas", 1200),
            new Product("Oims", "Huvtsas", 500)
        );

        Map<String, List<Product>> result = products.stream()
            .filter(p -> p.getPrice() > 1000) // 1000₮-с дээш[cite: 1]
            .sorted(Comparator.comparing(Product::getPrice).reversed()) // Буурах эрэмбэ[cite: 1]
            .collect(Collectors.groupingBy(Product::getCategory)); // Категориор нэгтгэх[cite: 1]

        // Гаралт: Хувцас: [Гутал (1500), Цамц (1200)][cite: 1]
        result.forEach((cat, list) -> System.out.println(cat + ": " + list));
    }
}