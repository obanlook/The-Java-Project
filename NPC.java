import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public abstract class NPC {

    private final String name;
    private Set<Language> languages = new HashSet<>();

    //Constructor
    public NPC(String name) {
        this.name = name;
    }

    // Abstract method(s)
    public abstract String talk(Player player);


    // Getters
    public String getName() {
        return name;
    }

    public boolean canSpeak(Language lang) {
        return languages.contains(lang);
    }

    public List<Language> getLanguages() {
        return new ArrayList<>(languages);
    }

    //Learn language(after using dictionary)
    public void addLanguage(Language lang) {
        languages.add(lang);
    }



}
