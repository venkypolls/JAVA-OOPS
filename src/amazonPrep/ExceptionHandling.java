package amazonPrep;

import java.io.*;

public class ExceptionHandling {

	public static void main(String[] args) throws Exception{
		String strLine = "";
		InputStreamReader isr = null;
		int i,j;
		i =9;
		j =0;
//		try {
//			isr = new InputStreamReader(System.in);
//	        BufferedReader br = new BufferedReader(isr);
//	        String line = "";
//	        while ((line = br.readLine()) != null && !line.equals("exit") ) {
//	            strLine += line + "~";
//	            System.out.println(strLine);
//	        }
//	        br.close();
	        
	        
//		}catch(IOException e) {
//			e.printStackTrace();
//			System.out.println("exception in IO");
//		}finally {
//			isr.close();
//		}
		try {
			int k = i/j;
			if(k==0)
				throw new TestException("not possible");
	        System.out.println(k);
	    }catch(TestException e) {
	    	e.getMessage();
	    }
		
	}

}
