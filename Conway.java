import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Conway extends GridWorld
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private boolean[][] active;
    private int[][] ns = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
    
    public Conway(int size)
    {
        super(size);
        //ns = ;
        Random rand = new Random();
        active = new boolean[size][size];
        for(int i = 0; i<size; i++)
        {
            for(int j = 0; j<size; j++)
            {
                double double_random=rand.nextDouble();
                active[i][j] = double_random > 0.5;
            }
        }
    }
    
    public void run(int steps)
    {
        for(int i = 0; i<steps; i++)
        {
            update();
            draw();
            wait(100);
            
        }
    }
    
    public void update() 
    {
        int[][] all_ns = new int[size][size]; 
        for(int i = 0; i<this.size; i++)
        {
            for(int j = 0; j<this.size; j++)
            {
                int count_ns = 0;
                for (int k = 0; k<this.ns.length; k++)
                {
                    //System.out.println(i);
                    //System.out.println(j);
                    //System.out.println(k);
                    //System.out.println("-");
                    int ns_x = i+ns[k][0];
                    int ns_y = j+ns[k][1];
                    if (ns_x < 0)
                    {
                        ns_x = 0;
                    }
                    if (ns_x >= size)
                    {
                        ns_x = size-1;
                    }
                    if (ns_y < 0)
                    {
                        ns_y = 0;
                    }
                    if (ns_y >= size)
                    {
                        ns_y = size-1;
                    }
                    if (active[ns_x][ns_y])
                    {
                        count_ns += 1;
                    }
                }
                all_ns[i][j] = count_ns;
            }
        }
        
        for(int i = 0; i<this.size; i++)
        {
            for(int j = 0; j<this.size; j++)
            {
                if (active[i][j])
                {
                    // alive
                    if(all_ns[i][j] == 2 || all_ns[i][j] == 3)
                    {
                        active[i][j] = true;
                    }
                    else
                    {
                        active[i][j] = false;
                    }
                                        
                }
                else {
                    // dead
                    if(all_ns[i][j] == 3)
                    {
                        active[i][j] = true;
                    }
                    else
                    {
                        active[i][j] = false;
                    }
                }
                
            }
        }
    }
    
    public void draw()
    {
        for(int i = 0; i<this.size; i++)
        {
            for(int j = 0; j<this.size; j++)
            {
                if (active[i][j])
                {
                    this.faerben(i,j, "rot");
                }
                else
                {
                    this.faerben(i,j, "weiß");
                }
            }
        }
        
    }
    
    public void foo()
    {
         Random rand = new Random(); //instance of random class
        int upperbound = 25;
        for(int i = 0; i<100; i++)
        {
            double double_random=rand.nextDouble();
            System.out.println(double_random);
            
        }
    }

}
