package model;

public class ClasseMount {
    private int id;
    private String classe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClasse() {
            return classe;
    }

    public void setClasse(String classe) {
            this.classe = classe;
    }

    public ClasseMount() {

    }
    public ClasseMount(String classe) {

            this.classe = classe;
    }

    @Override
    public String toString() {
            return "ClasseMount [Classe=" + getClasse() + "]";
    }
	
	
}
