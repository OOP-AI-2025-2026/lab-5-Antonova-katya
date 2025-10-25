package ua.opnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame implements ActionListener {

    public MainFrame(String title) throws HeadlessException {
        super(title);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        JButton rockButton = new JButton("Камінь");
        rockButton.addActionListener(this);
        rockButton.setActionCommand("rock");
        JButton paperButton = new JButton("Папір");
        paperButton.addActionListener(this);
        paperButton.setActionCommand("paper");
        JButton scissorsButton = new JButton("Ножиці");
        scissorsButton.addActionListener(this);
        scissorsButton.setActionCommand("scissors");

        this.add(rockButton);
        this.add(paperButton);
        this.add(scissorsButton);

        this.pack();
        this.setVisible(true);
    }

    private GameShape generateShape() {
        int random = new Random().nextInt(3);
        switch (random) {
            case 0:
                return new rock();
            case 1:
                return new paper();
            case 2:
                return new scissors();
            default:
                return new paper();
        }
    }

    private int checkWinner(GameShape player, GameShape computer) {
            // Перевірка на нічию
            if ((player instanceof rock && computer instanceof rock) ||
                    (player instanceof paper && computer instanceof paper) ||
                    (player instanceof scissors && computer instanceof scissors)) {
                return 0;
            }

            // Перевірка на виграш гравця
            if ((player instanceof rock && computer instanceof scissors) ||
                    (player instanceof paper && computer instanceof rock) ||
                    (player instanceof scissors && computer instanceof paper)) {
                return 1;
            }

            // 3. Якщо виграв комп'ютер
            return -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Генерується ход комп'ютеру
        GameShape computerShape = generateShape();

        GameShape playerShape = new GameShape();
        // Визначаємо, на яку кнопку натиснув гравець
        switch (e.getActionCommand()) {
            case "rock":
                // присвоїти playerShape об'єкт відповідного класу
                playerShape = new rock();
                break;
            case "paper":
                // присвоїти playerShape об'єкт відповідного класу
                playerShape = new paper();
                break;
            case "scissors":
                // присвоїти playerShape об'єкт відповідного класу
                playerShape = new scissors();
                break;
        }

        // Визначити результат гри
        int gameResult = checkWinner(playerShape, computerShape);

        // Сформувати повідомлення
        String message = "Вибір гравця: " + playerShape + ". Вибір комп'ютера: " + computerShape + ". ";
        switch (gameResult) {
            case -1:
                message += "Комп'ютер переміг!";
                break;
            case 0:
                message += "Нічия!";
                break;
            case 1:
                message += "Гравець виграв!";
        }

        // Вивести діалогове вікно з повідомленням
        JOptionPane.showMessageDialog(null, message);
    }
}
