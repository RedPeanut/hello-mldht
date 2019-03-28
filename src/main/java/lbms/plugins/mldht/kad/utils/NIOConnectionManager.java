package lbms.plugins.mldht.kad.utils;

import java.io.IOException;
import java.nio.channels.Selector;

public class NIOConnectionManager {
	
	Runnable run = new Runnable() {
		@Override
		public void run() {
		}
	};
	
	/*
	Runnable run2 = () -> {
		
	};
	*/
	
	private void ensureRunning() {
		new Thread(run);
	}
	
	public static void main(String[] args) {
		try {
			Selector selector = Selector.open();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
