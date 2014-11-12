import java.util.Collections;
/**
 * Represents a Pokedex - basically a Pokemon encyclopedia that adds new entries
 * when you encounter a Pokemon for the first time.
 * It also provides methods for organizing its information in useful ways.
 *
 * @author Joe Rossi, Tommy Ristau
 * @version 1.0
 */
public class Pokedex {

    private MySortedSet<Pokemon> backingData;

    /**
     * Constructs a Pokedex object by setting up the sorted set of Pokemon
     */
    public Pokedex() {
        backingData = new MySortedSet<>((a,b) -> a.compareTo(b));
    }

    @Override
    public String toString() {
        // TODO
        return backingData.toString();
    }

    /**
     * Adds a Pokemon to the sorted set
     *
     * @param p the Pokemon to be added
     * @return true if the pokemon was not already in the set, false otherwise
     */
    public boolean add(Pokemon p) {
        // TODO
         return backingData.add(p);
    }

    /**
     * Returns the number of Pokemon in the Pokedex
     *
     * @return  the number of Pokemon in the Pokedex
     */
    public int countPokemon() {
        // TODO
        return backingData.size();
    }

    /**
     * Clear the Pokedex and start over
     */
    public void clear() {
        backingData.clear();
    }

    /**
     * Returns a set of alphabetized Pokemon, using a lambda expression
     *
     * @return  the alphabetized set
     */
    public MySortedSet<Pokemon> listAlphabetically() {
        // TODO
        return backingData.sort((a, b) -> {
            return a.getName().compareTo(b.getName());
        });
    }

    /**
     * Returns a set of Pokemon grouped by type, using a lambda expression
     *
     * @return  the grouped by primary type set
     */
    public MySortedSet<Pokemon> groupByPrimaryType() {
        // TODO
        return backingData.sort((a,b) -> {
            return a.getPrimaryType().compareTo(b.getPrimaryType());
        });
    }

    /**
     * Returns a set of all Pokemon of type t
     *
     * @param t the type we want listed
     * @return  the set of all Pokemon in the Pokedex of type t
     */
    public MySortedSet<Pokemon> listByType(PokemonType t) {
        // TODO
        return backingData.filter(a -> a.getPrimaryType().equals(t) || a.getSecondaryType().equals(t));
    }

    /**
     * Returns a set of Pokemon with numbers in the range [start, end]
     *
     * @param start the first number in the new set
     * @param end   the last number in the new set
     * @return  the set containing all Pokemon in the Pokedex from [start, end]
     */
    public MySortedSet<Pokemon> listRange(int start, int end) {
        // TODO
        return backingData.filter(a -> a.getNumber() >= start && a.getNumber() <= end);
    }
}
