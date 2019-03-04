public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    public boolean isPalindrome(String word) {
        Deque d = wordToDeque(word);
        return palCompare(d);
    }

    private boolean palCompare(Deque d) {
        if (d.size() <= 1) {
            return true;
        } else if (d.removeFirst() != d.removeLast()) {
            return false;
        } else {
            return palCompare(d);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque d = wordToDeque(word);
        return palCompare(d, cc);
    }

    private boolean palCompare(Deque<Character> d, CharacterComparator cc) {
        if (d.size() <= 1) {
            return true;
        } else if (!cc.equalChars(d.removeFirst(), d.removeLast())) {
            return false;
        } else {
            return palCompare(d, cc);
        }
    }

}
