import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditorFrame extends JFrame {
    private JTextArea textArea;
    private JFileChooser fileChooser;

    public TextEditorFrame() {
        setTitle("Java Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(createMenuBar(), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        fileChooser = new JFileChooser();
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");

        openItem.addActionListener(e -> TextEditorFunctions.openFile(textArea, fileChooser, this));
        saveItem.addActionListener(e -> TextEditorFunctions.saveFile(textArea, fileChooser, this));

        fileMenu.add(openItem);
        fileMenu.add(saveItem);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        JMenuItem findReplaceItem = new JMenuItem("Find & Replace");

        cutItem.addActionListener(e -> textArea.cut());
        copyItem.addActionListener(e -> textArea.copy());
        pasteItem.addActionListener(e -> textArea.paste());
        findReplaceItem.addActionListener(e -> TextEditorFunctions.findAndReplace(textArea));

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.add(findReplaceItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        return menuBar;
    }
}
