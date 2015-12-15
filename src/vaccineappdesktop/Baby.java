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
public class Baby {

	private final String baby_name;
	private final int baby_id;

	public int getBaby_id() {
		return baby_id;
	}

	public String getBaby_name() {
		return baby_name;
	}

	public Baby(String baby_name, int baby_id) {
		this.baby_name = baby_name;
		this.baby_id = baby_id;
	}

}
