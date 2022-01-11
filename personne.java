public class personne {
    private String nom;
    private String genre;
    private int id;

    public personne(){}
    public personne(int id,String nom,String genre){
        this.id=id;
        this.nom=nom;
        this.genre=genre;
    }
    public personne(String nom,String genre){
        this.nom=nom;
        this.genre=genre;        
    }
    public String getnom(){
      return this.nom;
    }
    public String getgenre(){
        return this.genre;
      }
    public int getid(){
        return this.id;
      }
    public void setnom(String nom){
        this.nom=nom;
    }
    public void setgenre(String genre){
        this.genre=genre;
    }
    public void setid(int id){
        this.id=id;
    }
}
