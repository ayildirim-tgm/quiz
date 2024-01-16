package quiz;

import javax.swing.*;
import java.awt.*;

/**
 * Repräsentiert eine einzelne Frage mit Auswahlmöglichkeiten in einem Multiple-Choice-Quiz.
 * @author Aran Yildirim
 * @version 16.01.2023
 */
public class MultipleChoiceQuestion implements Question {
    private String question;
    private String[] options;
    private String correctAnswer;

    private JPanel questionPanel;
    private ButtonGroup buttonGroup;

    /**
     * Konstruktor für die Question-Klasse.
     * @param question Die Frage als Text.
     * @param options Das Array der Antwortmöglichkeiten.
     * @param correctAnswer Die korrekte Antwort unter den Optionen.
     */
    public MultipleChoiceQuestion(String question, String[] options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;

        questionPanel = new JPanel();
        questionPanel.setLayout(new BorderLayout());

        JLabel questionLabel = new JLabel(question);
        questionPanel.add(questionLabel, BorderLayout.PAGE_START);

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.LINE_AXIS));
        buttonGroup = new ButtonGroup();
        for (String option : options) {
            JRadioButton radioButton = new JRadioButton(option);
            radioButton.setActionCommand(option);
            buttonGroup.add(radioButton);
            optionPanel.add(radioButton);
        }
        questionPanel.add(optionPanel, BorderLayout.CENTER);
    }

    /**
     * Ruft das Panel mit der Frage und den Antwortmöglichkeiten ab.
     * @return Das JPanel, das die Frage und die Optionen repräsentiert.
     */
    @Override
    public JPanel getQuestionPanel() {
        return questionPanel;
    }

    /**
     * Überprüft, ob die ausgewählte Antwort korrekt ist.
     * @return True, wenn die ausgewählte Antwort korrekt ist, andernfalls false.
     */
    @Override
    public boolean isCorrect() {
        if(buttonGroup.getSelection().getActionCommand() != null) {
            return buttonGroup.getSelection().getActionCommand().equals(correctAnswer);
        } else {
            return false;
        }
    }
}
