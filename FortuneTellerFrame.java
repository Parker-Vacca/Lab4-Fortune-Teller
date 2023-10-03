import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JButton readButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {

        super("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);


        fortunes = new ArrayList<>();
        fortunes.add("You will slip on a banana tomorrow!");
        fortunes.add("Death awaits you soon.");
        fortunes.add("Stay away from cows for the next 2 months.");
        fortunes.add("You will find your dream house next yeer.");
        fortunes.add("Your soulmate awaits you in Italy!");
        fortunes.add("A big job promotion is on the horizon.");
        fortunes.add("Play the lottery in 7 days.");
        fortunes.add("You will find great riches.");
        fortunes.add("Religion will awake you soon.");
        fortunes.add("Do not give up on your baseball career. ");
        fortunes.add("Buy bitcoin at 9PM on december 14th. ");
        fortunes.add("You will become the president of the United States.");


        titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        ImageIcon icon = new ImageIcon("fortune-teller.png");
        titleLabel.setIcon(icon);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        fortuneArea = new JTextArea();
        fortuneArea.setEditable(false);
        fortuneArea.setFont(new Font("Arial", Font.PLAIN, 24));

        JScrollPane scrollPane = new JScrollPane(fortuneArea);

        readButton = new JButton("Generate Fortune");
        readButton.setFont(new Font("Arial", Font.BOLD, 24));
        readButton.addActionListener((ActionEvent e) -> {
            String fortune = getRandomFortune();
            fortuneArea.append(fortune + "\n");
        });

        quitButton = new JButton("Exit");
        quitButton.setFont(new Font("Arial", Font.BOLD, 24));
        quitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });


        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(readButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private String getRandomFortune() {
        int index = lastFortuneIndex;
        while (index == lastFortuneIndex) {
            index = new Random().nextInt(fortunes.size());
        }
        lastFortuneIndex = index;
        return fortunes.get(index);
    }
}