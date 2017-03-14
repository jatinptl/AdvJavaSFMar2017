package generics;

public class PairOfClothing<T extends Colored & Sized> extends Pair<T> {

    public PairOfClothing(T left, T right) {
        super(left, right);
    }

    public boolean isMatched() {
        return getLeft().getColor().equals(getRight().getColor())
                && getLeft().getSize() == getRight().getSize();
    }

}
