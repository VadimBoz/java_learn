public class Cat extends Animal implements Speakable,Runable, Swimable {

    public Cat(String nickname, int legs, String owner) {
        super(nickname, legs, owner);
    }

    @Override
    public String speak() {
        return "Myau";
    }

    @Override
    public Integer runSpeed() {
        return 50;
    }

    @Override
    public String toString() {
        return "Cat" + super.toString();
    }

    @Override
    public int swimSpeed() {
        return 1;
    }
}
