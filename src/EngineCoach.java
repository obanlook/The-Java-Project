import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EngineCoach extends Location{
    private boolean isFixed = false;
    private List<Item> requiredItems = new ArrayList<>(); //items for fixing the engine
    private List<Character> characters = new ArrayList<>();
    public EngineCoach(){
        super("Engine",
                "This is engine coach.\n help mechanic to fix the engine! ",
                false, // locked?
                 false // dark?
        );
        requiredItems.add(new Wrench());
        characters.add(new Mechaninc());



    }
}
