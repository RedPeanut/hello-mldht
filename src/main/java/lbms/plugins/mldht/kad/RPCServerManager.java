package lbms.plugins.mldht.kad;

import java.net.InetAddress;

public class RPCServerManager {

	private void newServer(InetAddress addr) {
		RPCServer srv = new RPCServer(this, addr, 0);
		srv.start();
	}
	
	private void startNewServers() {
		InetAddress rebindAddress = null;
		newServer(rebindAddress);
	}
	
	public void refresh(long now) {
		startNewServers();
	}
	
}
