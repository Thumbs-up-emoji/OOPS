class MyDictionary {
  // Main Driver Method (optional in our modular design)
  public static void main(String args[]) {
    System.out.println("The best way to use this type is to run another app main and instantiate a dictionary in it.");
  }
  private int[] arr;
  private int size=0;
  private int count=0;
  public int Size() { return size; }
  public int Count() { return count; }
  MyDictionary(int initialSize) {
    arr=new int[initialSize];
    size=initialSize;
    count=0;
  }
  public void Insert(int elem) {
    if(size>count) {
      arr[++count]=elem;
    }
    else System.out.println("Size" + size + " not enough for holding an extra element after " + count + " count");
  }
  public void Show() {
    System.out.print("Printing Dictionary of " + size + " Size and " + count + " Occupancy:");
    for (int i = 0; i < count; i++) {
      System.out.print(" " + arr[i]);
    }
    for (int i = count; i < size; i++) {
      System.out.print(" .");
    }
    System.out.println("");
  }
}
