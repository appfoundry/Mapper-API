package be.idamf.sofa.mapper;

import java.util.List;

/**
 * Mapper interface defining operations to map an entity to value object and vice versa.
 * 
 * @param <V> The value object type
 * @param <E> The entity type
 */
public interface Mapper<V, E> {
    /**
     * Map a value object to an entity.
     * 
     * @param vo the value object.
     * @return The entity object
     */
    E mapToEntity(V vo);

    /**
     * Map an entity to a value object.
     * 
     * @param e the entity to be mapped to a value object
     * @return the value object
     */
    V mapToValueObject(E e);

    /**
     * Maps a list of value objects to a list of entities.
     * 
     * @param valueObjects the value object list to be mapped
     * @return a list of mapped entities. If the valueObjects list is empty, the returned list will also be empty. Null
     *         is returned when valueObjects is null.
     */
    List<E> mapToEntities(final List<V> valueObjects);

    /**
     * Map all entities to value objects.
     * 
     * @param entities the entities to be mapped to value objects
     * @return the list of value object. If the entities list is empty, the returned list will also be empty. Null
     *         is returned when entities is null.
     */
    List<V> mapToValueObjects(List<E> entities);
}
