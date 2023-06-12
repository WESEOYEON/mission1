package example;

public class bookmarkInfo {
	String name;
	int number;
	String regiDate;
	String editDate;
	int idx;
	String wifiName;
	String regiwifiDate;
	String wifiNumber;
	
	public bookmarkInfo() {
		
	}
	
	public bookmarkInfo(String name, int number, String regiDate, String editDate, int idx, String wifiName, String regiwifiDate, String wifiNumber) {
		super();
		this.name = name;
		this.number = number;
		this.regiDate = regiDate;
		this.editDate = editDate;
		this.idx = idx;
		this.wifiName = wifiName;
		this.regiwifiDate = regiwifiDate;
		this.wifiNumber = wifiNumber;
	}

	public bookmarkInfo(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(String regiDate) {
		this.regiDate = regiDate;
	}

	public String getEditDate() {
		return editDate;
	}

	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public String getWifiName() {
		return wifiName;
	}

	public void setWifiName(String wifiName) {
		this.wifiName = wifiName;
	}
	
	public String getRegiwifiDate() {
		return regiwifiDate;
	}

	public void setRegiwifiDate(String regiwifiDate) {
		this.regiwifiDate = regiwifiDate;
	}
	
	public String getWifiNumber() {
		return wifiNumber;
	}

	public void setWifiNumber(String wifiNumber) {
		this.wifiNumber = wifiNumber;
	}
}
