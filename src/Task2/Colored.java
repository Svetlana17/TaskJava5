package Task2;

import java.awt.*;

public interface Colored {
    Color _color = new Color(255,0,0);

    default void setColor(Color color)
    {
    }

    Color getColor();
    String whoAmI();

    default String getColor(Color color)
    {
        switch (color.toString())
        {
            case "java.awt.Color[r=0,g=255,b=0]":
                return "GREEN";
            case "java.awt.Color[r=255,g=0,b=0]":
                return "RED";
            case "java.awt.Color[r=0,g=0,b=255]":
                return "BLUE";
            default:
                return color.toString();
        }
    }
}
