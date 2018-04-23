import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group; 

public class gui extends Application {

    private static final String styleHide = "-fx-skin: \"com.sun.javafx.scene.control.skin.ButtonSkin\"; -fx-base: gray; -fx-padding: 2; -fx-font-weight: bold; -fx-text-fill: #FFF; -fx-background-radius: 0 10 10 0;";
    private static final String styleShow = "-fx-skin: \"com.sun.javafx.scene.control.skin.ButtonSkin\"; -fx-base: gray; -fx-padding: 2; -fx-font-weight: bold; -fx-text-fill: #FFF; -fx-background-radius: 10 0 0 10;";
    private final double minWidth = 5;
    private final double maxWidth = 170;
    private boolean hidden = true;

    public static void main(String[] args) {
        launch(args);
    }

    private Pane root;

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        root = new Pane();
        root.getChildren().add(borderPane);

        borderPane.prefWidthProperty().bind(root.widthProperty());
        borderPane.prefHeightProperty().bind(root.heightProperty());

        final Pane rightPane = getRightContent();
        borderPane.setRight(rightPane);
        
        String question = "Question 1: Where's the beef?";
        final Pane topPane = getTopContent(question);
        borderPane.setTop(topPane);
        
        VBox box = new VBox();
        box.setStyle("-fx-background-color: lightgray;");
        box.setAlignment(Pos.CENTER_RIGHT);
        
        String[] answers = {"test1", "Test2"};
        final Pane bottomPane = getBottomContent(answers);
        borderPane.setBottom(bottomPane);
        
        
        box.getChildren().add(new Label("Answers"));
        
        for(int i=1; i<5;i++) {
        	box.getChildren().add(new Button("Button "+i));
        }
        
        borderPane.setCenter(box);

        primaryStage.setScene(new Scene(root, 600, 500));

        final Button btn = new Button(" toggle button ");
        btn.setPrefHeight(40);
        btn.setFocusTraversable(false);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                toggleRightContent(btn, rightPane);
            }
        });

        root.getChildren().add(btn);
        toggleRightContent(btn, rightPane);

        primaryStage.show();
    }


    private GridPane getRightContent() {
        GridPane pane = new GridPane();

        Text txt = new Text("Right Content");
        txt.setWrappingWidth(maxWidth - 20);

        pane.setVgap(10);
        pane.setStyle("-fx-padding: 5; -fx-background-color: gray;");
        pane.addColumn(0, txt);

        return pane;
    }
    
    private GridPane getTopContent(String question) {
        GridPane pane = new GridPane();

        Text txt = new Text(question);
        txt.setWrappingWidth(maxWidth - 20);

        pane.setVgap(10);
        pane.setStyle("-fx-padding: 5; -fx-background-color: gray;");
        pane.addColumn(0, txt);

        return pane;
    }
    
    
    private GridPane getBottomContent(String[] Answers) {
        GridPane pane = new GridPane();
        
       
        pane.setVgap(10);
        pane.setStyle("-fx-padding: 5; -fx-background-color: gray;");
        
        pane.addRow(0, new Label("Answers"));
        for(int i=0; i<5;i++) {
        	pane.add(new Button("Button "+(i+1)), i, 1);
        }

        return pane;
    }

    private void toggleRightContent(Button btn, Pane pane) {
        if (hidden) {
            btn.setStyle(styleHide);
            pane.setMaxWidth(maxWidth);
            pane.setMinWidth(maxWidth);
            pane.setPrefWidth(maxWidth);
            btn.layoutXProperty().bind(root.widthProperty().subtract(maxWidth));
        } else {
            btn.setStyle(styleShow);
            pane.setMaxWidth(minWidth);
            pane.setMinWidth(minWidth);
            pane.setPrefWidth(minWidth);
            btn.layoutXProperty().bind(root.widthProperty().subtract(minWidth).subtract(btn.widthProperty()));
        }
        hidden = !hidden;
    }
}