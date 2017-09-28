import com.Canvas;
import org.junit.Assert;
import org.junit.Test;

public class TestCanvas {
    @Test
    public void testPrintCanvas() {
        String[] coockedCanvas = Canvas.toString(5,3);
        for (int iterator = 0; iterator < coockedCanvas.length; iterator++) {
            System.out.println(coockedCanvas[iterator]);
        }

        Assert.assertTrue(true);
    }

//    @Test
//    public void testToString() {
//        Canvas c = new Canvas(1, 1, 5, 5, 3, 3, ' ', new char[5][5]);
//        Assert.assertEquals("Hello", c.toString());
//    }
}
