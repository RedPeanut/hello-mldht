package lbms.plugins.mldht.kad;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.LinkedHashMap;

import lbms.plugins.mldht.kad.message.MessageBase;
import lbms.plugins.mldht.kad.utils.Selectable;

public class RPCServer {

	LinkedHashMap<InetAddress, InetSocketAddress> originPairs;
	RPCServerManager manager;
	
	RPCServer() {}
	
	RPCServer(RPCServerManager manager, InetAddress addr, int port) {
		this.manager = manager;
	}
	
	void updatePublicIPConsensus(InetAddress source, InetSocketAddress addr) {
		
	}
	
	public void start() {
		
	}
	
	public void stop() {
		
	}
	
	private void handlePacket() {
		
	}
	
	private class SocketHandler implements Selectable {
		
		DatagramChannel channel;
		
		public SocketHandler() {
			try {
				channel = DatagramChannel.open();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void selectionEvent() {
			readEvent();
		}
		
		private void readEvent() {
			
			// call handlePacket in a scheduler
			
			handlePacket();
			
		}
	}
	
	private class EnqueuedSend {
		
	}

	public RPCCall doCall(MessageBase msg) {
		RPCCall c = new RPCCall();
		dispatchCall(c);
		return c;
	}
	
	private void dispatchCall(RPCCall call) {
		MessageBase msg = call.getRequest();
		sendMessage(msg);
		//call.addListener(null);
		//call.start();
	}
	
	public void sendMessage(MessageBase msg) {
		send(msg.getDestination(), msg.encode());
	}
	
	private DatagramSocket sock;
	private void send(InetSocketAddress addr, byte[] msg) {
		try {
			DatagramPacket p = new DatagramPacket(msg, msg.length);
			p.setSocketAddress(addr);
			sock.send(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//public static void main(String[] args) {
	
		/*
		Collection<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee(1000000));
		emps.add(new Employee(2000000));
		emps.add(new Employee(3000000));
		emps.add(new Employee(4000000));
		emps.add(new Employee(3000000));

		emps.stream()
			.collect(Collectors.groupingBy(e -> e.getSalary()));
		*/
		
		/*
		int sum = 0, count = 0;
		for (Employee emp: emps) {
			if (emp.getSalary() > 3000000) {
				sum += emp.getSalary();
				count++;
			}
		}
		System.out.println("sum = " + sum);
		
		emps.stream();
		sum = emps.stream()
			.filter(x -> x.getSalary() > 3000000)
			.mapToInt(x -> x.getSalary())
			.sum();
		System.out.println("sum = " + sum);
		*/
		
		/*
		RPCServer rs = new RPCServer();
		rs.originPairs.values();
		InetSocketAddress isa = new InetSocketAddress(0);
		//isa.stream();
		//InetAddress ia = new InetAddress();
		Stream<InetSocketAddress> s;
		*/
	//}
}
