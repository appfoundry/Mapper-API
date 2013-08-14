package be.idamf.sofa.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import be.idamf.sofa.mapper.AbstractStrategyMapper;
import be.idamf.sofa.mapper.MapperStrategy;

@RunWith(JUnit4.class)
public class AbstractStrategyMapperTest {
    //SUT
    private AbstractStrategyMapper<String, String> mapper;

    //Mock
    private MapperStrategy<String, String> defaultStrategy;

    @Before
    public void setup() {
        defaultStrategy = Mockito.mock(MapperStrategy.class);
        mapper = new AbstractStrategyMapper<String, String>() {

            @Override
            public MapperStrategy<String, String> getDefaultStartegy() {
                return defaultStrategy;
            }

            public String mapToEntity(String vo) {
                return "e";
            }

        };
    }

    @Test
    public void testMapToValueObject() {
        String expected = "strategyResult";
        Mockito.when(defaultStrategy.mapToValueObject("entity")).thenReturn(expected);
        String actual = mapper.mapToValueObject("entity");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapToValueObjectWithStrategy() {
        String expected = "strategyResult";
        Mockito.when(defaultStrategy.mapToValueObject("entity")).thenReturn(expected);
        String actual = mapper.mapToValueObject("entity", defaultStrategy);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public final void testMapToValueObjectsWithStrategy() {
        List<String> expected = new ArrayList<String>();
        expected.add("strategyResult");

        List<String> entities = new ArrayList<String>();
        entities.add("entity");

        Mockito.when(defaultStrategy.mapToValueObject("entity")).thenReturn("strategyResult");

        List<String> actual = mapper.mapToValueObjects(entities, defaultStrategy);

        Assert.assertEquals(expected, actual);
    }
}
