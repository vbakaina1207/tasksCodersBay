package modul5;

import java.util.ArrayList;
import java.util.Random;

public class Challenge2 {
    public static void main(String[] args) {
        ArrayList<Tree> listTree = new ArrayList<>();
        Random r = new Random();
        int maxLeaves = 0;
        int allLeaves = 0;
        int maxId = -1;

        for(int i = 1; i <= 100; i++){
            int leaves = r.nextInt(1001);
            Tree tree = new Tree(leaves, i);
            listTree.add(tree);
            allLeaves += tree.leaves;
            if(leaves > maxLeaves) {
                maxLeaves = leaves;
                maxId = tree.id;
            }
        }
        System.out.println("Gesamtblätter: " + allLeaves);
        System.out.println("Der Baum mit dem grösten Anzahl an Blättern hat ID " + maxId);
    }

    public  static class Tree {
        public int leaves;
        public int id;

        public Tree(int leaves, int id) {
            this.leaves = leaves;
            this.id = id;
        }
    }
}
