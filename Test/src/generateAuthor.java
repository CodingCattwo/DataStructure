
/*
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class generateAuthor {
	
	public static final int range = 560;
	public static final String specialFlg = " ---- ";
	
public static void generateBinarySearchDoc(String pathSource, String pathTarget){
		
		RandomAccessFile rafRead = null;
		FileWriter fileWrite = null;
		try {
			rafRead = new RandomAccessFile(pathSource, "r");
			fileWrite = new FileWriter(new File(pathTarget), true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		try{
			String tmp, cntS = "0";
			int cnt = 0;
			while((tmp = rafRead.readLine()) != null){
				if(cnt % range == 0)	//��rangeΪһ�������Ϊһ�飬�������ܹ�10062�飬Ҳ�ʹ�ȷ��TitleNode����Ҫ������ռ��С
					fileWrite.write(tmp.trim().split(specialFlg)[0] + specialFlg + cntS + "\n");
				cnt++;
				cntS = String.valueOf(rafRead.getFilePointer());
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(rafRead != null)
					rafRead.close();
				if(fileWrite != null)
					fileWrite.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		System.out.println("�����ļ�������ϣ�");
	}

	public static void main(String[] args){
		generateBinarySearchDoc("B:\\dblp.xml", "B:\\author.txt");
	}

}

*/