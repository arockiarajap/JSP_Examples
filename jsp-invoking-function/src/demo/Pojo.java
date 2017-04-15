/**
 * 
 */
package demo;

/**
 * @author Arockia
 *
 */
public class Pojo {

	private String type = null;
	private static String[] types = new String[8];

	public Pojo() {
		types[0] = "byte";
		types[1] = "short";
		types[2] = "int";
		types[3] = "long";
		types[4] = "float";
		types[5] = "double";
		types[6] = "boolean";
		types[7] = "char";
	}

	public static boolean isAcceptableType(String type) {
		boolean acceptable = false;
		for (String string : types) {
			if (string.equalsIgnoreCase(type)) {
				acceptable = true;
				break;
			}
		}
		return acceptable;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
