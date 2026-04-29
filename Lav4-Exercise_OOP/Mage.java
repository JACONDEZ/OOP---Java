/**
 * Concrete subclass: Mage
 * 
 * A spellcaster who uses mana to cast powerful magical spells.
 * Implements CasterAbility to represent spell-casting capabilities.
 * 
 * @author John Arnel C. Condez_RPG - CCS
 * @version 1.0
 */

public class Mage extends GameCharacter implements CasterAbility {
    private int mana;
    private int maxMana;

  
    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
        this.maxMana = mana;
    }

    @Override
    public String describeClass() {
        return getName() + " - Mage [HP: " + getHp() + "/" + getMaxHp() + ", ATK: " + getAttackPower() + ", Mana: " + mana + "/" + maxMana + "]";
    }

   
    @Override
    public void attack() {
        if (mana >= 15) {
            mana -= 15;
            System.out.println(getName() + " (Mage) casts Magic Missile! Deals " + getAttackPower() + " magical damage. Mana: " + mana + "/" + maxMana);
        } else {
            System.out.println(getName() + " (Mage) tries to cast but lacks enough mana!");
        }
    }

   
    

    @Override
    public void rest() {
        int recovered = 5;
        setHp(getHp() + recovered);
        if (getHp() > getMaxHp()) {
            setHp(getMaxHp());
        }
        restoreMana(20);
        System.out.println(getName() + " meditates in the tower. Recovered " + recovered + " HP and 20 Mana.");
    }

    
    @Override
    public void castSpell(String spellName) {
        int manaCost = 20; // Standard spell cost
        if (mana >= manaCost) {
            mana -= manaCost;
            System.out.println(getName() + " casts " + spellName + "! Mana remaining: " + mana + "/" + maxMana);
        } else {
            System.out.println(getName() + " lacks enough mana to cast " + spellName + ".");
        }
    }

   
    @Override
    public int getMana() {
        return mana;
    }

    
    @Override
    public int getMaxMana() {
        return maxMana;
    }

    // ==================== GETTERS & SETTERS ====================
    public void setMana(int mana) {
        this.mana = Math.max(0, Math.min(mana, maxMana)); // Keep within bounds
    }

    public void restoreMana(int amount) {
        mana = Math.min(mana + amount, maxMana);
    }
}