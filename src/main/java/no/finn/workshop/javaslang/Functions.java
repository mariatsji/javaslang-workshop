package no.finn.workshop.javaslang;

public class Functions {

    public static void main(String[] args) {
        DerivableFunction myFunction = new DerivableFunction(7d, -3d, 9d);
        System.out.println(myFunction);
        System.out.println(myFunction.apply(1d));
    }


}
