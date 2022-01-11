
import java.awt.*;
import javax.swing.*;
public class MyThread extends Thread {
    MyList l; 
    Histogramme g;
    int nbrf;
    int nbrm;
    private final int TIMEOUT = 1000;
public MyThread(MyList l){
        this.l=l;
        g = new Histogramme();
}
class Histogramme extends JPanel  {
    int nbrf;
    int nbrm;
    String nbrp;

public Histogramme(){
  this.setBackground(Color.black);
}
public void paintComponent(Graphics g){
  
    super.paintComponent(g);
    int height = this.getHeight();
    int width = this.getWidth();
    nbrf=l.db.nbrfemales();
    nbrm=l.db.nbrmales();
    nbrp=l.db.nbrpersonne();
    if ( (nbrf*10 > height ) || (nbrm*10 > height) )
    {
        g.setColor(Color.red);
        g.drawString("WARNING!!", (width/2)-30 , (height/2) );
        g.drawString("Capacity Overload !!",(width/2)-50 , ((height/2)+20) );
    }
    else{
        g.setColor(Color.pink);
        g.fillRect(50,(height-(10*nbrf)),100,height);
        
        g.setColor(Color.white);
        g.drawString("Nbr",0, 10);
        g.drawString(nbrp,20,10);
        g.setColor(Color.blue);
        g.drawString("Male", (width-50) , (height-10));
        g.setColor(Color.pink);
        g.drawString("Female", (width-150) , (height-10));
    
        g.setColor(Color.blue);
        g.fillRect(170,(height-(10*nbrm)),100,height);
    }
}
}
public void run(){  
    while (true) {
 try {
        Thread.sleep(TIMEOUT);
        l.db.remplirTable(l.model);
        g.paintComponent(g.getGraphics());
    } catch (InterruptedException ex) {
    }
}  
}
}



