package com.draw;


public class Canvas {
    private int canvasWidth;
    private int canvasHeight;
    private char[][] canvas;
    public static final char HORIZONTAL_BORDER_CHAR = '-';
    public static final char VERTICAL_BORDER_CHAR = '|';

    public Canvas(int canvasHeight, int canvasWidth, char symbol) {
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
        String[] canvasRows = new String[this.canvasHeight +2];
        getTopHorizontalBorder(canvasRows, HORIZONTAL_BORDER_CHAR);
        getCanvasRowsWithVerticalBorder(canvasRows, VERTICAL_BORDER_CHAR);
        getBottomHorizontalBorder(canvasRows, HORIZONTAL_BORDER_CHAR);

        return canvasRows;
    }

    private void getTopHorizontalBorder(String[] canvasRows, char horizontalBorderChar) {
        for (int i1 = 0; i1 < this.canvasWidth +2; i1++) {
            if (i1 == 0) canvasRows[0] = String.valueOf(horizontalBorderChar);
            else canvasRows[0] += horizontalBorderChar;
        }
    }

    private void getCanvasRowsWithVerticalBorder(String[] canvasRows, char verticalBorderChar) {
        int i = 1;
        for(char[] row : this.canvas) {
            String rowInCanvas = verticalBorderChar + String.copyValueOf(row) + verticalBorderChar;
            canvasRows[i] = rowInCanvas;
            i += 1;
        }
    }

    private void getBottomHorizontalBorder(String[] canvasRows, char horizontalBorderChar) {
        for (int i1 = 0; i1 < this.canvasWidth +2; i1++) {
            if (i1 == 0) canvasRows[canvasHeight+1] = String.valueOf(horizontalBorderChar);
            else canvasRows[canvasHeight+1] += horizontalBorderChar;
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String line : toRows()) {
            builder.append(line).append(System.lineSeparator());
        }
        return builder.toString();
    }

}