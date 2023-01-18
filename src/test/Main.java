package test;

public class Main {

	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		int c = new Integer(1);
		
		int a2 = 2;
		int d = new Integer(2);
		
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		System.out.println(System.identityHashCode(c));
		
		System.out.println(System.identityHashCode(a2));
		System.out.println(System.identityHashCode(d));
		
		String str = "string";
        String str2 = "string";
        String str3 = new String("string");
        
        System.out.println(System.identityHashCode(str));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		
		int e = 1;
		System.out.println(System.identityHashCode(e));
	}

}
