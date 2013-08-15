package be.idamf.sofa.mapper;

import java.util.Collection;

/**
 * Abstract mapper class, implementing the {@link Mapper#mapCollectionOfAToCollectionOfB(java.util.Collection,
 * java.util.Collection)}
 * method by just iterating the list and calling the {@link Mapper#mapAToB(Object)}.
 *
 * @param <A> object type A
 * @param <B> object type B
 */
public abstract class AbstractMapper<A, B> implements Mapper<A, B> {

    /**
     * {@inheritDoc}
     */
    @Override
    public <C extends Collection<B>> C mapCollectionOfAToCollectionOfB(final Collection<A> collectionOfA, final C emptyMutableCollectionOfB) {
        C result = null;
        if (collectionOfA != null) {
            result = fillCollectionOfB(collectionOfA, emptyMutableCollectionOfB);
        }
        return result;
    }

    private <C extends Collection<B>> C fillCollectionOfB(final Collection<A> collectionOfA, final C emptyMutableCollectionOfB) {
        for (A a : collectionOfA) {
            emptyMutableCollectionOfB.add(this.mapAToB(a));
        }
        return emptyMutableCollectionOfB;
    }
}
