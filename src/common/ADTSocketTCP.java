package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * An abstract data type for a socket, designed
 * to be inherited by more specific socket types.
 */
public abstract class ADTSocketTCP implements ISocket {
	private int inPort = 0;
	private int outPort = 0;
	private String remoteHostIP = "";
	private String localHostIP = "";
	private BufferedReader inputStream;
	private PrintStream outputStream;
	
	public ADTSocketTCP() {
		// initialize fields to sane values
		inPort = 0;
		outPort = 0;
		remoteHostIP = "";
		localHostIP = "";
	}
	
	public ADTSocketTCP(InetAddress address, int commPort) throws UnknownHostException, IOException {
		// initialize fields to sane values
		this();
		
		initialize(address, commPort);
	}
	
	public abstract void initialize(InetAddress address, int commPort) throws IOException;
	public abstract void send(String data);
	public abstract String receive() throws IOException;
	public abstract void close() throws IOException;
	
	/**
	 * Sets the port to listen to incoming data on.
	 * @param inPort the inPort to set
	 */
	public void setInPort(int inPort) {
		this.inPort = inPort;
	}
	/**
	 * Gets the port to listen to incoming data on.
	 * @return the inPort
	 */
	public int getInPort() {
		return inPort;
	}
	/**
	 * Sets the port to transmit outgoing data on.
	 * @param outPort the outPort to set
	 */
	public void setOutPort(int outPort) {
		this.outPort = outPort;
	}
	/**
	 * Gets the port outgoing data is transmitted on.
	 * @return the outPort
	 */
	public int getOutPort() {
		return outPort;
	}
	/**
	 * @param remoteHostIP the remoteHostIP to set
	 */
	public void setRemoteHostIP(String remoteHostIP) {
		this.remoteHostIP = remoteHostIP;
	}
	/**
	 * @return the remoteHostIP
	 */
	public String getRemoteHostIP() {
		return remoteHostIP;
	}
	/**
	 * @param localHostIP the localHostIP to set
	 */
	public void setLocalHostIP(String localHostIP) {
		this.localHostIP = localHostIP;
	}
	/**
	 * @return the localHostIP
	 */
	public String getLocalHostIP() {
		return localHostIP;
	}
	
	public abstract boolean isBound();
	public abstract boolean isClosed();
	public abstract boolean isConnected();

	/**
	 * @param inputStream the inputStream to set
	 */
	protected void setInputStream(BufferedReader inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * @return the inputStream
	 */
	protected BufferedReader getInputStream() {
		return inputStream;
	}

	/**
	 * @param outputStream the outputStream to set
	 */
	protected void setOutputStream(PrintStream outputStream) {
		this.outputStream = outputStream;
	}

	/**
	 * @return the outputStream
	 */
	protected PrintStream getOutputStream() {
		return outputStream;
	}
}
