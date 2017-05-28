package Notepad;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;


import java.awt.*;
import java.io.*;
import java.nio.Buffer;

public class MyController {

    private String currentFileName;
    private Main mainApp;
    private FileDialog myFileDialog;
    private String myText;

    private byte[] buffer;
    private String filePass="";

    @FXML
    private TextArea myTestArea;
    @FXML
    private  MenuItem newMenuItem;
    @FXML
    private  MenuItem openMenuItem;
    @FXML
    private  MenuItem saveMenuItem;
    @FXML
    private  MenuItem saveAsMenuItem;
    @FXML
    private  MenuItem closeMenuItem;
    @FXML
    private  MenuItem copyMenuItem;
    @FXML
    private  MenuItem pastleMenuItem;
    @FXML
    private  MenuItem deleteMenuItem;
    @FXML
    private  MenuItem aboutMenuItem;

    @FXML
    private  void newMenuSelected(){
        myTestArea.setText("");
        filePass="";

    };
    @FXML
    private  void openMenuSelected(){
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открытие файла");
        File file = fileChooser.showOpenDialog(mainApp.primaryStage);
        filePass=file.getAbsolutePath();
        if(file!=null){
            try{

                FileInputStream fis = new FileInputStream(file);
                buffer = new byte[fis.available()];
                fis.read(buffer);
                myTestArea.setText("");
                myTestArea.setText(new String(buffer,"Cp1251"));
                fis.close();


                /*BufferedReader bf = new BufferedReader(fis);
                for(int i=0;i<10;i++) {
                    myTestArea.appendText(bf.readLine() + "\n");
                }*/
            }
            catch (Exception ex){
                System.out.println("Не получилось");
            };
        }
    };

    @FXML
    private  void saveMenuSelected(){


     if(filePass.length()==0){
          saveAsMenuSelected();
      }
      else{
          fileSave();
      }

    };

    @FXML
    private  void saveAsMenuSelected(){
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранение файла");
        File file =fileChooser.showSaveDialog(mainApp.primaryStage);
        if(file.exists()){

            System.out.println("Файл существует");
        }
        else{
            System.out.println("Файл не существует");
        }
        filePass=file.getAbsolutePath();

        fileSave();




    };
    @FXML
    private  void closeMenuSelected(){
        System.out.println("menu close selected");

    };
    @FXML
    private  void copyMenuSelected(){
        System.out.println("menu copy selected");

    };
    @FXML
    private  void pastleMenuSelected(){
        System.out.println("menu pastle selected");

    };
    @FXML
    private  void deleteMenuSelected(){
        System.out.println("menu deleted selected");

    };
    @FXML
    private  void aboutMenuSelected(){
        System.out.println("menu about selected");

    };

    private void fileSave() {
        FileOutputStream fileOutputStream = null;

        try{

        myText=myTestArea.getText();
        buffer=myText.getBytes("Cp1251");

        fileOutputStream=new FileOutputStream(filePass);
        fileOutputStream.write(buffer);
        fileOutputStream.close();
    }
    catch (Exception ex){
        System.out.println(ex.toString());
        }
    }


    public void setMainApp(Main mainApp){
        //filePass="";
        this.mainApp=mainApp;




    }
}
