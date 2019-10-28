import java.util.Arrays;

public class Main {
	
	//Divide
	public static void mergeSort(int ar[], int n) {
		//1� Step
		//In base ai principi del Merge Sort se la lunghezza del vettore � >= 1 l'array � gi� ordinato
		if(n < 2)
			return;
		
		//2� Step
		//Identificati attori dell'algoritmo
		//Mid � la lunghezza media del vettore
		//l[] � il vettore di sinistra che dovr� essere scomposto a sua volta
		//r[] � il vettore di destra che dovr� essere scomposto a sua volta
		int mid = n / 2;
		int l[] = new int[mid];
		int r[] = new int[n - mid];
		
		//Passo i valori all'interno di l
		for(int i = 0; i < mid; i++) 
			l[i] = ar[i];
		
		//Passo i valori all'interno di r
		for(int i = mid; i < n; i++) 
			r[i - mid] = ar[i];
		
		//3� Step
		//Ordino i due sub-arrays
		mergeSort(l, mid);
		mergeSort(r, n - mid);
		
		//4� step
		//Eseguo il merge dei due sub-arrays
		merge(ar, l, r, mid, n - mid);
	}
	
	//Impera
	public static void merge(int ar[], int l[], int r[], int left, int right) {
		int i = 0, k = 0, j = 0;
		
		while(i < left && j < right) {
			if(l[i] <= r[j])
				ar[k++] = l[i++];
			else
				ar[k++] = r[j++];
		}
		
		while(i < left) {
			ar[k++] = l[i++];
		}
		while(j < right) {
			ar[k++] = r[j++];
		}
	}
	
	public static void main(String []args) {
		System.out.println("Merge Sort");
		int ar[] = {3,6,19,4,5,0,8,2};
		mergeSort(ar, ar.length);
		System.out.println(Arrays.toString(ar));
	}
	
}
