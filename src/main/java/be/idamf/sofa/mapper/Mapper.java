package be.idamf.sofa.mapper;

import java.util.Collection;

/**
 * A Mapper is capable of mapping an object of type A to an object of type B.
 *
 * @param <A> object type A
 * @param <B> object type B
 */
public interface Mapper<A, B> {
    /**
     * Map an object of type A to an object of type B.
     *
     * @param a the object of type A
     * @return an object of type B
     */
    B mapAToB(A a);

    /**
     * Map a collection of objects of type A to a collection of objects of type B.
     *
     * @param collectionOfA             the collection of objects of type A
     * @param emptyMutableCollectionOfB an instance of the collection of objects of type B, which will be filled up
     * @param <C>                       The type of the resulting collection
     * @return a collection of objects of type B
     */
    <C extends Collection<B>> C mapCollectionOfAToCollectionOfB(Collection<A> collectionOfA, C emptyMutableCollectionOfB);
}
