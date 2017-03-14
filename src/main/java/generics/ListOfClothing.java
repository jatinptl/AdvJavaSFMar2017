package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.UnaryOperator;

public class ListOfClothing<E extends Colored & Sized> implements List<E> {

    // DELEGATION example, incomplete, but illustrative
    private List<E> theList = new ArrayList<>();

    public boolean itemsAreValid(int idx1, int idx2) {
//        return theList.get(idx1).getColor().equ...
        return true;
    }

    @Override
    public int size() {
        return theList.size();
    }

    @Override
    public boolean isEmpty() {
        return theList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return theList.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return theList.iterator();
    }

    @Override
    public Object[] toArray() {
        return theList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return theList.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return theList.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return theList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return theList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return theList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return theList.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return theList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return theList.retainAll(c);
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        theList.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        theList.sort(c);
    }

    @Override
    public void clear() {
        theList.clear();
    }

    @Override
    public boolean equals(Object o) {
        return theList.equals(o);
    }

    @Override
    public int hashCode() {
        return theList.hashCode();
    }

    @Override
    public E get(int index) {
        return theList.get(index);
    }

    @Override
    public E set(int index, E element) {
        return theList.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        theList.add(index, element);
    }

    @Override
    public E remove(int index) {
        return theList.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return theList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return theList.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return theList.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return theList.listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return theList.subList(fromIndex, toIndex);
    }

    @Override
    public Spliterator<E> spliterator() {
        return theList.spliterator();
    }

}
