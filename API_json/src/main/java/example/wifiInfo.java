package example;

public class wifiInfo {
	private String dist;
	private String number;
	private String sigu;
	private String mainADD;
	private String add1;
	private String add2;
	private String floor;
	private String type;
	private String inst;
	private String service;
	private String cmcwr;
	private int year;
	private String inout;
	private String environment; 
	private double lat;
	private double lnt;
	private String day;
	
	// 히스토리 사용
	private String time;
	private String num;
	private double X좌표;
	private double Y좌표;
	
	//히스토리 사용
	public wifiInfo(String num, double X좌표, double Y좌표, String time) {
		super();
		this.num = num;
		this.X좌표 = X좌표;
		this.Y좌표 = Y좌표;
		this.time = time;
	}
	

	//DB 업데이트 시 사용
	public wifiInfo(String number, String sigu, String mainADD, String add1, String add2, String floor, String type,
			String inst, String service, String cmcwr, int year, String inout, String environment, double lat,
			double lnt, String day) {
		super();
		this.number = number;
		this.sigu = sigu;
		this.mainADD = mainADD;
		this.add1 = add1;
		this.add2 = add2;
		this.floor = floor;
		this.type = type;
		this.inst = inst;
		this.service = service;
		this.cmcwr = cmcwr;
		this.year = year;
		this.inout = inout;
		this.environment = environment;
		this.lat = lat;
		this.lnt = lnt;
		this.day = day;
	}
	
	// 20개 불러올 때 사용
	public wifiInfo(String dist, String number, String sigu, String mainADD, String add1, String add2, String floor, String type,
			String inst, String service, String cmcwr, int year, String inout, String environment, double lat,
			double lnt, String day) {
		super();
		this.dist = dist;
		this.number = number;
		this.sigu = sigu;
		this.mainADD = mainADD;
		this.add1 = add1;
		this.add2 = add2;
		this.floor = floor;
		this.type = type;
		this.inst = inst;
		this.service = service;
		this.cmcwr = cmcwr;
		this.year = year;
		this.inout = inout;
		this.environment = environment;
		this.lat = lat;
		this.lnt = lnt;
		this.day = day;
	}


	public wifiInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getSigu() {
		return sigu;
	}


	public void setSigu(String sigu) {
		this.sigu = sigu;
	}


	public String getMainADD() {
		return mainADD;
	}


	public void setMainADD(String mainADD) {
		this.mainADD = mainADD;
	}


	public String getAdd1() {
		return add1;
	}


	public void setAdd1(String add1) {
		this.add1 = add1;
	}


	public String getAdd2() {
		return add2;
	}


	public void setAdd2(String add2) {
		this.add2 = add2;
	}


	public String getFloor() {
		return floor;
	}


	public void setFloor(String floor) {
		this.floor = floor;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getInst() {
		return inst;
	}


	public void setInst(String inst) {
		this.inst = inst;
	}


	public String getService() {
		return service;
	}


	public void setService(String service) {
		this.service = service;
	}


	public String getCmcwr() {
		return cmcwr;
	}


	public void setCmcwr(String cmcwr) {
		this.cmcwr = cmcwr;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getInout() {
		return inout;
	}


	public void setInout(String inout) {
		this.inout = inout;
	}


	public String getEnvironment() {
		return environment;
	}


	public void setEnvironment(String environment) {
		this.environment = environment;
	}


	public double getLat() {
		return lat;
	}


	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getLnt() {
		return lnt;
	}


	public void setLnt(double lnt) {
		this.lnt = lnt;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getDist() {
		return dist;
	}


	public void setDist(String dist) {
		this.dist = dist;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public double getX좌표() {
		return X좌표;
	}


	public void setX좌표(double x좌표) {
		X좌표 = x좌표;
	}


	public double getY좌표() {
		return Y좌표;
	}


	public void setY좌표(double y좌표) {
		Y좌표 = y좌표;
	}

}
