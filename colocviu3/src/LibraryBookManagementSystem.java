import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class LibraryBookManagementSystem extends JFrame { //problem 2
    private ArrayList<Book> bookRecords;
    private JTextField titleField, authorField;
    private JTextArea displayArea;

    public LibraryBookManagementSystem() {
        bookRecords = new ArrayList<>();


        setTitle("Library Book Management System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JLabel titleLabel = new JLabel("Title:");
        JLabel authorLabel = new JLabel("Author:");
        titleField = new JTextField();
        authorField = new JTextField();
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");
        JButton displayButton = new JButton("Display");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");
        displayArea = new JTextArea();

        //panel input utilizator
        inputPanel.add(titleLabel);
        inputPanel.add(titleField);
        inputPanel.add(authorLabel);
        inputPanel.add(authorField);
        inputPanel.add(addButton);
        inputPanel.add(searchButton);

        //action listener
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                if (author.equals("") || title.equals("")) {
                    JOptionPane.showMessageDialog(null, "Book name or title invalid!");
                } else {
                    Book book = new Book(title, author);
                    bookRecords.add(book);
                    titleField.setText("");
                    authorField.setText("");
                    displayArea.append("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + "\n");
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean found = false;
                String searchTerm = JOptionPane.showInputDialog(null, "Enter the name of the book:");
                displayArea.setText("");
                for (Book book : bookRecords) {
                    if (book.getTitle().equalsIgnoreCase(searchTerm)) {
                        displayArea.append("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + "\n");
                        found = true;
                    }
                }
                if (found == false) {
                    JOptionPane.showMessageDialog(null, "The book was not found!");
                }
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("");
                for (Book book : bookRecords) {
                    displayArea.append("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + "\n");
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int userChoice = fileChooser.showSaveDialog(null);

                if (userChoice == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();

                    try {
                        FileOutputStream fileOut = new FileOutputStream(filePath);
                        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                        objectOut.writeObject(bookRecords);
                        objectOut.close();
                        JOptionPane.showMessageDialog(null, "Book records saved successfully!");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });


        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int userChoice = fileChooser.showOpenDialog(null);

                if (userChoice == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();

                    try {
                        FileInputStream fileIn = new FileInputStream(filePath);
                        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                        bookRecords = (ArrayList<Book>) objectIn.readObject();
                        objectIn.close();
                        displayArea.setText("");
                        for (Book book : bookRecords) {
                            displayArea.append("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + "\n");
                        }
                        JOptionPane.showMessageDialog(null, "Book records loaded successfully!");
                    } catch (IOException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        //button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(displayButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        //main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LibraryBookManagementSystem bookManagementSystem = new LibraryBookManagementSystem();
                bookManagementSystem.setVisible(true);
            }
        });
    }

    public ArrayList<Book> getBookRecords() {
        return bookRecords;
    }
}

