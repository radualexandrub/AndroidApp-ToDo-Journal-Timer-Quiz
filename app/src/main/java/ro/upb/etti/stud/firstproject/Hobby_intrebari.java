package ro.upb.etti.stud.firstproject;

public class Hobby_intrebari {

    public String mQuestions[] = {
            "Cati ani ai?",
            "Care a fost materia ta preferata in timpul scolii?", //music, gym, doing art, reading, history
            "Intr-o zi ploioasa de sambata, ce preferi sa faci?",
            "Caracteristica care te descrie cel mai bine este:",
            "Iti place sa te vezi precum un...", //lider, ganditor, visator, luptator
            "Te consideri bun in activitatile care necesita:", //critical thought, patience, brainstorm, physical strength
            "Preferi un hobby care sa fie..." //rewarding, challenging, fun, relaxing
    };

    private String mChoices[][] = {
            {"Sub 18 ani", "Intre 18 si 30 ani", "Intre 31 si 40 ani", "Peste 40 de ani"},
            {"Arte si literatura", "Sport", "Matematica", "Muzica"},
            {"Citesc o carte", "Exercitii fizice", "Jocuri de societate", "Dansez"},
            {"Creativ", "Puternic si curajos","Calm si rabdator", "Practic"},
            {"Visator", "Luptator", "Ganditor", "Lider"},
            {"Brainstorming", "Forta fizica", "Rabdare", "Gandire critica"},
            {"Relaxant", "Provocator", "Satisfacator", "Amuzant"}
    };

    public String getQuestion(int i) {
        String question = mQuestions[i];
        return question;
    }

    public String getChoice1(int i) {
        String choice = mChoices[i][0];
        return choice;
    }
    public String getChoice2(int i) {
        String choice = mChoices[i][1];
        return choice;
    }
    public String getChoice3(int i) {
        String choice = mChoices[i][2];
        return choice;
    }
    public String getChoice4(int i) {
        String choice = mChoices[i][3];
        return choice;
    }
}
