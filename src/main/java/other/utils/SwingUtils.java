package other.utils;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class SwingUtils {
	public static String getTextFromSelectedButtonGroup(ButtonGroup bg) {
		Enumeration<AbstractButton> en = bg.getElements();
		while (en.hasMoreElements()) {
			AbstractButton ab = en.nextElement();
			if (ab.isSelected()) {
				return ab.getText();
			}
		}
		return null;
	}
}
