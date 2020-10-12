import ea.*;


public class HanoiView extends Game
{
    int largest = 180;
    int smallest = 30;
    float step;
    float height;
    private Rechteck[][] ts = new Rechteck[][]{{}, {}, {}};

    
    
    public HanoiView(int anzahl)
    {
        super(830, 600);
        draw_blank_towers();
       
        step = (largest - smallest)/anzahl;
        height = 160/anzahl;

         draw_tower(2, new int[]{1,2,3,4,5,6});
    }
    
    public void draw_blank_towers()
    {
        Rechteck background = new Rechteck(0,0, 830, 600);
        background.farbeSetzen("weiss");
        wurzel.add(background);
        
        Rechteck tower1 = new Rechteck(200, 200, 10, 200 );
        tower1.farbeSetzen("schwarz");
        wurzel.add(tower1);
        
        Rechteck tower2 = new Rechteck(400, 200, 10, 200 );
        tower2.farbeSetzen("schwarz");
        wurzel.add(tower2);
        
                
        Rechteck tower3 = new Rechteck(600, 200, 10, 200 );
        tower3.farbeSetzen("schwarz");
        wurzel.add(tower3);
    }
    
    public void draw_tower(int t, int[] xs)
    {
        for (int i = 0; i<ts[t].length; i++)
        {
            wurzel.entfernen(ts[t][i]);            
        }
        Rechteck[] t_new = new Rechteck[xs.length];
        for (int i = 0; i<xs.length; i++)
        {
            float width = step*xs[i];
            Rechteck r = new Rechteck((200*(t+1))-(width/2), 400-(i*height)-step, width + 10, height);
            r.farbeSetzen("blau");
            wurzel.add(r);
            t_new[i] = r;
        }
        ts[t] = t_new;
        
    }
    
    
    
    @Override
    public void tasteReagieren(int code) {
    }
}
