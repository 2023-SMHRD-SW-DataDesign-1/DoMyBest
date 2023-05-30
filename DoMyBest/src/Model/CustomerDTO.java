package Model;

public class CustomerDTO {

	private String name;
	private String gender;
	private String hamburger;
	private String recipe;

	public CustomerDTO(String name, String gender, String hamburger, String recipe) {

		this.name = name;
		this.gender = gender;
		this.hamburger = hamburger;
		this.recipe = recipe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHamburger() {
		return hamburger;
	}

	public void setHamburger(String hamburger) {
		this.hamburger = hamburger;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

}
