package com.draw;


public class Canvas {
    private int canvasWidth;
    private int canvasHeight;
    private char[][] canvas;
    public static final char HORIZONTAL_BORDER_CHAR = '-';
    public static final char VERTICAL_BORDER_CHAR = '|';

    public Canvas(int canvasHeight, int canvasWidth) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.canvas = new char[this.canvasHeight][this.canvasWidth];

        this.initialize();
    }

    private void initialize(){
        for (int height = 0; height < canvasHeight; height++) {
            for (int width = 0; width < canvasWidth; width++) {
                canvas[height][width] = ' ';
            }
        }
    }

    public void drawHorizontalLine(int firstXCoordinate, int firstYCoordinate, int secondXCoordinate, int secondYCoordinate){
        if (firstYCoordinate == secondYCoordinate) {
            for (int i = firstXCoordinate; i <= secondXCoordinate; i++) {
                canvas[firstYCoordinate-1][i] = 'x';
            }
        }
    }

    public void drawVerticalLine(int firstXCoordinate, int firstYCoordinate, int secondXCoordinate, int secondYCoordinate){
        if (firstXCoordinate == secondXCoordinate) {
            for (int i = firstYCoordinate-1; i < secondYCoordinate; i++) {
                canvas[i][firstXCoordinate] = 'x';
            }
        }
    }

    public void createSmallBox(int firstXCoordinate, int firstYCoordinate, int secondXCoordinate, int secondYCoordinate) {
        if ((firstXCoordinate != secondXCoordinate) && firstYCoordinate != secondYCoordinate) {
            drawHorizontalLine(firstXCoordinate, firstYCoordinate, secondXCoordinate, firstYCoordinate);
            drawHorizontalLine(firstXCoordinate, secondYCoordinate, secondXCoordinate, secondYCoordinate);
            drawVerticalLine(firstXCoordinate, firstYCoordinate, firstXCoordinate, secondYCoordinate);
            drawVerticalLine(secondXCoordinate, firstYCoordinate, secondXCoordinate, secondYCoordinate);
        }
    }

    public String[] toRows(){
        String[] canvasRows;

        canvasRows = getCanvasRowsWithVerticalBorder(VERTICAL_BORDER_CHAR);
        canvasRows[0] = String.valueOf(getTopHorizontalBorder(HORIZONTAL_BORDER_CHAR));
        canvasRows[canvasHeight+1] = getBottomHorizontalBorder(HORIZONTAL_BORDER_CHAR);

        return canvasRows;
    }

    private String getTopHorizontalBorder(char horizontalBorderChar) {
        String canvasRows = new String();

        for (int i1 = 0; i1 < this.canvasWidth +2; i1++) {
            if (i1 == 0) canvasRows = String.valueOf(horizontalBorderChar);
            else canvasRows += horizontalBorderChar;
        }

        return canvasRows;
    }

    private String[] getCanvasRowsWithVerticalBorder(char verticalBorderChar) {
        int i = 1;
        String[] canvasRows = new String[this.canvasHeight +2];

        for(char[] row : this.canvas) {
            String rowInCanvas = verticalBorderChar + String.copyValueOf(row) + verticalBorderChar;
            canvasRows[i] = rowInCanvas;
            i += 1;
        }

        return canvasRows;
    }

    private String getBottomHorizontalBorder(char horizontalBorderChar) {
        String canvasRows = new String();

        for (int i1 = 0; i1 < this.canvasWidth +2; i1++) {
            if (i1 == 0) canvasRows = String.valueOf(horizontalBorderChar);
            else canvasRows += horizontalBorderChar;
        }

        return canvasRows;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String line : toRows()) {
            builder.append(line).append(System.lineSeparator());
        }
        return builder.toString();
    }

}