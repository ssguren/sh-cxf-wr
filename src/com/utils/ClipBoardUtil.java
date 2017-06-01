package com.utils;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipBoardUtil {

	/**
	 * If a string is on the system clipboard, this method returns it; otherwise
	 * it returns null.
	 */
	public static String getClipboard_Txt() {
		Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard()
				.getContents(null);

		try {
			if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				String text = (String) t
						.getTransferData(DataFlavor.stringFlavor);
				return text;
			}
		} catch (UnsupportedFlavorException e) {
		} catch (IOException e) {
		}

		return null;
	}

	/**
	 * This method writes a string to the system clipboard. otherwise it returns
	 * null.
	 */
	public static void setClipboard(String str) {
		StringSelection ss = new StringSelection(str);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	}

	/**
	 * Getting an Image on the System Clipboard If an image is on the system
	 * clipboard, this method returns it; otherwise it returns null.
	 */
	public static Image getClipboard_Img() {
		Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard()
				.getContents(null);

		try {
			if (t != null && t.isDataFlavorSupported(DataFlavor.imageFlavor)) {
				Image image = (Image) t.getTransferData(DataFlavor.imageFlavor);
				return image;
			}
		} catch (UnsupportedFlavorException e) {
		} catch (IOException e) {
		}

		return null;
	}

	/**
	 * Setting an image on the system clipboard requires a custom Transferable
	 * object to hold the image while on the clipboard. This method writes a
	 * image to the system clipboard. otherwise it returns null.
	 */
	public static void setClipboard(Image image) {
		ImageSelection imgSel = new ImageSelection(image);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imgSel,
				null);
	}

	/** This class is used to hold an image while on the clipboard. */
	private static class ImageSelection implements Transferable {
		private Image image;

		public ImageSelection(Image image) {
			this.image = image;
		}

		// Returns supported flavors
		public DataFlavor[] getTransferDataFlavors() {
			return new DataFlavor[] { DataFlavor.imageFlavor };
		}

		// Returns true if flavor is supported
		public boolean isDataFlavorSupported(DataFlavor flavor) {
			return DataFlavor.imageFlavor.equals(flavor);
		}

		// Returns image
		public Object getTransferData(DataFlavor flavor)
				throws UnsupportedFlavorException, IOException {
			if (!DataFlavor.imageFlavor.equals(flavor)) {
				throw new UnsupportedFlavorException(flavor);
			}

			return image;
		}
	}

	public static void main(String[] args) {
		String s = "abc\tedf\njhf";
		setClipboard(s);
		System.out.println(getClipboard_Txt());
	}
}