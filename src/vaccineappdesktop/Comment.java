/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccineappdesktop;

/**
 *
 * @author muslumoncel
 */
public class Comment {

	private final String comment, comment_date, vaccine_name, username;

	public Comment(String comment, String comment_date, String vaccine_name, String username) {
		this.comment = comment;
		this.comment_date = comment_date;
		this.vaccine_name = vaccine_name;
		this.username = username;
	}

	public String getComment() {
		return comment;
	}

	public String getComment_date() {
		return comment_date;
	}

	public String getUsername() {
		return username;
	}

	public String getVaccine_name() {
		return vaccine_name;
	}

}
