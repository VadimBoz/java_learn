public class Crocodile extends Animal implements Swimable, Runable  {

    public Crocodile(String nickname, int legs, String owner) {
        super(nickname, legs, owner);
    }

    @Override
    public Integer runSpeed() {
        return 9;
    }

    @Override
    public String toString() {
        return "Crocodile" + super.toString();
    }

    @Override
    public int swimSpeed() {
        return 15;
    }


}
