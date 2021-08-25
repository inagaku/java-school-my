package homework.design_patterns.adapter;

import homework.utils.RandomUtil;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Evgeny Borisov
 */
public class ProductRepo {

    private List<Supplier<? extends Costable>> products = List.of(Chair::new,Table::new);

    public Costable getProduct() {
        return RandomUtil.getRandomElement(products).get();
    }
}
