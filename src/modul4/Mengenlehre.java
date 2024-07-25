package modul4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Mengenlehre {
    public static void main(String[] args) {
        Set <Integer> A = setOf ( 1, 3, 5 );
        Set <Integer> B = setOf ( 3, 5, 7 );
        Set <Integer> C = setOf ( 5, 7, 9 );

        Set <Integer> D = unionSet(unionSet(A, B), C);
        System.out.println("union A ∪ B ∪ C " + D);
        Set <Integer> E = unionSet(A, intersectSet(B, C));
        System.out.println("intersect A ∪ (B ∩ C) " + E);
        Set <Integer> F = intersectSet(intersectSet(A,B), C);
        System.out.println("intersectSet (A ∩ B) ∩ C " + F);
        Set <Integer> I = intersectSet(A,unionSet(B, C));
        System.out.println("intersect A ∩ (B ∪ C) " + I);

        Set <Integer> Dif = differenceSet(A,unionSet(B, C));
        System.out.println("difference A,unionSet(B, C)" + Dif);
        Set <Integer> Dif1 = differenceSet(A,differenceSet(B, C));
        System.out.println("difference A,differenceSet(B, C)" + Dif1);
    }

    private static Set<Integer> setOf(Integer... values) {
        return new HashSet<>(Arrays.asList(values));
    }

    private static Set<Integer> intersectSet (Set<Integer> A, Set<Integer> B) {
        Set<Integer> intersectSet = new HashSet<>(A);
        intersectSet.retainAll(B);
        return intersectSet;
    }

    private static Set<Integer> unionSet (Set<Integer> A, Set<Integer> B) {
        Set<Integer> unionSet = new HashSet<>(A);
        unionSet.addAll(B);
        return unionSet;
    }

    private static Set<Integer> differenceSet (Set<Integer> A, Set<Integer> B) {
        Set<Integer> differenceSet = new HashSet<>(A);
        differenceSet.removeAll(B);
        return differenceSet;
    }
}
