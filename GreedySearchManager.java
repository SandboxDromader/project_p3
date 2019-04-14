import java.lang.Math;
import java.text.DecimalFormat;

public class GreedySearchManager {
    private Cell[][] cells2DMap;
    private int[][] cells2DTravelOrderMap;
    private double[][] cells2DHuristicMap;
    private DecimalFormat df1 = new DecimalFormat(".#");

    public GreedySearchManager(int noOfRows, int noOfColumns) {
        cells2DMap = new Cell[noOfRows][];
        cells2DTravelOrderMap = new int[noOfRows][];

        int xOfMaxVal, yOfMaxVal;

        xOfMaxVal = 2;
        yOfMaxVal = 3;

        for(int i=0;i<cells2DMap.length;i++) {
            cells2DMap[i] = new Cell[noOfColumns];
            cells2DTravelOrderMap[i] = new int[noOfColumns];

            for(int j=0;j<cells2DMap[i].length;j++) {
                cells2DMap[i][j] = new Cell(Utilities.getRandomInteger(10,99),j,i);
                cells2DTravelOrderMap[i][j] = 0;
            }
        }

        createHeuristic2DMap(xOfMaxVal, yOfMaxVal);
    }

    public void print2DMap() {
        for(int i=cells2DMap.length-1;i>=0;i--) {
            for(int j=0;j<cells2DMap[i].length;j++) {
                System.out.print(cells2DMap[i][j].getValue() + "\t");
            }
            System.out.print("\n");
        }
    }

    public void print2DTravelOrderMap() {
        for(int i=cells2DTravelOrderMap.length-1;i>=0;i--) {
            for(int j=0;j<cells2DTravelOrderMap[i].length;j++) {
                System.out.print(cells2DTravelOrderMap[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    public void createHeuristic2DMap(int xOfMaxVal, int yOfMaxVal) {
        cells2DHuristicMap = new double[cells2DMap.length][cells2DMap[0].length];

        for(int i=cells2DHuristicMap.length-1;i>=0;i--) {
            for(int j=0;j<cells2DHuristicMap[i].length;j++) {
                cells2DHuristicMap[i][j] = this.getDistance(xOfMaxVal, yOfMaxVal, j, i);
            }
            System.out.print("\n");
        }
    }

    public void printHeuristic2DMap() {
        for(int i=cells2DHuristicMap.length-1;i>=0;i--) {
            for(int j=0;j<cells2DHuristicMap[i].length;j++) {
                System.out.print(df1.format(cells2DHuristicMap[i][j]) + "\t");
            }
            System.out.print("\n");
        }
    }

    public double getDistance(double xA, double yA, double xB, double yB) {
        return Math.sqrt(Math.pow(xB - xA, 2) + Math.pow(yB - yA, 2));
    }

    public void getRandomCell() {
        int xOrder = cells2DTravelOrderMap.length - 1 - Utilities.getRandomInteger(1,cells2DMap.length), yOrder = Utilities.getRandomInteger(1,cells2DMap[0].length);

        cells2DTravelOrderMap[yOrder][xOrder] = 1;
        System.out.println("Random cell (x,y) = (" + xOrder + "," + yOrder + ")");
        System.out.println("Random cell [x,y].value = [" + cells2DMap[yOrder][xOrder].getValue() + "]");

        // cells2DTravelOrderMap[cells2DTravelOrderMap.length - 1 - Utilities.getRandomInteger(1,cells2DMap.length)][Utilities.getRandomInteger(1,cells2DMap[0].length)] = 1;
    }

    public static void main(String[] args) {
        System.out.println("2DMap:");
        GreedySearchManager greedySearchManager = new GreedySearchManager(5,5);

        greedySearchManager.print2DMap();

        System.out.println("\n2DTravelOrderMap:");
        greedySearchManager.getRandomCell();
        greedySearchManager.print2DTravelOrderMap();

        System.out.println("\n2DHeuristicMap:");
        greedySearchManager.printHeuristic2DMap();
    }
}