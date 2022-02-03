import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	private static String a=null;
	private static String b=null;
	private static int diff[];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		a=sc.next();
		b=sc.next();
		
		int lenA=a.length();
		int lenB=b.length();
		diff=new int[lenB-lenA+1];
		for(int start=0;start<=lenB-lenA;start++) {
			int idx=0;
			for(int i=start;i<start+lenA;i++) {
				if(a.charAt(idx++)!=b.charAt(i)) diff[start]++;
			}
		}
		Arrays.sort(diff);
		System.out.println(diff[0]);
	}

}
