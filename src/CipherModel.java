import java.util.HashMap;

public class CipherModel {
    private boolean encodeMode = true;

    public CipherModel() {
    }

    private static boolean isAsciiLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    public static String encode(int key, String plainText) {
        key %= 26;
        StringBuilder cipher = new StringBuilder();
        for (char ch : plainText.toCharArray()) {
            if (!isAsciiLetter(ch)) {
                cipher.append(ch);
                continue;
            }
            int baseModifier = Character.isUpperCase(ch) ? 'A' : 'a';
            ch -= baseModifier;
            ch = (char) ((ch + key + 26) % 26);
            ch += baseModifier;
            cipher.append(ch);
        }
        return cipher.toString();
    }

    public static String decode(int key, String cipherText) {
        key %= 26;
        StringBuilder plainText = new StringBuilder();
        for (char ch : cipherText.toCharArray()) {
            if (!isAsciiLetter(ch)) {
                plainText.append(ch);
                continue;
            }
            int baseModifier = Character.isUpperCase(ch) ? 'A' : 'a';
            ch -= baseModifier;
            ch = (char) ((ch + 26 - key) % 26);
            ch += baseModifier;
            plainText.append(ch);
        }
        return plainText.toString();
    }

    public boolean isEncodeMode() {
        return encodeMode;
    }

    public void setEncodeMode(boolean encodeMode) {
        this.encodeMode = encodeMode;
    }
}
