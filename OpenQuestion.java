/**
 * Diese Klasse ermöglicht das Stellen von offenen Fragen.
 * 
 * @author Aran Yildirim
 * @version 16.01.2023
 */
package quiz;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OpenQuestion implements Question {
    private String question;
    private String correctAnswer;
    private JTextField questionText;
    private JPanel questionPanel;

    /**
     * Konstruktor für die OpenQuestion-Klasse.
     * 
     * @param question      Die Frage als Text.
     * @param correctAnswer Die korrekte Antwort auf die Frage.
     */
    public OpenQuestion(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        questionPanel = new JPanel();
        questionText = new JTextField();

        JLabel questionLabel = new JLabel(question);
        JPanel antwort = new JPanel();

        questionPanel.setLayout(new BorderLayout());
        questionPanel.add(questionLabel, BorderLayout.PAGE_START);

        antwort.setLayout(new BoxLayout(antwort, BoxLayout.LINE_AXIS));
        antwort.add(questionText);
        questionPanel.add(antwort, BorderLayout.CENTER);
    }

    /**
     * Überprüft, ob der eingegebene Text der richtigen Antwort entspricht.
     * 
     * @return True, wenn die Antwort korrekt ist, andernfalls false.
     */
    @Override
    public boolean isCorrect() {
        if (questionText.getText().equals(correctAnswer) || questionText.getText().equals(correctAnswer.toLowerCase())) {
            return true;
        }
        return false;
    }

    /**
     * Gibt das Panel mit der Frage und dem Eingabefeld zurück.
     * 
     * @return Das JPanel, das die Frage und das Eingabefeld repräsentiert.
     */
    @Override
    public JPanel getQuestionPanel() {
        return questionPanel;
    }
}
