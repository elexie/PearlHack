package first;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HomePage extends Application{
	
	BorderPane myPane;//holds gridpane
	private Button savedSolutionsButton;
	String userName;
	private Label savedSolutions;
	//Stage aStage;//this stage will be passed 
	//as a parameter to the run method, so that when 
	//it is called from LoginPage.java,
	public static void main(String[] args) {
		launch(args);
	}

	private Label savedSolutionsLabel(){
	 savedSolutions=new Label("My Saved Solutions");
	/**	savedSolutionsLabel().setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent evt) {
				System.out.println("save solutions clicked");
			}
		});
		*/
		
		return savedSolutions;
	}
	private Button savedSolutionsButton(){
		 savedSolutionsButton=new Button("My Saved Solutions");
		return savedSolutionsButton;
	}
	private StackPane savedSolutions(){
		StackPane savedSolutions=new StackPane();
		savedSolutions.getChildren().add
		(savedSolutionsButton());
		return savedSolutions;
	}
	private GridPane grid() {
		GridPane gPane = new GridPane();
		gPane.setAlignment(Pos.CENTER);
	
		//saved solutions
		gPane.add(savedSolutions(),1,1);

		gPane.setHgap(10);
		gPane.setVgap(10);
		gPane.setPadding(new Insets(25, 25, 25, 25));

		return gPane;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserName(){
		return this.userName;
	}
	@Override
	public void start(Stage homeStage) throws Exception {
		
		myPane = new BorderPane();
		myPane.setCenter(grid());

		Scene scene = new Scene(grid(), 500, 500);
		savedSolutionsButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent evt) {
			scene.setCursor(Cursor.HAND);
			}
		});
		savedSolutionsButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent evt) {
			scene.setCursor(Cursor.DEFAULT);
			}
		});
		savedSolutionsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent evt) {
				Stage savedSolStage=new Stage();
				SavedSolutions s=new SavedSolutions();
				try {
					s.setUserFolder(getUserName());
					s.start(savedSolStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		//		System.out.println("save solutions clicked");
				//show a popup of all the user's solutions
				//queried from the db
		//for now: print out all user's solutions
			}
		});
		homeStage.setMaxWidth(500);
		homeStage.setMaxHeight(500);
		homeStage.setScene(scene);
		homeStage.setTitle("Home Page");
		homeStage.show();
		
	}
	
	
	
}
