package quiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Repräsentiert eine Anwendung für ein Multiple-Choice-Quiz, die Fragen anzeigt und Antworten überprüft.
 * @author Aran Yildirim
 * @version 16.01.2023
 */
public class Quiz extends JFrame {
    private JButton submitButton;
    private Question[] questions;

    /**
     * Konstruktor für die Quiz-Klasse, initialisiert die GUI und Fragen für das Multiple-Choice-Quiz.
     */
    public Quiz() {
        setTitle("Multiple-Choice-Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        questions = new Question[]{
                new MultipleChoiceQuestion("Was ist die Hauptstadt von Frankreich?", new String[]{"London", "Berlin", "Paris", "Madrid"}, "Paris"),
                new MultipleChoiceQuestion("Welcher Planet ist als der Rote Planet bekannt?", new String[]{"Mars", "Venus", "Jupiter", "Mercury"}, "Mars"),
                new OpenQuestion("Wer ist die schnellste Person der Welt?", "Usain Bolt"),
                // Weitere Fragen in einem ähnlichen Format hinzufügen
        };

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        for (Question question : questions) {
            JPanel questionPanel = question.getQuestionPanel();
            mainPanel.add(questionPanel);
        }

        submitButton = new JButton("Absenden");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswers();
            }
        });

        mainPanel.add(submitButton);
        add(mainPanel);
        setVisible(true);
    }

    /**
     * Überprüft die Antworten für alle Fragen und zeigt den Punktestand in einem Nachrichten-Dialog an.
     */
    private void checkAnswers() {
        int score = 0;
        for(Question question : questions) {
            if(question.isCorrect())
                score++;
        }
        JOptionPane.showMessageDialog(this, "Ihr Punktestand ist: " + score + "/" + questions.length);
        System.exit(0);
    }

    /**
     * Einstiegspunkt für die Ausführung der Anwendung für das Multiple-Choice-Quiz.
     * @param args Kommandozeilenargumente (nicht verwendet)
     */
    public static void main(String[] args) {
        new Quiz();
    }
}
