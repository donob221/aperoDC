package sqli.df.tp.tp_test;

import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

// j'ai refait à peu près la même chose que ce que j'ai perdu
// mais je n'arrive pas à lancer les tests, cela ne fonctionne qu'avec AppTest.java
// je ne sais pas ce qui manque mais j'ai déjà trop de retard alors voici ma dernière version

public class AperoDeConsSteps {
	
	private Pub thePub;
	
	
	@Given("^The pub exists$")
	public void aperoDeConsSteps(){
		thePub = new Pub();
	}
	
	@Given("^The pub has (\\d+) places$")
	public void the_pub_has_places(int arg1) throws Throwable {
	    thePub.setPlaces(arg1);
	}
	
	@Given("^(\\d+) places are already taken in the pub$")
	public void places_are_already_taken_in_the_pub(int arg1) throws Throwable {
		thePub.setNotFree(arg1);
	}

	@Given("^A group of (\\d+) want to enter the pub$")
	public void a_group_of_want_to_enter_the_pub(int arg1) throws Throwable {
	    thePub.setArriving(arg1);
	}
	
	@When("^the number of arriving \\+ the number of notFree > the number of places is true$")
	public void the_number_of_arriving_the_number_of_notFree_the_number_of_places_is_true() throws Throwable {
	    Assert.assertTrue((thePub.getArriving() + thePub.getNotFree()) > thePub.getPlaces());
	    thePub.setStatus("Complet");
	}
	
	@When("^the number of arriving \\+ the number of notFree > the number of places is false$")
	public void the_number_of_arriving_the_number_of_notFree_the_number_of_places_is_false() throws Throwable {
		 Assert.assertFalse((thePub.getArriving() + thePub.getNotFree()) > thePub.getPlaces());
		 thePub.setStatus("Pas complet");
	}
	
	@Then("^The status of the pub is \"([^\"]*)\"$")
	public void the_status_of_the_pub_is(String arg1) throws Throwable {
		Assert.assertTrue(thePub.getStatus().equals(arg1));
	}
	
	@Then("^They command (\\d+) cocktails$")
	public void they_command_cocktails(int arg1) throws Throwable {
		thePub.setConso(arg1);
	}

	@Then("^Le Blanc pays (\\d+) and Pignon (\\d+)$")
	public void le_Blanc_pays_and_Pignon(int arg1, int arg2) throws Throwable {
		thePub.setLbPays(arg1);
		thePub.setPPays(arg2);
	}

	@Then("^Pignon feels \"([^\"]*)\"$")
	public void pignon_feels(String arg1) throws Throwable {
		thePub.setPignon(arg1);
	}
}