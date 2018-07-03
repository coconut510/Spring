package org.kh.bean.model.vo;

import java.util.Map;

public class MapBean {
	private Map<String,String> mapName;

	public MapBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MapBean(Map<String, String> mapName) {
		this.mapName = mapName;
	}

	public Map<String, String> getMapName() {
		return mapName;
	}

	public void setMapName(Map<String, String> mapName) {
		this.mapName = mapName;
	}
	
	
}
