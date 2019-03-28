package lbms.plugins.mldht.kad;

import lbms.plugins.mldht.kad.message.SomeRequest;

public class KBucket {
	
	private boolean ping() {
		RPCServer server = new RPCServer();
		SomeRequest r = new SomeRequest();
		server.doCall(r);
		return false;
	}
}
