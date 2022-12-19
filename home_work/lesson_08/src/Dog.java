public class Dog extends Animal implements Speakable,Runable, Swimable {

    public Dog(String nickname, int legs, String owner) {
        super(nickname, legs, owner);
    }

    @Override
    public String speak() {
        return "Waw";
    }


    @Override
    public Integer runSpeed() {
        return 30;
    }

    @Override
    public String toString() {
        return "Dog" + super.toString();
    }

    @Override
    public int swimSpeed() {
        return 2;
    }
}
