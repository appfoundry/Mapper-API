package be.idamf.sofa.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static junit.framework.Assert.fail;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AbstractBidirectionalStrategyMapperTest {
    private AbstractBidirectionalStrategyMapper<String, String> mapper;

    @Mock
    private MapperStrategy<String, String> strategy;

    @Before
    public void setUp() {
        mapper = new AbstractBidirectionalStrategyMapper<String, String>(strategy) {


            @Override
            public String mapAToB(String s) {
                fail("should never be called in these tests");
                return null;
            }
        };
    }

    @Test
    public void test_mapBToA_usingStrategy() throws Exception {
        when(strategy.mapBToA("one")).thenReturn("two");

        String result = mapper.mapBToA("one", strategy);
        assertThat(result, is("two"));
    }

    @Test
    public void test_mapBToA_defaultStrategy() throws Exception {
        when(strategy.mapBToA("one")).thenReturn("three");

        String result = mapper.mapBToA("one");
        assertThat(result, is("three"));
    }

    @Test
    public void test_mapCollectionOfBToCollectionOfA_usingStrategy() throws Exception {
        when(strategy.mapBToA(anyString())).thenReturn("strat_one", "strat_two", "strat_three");
        List<String> result = mapper.mapCollectionOfBToCollectionOfA(Arrays.asList("one", "two", "three"), new ArrayList<String>(), strategy);
        assertThat(result.size(), is(3));
        assertThat(result, hasItems("strat_one", "strat_two", "strat_three"));
    }

    @Test
    public void test_mapCollectionOfBToCollectionOfA_defaultStrategy() throws Exception {
        when(strategy.mapBToA(anyString())).thenReturn("strat_one", "strat_two", "strat_three");
        List<String> result = mapper.mapCollectionOfBToCollectionOfA(Arrays.asList("one", "two", "three"), new ArrayList<String>());
        assertThat(result.size(), is(3));
        assertThat(result, hasItems("strat_one", "strat_two", "strat_three"));
    }

    @Test
    public void test_mapCollectionOfBToCollectionOfA_collectionOfBIsNull() throws Exception {
        List<String> result = mapper.mapCollectionOfBToCollectionOfA(null, new ArrayList<String>(), strategy);
        assertThat(result, is(nullValue()));
    }

}
