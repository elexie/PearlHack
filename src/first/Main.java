package first;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	private BorderPane root;
	Scene scene;
	double height;
	double width;
	TextField searchField;
	String solutionName;
	String solutionLanguages;
	String solutionsFolder = "C:\\Users\\Elexie\\Desktop\\pearlHacks\\predefinedSolutions";
	SolutionArea[] sa = new SolutionArea[5];

	public void setSolutionName(String solName) {
		this.solutionName = solName;
	}

	public void setSolutionLanguages(String langs) {
		this.solutionLanguages = langs;
	}

	// returns the code from the file as a string
	public String getAsString(String filePath) throws IOException {
		String output = "";
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line = "";
		while ((line = br.readLine()) != null) {
			output += line.trim();
		}
		return output;
	}

	// puts the code in the text area
	public void setCode() throws IOException {
		String[] languages = solutionLanguages.trim().split(",");
		// System.out.println("solutionLanguages: "+solutionLanguages);
		// System.out.println("languages: "+languages[0]);
		// System.out.println("solutionName: "+solutionName);
		// System.out.println("languages length: "+languages.length);
		for (int x = 0; x < languages.length; x++) {
			sa[x].setText(getAsString(solutionsFolder + "\\" + languages[x]
					+ "\\" + solutionName + ".txt"));
		}
	}

	@Override
	public void start(Stage primaryStage) throws IOException {

		// components of the Borderpane
		root = new BorderPane();
		root.setTop(topBar());
		// root.setRight(getRightHBox());
		// root.setBottom(getFooter());
		// root.setLeft(getLeftHBox());
		root.setCenter(center());

		scene = new Scene(root, 300, 300);
		height = scene.getHeight();
		width = scene.getWidth();

		// sf=new SolutionField(500,50);
		// sf.setMinWidth(width/2);
		// sf.setMinHeight(height/2);

		primaryStage.setTitle("Split");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public TextField searchField() {
		searchField = new TextField("Your Search Here");
		// searchField.setPadding(new Insets(20,-10,0,0));
		return searchField;
	}

	private MenuBar getMenu() {
		MenuBar menuBar = new MenuBar();

		Menu menuFile = new Menu("File");
		Menu menuEdit = new Menu("Edit");
		Menu menuHelp = new Menu("Help");
		Menu addMenu = new Menu("Add");
		// Button b=new Button("");
		// b.setOnAction( (e) -> System.out.println("hi"));
		// hbox.getChildren().add(b);
		addMenu.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {

						System.out.println("clicked");
						addMenu.setText("hi");
					}

				});
		menuBar.getMenus().addAll(menuFile, menuEdit, menuHelp, addMenu);

		return menuBar;
	}

	private HBox right() {
		HBox hbox = new HBox();

		VBox vbox = new VBox(50);
		vbox.setPadding(new Insets(0, 20, 0, 20));
		vbox.setAlignment(Pos.CENTER);

		vbox.getChildren().addAll(new Text("Additional Info 1"),
				new Text("Additional Info 2"), new Text("Additional Info 3"));
		hbox.getChildren().addAll(new Separator(Orientation.VERTICAL), vbox);

		return hbox;
	}

	private HBox leftHBox() {
		HBox hbox = new HBox();

		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(10));

		Text text = new Text("Navigation");
		text.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));

		VBox vboxText = new VBox(10);
		for (int i = 1; i <= 10; i++) {
			vboxText.getChildren().add(new Text("Category " + i));
		}
		vboxText.setTranslateX(10);

		vbox.getChildren().addAll(text, vboxText);
		hbox.getChildren().addAll(vbox, new Separator(Orientation.VERTICAL));

		return hbox;
	}

	private HBox topBar() {
		HBox topBar = new HBox();
		Button homeButton = new Button("Home");
		Button addButton = new Button("Add");

		// topBar.getChildren().addAll(homeButton,addButton,searchField());

		return topBar;
	}

	private HBox center() throws IOException {
		HBox hbox = new HBox();
		sa[0] = new SolutionArea();
		sa[1] = new SolutionArea();
		sa[2] = new SolutionArea();
		sa[3] = new SolutionArea();
		sa[4] = new SolutionArea();

		// set the properties of the solution area
		for (int x = 0; x < sa.length; x++) {
			sa[x].setWrapText(true);
		}

		// add the solution areas to the hbox
		for (int x = 0; x < sa.length - 1; x++) {
			hbox.getChildren().add(sa[x]);
		}

		// set the code of the textarea
		setCode();

		/**
		 * SolutionArea sa1 = new SolutionArea(); sa1.setWrapText(true);
		 * hbox.getChildren().addAll(sa1);
		 * 
		 * SolutionArea sa2 = new SolutionArea(); sa2.setWrapText(true);
		 * hbox.getChildren().addAll(sa2);
		 * 
		 * SolutionArea sa3 = new SolutionArea(); sa3.setWrapText(true);
		 * //sa3.setOnMouseClicked((e) -> System.out.println("clicked"));
		 * hbox.getChildren().addAll(sa3);
		 * 
		 * SolutionArea sa4 = new SolutionArea(); sa4.setWrapText(true);
		 * //hbox.getChildren().addAll(sa4);
		 */
		hbox.setFillHeight(true);

		return hbox;
	}

	public static void main(String[] args) {

		launch(args);
	}
}