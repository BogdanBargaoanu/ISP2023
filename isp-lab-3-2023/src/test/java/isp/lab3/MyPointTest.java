package isp.lab3;

import isp.lab3.exercise4.MyPoint;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyPointTest {
    @Test
    public void testDistance() {
        MyPoint punct1=new MyPoint();
        MyPoint punct2=new MyPoint();
        assertEquals(1,punct1.distance(1,0,0),0.001);
        assertEquals(0,punct1.distance(punct2),0.001);
    }
}
