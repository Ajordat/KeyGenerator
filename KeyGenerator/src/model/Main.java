package model;

import javax.swing.SwingUtilities;

import controller.ButtonController;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				MainWindow view = new MainWindow();
				
				ButtonController controller = new ButtonController(view);
				view.registerController(controller);
				
				view.setVisible(true);
				
			}
		});

	}

}
