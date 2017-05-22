import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Top {

	public static final String specialFlg = " ---- ";
	
	public static void readTop(String filePath,String topPath){
		
		FileWriter fileWriter=null;
		File file=new File(filePath);
		InputStreamReader read=null;
		BufferedReader bufferedReader = null;
		Map<String,Integer> map=new HashMap<String,Integer>();
		//map<key,value>名字是key，value是次数
		
		try{
			
			fileWriter = new FileWriter(new File(topPath), true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		try{	
			
			read=new InputStreamReader(new FileInputStream(file));
			bufferedReader = new BufferedReader(read);
			String lineTxt=null;
			while((lineTxt=bufferedReader.readLine())!=null){
				
				/*
				 <author>Paolo Sipala</author> ---- 161070
				 -->
				 <author,Paolo Sipala</author, ---- 161070
				 	[0]		[1]					[2]
				 -->
				 	Paolo Sipala,/author
				 		[0]			[1]
				*/
				
				
				lineTxt=lineTxt.split(specialFlg)[0];
				
				if(lineTxt.split(">")[0].equals("<author"))
				{
					lineTxt=lineTxt.split(">")[1];
					String temp=lineTxt.split("<")[0];
					if(!map.containsKey(temp))
					{
						map.put(temp, 1);
					}
					else
					{
						int num=map.get(temp);
						map.put(temp, ++num);
					}
					
					//用map<K,V>来储存author，K为名字，V为次数，最后以V来排序
				}
								
			}
			
			
			List<Entry<String,Integer>> list=new
					ArrayList<Entry<String,Integer>>(map.entrySet());
			Collections.sort(list,new Comparator<Map.Entry<String,Integer>>()
					{
				
						public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2)
							{
								return (o2.getValue() - o1.getValue());
								}
					});
			
			//弄一个list的遍历
			int count =0;
			for(Map.Entry<String,Integer> mapping:list){ 
				
				
	            String key = mapping.getKey();  
	  
	            Integer value = mapping.getValue();   
				
				fileWriter.write("["+key+" number is:  "+value+"  ]\n");
				count++;
				if(count>=100)break;
			}
			
			
			
				
			
			
		
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(bufferedReader != null)
					bufferedReader.close();
				if(fileWriter != null)
					fileWriter.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		System.out.println("文件建立完毕！");
	}
	
	public static void main(String[] args){
		readTop("B:\\author.txt", "B:\\result.txt");
	}
}
