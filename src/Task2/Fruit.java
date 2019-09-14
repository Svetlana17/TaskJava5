package Task2;

import java.awt.*;

public class Fruit implements Colored {
    private Color _color;

    @Override
    public void setColor(Color color)
    {
        _color = color;
    }

    @Override
    public Color getColor() {
        return _color;
    }

    @Override
    public String whoAmI() {
         return (getClass().getSimpleName() + " " + getColor(_color));
    }
}
