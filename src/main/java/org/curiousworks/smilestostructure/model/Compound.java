package org.curiousworks.smilestostructure.model;

public class Compound {

	String smiles;
	String serializedImage;

	public Compound(String smiles, String serializedImage) {
		super();
		this.smiles = smiles;
		this.serializedImage = serializedImage;
	}

	public Compound(long incrementAndGet, String format) {
		System.out.println("hello " + this);
	}

	public String getSmiles() {
		return smiles;
	}

	public void setSmiles(String smiles) {
		this.smiles = smiles;
	}

	public String getSerializedImage() {
		return serializedImage;
	}

	public void setSerializedImage(String serializedImage) {
		this.serializedImage = serializedImage;
	}

	@Override
	public String toString() {
		return "Compound [smiles=" + smiles + ", serializedImage=" + serializedImage + "]";
	}

}
