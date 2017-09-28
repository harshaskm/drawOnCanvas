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

    public void drawHorizontalLineInCanvas(int firstXCoOrdinate, int firstYCoOrdinate, int secondXCoOrdinate, int secondYCoOrdinate){
        if (firstYCoOrdinate == secondYCoOrdinate) {
            for (int iterator = firstXCoOrdinate; iterator <= secondXCoOrdinate; iterator++) {
                canvas[firstYCoOrdinate][iterator] = 'x';
            }
        }
    }

    public void drawVerticalLineInCanvas(int firstXCoOrdinate, int firstYCoOrdinate, int secondXCoOrdinate, int secondYCoOrdinate){
        if (firstXCoOrdinate == secondXCoOrdinate) {
            for (int iterator = firstYCoOrdinate; iterator <= secondYCoOrdinate; iterator++) {
                canvas[iterator][firstXCoOrdinate] = 'x';
            }
        }
    }

    public void createSmallBoxInTheCanvas(int firstXCoOrdinate, int firstYCoOrdinate, int secondXCoOrdinate, int secondYCoOrdinate) {
        drawHorizontalLineInCanvas(firstXCoOrdinate, firstYCoOrdinate, secondXCoOrdinate, secondYCoOrdinate);
        drawHorizontalLineInCanvas(firstXCoOrdinate, secondYCoOrdinate, secondXCoOrdinate, secondYCoOrdinate);
        drawVerticalLineInCanvas(firstXCoOrdinate, firstYCoOrdinate, secondXCoOrdinate, secondYCoOrdinate);
        drawVerticalLineInCanvas(secondXCoOrdinate, firstYCoOrdinate, secondXCoOrdinate, secondYCoOrdinate);
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