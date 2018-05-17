package algorithm2;

import java.util.Scanner;

public class HamiltonianCycle {
	Scanner scanner = new Scanner(System.in);
	int n;//노드 개수
	int G[][] ;	
	int s[];//
	int x[];//solution
	int r[];//X[k]에 assign된 ai의 i 모아둠
	int k;//노드의 갯수만큼
	
void read() {
	n = scanner.nextInt();
	G = new int [n][n];
    for (int i=0; i<G.length; i++) {
    	  for (int j=0; j<G[i].length;j++)
    		  G[i][j]= scanner.nextInt();
    }
 
    x= new int [n];
    s = new int [n];
    r= new int[n];//x[0]~x[n-1]에 assign된s[0]~s[n-1]중의 벨류의인덱스 
    for (int i=0; i<n; i++)
    	s[i]=i+1;
   
    
}
	

 public void hamiltonian(int n) {
	 k=1;
	 x[0]=1; r[0]=0;
	
	    for (int i=1; i<n; i++) {
	    	
	    	x[i]=0;//아직 솔루션 없어서 0
	    	r[i]=-1;
	    }
	 while (1<=k && k<n) {
		 getNext(k);
		 if (x[k]==0 ) {
			 k--;}
		 else
			 if (k==n-1) {
				 
				if ( G[x[n-1]-1][0]==1)
				{ for (int q : x)
 					System.out.print(q+"-" );
 					System.out.print(x[0]);
			  System.out.println();
			  return;
			  }
			  
			 }
			 
			 else k++;
	 }System.out.print("There is no HC");
	 return;
    
    }
 void getNext(int k) {
	while(r[k]<n-1) { 
		if (r[k]==-1) 
		  {r[k]=0;}
		 r[k]++;//S[0]=1인데 이거 건너뛰어야함
		 x[k]= s[r[k]];
		
		 if ((bound (k))==true) { 
			 return;
		 }
	 }
	 if (r[k]==n-1) {
		 r[k]=-1;
		 x[k]=0;
		
	 }
		 
 }
 public boolean bound(int k) {
	
	 for (int i=0; i<k; i++) 
	 { if (x[k]==x[i])
			 return false;}
     if(G[x[k]-1][x[k-1]-1]==1)//이제까지 나타난거 없고 자기 직전 노드와 연결되어있다면
			 return true;
	 else
			 return false;
	
 }
 void run () {
	read();
	
	hamiltonian(n);
	
 }
public static void main(String[] args) {
	// TODO Auto-generated method stub	
	HamiltonianCycle hcycle = new HamiltonianCycle ();
	hcycle.run();
  
}

}
