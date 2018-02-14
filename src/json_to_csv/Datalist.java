package json_to_csv;

public class Datalist {
	int location;
	double lat;
	double lon;
	double location_between_gateway1;
	double location_between_gateway2;
	double location_between_gateway3;
	
	public Datalist(int loca,double lat_in,double lon_in){
		location=loca;
		lat=lat_in;
		lon=lon_in;
	}
	
	public void count_location_bet_gatway(double location_1_lat,double location_1_lon,int gateway) {
		double EARTH_RADIUS = 6378137.0;
		double radLat_g = (location_1_lat * Math.PI / 180.0);
		double radLat_now = (lat * Math.PI / 180.0);
		double a = radLat_g - radLat_now;
		double b = (location_1_lon - lon) * Math.PI / 180.0;
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
		+ Math.cos(radLat_g) * Math.cos(radLat_now)
		* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		if(gateway==1) {
			location_between_gateway1 = Math.round(s * 10000) / 10000;
		}else if(gateway==2) {
			location_between_gateway2 = Math.round(s * 10000) / 10000;
		}else {
			location_between_gateway3 = Math.round(s * 10000) / 10000;
		}
	}
	
	public int get_distance(int gateway) {
		if(gateway==1) {
			return (int)location_between_gateway1;
		}else if(gateway==2) {
			return (int)location_between_gateway2;
		}else {
			return (int)location_between_gateway3;
		}
	}
}
