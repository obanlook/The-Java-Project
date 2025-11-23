import java.sql.SQLOutput;

public class Wrench extends Item{
    public String examine(){
        return "Wrench! It may help you fix the engine!";
    }

    public boolean use(Player player){
        if(player.getCurrentLocation().equals("Engine")){
            System.out.println("Engine is fixed!\n YOU WON!");
            return true;
        }
        return false;
    }

}
