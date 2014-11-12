import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Collections;

/**
 * An implementation of the FunctionalSortedSet interface that uses an ArrayList
 * as the backing data structure.
 *
 * @author Joe Rossi, Tommy Ristau
 * @version 1.0
 * @param <E> A comparable object that is contained within this sorted set.
 */
public class MySortedSet<E extends Comparable<? super E>>
    implements FunctionalSortedSet<E> {

    private ArrayList<E> list;
    private Comparator<E> c;

    /**
     * Creates a MySortedSet using the Comparable's compareTo as Comparator
     */
    public MySortedSet() {
        this(null);
    }


    /**
     * Creates a MySortedSet using a specific Comparator
     *
     * @param c a Comparator that either "has" or "is" one int valued method
     */
    public MySortedSet(Comparator<E> c) {
        this.c = c;
        list = new ArrayList<E>();
    }

    //-----------FunctionalSortedSet METHODS - ONLY MODIFY filter!!------------

    @Override
    public MySortedSet<E> filter(Predicate<E> p) {
        MySortedSet<E> returnStructure = new MySortedSet();
        for (E anObject : list) {
            if (p.test(anObject)) {
                returnStructure.add(anObject);
            }
        }
        return returnStructure;
    }

    @Override
    public MySortedSet<E> sort(Comparator<E> comparator) {
        MySortedSet<E> ret = new MySortedSet<E>(comparator);
        ret.addAll(this.list);
        return ret;
    }

    //------SortedSet METHODS - ONLY MODIFY subSet and tailSet!!---------------

    @Override
    public Comparator<? super E> comparator() {
        return c;
    }

    @Override
    public E first() {
        return list.get(0);
    }

    /**
     * Returns a MySortedSet object with all elements [first, toElement) using a
     * functional programming expression.
     *
     * @param toElement The element the returned set should stop before.
     * @return A sorted set containing elements strictly less than toElement.
     */
    @Override
    public MySortedSet<E> headSet(E toElement) {
        return list.subList(0, list.indexOf(toElement)).stream().collect(
                            Collectors.toCollection(() -> new MySortedSet<>(c)));
    }

    /**
     * Return a MySortedSet object with all elements [fromElement, toElement)
     * using a functional programming expression.
     *
     * @param fromElement The first element the returned set should contain.
     * @param toElement The element the returned set should stop before.
     * @return A sorted set containing elements fromElement to toElement.
     */
    @Override
    public MySortedSet<E> subSet(E fromElement, E toElement) {
        // TODO
        return list.subList(list.indexOf(fromElement) , list.indexOf(toElement)).stream().collect(
                            Collectors.toCollection(() -> new MySortedSet<>(c)));
    }

    /**
     * Return a MySortedSet object with all elements [fromElement, last]
     * using a functional programming expression.
     *
     * @param fromElement The first element the returned set should contain.
     * @return A sorted set containing elements fromElement and onwards.
     */
    @Override
    public MySortedSet<E> tailSet(E fromElement) {
        // TODO
        return list.subList(list.indexOf(fromElement) , list.size() - 1).stream().collect(
                            Collectors.toCollection(() -> new MySortedSet<>(c)));
    }

    @Override
    public E last() {
        return list.get(list.size() - 1);
    }

    //-----------Set METHODS - TODO---------------------------------------------

    @Override
    public boolean add(E e) {
        if (list.contains(e)) {
            return false;
        }
        boolean answer = list.add(e);
        Collections.sort(list, c);
        return answer;
    }

    @Override
    public boolean remove(Object e) {
        // TODO
        return list.remove(e);
    }

    @Override
    public boolean contains(Object e) {
        // TODO
        return list.contains(e);
    }

    @Override
    public boolean containsAll(Collection<?> col) {
        // TODO
        return list.containsAll(col);
    }

    @Override
    public boolean isEmpty() {
        // TODO
        return list.isEmpty();
    }

    @Override
    public int size() {
        // TODO
        return list.size();
    }

    @Override
    public boolean addAll(Collection<? extends E> col) {
        // TODO
        boolean answer = list.addAll(col);
        Collections.sort(list, c);
        return answer;
    }

    @Override
    public boolean removeAll(Collection<?> col) {
        // TODO
        return list.removeAll(col);
    }

    @Override
    public boolean retainAll(Collection<?> col) {
        // TODO
        return list.retainAll(col);
    }

    @Override
    public Iterator<E> iterator() {
        // TODO
        return list.iterator();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Object[] toArray() {
        // TODO
        return list.toArray();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        // TODO
        return list.toArray(a);
    }

    @Override
    public String toString() {
        // TODO
        String output = "";
        for (E anObject : list) {
            output += anObject.toString() + "\n";
        }
        return output;
    }
}
