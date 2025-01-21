public class SurvivorLeader {
    private String transmission = "q2xf1t8r5w3t tm9c5i8l900d5n7heto 3g5t6hgw44y5e7bhty605rh8t5 85ml95ak2k5r7qw5ksp295e5t7p45 o5i3n 6z5n205 9soe5o8hhg5lygtt5dq7th 5 gf34s9o 35j7j5o45k99hg5kyqqcjg5mkpl20z5o629sle5k20sk5k9c5 gh73h qxp25vi8t5i3f2v1q 9x7z6t5l8r9j3o4v5l3l1w 9y5a4d6f7x2c9l5g h8s45ek6";
    public Shelter shelters[] = new Shelter[40];

    public static void main(String[] args) {
        SurvivorLeader sL = new SurvivorLeader();
    }

    public SurvivorLeader(){
        System.out.println("Goodbye world! Good luck surviving the apocalypse!");
        for (int x = 0; x < 40; x++){
            int defense = (int)(Math.random()*100) + 1;
            int supplies = (int)(Math.random()*1001);
            shelters[x] = new Shelter(defense,supplies);
        }
        displayShelters();
        checkSupplies();
        System.out.println(checkSupplies());
        decipher(transmission);
        System.out.println(decipher(transmission));
        newDefense();
        displayShelters();
        checkSupplies();
        System.out.println(checkSupplies());
    }

    public void displayShelters(){
        for (int x = 0; x < 40; x++){
            shelters[x].printInfo();
        }
    }

    public boolean checkSupplies(){
        boolean checkSuccesful = false;


        for (int x = 0; x < 750; x++){;
            int currentCheck1 = (int)(Math.random()*40);
            int currentCheck2 = (int)(Math.random()*40);
            if (shelters[currentCheck1].getNumberOfSupplies() == shelters[currentCheck2].getNumberOfSupplies() && currentCheck2 != currentCheck1){
                System.out.println("Supplies are the same at " + shelters[currentCheck1].getNumberOfSupplies());
                checkSuccesful = true;
            }
        }
        return checkSuccesful;
    }

    public String decipher(String paramTransmission){
        String decoddedString = "";
        paramTransmission = transmission;
        int fiveLocation = paramTransmission.indexOf("5") + 1;
        while (fiveLocation != 0){
            String sub = paramTransmission.substring(fiveLocation, fiveLocation + 1);
            decoddedString += sub;
            fiveLocation = paramTransmission.indexOf("5", fiveLocation) + 1;
        }
        return decoddedString;
    }

    public void newDefense(){
        if (checkSupplies() == true) {
            while (checkSupplies() == true) {
                for (int x = 0; x < 40; x++) {
                    int defense = (int) (Math.random() * 100) + 1;
                    int supplies = (int) (Math.random() * 1001);
                    shelters[x] = new Shelter(defense, supplies);
                }
                checkSupplies();
            }
        }
    }
}
