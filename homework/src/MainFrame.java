import javafx.scene.text.FontBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton but1=new JButton("Run");
    private JButton but2=new JButton("Reset");
    private JButton but3=new JButton("Exit");
    private Container cp ;
    private JButton[][] Jps=new JButton [3][3];

    private JPanel Jpc=new JPanel(new GridLayout(3,3,3,3));
    private JPanel Jpr=new JPanel(new GridLayout(3,1,3,3));

    private boolean flag =true;


    public MainFrame(){
        inti();
    }

    private void inti(){
        this.setBounds(100,100,600,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(Jpc,BorderLayout.CENTER);
        cp.add(Jpr,BorderLayout.EAST);
        Jpr.add(but1);
        Jpr.add(but2);
        Jpr.add(but3);

        for(int i=0 ;i<3;i++){
            for(int j=0;j<3;j++){
                Jps[i][j]=new JButton();
                Jps[i][j].setEnabled(false);
                Jpc.add(Jps[i][j]);
                Jps[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton tmptn=(JButton)e.getSource();
                        tmptn.setFont(new Font(null,Font.BOLD,72));
                        if(tmptn.getText().equals("")){
                            if(flag){
                                tmptn.setText("o");
                            }else{
                                tmptn.setText("x");
                            }
                            flag=!flag;
                        }
                        checkStart();
                    }
                });

            }
        }

        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0 ;i<3;i++) {
                    for (int j = 0; j < 3; j++) {
                        Jps[i][j].setEnabled(true);
                    }
                }
            }
        });

        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0 ;i<3;i++) {
                    for (int j = 0; j < 3; j++) {
                        Jps[i][j].setText("");
                        Jps[i][j].setEnabled(false);
                    }
                }
            }
        });





        but3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    private void checkStart(){
        if(Jps[0][0].getText().equals(Jps[0][1].getText())
                && Jps[0][0].getText().equals(Jps[0][2].getText())
                &&!Jps[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,Jps[0][0].getText()+"~WIN");
        }
        else if(Jps[1][0].getText().equals(Jps[1][1].getText())
                && Jps[1][0].getText().equals(Jps[1][2].getText())
                &&!Jps[1][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,Jps[1][0].getText()+"~WIN");
        }
        else if(Jps[2][0].getText().equals(Jps[2][1].getText())
                && Jps[2][0].getText().equals(Jps[2][2].getText())
                &&!Jps[2][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,Jps[2][0].getText()+"~WIN");
        }

        else if(Jps[0][0].getText().equals(Jps[1][0].getText())
                && Jps[0][0].getText().equals(Jps[2][0].getText())
                &&!Jps[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,Jps[0][0].getText()+"~WIN");
        }
        else if(Jps[1][0].getText().equals(Jps[1][1].getText())
                && Jps[1][0].getText().equals(Jps[2][1].getText())
                &&!Jps[1][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,Jps[1][0].getText()+"~WIN");
        }
        else if(Jps[2][0].getText().equals(Jps[1][2].getText())
                && Jps[2][0].getText().equals(Jps[2][2].getText())
                &&!Jps[2][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,Jps[2][0].getText()+"~WIN");
        }
        else if(Jps[0][0].getText().equals(Jps[1][1].getText())
                && Jps[0][0].getText().equals(Jps[2][2].getText())
                &&!Jps[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,Jps[0][0].getText()+"~WIN");
        }
        else if(Jps[0][2].getText().equals(Jps[1][1].getText())
                && Jps[0][2].getText().equals(Jps[2][0].getText())
                &&!Jps[0][2].getText().equals("")){
            JOptionPane.showMessageDialog(MainFrame.this,Jps[0][2].getText()+"~WIN");
        }

    }



}
