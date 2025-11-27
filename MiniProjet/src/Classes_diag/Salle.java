package Classes_diag;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Salle {
	 int id;
	    String nom;
	    int capacite;
	    List<Materiel> materiels;
	    List<Crenau> creneaux;   // sessions prévues dans la salle

	    Salle(int id, String nom, int capacite) {
	        this.id = id;
	        this.nom = nom;
	        this.capacite = capacite;
	        this.materiels = new ArrayList<>();
	        this.creneaux = new ArrayList<>();
	    }
	    

	    public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}


		public int getCapacite() {
			return capacite;
		}


		public void setCapacite(int capacite) {
			this.capacite = capacite;
		}


		public List<Materiel> getMateriels() {
			return materiels;
		}


		public void setMateriels(List<Materiel> materiels) {
			this.materiels = materiels;
		}


		public List<Crenau> getCreneaux() {
			return creneaux;
		}


		public void setCreneaux(List<Crenau> creneaux) {
			this.creneaux = creneaux;
		}


		// Vérifie la disponibilité pour un nouveau créneau
	    boolean estDisponible(Date d, Time deb, Time fin) {
	        Crenau test = new Crenau(null, this, d, deb, fin);

	        for (Crenau c : creneaux) {
	            if (test.chevauche(c)) return false;
	        }
	        return true;
	    }

	    // Ajouter du matériel dans la salle
	    void ajouterMateriel(Materiel m) {
	        materiels.add(m);
	    }

	    // Retirer matériel
	    void retirerMateriel(Materiel m) {
	        materiels.remove(m);
	    }

	    // Ajouter un créneau finalisé
	    void ajouterCreneau(Crenau c) {
	        creneaux.add(c);
	    }

}
