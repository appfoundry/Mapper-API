package be.idamf.sofa.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract mapper class, implementing the entity to value object mapping methods as delegation to the strategy.
 * Implementing classes must provide a default {@link StrategyMapper}. This strategy will be used when calling
 * {@link Mapper#mapToValueObject(Object)}.
 * 
 * @param <V> The value object type
 * @param <E> The entity type
 */
public abstract class AbstractStrategyMapper<V, E> extends AbstractMapper<V, E> implements StrategyMapper<V, E> {

    /**
     * {@inheritDoc}
     */
    public final V mapToValueObject(final E e) {
        return mapToValueObject(e, getDefaultStartegy());
    }

    /**
     * {@inheritDoc}
     */
    public final V mapToValueObject(final E e, final MapperStrategy<V, E> strategy) {
        return strategy.mapToValueObject(e);
    }

    /**
     * {@inheritDoc}
     */
    public final List<V> mapToValueObjects(final List<E> entities, final MapperStrategy<V, E> strategy) {
        List<V> valueObjects = new ArrayList<V>(entities.size());
        for (E e : entities) {
            valueObjects.add(mapToValueObject(e, strategy));
        }
        return valueObjects;
    }

    /**
     * Get the default mapping strategy. This strategy will be used when calling {@link Mapper#mapToValueObject(Object)}
     * 
     * @return the default mapping strategy
     */
    public abstract MapperStrategy<V, E> getDefaultStartegy();
}
