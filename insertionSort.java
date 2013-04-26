/**
*   Implementation of insertion sort whose complexity in the worse case is O(n^2).
*/
blic static void insertionSort(int[] array, int first, int last){
    int j, temp;
    for (int i = first +1; i <= last; i++){
    j = i;
    temp = array[j];
    while (j > 0 && temp < array[j-1]){
        array[j] = array[j-1];
        j--;
    }
    array[j] = temp;
    }
}
