package first;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SavedSolutions extends Application {
	String name;
	String userFolder;
	String userName;
	static BufferedReader br;
	private BorderPane myPane;

	Label[] labels = new Label[5];
	Label[] langLabels = new Label[5];

	public Label langLabel1() {
		Label ll1 = new Label("");
		return ll1;
	}

	public Label langLabel2() {
		Label ll2 = new Label("");
		return ll2;
	}

	public Label langLabel3() {
		Label ll3 = new Label("");
		return ll3;
	}

	public Label langLabel4() {
		Label ll4 = new Label("");
		return ll4;
	}

	public Label langLabel5() {
		Label ll5 = new Label("");
		return ll5;
	}

	public Label label1() {
		Label label1 = new Label("");
		return label1;
	}

	public Label label2() {
		Label label2 = new Label("");
		return label2;
	}

	public Label label3() {
		Label label3 = new Label("");
		return label3;
	}

	public Label label4() {
		Label label4 = new Label("");
		return label4;
	}

	public Label label5() {
		Label label5 = new Label("");
		return label5;
	}

	public GridPane grid() {
		GridPane gPane = new GridPane();
		labels[0] = label1();
		labels[1] = label2();
		labels[2] = label3();
		labels[3] = label4();
		labels[4] = label5();
		gPane.setAlignment(Pos.CENTER);
		// add the problem labels
		gPane.add(labels[0], 1, 1);
		gPane.add(labels[1], 1, 2);
		gPane.add(labels[2], 1, 3);
		gPane.add(labels[3], 1, 4);
		gPane.add(labels[4], 1, 5);

		langLabels[0] = label1();
		langLabels[1] = label2();
		langLabels[2] = label3();
		langLabels[3] = label4();
		langLabels[4] = label5();
		// add the solution labels
		gPane.add(langLabels[0], 2, 1);
		gPane.add(langLabels[1], 2, 2);
		gPane.add(langLabels[2], 2, 3);
		gPane.add(langLabels[3], 2, 4);
		gPane.add(langLabels[4], 2, 5);

		return gPane;
	}

	@Override
	public void start(Stage savedSolStage) throws Exception {
		myPane = new BorderPane();
		myPane.setCenter(grid());
		Scene scene = new Scene(grid(), 500, 600);
		showSavedSols();
		savedSolStage.setMaxWidth(300);
		savedSolStage.setMaxHeight(600);
		savedSolStage.setScene(scene);
		savedSolStage.setTitle("My Saved Solutions");
		savedSolStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void setUserFolder(String name) {
		this.userFolder = "C:\\Users\\Elexie\\Desktop"
				+ "\\PearlHacks\\savedSolutions\\" + name;
	}

	public void showSavedSols() throws IOException {
		showLangLabels();
		br = new BufferedReader(new FileReader(userFolder + "\\solutions.txt"));
		String lines = "";
		int x = 0;
		while ((lines = br.readLine()) != null) {
			lines = lines.trim();
			labels[x].setText(lines + " : ");
			String labelText = labels[x].getText();
			String langLabel = langLabels[x].getText();
		//	System.out.println("labelText: "+labelText);
		//	System.out.println("lang label: "+langLabel);
			String getLine=lines;

			labels[x].setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				
				public void handle(MouseEvent e) {
					try {
				//		System.out.println("clicked");
						callMain(getLine, langLabel);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});

			/**
			 * labels[x].setOnMouseClicked((e) ->System.out.println("clicked")
			 * ); labels[x].setOnMouseClicked((e) ->
			 * callMain(labelText,langLabel) );
			 */

			x++;
		}
		//showLangLabels();

	}

	public void showLangLabels() throws IOException {
		br = new BufferedReader(new FileReader(userFolder + "\\languages.txt"));
		String lines = "";
		int x = 0;
		while ((lines = br.readLine()) != null) {
			lines = lines.trim();
			langLabels[x].setText(lines);
			x++;
		}
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	// calls main.java
	public void callMain(String solutionName, String langs) throws IOException {
		Main m = new Main();
		Stage mainStage = new Stage();
		m.setSolutionName(solutionName);
		m.setSolutionLanguages(langs);
		m.start(mainStage);

	}

}
