package sample;

import Task1.Task1Main;
import Task2.Task2Main;
import Task3.Task3Main;
import Task4.Task4Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {

    @FXML
    TextArea task1Strings;

    @FXML
    TextArea task1Result;

    @FXML
    TextField task2CountElements;

    @FXML
    TextField task2FindColor;

    @FXML
    TextArea task2Result;

    @FXML
    TextField task3Count;

    @FXML
    TextArea task3Result;

    @FXML
    TextField task4CountThread;

    @FXML
    TextField task4CountRow;

    @FXML
    TextArea task4Result;

    public void StartTask1(ActionEvent event)
    {
        String text = task1Strings.getText();
        String[] args = text.split(" ");

        try {
            ArrayList<String> list = Task1Main.main(args);
            task1Result.clear();
            for (int i = 0; i < list.size(); i++) {
                task1Result.appendText(list.get(i) + " ");
            }
        }
        catch (IllegalArgumentException exc)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Внимание");
            alert.setHeaderText(null);
            alert.setContentText("Нет данных для обработки");

            alert.showAndWait();
        }
    }

    public void StartTask2(ActionEvent event)
    {
        String[] args = new String[2];
        args[0] = task2CountElements.getText();
        args[1] = task2FindColor.getText();

        try {
            task2Result.clear();
            Task2Main.main(args, task2Result);
        }
        catch (IllegalArgumentException exc)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Внимание");
            alert.setHeaderText(null);
            alert.setContentText(exc.getMessage());

            alert.showAndWait();
        }
    }

    public void StartTask3(ActionEvent event)
    {
        task3Result.clear();

        String[] args = new String[1];
        args[0] = task3Count.getText();

        try {
            Task3Main.main(args, task3Result);
        }
        catch (IllegalArgumentException exc)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Внимание");
            alert.setHeaderText(null);
            alert.setContentText(exc.getMessage());

            alert.showAndWait();
        }
    }

    public void StartTask4(ActionEvent event)
    {
        task4Result.clear();

        String[] args = new String[2];
        args[0] = task4CountThread.getText();
        args[1] = task4CountRow.getText();

        try {
            Task4Main.main(args, task4Result);
        }
        catch (IllegalArgumentException exc)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Внимание");
            alert.setHeaderText(null);
            alert.setContentText(exc.getMessage());

            alert.showAndWait();
        }
    }
}
