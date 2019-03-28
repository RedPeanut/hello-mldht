package lbms.plugins.mldht.kad;

import lbms.plugins.mldht.kad.message.MessageBase;

public class RPCCall {
	MessageBase msg;
	
	public MessageBase getRequest() {
		return this.msg;
	}
}
