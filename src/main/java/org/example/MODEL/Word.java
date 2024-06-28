package org.example.MODEL;

public class Word {
    private int id;
    private String german;
    private String hungarian;
    private String theme;
    private WordType type;

    public Word(int id, String german, String hungarian, String theme, String type) {
        if (verifyArgs(german, hungarian, theme, type)) {
            try {
                this.id = id;
                this.german = german;
                this.hungarian = hungarian;
                this.theme = theme;
                this.type = WordType.of(type);
            } catch (NonExistentWordTypeException e) {
                System.out.println("Probably misstyped into sql on insert(would be interesting, considering I inserted them with ids)");
            }
        } else throw new IllegalArgumentException();
    }
    /*Theme can be null, for now because I have no clue how to put the words into theme categories
     *so it is allowed to take the null value, also some words might belong to multiple categories
     *and I don't feel like dealing with that
     */
    private static boolean verifyArgs(String german, String hungarian, String theme, String type) {
            return german != null && !german.isBlank() &&
                    hungarian != null && !hungarian.isBlank() &&
                    type != null && !type.isBlank();
    }
    public int getId() {return this.id;}
    public String getGerman() {return this.german;}
    public String getHungarian() {return this.hungarian;}
    public String getTheme() {return this.theme;}
    public WordType getType() {return this.type;}
    @Override
    public String toString() {
        return String.format("""
                German : %s,
                Hungarian : %s,
                theme : %s,
                type : %s
                """, this.german, this.hungarian, this.theme, this.type.toString());
    }
}
