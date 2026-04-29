/**
 * Concrete subclass: Warrior
 * 
 * A melee fighter with high HP and armor.
 * Implements Defendable to represent heavy defensive capabilities.
 * 
 * @author John Arnel C. Condez_RPG - CCS
 * @version 1.0
 */
public class Warrior extends GameCharacter implements Defendable {
    private int armorRating;

    public Warrior(String name, int hp, int attackPower, int armorRating) {
        super(name, hp, attackPower);
        this.armorRating = armorRating;
    }

    @Override
    public String describeClass() {
        return getName() + " - Warrior [HP: " + getHp() + "/" + getMaxHp() +  ", ATK: " + getAttackPower() + ", Armor: " + armorRating + "]";
    }

    
    @Override
    public void attack() {
        System.out.println(getName() + " (Warrior) swings his sword! Deals " + getAttackPower() + " damage.");
    }


    @Override
    public void rest() {
        int recovered = 15;
        setHp(getHp() + recovered);
        if (getHp() > getMaxHp()) {
            setHp(getMaxHp());
        }
        System.out.println(getName() + " rests at the campfire. Recovered " + recovered + " HP.");
    }

    
    @Override
    public void block() {
        System.out.println(getName() + " raises their shield and blocks the attack!");
    }

   
    @Override
    public int getDefenseRating() {
        return armorRating;
    }

    
    public int getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(int armorRating) {
        this.armorRating = armorRating;
    }
}