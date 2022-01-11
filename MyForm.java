import javax.swing.*;
import java.awt.*;

public class MyForm extends JFrame {
    JPanel P = new JPanel();
    JPanel P1 = new JPanel();
    JPanel P2 = new JPanel();
    JPanel P3 = new JPanel();
    JPanel Pass = new JPanel();
    JButton b1 = new JButton("Ajouter");
    JButton b2 = new JButton("List");
    JLabel l = new JLabel("Nom:");
    JLabel l1 = new JLabel("Genre:");
    JLabel examen=new JLabel("Examen");
    JTextField tf = new JTextField();
    JRadioButton j1 = new JRadioButton("Homme ♂");
    JRadioButton j2 = new JRadioButton("Femme ♀");
    ButtonGroup G = new ButtonGroup();
  
    
    public MyForm(){ 
        examen.setHorizontalAlignment(SwingConstants.CENTER);
    	examen.setFont(new Font("Time New Roman", Font.BOLD, 25));
        G.add(j1);
        G.add(j2);
        P1.setLayout(new GridLayout(1,1));
        P1.add(l);
        P1.add(tf);
        P3.setLayout(new GridLayout(1,2));
        P3.add(l1);
        P3.add(j1);
        P3.add(j2);
        Pass.setLayout(new GridLayout(2,1));
        Pass.add(P1);
        Pass.add(P3);
        Pass.setBorder(BorderFactory.createTitledBorder("Informations"));
        P2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        P2.add(b1);
        P2.add(b2);
        P.setLayout(new BorderLayout());
        P.add("Center",Pass);
        P.add("South",P2);
        Container c=getContentPane();
    	c.setLayout(new BorderLayout());
        c.add("North",examen);
        c.add("Center",P);
        setTitle("Examen");
        setSize(800,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        b1.addActionListener(new MyEvents(this));
        b2.addActionListener((e)->new MyList());
        }
public String  btnselect (){

                String qual = " ";
  
                if (j1.isSelected()) {
  
                    qual = "Homme";
                }
  
                else if (j2.isSelected()) {
  
                    qual = "Femme";
                }
                else {
  
                    qual = "Null";
                }     
                return qual;
        }
    public static void main(String[] args){
        new MyForm();
    }
}