package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends HBox{

    Button importPictureButton, importDatabaseButton, destinationButton, createPDFButton;
    TextField picturePathTextField, databasePathTextField, fileNameTextField, destinationPathTextField, startIndexTextField;
    RadioButton a3Radio, a4Radio, a5Radio, portraitRadio, landscapeRadio, sequentialRadio, generatedRadio;
    ToggleGroup pageFormatToggleGroup, pageSizeToggleGroup, identifierToggleGroup;
    ChoiceBox nameFontFamilyChoiceBox, idFontFamilyChoiceBox, nameFontSizeChoiceBox, idFontSizeChoiceBox;
    ColorPicker nameFontColorColorPicker, idFontColorColorPicker;
    Spinner<Integer> nameXPosSpinner, nameYPosSpinner, idXPosSpinner, idYPosSpinner;
    Label choosePicture, chooseDatabase, pageSize, a3, a4, a5, pageFormat, portrait, landscape, identifier, squential, generated,
            start, nameFontProperties, idFontProperties, nameFont, nameSize, nameColor, idFont, idSize, idColor, namePosition,
            idPosition, nameX, nameY, idX, idY, fileName, destination;
    ImageView preview;
    FileChooser fileChooser, folderChooser;
    DirectoryChooser directoryChooser;
    FileChooser.ExtensionFilter extensionFilter;
    Scene scene;
    HBox main, fileHBox, destinationHBox, creationHBox, pictureHBox, databaseHBox, pageSizeHBox, pageFormatHBox, identifierHBox,
            namePropertiesHBox, idPropertiesHBox, namePosHBox, idPosHBox;
    VBox leftVBox, rightVBox, namePropertiesVBox, idPropertiesVBox, namePosVBox, idPosVBox;
    StackPane pane;
    Text name, id;
    float ration = 0.692307692f;

    public Main(){
        choosePicture       = new Label("Choose a picture");
        chooseDatabase      = new Label("Choose a database");
        pageSize            = new Label("Page size");
        pageFormat          = new Label("Page format");
        a3                  = new Label("A3");
        a4                  = new Label("A4");
        a5                  = new Label("A5");
        portrait            = new Label("Portrait");
        landscape           = new Label("Landscape");
        identifier          = new Label("Identifier");
        squential           = new Label("Sequential");
        generated           = new Label("Generated");
        start               = new Label("index");
        nameFontProperties  = new Label("Name font properties");
        idFontProperties    = new Label("Identifier font properties");
        nameFont            = new Label("Family");
        nameSize            = new Label("Size");
        nameColor           = new Label("Color");
        idFont              = new Label("Family");
        idSize              = new Label("Size");
        idColor             = new Label("Color");
        namePosition        = new Label("Name position");
        idPosition          = new Label("Identifier position");
        nameX               = new Label("X");
        nameY               = new Label("Y");
        idX                 = new Label("X");
        idY                 = new Label("Y");
        fileName            = new Label("File name");
        destination         = new Label("Destination");

        fileChooser = new FileChooser();
        folderChooser = new FileChooser();
        extensionFilter = new FileChooser.ExtensionFilter("picture", "*.jpeg", "*.jpg", "*.png", "*.JPEG", "*.JPG", "*.PNG");
        fileChooser.getExtensionFilters().add(extensionFilter);
        directoryChooser = new DirectoryChooser();

        importPictureButton     = new Button("Import");
        importDatabaseButton    = new Button("Import");
        destinationButton       = new Button("Choose");
        createPDFButton         = new Button("Create PDF");

        picturePathTextField        = new TextField();
        databasePathTextField       = new TextField();
        fileNameTextField           = new TextField();
        destinationPathTextField    = new TextField();
        startIndexTextField         = new TextField();
        fileNameTextField.setText("new pdf file");
        destinationPathTextField.setText("C:/Users/Public/Documents/");
        destinationPathTextField.setDisable(true);

        preview = new ImageView();
        preview.setFitHeight(420);
        preview.setFitWidth(595);
        preview.setImage(new Image("default.png"));

        pageFormatToggleGroup   = new ToggleGroup();
        pageSizeToggleGroup     = new ToggleGroup();
        identifierToggleGroup   = new ToggleGroup();

        a3Radio         = new RadioButton();
        a4Radio         = new RadioButton();
        a5Radio         = new RadioButton();
        portraitRadio   = new RadioButton();
        landscapeRadio  = new RadioButton();
        sequentialRadio = new RadioButton();
        generatedRadio  = new RadioButton();

        a3Radio.setUserData("a3Radio");
        a4Radio.setUserData("a4Radio");
        a5Radio.setUserData("a5Radio");
        portraitRadio.setUserData("portraitRadio");
        landscapeRadio.setUserData("landscapeRadio");
        sequentialRadio.setUserData("sequentialRadio");
        generatedRadio.setUserData("generatedRadio");

        a3Radio.setToggleGroup(pageSizeToggleGroup);
        a4Radio.setToggleGroup(pageSizeToggleGroup);
        a5Radio.setToggleGroup(pageSizeToggleGroup);
        portraitRadio.setToggleGroup(pageFormatToggleGroup);
        landscapeRadio.setToggleGroup(pageFormatToggleGroup);
        sequentialRadio.setToggleGroup(identifierToggleGroup);
        generatedRadio.setToggleGroup(identifierToggleGroup);

        nameFontFamilyChoiceBox = new ChoiceBox();
        idFontFamilyChoiceBox   = new ChoiceBox();
        nameFontSizeChoiceBox   = new ChoiceBox();
        idFontSizeChoiceBox     = new ChoiceBox();

        nameXPosSpinner = new Spinner<Integer>(-500,500,0,5);
        nameYPosSpinner = new Spinner<Integer>(-500,500,0,5);
        idXPosSpinner   = new Spinner<Integer>(-500,500,0,5);
        idYPosSpinner   = new Spinner<Integer>(-500,500,0,5);

        nameFontColorColorPicker    = new ColorPicker();
        idFontColorColorPicker      = new ColorPicker();
        nameFontColorColorPicker.setValue(Color.BLACK);
        idFontColorColorPicker.setValue(Color.BLACK);

        leftVBox            = new VBox();
        rightVBox           = new VBox();
        namePropertiesVBox  = new VBox();
        idPropertiesVBox    = new VBox();
        namePosVBox         = new VBox();
        idPosVBox           = new VBox();

        main                = new HBox();
        fileHBox            = new HBox();
        destinationHBox     = new HBox();
        creationHBox        = new HBox();
        pictureHBox         = new HBox();
        databaseHBox        = new HBox();
        pageSizeHBox        = new HBox();
        pageFormatHBox      = new HBox();
        identifierHBox      = new HBox();
        namePropertiesHBox  = new HBox();
        idPropertiesHBox    = new HBox();
        namePosHBox         = new HBox();
        idPosHBox           = new HBox();

        pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        //pane.setPrefHeight(420);
        pane.setPrefHeight(595);
        pane.setPrefWidth(595);

        name = new Text("Benamer ihab");
        name.setFont(Font.loadFont ("file:///C:/windows/Fonts/arial.ttf", Math.round(36) * ration));
        name.setFill(Color.BLACK);

        id = new Text("N° 000001");
        id.setFont(Font.loadFont ("file:///C:/windows/Fonts/arial.ttf", 12 * ration));
        id.setFill(Color.BLACK);
        //id.setTranslateY(200);

        pane.getChildren().addAll(preview, name, id);
        main.getChildren().addAll(leftVBox, rightVBox);
        leftVBox.getChildren().addAll(pane, creationHBox);
        fileHBox.getChildren().addAll(fileName, fileNameTextField);
        destinationHBox.getChildren().addAll(destination, destinationPathTextField, destinationButton);
        creationHBox.getChildren().add(createPDFButton);
        rightVBox.getChildren().addAll(pictureHBox, databaseHBox, pageSizeHBox, pageFormatHBox, identifierHBox, namePropertiesVBox, idPropertiesVBox, namePosVBox, idPosVBox, fileHBox, destinationHBox);
        pictureHBox.getChildren().addAll(choosePicture, picturePathTextField, importPictureButton);
        databaseHBox.getChildren().addAll(chooseDatabase, databasePathTextField, importDatabaseButton);
        pageSizeHBox.getChildren().addAll(pageSize, a3Radio, a3, a4Radio, a4, a5Radio, a5);
        pageFormatHBox.getChildren().addAll(pageFormat, portraitRadio, portrait, landscapeRadio, landscape);
        identifierHBox.getChildren().addAll(identifier, sequentialRadio, squential, start, startIndexTextField, generatedRadio, generated);
        namePropertiesVBox.getChildren().addAll(nameFontProperties, namePropertiesHBox);
        namePropertiesHBox.getChildren().addAll(nameFont, nameFontFamilyChoiceBox, nameSize, nameFontSizeChoiceBox, nameColor, nameFontColorColorPicker);
        idPropertiesVBox.getChildren().addAll(idFontProperties, idPropertiesHBox);
        idPropertiesHBox.getChildren().addAll(idFont, idFontFamilyChoiceBox, idSize, idFontSizeChoiceBox, idColor, idFontColorColorPicker);
        namePosVBox.getChildren().addAll(namePosition, namePosHBox);
        namePosHBox.getChildren().addAll(nameX, nameXPosSpinner, nameY, nameYPosSpinner);
        idPosVBox.getChildren().addAll(idPosition, idPosHBox);
        idPosHBox.getChildren().addAll(idX, idXPosSpinner, idY, idYPosSpinner);

        leftVBox.setAlignment(Pos.CENTER);
        rightVBox.setAlignment(Pos.CENTER);
        fileHBox.setAlignment(Pos.CENTER_LEFT);
        destinationHBox.setAlignment(Pos.CENTER_LEFT);
        creationHBox.setAlignment(Pos.CENTER);
        pictureHBox.setAlignment(Pos.CENTER_LEFT);
        databaseHBox.setAlignment(Pos.CENTER_LEFT);
        pageFormatHBox.setAlignment(Pos.CENTER_LEFT);
        pageSizeHBox.setAlignment(Pos.CENTER_LEFT);
        identifierHBox.setAlignment(Pos.CENTER_LEFT);
        namePosVBox.setAlignment(Pos.CENTER);
        idPosVBox.setAlignment(Pos.CENTER);
        namePropertiesVBox.setAlignment(Pos.CENTER);
        idPropertiesVBox.setAlignment(Pos.CENTER);
        idPosHBox.setAlignment(Pos.CENTER);
        namePosHBox.setAlignment(Pos.CENTER);
        namePropertiesHBox.setAlignment(Pos.CENTER);
        idPropertiesHBox.setAlignment(Pos.CENTER);

        rightVBox.setPadding(new Insets(0,0,0,10));

        createPDFButton.setPrefHeight(30);
        createPDFButton.setPrefWidth(150);
        creationHBox.setPadding(new Insets(20,0,20,0));

        pictureHBox.setPadding(new Insets(10,0,10,0));
        pictureHBox.setSpacing(10);
        picturePathTextField.setPrefWidth(210);
        HBox.setMargin(picturePathTextField, new Insets(0,0,0,11));

        databaseHBox.setPadding(new Insets(5,0,5,0));
        databaseHBox.setSpacing(10);
        databasePathTextField.setPrefWidth(210);

        pageSizeHBox.setPadding(new Insets(10,0,10,0));
        pageSizeHBox.setSpacing(5);
        HBox.setMargin(a3Radio, new Insets(0,0,0,90));
        HBox.setMargin(a4Radio, new Insets(0,0,0,35));
        HBox.setMargin(a5Radio, new Insets(0,0,0,35));

        pageFormatHBox.setPadding(new Insets(10,0,10,0));
        pageFormatHBox.setSpacing(5);
        HBox.setMargin(portraitRadio, new Insets(0,0,0,75));
        HBox.setMargin(landscapeRadio, new Insets(0,0,0,45));

        identifierHBox.setPadding(new Insets(10,0,10,0));
        identifierHBox.setSpacing(5);
        startIndexTextField.setPrefWidth(35);
        HBox.setMargin(sequentialRadio, new Insets(0,0,0,12));
        HBox.setMargin(start, new Insets(0,0,0,15));
        HBox.setMargin(generatedRadio, new Insets(0,0,0,20));

        namePropertiesVBox.setPadding(new Insets(10,0,10,0));
        namePropertiesVBox.setSpacing(10);
        nameFontFamilyChoiceBox.setPrefWidth(180);
        nameFontColorColorPicker.setPrefWidth(40);
        HBox.setMargin(nameFontFamilyChoiceBox, new Insets(0,0,0,10));
        HBox.setMargin(nameSize, new Insets(0,5,0,5));
        HBox.setMargin(nameColor, new Insets(0,5,0,5));

        idPropertiesVBox.setPadding(new Insets(10,0,10,0));
        idPropertiesVBox.setSpacing(10);
        idFontFamilyChoiceBox.setPrefWidth(180);
        idFontColorColorPicker.setPrefWidth(40);
        HBox.setMargin(idFontFamilyChoiceBox, new Insets(0,0,0,10));
        HBox.setMargin(idSize, new Insets(0,5,0,5));
        HBox.setMargin(idColor, new Insets(0,5,0,5));

        namePosVBox.setPadding(new Insets(10,0,10,0));
        namePosVBox.setSpacing(10);
        nameXPosSpinner.setPrefWidth(60);
        nameYPosSpinner.setPrefWidth(60);
        HBox.setMargin(nameX, new Insets(0,10,0,0));
        HBox.setMargin(nameY, new Insets(0,10,0,50));

        idPosVBox.setPadding(new Insets(10,0,10,0));
        idPosVBox.setSpacing(10);
        idXPosSpinner.setPrefWidth(60);
        idYPosSpinner.setPrefWidth(60);
        HBox.setMargin(idX, new Insets(0,10,0,0));
        HBox.setMargin(idY, new Insets(0,10,0,50));


        fileHBox.setPadding(new Insets(10,0,10,0));
        fileHBox.setSpacing(10);
        fileNameTextField.setPrefWidth(275);
        HBox.setMargin(fileNameTextField, new Insets(0,0,0,50));

        destinationHBox.setPadding(new Insets(10,0,10,0));
        destinationHBox.setSpacing(10);
        destinationPathTextField.setPrefWidth(210);
        HBox.setMargin(destinationPathTextField, new Insets(0,0,0,40));

        sequentialRadio.fire();
        landscapeRadio.fire();
        a4Radio.fire();
        startIndexTextField.setText("1");

        nameFontSizeChoiceBox.getItems().addAll(8,9,10,11,12,14,16,18,20,22,24,26,28,36,48,56,64,72,80,92,100);
        nameFontSizeChoiceBox.setValue(36);
        idFontSizeChoiceBox.getItems().addAll(8,9,10,11,12,14,16,18,20,22,24,26,28,36,48,56,64,72,80,92,100);
        idFontSizeChoiceBox.setValue(12);

        File[] listOfFiles = new File("C:/Windows/Fonts").listFiles();

        if(listOfFiles != null){
            for (int i = 0; i < listOfFiles.length; i++) {
                if(!listOfFiles[i].getName().contains(".fon")){
                    nameFontFamilyChoiceBox.getItems().add(listOfFiles[i].getName());
                    idFontFamilyChoiceBox.getItems().add(listOfFiles[i].getName());
                }
            }
        }

        nameFontFamilyChoiceBox.setValue("arial.ttf");
        idFontFamilyChoiceBox.setValue("arial.ttf");


        scene = new Scene(main, 1000, 650);

    }



}
