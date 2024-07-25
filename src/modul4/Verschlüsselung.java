package modul4;

public class Verschlüsselung {
    public static void main(String[] args) {

        String text = "mein Lieblingsfilm z56789";
        char[] symbolText = text.toUpperCase().toCharArray();
        int key = 1;

        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        //StringBuilder enctyptonMessage = encrypton(symbolText, key, alphabet);
        //System.out.println(enctyptonMessage);
        //symbolText = enctyptonMessage.toString().toCharArray();
        symbolText = "Mpse pg uif Sjoht".toUpperCase().toCharArray();;
        //StringBuilder denctyptonMessage = dencrypton(enctyptonMessage.toString().toCharArray(), key, alphabet);
        StringBuilder denctyptonMessage = dencrypton(symbolText, key, alphabet);
        System.out.println(denctyptonMessage);


    }


    private static StringBuilder encrypton(char[] symbol, int key, char[] alphabet) {
        StringBuilder message = new StringBuilder();
        boolean isCode = false;
        int len = alphabet.length;

        for (int i = 0; i < symbol.length; i++) {
            for (int j =0; j< alphabet.length && !isCode; j++){
                if(symbol[i] == alphabet[j]){
                    symbol[i] = alphabet[(j+key)%len];
                    isCode = true;
                }
            }
            isCode= false;
            message.append(symbol[i]);
        }
        return message;
    }

    private static StringBuilder dencrypton(char[] symbol, int key, char[] alphabet) {
        StringBuilder message = new StringBuilder();
        boolean isCode = false;
        int len = alphabet.length;

        for (int i = 0; i < symbol.length; i++) {
            for (int j =0; j< alphabet.length && !isCode; j++){
                if(symbol[i] == alphabet[j]){
                    if ((j-key)>=0)
                        symbol[i] = alphabet[Math.abs(j-key)];
                    else
                        symbol[j] = alphabet[36-Math.abs(j-key)];
                    isCode = true;
                }
            }
            isCode= false;
            message.append(symbol[i]);
        }
        return message;
    }
}