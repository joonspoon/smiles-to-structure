package org.curiousworks.smilestostructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.IOUtils;
import org.curiousworks.smilestostructure.worker.OpenMolecules;
import org.junit.jupiter.api.Test;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

class OpenMoleculesTest {

	@Test
	void testConnectingToOpenMolecules() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		WebClient webClient = new WebClient();
		HtmlPage page = webClient.getPage("http://www.openmolecules.org/name2structure.html");
		assertEquals("www.openmolecules.org", page.getTitleText());
	}

	@Test
	public void testJavascriptMethod() throws Exception {
		HtmlImage image = OpenMolecules
				.getStructureUsingJavascript("Cc1c(sc(n1)NC(=N)N)c2ccc(cc2)NC(=O)C3CC4(CCNCC4)CN3");
		File imageFile = new File("structure.jpg");
		image.saveAs(imageFile);
		FileInputStream fis = new FileInputStream(imageFile);
		String rawImage = IOUtils.toString(fis, "UTF-8");
		assertTrue(rawImage.contains("PNG"));
		imageFile.delete();
	}

	@Test
	public void testThis() throws Exception {
		String smiles = "Cc1nc(cc(n1)N2CCN(CC2)C)Nc3cc(ccn3)Nc4nc(ns4)c5ccccc5";
		Image structure = OpenMolecules.getStructure(smiles);
		assertEquals(360, structure.getHeight(null));
	}
	
	@Test
	public void testDisplayImage() throws Exception {
		String smiles = "Cc1c(sc(n1)NC(=N)N)c2ccc(cc2)NC(=O)C3CC4(CCNCC4)CN3";
		OpenMolecules.displayImage(OpenMolecules.getStructure(smiles));
		Thread.sleep(10000);
	}
}
