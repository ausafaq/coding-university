package Builder;

public abstract class Soda implements Item {

    @Override
    public Packing packing() {
        return new Tumbler();
    }

    @Override
    public abstract float price();

}
