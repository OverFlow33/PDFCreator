package sample;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.*;

public class Controller extends Application {

    File openedFile;
    String nameFontFamily;
    String idFontFamily;
    int nameFontSize;
    int idFontSize;
    String nameFontColor = "000000";
    String idFontColor = "000000";
    String result ;
    String picture = "C:\\Users\\B.IHAB\\Desktop\\certificat1.png";
    Document document;
    Rectangle pageSize;
    com.itextpdf.text.Image background = null;
    int nameXTranslate = 0, nameYTranslate = 0, idXTranslate = 0, idYTranslate = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main mainUI = new Main();
        nameFontFamily = "file:///C:/windows/Fonts/arial.ttf";
        idFontFamily = "file:///C:/windows/Fonts/arial.ttf";
        nameFontSize = 36;
        idFontSize = 12;
        mainUI.importPictureButton.setOnAction((ActionEvent e) ->
        {
            openedFile = mainUI.fileChooser.showOpenDialog(primaryStage);
            if(openedFile != null){
                mainUI.picturePathTextField.setText(openedFile.getPath());
                mainUI.picturePathTextField.setDisable(true);
                mainUI.preview.setImage(new Image("file:///"+openedFile.getPath().replace('\\', '/')));
                picture = openedFile.getPath().replace('\\', '/');
                try {
                    background = com.itextpdf.text.Image.getInstance(picture);
                } catch (BadElementException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        mainUI.a3Radio.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {
                    mainUI.ration = 0.5f;
                    mainUI.name.setFont(Font.loadFont (nameFontFamily, Math.round(nameFontSize) * mainUI.ration));
                    mainUI.id.setFont(Font.loadFont (idFontFamily, Math.round(idFontSize) * mainUI.ration));
                    mainUI.name.setTranslateX(Math.round(mainUI.name.getX() + nameXTranslate * mainUI.ration));
                    mainUI.name.setTranslateY(Math.round(mainUI.name.getY() - nameYTranslate * mainUI.ration));
                    mainUI.id.setTranslateX(Math.round(mainUI.id.getX() +idXTranslate * mainUI.ration));
                    mainUI.id.setTranslateY(Math.round(mainUI.id.getY() -idYTranslate * mainUI.ration));
                }
            }
        });

        mainUI.a4Radio.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {
                    mainUI.ration = 0.692307692f;
                    mainUI.name.setFont(Font.loadFont (nameFontFamily, Math.round(nameFontSize)* mainUI.ration));
                    mainUI.id.setFont(Font.loadFont (idFontFamily, Math.round(idFontSize) * mainUI.ration));
                    mainUI.name.setTranslateX(Math.round(mainUI.name.getX() + nameXTranslate * mainUI.ration));
                    mainUI.name.setTranslateY(Math.round(mainUI.name.getY() - nameYTranslate * mainUI.ration));
                    mainUI.id.setTranslateX(Math.round(mainUI.id.getX() +idXTranslate * mainUI.ration));
                    mainUI.id.setTranslateY(Math.round(mainUI.id.getY() -idYTranslate * mainUI.ration));

                }
            }
        });

        mainUI.a5Radio.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {
                    mainUI.ration = 1;
                    mainUI.name.setFont(Font.loadFont (nameFontFamily, Math.round(nameFontSize)* mainUI.ration));
                    mainUI.id.setFont(Font.loadFont (idFontFamily, Math.round(idFontSize)* mainUI.ration));
                    mainUI.name.setTranslateX(Math.round(mainUI.name.getX() + nameXTranslate * mainUI.ration));
                    mainUI.name.setTranslateY(Math.round(mainUI.name.getY() - nameYTranslate * mainUI.ration));
                    mainUI.id.setTranslateX(Math.round(mainUI.id.getX() +idXTranslate * mainUI.ration));
                    mainUI.id.setTranslateY(Math.round(mainUI.id.getY() -idYTranslate * mainUI.ration));

                }
            }
        });

        mainUI.landscapeRadio.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {
                    mainUI.preview.setFitWidth(595);
                    mainUI.preview.setFitHeight(420);
                }
            }
        });

        mainUI.portraitRadio.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {
                    mainUI.preview.setFitWidth(420);
                    mainUI.preview.setFitHeight(595);
                }
            }
        });

        mainUI.sequentialRadio.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {
                    mainUI.sequentialRadio.fire();
                    mainUI.startIndexTextField.setText("1");
                    mainUI.startIndexTextField.setDisable(false);
                }
            }
        });

        mainUI.generatedRadio.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {
                    mainUI.generatedRadio.fire();
                    mainUI.startIndexTextField.setText("");
                    mainUI.startIndexTextField.setDisable(true);
                }
            }
        });

        mainUI.a3.setOnMouseClicked(e ->{
            mainUI.a3Radio.fire();
        });

        mainUI.a4.setOnMouseClicked(e ->{
            mainUI.a4Radio.fire();

        });

        mainUI.a5.setOnMouseClicked(e ->{
            mainUI.a5Radio.fire();

        });

        mainUI.portrait.setOnMouseClicked(e ->{
            mainUI.portraitRadio.fire();
        });

        mainUI.landscape.setOnMouseClicked(e ->{
            mainUI.landscapeRadio.fire();
        });

        mainUI.squential.setOnMouseClicked(e ->{
            mainUI.sequentialRadio.fire();
            mainUI.startIndexTextField.setText("1");
            mainUI.startIndexTextField.setDisable(false);
        });

        mainUI.generated.setOnMouseClicked(e ->{
            mainUI.generatedRadio.fire();
            mainUI.startIndexTextField.setText("");
            mainUI.startIndexTextField.setDisable(true);
        });

        mainUI.destinationButton.setOnAction((ActionEvent e) ->
        {
            openedFile = mainUI.directoryChooser.showDialog(primaryStage);
            if(openedFile != null){
                mainUI.destinationPathTextField.setText(openedFile.getPath().replace("\\", "/") + "/");
            }
        });

        mainUI.importDatabaseButton.setOnAction((ActionEvent e) ->{

        });

        mainUI.nameFontFamilyChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                nameFontFamily = "file:///C:/windows/Fonts/" + mainUI.nameFontFamilyChoiceBox.getItems().get((Integer) number2);
                mainUI.name.setFont(Font.loadFont(nameFontFamily, nameFontSize * mainUI.ration));
            }
        });

        mainUI.nameFontSizeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                nameFontSize = Integer.parseInt(mainUI.nameFontSizeChoiceBox.getItems().get((Integer) number2).toString());
                mainUI.name.setFont(Font.loadFont(nameFontFamily, nameFontSize * mainUI.ration));
            }
        });

        mainUI.nameFontColorColorPicker.setOnAction((ActionEvent e) ->{
            nameFontColor = mainUI.nameFontColorColorPicker.getValue().toString().substring(2, mainUI.nameFontColorColorPicker.getValue().toString().length() - 2);
            mainUI.name.setFill(mainUI.nameFontColorColorPicker.getValue());
        });

        mainUI.idFontColorColorPicker.setOnAction((ActionEvent e) ->{
            idFontColor = mainUI.idFontColorColorPicker.getValue().toString().substring(2, mainUI.idFontColorColorPicker.getValue().toString().length() - 2);
            mainUI.id.setFill(mainUI.idFontColorColorPicker.getValue());
        });

        mainUI.idFontFamilyChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                idFontFamily = "file:///C:/windows/Fonts/" + mainUI.idFontFamilyChoiceBox.getItems().get((Integer) number2);
                mainUI.id.setFont(Font.loadFont(idFontFamily, idFontSize * mainUI.ration));
            }
        });

        mainUI.idFontSizeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                idFontSize = Integer.parseInt(mainUI.idFontSizeChoiceBox.getItems().get((Integer) number2).toString());
                mainUI.id.setFont(Font.loadFont(idFontFamily, idFontSize * mainUI.ration));
            }
        });

        mainUI.nameXPosSpinner.valueProperty().addListener((obs, oldValue, newValue) ->{
            mainUI.name.setTranslateX(Math.round(newValue * mainUI.ration));
            nameXTranslate = Math.round(newValue / mainUI.ration * 0.8f);
        });

        mainUI.nameYPosSpinner.valueProperty().addListener((obs, oldValue, newValue) ->{
            mainUI.name.setTranslateY(Math.round(newValue * mainUI.ration));
            nameYTranslate = -Math.round(newValue / mainUI.ration  * 0.8f) ;
        });

        mainUI.idXPosSpinner.valueProperty().addListener((obs, oldValue, newValue) ->{
            mainUI.id.setTranslateX(Math.round(newValue * mainUI.ration));
            idXTranslate = Math.round(newValue / mainUI.ration);
        });

        mainUI.idYPosSpinner.valueProperty().addListener((obs, oldValue, newValue) ->{
            mainUI.id.setTranslateY(Math.round(newValue * mainUI.ration));
            idYTranslate = -Math.round(newValue / mainUI.ration);
        });

        mainUI.createPDFButton.setOnAction((ActionEvent e) ->{
            result = mainUI.destinationPathTextField.getText() + mainUI.fileNameTextField.getText() + ".pdf";

            if(mainUI.pageSizeToggleGroup.getSelectedToggle().getUserData().equals("a3Radio"))
                pageSize = PageSize.A3;
            else if(mainUI.pageSizeToggleGroup.getSelectedToggle().getUserData().equals("a5Radio"))
                pageSize = PageSize.A5;
            else
                pageSize = PageSize.A4;

            if(mainUI.pageFormatToggleGroup.getSelectedToggle().getUserData().equals("landscapeRadio"))
                document = new Document(pageSize.rotate());
            else
                document = new Document(pageSize);

            PdfWriter writer  = null;
            try {
                writer = PdfWriter.getInstance(document, new FileOutputStream(result));
                float width = document.getPageSize().getWidth();
                float height = document.getPageSize().getHeight();
                document.open();
                String [] names = {"Benamer ihab", "benali karim", "laib salim", "karim islem", "benmohamed zakaria"};
                for(int i = 0; i<names.length; i++){
                    String nameText = names[i];
                    String mat = "N° 00000" + i+1;
                    writer.getDirectContentUnder().addImage(background, width, 0, 0, height, 0, 0);
                    com.itextpdf.text.Font nameFont = FontFactory.getFont(nameFontFamily.substring(8), nameFontSize, com.itextpdf.text.Font.NORMAL,new CMYKColor(0, 0, 0, 175));
                    nameFont.setColor(Integer.valueOf( nameFontColor.substring( 0, 2 ), 16 ),Integer.valueOf( nameFontColor.substring( 2, 4 ), 16 ),Integer.valueOf( nameFontColor.substring( 4, 6 ), 16 ));
                    com.itextpdf.text.Font idFont = FontFactory.getFont(idFontFamily.substring(8), idFontSize, com.itextpdf.text.Font.NORMAL,new CMYKColor(0, 0, 0, 0));
                    idFont.setColor(Integer.valueOf( idFontColor.substring( 0, 2 ), 16 ),Integer.valueOf( idFontColor.substring( 2, 4 ), 16 ),Integer.valueOf(idFontColor.substring( 4, 6 ), 16 ));
                    PdfContentByte canvas = writer.getDirectContent();
                    Phrase name = new Phrase(nameText, nameFont);
                    Phrase identifier = new Phrase(mat, idFont);
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, name, document.getPageSize().getWidth()/2 - ColumnText.getWidth( name ) /2 + nameXTranslate, document.getPageSize().getHeight() / 2 - nameFontSize * mainUI.ration /2  + nameYTranslate, 0);
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, identifier, document.getPageSize().getWidth()/2 - ColumnText.getWidth( identifier ) /2 + idXTranslate, document.getPageSize().getHeight() / 2 - idFontSize * mainUI.ration  /2  + idYTranslate, 0);
                    document.newPage();
                }

            } catch (DocumentException | FileNotFoundException e1) {
                e1.printStackTrace();
            }


            document.close();
        });


        primaryStage.setTitle("PDF Creator");
        primaryStage.setScene(mainUI.scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
