package Task4;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

class MyThread implements Runnable{

    private int countString;
    private int number;
    MyThread next;

    MyThread(int number, int count)
    {
        this.number = number;
        this.countString = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < countString; i++) {
            if (!(number == 0 && i == 0) && this != next)
            {
                synchronized (this)
                {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            if (number == 0)
                Platform.runLater(() -> Task4Main._textArea.appendText("\n"));

            Platform.runLater(() -> Task4Main._textArea.appendText("Thread " + number + " "));

            synchronized (next) {
                next.notify();
            }
        }
    }
}

public class Task4Main {
    public static TextArea _textArea;

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

    public static void main(String[] args, TextArea textArea) {

        if (args.length < 2)
            throw new IllegalArgumentException("Недостаточное кол-во аргументов");

        if (!checkInteger(args[0]) || !checkInteger(args[1]))
            throw new IllegalArgumentException("Аргументы должны быть целыми числами!");

        _textArea = textArea;
        int countThread = Integer.parseInt(args[0]);
        int countString = Integer.parseInt(args[1]);

        MyThread[] threads = new MyThread[countThread];
        for (int i = 0; i < countThread; i++) {
            threads[i] = new MyThread(i, countString);
        }

        for (int i = 0; i < countThread - 1; i++) {
            threads[i].next = threads[i+1];
        }

        threads[countThread-1].next = threads[0];

        for (int i = countThread-1; i >= 0; i--) {
            Thread thread = new Thread(threads[i]);
            thread.start();
        }
    }
}
