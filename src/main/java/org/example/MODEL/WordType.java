package org.example.MODEL;

public enum WordType {
    SUBSTANTIV("Substantiv"),
    VERB("Verb"),
    PRONOMEN("Pronomen"),
    ADJEKTIV("Adjektiv"),
    ADVERB("Adverb"),
    ARTIKEL("Artikel"),
    PRAPOSITION("Präposition"),
    KONJUNKTION("Konjunktion"),
    INTERJEKTION("Interjektion"),
    ZAHLWORT("Zahlwört"),
    AUSDRUCK("Ausdruck");

    private final String type;

    WordType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }
    public static WordType of(String type) throws NonExistentWordTypeException {
        for (WordType wt : WordType.values()) {
            if (wt.getType().equals(type)) {
                return wt;
            }
        } throw new NonExistentWordTypeException();
    }
}
