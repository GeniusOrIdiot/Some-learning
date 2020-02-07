package design_pattern.factory;

/**
 * @author LiuYJ
 * @since 2020/2/7
 */
public class FruitFactory {

    public <T extends Fruit> T make(Class<T> clz) {
        try {
            return clz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Make fruit failed: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        FruitFactory fruitFactory = new FruitFactory();

        Peach peach = fruitFactory.make(Peach.class);
        peach.name();

        Apple apple = fruitFactory.make(Apple.class);
        apple.name();
    }
}
