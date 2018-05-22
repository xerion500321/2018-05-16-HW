import org.jcp.xml.dsig.internal.dom.DOMBase64Transform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JLabel lab = new JLabel("0",JLabel.RIGHT);
    private JButton jbtn[][] = new JButton[4][5];
    private Container cp;
    private JPanel jpannorth = new JPanel(new GridLayout(1,1,3,3));
    private JPanel jpancenter = new JPanel(new GridLayout(4, 5, 3, 3));
    private ImageIcon imgIcons[] = new ImageIcon[10];
    int op;
    Double v1;
    Double v3;
    Double v2;
    public MainFrame() {
        init();
    }
    private void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 50, 800, 550);
        this.cp = this.getContentPane();
        this.cp.setLayout(new BorderLayout(3, 3));
        this.cp.add(this.jpancenter,"Center");
        this.cp.add(this.jpannorth,"North");
        this.jpannorth.add(lab);
        lab.setFont(new Font(null,Font.BOLD,54));
        for(int i=0 ; i<10 ; i++){
            String imgName = Integer.toString(i)+".png";
            imgIcons[i] = new ImageIcon(imgName);
            }
                jbtn[0][0] = new JButton(imgIcons[7]);
                jbtn[0][1] = new JButton(imgIcons[8]);
                jbtn[0][2] = new JButton(imgIcons[9]);
                jbtn[0][3] = new JButton("/");
                jbtn[0][4] = new JButton("AC");
                jbtn[1][0] = new JButton(imgIcons[4]);
                jbtn[1][1] = new JButton(imgIcons[5]);
                jbtn[1][2] = new JButton(imgIcons[6]);
                jbtn[1][3] = new JButton("*");
                jbtn[1][4] = new JButton("SQRT");
                jbtn[2][0] = new JButton(imgIcons[1]);
                jbtn[2][1] = new JButton(imgIcons[2]);
                jbtn[2][2] = new JButton(imgIcons[3]);
                jbtn[2][3] = new JButton("-");
                jbtn[2][4] = new JButton("PI");
                jbtn[3][0] = new JButton(imgIcons[0]);
                jbtn[3][1] = new JButton(".");
                jbtn[3][2] = new JButton("=");
                jbtn[3][3] = new JButton("+");
                jbtn[3][4] = new JButton("Exit");
                for (int i=0 ; i<4 ; i++){
                    for (int j=0 ; j<5 ; j++){
                        this.jpancenter.add(jbtn[i][j]);
                        jbtn[i][j].setFont(new Font(null,Font.BOLD,36));
                    }
                }
                for(int i=0 ; i<4 ; i++){
                    for(int j=0 ; j<5 ; j++){
                        jbtn[i][j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton jbtn1 = (JButton)e.getSource();
                                switch (jbtn1.getText()) {
                                    case "AC":
                                        lab.setText("0");
                                        op = -1;
                                        break;
                                    case "SQRT":
                                        v1 = Double.parseDouble(lab.getText());
                                        lab.setText(Double.toString(Math.sqrt((v1))));
                                        break;
                                    case "PI":
                                        lab.setText(Double.toString(Math.PI));
                                        break;
                                    case "Exit":
                                        System.exit(0);
                                    case "+":
                                        op = 0;
                                        v1 = Double.parseDouble(lab.getText());
                                        break;
                                    case "-":
                                        op = 1;
                                        v1 = Double.parseDouble(lab.getText());
                                        break;
                                    case "*":
                                        op = 2;
                                        v1 = Double.parseDouble(lab.getText());
                                        break;
                                    case "/":
                                        op = 3;
                                        v1 = Double.parseDouble(lab.getText());
                                        break;
                                    case "=":
                                        v2 = Double.parseDouble(lab.getText());
                                        switch (op) {
                                            case 0:
                                                v3 = v1+v2;
                                                break;
                                            case 1:
                                                v3 = v1-v2;
                                                break;
                                            case 2:
                                                v3 = v1*v2;
                                                break;
                                            case 3:
                                                v3 = v1/v2;
                                                break;
                                        }
                                        lab.setText(Double.toString(v3));
                                        op = -1;
                                        break;
                                         default:
                                        if(lab.getText().equals("0")||op>-1){
                                            if(jbtn1.getIcon().equals(imgIcons[7])){
                                                lab.setText("7");
                                            }
                                            else if(jbtn1.getIcon().equals(imgIcons[8])){
                                                lab.setText("8");
                                            }
                                            else if(jbtn1.getIcon().equals(imgIcons[9])){
                                                lab.setText("9");
                                            }
                                            else if (jbtn1.getIcon().equals(imgIcons[4])){
                                                lab.setText("4");
                                            }
                                            else if (jbtn1.getIcon().equals(imgIcons[5])){
                                                lab.setText("5");
                                            }
                                            else if(jbtn1.getIcon().equals(imgIcons[6])){
                                                lab.setText("6");
                                            }
                                            else if(jbtn1.getIcon().equals(imgIcons[1])){
                                                lab.setText("1");
                                            }
                                            else if(jbtn1.getIcon().equals(imgIcons[2])){
                                                lab.setText("2");
                                            }
                                            else  if(jbtn1.getIcon().equals(imgIcons[3])){
                                                lab.setText("3");
                                            }
                                            else if(jbtn1.getIcon().equals(imgIcons[0])){
                                                lab.setText("0");
                                            }
                                        }
                                        else {
                                           lab.setText(jbtn1.getText()+lab.getText());
                                           }
                                }
                            }
                        });
                    }
                }
            }
}
