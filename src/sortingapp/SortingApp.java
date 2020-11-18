package sortingapp;
import java.util.Scanner;

public class SortingApp 
{

    
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        SortingAlgos sort = new SortingAlgos();
        System.out.print("Enter Number of Element in Data Set : ");
        int size = input.nextInt();
        int mstrList[];
        int bblList[];
        int ssList[];
        int iList[];
        int mList[];
        int qList[];
                
        //Create a Master List
        mstrList = new int[size];
        bblList = new int[size];
        ssList = new int[size];
        iList = new int[size];
        mList = new int[size];
        qList = new int[size];
        
        for(int i=0; i<size; i++)
        {
            mstrList[i] = (int)(Math.random()*100);
            bblList[i] = mstrList[i];
            ssList[i] = mstrList[i];
            iList[i] = mstrList[i];
            mList[i] = mstrList[i];
            qList[i] = mstrList[i];
        }
        
        char choice;            
        while(true)
        {
            System.out.println("\n########## SORTING MENUE ##########");
            System.out.println("\t1. Bubble Sort        (B/b) ");
            System.out.println("\t2. Selection Sort     (S/s) ");
            System.out.println("\t3. Insertion Sort     (I/i) ");
            System.out.println("\t4. Quick Sort         (Q/q) ");
            System.out.println("\t5. Print Comp Report  (R/r) ");
            System.out.println("\t6. Exit Programe      (E/e) ");
            System.out.println("\t7. Merge Sort         (M/m) ");
            System.out.println("------------------------------------");
            System.out.print("Enter Your Choice (I/L/B/) : ");
            
            choice =  (input.next()).charAt(0);
            
            if(choice == 'B' || choice == 'b')
            {
                System.out.println("\n------------------------------------");
                System.out.print("\nList Before Sort : ");
                sort.PrintList(bblList);
                sort.BubbleSort(bblList);
                System.out.print("\nList After  Sort : ");
                sort.PrintList(bblList);
                System.out.println("\n------------------------------------");
            }
            else if(choice == 'S' || choice == 's')
            {
                System.out.println("\n------------------------------------");
                System.out.print("\nList Before Sort : ");
                sort.PrintList(ssList);
                sort.SelectionSort(ssList);
                System.out.print("\nList After  Sort : ");
                sort.PrintList(ssList);
                System.out.println("\n------------------------------------");
            }
            else if(choice == 'I' || choice == 'i')
            {
                System.out.println("\n------------------------------------");
                sort.PrintList(iList);
                sort.InsertionSort(iList);
                System.out.println("\nList After Sort : ");
                sort.PrintList(iList);
                System.out.println("\n------------------------------------");
            }

            else if(choice == 'M' || choice == 'm')
            {
                System.out.println("\n------------------------------------");
                sort.PrintList(mList);
                sort.mergeSort(mList,0,mList.length-1);
                System.out.println("\nList After Sort : ");
                sort.PrintList(mList);
                System.out.println("\n------------------------------------");
            }

            else if(choice == 'Q' || choice == 'q')
            {
                System.out.println("\n------------------------------------");
                sort.PrintList(qList);
                sort.QuickSort(qList,0,qList.length-1);
                System.out.println("\nList After Sort : ");
                sort.PrintList(qList);
                System.out.println("\n------------------------------------");
            }
            
            else if(choice == 'R' || choice == 'r')
            {
                System.out.println("\n------------------------------------");
                sort.PrintReport();
                System.out.println("\n------------------------------------");
            }
            else
            {
                System.out.println("\n--------------------------------");
                System.out.println("Programe Exiting");
                System.out.println("\n--------------------------------");
                System.exit(0);
            }
            
        }
    }
    
}
