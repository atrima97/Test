	package com.cts.h1;
	
	import java.io.*;
	import org.json.simple.*;
	
	public class Memory {
	
		public static void main(String[] args) throws Exception {
			
			String data;
			int line=0,i=1;
			float max=0,sum=0;
			float val2;
			FileReader fr=new FileReader("D:\\Memory.txt");
			BufferedReader br=new BufferedReader(fr);
			JSONObject values=new JSONObject();
			JSONObject total=new JSONObject();
			JSONArray arraytotal=new JSONArray();
			while((data=br.readLine())!=null) {
				line++;
				if((line%2)==0) {
					String[] val1=data.split("\\s+");
					//System.out.println(value[2]);
					
					float val=Float.parseFloat(val1[2]);
					val2=val/1024;
					if(val2>max) {
						max=val2;
					}
					sum=sum+val2;
					String s= i+"s";
	
					values.put(s,(String.format("%.2f",val2)));
					i++;
					}	
			}
			float avg=sum/i;
			total.put("values",values);
			total.put("MaxMemory(MB)",(String.format("%.2f",max)));
			total.put("AverageMemory(MB)",(String.format("%.2f",avg)));
			total.put("Usercasename","HomePage");
			arraytotal.add(total);
			System.out.print(arraytotal);
			FileWriter fw=new FileWriter("UserCase1Output.json");
			fw.write(arraytotal.toJSONString());
			fw.close();
			br.close();
			
		}
	
	}
