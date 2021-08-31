package real_spring;

import homework.utils.RandomUtil;

/**
 * @author Evgeny Borisov
 */
public class IntegerFactory  {
    public Integer randomInt() throws Exception {
        return RandomUtil.between(100,1200);
    }


}
