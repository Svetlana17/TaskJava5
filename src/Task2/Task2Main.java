package Task2;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import javafx.scene.control.TextArea;

public class Task2Main {

    static boolean checkInteger(String s)
    {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args, TextArea textArea)
    {
        try
        {
            if (args.length < 2)
                throw new IllegalArgumentException("Аргументов меньше чем два");

            if (!checkInteger(args[0]))
                throw new IllegalArgumentException("Некорректный первый аргумент (должно быть целое положительное число)");

            int n = Integer.parseInt(args[0]);

            Object[] objects = new Object[n];

            Color[] colors = new Color[3];
            colors[0] = new Color(255,0,0);
            colors[1] = new Color(0,255,0);
            colors[2] = new Color(0,0,255);

            String[] models = {"Opel", "Mazda", "Mersedes", "BMW"};

            Random random = new Random();

            for (int i = 0; i < n/2; i++) {
                int k = random.nextInt(2);
                Colored obj = null;
                if (k == 0)
                    obj = new Pen();
                else
                    obj = new Fruit();

                obj.setColor(colors[random.nextInt(colors.length)]);
                objects[i] = obj;
            }

            for (int i = n/2; i < n; i++) {
                int k = random.nextInt(2);

                if (k == 0)
                    objects[i] = new Car(models[random.nextInt(models.length)]);
                else
                    objects[i] = new House(random.nextInt(10)+3);
            }

            textArea.appendText("Исходные данные\n");

            for (int i = 0; i < n; i++) {
                if (objects[i] instanceof Colored)
                {
                    Colored colored = (Colored)objects[i];
                    textArea.appendText(colored.whoAmI()+ "\n");
                }
                else
                {
                    textArea.appendText(objects[i].toString()+ "\n");
                }
            }

            String findColor = args[1];
            textArea.appendText("Результат поиска по цвету\n");

            for (int i = 0; i < n; i++) {
                if (objects[i] instanceof Colored) {
                    Colored colored = (Colored) objects[i];
                    String currentColor = colored.getColor(colored.getColor());

                    if (findColor.compareTo(currentColor) == 0)
                        textArea.appendText(colored.whoAmI()+ "\n");
                }
            }
        }
       catch (IllegalArgumentException exc)
       {
           System.out.println(exc.getMessage());
       }
    }
}
