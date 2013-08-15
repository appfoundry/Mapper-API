package be.idamf.sofa.mapper;

import java.util.Collection;

/**
 * A bidirectional mapper is able to map from A to B and vice versa.
 *
 * @author Mike Seghers
 */
public interface BidirectionalMapper<A, B> extends Mapper<A, B> {
    /**
     * Map an object of type B to an object of type A.
     *
     * @param b the object of type B
     * @return an object of type A
     */
    A mapBToA(B b);

    /**
     * Map a collection of objects of type B to a collection of objects of type A.
     *
     * @param collectionOfB             the collection of objects of type B
     * @param emptyMutableCollectionOfA an instance of the collection of objects of type A, which will be filled up
     * @param <C>                       The type of the resulting collection
     * @return a collection of objects of type A
     */
    <C extends Collection<A>> C mapCollectionOfBToCollectionOfA(Collection<B> collectionOfB, C emptyMutableCollectionOfA);
}
