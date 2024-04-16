

import java.util.HashMap;

public class TesterPrefixCode {
    public static void main(String[] args) {
        BinaryTree<Character> tree = new BinaryTree<>(' ');

        HashMap<Character, String> encodeMap = new HashMap<>();
        encodeMap.put('a', "00");
        encodeMap.put('b', "01");
        encodeMap.put('c', "10");
        encodeMap.put('d', "11");

        HashMap<String, Character> decodeMap = new HashMap<>();
        for (HashMap.Entry<Character, String> entry : encodeMap.entrySet()) {
            decodeMap.put(entry.getValue(), entry.getKey());
        }

        tree.addNode('d', ' ', true);
        tree.addNode('a', 'd', true);
        tree.addNode('b', 'd', false);
        tree.addNode('c', 'a', false);

        String textToEncode = "bba";
        String encodedString = tree.encode(textToEncode, encodeMap);
        System.out.println("Encoded string: " + encodedString);

        String codeToDecode = encodedString;
        String decodedString = tree.decode(codeToDecode, decodeMap);
        System.out.println("Decoded string: " + decodedString);
    }
}
