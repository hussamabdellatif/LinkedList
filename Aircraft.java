
public class Aircraft {

	private int iD;
	private int altitude;
	private int speed;
	private String name;
	
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public int getAltitude() {
		return altitude;
	}
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String finalString (int id, int altitude , int speed, String name){
		
		String finalS = "iD: " +iD +"altitude: "+altitude + "speed: " + speed + "name" +name;
		
		return finalS;
	}

}
