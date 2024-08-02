/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author chetankumar
 */
public class Calculator implements ActionListener{ 
    
    JFrame frame;
    JTextField text;
    JButton[] NumButtons = new JButton[10];
    JButton[] FuncButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton, decButton, negButton, clrButton, eqButton, delButton;
    JPanel panel;
    
    Font myFont = new Font("Ink Free",Font.BOLD,30);
    
    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        
        text = new JTextField();
        text.setBounds(50, 25, 300, 50);
        text.setFont(myFont);
        text.setEditable(false);
        
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        negButton = new JButton("(-)");
        clrButton = new JButton("Clr");
        eqButton  = new JButton("="); 
        delButton = new JButton("del");
        
        FuncButtons[0] = addButton;
        FuncButtons[1] = subButton;
        FuncButtons[2] = mulButton;
        FuncButtons[3] = divButton; 
        FuncButtons[4] = decButton;
        FuncButtons[5] = negButton; 
        FuncButtons[6] = clrButton; 
        FuncButtons[7] = eqButton;
        FuncButtons[8] = delButton;
        
        for (int i = 0;i<9;i++){
            FuncButtons[i].addActionListener(this);
            FuncButtons[i].setFont(myFont);
            FuncButtons[i].setFocusable(false);
        }
        
        for (int i = 0; i < 10; i++){
            NumButtons[i] = new JButton(String.valueOf(i));
            NumButtons[i].addActionListener(this);
            NumButtons[i].setFont(myFont);
            NumButtons[i].setFocusable(false);
        }
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);
        
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        
        panel.add(NumButtons[1]);
        panel.add(NumButtons[2]);
        panel.add(NumButtons[3]);
        panel.add(addButton);
        panel.add(NumButtons[4]);
        panel.add(NumButtons[5]);
        panel.add(NumButtons[6]);
        panel.add(subButton);
        panel.add(NumButtons[7]);
        panel.add(NumButtons[8]);
        panel.add(NumButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(NumButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);
        
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(text);
        frame.setVisible(true);
       
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < 10 ; i++){
            if (e.getSource() == NumButtons[i]){
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton){
            text.setText(text.getText().concat("."));
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(text.getText());
            operator = '+';
            text.setText("");
        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(text.getText());
            operator = '-';
            text.setText("");
        }
        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(text.getText());
            operator = '*';
            text.setText("");
        }
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(text.getText());
            operator = '/';
            text.setText("");
        }
        if (e.getSource() == eqButton){
            num2 = Double.parseDouble(text.getText());
            
            switch(operator){
                case'+':
                    result = num1 + num2;
                    break;
                case'-':
                    result = num1 - num2;
                    break;
                case'*':
                    result = num1 * num2;
                    break;
                case'/':
                    result = num1/num2;
                    break;
                    
            }
            text.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton){
            text.setText("");
        }
        if (e.getSource() == delButton){
            String string = text.getText();
            text.setText("");
            for (int i = 0; i < string.length() - 1; i++){
                text.setText(text.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negButton){
            double temp = Double.parseDouble(text.getText());
            temp = temp * -1;
            text.setText(String.valueOf(temp));
        }
        
        
        
    }
}
