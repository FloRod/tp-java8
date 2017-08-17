package lambdas;

@FunctionalInterface					// empêche l'ajout, la suprression ou la modif des méthodes présentes dans cette interface si il y a utilisation de lambda expression
public interface Mapper {
	
	public Personne map(CompteCourant t);

}
