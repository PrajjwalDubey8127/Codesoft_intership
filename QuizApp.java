import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizApp extends JFrame implements ActionListener {

    String[] questions = {
        "What is the capital of India?",
        "Which planet is known as the Red Planet?",
        "Who wrote the Ramayana?"
    };

    String[][] options = {
        {"Delhi", "Mumbai", "Kolkata", "Chennai"},
        {"Earth", "Mars", "Jupiter", "Saturn"},
        {"Valmiki", "Tulsidas", "Ved Vyas", "Kalidas"}
    };

    int[] correctAnswers = {0, 1, 0}; // index of correct options

    int currentQuestion = 0;
    int selectedOption = -1;
    int score = 0;
    int timeLeft = 10;

    JLabel questionLabel = new JLabel();
    JRadioButton[] optionButtons = new JRadioButton[4];
    ButtonGroup optionsGroup = new ButtonGroup();
    JButton nextButton = new JButton("Next");
    JLabel timerLabel = new JLabel("Time Left: 10");
    Timer timer;

    public QuizApp() {
        setTitle("Quiz App");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 1));

        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(questionLabel);

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setActionCommand(String.valueOf(i));
            optionsGroup.add(optionButtons[i]);
            add(optionButtons[i]);

            optionButtons[i].addActionListener(e -> nextButton.setEnabled(true));
        }

        add(timerLabel);
        add(nextButton);
        nextButton.addActionListener(this);
        nextButton.setEnabled(false);

        loadQuestion();
        startTimer();

        setVisible(true);
    }

    void loadQuestion() {
        if (currentQuestion < questions.length) {
            questionLabel.setText("Q" + (currentQuestion + 1) + ": " + questions[currentQuestion]);
            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(options[currentQuestion][i]);
                optionButtons[i].setSelected(false);
            }
            optionsGroup.clearSelection();
            nextButton.setEnabled(false);
            timeLeft = 10;
            timerLabel.setText("Time Left: " + timeLeft);
        } else {
            showResult();
        }
    }

    void startTimer() {
        timer = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("Time Left: " + timeLeft);
            if (timeLeft <= 0) {
                timer.stop();
                checkAnswer(-1); // No answer selected
                nextQuestion();
            }
        });
        timer.start();
    }

    void checkAnswer(int selected) {
        if (selected == correctAnswers[currentQuestion]) {
            score++;
        }
    }

    void nextQuestion() {
        currentQuestion++;
        loadQuestion();
        timer.restart();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.stop();
        selectedOption = Integer.parseInt(optionsGroup.getSelection().getActionCommand());
        checkAnswer(selectedOption);
        nextQuestion();
    }

    void showResult() {
        JOptionPane.showMessageDialog(this, "Quiz Over!\nYour score: " + score + "/" + questions.length);
        System.exit(0);
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}
