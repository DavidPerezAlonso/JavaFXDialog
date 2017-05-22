package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MyController {

	@FXML
   private Button myButton;

   @FXML
   private TextField myTextField;

   @FXML
   public void initialize() {

       // TODO (don't really need to do anything here).

   }

   // When user click on myButton
   // this method will be called.
   public void showDateTime(ActionEvent event) throws ParseException {
       System.out.println("Button Clicked!");

       Date now= new Date();

       DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");


        // Model Data
        String dateTimeString = df.format(now);

        // Show in VIEW
        myTextField.setText(dateTimeString);

        //Show Dialog Box with the information season
        ShowSeason(now);

   }

   // Este método mostrará un dialog box de información con la estación del año
   void ShowSeason(Date now) throws ParseException{
	   String sAux = "";
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	   Date spring = sdf.parse("2017-03-20");
	   Date summer = sdf.parse("2017-06-21");
	   Date fall = sdf.parse("2017-09-22");
	   Date winter = sdf.parse("2017-12-21");

	   int iAux;
	   iAux = now.compareTo(spring);
	   if(  iAux <= 0)
		   sAux="WINTER!!!";
	   else{
		   if( now.compareTo(summer) <= 0)
			   sAux="SPRING!!!";
		   else{
			   if( now.compareTo(fall) <= 0)
				   sAux="SUMMER!!!";
			   else{
				   if( now.compareTo(winter) <= 0)
					   sAux="FALL!!!";
				   else
					   sAux="WINTER!!!";
			   }
		   }
	   }

	   Alert alert = new Alert(AlertType.INFORMATION);
	   alert.setTitle("Information Dialog!");
	   alert.setHeaderText(null);
	   alert.setContentText(sAux);
	   alert.showAndWait();
   }
}
