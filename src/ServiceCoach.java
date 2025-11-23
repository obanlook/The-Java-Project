public class ServiceCoach extends Location {



    //private int lockLevel = 2; not our case yet

    public ServiceCoach() {
        super("ServiceCoach",// name
                "This is the service coach.\n You can find some tools here!",//description
                false,  // locked?
                false   // dark?
        );
        addItem(new Wrench());
        addCharacter(new Conductor());
    }

//    public int getLockLevel() {
//
//        return lockLevel;
//    }

    private String getName() {
        return name;
    }


}
