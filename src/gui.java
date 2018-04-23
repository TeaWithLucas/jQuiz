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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group; 

public class gui extends Application {

    private static final String styleHide = "-fx-skin: \"com.sun.javafx.scene.control.skin.ButtonSkin\"; -fx-base: gray; -fx-padding: 2; -fx-font-weight: bold; -fx-text-fill: #FFF; -fx-background-radius: 0 10 10 0;";
    private static final String styleShow = "-fx-skin: \"com.sun.javafx.scene.control.skin.ButtonSkin\"; -fx-base: gray; -fx-padding: 2; -fx-font-weight: bold; -fx-text-fill: #FFF; -fx-background-radius: 10 0 0 10;";
    private final double minWidth = 5;
    private final double maxWidth = 170;
    private final int Width = 1080;
    private final int Height = 980;
    private boolean hidden = true;

    public static void main(String[] args) {
        launch(args);
    }

    private Pane root;
    private Stage stage;
    
    @Override
    public void start(Stage primaryStage) {
    	stage = primaryStage;
    	primaryStage.setTitle("jQuiz Master");
    	startScreen();
    	
    	primaryStage.show();
    }
    
    private void QuestionFrame() {
    	BorderPane borderPane = new BorderPane();
        root = new Pane();
        root.getChildren().add(borderPane);
    	Scene questionScene = new Scene(root, Width, Height);
    	questionScene.getStylesheets().add("question.css");
    	
        

        borderPane.prefWidthProperty().bind(root.widthProperty());
        borderPane.prefHeightProperty().bind(root.heightProperty());

        String question = "Question 1: Where's the beef?";
        Pane topPane = questionMenuTop();
        borderPane.setTop(topPane);	
        
        GridPane middlePane = new GridPane();
        borderPane.setCenter(middlePane);
        
        String[] answers = {"test1", "Test2"};
        middlePane.addRow(0, questionFrame(question));
        middlePane.addRow(1, answerFrame(answers));     
        
        stage.setScene(questionScene);

        
    }
    
    private void startScreen() {
    	BorderPane borderPane = new BorderPane();
        root = new Pane();
        root.getChildren().add(borderPane);
    	Scene startScene = new Scene(root, Width, Height);
    	startScene.getStylesheets().add("startscreen.css");
        
        

        borderPane.prefWidthProperty().bind(root.widthProperty());
        borderPane.prefHeightProperty().bind(root.heightProperty());
        
        VBox mainBox = new VBox();
        mainBox.setStyle("-fx-background-color: lightgray;");
        mainBox.setAlignment(Pos.CENTER);
        
        borderPane.setCenter(mainBox);
        
        Text mainText = new Text("jQuiz");
        mainText.setFont(Font.font ("Verdana", 40));
        mainBox.getChildren().add(mainText);
        
        VBox choiceBox = new VBox();
        choiceBox.setStyle("-fx-background-color: lightgray;");
        choiceBox.setAlignment(Pos.CENTER);
        Button quizButton = new Button("Quiz");
        quizButton.setOnMouseClicked(e -> { QuizStartScreen("Poo and shit"); });
        choiceBox.getChildren().add(quizButton);
        Button loginButton = new Button("Login");
        loginButton.setOnMouseClicked(e -> { QuizStartScreen("Poo and shit"); });
        choiceBox.getChildren().add(loginButton);
        
        borderPane.setCenter(choiceBox);
        
        stage.setScene(startScene);
    }
    
    private void QuizStartScreen(String topicName) {
    	BorderPane borderPane = new BorderPane();
        root = new Pane();
        root.getChildren().add(borderPane);
    	Scene quizSSScene = new Scene(root, Width, Height);
    	quizSSScene.getStylesheets().add("quizstartscreen.css");
    	
        borderPane.prefWidthProperty().bind(root.widthProperty());
        borderPane.prefHeightProperty().bind(root.heightProperty());
        
        Pane topPane = questionMenuTop();
        borderPane.setTop(topPane);	
        
        
        VBox box = new VBox();
        box.setStyle("-fx-background-color: lightgray;");
        box.setAlignment(Pos.CENTER);
        
        Text mainText = new Text("Welcome to the Quiz on "+ topicName);
        mainText.setFont(Font.font ("Verdana", 40));
        box.getChildren().add(mainText);
        Text getStarted = new Text("Click here to start!");
        getStarted.setFont(Font.font ("Verdana", 30));
        box.getChildren().add(getStarted);
        getStarted.setOnMouseClicked(e -> { QuestionFrame(); });
        
        borderPane.setCenter(box);

        stage.setScene(quizSSScene);
        
    }

    private GridPane getRightContent() {
        GridPane pane = new GridPane();

        Text txt = new Text("Right Content");
        //txt.setWrappingWidth(maxWidth - 20);

        //pane.setVgap(10);
        pane.setStyle("-fx-padding: 5; -fx-background-color: gray;");
        pane.addColumn(0, txt);

        return pane;
    }
    
    private GridPane questionFrame(String question) {
        GridPane pane = new GridPane();

        Text txt = new Text(question);
        txt.setFont(Font.font ("Verdana", 30));
        //txt.setWrappingWidth(maxWidth - 20);

        //pane.setVgap(10);
        //pane.setStyle("-fx-padding: 5; -fx-background-color: gray;");
        pane.addColumn(0, txt);
        
        return pane;
    }
    
    private GridPane questionMenuTop() {
        GridPane pane = new GridPane();

        Button quitButton = new Button("< Quit");
        Button restartButton = new Button("Restart");
        
        quitButton.setOnMouseClicked(e -> { startScreen(); });
        restartButton.setOnMouseClicked(e -> { QuizStartScreen("Poo and shit"); });

        //pane.setVgap(10);
        pane.setStyle("-fx-padding: 5; -fx-background-color: gray;");
        pane.addColumn(0, quitButton);
        pane.addColumn(1, restartButton);
        
        return pane;
    }
    
    
    private GridPane getBottomContent(String[] Answers) {
        GridPane pane = new GridPane();
        
       
        //pane.setVgap(10);
        pane.setStyle("-fx-padding: 5; -fx-background-color: gray;");
        
        pane.addRow(0, new Label("Answers"));
        for(int i=0; i<5;i++) {
        	pane.add(new Button("Button "+(i+1)), i, 1);
        }

        return pane;
    }
    
    private GridPane answerFrame(String[] Answers) {
       GridPane pane = new GridPane();
       
       
       //pane.setVgap(10);
       pane.setStyle("-fx-padding: 5; -fx-background-color: gray;");
       
       pane.addRow(0, new Label("Answers"));
       for(int i=0; i<Answers.length;i++) {
    	   pane.add(new Button(Answers[i]), i, 1);
       }

        return pane;
    }
}