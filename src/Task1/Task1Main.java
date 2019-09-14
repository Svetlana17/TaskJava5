package Task1;

import javafx.scene.control.TextArea;
import sample.Controller;

import java.util.ArrayList;

public class Task1Main {
    static boolean checkInteger(String s)
    {
        if (s.isEmpty())
            return false;

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    static int sumDigit(int num)
    {
        int sum = 0;

        while (num != 0)
        {
            int last = num % 10;

            sum += last;
            num /= 10;
        }

        return sum;
    }

    static boolean checkHappy(String s)
    {
        int num = Integer.parseInt(s);
        int len = s.length();

        int k = (int)Math.pow(10, len / 2);

        int first = num / k;
        int second = num % k;

        return sumDigit(first) == sumDigit(second);
    }

    static boolean checkPalindrom(String s)
    {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }

        return true;
    }

    public static ArrayList<String> main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();

        if (args.length == 0)
            throw new IllegalArgumentException("Нет аргументов");

        for (int i = 0; i < args.length; i++) {
            if (args[i].length() % 2 == 0) {
                if (checkInteger(args[i])) {
                    if (checkHappy(args[i]))
                        list.add(args[i]);
                } else {
                    if (checkPalindrom(args[i]))
                        list.add(args[i]);
                }
            }
        }

        return list;
    }
}
