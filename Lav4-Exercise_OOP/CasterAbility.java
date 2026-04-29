/**
 * Interface for characters that can cast spells.
 * 
 * Any character implementing this interface can perform magical abilities
 * and must manage a mana resource. This is typically implemented by
 * spellcasting classes like Mage.
 * 
 * Implementing classes must provide implementations for casting spells,
 * tracking current mana, and tracking maximum mana capacity.
 * 
 * @author John Arnel C. Condez_RPG - CCS
 * @version 1.0
 */
public interface CasterAbility {

    void castSpell(String spellName);
    int getMana();
    int getMaxMana();
    
}