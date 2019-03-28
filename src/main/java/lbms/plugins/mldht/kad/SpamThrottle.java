package lbms.plugins.mldht.kad;

import java.net.InetAddress;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.function.BiFunction;

public class SpamThrottle {
	
	private HashMap<InetAddress, Integer> hitCounter = new HashMap<InetAddress, Integer>();
	private static final int BURST = 10;
	
	public boolean isSpam(InetAddress addr) {
	
		//BiFunction<T, U, R>
		
		BiFunction<? super InetAddress, ? super Integer, ? extends Integer> remappingFunction = null;
		int updated = hitCounter.compute(addr, remappingFunction);

		int old = hitCounter.get(addr);
		if (old == 0)
			hitCounter.put(addr, 1);
		else
			hitCounter.put(addr, Math.min(old + 1, BURST));
		
		return false;
	}
	
	long lastDecayTime = 0L;
	
	public void decay() {
		
		//Calendar c = Calendar.getInstance();
		long now = System.currentTimeMillis();
		long delta = lastDecayTime - now;
		
		//BiFunction<? super InetAddress, ? super Integer, ? extends Integer> function = null;
		//hitCounter.replaceAll(function);
		
		// loop the map
		// and replace all values
		
		Set<InetAddress> keys = hitCounter.keySet();
		for (Iterator<InetAddress> itor = keys.iterator(); itor.hasNext();) {
			String key = itor.next().toString();
			int value = hitCounter.get(key);
		}
	}
}
