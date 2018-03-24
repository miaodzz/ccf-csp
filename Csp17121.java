import java.util.*;
public class Csp17121 {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] num=new int[n];
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			num[i]=sc.nextInt();
			for(int j=0;j<i;j++){
				if(ans>Math.abs(num[i]-num[j])){
					ans=Math.abs(num[i]-num[j]);
				}
			}
		}
		System.out.println(ans);
	}
}
