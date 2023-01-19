import java.io.*;

public class part05 {
	public static void main(String args[]) {
		final String FILE = "txt_file/비상영어 4과_영어 본문.txt";
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
			BufferedWriter bw;
			BufferedWriter bw2;
				
			try {
				bw = new BufferedWriter(new FileWriter(new File("final/visang/비상영어 4과_문단순서.txt")));
				bw.write("[ 문단 순서 변형 문제 ]\n\n");
				bw.write("Q. 주어진 글 다음에 이어질 글의 순서로 가장 적절한 것을 고르시오.\n");
				bw.write("=============================================================================\n");
				
				String ex[] = paragraph[0].split("\\."); //문단 끝이 .이 아닌 !나 ?로 끝나는 경우 추가
				bw.write(ex[ex.length-1] + ".\n");
				
				bw.write("=============================================================================\n\n");

				int[] num = new int[3];
				for(int i=0; i<num.length; i++) {
					num[i] = (int)(Math.random()*3)+1;
					
					for(int j=0; j<i; j++) {
						if(num[i] == num[j]) {
							i--;
							break;
						}
					}
				}
				
				bw.write("(A)\n" + paragraph[num[0]]);
				bw.write("\r\n\r\n");
				
				bw.write("(B)\n" + paragraph[num[1]]);
				bw.write("\r\n\r\n");
				
				bw.write("(C)\n" + paragraph[num[2]]);
				bw.write("\r\n\r\n");
				
				bw.write("1.(A)-(C)-(B)\t2.(B)-(A)-(C)\t3.(B)-(C)-(A)\n4.(C)-(A)-(B)\t5.(C)-(B)-(A)");
				bw.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
