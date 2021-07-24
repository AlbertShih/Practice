package questions.practice;

import java.util.*;
import java.util.stream.IntStream;

public class JavaBitSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        BitSet B1 = new BitSet(N);
        BitSet B2 = new BitSet(N);

        IntStream.range(0, M).forEach(
                itr -> {
                    String cmd = sc.next();
                    int n1 = sc.nextInt();
                    int n2 = sc.nextInt();

                    switch(cmd){
                        case "AND":
                            if(n1 == 1){
                                B1.and(B2);
                            } else {
                                B2.and(B1);
                            }
                            break;
                        case "OR":
                            if(n1 == 1){
                                B1.or(B2);
                            } else {
                                B2.or(B1);
                            }
                            break;
                        case "XOR":
                            if(n1 == 1){
                                B1.xor(B2);
                            } else {
                                B2.xor(B1);
                            }
                            break;
                        case "SET":
                            if(n1 == 1){
                                B1.set(n2);
                            } else {
                                B2.set(n2);
                            }
                            break;
                        case "FLIP":
                            if(n1 == 1){
                                B1.flip(n2);
                            } else {
                                B2.flip(n2);
                            }
                            break;
                    }
                    System.out.println(B1.cardinality() + " " + B2.cardinality());
                }
        );
    }
}