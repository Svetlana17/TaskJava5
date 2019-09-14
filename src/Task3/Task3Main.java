package Task3;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class Task3Main {
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
        if (args.length == 0)
            throw new IllegalArgumentException("Нет аргументов");

        if (!checkInteger(args[0]))
            throw new IllegalArgumentException("Кол-во посылок должно быть целое число");

        int count = Integer.parseInt(args[0]);
        _textArea = textArea;

        Receiver receiver = new Receiver(count);
        Sender sender = new Sender(receiver, count);

        Thread thread1 = new Thread(sender, "Отправитель");
        Thread thread2 = new Thread(receiver, "Получатель");
        thread2.start();
        thread1.start();
    }
}

class Sender implements Runnable
{
    private int _count;
    private Receiver _receiver;

    public Sender(Receiver receiver, int count)
    {
        _count = count;
        _receiver = receiver;
    }

    @Override
    public void run() {
        for (int i = 0; i < _count; i++) {
            _receiver.send(i);
        }
    }
}

class Receiver implements Runnable
{
    private int _count;

    public Receiver(int count)
    {
        _count = count;
    }

    public synchronized void send(int i)
    {
        String nameThread = Thread.currentThread().getName();
        Platform.runLater(() -> Task3Main._textArea.appendText(nameThread+"\n"));
        Platform.runLater(() ->  Task3Main._textArea.appendText("отправил посылку №" + i + "\n"));

        notify();

        try {
            wait();
        }
        catch (InterruptedException exc)
        {

        }
    }

    public synchronized void receive()
    {
        try {
            wait();
        }
        catch (InterruptedException exc)
        {

        }

        String nameThread = Thread.currentThread().getName();
        Platform.runLater(() ->   Task3Main._textArea.appendText(nameThread + "\n"));
        Platform.runLater(() ->   Task3Main._textArea.appendText("получил посылку\n"));

        notify();
    }

    @Override
    public void run() {
        for (int i = 0; i < _count; i++) {
            receive();
        }
    }
}