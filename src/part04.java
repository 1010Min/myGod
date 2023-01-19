import java.io.*;
import java.util.Random;

public class part04{
	public static void main(String[] args) {
		final String FILE = "비상영어 4과_영어 본문.txt";
		File file = new File(FILE);
		String b[] = new String[(int)file.length()]; // 본문 문장수에 따른 크기 조정 필요
		String c = "";
		Random random = new Random();
		try {
			int n=0;
			BufferedReader br = new BufferedReader(new FileReader(file));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("test.txt")));
			
			while((c = br.readLine()) != null) {
				b[n] = c;
				n++;
			}
			
			bw.write("[ 문장 순서 변형 문제 ]\n\n");
			
			int ran = random.nextInt(b.length)+1;
			if(ran <2)
				ran = random.nextInt(b.length)+1;
			
			for(int i=0; i<ran; i++)
				bw.write("(" + i + ") " + b[i] + "\r\n");
			for(int i=ran+1; i<b.length; i++) 
				bw.write("(" + (i-1) + ") " + b[i] + "\r\n");
			
			bw.write("\n다음 중 아래의 문장이 들어갈 순서는?\n");
			bw.write("< " + b[ran] + ">" + "\n");
			bw.flush();
			
			System.out.println();
			
			br.close();
		} catch(IOException e) { }
	}
}