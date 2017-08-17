package tplambdaprogressif;

public class Article {

	private String reference;
	private String type;
	private double prix;
	private boolean enRupture;
	
	public Article(String reference, String type, double prix, boolean enRupture) {
		super();
		this.reference = reference;
		this.type = type;
		this.prix = prix;
		this.enRupture = enRupture;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the enRupture
	 */
	public boolean isEnRupture() {
		return enRupture;
	}

	/**
	 * @param enRupture the enRupture to set
	 */
	public void setEnRupture(boolean enRupture) {
		this.enRupture = enRupture;
	}
}
