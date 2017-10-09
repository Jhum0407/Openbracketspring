package h.j.results;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImageTestTest {
    ImageTest imageTest;

    @Before
    public void setUp(){
        imageTest = new ImageTest();
    }
    @Test
    public void displayImage() throws Exception {
        System.out.println(imageTest.icon.getIconHeight());
    }

}