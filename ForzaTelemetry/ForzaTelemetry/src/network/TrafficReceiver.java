/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Jay
 */
public class TrafficReceiver {

	// {{ Variables
    private int port;
    private DatagramSocket dataSock;
    private DatagramPacket dataPack;
    private byte[] receivedBytes;
    private boolean running;
    // }} Variables
    
    public void initialize(int port) {

        this.setPort(port);
		this.setDataSock(this.getPort());
        this.setReceivedBytes(232);
        this.setDataPack(this.getReceivedBytes());

    }

    public void receiveTraffic() {
        try {
			this.getDataSock().receive(this.getDataPack());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    // {{ Getters and Setters
    public InetAddress getAddress(){
        return this.getDataPack().getAddress();
    }
    /**
     * @return the port
     */
    private int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    private void setPort(int port) {
        this.port = port;
    }

    /**
     * @return the dataSock
     */
    private DatagramSocket getDataSock() {
        return dataSock;
    }

    /**
     * @param port the port to look on the network for
     */
    private void setDataSock(int port) {
        try {
			this.dataSock = new DatagramSocket(port);
			this.setRunning(true);
		} catch (SocketException e) {
			this.setRunning(false);
			e.printStackTrace();
		}
    }

    /**
     * @return the dataPack
     */
    public DatagramPacket getDataPack() {
        return dataPack;
    }

    /**
     * @param receivedBytes setup dataPack by giving it a byte array
     */
    private void setDataPack(byte[] receivedBytes) {
        this.dataPack = new DatagramPacket(receivedBytes, receivedBytes.length);
    }

    /**
     * @return the receivedBytes
     */
    private byte[] getReceivedBytes() {
        return receivedBytes;
    }

    /**
     * @param length the length of the expected bytes to receive
     */
    private void setReceivedBytes(int length) {
        this.receivedBytes = new byte[length];
    }

	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * @param running the running to set
	 */
	private void setRunning(boolean running) {
		this.running = running;
	}
    // }} Getters and Setters
}
