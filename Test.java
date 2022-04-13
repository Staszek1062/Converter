package converter;

import javax.swing.SwingUtilities;
import converter.Panel.Panel;
 
public class Test {
	public static void main(final String[] args) {
	   SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Panel().setVisible(true);
			}
		});
	}
}
