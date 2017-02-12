package first;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginPage extends Application {

	private BorderPane myPane;
	private TextField userName;
	private TextField password;

	private String name;
	private String passWord;
	private PasswordField passWordField;
	
	private Button login;

	private void handleLoginAction(ActionEvent event) {
	//	System.out.println("sup");
	}

	public boolean validateLogin() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, SQLException {
		String[] userName_passWord = new String[2];
		userName_passWord[0] = userName.getText();// user name
		userName_passWord[1] = passWordField.getText();// password
		name=userName_passWord[0];
		ValidateLogin vL = new ValidateLogin(userName_passWord[0],
				userName_passWord[1]);
		boolean valid = vL.getValidity();
		return valid;
	}

	public Button login() {
	 login = new Button("Login");
		// login.setOnAction( (e) -> validateLogin(e) );
/**		login.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent evt) {
				try {
					validateLogin();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		*/
		return login;
	}

	public TextField userName() {
		userName = new TextField();
		userName.setPromptText("Username");
		return userName;
	}

	public TextField password() {
		password = new TextField("Password");
		return password;
	}
	
	public PasswordField passwordField(){
		passWordField=new PasswordField();
		passWordField.setPromptText("Password");
		return passWordField;
	}

	private GridPane grid() {
		GridPane gPane = new GridPane();
		gPane.setAlignment(Pos.CENTER);
		gPane.add(userName(), 1, 1);
		gPane.add(passwordField(), 1, 2);
		gPane.add(login(), 1, 3);

		gPane.setHgap(10);
		gPane.setVgap(10);
		gPane.setPadding(new Insets(25, 25, 25, 25));
		return gPane;
	}

	public void start(Stage loginStage) throws Exception {
		myPane = new BorderPane();
		myPane.setCenter(grid());

		Scene scene = new Scene(grid(), 500, 200);
		HomePage homePage=new HomePage();
		
		loginStage.setMaxWidth(500);
		loginStage.setMaxHeight(200);
		loginStage.setScene(scene);
		loginStage.setTitle("Welcome");
		loginStage.show();
		login.setOnMouseEntered(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent evt) {
				scene.setCursor(Cursor.HAND);
			}
		});
		login.setOnMouseExited(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent evt) {
				scene.setCursor(Cursor.DEFAULT);
			}
		});
		login.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent evt) {
				try {
					if(validateLogin()){
					Stage homeStage=new Stage();
					loginStage.close();
					homePage.setUserName(name);
					homePage.start(homeStage);
						//	loginStage.setScene(new Scene(homePage));
					}
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});


	}

	public static void main(String[] args) {
		launch(args);
	}

}
