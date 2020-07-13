import ea.*;

public class GridWorld extends Game {
    public static void main(String[] args) {
        new GridWorld(50);
    }
    
    private Rechteck box;
    public int size;
    private int dim;
    private Rechteck[][] grid;
    
    public GridWorld(int size) {
        super(400, 400);
        this.size = size;
        this.dim = 400/size;
        grid = new Rechteck[size][size];
        for(int i = 0; i<size; i++)
        {
            for(int j = 0; j<size; j++)
            {
                box = new Rechteck(i*this.dim, j*this.dim, this.dim, this.dim);
                wurzel.add(box);
                grid[i][j] = box;
            }
        }
    }
    
    public void faerben(int x, int y, String color)
    {
        this.grid[x][y].farbeSetzen(color); 
    }
    
    @Override
    public void tasteReagieren(int code) {
        switch(code) {
            case 26: box.verschieben(+0, -10); break;
            case 27: box.verschieben(+10, +0); break;
            case 28: box.verschieben(+0, +10); break;
            case 29: box.verschieben(-10, +0); break;
        }
    }
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
    }
    }
}