package be.idamf.sofa.mapper;

import java.util.Collection;

/**
 * @author Mike Seghers
 */
public abstract class AbstractBidirectionalMapper<A, B> extends AbstractMapper<A, B> implements BidirectionalMapper<A, B> {
    private AbstractMapper<B, A> inverseMapper = new AbstractMapper<B, A>() {
        @Override
        public A mapAToB(final B b) {
            return AbstractBidirectionalMapper.this.mapBToA(b);
        }
    };

    /**
     * {@inheritDoc}
     */
    @Override
    public <C extends Collection<A>> C mapCollectionOfBToCollectionOfA(Collection<B> collectionOfB, C emptyMutableCollectionOfA) {
        return inverseMapper.mapCollectionOfAToCollectionOfB(collectionOfB, emptyMutableCollectionOfA);
    }
}
