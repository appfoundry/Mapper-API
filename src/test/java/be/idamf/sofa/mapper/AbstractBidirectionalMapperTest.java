package be.idamf.sofa.mapper;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.fail;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Mike Seghers
 */
public class AbstractBidirectionalMapperTest {
    private AbstractBidirectionalMapper<String, String> mapper;
    @Before
    public void setUp() throws Exception {
        mapper = new AbstractBidirectionalMapper<String, String>() {
            @Override
            public String mapBToA(String b) {
                return b + ("_to_a");
            }

            @Override
            public String mapAToB(String a) {
                fail("mapAToB should never be called");
                return null;
            }
        };
    }

    @Test
    public void test_mapListOfAToListOfB() throws Exception {
        List<String> result = mapper.mapCollectionOfBToCollectionOfA(Arrays.asList("one", "two", "three"),
                                                                     new ArrayList<String>());
        assertThat(result.size(), is(3));
        assertThat(result, hasItems("one_to_a", "two_to_a", "three_to_a"));
    }

    @Test
    public void test_mapListOfAToListOfB_nullList() throws Exception {
        List<String> result = mapper.mapCollectionOfBToCollectionOfA(null, new ArrayList<String>());
        assertThat(result, is(nullValue()));
    }

    @Test
    public void test_mapListOfAToListOfB_emptyList() throws Exception {
        List<String> result = mapper.mapCollectionOfBToCollectionOfA(Collections.<String>emptyList(),
                                                                     new ArrayList<String>());
        assertThat(result.isEmpty(), is(true));
    }
}
