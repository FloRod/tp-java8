package tplambdaprogressif;

public class Filtre implements IFiltre {

	@Override
	public boolean accept(Article article) {
		boolean bool = false;
		double prixMax = 2;
		if (article.isEnRupture() && article.getPrix() <= prixMax){
			bool = article.isEnRupture();
		}
		return bool;
	}

}
