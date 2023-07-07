package Gui;

import java.awt.*;  // BorderLayout, Color, Dimension, GridLayout
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
// import java.security.SecureRandom; // SecureRandom
import java.util.Base64; // Base64

import javax.swing.*; // JFrame, JLabel, JPanel, JTextField, WindowConstants

public class MainFrame extends JFrame{

  final private Font mainFont = new Font("Arial", Font.PLAIN, 20); // set mainFont
  private JTextField tfFirstName, tfLastName;
  private JLabel lbWelcome;

  /**
   * getGen256RandomKey
   * @return
   */
  private String getGen256RandomKey() throws NoSuchAlgorithmException{

    // SecureRandom random = new SecureRandom();
    // byte[] bytes = new byte[256];

    // random.nextBytes(bytes);
    // String encodedKey = Base64.getEncoder().encodeToString(bytes);

    // System.out.println(encodedKey);

    String sentence = "God will make a way for me";

    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] hash = digest.digest(sentence.getBytes(StandardCharsets.UTF_8));
    String encoded = Base64.getEncoder().encodeToString(hash);

    System.out.println(encoded);

    //
    return encoded;
  }

  /**
   * initialize
   */
  public void initialize() {
    JLabel lbFirstName = new JLabel("First Name");
    lbFirstName.setFont(mainFont);

    JLabel lbLastName = new JLabel("Last Name");
    lbLastName.setFont(mainFont);

    tfFirstName = new JTextField();
    tfLastName = new JTextField();
    tfFirstName.setFont(mainFont);
    tfLastName.setFont(mainFont);

    JPanel fromPanel = new JPanel();
    fromPanel.setLayout(new GridLayout(4, 1, 5, 5));
    fromPanel.add(lbFirstName);
    fromPanel.add(tfFirstName);
    fromPanel.add(lbLastName);
    fromPanel.add(tfLastName);

    lbWelcome = new JLabel("Welcome");
    lbWelcome.setFont(mainFont);

    // make btnOk and btnCancel
    JButton btnOk = new JButton("OK");
    btnOk.setFont(mainFont);
    btnOk.addActionListener(e -> {
      String firstName = tfFirstName.getText();
      String lastName = tfLastName.getText();
      // lbWelcome.setText("Welcome " + firstName + " " + lastName);
      try {
        lbWelcome.setText(getGen256RandomKey());
      } catch (NoSuchAlgorithmException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    });

    JButton btnCancel = new JButton("Cancel");
    btnCancel.setFont(mainFont);
    btnCancel.addActionListener(e -> {
      tfFirstName.setText("");
      tfLastName.setText("");
      lbWelcome.setText("Welcome");
    });

    // make panel for btnOk and btnCancel
    JPanel btnPanel = new JPanel();
    btnPanel.setLayout(new GridLayout(1, 2, 5, 5));
    btnPanel.add(btnOk);
    btnPanel.add(btnCancel);

    // set mainPanel as Jpanel
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBackground(new Color(128, 128, 255));
    mainPanel.add(fromPanel, BorderLayout.NORTH);
    mainPanel.add(lbWelcome, BorderLayout.CENTER);
    mainPanel.add(btnPanel, BorderLayout.SOUTH);

    add(mainPanel);

    setTitle("Gen256RandomKey");
    setSize(800, 800);
    setMinimumSize(new Dimension(500, 500));
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
  }

}
