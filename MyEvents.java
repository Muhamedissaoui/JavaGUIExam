import java.awt.event.*;

public class MyEvents implements ActionListener {
 
MyForm f;    
MyDataBase db = new MyDataBase();
public MyEvents(MyForm f){
   this.f=f;
}
public void actionPerformed(ActionEvent e){
    if(e.getSource()==f.b1)
    {
    personne p = new personne();
    p.setnom(f.tf.getText());
    p.setgenre(f.btnselect());
    db.ajouter(p);
    }
}
}
