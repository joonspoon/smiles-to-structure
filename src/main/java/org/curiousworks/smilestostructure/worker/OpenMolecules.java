package org.curiousworks.smilestostructure.worker;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class OpenMolecules {

	public static HtmlImage getStructureUsingJavascript(String smiles)
			throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		HtmlPage name2StucturePage = new WebClient().getPage("http://www.openmolecules.org/name2structure.html");
		HtmlTextInput smilesField = (HtmlTextInput) name2StucturePage.getElementById("sname");
		smilesField.type(smiles);
		name2StucturePage.executeJavaScript("getStructure();");
		return (HtmlImage) name2StucturePage.getElementById("image1");
	}

	public static Image getStructure(String smiles) throws IOException {
		String queryUrl = "http://n2s.openmolecules.org?name=";
		URL url = new URL(queryUrl + smiles);
		return ImageIO.read(url);
	}

	public static void displayImage(Image image) {
		JFrame frame = new JFrame();
		JLabel ic = new JLabel(new ImageIcon(image));
		frame.add(ic);
		frame.pack();
		frame.setVisible(true);
	}

}
