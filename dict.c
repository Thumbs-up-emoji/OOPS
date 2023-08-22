#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
#include<error.h>
#include<stdbool.h>
typedef int *Dict;
Dict ConsDict(int size) {
int *p=(int*)malloc((size+2)*sizeof(int));
p[0] = 0; p[1] = size;
return p;
}
void func(Dict d,int n)
{
    //Let func be x^2-3x+2, I'll try sorting x values on the basis of their respective x2-3X+2 values
   
    for(int i=0;i<n;i++)
    {
        d[i]=d[i]*d[i]-3*d[i]+2;
    }
}
void BubbleSort(Dict d, int n)
{
    int temp;
    bool swapped;
    func(d, n);
    for (int i = 0; i < n - 1; i++) {
        swapped = false;
        for (int j = 0; j < n - i - 1; j++) {
            if (d[j] > d[j + 1]) {
                if(d[j]>d[j+1])
                {
                    temp=d[j];
                    d[j]=d[j+1];
                    d[j+1]=temp;
                    swapped = true;
                }
            }
        }
         if (swapped == false)
            break;
    }
}

void SortDict(Dict d) {
BubbleSort(d+2,d[0]);
// Sort d[0]=actual count elements in it
}
void InsertDict(Dict d, int i) {
if(d[0]==d[1]) error(-1,0,"Dictionally full!");
d[d[0]+2]=i;
d[0]+=1;
}
void DisplayDict(Dict d) {
int i;
printf("Displaying dictionary with %d elements, size %d: ",d[0],d[1]);
for(i=2; i<d[0]+2; i++) {
printf("Element%02d=%d ",i-1,d[i]);
}
printf("\n");
}