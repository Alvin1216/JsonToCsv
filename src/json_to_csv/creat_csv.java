package json_to_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.*;
public class creat_csv {
	public ArrayList<Datalist> EveryLocationWithDistanceOfGatway=new ArrayList<Datalist>();
	public ArrayList<Data> EveryLocationWithData=new ArrayList<Data>();
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String FILE_HEADER = "power,sf,distance,rssi,snr";
	
	public creat_csv(ArrayList<Datalist> a) {
		EveryLocationWithDistanceOfGatway=a;
	}
	public void input_data() {
		String location_1="00800000a00006d4";
		String location_2="00800000a0000a1c";
		String location_3="00800000a0000ed1";
		int power,sf,count,rssi,gt_num,loc;
		double snr;
		String gt;
		
		for(int i=0;i<EveryLocationWithDistanceOfGatway.size();i++) {
		//for(int i=0;i<1;i++) {
			if(i==22 || i==27 || i==45 || i==62 ||i==56||i==55)continue;
			//System.out.println(i);
			//String filename="C:\\\\Users\\\\Aaron\\\\Desktop\\\\testData\\\\testData\\\\";
			String filename="C:\\Users\\user\\Desktop\\testData\\testData\\";
			filename=filename+String.valueOf(EveryLocationWithDistanceOfGatway.get(i).location);
			File f=new File(filename);
			File[] f1=f.listFiles();
			//System.out.println(filename);
			for(int j=0;j<f.listFiles().length;j++) {
				String filename2="";
				filename2=filename;
				String[] tokens = f1[j].getName().split("_|\\.");
				power=Integer.parseInt(tokens[3]);
				sf=Integer.parseInt(tokens[4]);
				count=Integer.parseInt(tokens[5]);
				
				filename2=filename2+"\\";
				filename2=filename2+f1[j].getName();
				FileReader fr=null;
				try {
					fr = new FileReader(filename2);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			     BufferedReader br = new BufferedReader(fr);
			     String line;
			     String tempstring="";
			     String[] tempArray= new String[3];
			     ArrayList myList = new ArrayList();
			      try {
					while((line = br.readLine())!=null)
					   {
					    	tempstring= line;
					    }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      //System.out.println(tempstring);
			      JSONObject json_ob=null;
			      json_ob = new JSONObject(tempstring);
			      //Object s=json_ob.getJSONObject("rx_rssi")
			      //JSONObject location = json_ob.getJSONObject("rx_rssi");
			      //System.out.println();
			      rssi=json_ob.getInt("rx_rssi");
			      snr=json_ob.getDouble("rx_loRaSNR");
			      gt=json_ob.getString("gateway");
			      //loc=json_ob.getInt("location");
			      if(gt.equals(location_1))gt_num=1;
			      else if(gt.equals(location_2))gt_num=2;
			      else gt_num=3;
			      EveryLocationWithData.add(new Data(EveryLocationWithDistanceOfGatway.get(i).location,rssi,snr,power,sf,count,gt_num,gt,i));
			      /*System.out.println(EveryLocationWithData.get(EveryLocationWithData.size()-1).location+":"
			  	    	+EveryLocationWithData.get(EveryLocationWithData.size()-1).RSSI+","+EveryLocationWithData.get(EveryLocationWithData.size()-1).SNR+","
			  	    	+EveryLocationWithData.get(EveryLocationWithData.size()-1).power+","+EveryLocationWithData.get(EveryLocationWithData.size()-1).sf+","
			  	    	+EveryLocationWithData.get(EveryLocationWithData.size()-1).gt_number);*/
			      
			}
			 
		}
		
		
	}

	public void csv_array(){
		double[][][] rssi=new double[21][21][1000];
		double[][][] snr=new double[21][21][1000];
		int[][][] rssi_count=new int[21][21][1000];
		int[][][] snr_count=new int[21][21][1000];
		//sf=7 8 9 10
		for(int i=0;i<21;i++){
			for(int j=0;j<21;j++){
				for(int t=0;t<1000;t++){
				}
			}
		}
		
		for(int p=0;p<EveryLocationWithData.size();p++) {
			Data temp=EveryLocationWithData.get(p);
			int distance=EveryLocationWithDistanceOfGatway.get(temp.index).get_distance(temp.gt_number);
			rssi[temp.power][temp.sf][distance]=rssi[temp.power][temp.sf][distance]+temp.RSSI;
			snr[temp.power][temp.sf][distance]=snr[temp.power][temp.sf][distance]+temp.SNR;
			rssi_count[temp.power][temp.sf][distance]++;
			snr_count[temp.power][temp.sf][distance]++;
		}
		FileWriter fileWriter=null;
		try {
			fileWriter = new FileWriter("rssi.csv");
			StringBuilder sb = new StringBuilder();
			PrintWriter pw = new PrintWriter(new File("only_SNR_double.csv"));
			//sb.append(FILE_HEADER.toString());
			//sb.append(NEW_LINE_SEPARATOR);
			//Write the CSV file header;
			fileWriter.append(FILE_HEADER.toString());
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			int flag=0;
			
			/*for(int p=1;p<=20;p++){
				for(int j=7;j<=10;j++) {
					sb.append(String.valueOf(p)+"_"+String.valueOf(j));
					sb.append(NEW_LINE_SEPARATOR);
				}
			}*/
			
			
			for(int i=0;i<21;i++){
				for(int j=0;j<21;j++){
					for(int t=0;t<1000;t++){
						if(rssi[i][j][t]!=0&&snr[i][j][t]!=0) {
							flag++;
							rssi[i][j][t]=(rssi[i][j][t]/rssi_count[i][j][t]);
							//System.out.println("rssi[i][j][t]"+i+" "+j+" "+t+" "+rssi[i][j][t]);
							snr[i][j][t]=(snr[i][j][t]/snr_count[i][j][t]);
							//System.out.println("snr[i][j][t]"+i+" "+j+" "+t+" "+snr[i][j][t]);
							//sb.append(String.valueOf(i));
							//sb.append(COMMA_DELIMITER);
							//sb.append(String.valueOf(j));
							//sb.append(COMMA_DELIMITER);
							//sb.append(String.valueOf(t));
							//sb.append(COMMA_DELIMITER);
							//sb.append(String.valueOf(rssi[i][j][t]));
							//sb.append(COMMA_DELIMITER);
							sb.append(String.valueOf(snr[i][j][t]));
							sb.append(COMMA_DELIMITER);
						}
					}
					if(flag!=0)sb.append(NEW_LINE_SEPARATOR);
					flag=0;
				}
			}
			 pw.write(sb.toString());
		     pw.close();
			System.out.println("CSV file was created successfully !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*		for(int i=0;i<21;i++){
			for(int j=0;j<21;j++){
				for(int t=0;t<1000;t++){
					if(rssi[i][j][t]!=0) {
						rssi[i][j][t]=(int)(rssi[i][j][t]/rssi_count[i][j][t]);
						System.out.println("rssi[i][j][t]"+i+" "+j+" "+t+" "+rssi[i][j][t]);
						snr[i][j][t]=(int)(snr[i][j][t]/snr_count[i][j][t]);
						System.out.println("snr[i][j][t]"+i+" "+j+" "+t+" "+snr[i][j][t]);
					}
				}
			}
		}*/
	}
}
