package Classes_diag;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

class Crenau {
    LocalDate date;
    LocalTime heureDebut;
    LocalTime heureFin;

    Session session;
    Salle salle;

    Crenau(Session s, Salle sal, LocalDate d, LocalTime deb, LocalTime fin) {
        this.session = s;
        this.salle = sal;
        this.date = d;
        this.heureDebut = deb;
        this.heureFin = fin;
    }
    
    

    public Crenau(Object s, Salle sal, Date d, Time deb, Time fin) {
		// TODO Auto-generated constructor stub
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public LocalTime getHeureDebut() {
		return heureDebut;
	}



	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}



	public LocalTime getHeureFin() {
		return heureFin;
	}



	public void setHeureFin(LocalTime heureFin) {
		this.heureFin = heureFin;
	}



	public Session getSession() {
		return session;
	}



	public void setSession(Session session) {
		this.session = session;
	}



	public Salle getSalle() {
		return salle;
	}



	public void setSalle(Salle salle) {
		this.salle = salle;
	}



	// Vérifie superposition avec un autre créneau
    boolean chevauche(Crenau c) {
        if (!this.date.equals(c.date)) return false;

        return !(this.heureFin.compareTo(c.heureDebut) <= 0 ||
                 this.heureDebut.compareTo(c.heureFin) >= 0);
    }

    int dureeMinutes() {
        return (int) java.time.Duration.between(heureDebut, heureFin).toMinutes();
    }
}

