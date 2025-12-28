import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EngineCoach extends Location {
    private boolean fixed = false;
    private List<Item> requiredItems = new ArrayList<>();

    public EngineCoach() {
        super(
                "Engine Coach",
                "This is the engine coach. Help the mechanic fix the engine!",
                false, // locked?
                true // dark?

        );

        // The engine requires a wrench to be fixed
        requiredItems.add(new Wrench());
    }


    public boolean isFixed() {
        return fixed;
    }

    public void fixEngine() {
        fixed = true;
    }

}
