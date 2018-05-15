import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class frame1 extends JFrame{
    private JButton but1=new JButton("產生");
    private JButton but2=new JButton("結束");
    private Container cp ;
    private JLabel[] Jps=new JLabel [6];
    private JPanel Jpc=new JPanel(new GridLayout(1,6,3,3));
    private JPanel Jpr=new JPanel(new GridLayout(1,2,3,3));

    private Random ran=new Random();
    public frame1(){
        inti();
    }

    private void inti(){
        this.setBounds(100,100,500,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));



        for(int i=0 ;i<6;i++){
            Jps[i]=new JLabel();
            Jps[i].setHorizontalAlignment(JLabel.CENTER);
            Jps[i].setOpaque(true);
            Jps[i].setBackground(new Color(255, 117, 80));
            Jps[i].setFont(new Font(null,Font.PLAIN,36));
            Jpc.add(Jps[i]);

        }


        cp.add(Jpc,BorderLayout.CENTER);
        cp.add(Jpr,BorderLayout.SOUTH);
        Jpr.add(but1);
        Jpr.add(but2);




        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=0 ;
                while(i<6){
                    Jps[i].setText(Integer.toString(ran.nextInt(49)+1));
                    boolean flag=true;
                    int j=0;
                    while (j<i){
                        if(Jps[i]==Jps[j]){
                            flag=false;

                        }
                        break;
                    }
                    if(flag){
                        i++;
                    }
                }
            }


        });

        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }




}
