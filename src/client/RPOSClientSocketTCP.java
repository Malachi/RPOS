package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import common.ADTSocketTCP;

/**
 * A socket class used by clients to connect to a remote host.
 */
public class RPOSClientSocketTCP extends ADTSocketTCP {
	private Socket socket;
	
	/**
	 * Constructs a new socket object to be used for client connections.
	 * @param address the address of the remote host being connected too
	 * @param commPort the local port used for the communication
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public RPOSClientSocketTCP(InetAddress address, int commPort) throws UnknownHostException, IOException {
		super(address, commPort);
		
		initialize(address, commPort);
	}
	public void initialize(InetAddress address, int commPort) throws IOException {
		socket = new Socket(address, commPort);
		
		// bind input and output streams to this socket
		setInputStream(new BufferedReader(new InputStreamReader(socket.getInputStream())));
		setOutputStream(new PrintStream(socket.getOutputStream()));
	}
	public void connect() {
		// TODO implement soon
		//socket.connect(endpoint);
	}
	public void connect(int timeout) {
		// TODO implement soon
		//socket.connect(endpoint, timeout);
	}
	@Override
	public void close() throws IOException {
		this.getInputStream().close();
		this.getOutputStream().close();
		socket.close();
	}
	@Override
	public boolean isBound() {
		return socket.isBound();
	}
	@Override
	public boolean isClosed() {
		return socket.isClosed();
	}
	@Override
	public boolean isConnected() {
		return socket.isConnected();
	}
	@Override
	public String receive() throws IOException {
		String line = null;
		String allData = null;
		while ((line = this.getInputStream().readLine()) != null) {
			allData += line;
		}
		return allData;
	}
	@Override
	public void send(String data) {
		this.getOutputStream().print(data);
	}
}
