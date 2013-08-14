package be.idamf.sofa.mapper;

/**
 * Mapper strategy. A strategy is defined to decide what parts of an entity get mapped to the value
 * object (to avoid unnecessary data loading).
 * 
 * @param <V> The value object type
 * @param <E> The entity type
 */
public interface MapperStrategy<V, E> {
    /**
     * Map the entity to a value object, with a certain strategy in mind.
     * 
     * @param e the entity
     * @return the mapped value object
     */
    V mapToValueObject(E e);
}
