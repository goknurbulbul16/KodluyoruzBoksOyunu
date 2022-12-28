public class Ring {
    Fighter f1;
    Fighter f2;
    Fighter startingFighter;
    Fighter otherFighter;
    int minWeight;
    int maxWeight;

    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.startingFighter = null;
        this.otherFighter = null;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void chooseStartingFighter()
    {
        double rand = Math.random() * 100;

        if(rand >= 50)
        {
            System.out.println("Maca " + f2.name + " baslayacak.");
            this.startingFighter = f2;
            this.otherFighter = f1;
        }
        else{
            System.out.println("Maca " + f1.name + " baslayacak.");
            this.startingFighter = f1;
            this.otherFighter = f2;
        }
    }

    public void run() {

        if (checkWeight()) {
            chooseStartingFighter();
            while (startingFighter.health > 0 && otherFighter.health > 0) {
                System.out.println("======== YENİ ROUND ===========");
                otherFighter.health = startingFighter.hit(otherFighter);
                if (isWin()){
                    break;
                }
                startingFighter.health = otherFighter.hit(startingFighter);
                if (isWin()){
                    break;
                }
                printScore();
            }

        } else {
            System.out.println("Sporcuların ağırlıkları uyuşmuyor.");
        }


    }

    public boolean checkWeight() {
        return (f1.weight >= minWeight && f1.weight <= maxWeight) && (f2.weight >= minWeight && f2.weight <= maxWeight);
    }

    public boolean isWin() {
        if (startingFighter.health == 0) {
            System.out.println("Maçı Kazanan : " + otherFighter.name);
            return true;
        } else if (otherFighter.health == 0){
            System.out.println("Maçı Kazanan : " + otherFighter.name);
            return true;
        }

        return false;
    }


    public void printScore() {
        System.out.println("------------");
        System.out.println(startingFighter.name + " Kalan Can \t:" + startingFighter.health);
        System.out.println(otherFighter.name + " Kalan Can \t:" + otherFighter.health);
    }
}
