package ClassWork001.Task001;



public class Magician extends BaseHero {

    private int mana;
    private int maxMana;

    public Magician() {
        super(String.format("Hero_Magician #%d", ++Magician.number),
                Magician.r.ints(100, 200).findFirst().getAsInt());
        this.maxMana = Magician.r.ints(50, 150).findFirst().getAsInt();
        this.mana = maxMana;
    }

    public String getInfo() {
        return String.format("%s  Mana: %d",super.getInfo(), this.mana);
    }
}