public class Palindrome {
    /** Transform string into deque. */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    /** */
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);

        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        } else {
            if (wordDeque.removeFirst() == wordDeque.removeLast()) {
                return isPalindrome(dequeToString(wordDeque));
            } else {
                return false;
            }
        }
    }

    /** Helper function for isPalindrome. */
    private String dequeToString(Deque d) {
        StringBuffer sb = new StringBuffer();

        while (d.size() > 0) {
            sb.append(d.removeFirst());
        }

        String word = sb.toString();
        return word;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);

        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        } else {
            if (cc.equalChars(wordDeque.removeFirst(), wordDeque.removeLast())) {
                return isPalindrome(dequeToString(wordDeque), cc);
            } else {
                return false;
            }
        }
    }
}
