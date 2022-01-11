import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
public class MyList  extends JFrame {
    String enteteTab[]={"ID","Nom","Genre"};
	DefaultTableModel model=new DefaultTableModel(enteteTab,0);
	JTable table=new JTable(model);
	JScrollPane sp=new JScrollPane(table);
    JPanel P = new JPanel();
    JPanel P1 = new JPanel();
    MyForm f;
    MyThread t = new MyThread(this);
    MyDataBase db = new MyDataBase();
    Container c=getContentPane();
public MyList(){
    setTitle("Examen");
    t.start();
    P.setLayout(new GridLayout(1,0));
    P.add(sp);
    P.setBorder(BorderFactory.createTitledBorder("Liste des utilisateurs"));
    c.setLayout(new BorderLayout());
    c.add("North",P);
    c.add("Center",t.g);
    setSize(600,800);
    setVisible(true);
    
} 
}
