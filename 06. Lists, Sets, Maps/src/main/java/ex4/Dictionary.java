package ex4;

import java.util.*;

public class Dictionary {


    private final Map<Word, Definition> words;

    public Dictionary() {
        this.words = new HashMap<>();
    }

    public void addWord(Word word, Definition definition) {
        this.words.put(word, definition);
    }

    public Definition getDefinition(Word word) {
        return this.words.get(word);
    }

    public Set<Word> getAllWords() {
        return this.words.keySet();
    }

    public List<Definition> getAllDefinitions() {
        return new ArrayList<>(this.words.values());
    }
}