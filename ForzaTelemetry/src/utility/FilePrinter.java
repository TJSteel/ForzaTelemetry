package utility;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FilePrinter {
	
	private String filename;
	private PrintWriter writer;
	private boolean fileOpen;
	
	public FilePrinter(String filename) {
		this.setFilename(filename);
	}

	public void createFile() {
		try {
			this.setWriter(new PrintWriter(this.getFilename(), "UTF-8"));
			this.setFileOpen(true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			this.setFileOpen(false);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.setFileOpen(false);
		}
	}

	public void closefile() {
		this.getWriter().close();
		this.setFileOpen(false);
	}

	public void writeToFile(String inputString) {
		this.getWriter().println(inputString);
	}

	// {{ getters and setters	
	
	/**
	 * @return the filename
	 */
	private String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	private void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the writer
	 */
	private PrintWriter getWriter() {
		return writer;
	}

	/**
	 * @param writer the writer to set
	 */
	private void setWriter(PrintWriter writer) {
		this.writer = writer;
	}

	/**
	 * @return the fileOpen
	 */
	public boolean isFileOpen() {
		return fileOpen;
	}

	/**
	 * @param fileOpen the fileOpen to set
	 */
	private void setFileOpen(boolean fileOpen) {
		this.fileOpen = fileOpen;
	}
	// }}
}
