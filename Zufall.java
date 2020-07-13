import java.util.Random;

public class Zufall
{   
    private Random rand;
    public Zufall()
    {
        rand = new Random();
        
        int int_random = rand.nextInt(15);
        System.out.println(int_random);
        
        double double_random=rand.nextDouble();
        System.out.println(double_random);
    }
    

    
    /*
    public int zufall_int(int von, int bis)
    {
        // todo: soll einen zufall wert von-bis zurueckgeben
    }*/
    
    /*
    public boolean zufall_bool()
    {
        // todo: soll zufaellig true oder false zurueckgeben
        
    }*/
    
    
    /*
    public <E> E zufall_element(E[] liste)
    {
        // todo: soll eine zufaelliges element aus der liste zurückgeben
        
    }*/
    
    
}
