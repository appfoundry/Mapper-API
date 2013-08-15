package be.idamf.sofa.mapper;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class AbstractMapperTest {
    private AbstractMapper<String, String> mapper;

    @Before
    public void setup() {
        mapper = new AbstractMapper<String, String>() {
            public String mapAToB(String a) {
                return a + "_to_b";
            }
        };
    }

    @Test
    public void test_mapListOfAtoListOfB() throws Exception {
        List<String> result = mapper.mapCollectionOfAToCollectionOfB(Arrays.asList("one", "two", "three"),
                                                                     new ArrayList<String>());
        assertThat(result.size(), is(3));
        assertThat(result, hasItems("one_to_b", "two_to_b", "three_to_b"));
    }

    @Test
    public void test_mapListOfAtoListOfB_nullList() throws Exception {
        List<String> result = mapper.mapCollectionOfAToCollectionOfB(null, new ArrayList<String>());
        assertThat(result, is(nullValue()));
    }

    @Test
    public void test_mapListOfAtoListOfB_emptyList() throws Exception {
        List<String> result = mapper.mapCollectionOfAToCollectionOfB(Collections.<String>emptyList(), new ArrayList<String>());
        assertThat(result.isEmpty(), is(true));
    }
}
