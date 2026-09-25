import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class View {
    Frame frame = new Frame("Caesar Cipher");

    Label mainLabel = new Label("Cifra de Cesar");

    Label keyLabel = new Label("Key");
    TextField keyTextField = new TextField(4);

    Label topInputLabel = new Label("Plain Text");
    TextArea topInputTextArea = new TextArea("", 10, 50, TextArea.SCROLLBARS_VERTICAL_ONLY);

    Label bottomInputLabel = new Label("Cipher Text");
    TextArea bottomInputTextArea = new TextArea("", 10, 50, TextArea.SCROLLBARS_VERTICAL_ONLY);

    Panel keyInputPanel = new Panel();

    Panel topInputPanel = new Panel();

    Panel keyTopInputPanel = new Panel();

    Panel bottomInputPanel = new Panel();

    Panel mainInputsPanel = new Panel(new BorderLayout());

    Button changeModeButton = new Button("Change Mode");
    Button executeActionButton = new Button("Encode");

    Panel buttonPanel = new Panel();

    public View() {
        this.buildWindow(500, 500);
    }

    private void buildWindow(int windowWidth, int windowHeight) {

        mainLabel.setAlignment(1);

        keyInputPanel.setLayout(new BorderLayout());
        keyInputPanel.add(keyLabel, BorderLayout.NORTH);
        keyInputPanel.add(keyTextField, BorderLayout.CENTER);

        topInputPanel.setLayout(new BorderLayout());
        topInputPanel.add(topInputLabel, BorderLayout.NORTH);
        topInputPanel.add(topInputTextArea, BorderLayout.CENTER);

        keyTopInputPanel.setLayout(new BorderLayout());
        keyTopInputPanel.add(keyInputPanel, BorderLayout.WEST);
        keyTopInputPanel.add(topInputPanel, BorderLayout.CENTER);

        bottomInputPanel.setLayout(new BorderLayout());
        bottomInputPanel.add(bottomInputLabel, BorderLayout.NORTH);
        bottomInputPanel.add(bottomInputTextArea, BorderLayout.CENTER);

        mainInputsPanel.setLayout(new BorderLayout());
        mainInputsPanel.add(keyTopInputPanel, BorderLayout.NORTH);
        mainInputsPanel.add(bottomInputPanel, BorderLayout.SOUTH);

        buttonPanel.add(executeActionButton);
        buttonPanel.add(changeModeButton);

        frame.setLayout(new BorderLayout());
        frame.setSize(windowWidth, windowHeight);
        frame.setVisible(true);

        frame.add(mainLabel, BorderLayout.NORTH);
        frame.add(mainInputsPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        this.setListeners();

    }

    private void setListeners() {
        frame.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );

        changeModeButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }
        );

        executeActionButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }
        );
    }

    public void setChangeModeButtonActionListener(ActionListener listener) {
        changeModeButton.addActionListener(listener);
    }

    public void setExecuteActionButtonActionListener(ActionListener listener) {
        executeActionButton.addActionListener(listener);
    }

    public String getKeyText() {
        return keyTextField.getText();
    }

    public String getTopInputText() {
        return topInputTextArea.getText();
    }

    public String getBottomInputText() {
        return bottomInputTextArea.getText();
    }

    public void setTopInputLabelText(String text) {
        topInputLabel.setText(text);
    }

    public void setBottomInputLabelText(String text) {
        bottomInputLabel.setText(text);
    }

    public void setTopInputText(String text) {
        topInputTextArea.setText(text);
    }

    public void setBottomInputText(String text) {
        bottomInputTextArea.setText(text);
    }

    public void setExecuteActionButtonText(String text) {
        executeActionButton.setLabel(text);
    }
}
