/**
 * Abstract base class representing a game character in an RPG party.
 * 
 * This class defines the common structure for all character types, including:
 * - Core attributes (name, health points, attack power)
 * - Abstract methods that each subclass must implement
 * 
 * All subclasses must provide their own implementations of attack(),
 * describeClass(), and rest() based on their character type.
 * 
 * @author John Arnel C. Condez_RPG - CCS
 * @version 1.0
 */
public abstract class GameCharacter {
    private String name;
    private int hp;
    private int maxHp;
    private int attackPower;

    public GameCharacter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attackPower = attackPower;
    }

    
    public abstract String describeClass();
    public abstract void attack();
    public abstract void rest();

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}