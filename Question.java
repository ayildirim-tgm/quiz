/**
 * Dieses Interface definiert alle Anforderungen für die Darstellung und Auswertung von Fragen.
 * 
 * @author Aran Yildirim
 * @since 16.01.2023
 */
package at.ac.tgm.quiz;

import javax.swing.JPanel;

public interface Question {

    /**
     * Gibt das Panel mit der Frage und den Antwortmöglichkeiten zurück.
     * 
     * @return Das JPanel, das die Frage und die Antwortmöglichkeiten repräsentiert.
     */
    public JPanel getQuestionPanel();

    /**
     * Überprüft, ob die gegebene Antwort korrekt ist.
     * 
     * @return True, wenn die Antwort korrekt ist, andernfalls false.
     */
    public boolean isCorrect();
}
