/**
 * Concrete subclass: Archer
 * 
 * A ranged fighter who uses arrows for combat.
 * Manages a limited arrow resource for attacks.
 * 
 * @author John Arnel C. Condez_RPG - CCS
 * @version 1.0
 */
public class Archer extends GameCharacter {
    private int arrowCount;

    public Archer(String name, int hp, int attackPower, int arrowCount) {
        super(name, hp, attackPower);
        this.arrowCount = arrowCount;
    }

    @Override
    public String describeClass() {
        return getName() + " - Archer [HP: " + getHp() + "/" + getMaxHp() + ", ATK: " + getAttackPower() + ", Arrows: " + arrowCount + "]";
    }

    
    @Override
    public void attack() {
        if (arrowCount > 0) {
            arrowCount--;
            System.out.println(getName() + " (Archer) fires an arrow! Deals " + getAttackPower() + " damage. Arrows remaining: " + arrowCount);
        } else {
            System.out.println(getName() + " (Archer) has no arrows left!");
        }
    }

    

    @Override
    public void rest() {
        int recovered = 10;
        setHp(getHp() + recovered);
        if (getHp() > getMaxHp()) {
            setHp(getMaxHp());
        }
        System.out.println(getName() + " rests in the wild. Recovered " + recovered + " HP.");
    }

    
    public int getArrowCount() {
        return arrowCount;
    }

    public void setArrowCount(int arrowCount) {
        this.arrowCount = Math.max(0, arrowCount);
    }

    public void pickupArrows(int count) {
        arrowCount += count;
        System.out.println(getName() + " picks up " + count + " arrows. Total: " + arrowCount);
    }
}