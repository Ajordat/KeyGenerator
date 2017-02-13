package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import model.KeyGenerator;
import view.MainWindow;

public class ButtonController implements ActionListener{

	private MainWindow view;
	
	public ButtonController(MainWindow view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int n = view.getNumber();
		if(n==0){
			view.showUser("Enter a valid number of characters.");
			return;
		}
		boolean[] conds = view.getConditions();
		boolean flag = false;
		for(boolean b : conds){
			if(b) flag = true;
		}
		if(!flag){
			view.showUser("Mark a type of character.");
			return;
		}
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				view.showUser(KeyGenerator.generate(n, conds));
			}
		});
	}

}
