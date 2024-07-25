package modul1;


public class A113_WorkingwithStrings {
    public static void main(String[] args) {
        String text = " Hello World! ";
        char[] symbol = text.toCharArray();

        System.out.println("Length the string " + text + " is " + symbol.length+ " symbols");
        System.out.println("Text in uppercase:" + text.toUpperCase());
        System.out.println("Text in lowercase:" + text.toLowerCase());
        System.out.println("replace “World” with “Codersbay”:"+ text.replace("World", "Codersbay"));
        System.out.println("Text without the leading spaces: "+text.trim());
        System.out.println((text+"\n").repeat(15));
    }
}
