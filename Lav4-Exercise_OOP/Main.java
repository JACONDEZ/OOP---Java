import java.util.ArrayList;

/**
 * Main driver class for the RPG Character System.
 * 
 * Demonstrates:
 * - Creating a polymorphic collection of different character types
 * - Processing all characters uniformly through polymorphic dispatch
 * - Using instanceof checks to identify and call interface-specific methods
 * - Downcasting to access subclass-specific functionality
 * - Party summary and statistics
 * 
 * @author John Arnel C. Condez_RPG - CCS
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        
        System.out.println("  \n------ RPG CHARACTER CLASS SYSTEM ------  ");
        
        

        // ============================================================
        // STEP 1: Create party members (polymorphic collection)
        // ============================================================
        ArrayList<GameCharacter> party = new ArrayList<>();
        
        // Add one of each concrete subclass
        party.add(new Warrior("Garen", 120, 18, 25));
        party.add(new Mage("Lux", 70, 30, 100));
        party.add(new Archer("Ashe", 85, 22, 30));
        

        System.out.println("\nParty assembled! Members: " + party.size() + "\n");

        // ============================================================
        // STEP 2: Polymorphic loop — all characters
        // Process each character the same way; polymorphic dispatch
        // ensures the correct method version runs for each type.
        // ============================================================

        System.out.println("---------------------------------------------");
        System.out.println("         PARTY ROSTER & ACTIONS\n");
        

        for (GameCharacter c : party) {
            // Call overridden abstract methods — polymorphism in action!
            System.out.println(c.describeClass());
            c.attack();
            c.rest();
            System.out.println();
        }

        System.out.println("All characters processed with the same loop (polymorphism verified)\n");

        // ============================================================
        // STEP 3: Interface-specific actions — Casters
        // instanceof checks to find characters that implement CasterAbility
        // ============================================================
        
        System.out.println("---------------------------------------------");
        System.out.println("       CASTERS IN THE PARTY\n");
        

        for (GameCharacter c : party) {
            if (c instanceof CasterAbility) {
                // Downcast to CasterAbility interface
                CasterAbility caster = (CasterAbility) c;
                
                // Call interface-specific methods
                System.out.println(c.getName() + " (Caster):");
                caster.castSpell("Fireball");
                System.out.println("Mana: " + caster.getMana() + "/" + caster.getMaxMana());
                System.out.println();
            }
        }

        // ============================================================
        // STEP 4: Interface-specific actions — Defenders
        // instanceof checks to find characters that implement Defendable
        // ============================================================


        System.out.println("---------------------------------------------");
        System.out.println("       DEFENDERS IN THE PARTY\n");
        

        for (GameCharacter c : party) {
            if (c instanceof Defendable) {
                // Downcast to Defendable interface
                Defendable d = (Defendable) c;
                
                // Call interface-specific methods
                System.out.println(c.getName() + " (Defender):");
                d.block();
                System.out.println("Defense Rating: " + d.getDefenseRating());
                System.out.println();
            }
        }

        // ============================================================
        // STEP 5: Party summary & statistics
        // ============================================================

        System.out.println("---------------------------------------------");
        System.out.println("       PARTY SUMMARY & STATISTICS\n");
        

        int totalMembers = party.size();
        int totalHp = 0;
        int casterCount = 0;
        int defenderCount = 0;
        int meleeDamage = 0;

        for (GameCharacter c : party) {
            totalHp += c.getHp();
            meleeDamage += c.getAttackPower();

            if (c instanceof CasterAbility) {
                casterCount++;
            }
            if (c instanceof Defendable) {
                defenderCount++;
            }
        }

        System.out.println("Total Party Members:     " + totalMembers);
        System.out.println("Total Party HP:          " + totalHp);
        System.out.println("Total Attack Power:      " + meleeDamage);
        System.out.println("Casters in Party:        " + casterCount);
        System.out.println("Defenders in Party:      " + defenderCount);
        System.out.println("\nParty Status: " + (totalHp > 0 ? "READY FOR BATTLE!  " : "LET'S GO!"));
        System.out.println();

        // ============================================================
        // ADDITIONAL: Demonstrate subclass-specific functionality
        // ============================================================
        System.out.println("---------------------------------------------");
        System.out.println("   SUBCLASS-SPECIFIC ACTIONS (Downcasting)\n");
        

        // Downcast to Warrior and use armor-specific method
        for (GameCharacter c : party) {
            if (c instanceof Warrior) {
                Warrior warrior = (Warrior) c;
                System.out.println(warrior.getName() + "'s armor is incredibly strong!");
                System.out.println("Armor Rating: " + warrior.getArmorRating() + "\n");
            }
        }

        // Downcast to Archer and use arrow-specific method
        for (GameCharacter c : party) {
            if (c instanceof Archer) {
                Archer archer = (Archer) c;
                archer.pickupArrows(15);
                System.out.println();
            }
        }

        System.out.println("---------------------------------------------");
        System.out.println("  ~ PROGRAM COMPLETED SUCCESSFULLY");
        System.out.println("---------------------------------------------");
    }
}