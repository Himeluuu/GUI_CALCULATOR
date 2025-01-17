import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons =new JButton [9];  // + - * /
    JButton addButton,subbButton,mulButton,divButton;
    JButton decimalButton,equButton,delButton,clrButton,negButton;
    JPanel panel;

    Font font = new Font("Times New Roman",Font.BOLD,30);
    double num1 = 0, num2=0,result=0;
    char operator;

    calculator(){
       //Set up for Frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        //Set up for text fields
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(font);
        textfield.setEditable(false);

        //Set up for buttons:
        addButton = new JButton("+");
        subbButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decimalButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        negButton = new JButton("(-)");

        //Initializing all funtional buttons in an array to perform similar commands
        functionButtons[0] = addButton ;
        functionButtons[1] = subbButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for(int i=0;i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }
        
        for(int i=0;i<10;i++){

            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }

        //Different bounds for Delete, negetive number and Clear button

        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);
        negButton.setBounds(50,430,100,50);

        //Set up for panel
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        
        //Adding everything to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subbButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(divButton);
        panel.add(equButton);
        
        //addign everything to the frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(clrButton);
        frame.add(delButton);
        frame.add(textfield);
        frame.setVisible(true);
    }


    public static void main(String[] args){
        calculator calc = new calculator();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++){
            if(e.getSource() == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decimalButton){
            textfield.setText(textfield.getText().concat(String.valueOf(".")));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");

        }
        if(e.getSource() == subbButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
            
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
            
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
            
        }
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result= num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
         if(e.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
            
        }
        
        }
        if(e.getSource() == clrButton){
            textfield.setText("");
        }
        if(e.getSource() == delButton){
            String string = textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++){
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        if(e.getSource() == clrButton){
            num1=0;num2=0;result=0;
            textfield.setText("");
        }
        if(e.getSource() == negButton){
            Double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }
    }
}