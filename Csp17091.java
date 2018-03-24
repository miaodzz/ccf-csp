import java.util.*;
public class Csp17091 {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt()/10;
		int ans=0;
		for(int i=0;i*3<=n;i++){
			for(int j=0;i*3+j*5<=n;j++){
				if(ans<i*4+j*7+(n-i*3-j*5)){
					ans=i*4+j*7+(n-i*3-j*5);
				}
			}
		}
		System.out.println(ans);
	}
	
}
