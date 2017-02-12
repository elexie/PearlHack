package first;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchBox extends Application{
	BorderPane myPane;//this pane will hold the grid pane
	
	private CheckBox java(){
		CheckBox javaCheckBox=new CheckBox();
		return javaCheckBox;
	}
	private CheckBox python(){
		CheckBox pythonCheckBox=new CheckBox();
		return pythonCheckBox;
	}
	private CheckBox cpp(){
		CheckBox cppCheckBox=new CheckBox();
		return cppCheckBox;
	}
	private CheckBox cSharp(){
		CheckBox cppCSharpBox=new CheckBox();
		return cppCSharpBox;
	}
	private CheckBox javaScript(){
		CheckBox javascriptCheckBox=new CheckBox();
		return javascriptCheckBox;
	}
	private VBox checkBoxes(){
		VBox checkBoxes=new VBox();
		checkBoxes.getChildren().add(java());
		checkBoxes.getChildren().add(python());
		checkBoxes.getChildren().add(cpp());
		checkBoxes.getChildren().add(cSharp());
		checkBoxes.getChildren().add(javaScript());
		
		return checkBoxes;
	}
	private VBox resultsBox(){
		VBox resultsBox=new VBox();
		resultsBox.getChildren().add(new Label("Java"));
		resultsBox.getChildren().add(new Label("Python"));
		resultsBox.getChildren().add(new Label("C++"));
		resultsBox.getChildren().add(new Label("C#"));
		resultsBox.getChildren().add(new Label("JavaScript"));
		
		return resultsBox;
	}
	private TextField searchField(){
		TextField searchField=new TextField();
		return searchField;
	}
	//gridpane will hold the search field
	//and the results
	private GridPane grid() {
		GridPane gPane = new GridPane();
		gPane.add(searchField(),1,1);
		gPane.add(checkBoxes(),1,2);
		gPane.add(resultsBox(),2,2);
		
		gPane.setAlignment(Pos.CENTER);
		gPane.setHgap(10);
		gPane.setVgap(10);
		gPane.setPadding(new Insets(0));

		return gPane;
	}

	@Override
	public void start(Stage searchStage) throws Exception {
		myPane = new BorderPane();
		myPane.setCenter(grid());
		Scene scene = new Scene(grid(), 500, 500);

		searchStage.setMaxWidth(500);
		searchStage.setMaxHeight(500);
		searchStage.setScene(scene);
		searchStage.setTitle("Search Here");
		searchStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
