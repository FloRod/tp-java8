package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercice 02 - Map
 */
public class Lambda_02_Test {

	// tag::PersonToAccountMapper[]
	interface PersonToAccountMapper<T> { // T = type générique, ici devrait être Account ou String (transformation personne -> compte et prénom
		T map(Person p);
	}
	// end::PersonToAccountMapper[]
	// interface PersonToFirstName {String firstname(Person p);}  -> ancienne méthode pour String
	
	// tag::map[]
	private <T> List<T> map(List<Person> personList, PersonToAccountMapper<T> mapper) {

		// TODO implémenter la méthode pour transformer une liste de personnes en liste de comptes ou en liste de prénom
		List<T> tabReverse = new ArrayList<T>();
		for (Person i : personList) {
			tabReverse.add((T) mapper.map(i));
		}
		return tabReverse;
	}
	// end::map[]
	
	// ancienne méthode pour le traitement individuel de la deuxième partie du programme (personne -> prénom)
	// private List<String> firstname(List<Person> personList, PersonToFirstName name) {
	// // TODO implémenter la méthode pour transformer une liste de personnes en liste de prénoms
	// List <String> tabReverse = new ArrayList<String>();
	// for (Person i : personList){
	// tabReverse.add(name.firstname(i));
	// }
	// return tabReverse;
	// }

	// tag::test_map_person_to_account[]
	@Test
	public void test_map_person_to_account() throws Exception {

		List<Person> personList = Data.buildPersonList(100);

		// TODO transformer la liste de personnes en liste de comptes
		// TODO tous les objets comptes ont un solde à 100 par défaut

		PersonToAccountMapper<Account> persAccountReverse = personne -> new Account(personne, 100);
		List<Account> result = map(personList, persAccountReverse);

		assert result.size() == personList.size();
		for (Account account : result) {
			assert account.getBalance().equals(100);
			assert account.getOwner() != null;
		}
	}
	// end::test_map_person_to_account[]

	// tag::test_map_person_to_firstname[]
	@Test
	public void test_map_person_to_firstname() throws Exception {

		List<Person> personList = Data.buildPersonList(100);

		// TODO transformer la liste de personnes en liste de prénoms
		// PersonToFirstName persNameReverse = personne -> personne.getFirstname(); -> ancienne expression lambda lorsque le programme n'était pas générique
		
		PersonToAccountMapper<String> persNameReverse = personne -> personne.getFirstname();
		List<String> result = map(personList, persNameReverse);

		assert result.size() == personList.size();
		for (String firstname : result) {
			assert firstname.startsWith("first");
		}
	}
	// end::test_map_person_to_firstname[]
}
