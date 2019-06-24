#include <stdio.h>


int _lis(int *arr, int *end){
 
    if (arr == NULL || end == NULL) return 0; //input validation

    //arr holds the last element of the lis, so we need a traversal pointer
    int *traverse;  
    traverse = arr;

    //Find the next array element greater than the current lis
    while(*traverse <= *arr && traverse != end)
    {   
      traverse++; 
    }

    if(traverse == end) //traversal reached end of the array
    {   
      return (*traverse > *arr)? 2: 1;  //Check if the last element is in the lis
    }

    return 1 + _lis(traverse, end); //look at the rest of the list
}

int LIS(int arr[], int arr_len){
  if(arr_len == 0) return 0;

  int max = 0, temp;
  for(int i = 0; i < arr_len; ++i){
    temp = _lis(&(arr[i]), &(arr[arr_len-1]));
    max = (temp > max)?temp: max;
  }
  
  return max;
}  

int main(void) {
 
  int intArray[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
  printf(" LIS IS: %d\n", LIS(intArray,16));
  return 0;
}

