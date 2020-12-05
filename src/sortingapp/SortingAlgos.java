package sortingapp;

import java.util.Collections;
import java.util.*;

public class SortingAlgos 
{
    private int bSwap;
    private int bComp;
    private int sSwap;
    private int sComp;
    private int iComp;
    private int iSwap;
    void SortingAlgos()
    {
        bSwap = 0;
        bComp = 0;
        sComp = 0;
        sSwap = 0;
        iComp = 0;
        iSwap = 0;

    }
    
    public void BubbleSort(int bList[])
    {
        
        //Implement Bubble Sort Algorithm Here
        int n = bList.length; 
        long start = System.currentTimeMillis();
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                bComp++;
                if (bList[j] > bList[j+1]) 
                { 
                    // swap bList[j+1] and bList[j] 
                    bSwap++;
                    int temp = bList[j]; 
                    bList[j] = bList[j+1]; 
                    bList[j+1] = temp; 
                }
            }
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        
        System.out.println("Running duration for BBL sort " + duration);
    } 
    
    
    
    public void BucketSort(float [] arr, int n){
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
    
    }
    
    
    public void SelectionSort(int sList[]){
        
        int min,temp;
        int size = sList.length;
        long start = System.currentTimeMillis();
        for ( int outer = 0;outer < size;outer++ ){
            min = outer;
            for (int inner = outer + 1;inner < size; inner ++){
                sComp ++;
                if (sList[inner] < sList[min]){
                    min = inner;
                }
            }
            if (sList[min] != sList[outer]){
                sSwap++;
                temp = sList[min];
                sList[min] = sList[outer];
                sList[outer] = temp;
            }
            
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Total Duration : " + duration);
    }



    public void InsertionSort(int[] iList){
        long start = System.currentTimeMillis();
        for (int i = 1;i < iList.length;i++){
            int j = i;
            while (j > 0 && iList[j] < iList[j -1]){
                bSwap ++;
                bComp++;
                int temp = iList[j - 1];
                iList[j-1] = iList[j];
                iList[j] = temp;
                j--;
            }
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Total Running Duration" + duration);
    }


    public void mergeSort(int arr[], int left, int right){

        // checks if right index is less than left index
        if (left < right){
            // calculate the mid for dividing the array in two
            int mid = (left + right) /2;
            // call two recursive merge sort on the left half and right half

            // this is left half
            mergeSort(arr, left, mid);
            // this is the right half
            mergeSort(arr, mid + 1, right); 
            // merge togather the subarrays into single array while checking them spontaniously
            merge(arr,left,mid,right);
        }
    }

    public void merge(int arr[], int left,int mid, int right){

        // Here we'll calculate the array sizes that and then make temorary arrays to store their values and put them 
        // in their respective arrays and start comparing each element and then change them in the orignal array as well
        // this way we get a sorted array

        // calculate the array1 size
        int arr1size = mid - left + 1;
        // calculate the array2 size
        int arr2size = right - mid;

        // create two empty arrays of the size of each sub array sothat we
        // dont have to mess arround with the orignal array 
        int [] tempArr1 = new int [arr1size];
        int [] tempArr2 = new int [arr2size];

        // now put each subarray elements in the respective temporary arrays

        // for subarray1
        for (int i = 0; i < arr1size;i++){
            tempArr1[i] = arr[left + i];
        }
        
        // for subarray2
        for (int i = 0; i < arr2size;i++){
            tempArr2[i] = arr[mid + 1 + i];
        }

        // initialize i and j to be used while comparing and swapping values of the subarrays
        int i =0 , j = 0;

        // initialize k for swapping the values of the main array 
        int k = left;


        // here the actaul swapping occurs well check each element againsts the other elements in the other subarray ( not clear to me as well yet)
        // dry run to understand
        while ( i < arr1size && j < arr2size){

            if (tempArr1[i] <= tempArr2[j]){
                arr[k]  = tempArr1[i];
                i ++;
            }
            else{
                arr[k] = tempArr2[j];
                j ++;
            }
            k ++;
        }
        // inset remaing elements for left array 
        while(i < arr1size){
            arr[k] = tempArr1[i];
            i++;
            k++;
        }
        
        // inset remaing elements for right array 
        while(j < arr2size){
            arr[k] = tempArr2[j];
            j++;
            k++;
        }
    }


    


    public void QuickSort(int[] arr, int low, int high){
        if (low < high){
            int pi = partition(arr,low,high);

            QuickSort(arr, low, pi -1);
            QuickSort(arr, pi + 1, high);

        }
    }
    
int partition(int[] arr,int lb, int ub){
    int pivot = arr[lb];
    int start = lb;
    int end = ub;

    while(start < end){
        while(arr[start] <= pivot){
            start ++;
        }
        while(arr[end] > pivot){
            end --;
        }

        if (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
    int temp = arr[lb];
    arr[lb] = arr[end];
    arr[end] = temp;
    return end;
    

}

//     int partition(int[] arr, int low, int high){
// // [33,42,43,64,5,3,44,53],
// //[33,53,43,64,5,3,44,42]
//         int pivot = arr[high];//53 

//         int i = low -1; //-1 

//         for (int j = low;j <= high - 1;j++){
//             if (arr[j] < pivot){ // 33 < 53 T 
//                 i++; //0
//                 int temp = arr[i]; // 33
//                 arr[i] = arr[j]; // arr[0] = 33
//                 arr[j] = temp; // arr[0] = 53
//             }
//         }
//         int tempOut = arr[high];//53
//         arr[high] = arr[i + 1]; //arr[7] = 42
//         arr[i + 1] = tempOut; // arr[1] = 53

//         return (i + 1); // 1
        
//     }




    public void PrintList(int List[])
    {
        for(int i=0; i<List.length; i++)
        {
            System.out.print(List[i]+" ");
        }
        
    }
    
    public void PrintReport()
    {
        System.out.println("----------------------------------");
        System.out.println("\t Comparison Chart");
        System.out.println("----------------------------------");
        System.out.println("Bubble Sort Comparisons       : "+bComp);
        System.out.println("Bubble Swaps Swaps            : "+bSwap);
        System.out.println("Selection Sort Comparisons    : "+sComp);
        System.out.println("Selection Swaps Swaps         : "+sSwap);
        System.out.println("Insertion Sort Comparisons    : "+iComp);
        System.out.println("Insertion Swaps Swaps         : "+iSwap);
    }
    
}
