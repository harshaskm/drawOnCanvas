package com;

public class Canvas {
    private int horizontalBorderLines;
    private int verticalBorderLines;
    private int canvasWidthWithBorder;
    private int canvasHeightWithBorder;
    private int canvasHeightWithoutBorder;
    private int canvasWidthWithoutBorder;
    private int headerLine;
    private int footerLine;
    private char symbol;
    private char[][] canvas = new char[canvasHeightWithBorder][canvasWidthWithBorder];

    public Canvas(int horizontalBorderLines, int verticalBorderLines, int canvasWidthWithBorder, int canvasHeightWithBorder
                    , int canvasHeightWithoutBorder, int canvasWidthWithoutBorder, char symbol, char[][] canvas) {
        this.horizontalBorderLines = horizontalBorderLines;
        this.verticalBorderLines = verticalBorderLines;
        this.canvasWidthWithBorder = canvasWidthWithBorder;
        this.canvasHeightWithBorder = canvasHeightWithBorder;
        this.canvasHeightWithoutBorder = canvasHeightWithoutBorder;
        this.canvasWidthWithoutBorder = canvasWidthWithoutBorder;
        this.headerLine = 0;
        this.footerLine = canvasHeightWithBorder - 1;
        this.symbol = symbol;
        this.canvas = canvas;

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

    public static void print(int canvasWidthWithoutBorder, int canvasHeightWithoutBorder){
        String lineOut="";
        int horizontalBorderLines = 2;
        int verticalBorderLines = 2;
        int canvasWidthWithBorder = canvasWidthWithoutBorder + verticalBorderLines;
        int canvasHeightWithBorder = canvasHeightWithoutBorder + horizontalBorderLines;
        char[][] box = new char[canvasHeightWithBorder][canvasWidthWithBorder];

        Canvas canvas = new Canvas(horizontalBorderLines, verticalBorderLines, canvasWidthWithBorder
                                    , canvasHeightWithBorder, canvasHeightWithoutBorder, canvasWidthWithoutBorder, ' ', box);

//        for(int height=0; height <= canvasHeightWithBorder; height++){
//            for(int width=0; width <= canvasWidthWithBorder; width++){
//                lineOut += canvas.canvas[width][height];
//            }
//        }

        for(char[] row : canvas.canvas) {
            for (char cell : row) {
                System.out.print(cell);
            }

            System.out.println();
        }
    }
}
