package BufferCucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
	private double result;
	private BufferAcotado<Integer> buff;
	private String res;
	
	@Given("I want to create a buffer")
	public void nada() {}	
	@When("I do it with capacity {int}")
	public void initialiate(int a) {
	res="Creado satisfactoriamente";
		try {
		new BufferAcotado<Integer>(a);
	}catch (IllegalArgumentException e) {
		res="Ilegal";
	}
	}
	
	@Then("it should return {string}")
	public void returnconstruct(String expectedAnswer) {
		assertEquals(expectedAnswer, res);
	}
	
	@Given("I have a buffer of capacity {int}")
	public void creo(int a) {
		buff = new BufferAcotado<Integer>(a);
	}	
	
	@When("I put one item")
	public void adding() {
	buff.put(4);
	result=buff.size();
	}
	
	@Then("Size should be: {double}")
	public void size(double expectedAnswer) {
		assertEquals(expectedAnswer, result);
	}
	
	@When("I put one item and then I delete it")
	public void quitando() {
	buff.put(4);
	buff.get();
	result=buff.size();
	}
	
	@When("I put four items")
	public void addingmore() {
	buff.put(4);
	buff.put(4);
	buff.put(4);
	buff.put(4);
	result=buff.size();
	}
	
	@When("I put four items and I delete two")
	public void addingmoredeleting() {
	buff.put(4);
	buff.put(4);
	buff.put(4);
	buff.put(4);
	buff.get();
	buff.get();
	result=buff.size();
	}
	
	@Then("I add one and I get {string}")
	public void lleno(String expectedAnswer) {
		res="No lleno";
		try {
		buff.put(4);
	}catch (IllegalStateException e) {
		res="Lleno";
	}
		assertEquals(expectedAnswer, res);
	}
	
	@Then("I delete all and I get {string}")
	public void vacio(String expectedAnswer) {
		res="No vacio";
		buff.get();
		buff.get();
		buff.get();
		buff.get();
		if (buff.size()==0) res="Vacio";
		assertEquals(expectedAnswer, res);
	}
	
}
