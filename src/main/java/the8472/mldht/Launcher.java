package the8472.mldht;

import lbms.plugins.mldht.kad.DHT;


public class Launcher {

	Thread shutdownHook = new Thread(new Runnable() {
		@Override
		public void run() {
			onVmShutdown();
		}
	}, "");
	
	private void onVmShutdown() {
		
	}
	
	void start() {
		
		// set logger
		// read config file
		// start component in config
		
		Runtime.getRuntime().addShutdownHook(shutdownHook);
		
		DHT dht = new DHT();
		dht.start();
		dht.bootstrap();
	}
	
	public static void main(String[] args) {
		new Launcher().start();
	}
	
}
