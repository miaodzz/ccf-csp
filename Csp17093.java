import java.util.*;
public class Csp17093 {
	public static void main(String[] args){
		//string \\ 和 \"
		//object {:,:}
		int n;//行
		int m;//查询数
		
		Scanner sc=new Scanner(System.in);
		String temp[]=sc.nextLine().toString().split(" ");
		n=Integer.valueOf(temp[0]);
		m=Integer.valueOf(temp[1]);
		
		StringBuilder allstr=new StringBuilder("");
		String[] query=new String[m];
		
		int i=0;
		while(i++<n){
			allstr.append(sc.nextLine());
		}
		i=0;
		while(i<m){
			query[i++]=sc.nextLine();
		}
		
		String longstr=allstr.toString().replaceAll(" ","");
		
		
	}
	
	
	public static Map solve1(String line){//把一个对象分成 String key-String value
		String[] temp=line.split(",");
		for(String t:temp){
			
		}
		return null;
		
	}
}
