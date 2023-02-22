package m1.day__;


public class Main2739 {

    public static void main(String[] args) {
        String str = "string";
        String str2 = "string";
        
        System.out.println(System.identityHashCode(str2));
        
        str2.toUpperCase();
        
        System.out.println(System.identityHashCode(str2.toUpperCase()));


        System.out.println(System.identityHashCode(str));    //result:2008362258 
        System.out.println(System.identityHashCode(str2));     //result:2008362258
        
        str2 = "qwe";
        
        
        System.out.println(str);
        System.out.println(str2);
        
        System.out.println(System.identityHashCode(str));    //result:2008362258 
        System.out.println(System.identityHashCode(str2));     //result:2008362258
    }

}