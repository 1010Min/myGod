import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class part03 {
	public static void main(String args[]) {
		final String FILE = "txt_file/천재영어 2과_영어 본문.txt";
		File file = new File(FILE);
		
		try {
			FileInputStream fileStream = new FileInputStream(file);
			byte[] byteArray = new byte[(int)file.length()];
			
			try {
				fileStream.read(byteArray);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String data = new String(byteArray);
			String[] paragraph = data.toString().split("\r\n\r\n");
			String[] paragraph2 = data.toString().split("\r\n\r\n");
			BufferedWriter bw;
			BufferedWriter bw2;
				
			try {
				bw = new BufferedWriter(new FileWriter(new File("final/chunjae/천재영어 2과_관사.txt")));
				bw2 = new BufferedWriter(new FileWriter(new File("final/chunjae/천재영어 2과_관사_답지.txt")));
				bw.write("[ '관사' 어법 변형 문제 ]\n\n");
				bw.write("3번. 다음 두 보기 중 올바른 관사를 선택해 표시하시오.\n\n");
				bw2.write("[ '관사' 어법 변형 문제 ]\n\n");
				bw2.write("3번. 다음 두 보기 중 올바른 관사를 선택해 표시하시오.\n\n");

				int[] num = new int[(int)paragraph.length];
				for(int i=0; i<num.length; i++) {
					num[i] = (int)(Math.random()*(int)paragraph.length)+1;
					
					for(int j=0; j<i; j++) {
						if(num[i] == num[j]) {
							i--;
							break;
						}
					}
				}
				
					paragraph[num[0]] = paragraph[num[0]].replaceAll(" an ", " (a/an) ");
					paragraph[num[0]] = paragraph[num[0]].replaceAll(" a ", " (a/an) ");
					paragraph[num[0]] = paragraph[num[0]].replaceAll("A ", "(A/An) "); 
					paragraph[num[0]] = paragraph[num[0]].replaceAll("An ", "(A/An) "); 
					bw.write(paragraph[num[0]] + "\r\n");
					bw.flush();
					
					paragraph2[num[0]] = paragraph2[num[0]].replaceAll(" an ", " (an) ");
					paragraph2[num[0]] = paragraph2[num[0]].replaceAll(" a ", " (a) ");
					paragraph2[num[0]] = paragraph2[num[0]].replaceAll("A ", "(A) "); 
					paragraph2[num[0]] = paragraph2[num[0]].replaceAll("An ", "(An) "); 
					bw2.write(paragraph2[num[0]] + "\r\n");
					bw2.flush();
				
				bw.flush();
				bw2.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}

