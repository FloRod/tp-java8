package tplambdaprogressif;

import java.util.List;

public class TestPanier {

	public static void main(String[] args) {

		Panier panier = new Panier();
		panier.getArticles().add(new Article("Coca-Cola", "Boisson", 2.5, false));
		panier.getArticles().add(new Article("Orangina", "Boisson", 2.5, false));
		panier.getArticles().add(new Article("Bière sans alcool", "Boisson", 4.2, true));
		panier.getArticles().add(new Article("Spaghetti", "Pates", 1.8, false));
		panier.getArticles().add(new Article("Lasagnes", "Pates", 3.1, true));
		panier.getArticles().add(new Article("Ramen", "Pates", 3.5, false));
		panier.getArticles().add(new Article("Beurre salé", "Produits laitiers", 1.8, true));
		panier.getArticles().add(new Article("Camembert", "Produits laitiers", 2.8, false));
		panier.getArticles().add(new Article("Yaourth", "Produits laitiers", 3.1, false));

		// En méthode impérative:
		// a- écrire une méthode dans la classe panier qui filtre les articles et retourne uniquement les articles du panier qui sont en stock (enRupture=false)

		System.out.println("méthode 0");
		List<Article> articles = panier.filtrer();
		for (Article i : articles) {
			System.out.println(i.isEnRupture() + " " + i.getPrix());
		}
		// b- écrire une méthode dans la classe panier un peu plus générique qui prend en paramètre stock=O/N et un prix maximum et qui retourne
		// la liste des articles du panier qui correspondent aux critères (cf. exemple 1)

		// c- vérifier que la méthode fonctionne en testant divers cas de figures. Exemple (1) de ce qu’il faut obtenir :

		articles = panier.filtrer(true, 4);
		System.out.println("première méthode");
		for (Article i : articles) {
			System.out.println(i.isEnRupture() + " " + i.getPrix());
		}

		// Ecrire maintenant une interface Filtre qui a une seule méthode : boolean accept(Article article)

		// Ajouter une annotation à cette interface de manière à ce qu’elle ne puisse avoir qu’une seule méthode

		// Ecrire une classe qui implémente l’interface Filtre. La méthode de cette classe retourne true uniquement pour les produits en stock.

		// Ecrire une classe qui implémente l’interface Filtre. La méthode de cette classe retourne true uniquement pour les produits en stock et dont le prix
		// n’excède pas un montant limite.

		// Modifier la méthode de la classe panier précédente afin qu'elle utilise ce nouveau système de filtrage plutôt qu’un filtre interne.

		System.out.println("deuxième méthode");
		articles = panier.filtrer(new Filtre());
		for (Article i : articles) {
			System.out.println(i.isEnRupture() + " " + i.getPrix());
		}

		// Appeler la méthode filtrer avec une classe anonyme
		// articles = ...;
		// assert articles.size()==4;
		
		System.out.println("troisième méthode : classe anonyme");
		IFiltre newFiltre = new IFiltre() {

			@Override
			public boolean accept(Article article) {
				boolean bool = false;
				double prixMax = 3.1;
				if (article.isEnRupture() && article.getPrix() <= prixMax) {
					bool = article.isEnRupture();
				}
				return bool;
			}
		};

		articles = panier.filtrer(newFiltre);
		for (Article i : articles) {
			System.out.println(i.isEnRupture() + " " + i.getPrix());
		}

		articles.clear();
		// Appeler la méthode filtrer avec une expression lamnda
		// articles = ...;
		
		System.out.println("quatrième méthode : expression lambda");
		double prixMax = 5;
		//		IFiltre lambdaFiltre = (Article article) -> {
		//			return (article.isEnRupture() && article.getPrix() <= prixMax);
		//		};
		
		IFiltre lambdaFiltre = article -> article.isEnRupture() && article.getPrix() <= prixMax;
		articles = panier.filtrer(lambdaFiltre);
		for (Article i : articles) {
			System.out.println(i.isEnRupture() + " " + i.getPrix());
		}
			
	}

}
