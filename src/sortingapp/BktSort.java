package sortingapp;



// Java program to sort an array 
// using bucket sort 
import java.util.*; 
import java.util.Collections; 

class BktSort { 

	// Function to sort arr[] of size n 
	// using bucket sort 
	static void bucketSort(float arr[], int n) 
	{ 
		if (n <= 0) 
			return; 

		// 1) Create n empty buckets 
		@SuppressWarnings("unchecked")
		Vector<Float>[] buckets = new Vector[n]; 

		for (int i = 0; i < n; i++) { 
			buckets[i] = new Vector<Float>(); 
		} 

		// 2) Put array elements in different buckets 
		for (int i = 0; i < n; i++) { 
			float idx = arr[i] * n; 
			buckets[(int)idx].add(arr[i]); 
		} 

		// 3) Sort individual buckets 
		for (int i = 0; i < n; i++) { 
			Collections.sort(buckets[i]); 
		} 

		// 4) Concatenate all buckets into arr[] 
		int index = 0; 
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < buckets[i].size(); j++) { 
				arr[index++] = buckets[i].get(j); 
			} 
		} 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		float arr[] = { 
			(float)0.897, (float)0.565, 
			(float)0.656, (float)0.1234, 
			(float)0.665, (float)0.3434,
			(float)0.2434,(float)0.1131,
			(float)0.3434,(float)0.3090,
			(float)0.1212,(float)0.2354,
			(float)0.2521,(float)0.7030,
			(float)0.1109,(float)0.5531,
		};

		System.out.println("UnSorted  array is "); 
		System.out.print("[");
		for (float el : arr) { 
			System.out.print(el + ", "); 
		} 
		System.out.print("]");

				

		int n = arr.length; 
		bucketSort(arr, n); 

		System.out.println("Sorted array is "); 
		System.out.print("[");
		for (float el : arr) { 
			System.out.print(el + ", "); 
		} 
		System.out.print("]");

	} 
} 

