import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookStoreApp extends JFrame {
    private Book[] books;
    private int bookCount;

    public BookStoreApp() {
        books = new Book[3];
        bookCount = 0;

        setTitle("Aplikasi Toko Buku");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Judul:");
        JTextField titleField = new JTextField();
        JLabel authorLabel = new JLabel("Nama Pengarang:");
        JTextField authorField = new JTextField();
        JLabel publisherLabel = new JLabel("Penerbit:");
        JTextField publisherField = new JTextField();
        JLabel yearLabel = new JLabel("Tahun Cetak:");
        JTextField yearField = new JTextField();
        JLabel categoryLabel = new JLabel("Kategori:");
        JComboBox<String> categoryComboBox = new JComboBox<>(new String[]{"Semua umur", "Remaja", "Dewasa", "Anak-anak"});

        JButton addButton = new JButton("Tambah Buku");
        JButton showButton = new JButton("Lihat Buku");

        gbc.insets = new Insets(5, 5, 5, 5); // margin
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(titleLabel, gbc);
        gbc.gridx = 1;
        add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(authorLabel, gbc);
        gbc.gridx = 1;
        add(authorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(publisherLabel, gbc);
        gbc.gridx = 1;
        add(publisherField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(yearLabel, gbc);
        gbc.gridx = 1;
        add(yearField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(categoryLabel, gbc);
        gbc.gridx = 1;
        add(categoryComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(addButton, gbc);
        gbc.gridx = 1;
        add(showButton, gbc);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bookCount < 3) {
                    String judul = titleField.getText();
                    String pengarang = authorField.getText();
                    String penerbit = publisherField.getText();
                    int tahun_terbit = Integer.parseInt(yearField.getText());
                    String kategori = (String) categoryComboBox.getSelectedItem();

                    books[bookCount] = new Book(judul, pengarang, penerbit, tahun_terbit, kategori);
                    bookCount++;
                    JOptionPane.showMessageDialog(null, "Buku berhasil ditambahkan!");
                } else {
                    JOptionPane.showMessageDialog(null, "Data buku penuh!");
                }
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder bookList = new StringBuilder("<html><div style='text-align: center;'>Data Buku:<br/><br/>");
                for (int i = 0; i < bookCount; i++) {
                    Book book = books[i];
                    bookList.append("Judul: ").append(book.getTitle()).append("<br/>");
                    bookList.append("Pengarang: ").append(book.getAuthor()).append("<br/>");
                    bookList.append("Penerbit: ").append(book.getPublisher()).append("<br/>");
                    bookList.append("Tahun Cetak: ").append(book.getYear()).append("<br/>");
                    bookList.append("Kategori: ").append(book.getCategory()).append("<br/><br/>");
                }
                bookList.append("</div></html>");
                JOptionPane.showMessageDialog(null, bookList.toString());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BookStoreApp().setVisible(true);
            }
        });
    }
}

class Book {
    private String judul;
    private String pengarang;
    private String penerbit;
    private int tahun_terbit;
    private String kategori;

    public Book(String judul , String pengarang, String penerbit, int tahun_terbit, String kategori) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahun_terbit = tahun_terbit;
        this.kategori = kategori;
    }

    // Getters and Setters
    public String getTitle() { return judul; }
    public void setTitle(String judul) { this.judul = judul; }
    public String getAuthor() { return pengarang; }
    public void setAuthor(String pengarang) { this.pengarang = pengarang; }
    public String getPublisher() { return penerbit; }
    public void setPublisher(String penerbit) { this.penerbit = penerbit; }
    public int getYear() { return tahun_terbit; }
    public void setYear(int tahun_terbit) { this.tahun_terbit = tahun_terbit; }
    public String getCategory() { return kategori; }
    public void setCategory(String kategori) { this.kategori = kategori; }
}
