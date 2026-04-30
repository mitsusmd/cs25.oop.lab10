import java.util.List;
import java.util.function.*;

public class StringProcessor {
    public void processStrings(List<String> strings, Predicate<String> filter, 
                               Function<String, String> transformer, Consumer<String> action) {
        for (String s : strings) {
            if (filter.test(s)) { // 5 тэмдэгтээс урт үгсийг шүүх [cite: 21]
                String result = transformer.apply(s); // Үгсийг урвуулах [cite: 22]
                action.accept(result); // "ГАРШИЛ: " угтвартай хэвлэх [cite: 23]
            }
        }
    }
}