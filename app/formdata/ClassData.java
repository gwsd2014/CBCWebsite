package formdata;

public class ClassData {
	
	public String name;
	public String description;
	public String gradeLow;
	public String gradeHigh;
	
	public ClassData() {}
	public ClassData(String name, String description, String gradeLow, String gradeHigh) {
		this.name = name;
		this.description = description;
		this.gradeLow = gradeLow;
		this.gradeHigh = gradeHigh;
	}

	public String validate() {
		if (name.length() <= 0) {
			return "No class name specified! Please provide one, then try again.";
		}
		
		if (name.length() >= 50) {
			return "Class name is too long! Please provide a smaller one.";
		}

		if (gradeLow.equals("")) {
			return "No beginning grade range specified! Please provide one, then try again.";
		}

		if (gradeHigh.equals("")) {
			return "No end grade range specified! Please provide one, then try again.";
		}

		return null;
	}
	
}
