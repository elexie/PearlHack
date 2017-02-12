package first;

import javafx.scene.control.TextArea;

public class SolutionArea extends TextArea {

	TextArea solutionArea;

	public SolutionArea() {
		solutionArea = new TextArea();
		solutionArea.setWrapText(true);
	}

	public SolutionArea(double width, double height) {
		solutionArea = new TextArea();
		solutionArea.setWrapText(true);
		solutionArea.setPrefWidth(width);
		solutionArea.setPrefHeight(height);
	}

}
