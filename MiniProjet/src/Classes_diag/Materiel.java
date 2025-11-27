package Classes_diag;

import java.util.List;

public class Materiel {
	int id;
    String nom;
    String type;
    int quantite;

    Materiel(int id, String nom, String type, int qte) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.quantite = qte;
    }

    // Vérifie si du matériel est disponible dans la salle
    boolean estDisponibleDans(List<Materiel> materielsSalle) {
        int count = 0;

        for (Materiel m : materielsSalle) {
            if (m.nom.equals(this.nom)) {
                count += m.quantite;
            }
        }

        return count >= this.quantite;
    }


}
