public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.addAnimal(new Cat("Dimka",4,"Oleg"))
                .addAnimal(new Dog("Tuzik",4,"Petya"))
                .addAnimal(new Duck("Donald",2,"Ivan"))
                .addAnimal(new Eagle("Trut",2,"Sasha"))
                .addAnimal(new Crocodile("Tom", 4, "Sava"));

        System.out.println(zoo.toString());
        System.out.println(zoo.talk());
        System.out.println("----Runable-----");
        for (Runable i: zoo.getRunable()) {
            System.out.println(i.runSpeed() + " " + i.getClass().getName());
        }
        System.out.println(zoo.getChampionSpeed());
        System.out.println("----Flyable-----");
        for (Flyable i: zoo.getFlyable())
        {
            System.out.println(i.flySpeed() + " " + i.getClass().getName());
        }

        SaveManagerAnimals saveManagerAnimals = new SaveManagerAnimals();
        saveManagerAnimals.save(zoo.getAnimals());

        System.out.println("------Swimable----");
        for (Swimable i: zoo.getSwimable())
        {
            System.out.println(i.swimSpeed() + " " + i.getClass().getName());
        }




    }
}