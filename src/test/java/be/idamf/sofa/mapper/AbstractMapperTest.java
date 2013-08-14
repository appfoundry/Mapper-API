package be.idamf.sofa.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import be.idamf.sofa.mapper.AbstractMapper;

@RunWith(JUnit4.class)
public class AbstractMapperTest {
    //SUT
    protected AbstractMapper<String, String> mapper;

    @Before
    public void setup() {
        mapper = new AbstractMapper<String, String>() {

            public String mapToEntity(String vo) {
                return "e";
            }

            public String mapToValueObject(String e) {
                return "vo";
            }

        };
    }

    @Test
    public final void testMapToEntities() {
        List<String> valueObjects = new ArrayList<String>();
        valueObjects.add("valueObject");

        List<String> expected = new ArrayList<String>();
        expected.add("e");

        List<String> actual = mapper.mapToEntities(valueObjects);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public final void testMapToEntitiesNull() {
        List<String> actual = mapper.mapToEntities(null);
        Assert.assertNull(actual);
    }

    @Test
    public final void testMapToValueObjects() {
        List<String> entities = new ArrayList<String>();
        entities.add("entity");

        List<String> expected = new ArrayList<String>();
        expected.add("vo");

        List<String> actual = mapper.mapToValueObjects(entities);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public final void testMapToValueObjectsNull() {
        List<String> actual = mapper.mapToValueObjects(null);
        Assert.assertNull(actual);
    }

}
