package be.idamf.sofa.mapper;

/**
 * Mapper strategy. A strategy is defined to decide what parts of an object of type B gets mapped to an object of type
 * A.
 * This is useful in situations where the mapping of an object depends on the context in which it is mapped.
 *
 * @param <A> the source object type
 * @param <B> the destination object type
 */
public interface MapperStrategy<A, B> {
    /**
     * Map an object of type B to an object of type A.
     *
     * @param b the object of type B
     * @return an object of type A
     */
    A mapBToA(B b);
}
