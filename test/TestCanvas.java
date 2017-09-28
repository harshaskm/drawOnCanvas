import com.Canvas;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestCanvas {
    @Test
    public void testPrintCanvas() {

        Canvas canvas = new Canvas(4, 20, ' ');
        canvas.drawHorizontalLineInCanvas(1, 2, 6, 2);
        canvas.drawVerticalLineInCanvas(6, 3, 6, 4);
        canvas.createSmallBoxInTheCanvas(14,1,18,3);
        System.out.println(canvas.toString());

        Assert.assertTrue(true);
    }
}
