package itcast.day25;

public interface Food {
    enum Coffe implements Food{
        BLACK_COFFEE, DECAF_COFFF
    }
    enum Dessert implements Food{
        FRUIT, CAKE, GELATO
    }
}
