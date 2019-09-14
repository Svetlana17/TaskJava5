package Task2;

public class House {
    private int _countFloor;

    public House(int count)
    {
        _countFloor = count;
    }

    public String toString()
    {
        return (getClass().getSimpleName() + " " + _countFloor);
    }
}
