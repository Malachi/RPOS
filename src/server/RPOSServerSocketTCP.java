package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import common.ADTSocketTCP;

/**
 * A socket class used by a host to allow client connections.
 */
public class RPOSServerSocketTCP extends ADTSocketTCP {
	private ServerSocket socket;
	
	public RPOSServerSocketTCP(InetAddress address, int listeningPort) throws IOException {
		super(address, listeningPort);
			
		initialize(address, listeningPort);
	}
	public void initialize(InetAddress address, int listeningPort) throws IOException {
		socket = new ServerSocket(listeningPort);
	}
	public Socket listen() throws IOException {
		// listen for requests and accept when someone tries to connect
		Socket temp = socket.accept();
		
		// bind input and output streams to this socket
		setInputStream(new DataInputStream(temp.getInputStream()));
		setOutputStream(new PrintStream(temp.getOutputStream()));
		
		return temp;
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
		return false;
	}
	@Override
	public String receive() throws IOException {
		byte buffer[] = null;
		this.getInputStream().read(buffer);
		return null; // TODO make this a string
	}
	@Override
	public void send(String data) {
		this.getOutputStream().print(data);
	}
}
