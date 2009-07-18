package common;

import java.io.IOException;
import java.net.InetAddress;

public interface ISocket {
	void initialize(InetAddress address, int commPort) throws IOException;
	void send(String data);
	String receive() throws IOException;
	void close() throws IOException;
	boolean isBound();
	boolean isConnected();
	boolean isClosed();
}
