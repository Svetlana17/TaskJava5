package Task2;

public class Car {
    private String _model;

    public Car(String model)
    {
        _model = model;
    }

    public String toString()
    {
        return (getClass().getSimpleName() + " " + _model);
    }
}
