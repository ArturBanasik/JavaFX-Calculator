package application;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;

public class MainController {
	
	@FXML
	private Label result;
	private float num1 = 0;
	private float num2 = 0;
	private String operator = "";
	private boolean start = true;
	Model model = new Model();
	String prevValue = "";
	String value = "";
	String num1String = "";
	String operation = "";
	boolean nn = false;
	boolean divError = false;
	

	@FXML

	public void onClickC(ActionEvent Event) {
		num1 = 0;
		num2 = 0;
		prevValue = "";
		result.setText(prevValue);
	}
	
	@FXML
	public float onClick(ActionEvent Event) {
		if(!nn) {
		prevValue = result.getText();
		value = ((Labeled) Event.getSource()).getText();
		prevValue += value;
		result.setText(prevValue);
		
		num1 = Float.parseFloat(prevValue);
		return num1;
		}
		else {
			
			prevValue = result.getText();
			value = ((Labeled) Event.getSource()).getText();
			prevValue += value;
			result.setText(prevValue);
			num2 = Float.parseFloat(prevValue);
			return num2;
		}
	}

	@FXML
	public void onClickFloat(ActionEvent Event) {
		
		result.setText(prevValue+".");
	}
	
	@FXML
	public void add(ActionEvent Event) {
		num1 = Float.parseFloat(prevValue);
		num1 = num1 + num2;
		prevValue = Float.toString(num1);
		result.setText(prevValue);
		nn = true;
	}
	
	@FXML
	public void adding(ActionEvent Event) {
		operation = "adding";
		result.setText(prevValue+"+");
		nn = true;
		result.setText("");
	}
	@FXML
	public void multiplication(ActionEvent Event) {
		operation = "multiplication";
		result.setText(prevValue+"*");
		nn = true;
		result.setText("");
	}
	@FXML
	public void division(ActionEvent Event) throws InterruptedException {
		operation = "division";
		result.setText(prevValue+"/");
		nn = true;
		result.setText("");
	}
	@FXML
	public void substraction(ActionEvent Event) {
		operation = "substraction";
		result.setText(prevValue+"-");
		nn = true;
		result.setText("");
	}
	@FXML
	public void squareRoot(ActionEvent Event) {
		num1 = num1*num1;
		prevValue = Float.toString(num1);
		result.setText(prevValue);
	}
	@FXML
	public void sqrt(ActionEvent Event) {
		if(num1>0) {
		num1 = (float) Math.sqrt(num1);
		prevValue = Float.toString(num1);
		} else {
			prevValue="Error";
		}
		result.setText(prevValue);
		
	}
	@FXML
	
	public void powerS(ActionEvent Event) {
		int powerInt =1;
		for (int i=1; i<=num1; i++) {
			powerInt = powerInt *i;
			
	    }
		prevValue = Integer.toString(powerInt);
		result.setText(prevValue);
		num1=0;
		
	}
	
	
	
	
	
	@FXML 
	public void equalsSign(ActionEvent Event) {
		switch (operation) {
		case "adding":
			num1 += num2;
			break;
			
		case "multiplication":
			num1 *= num2;
			break;
		case "division":
			if(num2!=0)
			num1 /= num2;
			
			else if (num2 == 0 )
				divError = true;
				prevValue="Error";
			break;
		case "substraction":
			num1 -= num2;
		break;
		
		default:
			num1 = 0;
			break;

		}	if (!divError)
			prevValue = Float.toString(num1);
			
			result.setText(prevValue);
			num1 = 0 ; 
			num2 = 0;
			
			nn = false;
		}
	}
	
	
