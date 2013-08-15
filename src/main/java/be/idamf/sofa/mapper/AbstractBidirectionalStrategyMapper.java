package be.idamf.sofa.mapper;

import java.util.Collection;

/**
 * Abstract mapper class, implementing the B to A mapping methods as delegation to the strategy.
 * Implementing classes must provide a default {@link StrategyMapper}. This strategy will be used when calling
 * {@link BidirectionalMapper#mapBToA(Object)}.
 *
 * @param <A> The object type A
 * @param <B> The object type B
 */
public abstract class AbstractBidirectionalStrategyMapper<A, B> extends AbstractBidirectionalMapper<A, B> implements StrategyMapper<A, B> {
    private MapperStrategy<A, B> defaultStrategy;

    /**
     * This constructor foreces implementation to always pass in a default strategy, so it can be used when {@link
     * BidirectionalMapper#mapBToA(Object)} is called.
     *
     * @param defaultStrategy the default strategy
     */
    protected AbstractBidirectionalStrategyMapper(final MapperStrategy<A, B> defaultStrategy) {
        this.defaultStrategy = defaultStrategy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public A mapBToA(final B b, final MapperStrategy<A, B> strategy) {
        return strategy.mapBToA(b);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public A mapBToA(final B b) {
        return defaultStrategy.mapBToA(b);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <C extends Collection<A>> C mapCollectionOfBToCollectionOfA(final Collection<B> collectionOfB, final C emptyMutableCollectionOfA, final MapperStrategy<A, B> strategy) {
        C result = null;
        if (collectionOfB != null) {
            result = fillCollectionOfA(collectionOfB, emptyMutableCollectionOfA, strategy);
        }
        return result;
    }

    private <C extends Collection<A>> C fillCollectionOfA(final Collection<B> collectionOfB, final C collectionOfA, final MapperStrategy<A, B> strategy) {
        for (B b : collectionOfB) {
            collectionOfA.add(strategy.mapBToA(b));
        }
        return collectionOfA;
    }
}
