package mini_projet;

import java.util.ArrayList;
import java.util.List;

public class Session {

    private int id;
    private Formation formation;
    private Formateur formateur;
    private Creneau creneau;   // lie Salle + date + heures
    private Salle salle;
    private ArrayList<Materiel> materielsUtilises = new ArrayList<>();

    
    public Session(Formation formation, Formateur formateur, Creneau creneau, Salle salle,
			ArrayList<Materiel> materielsUtilises) {
		super();
		this.formation = formation;
		this.formateur = formateur;
		this.creneau = creneau;
		this.salle = salle;
		this.materielsUtilises = materielsUtilises;
	}
    

	public Session(Formation formation, Formateur formateur, Creneau creneau, Salle salle) {
		super();
		this.formation = formation;
		this.formateur = formateur;
		this.creneau = creneau;
		this.salle = salle;
	}


	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}

	public ArrayList<Materiel> getMaterielsUtilises() {
		return materielsUtilises;
	}

	public void setMaterielsUtilises(ArrayList<Materiel> materielsUtilises) {
		this.materielsUtilises = materielsUtilises;
	}
	

	public Formateur getFormateur() {
		return formateur;
	}


	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}


	public Salle getSalle() {
		return salle;
	}


	public void setSalle(Salle salle) {
		this.salle = salle;
	}


	public int getId() {
		return id;
	}
	

	// Vérifie que le créneau est valide (heures cohérentes)
    boolean verifierCreneau() {
        return creneau.heureDebut < creneau.heureFin;
    }

    // Vérifie que la salle du créneau est disponible
    boolean verifierDisponibiliteSalle(List<Creneau> autresCreneaux) {
        for (Creneau cr : autresCreneaux) {
            if (cr.salle == creneau.salle && creneau.chevauche(cr)) {
                return false;
            }
        }
        return true;
    }

    // Vérifie que le matériel est disponible
    boolean verifierDisponibiliteMateriel() {
        for (Materiel m : materielsUtilises) {
            if (!m.estDisponiblePourSalle(creneau.salle)) {
                return false;
            }
        }
        return true;
    }

    // Ajoute matériel utilisé par cette session
    void ajouterMateriel(Materiel m) {
        materielsUtilises.add(m);
    }

    // Vérifie toutes les cohérences
    boolean estCohérente(List<Creneau> autresCreneaux) {
        return verifierCreneau()
            && verifierDisponibiliteSalle(autresCreneaux)
            && verifierDisponibiliteMateriel();
    }
}