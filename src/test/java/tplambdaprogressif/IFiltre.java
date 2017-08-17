package tplambdaprogressif;

@FunctionalInterface
public interface IFiltre {

	public boolean accept(Article article);
}
