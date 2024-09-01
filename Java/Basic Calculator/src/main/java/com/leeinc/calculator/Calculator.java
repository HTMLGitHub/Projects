/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.leeinc.calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Owner
 */
public class Calculator extends JFrame implements ActionListener
{
    private final JTextField display;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator = "";
    private Boolean dot = false;
    private Boolean done = false;
    
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
    
    public Calculator()
    {
        //Set title for JFrame
        setTitle("Calculator");
        
        // Set the size of the JFrame
        setSize(400, 600);
        
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set layout to BorderLayout
        setLayout(new BorderLayout());
        
        // New Text Field
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 50));
        add(display, BorderLayout.NORTH);
        
        // Create the panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));
        
        // String array for buttons
        String[] buttons =
        {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };
        
        // Creates buttons from 'buttons' array

        for(String text : buttons)
        {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 40));
            button.addActionListener(this);
            panel.add(button);
        }
        
        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();
        
        if(done == true && !"".equals(display.getText()))
        {
            display.setText("");
            done = false;
        }
        
        if(command.charAt(0) >= '0' && command.charAt(0) <= '9')
        {
            display.setText(display.getText() + command);
        }
        else if(command.equals(".") && dot == false)
        {
            display.setText(display.getText() + command);
            dot = true;
        }
        else if(command.equals("="))
        {
            secondNumber = Double.parseDouble(display.getText());
            
            try
            {
                switch(operator)
                {
                    case "+" -> display.setText(String.valueOf(firstNumber + secondNumber));
                    case "-" -> display.setText(String.valueOf(firstNumber - secondNumber));
                    case "*" -> display.setText(String.valueOf(firstNumber * secondNumber));
                    case "/" -> display.setText(String.valueOf(firstNumber / secondNumber));
                }
            }
            catch(ArithmeticException ex)
            {
                display.setText("Error: " + ex.getMessage());
            }
            finally
            {
                firstNumber = 0;
                secondNumber = 0;
                dot = false;
                done = true;
            }
        }
        else
        {
            firstNumber = Double.parseDouble(display.getText());
            operator = command;
            display.setText("");
        }
    }    
}