import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Csp17122 {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		LinkedList<Integer> list=new LinkedList<Integer>();
		int n=sc.nextInt();
		int k=sc.nextInt();
		for(int i=1;i<=n;i++){
			list.add(i);
		}
		int count=1,num=0;
		Iterator<Integer> it=list.iterator();
		while(list.size()!=1){
			if(!it.hasNext()){
				it=list.iterator();
			}
			it.next();
			if(count%10==k||count%k==0){
				it.remove();
			}
			count++;
		}
		
		System.out.println(list.peek());
	}
}
