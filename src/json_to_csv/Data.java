package json_to_csv;

public class Data {
	int location;
	int RSSI;
	double SNR;
	int power;
	int sf;
	int count;
	int gt_number;
	int index;
	String gateway;
	
	public Data(int loc,int rssi,double snr,int pow,int s,int cot,int gn,String gt,int ind) {
		location=loc;
	    RSSI=rssi;
		SNR=snr;
		power=pow;
		sf=s;
		count=cot;
		gt_number=gn;
		gateway=gt;
		index=ind;
	}
	
}
