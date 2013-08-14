package be.idamf.sofa.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract mapper class, implementing the {@link Mapper#mapToValueObjects(List)} and {@link Mapper#mapToEntities(List)}
 * methods by just iterating the list and calling the {@link Mapper#mapToValueObject(Object)} or
 * {@link Mapper#mapToEntity(Object)} respectively.
 * 
 * @param <V> The value object type
 * @param <E> The entity type
 */
public abstract class AbstractMapper<V, E> implements Mapper<V, E> {
    /**
     * {@inheritDoc}
     */
    public final List<V> mapToValueObjects(final List<E> entities) {
        List<V> valueObjects = null;
        if (entities != null) {
            valueObjects = new ArrayList<V>(entities.size());
            for (E e : entities) {
                valueObjects.add(mapToValueObject(e));
            }
        }
        return valueObjects;
    }

    /**
     * {@inheritDoc}
     */
    public final List<E> mapToEntities(final List<V> valueObjects) {
        List<E> entities = null;
        if (valueObjects != null) {
            entities = new ArrayList<E>(valueObjects.size());
            for (V vo : valueObjects) {
                entities.add(mapToEntity(vo));
            }
        }
        return entities;
    }
}
