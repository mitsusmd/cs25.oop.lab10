import java.util.*;
import java.util.stream.Collectors;

public class ProductAnalyzer {
    public Map<String, List<Product>> analyze(List<Product> products) {
        return products.stream()
            .filter(p -> p.getPrice() > 1000) // 1000₮-с дээш бүтээгдэхүүн [cite: 30]
            .sorted(Comparator.comparing(Product::getPrice).reversed()) // Үнэ буурахаар эрэмбэлэх [cite: 31]
            .collect(Collectors.groupingBy(Product::getCategory)); // Категориор нэгтгэх [cite: 32]
    }
}