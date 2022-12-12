package ClassWork001;


 
public class Healer extends BaseHero {

    private int elixir;
    private int maxElixir;

    public Healer() {
        super(String.format("Hero_Healer #%d", ++Healer.number),
            Healer.r.ints(50, 100).findFirst().getAsInt());
        this.maxElixir = Healer.r.ints(50, 150).findFirst().getAsInt();
        this.elixir = maxElixir;
        
    }
    
    public String getInfo() {
        return String.format("%s  Elixir: %d", super.getInfo(), this.elixir);
    }

    public void heal(BaseHero target) {
        int health = BaseHero.r.ints(5, 10).findFirst().getAsInt();
        target.healed(health);
    }
}
