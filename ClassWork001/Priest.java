package ClassWork001;


 
public class Priest extends BaseHero {

    private int elixir;
    private int maxElixir;

    public Priest() {
        super(String.format("Hero_Priest #%d", ++Priest.number),
                Magician.r.ints(100, 200).findFirst().getAsInt());
        this.maxElixir = Magician.r.ints(50, 150).findFirst().getAsInt();
        this.elixir = maxElixir;
        
    }
    
    public String getInfo() {
        return String.format("%s  Elixir: %d", super.getInfo(), this.elixir);
    }
}
