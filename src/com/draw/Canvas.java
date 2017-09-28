package com.draw;

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

        this.initialize();
    }

    private void initialize(){
        for (int height = 0; height < canvasHeightWithBorder; height++) {
            for (int width = 0; width < canvasWidthWithBorder; width++) {
                drawPerimeter(height, width);
                fill(height, width);
            }
        }
    }

    private void fill(int height, int width) {
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

    public void drawHorizontalLine(int firstXCoordinate, int firstYCoordinate, int secondXCoordinate, int secondYCoordinate){
        if (firstYCoordinate == secondYCoordinate) {
            for (int i = firstXCoordinate; i <= secondXCoordinate; i++) {
                canvas[firstYCoordinate][i] = 'x';
            }
        }
    }

    public void drawVerticalLine(int firstXCoordinate, int firstYCoordinate, int secondXCoordinate, int secondYCoordinate){
        if (firstXCoordinate == secondXCoordinate) {
            for (int i = firstYCoordinate; i <= secondYCoordinate; i++) {
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
        for(int i = xCoordinate; i < this.canvasWidthWithBorder; i++){
            if (canvas[yCoordinate][i] != colour){
                canvas[yCoordinate][i] = colour;
            }
        }
    }

    public String[] print(){
        String[] canvasRows = new String[this.canvasHeightWithBorder];
        int i = 0;

        for(char[] row : this.canvas) {
            String rowInCanvas = String.copyValueOf(row);

            canvasRows[i] = rowInCanvas;
            i += 1;
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