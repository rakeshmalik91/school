package server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
 
public class DNSServer extends UnicastRemoteObject implements DNSServerInterface {
	private HashMap<String, String> map=new HashMap<>();
    private DNSServer() throws RemoteException {}
	@Override
    public String getIP(String name) {
		if(map.containsKey(name))
			return map.get(name);
		else
			return "Not Found!!!";
    }
	private void loadDomainNames() {
		InputStreamReader in = new InputStreamReader(getClass().getResourceAsStream("/server/name"));
		int length=1;
		String sbuf="";
		try {
			while(length>0){
				char cbuf[]=new char[10000];
				length=in.read(cbuf);
				try{
					sbuf=sbuf+String.valueOf(cbuf, 0, length);
				}catch(StringIndexOutOfBoundsException ex){}
			}
			String[] str=sbuf.split("\n");
			for(String line : str) {
				map.put(line.split(" ")[0], line.split(" ")[1]);
			}
			in.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex, "Security File Load Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
    public static void main(String args[]) {
		System.setProperty("java.security.policy", "no.policy");
        System.out.println("RMI server started");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
            System.out.println("Security manager installed.");
        } else
			JOptionPane.showMessageDialog(null, "Security manager already exists.", "Security Manager Error", JOptionPane.ERROR_MESSAGE);
        try {
            LocateRegistry.createRegistry(1099); 
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, e, "Server Registry Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
        }
		String ip="";
        try {
            ip = JOptionPane.showInputDialog(null, "IP", InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(DNSServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DNSServer dnsServer = new DNSServer();
            Naming.bind("//"+ip+"/DNSServer", dnsServer);
            System.out.println("PeerServer bound in registry");
			dnsServer.loadDomainNames();
			new ServerWindow();
        } catch (RemoteException | AlreadyBoundException | MalformedURLException e) {
            JOptionPane.showMessageDialog(null, e, "Server Bind Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(0);
        }
    }
}