package com.draw;


public class Canvas {
    private int canvasWidth;
    private int canvasHeight;
    private char[][] canvas;

    public Canvas(int canvasHeight, int canvasWidth, char symbol) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.canvas = new char[this.canvasHeight][this.canvasWidth];

        this.initialize();
    }

    private void initialize(){
        for (int height = 0; height < canvasHeight; height++) {
            for (int width = 0; width < canvasWidth; width++) {
                fill(height, width);
            }
        }
    }

    private void fill(int height, int width) {
        if (width < canvasWidth) {
            canvas[height][width] = ' ';
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

    public void bucketFill(int xCoordinate, int yCoordinate, char colour){
        for(int i = xCoordinate; i < this.canvasWidth; i++){
            if (canvas[yCoordinate][i] != colour){
                canvas[yCoordinate][i] = colour;
            }
        }
    }

    public String[] print(){
        String[] canvasRows = new String[this.canvasHeight +2];
        char horizontalBorderChar = '-';
        char verticalBorderChar = '|';
        int i = 0;

        for (int i1 = 0; i1 < this.canvasWidth +2; i1++) {
            if (i1 == 0) canvasRows[i] = String.valueOf(horizontalBorderChar);
                    else canvasRows[i] += horizontalBorderChar;
        }
        i++;

        for(char[] row : this.canvas) {
            String rowInCanvas = verticalBorderChar + String.copyValueOf(row) + verticalBorderChar;
            canvasRows[i] = rowInCanvas;
            i += 1;
        }
        for (int i1 = 0; i1 < this.canvasWidth +2; i1++) {
            if (i1 == 0) canvasRows[i] = String.valueOf(horizontalBorderChar);
            else canvasRows[i] += horizontalBorderChar;
        }

        return canvasRows;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String line : print()) {
            builder.append(line).append(System.lineSeparator());
        }
        return builder.toString();
    }

}