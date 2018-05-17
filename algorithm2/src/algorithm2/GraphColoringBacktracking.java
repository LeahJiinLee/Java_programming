package algorithm2;

import java.util.Scanner;

public class GraphColoringBacktracking {
	Scanner scanner = new Scanner(System.in);
	int n;//노드 개수
	int G[][] ;	
	int m;//색깔 개수
	int s[];
	int x[];//solution
	int r[];//X[k]에 assign된 ai의 i 모아둠
	int k;//노드의 갯수만큼
	int c=-1;//컬러 가리킴 1~m
	double count=1;//root포함
	double num_nodes=0;
void read() {
	n = scanner.nextInt();
	G = new int [n][n];
    for (int i=0; i<G.length; i++) {
    	  for (int j=0; j<G[i].length;j++)
    		  G[i][j]= scanner.nextInt();
    }
    m= scanner.nextInt();
    x= new int [n];
    s = new int [m];
    r= new int[n];
    for (int i=0; i<m; i++)
    	s[i]=i+1;// s={1,2,3,4,,, m}
    num_nodes=((int)Math.pow(m,n+1))-1/m-1;
  
}
	

 public void colorGraph(int n) {
	 k=0;
	    for (int i=0; i<n; i++) {
	    	
	    	x[i]=0;//a0,c=0 초기화
	    	r[i]=-1;
	    }
	 while (0<=k && k<n) {//0~n-1
		 
		 getNext(k);
		 if (x[k]==0)
		  k--;
		
		 else
			 if (k==n-1) {
				 
			  for (int q : x)
 					System.out.print(q+" ");
			  System.out.println();
			
			 }
			 else k++;
	 }
	
	 System.out.print((int)count+",");
		System.out.print((int)num_nodes+",");
		System.out.print(count/num_nodes*100 + "%");
    }
 void getNext(int k) {
	 while (r[k]<m-1) {
		 r[k]++;
		 x[k]= s[r[k]];//
		++count;
		 if ((bound (k))==true) { 
			 return;
		 }
	 }
	 if (r[k]==m-1) {
		 r[k]=-1;
		 x[k]=0;
		
	 }
		 
 }
 public boolean bound(int k) {
	 for (int i=0; i<k; i++) {
		 if (x[k]==x[i] && G[k][i]==1)
			 return false;
	 }
		 
	 return true;
 }
 void run () {
	read();
	
	colorGraph(n);
	
 }
public static void main(String[] args) {
	// TODO Auto-generated method stub	
	GraphColoringBacktracking coloring = new GraphColoringBacktracking();
	coloring.run();
	
}

}
