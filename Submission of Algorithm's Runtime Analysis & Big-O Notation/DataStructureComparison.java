import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Random;

public class DataStructureComparison {

    public static void main(String[] args) {
        int datasetSize = 1_000_000;
        int target = 500_000;

        ArrayList<Integer> arrayList = generateArrayList(datasetSize);
        HashSet<Integer> hashSet = generateHashSet(datasetSize);
        TreeSet<Integer> treeSet = generateTreeSet(datasetSize);

        long arrayListSearchTime = searchArrayList(arrayList, target);
        long hashSetSearchTime = searchHashSet(hashSet, target);
        long treeSetSearchTime = searchTreeSet(treeSet, target);

        System.out.println("Array Search Time: " + arrayListSearchTime + " ns");
        System.out.println("HashSet Search Time: " + hashSetSearchTime + " ns");
        System.out.println("TreeSet Search Time: " + treeSetSearchTime + " ns");
    }

    private static ArrayList<Integer> generateArrayList(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(size));
        }
        return list;
    }

    private static HashSet<Integer> generateHashSet(int size) {
        HashSet<Integer> set = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            set.add(random.nextInt(size));
        }
        return set;
    }

    private static TreeSet<Integer> generateTreeSet(int size) {
        TreeSet<Integer> set = new TreeSet<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            set.add(random.nextInt(size));
        }
        return set;
    }

    private static long searchArrayList(ArrayList<Integer> list, int target) {
        long startTime = System.nanoTime();
        for (int num : list) {
            if (num == target) {
                break;
            }
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long searchHashSet(HashSet<Integer> set, int target) {
        long startTime = System.nanoTime();
        set.contains(target);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long searchTreeSet(TreeSet<Integer> set, int target) {
        long startTime = System.nanoTime();
        set.contains(target);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}