import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class MyDataBase {
String url ="jdbc:mysql://localhost/Examen",user="root",password="";
Connection con;
Statement stm;
ResultSet resultSelect;
int ResultUpdate;


public MyDataBase() {
    connexion();
}
void connexion() {
    try { 
        Class.forName("com.mysql.jdbc.Driver");
    }catch (ClassNotFoundException e) {
        System.err.println("Driver loading error: "+e);
    }
    try{
        con=DriverManager.getConnection(url, user, password);
    }catch(SQLException e){
        System.err.println("Sql connection error: "+e);
    }
}

public void ajouter(personne p){
    String v1;
    String v2;
    v1=p.getnom();
    v2=p.getgenre();
    String query="INSERT INTO users(Nom,Genre) Values('"+v1+"', '"+v2+"')";
    
    try{
        stm=con.createStatement();
    }catch(SQLException e){
        System.err.println("Sql creating error "+e);
    }
    try{
        ResultUpdate=stm.executeUpdate(query);
    }catch(SQLException e){
        System.err.println("Sql executing query: "+e);
    }
    try{
        //stm.close();
        //con.close();
    }catch(Exception e){
        System.err.println("Closing connection error: "+e);
    }
}
DefaultTableModel requeteSelection(String requete, DefaultTableModel model)
{

    try{
        stm=con.createStatement();
    }catch(SQLException e){
        System.err.println("Sql creating error "+e);
    }
    try
    {
        model.setRowCount(0);
        resultSelect=stm.executeQuery(requete);
        Object ligne[]=new Object[model.getColumnCount()];
        while(resultSelect.next())
        {
            for(int i=0;i<ligne.length;i++)
            {
                ligne[i]=resultSelect.getString(i+1);
            }
            model.addRow(ligne);
        }
    }catch(SQLException e)
    {
        System.err.println("Error executing query: " + e); 
    }
    try{
        //stm.close();
        //con.close();
    }catch(Exception e){
        System.err.println("Closing connection error: "+e);
    }
    return model;
}
void remplirTable(DefaultTableModel model)
{
    requeteSelection("SELECT * FROM users ",model);
}
int nbrfemales(){
   int nbr=0;
   
try{
    stm=con.createStatement();
}catch(SQLException e){
    System.err.println("Sql creating error "+e);
}
try{
    resultSelect=stm.executeQuery("SELECT * FROM users where Genre='Femme'");
    while(resultSelect.next()){
        nbr++;
    }
}catch(SQLException e)
{
    System.err.println("Error executing query: " + e); 
}
try{
    //stm.close();
    //con.close();
}catch(Exception e){
    System.err.println("Closing connection error: "+e);
}   
   return nbr;
}
int nbrmales(){
    int nbr=0;

 try{
     stm=con.createStatement();
 }catch(SQLException e){
     System.err.println("Sql creating error "+e);
 }
 try{
     resultSelect=stm.executeQuery("SELECT * FROM users where Genre='Homme'");
     while(resultSelect.next()){
         nbr++;
     }
 }catch(SQLException e)
 {
     System.err.println("Error executing query: " + e); 
 }
 try{
     //stm.close();
     //con.close();
 }catch(Exception e){
     System.err.println("Closing connection error: "+e);
 }   
    return nbr;
 }
 String nbrpersonne(){
    String p = " ";

 try{
     stm=con.createStatement();
 }catch(SQLException e){
     System.err.println("Sql creating error "+e);
 }
 try{
     resultSelect=stm.executeQuery("SELECT * FROM users");
     while(resultSelect.next()){
         p = resultSelect.getString(1);
     }
 }catch(SQLException e)
 {
     System.err.println("Error executing query: " + e); 
 }
 try{
     //stm.close();
     //con.close();
 }catch(Exception e){
     System.err.println("Closing connection error: "+e);
 }   
    return p ;
 }
}

