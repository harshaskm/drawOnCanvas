package com;


import sun.tools.java.Environment;

public class Canvas {
    private int canvasWidthWithBorder;
    private int canvasHeightWithBorder;
    private int headerLine;
    private int footerLine;
    private char symbol;
    private char[][] canvas;

    public Canvas(int canvasHeightWithoutBorder, int canvasWidthWithoutBorder, char symbol) {
        int horizontalBorderLines = 2;
        int verticalBorderLines = 2;
        this.canvasWidthWithBorder = canvasWidthWithoutBorder + horizontalBorderLines;
        this.canvasHeightWithBorder = canvasHeightWithoutBorder + verticalBorderLines;
        this.headerLine = 0;
        this.footerLine = canvasHeightWithBorder - 1;
        this.symbol = symbol;
        this.canvas = new char[canvasHeightWithBorder][canvasWidthWithBorder];

        this.initializeCanvas();
    }

    private void initializeCanvas (){
        for (int height = 0; height < canvasHeightWithBorder; height++) {
            for (int width = 0; width < canvasWidthWithBorder; width++) {
                drawPerimeter(height, width);
                fillCanvas(height, width);
            }
        }
    }

    private void fillCanvas(int height, int width) {
        if ( (height > headerLine && height < footerLine) && (width > 0 && width < canvasWidthWithBorder-1)) {
            canvas[height][width] = ' ';
        }
    }

    private void drawPerimeter(int height, int width) {
        if (height == headerLine || height == footerLine) {
            if (symbol != 'x') symbol = '-';
            canvas[height][width] = symbol;
        }

        if ((height > headerLine && height < footerLine) && (width == 0 || width == canvasWidthWithBorder-1 )) {
            if (symbol != 'x') symbol = '|';
            canvas[height][width] = symbol;
        }
    }

    public void drawHorizontalLineInCanvas(int firstXCoordinate, int firstYCoordinate, int secondXCoordinate, int secondYCoordinate){
        if (firstYCoordinate == secondYCoordinate) {
            for (int iterator = firstXCoordinate; iterator <= secondXCoordinate; iterator++) {
                canvas[firstYCoordinate][iterator] = 'x';
            }
        }
    }

    public void drawVerticalLineInCanvas(int firstXCoordinate, int firstYCoordinate, int secondXCoordinate, int secondYCoordinate){
        if (firstXCoordinate == secondXCoordinate) {
            for (int iterator = firstYCoordinate; iterator <= secondYCoordinate; iterator++) {
                canvas[iterator][firstXCoordinate] = 'x';
            }
        }
    }

    public void createSmallBoxInTheCanvas(int firstXCoordinate, int firstYCoordinate, int secondXCoordinate, int secondYCoordinate) {
        drawHorizontalLineInCanvas(firstXCoordinate, firstYCoordinate, secondXCoordinate, secondYCoordinate);
        drawHorizontalLineInCanvas(firstXCoordinate, secondYCoordinate, secondXCoordinate, secondYCoordinate);
        drawVerticalLineInCanvas(firstXCoordinate, firstYCoordinate, secondXCoordinate, secondYCoordinate);
        drawVerticalLineInCanvas(secondXCoordinate, firstYCoordinate, secondXCoordinate, secondYCoordinate);
    }

    public void bucketFill(int xCoordinate, int yCoordinate, char colour){
        for(int iterator = xCoordinate; iterator < this.canvasWidthWithBorder; iterator++){
            if (canvas[yCoordinate][iterator] != colour){
                canvas[yCoordinate][iterator] = colour;
            }
        }
    }

    public String[] printCanvas(){
        String[] canvasRows = new String[this.canvasHeightWithBorder];
        int iterator = 0;

        for(char[] row : this.canvas) {
            String rowInCanvas = String.copyValueOf(row);

            canvasRows[iterator] = rowInCanvas;
            iterator += 1;
        }
        return canvasRows;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String line : printCanvas()) {
            builder.append(line).append(System.lineSeparator());
        }
        return builder.toString();
    }

}