package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class FormUI {

    TextField fullNameField = new TextField();
    TextField addressField = new TextField();
    TextField contactField = new TextField();
    TextField emailField = new TextField();
    TextField educationField = new TextField();

    RadioButton maleBtn = new RadioButton("Male");
    RadioButton femaleBtn = new RadioButton("Female");
    RadioButton otherBtn = new RadioButton("Other");

    DatePicker availableDate = new DatePicker();
    TextField positionField = new TextField();
    TextField salaryField = new TextField();

    RadioButton authYes = new RadioButton("Yes");
    RadioButton authNo = new RadioButton("No");

    RadioButton relYes = new RadioButton("Yes");
    RadioButton relNo = new RadioButton("No");

    TextField relativeDetailField = new TextField();

    Label status = new Label("");

    public VBox getFormLayout() {

        Label title = new Label("Employment Application");
        title.setFont(Font.font("Arial", 24));

        ToggleGroup genderGroup = new ToggleGroup();
        maleBtn.setToggleGroup(genderGroup);
        femaleBtn.setToggleGroup(genderGroup);
        otherBtn.setToggleGroup(genderGroup);

        ToggleGroup authGroup = new ToggleGroup();
        authYes.setToggleGroup(authGroup);
        authNo.setToggleGroup(authGroup);

        ToggleGroup relGroup = new ToggleGroup();
        relYes.setToggleGroup(relGroup);
        relNo.setToggleGroup(relGroup);

        Button submitBtn = new Button("Submit");

        submitBtn.setOnAction(e -> {

            EmploymentModel model = new EmploymentModel(
                fullNameField.getText(),
                addressField.getText(),
                contactField.getText(),
                emailField.getText(),
                educationField.getText(),

                maleBtn.isSelected() ? "Male" :
                femaleBtn.isSelected() ? "Female" :
                otherBtn.isSelected() ? "Other" : "",

                availableDate.getValue() != null ? availableDate.getValue().toString() : "",
                positionField.getText(),
                salaryField.getText(),
                authYes.isSelected() ? "Yes" : "No",
                relYes.isSelected() ? "Yes" : "No",
                relativeDetailField.getText()
            );

            boolean success = EmploymentDAO.insert(model);
            status.setText(success ? "Submitted!" : "Failed!");
        });

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));

        layout.getChildren().addAll(
                title,
                labelBox("Full Name", fullNameField),
                labelBox("Current Address", addressField),
                labelBox("Contact Number", contactField),
                labelBox("Email Address", emailField),
                labelBox("Highest Education", educationField),
                labelBox("Gender", new HBox(10, maleBtn, femaleBtn, otherBtn)),
                labelBox("Date Available", availableDate),
                labelBox("Desired Position", positionField),
                labelBox("Desired Salary", salaryField),
                labelBox("Legally Authorized?", new HBox(10, authYes, authNo)),
                labelBox("Relatives Working Here?", new HBox(10, relYes, relNo)),
                labelBox("If yes, explain:", relativeDetailField),
                submitBtn,
                status
        );

        return layout;
    }

    private HBox labelBox(String label, javafx.scene.Node field) {
        Label l = new Label(label + ":");
        l.setMinWidth(180);
        return new HBox(10, l, field);
    }
}
