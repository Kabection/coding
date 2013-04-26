/**
*   Implementation of QuickSort whose complexity is O(n^2) in the worse case, but  is O(n log n).
*/

public static void quickSort(int[] array, int first, int last){
    int middle = Partition(array,first,last);
    quickSort(array, first, middle);
    quickSort(array, middle + 1, last);
}

public static void Partition(int[] array, int first, int last){
    int pospivo = (irst + last)/ 2;
    if (pospivo != first){
        troca(array, pospivo, first);
    }
    int pivo = array[first];
    int i = first;
    int j = last;
    do{
        while(i < last && array[i] <= pivo){
            i++;
        }

        while (j > first && array[j] > pivo){
            j--;
        }
        if (i < j){
            troca(array, i, j);
        }
    }while(i < j);
    troca(array, pivo, j);
    return j;

}

public static void troca(int[] array, int a, int b){
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
}
