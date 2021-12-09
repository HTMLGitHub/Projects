package Sudoku.problemdomain;

import java.util.Objects;

public class Coordinates
{
    private final int x;
    private final int y;

    public Coordinates(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Coordinates coord = (Coordinates) obj;
        return x == coord.x && y == coord.y;
    }

    @Override
    public int hashCode(){return Objects.hash(x,y);}
}
