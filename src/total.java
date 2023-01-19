import java.io.*;

public class total {
	public static void main(String args[]) {
		final String FILE = "txt_file/지학사 5과_영어 본문.txt";
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
				bw = new BufferedWriter(new FileWriter(new File("지학사 5과_total.txt")));
				bw2 = new BufferedWriter(new FileWriter(new File("지학사 5과_total_답지.txt")));
				
				bw.write("7번. 주어진 글 다음에 이어질 글의 순서로 가장 적절한 것을 고르시오.\n");
				bw.write("[ 문단 순서 변형 문제 ]\r\n");
				bw.write("=============================================================\n");
				
				String ex[] = paragraph[0].split("\\."); //문단 끝이 .이 아닌 !나 ?로 끝나는 경우 추가
				ex = paragraph[0].split("\\?");
				bw.write(ex[ex.length-1] + ".\n");
				
				bw.write("=============================================================\n\n");

				int[] num = new int[3];
				for(int i=0; i<num.length; i++) {
					num[i] = (int)(Math.random()*3)+1;
					
//					if(num[0] == 1 && num[1] == 2 && num[2] ==3) {
//						num[i] = (int)(Math.random()*3)+1;						
//					}
					
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
				
				if(num[0] == 1 && num[1] == 3 && num[2] == 2)
					bw2.write("7번. 1\r\n");
				if(num[0] == 2 && num[1] == 1 && num[2] == 3)
					bw2.write("7번. 2\r\n");
				if(num[0] == 2 && num[1] == 3 && num[2] == 1)
					bw2.write("7번. 4\r\n");
				if(num[0] == 3 && num[1] == 1 && num[2] == 2)
					bw2.write("7번. 3\r\n");
				if(num[0] == 3 && num[1] == 2 && num[2] == 1)
					bw2.write("7번. 5\r\n");
				
				bw.write("\r\n\r\n8번. 다음 두 보기 중 올바른 것을 선택해 표시하시오.\n");
				bw.write("[ '관사' 어법 변형 문제 ]\r\n");
				bw2.write("8번. ");
				
				int[] num1 = new int[(int)paragraph.length];
				for(int i=0; i<num1.length; i++) {
					num1[i] = (int)(Math.random()*(int)paragraph.length)+1;
					
					for(int j=0; j<i; j++) {
						if(num1[i] == num1[j]) {
							i--;
							break;
						}
					}
				}
				
				paragraph[num1[0]] = paragraph[num1[0]].replaceAll(" an ", " (a/an) ");
				paragraph[num1[0]] = paragraph[num1[0]].replaceAll(" a ", " (a/an) ");
				paragraph[num1[0]] = paragraph[num1[0]].replaceAll("A ", "(A/An) "); 
				paragraph[num1[0]] = paragraph[num1[0]].replaceAll("An ", "(A/An) "); 
				bw.write(paragraph[num1[0]] + "\r\n");
				
				paragraph2[num1[0]] = paragraph2[num1[0]].replaceAll(" an ", " (an) ");
				paragraph2[num1[0]] = paragraph2[num1[0]].replaceAll(" a ", " (a) ");
				paragraph2[num1[0]] = paragraph2[num1[0]].replaceAll("A ", "(A) "); 
				paragraph2[num1[0]] = paragraph2[num1[0]].replaceAll("An ", "(An) "); 
				bw2.write(paragraph2[num1[0]] + "\r\n");
				
				bw.write("\r\n9번. 다음 두 보기 중 올바른 것을 선택해 표시하시오.\n");
				bw.write("[ '관사' 어법 변형 문제 ]\r\n");
				bw2.write("\r\n9번. ");
				
				int[] num2 = new int[(int)paragraph.length];
				for(int i=0; i<num2.length; i++) {
					num2[i] = (int)(Math.random()*(int)paragraph.length)+1;
					
//					if(num2[i] == num1[i]) {
//						i--;
//						break;
//					}
					
					for(int j=0; j<i; j++) {
						if(num2[i] == num2[j]) {
							i--;
							break;
						}
					}
				}
				
				paragraph[num2[0]] = paragraph[num2[0]].replaceAll(" an ", " (a/an) ");
				paragraph[num2[0]] = paragraph[num2[0]].replaceAll(" a ", " (a/an) ");
				paragraph[num2[0]] = paragraph[num2[0]].replaceAll("A ", "(A/An) "); 
				paragraph[num2[0]] = paragraph[num2[0]].replaceAll("An ", "(A/An) "); 
				bw.write(paragraph[num2[0]] + "\r\n");
				
				paragraph2[num2[0]] = paragraph2[num2[0]].replaceAll(" an ", " (an) ");
				paragraph2[num2[0]] = paragraph2[num2[0]].replaceAll(" a ", " (a) ");
				paragraph2[num2[0]] = paragraph2[num2[0]].replaceAll("A ", "(A) "); 
				paragraph2[num2[0]] = paragraph2[num2[0]].replaceAll("An ", "(An) "); 
				bw2.write(paragraph2[num2[0]] + "\r\n");
				
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
