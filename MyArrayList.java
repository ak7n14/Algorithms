/**
 * List Implementation Using Arrays by Anish Katariya
 * Better implementation would be using generics instead of object
 * inheritance relation.
 * for experimental purposes only
 */

 public class MyArrayList implements MyArrayList{

   private object[] data;
   private int noElements;

   public MyArrayList()
   {
     data = new Object[10];
     noElements=0;
   }

   public MyArrayList(int initial_capacity) throws IllegalArgumentException
   {
     if(initial_capacity<=0)
        throw new IllegalArgumentException();
     data = new Object[initial_capacity];
     noElements=0;
   }

   public Object get(int Index) throws IndexOutOfBounceException
   {
     if(index>=noElements)
        throw new IndexOutOfBounceException();
     return data[index];
   }

   public int size()
   {
     return noElements;
   }
/**
  *General Time analysis of resizing arrays
  *Total Number of operations needed to be performed<3N
  *Where N is the number of adds needed to be performed
  */
   public void ensureCapacity(int n){
     if(n>data.length){
       Object[]newdata=new Object [2*n];
       for(int i=0;i<data.length;i++){
         newdata[i]=data[i];
       }
       // newdata = Arrays.copyOf (data, data.length) ;
       data = newdata;
     }
   }
   public Object removeLast(){
     Object obj = data[noElements-1]
     noElements--;
     return obj;
   }
 }


 public interface MyList
 {
    public void add(Object obj);
      //post:add new element to the end of List
    public Object get(int index);
      // pre: 0 <= index<size()
      // post: return element in location given by index
    public void set(int index, Object obj);
      // pre: 0 <= index<size()
      // post:set element in location given by index to o b j
    public Object removeLast();
      // pre: non−empty List
      // post: return last element and remove this from List
    public int size();
      // post : return size of List
 }
