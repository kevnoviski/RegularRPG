package model;

public class ClasseMount {
	private String classe;

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
