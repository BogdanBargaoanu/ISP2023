package isp.lab3;

import isp.lab3.exercise1.Tree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeTest {
    @Test
    public void testtoString() {
        Tree copac = new Tree();
        assertEquals("Inaltimea copacului este de 15 metri", copac.toString());
    }

    @Test
    public void testGrow() {
        Tree copac = new Tree();
        copac.grow(5);
        assertEquals(20, copac.height);
    }
}
