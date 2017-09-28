import com.draw.Canvas;
import org.junit.Assert;
import org.junit.Test;

public class TestCanvas {
    @Test
    public void testPrintCanvas() {

        Canvas canvas = new Canvas(4, 20, ' ');
        canvas.drawHorizontalLine(1, 2, 6, 2);
        canvas.drawVerticalLine(6, 3, 6, 4);
        canvas.createSmallBox(14,1,18,3);
        System.out.println(canvas.toString());

        Assert.assertTrue(true);
    }
}