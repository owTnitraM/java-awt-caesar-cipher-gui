import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private final CipherModel cipherModel;
    private final View view;

    public Controller() {
        this.cipherModel = new CipherModel();
        this.view = new View();

        view.setChangeModeButtonActionListener(e -> onModeChange());
        view.setExecuteActionButtonActionListener(e -> onExecuteAction());
    }

    public Controller(CipherModel cipherModel, View view) {
        this.cipherModel = cipherModel;
        this.view = view;

        view.setChangeModeButtonActionListener(e -> onModeChange());
        view.setExecuteActionButtonActionListener(e -> onExecuteAction());
    }

    private void onModeChange() {
        cipherModel.setEncodeMode(!cipherModel.isEncodeMode());
        if (cipherModel.isEncodeMode()) {
            view.setTopInputLabelText("Plain Text");
            view.setBottomInputLabelText("Cipher Text");
            view.setExecuteActionButtonText("Encode");
        } else {
            view.setTopInputLabelText("Cipher Text");
            view.setBottomInputLabelText("Plain Text");
            view.setExecuteActionButtonText("Decode");
        }
    }

    private void onExecuteAction() {
        int key;
        try {
            key = Integer.parseInt(view.getKeyText());
        } catch (Exception e){
            view.setBottomInputText("Not a Number: Key must be a java Integer");
            return;
        }
        String text = view.getTopInputText();
        if (cipherModel.isEncodeMode()) {
            view.setBottomInputText(cipherModel.encode(key, text));
        } else {
            view.setBottomInputText(cipherModel.decode(key, text));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
