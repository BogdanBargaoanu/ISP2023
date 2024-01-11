package isp.lab11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Radu Miron
 */
public class ExampleStreamsTest {

    @Test
    public void testFindEmployedPersons() {

    }

    @Test
    public void testFindAllPersonsByLastName() {

    }

    @Test
    public void testFindTheFirstPersonByFirstName() {

    }

    @Test
    public void testGetUniqueFirstNames() {

    }

    @Test
    public void testCalculateAverageSalary() {

    }

    @Test
    public void testGroupByEmploymentStatus() {

    }

    @Test
    public void testGroupByFirstName() {

    }

    @Test
    public void testLists() {
        List<String> l1 = List.of("1", "2", "3");
        List<String> l2 = List.of("1", "2", "3");
        List<String> l3 = List.of("2", "3", "1");

        Assertions.assertEquals(l1, l2, "the lists are not equal");
        Assertions.assertNotSame(l1, l2, "the lists are the same");
        Assertions.assertNotEquals(l1, l3, "the lists are equal");
    }
}
