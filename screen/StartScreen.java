package screen;

import asciiPanel.AsciiPanel;


public class StartScreen extends RestartScreen {

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("This is a maze game.", 0, 0);
        terminal.write("Press ENTER to continue...", 0, 1);
    }

}
