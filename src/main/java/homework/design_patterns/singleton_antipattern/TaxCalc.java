package homework.design_patterns.singleton_antipattern;

import lombok.AllArgsConstructor;

/**
 * @author Evgeny Borisov
 */
@AllArgsConstructor
public class TaxCalc {

    private NdsResolver ndsResolver;


    public double withNds(double price) {
        return ndsResolver.getNds() * price + price;
    }


}
