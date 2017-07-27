package StockMaintance;

public class FileException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FileException(String message, Exception e) 
    {
        super(message, e);
    }
	public FileException(Exception e) 
    {
        super(e);
    }
	public FileException(String message) 
    {
        super(message);
    }
}
