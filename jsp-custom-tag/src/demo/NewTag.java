/**
 * 
 */
package demo;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author Arockia
 *
 */
public class NewTag extends SimpleTagSupport {

	private String name;
	private int age;
	private String about;

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		if(name!=null){
			out.println("Person Name : "+name+"<br/>");
			out.println("Person age : "+age+"<br/>");
			out.println("Person about : "+about+"<br/>");
			out.println("<br/>");
		}
	}

}
