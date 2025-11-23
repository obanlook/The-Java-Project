import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public abstract class Location {

    protected String name;
    protected String description;
    protected Map<Direction,Location> exits = new HashMap<>();
    protected List<Item> groundItems  =  new ArrayList<>();
    protected List<Character> characters = new ArrayList<>();
    protected boolean locked = false;
    protected boolean dark = false;

    public Location(String name, String description, boolean locked, boolean dark) {
        this.name = name;
        this.description = description;
        this.locked = locked;
        this.dark = dark;
    }

    public String look(){
        return description;
    }

    public void addItem(Item item){
        groundItems.add(item);
    }
    public void addCharacter(Character character){
        characters.add(character);
    }

    public void unlock(){  //not our case yet

        locked = false;
    }

    public void enlighten(){ //not our case yet
        dark = false;
    }


    //Getters
    public Location getExit(Direction direction){

        return exits.get(direction);
    }


    public List<Character> getCharacters(){
        return characters;
    }

    public boolean getIsLocked(){

        return locked;
    }

    public boolean getIsDark(){

        return dark;
    }




}
