package source;

public class Player {
	private String marker;
	private String type;

	public Player(String marker, String type) {
		this.setMarker(marker);
		this.setType(type);
	}
	
	public boolean isHuman(){
		return this.type.equals("human");
	}
	
	public boolean isComputer(){
		return this.type.equals("computer");
	}

	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
