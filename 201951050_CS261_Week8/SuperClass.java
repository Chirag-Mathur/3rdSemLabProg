//package week8oops;

class A {
    // methods and fields
}

// derived class
class B extends A {

}

class C extends B {

}

public class SuperClass {
    public static void main(String args[]) throws ClassNotFoundException {
        // args[0] = "B";
        String data = args[0];
        int pos = 0;
        String classname = "";
        for (int i = data.length() - 1; i >= 0; i--) {
            if (data.charAt(i) == '.') {
                // pos = i;
                break;

            } else {
                classname = data.charAt(i) + classname;
            }
        }
        // String classname = data.substring(pos, data.length() - 1);
        // System.out.println(classname);

        // System.out.println(c1.getSuperclass());
        try {
            Class c1 = Class.forName(classname);
            int counter = 0;
            while (c1.getSuperclass() != null) {
                counter++;

                c1 = c1.getSuperclass();
            }
            System.out.println(counter);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }

}
