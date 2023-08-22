// dict.h
typedef void *Dict;
extern Dict ConsDict(int);
extern void SortDict(Dict);
extern void DisplayDict(Dict);
extern void InsertDict(Dict,int);