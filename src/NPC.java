import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * The NPC class represents a non-player character in the game.
 * <p>
 * NPCs can interact with the player through dialogue and may
 * speak one or more languages. This class serves as a base class
 * for all specific NPC types.
 * </p>
 */
public abstract class NPC {

    /**
     * The name of the NPC.
     */
    private final String name;

    /**
     * The set of languages the NPC can speak.
     */
    private Set<Language> languages = new HashSet<>();

    /**
     * Constructs an NPC with a given name.
     *
     * @param name the name of the NPC
     */
    //Constructor
    public NPC(String name) {
        this.name = name;
    }

    /**
     * Defines how the NPC talks to the player.
     * This behavior must be implemented by subclasses.
     *
     * @param player the player interacting with the NPC
     * @return a dialogue string spoken by the NPC
     */
    // Abstract method(s)
    public abstract String talk(Player player);

    /**
     * Returns the name of the NPC.
     *
     * @return the NPC's name
     */
    // Getters
    public String getName() {
        return name;
    }

    /**
     * Checks whether the NPC can speak a given language.
     *
     * @param lang the language to check
     * @return {@code true} if the NPC can speak the language,
     *         {@code false} otherwise
     */
    public boolean canSpeak(Language lang) {
        return languages.contains(lang);
    }

    /**
     * Returns a list of languages spoken by the NPC.
     *
     * @return a list of languages
     */
    public List<Language> getLanguages() {
        return new ArrayList<>(languages);
    }

    /**
     * Adds a new language to the NPC's known languages.
     * <p>
     * This is typically used when the player enables communication
     * using a dictionary or similar item.
     * </p>
     *
     * @param lang the language to add
     */
    //Learn language(after using dictionary)
    public void addLanguage(Language lang) {
        languages.add(lang);
    }
}
