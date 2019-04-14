public class Cell {
    public int value;
    public int xPosition;
    public int yPosition;

    public Cell(int value, int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.value = value;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if(o==this) {
            return true;
        }

        if(!(o instanceof Cell)) {
            return false;
        }

        Cell c = (Cell) o;
        return xPosition == c.xPosition && yPosition == c.yPosition && value == c.value;
    }
}