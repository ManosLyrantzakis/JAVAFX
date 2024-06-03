import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Main extends Application 
{
    Label lblValue;
    Label lblChoice;
    TextField txtValue;
    ComboBox<String> choCountry;
    Button btn1, btn2;

    @Override
    public void start(Stage stage) 
    {
        lblValue = new Label("Value: ");
        lblChoice = new Label("Choose One: ");

        txtValue = new TextField();
        txtValue.setPrefWidth(300);

        choCountry = new ComboBox<String>();
        choCountry.setEditable(true);
        choCountry.getItems().addAll("Greece", "Ghana", "Spain", "Austria");
        new AutoCompleteComboBoxListener<>(choCountry);

        btn1 = new Button("Set Value");
        btn2 = new Button("Print to the console");
        btn1.setOnAction(e->setValue());
        btn2.setOnAction(e->print());

        HBox pane1 = new HBox();
        pane1.getChildren().addAll(lblValue,txtValue);
        pane1.setAlignment(Pos.CENTER);
        HBox pane2 = new HBox();
        pane2.getChildren().addAll(lblChoice,choCountry);
        pane2.setAlignment(Pos.CENTER);
        HBox pane3 = new HBox();
        pane3.getChildren().addAll(btn1,btn2);
        pane3.setAlignment(Pos.CENTER);
        VBox pane = new VBox();
        pane.getChildren().addAll(pane1,pane2,pane3);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("AUTO COMPLETE");
        stage.setX((Screen.getPrimary().getVisualBounds().getWidth()-500)/2);
        stage.setY((Screen.getPrimary().getVisualBounds().getHeight()-300)/2);
        stage.setWidth(500);
        stage.setHeight(300);
        stage.show();
    }

    public void setValue() 
    {
        if (choCountry.getItems().contains(txtValue.getText()))
            choCountry.setValue(txtValue.getText());
    }

    public void print() 
    {
        System.out.println(choCountry.getValue());
    }

    public static void main(String[] args) {
        launch(args);
    }
}