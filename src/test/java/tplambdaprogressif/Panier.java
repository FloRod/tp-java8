package tplambdaprogressif;

import java.util.ArrayList;
import java.util.List;

public class Panier {

	private List<Article> articles;

	public Panier() {
		articles = new ArrayList<>();
	}

	// méthode 0
	public List<Article> filtrer() {

		List<Article> tabArticleTemp = new ArrayList<Article>();
		for (Article i : articles) {
			if (i.isEnRupture()) {
				tabArticleTemp.add(i);
			}
		}
		return tabArticleTemp;
	}
	
	// méthode 1
	public List<Article> filtrer(boolean stock, double prixMax) {

		List<Article> tabArticleTemp = new ArrayList<Article>();
		for (Article i : articles) {
			if (i.isEnRupture() == stock && i.getPrix() <= prixMax) {
				tabArticleTemp.add(i);
			}
		}
		return tabArticleTemp;
	}
	
	// méthode 2
	public List<Article> filtrer(IFiltre filtre) {

		List<Article> tabArticleTemp = new ArrayList<Article>();
		for (Article i : articles) {
			if (filtre.accept(i)) {
				tabArticleTemp.add(i);
			}
		}
		return tabArticleTemp;
	}

	/**
	 * @return the articles
	 */
	public List<Article> getArticles() {
		return articles;
	}

	/**
	 * @param articles
	 *            the articles to set
	 */
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}