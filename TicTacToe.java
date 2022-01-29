import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

    Random turn = new Random();
    JFrame frame = new JFrame();
    JPanel title = new JPanel();
    JPanel button = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Move;

    TicTacToe() throws InterruptedException {
        //frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        //textfield
        textfield.setBackground(new Color(30,30,30));
        textfield.setForeground(new Color(255,95,31).brighter());
        textfield.setFont(new Font("MV Boli ", Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        //title panel
        title.setLayout(new BorderLayout());
        title.setBounds(0,0,800,100);

        button.setLayout(new GridLayout(3,3));
        button.setBackground(Color.black);
        button.setOpaque(true);


        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            button.add(buttons[i]);
            buttons[i].setFont(new Font("",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title.add(textfield);
        frame.add(title,BorderLayout.NORTH);
        frame.add(button);

        firstMove();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
               if(player1Move){
                   if(buttons[i].getText()==""){
                       buttons[i].setForeground(Color.blue);
                       buttons[i].setText("X");
                       player1Move=false;
                       textfield.setText("O's Turn");
                       check();
                   }
               } else{
                   if(buttons[i].getText()==""){
                       buttons[i].setForeground(Color.red);
                       buttons[i].setText("O");
                       player1Move=true;
                       textfield.setText("X's Turn");
                       check();
                   }
               }
            }
        }
    }
    public void firstMove() throws InterruptedException {
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        if(turn.nextInt(2)==0){
            player1Move=true;
        textfield.setText("X's Turn");
        }else{
            player1Move=false;
            textfield.setText("O's Turn");
        }
    }
    public void check(){
        //x wins
        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")){
            xWins(0,1,2);
        }
        if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X")){
            xWins(0,1,2);
        }
        if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X")){
            xWins(0,1,2);
        }
        if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")){
            xWins(0,1,2);
        }
        if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")){
            xWins(0,1,2);
        }
        if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")){
            xWins(0,1,2);
        }
        if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")){
            xWins(0,1,2);
        }
        if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X")){
            xWins(0,1,2);
        }

        //O wins
        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O")){
            oWins(0,1,2);
        }
        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") &&
                (buttons[5].getText()=="O")){
            oWins(0,1,2);
        }
        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") &&
                (buttons[8].getText()=="O")){
            oWins(0,1,2);
        }
        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") &&
                (buttons[8].getText()=="O")){
            oWins(0,1,2);
        }
        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") &&
                (buttons[6].getText()=="O")){
            oWins(0,1,2);
        }
        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O")){
            oWins(0,1,2);
        }
        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O")){
            oWins(0,1,2);
        }
        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O")){
            oWins(0,1,2);
        }
    }
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X WINS!");
    }
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O WINS!");
    }
}
