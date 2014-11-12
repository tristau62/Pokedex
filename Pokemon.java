/**
 * Represents a Pokemon object. Each has a number, a name, and two elemental
 * types, chosen from the PokemonType enumeration.
 *
 * @author  Joe Rossi, Tommy Ristau
 * @version 1.0
 */
public class Pokemon implements Comparable<Pokemon> {

    // ------Instance data here------
    private int num;
    private String name;
    private PokemonType p;
    private PokemonType s;
    /**
     * Constructs a Pokemon object
     *
     * @param num   this Pokemon's unique number
     * @param name  this Pokemon's name
     * @param p this Pokemon's primary type
     * @param s this Pokemon's secondary type
     */
    public Pokemon(int num, String name, PokemonType p, PokemonType s) {
        this.num = num;
        this.name = name;
        this.p = p;
        this.s = s;
    }

    @Override
    public int compareTo(Pokemon o) {
        if (num > o.getNumber()) {
            return 1;
        }
        if (o.getNumber() > num) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (null == o) { return false; }
        if (this == o) { return true; }
        if (!(o instanceof Pokemon)) { return false; }
        Pokemon aPoke = (Pokemon) o;
        return this.getNumber() == (aPoke.getNumber());

    }

    @Override
    public int hashCode() {
        // TODO
        return num;
    }

    @Override
    public String toString() {
        String output = "";
        output += "Pokemon number: " + num + " Name: "
            + name + " Type 1: " + p + " Type 2: " + s;
        String output2 = String.format(
            "# %d %4s PRIMARY TYPE: %4s SECONDARY TYPE: %4s", num, name, p, s);
        return output2;
    }

    /**
     * @return  the name of this Pokemon
     */
    public String getName() {
        // TODO
        return name;
    }

    /**
     * @return  the unique number of this Pokemon
     */
    public int getNumber() {
        // TODO
        return num;
    }

    /**
     * @return  the primary type of this Pokemon
     */
    public PokemonType getPrimaryType() {
        // TODO
        return p;
    }

    /**
     * @return  the secondary type of this Pokemon
     */
    public PokemonType getSecondaryType() {
        // TODO
        return s;
    }
}
