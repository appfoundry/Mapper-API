package be.idamf.sofa.mapper;

import java.util.List;

/**
 * Mapper interface defining operations to map an entity to a value object and vice versa, using strategies. This
 * interface extends the {@link Mapper} interface, so implementations could (and should) also provide a default selected
 * strategy, which should be used when calling the {@link Mapper#mapToValueObject(Object)} method.
 * 
 * @param <V> The value object type
 * @param <E> The entity type
 */
public interface StrategyMapper<V, E> extends Mapper<V, E> {
    /**
     * Map an entity to a value object, using a given strategy.
     * 
     * @param e the entity
     * @param strategy the strategy
     * @return the value object
     */
    V mapToValueObject(final E e, final MapperStrategy<V, E> strategy);

    /**
     * Maps a list of entities to a list of value objects, using a strategy.
     * 
     * @param entities the entity list to be mapped
     * @param strategy the strategy
     * @return a list of mapped value objects.
     */
    List<V> mapToValueObjects(final List<E> entities, final MapperStrategy<V, E> strategy);
}
