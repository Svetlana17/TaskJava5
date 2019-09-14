package Task2;

import java.awt.*;

public class Pen implements Colored
{
    @Override
    public Color getColor() {
        return _color;
    }

    @Override
    public String whoAmI() {
        return (getClass().getSimpleName() + " " + getColor(_color));
    }
}
