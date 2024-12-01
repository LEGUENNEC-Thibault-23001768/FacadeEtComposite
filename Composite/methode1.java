import java.util.ArrayList;
import java.util.List;

class Boite {
    private List<Object> contenu = new ArrayList<>();

    public void ajouter(Object objet) {
        contenu.add(objet);
    }

    public List<Object> getContenu() {
        return contenu;
    }
}

public class RecursiviteBrute {

    // Méthode pour calculer le prix total avec récursivité brute
    public static double calculerPrixTotal(Object objet) {
        if (objet instanceof Double) { // Si c'est un prix simple
            return (double) objet;
        } else if (objet instanceof Boite) { // Si c'est une boîte
            double somme = 0;
            Boite boite = (Boite) objet;
            for (Object element : boite.getContenu()) {
                somme += calculerPrixTotal(element); // Appel récursif
            }
            return somme;
        }
        throw new IllegalArgumentException("Type non supporté");
    }

    public static void main(String[] args) {
        // Création de boîtes et objets simples
        Boite boite1 = new Boite();
        boite1.ajouter(300.0); // Téléphone
        boite1.ajouter(1000.0); // Ordinateur

        Boite boite2 = new Boite();
        boite2.ajouter(200.0); // Téléphone

        Boite grandeBoite = new Boite();
        grandeBoite.ajouter(boite1);
        grandeBoite.ajouter(boite2);

        // Calcul du prix total
        double prixTotal = calculerPrixTotal(grandeBoite);
        System.out.println("Prix total de la grande boîte : " + prixTotal);
    }
}
