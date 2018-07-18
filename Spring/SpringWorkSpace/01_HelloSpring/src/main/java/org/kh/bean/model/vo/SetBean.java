package org.kh.bean.model.vo;

import java.util.Set;

public class SetBean {
	private Set<String> set ;

	public SetBean() {
		super();
	}
	
	public SetBean(Set<String> set) {
		this.set = set;
	}


	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}
	
	
}
