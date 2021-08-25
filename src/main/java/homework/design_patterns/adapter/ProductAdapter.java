package homework.design_patterns.adapter;

import lombok.experimental.Delegate;

@Delegate
public class ProductAdapter implements Costable, Pricable{

    public static Costable pricableToCostable(Pricable product) {
        new Costable()
    }

}
