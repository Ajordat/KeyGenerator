import controller.ButtonController;
import view.MainWindow;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {

			MainWindow view = new MainWindow();

			ButtonController controller = new ButtonController(view);
			view.registerController(controller);

			view.setVisible(true);

		});

	}

}
