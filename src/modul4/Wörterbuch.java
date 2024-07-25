package modul4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Wörterbuch {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int chose = -1;
        addWord("book", "buch", dictionary);
        addWord("cat", "Katze", dictionary);
        addWord("today", "heute", dictionary);
        addWord("lake", "See", dictionary);
        addWord("head", "Kopf", dictionary);

        while (chose != 0) {
            System.out.println("----------------");
            System.out.println("Was möchten Sie:");
            System.out.println("1. ein Wort hinzufügen; ");
            System.out.println("2. ein Wort löschen");
            System.out.println("3. ein Wort übersetzen");
            System.out.println("0. ein Ausgang");
            System.out.println("----------------");
            chose = sc.nextInt();
            if (chose == 1) {
                addWordWithScanner(dictionary);
                printWord(dictionary);
            } else if (chose == 2) {
                removeWord("", dictionary);
                printWord(dictionary);
            } else if (chose == 3) {
                getWord("", dictionary);
            }
        }
    }

    private static void addWordWithScanner(Map<String, String> dictionary) {
        Scanner sc = new Scanner(System.in);
        String wordEnglish;
        String wordDeutsch;

        System.out.println("Geben Sie das Wort ein, das Sie hinzufügen möchten.");
        wordEnglish = sc.nextLine();

        System.out.println("Geben Sie eine Übersetzung eines Wort ein, das Sie hinzufügen möchten.");
        wordDeutsch = sc.nextLine();

        dictionary.put(wordEnglish, wordDeutsch);
        dictionary.putIfAbsent(wordDeutsch, wordEnglish);
    }


    public static void addWord(String wordEnglish, String wordDeutch, Map<String, String> dictionary) {
        Scanner sc = new Scanner(System.in);
        if ("".equals(wordEnglish)) {
            System.out.println("Geben Sie das Wort ein, das Sie hinzufügen möchten.");
            wordEnglish = sc.nextLine();
        }
        if ("".equals(wordDeutch)) {
            System.out.println("Geben Sie eine Übersetzung eines Wort ein, das Sie hinzufügen möchten.");
            wordDeutch = sc.nextLine();
        }
        dictionary.put(wordEnglish, wordDeutch);
        dictionary.putIfAbsent(wordDeutch, wordEnglish);
    }

    public static void removeWord(String word, Map<String, String> dictionary) {
        Scanner sc = new Scanner(System.in);
        if ("".equals(word)) {
            System.out.println("Geben Sie das Wort ein, das Sie löschen möchten.");
            word = sc.nextLine();
        }
        if (dictionary.containsKey(word.toLowerCase())) {
            String deutschWord = dictionary.get(word);
            dictionary.remove(word);
            dictionary.remove(deutschWord);
        }
    }

    public static void getWord(String word, Map<String, String> dictionary) {
        Scanner sc = new Scanner(System.in);
        if ("".equals(word)) {
            System.out.println("Geben Sie das Wort ein, das Sie übersetzen möchten.");
            word = sc.nextLine();
        }
        if (dictionary.containsKey(word)) {
            System.out.println(word + " - > " + dictionary.get(word));
        } else if (dictionary.containsKey(dictionary.get(word))) {
            System.out.println(word + " - > " + dictionary.get(dictionary.get(word)));
        } else
            System.out.println("Word not found");

    }

    public static void printWord(Map<String, String> dictionary) {
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + " - > " + entry.getValue());
        }
    }
}

