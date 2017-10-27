package dictionary;

public class Entry {
    private String word_;
    private String clue_;

    public Entry(String _word, String _clue) {
        word_=_word;
        clue_=_clue;
    }

    public String GetWord() {
        return word_;
    }

    public String GetClue() {
        return clue_;
    }
}


