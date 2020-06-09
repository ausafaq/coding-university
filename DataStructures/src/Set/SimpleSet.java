package Set;

import java.util.Iterator;

public interface SimpleSet {

    // Add the element to the set if not present
    boolean add(Object element);

    // Remove the element from the set if present
    boolean remove(Object element);

    // Remove true if the set contains the element
    boolean contains(Object element);

    // Returns the iterator over the elements in the set
    Iterator iterator();

    // Size of the set
    int size();

}
