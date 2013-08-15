package be.idamf.sofa.mapper;

import java.util.Collection;

/**
 * Mapper interface defining operations to map B to A objects, using strategies, while the A to B mapping does not need a strategy.
 * This interface extends the {@link BidirectionalMapper} interface, so implementations should also provide a default
 * selected strategy, which should be used when calling the {@link BidirectionalMapper#mapBToA(Object)} method.
 *
 * @param <A> The value object type
 * @param <B> The entity type
 */
public interface StrategyMapper<A, B> extends BidirectionalMapper<A, B> {
    /**
     * Map an object of type B to an object of type A, using a given strategy.
     *
     * @param b        the object of type B
     * @param strategy the strategy
     * @return an object of type A
     */
    A mapBToA(final B b, final MapperStrategy<A, B> strategy);

    /**
     * Maps a collection of objects of type B to a collection of objects of type A, using a strategy.
     *
     * @param collectionOfB the collection of objects of type B
     * @param strategy      the strategy
     * @return a collection of objects of type A
     */
    <C extends Collection<A>> C mapCollectionOfBToCollectionOfA(Collection<B> collectionOfB, C emptyMutableCollectionOfA, MapperStrategy<A, B> strategy);
}
