package lbms.plugins.mldht.kad;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	public static class RoutingTableEntry {
		
	}
	
	List<RoutingTableEntry> routingTableCOW = new ArrayList<RoutingTableEntry>();
	
	public Node() {
		routingTableCOW.add(new RoutingTableEntry());
	}
	
	/**
	 * Loads the routing table from a file
	 */
	public void loadTable() {
		
	}
	
}
