package com;


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

    public static String[] toString(int canvasWidthWithoutBorder, int canvasHeightWithoutBorder){
        Canvas canvas = new Canvas(canvasHeightWithoutBorder, canvasWidthWithoutBorder, ' ');
        String[] canvasRows = new String[canvasHeightWithoutBorder + 2];
        String rowInCanvas = new String();
        int iterator = 0;

        for(char[] row : canvas.canvas) {
            for (char cell : row) {
                rowInCanvas += cell;
            }

            canvasRows[iterator] = rowInCanvas;
            rowInCanvas = "";
            iterator += 1;
        }
        return canvasRows;
    }
}