#include"dict.h"
#include<stdlib.h>
// ... anything needed ...
// ...
int main(int argc, char *argv[]) {
Dict d1;
d1=ConsDict(argc-1);
// -- Make a dictionary of as many elements
// as passed on the command line
int i;
for (i=1; i<argc; i++) {
InsertDict(d1,atoi(argv[i]));
}
DisplayDict(d1);
SortDict(d1);
DisplayDict(d1);
}