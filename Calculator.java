//imports

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
	//main display
	JFrame window;
	//show user input
	JTextField inputField;
	//creating buttons for numbers
	JButton[] NumberButtons = new JButton[10];
	JButton[] operationButtons = new JButton[9];
	//naming operation buttons
	JButton add, sub, mult, div, decimal, equals, delete, clear, negative;	
	//creating a grid to hold those buttons
	JPanel panel;
	//font just like in Avatar
	Font font = new Font("Papyrus",Font.PLAIN,25);
	//initial numbers
	double num1=0,num2=0,result=0;
	//will be used to show operation performed
	char operation;
	
	Calculator(){
		
		window = new JFrame("Calculator 3000");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(420,550);
		window.setLayout(null);
		//setting dimensions for user input field and stopping user from
		//entering from keyboard
		inputField = new JTextField();
		inputField.setBounds(50, 25, 300, 50);
		inputField.setFont(font);
		inputField.setEditable(false);
		//creating operation buttons
		add = new JButton("+");
		sub = new JButton("-");
		mult = new JButton("x");
		div = new JButton(":");
		decimal = new JButton(".");
		equals = new JButton("=");
		delete = new JButton("delete");
		clear = new JButton("clear");
		negative = new JButton("negative");
		
		JButton operationButtons[] = {add,sub,mult,div,decimal,equals,delete,clear,negative};
		//setting operation buttons to same parameters via for loop
		for(int i=0;i<9;i++) {
			operationButtons[i].addActionListener(this);
			operationButtons[i].setFont(font);
			operationButtons[i].setFocusable(false);
		}
		//doing the same thing for number buttons
		for(int i=0;i<10;i++) {
			NumberButtons[i] = new JButton(String.valueOf(i));
			NumberButtons[i].addActionListener(this);
			NumberButtons[i].setFont(font);
			NumberButtons[i].setFocusable(false);
		}
		
		delete.setBounds(50, 430, 100, 50);
		negative.setBounds(150, 430, 100, 50);
		clear.setBounds(250, 430, 100, 50);
		
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		//adding buttons to the panel
		panel.add(NumberButtons[1]);
		panel.add(NumberButtons[2]);
		panel.add(NumberButtons[3]);
		panel.add(add);
		panel.add(NumberButtons[4]);
		panel.add(NumberButtons[5]);
		panel.add(NumberButtons[6]);
		panel.add(sub);
		panel.add(NumberButtons[7]);
		panel.add(NumberButtons[8]);
		panel.add(NumberButtons[9]);
		panel.add(mult);
		panel.add(decimal);
		panel.add(NumberButtons[0]);
		panel.add(equals);
		panel.add(div);
			

		panel.add(NumberButtons[0]);
		
		window.add(panel);
		window.add(negative);
		//can now see delete and clear buttons
		window.add(delete);
		window.add(clear);
		window.add(inputField);
		window.setVisible(true);
		inputField.setBackground(Color.GRAY);
		panel.setBackground(Color.GRAY);
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();

	}
	
	
	public void actionPerformed(ActionEvent e) {
	//assigning functions to buttons
		for(int i=0;i<10;i++) {
			if(e.getSource()==NumberButtons[i]) {
				inputField.setText(inputField.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource()==decimal) {
			inputField.setText(inputField.getText().concat(String.valueOf(".")));
		}
		if(e.getSource()==add) {
			num1 = Double.parseDouble(inputField.getText());
			operation = '+';
			inputField.setText("");
		}
		if(e.getSource()==sub) {
			num1 = Double.parseDouble(inputField.getText());
			operation = '-';
			inputField.setText("");
		}
		if(e.getSource()==mult) {
			num1 = Double.parseDouble(inputField.getText());
			operation = '*';
			inputField.setText("");
		}
		if(e.getSource()==div) {
			num1 = Double.parseDouble(inputField.getText());
			operation = '/';
			inputField.setText("");
		}
		if(e.getSource()==equals) {
			num2=Double.parseDouble(inputField.getText());
			//creating a switch to judge which operation should be performed
			switch(operation) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			inputField.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource()==clear) {
			inputField.setText("");
		}
		if(e.getSource()==delete) {
			String input = inputField.getText();
			inputField.setText("");
			for(int i=0;i<input.length()-1;i++) {
				inputField.setText(inputField.getText()+input.charAt(i));
			}
		}
		if(e.getSource()==negative) {
			double temp = Double.parseDouble(inputField.getText());
			temp*=-1;
			inputField.setText(String.valueOf(temp));
			
		}
		
		
	}

}
