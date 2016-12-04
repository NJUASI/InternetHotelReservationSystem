package presentation.guestUI.controller;

import javafx.beans.property.SimpleStringProperty;

public class EvaluationTable {
	public final SimpleStringProperty guestID;
	public final SimpleStringProperty comment;

	public EvaluationTable(String guestID, String comment) {
		this.guestID = new SimpleStringProperty(guestID);
		this.comment = new SimpleStringProperty(comment);
	}

}
