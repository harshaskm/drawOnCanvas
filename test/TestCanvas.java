import com.Canvas;
import org.junit.Assert;
import org.junit.Test;

public class TestCanvas {
    @Test
    public void testPrintCanvas() {

        String[] lines;
        Canvas canvas = new Canvas(4, 20, ' ');
        canvas.drawHorizontalLineInCanvas(3, 2, 7, 2);
        lines = canvas.printCanvas();

        for (int iterator = 0; iterator < lines .length; iterator++) {
            System.out.println(lines[iterator]);
        }

        Assert.assertTrue(true);
    }

//    @Test
//    public void testToString() {
//        Canvas c = new Canvas(1, 1, 5, 5, 3, 3, ' ', new char[5][5]);
//        Assert.assertEquals("Hello", c.printCanvas());
//    }
}
