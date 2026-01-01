import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EngineCoach extends Location implements WinCondition {
    private boolean fixed = false;

    public EngineCoach() {
        super(
                "Engine Coach",
                "This is the engine coach. Help the mechanic fix the engine!",
                false, // locked?
                true // dark?

        );


    }
    public void fixEngine() {
        fixed = true;
    }

    @Override
    public boolean isSatisfied() {
        return fixed;
    }

}
