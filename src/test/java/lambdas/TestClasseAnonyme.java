package lambdas;

public class TestClasseAnonyme {

	public static void main(String[] args) {

		// Mapper mapper = new Mapper() {
		// public Double map(CompteCourant t){
		// return t.getSolde();
		// }
		// };
		//
		// CompteCourant cc = new CompteCourant();
		// cc.setSolde(150.0);
		//
		// double solde = mapper.map(cc);
		// System.out.println(solde);

		// Ecriture Java 7
		Mapper mapper = new Mapper() { // interface mapper, une interface ne peut pas être instanciée => solution : création d'une classe anonyme (et forcément ineterne !)
			public Personne map(CompteCourant compte) {
				return new Personne(compte.getSolde());
			}
		};

		// Première étape : suppression du code "administratif" de la méthode
		mapper = (CompteCourant compte) -> {
				return new Personne(compte.getSolde());
		};

		// Deuxième étape : suppression des accolades et du return car le corps de la méthode ne contient qu'une seule ligne de code
		mapper = (CompteCourant compte) -> new Personne(compte.getSolde());

		// Trosième étape : suppression du type du paramètre : java le connait déjà !
		mapper = compte -> new Personne(compte.getSolde());

		CompteCourant cc = new CompteCourant();
		cc.setSolde(150.0);

		Personne personne = mapper.map(cc);
		System.out.println(personne.getSolde());
	}

}
