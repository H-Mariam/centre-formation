package mini_projet;

import java.util.ArrayList;

public class Formation {
	private int IdFormation;
	private String NomFormation;
	private String Description;
	private int Capacité;
	private ArrayList<Etudiant> ListEtud = new ArrayList<>();
	private Formateur Formateur;
	
	
	public Formation(String nomFormation, String description, int capacité,Formateur formateur) {
		super();
		NomFormation = nomFormation;
		Description = description;
		Capacité = capacité;
		Formateur = formateur;
	}
	public Formation(String nomFormation, int capacité,Formateur formateur) {
		super();
		NomFormation = nomFormation;
		Capacité = capacité;
		Formateur = formateur;
	}
	public String getNomFormation() {
		return NomFormation;
	}
	public void setNomFormation(String nomFormation) {
		NomFormation = nomFormation;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getCapacité() {
		return Capacité;
	}
	public void setCapacité(int capacité) {
		Capacité = capacité;
	}
	public ArrayList<Etudiant> getListEtud() {
		return ListEtud;
	}
	public void setListEtud(ArrayList<Etudiant> listEtud) {
		ListEtud = listEtud;
	}
	public Formateur getFormateur() {
		return Formateur;
	}
	public void setFormateur(Formateur formateur) {
		Formateur = formateur;
	}
	public int getIdFormation() {
		return IdFormation;
	}
	
	public void ajouterEtudiant(Etudiant e) {
        if (ListEtud.size() < Capacité) {
        	ListEtud.add(e);
            System.out.println("Étudiant ajouté à la formation : " + e.getNom());
        } else {
            System.out.println("Impossible d'ajouter l'étudiant : capacité maximale atteinte.");
        }
    }
	public boolean estInscrit(Etudiant e) {
	    return ListEtud.contains(e);
	}
	
	public void supprimerEtudiant(Etudiant e) {
	    if (ListEtud.remove(e)) {
	        System.out.println("Étudiant supprimé : " + e.getNom());
	    } else {
	        System.out.println("Impossible : l'étudiant n'est pas inscrit dans cette formation.");
	    }
	}
	

}
