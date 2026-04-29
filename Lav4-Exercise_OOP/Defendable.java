/**
 * Interface for characters that can block and defend.
 * 
 * @author John Arnel C. Condez_RPG - CCS
 * @version 1.0
 */
public interface Defendable {

    void block();
    /**
 * Gets the character's defense rating.
 * @return the defense rating value
 */
    int getDefenseRating();
    
}