package algorithm;
import java.util.*;
public class FloydAlgorithm {
	Scanner scanner = new Scanner(System.in);
	int n;
	int D[][] ;		
	int P[][];
	int s,d;
	
	private void read() {
		int q=0;
		String nodes = scanner.next();
		StringTokenizer st1 = new StringTokenizer(nodes, ", ");
		n = Integer.parseInt(st1.nextToken()); 		
		D =new int[n][n];
		P  = new int [n][n];
		String w = scanner.nextLine();
		
		StringTokenizer st2 = new StringTokenizer(w, ",\" ");
		int p = st2.countTokens();
		
		int A[] = new int [p];
		for (int i=0; i<A.length; i++)
		{ A[i]=Integer.parseInt(st2.nextToken());}
		
		
		for (int i=0; i<D.length; i++)
			for (int j=0; j<D[i].length; j++)
				{P[i][j]=0;
				D[i][j]= A[q];
				q++;
				}
		s =A[q];
		q++;
		d = A[q];
		
	}
	private void search() {
		for (int k=0; k<n; k++)
			for (int i=0; i<n; i++)
				for (int j=0; j<n; j++)
					{
					if (D[i][k]!=-1 && D[k][j]!=-1)
					
					  {int x= D[i][k]+D[k][j];
					   if (D[i][j]==-1 && x>D[i][j])
						{D[i][j]= x;
					     P[i][j]=k+1;}
					else if (D[i][j]!=-1 && x<D[i][j])
						{
						D[i][j] =x;
						P[i][j]=k+1;
						}
					  }
					}
	}
	private void print() {
		System.out.println("D");
		for (int i=0; i<D.length; i++) {
			for (int j=0; j< D[i].length; j++)
				System.out.print(D[i][j]+ " ");
		System.out.println();
		}
		System.out.println("P");
		for (int i=0; i<D.length; i++) {
			for (int j=0; j< P[i].length; j++)
				System.out.print(P[i][j]+ " ");
		System.out.println();
		}
		System.out.print(s);
		path(s,d);
		System.out.print(d);
	}
						
	private void path(int q, int r) {
		if (P[q-1][r-1]==0) 
		{System.out.print("->");
		
		}
		else
		{
			path(q, P[q-1][r-1]);
			System.out.print(P[q-1][r-1]);
			path(P[q-1][r-1],r);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FloydAlgorithm shortest = new FloydAlgorithm();
		shortest.read();
		shortest.search();
		shortest.print();
				
											
	}

}
