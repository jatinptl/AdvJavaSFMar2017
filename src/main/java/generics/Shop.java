package generics;

import java.awt.Color;

public class Shop {
    public static void main(String[] args) {
        PairOfClothing<Shoe> ps = new PairOfClothing<>(new Shoe(Color.RED, 10), new Shoe(Color.RED, 10));
        PairOfClothing<Shoe> ps2 = new PairOfClothing<>(new Shoe(Color.BLACK, 10), new Shoe(Color.RED, 10));
        
    }
}
