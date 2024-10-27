package Thread1;

import java.util.Arrays;
import java.util.Scanner;

class Laptop implements Runnable
{
	String lapName;
	WifiNetwork wifinetwork;
	public Laptop(String lapName, WifiNetwork wifinetwork) {
		super();
		this.lapName = lapName;
		this.wifinetwork = wifinetwork;
	}
	
	@Override
	public void run() {
		wifinetwork.connectedDevices(this);
	}

	@Override
	public String toString() {
		return "Laptop [lapName=" + lapName + ", wifinetwork=" + wifinetwork + "]";
	} 
	
}
class WifiNetwork{
	String ssid;
	String password;
	Laptop[] connectedDevices;
	int deviceCount;
	int capacity;
	public WifiNetwork(String ssid, String password, int capacity) {
		super();
		this.ssid = ssid;
		this.password = password;
		this.capacity = capacity;
		connectedDevices=new Laptop[capacity];
		
	}
	public void connectedDevices(Laptop laptop){
		System.out.println("<"+Thread.currentThread().getName()+">:<"+laptop.lapName+">");
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		if(Math.random() > 0.3 && deviceCount < capacity)
		{
			connectedDevices[deviceCount++]=laptop;
			System.out.println("connection is successfully..........");
		}
		else
		{
			System.out.println(laptop.lapName+"is not connected");
		}
	}
	public void showConnectDevices()
	{
		for(int i=0;i<deviceCount;i++)
		{
			System.out.println(connectedDevices[i]);
		}
	}
	@Override
	public String toString() {
		return "WifiNetwork [ssid=" + ssid + ", password=" + password +  ", deviceCount=" + deviceCount + ", capacity=" + capacity + "]";
	}
	
}
public class Therad2 {

	public static void main(String[] args) throws InterruptedException {
		WifiNetwork en=new WifiNetwork("ABC@123","abc123",10);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter how many laptop you want to connect? ");
		int numOfLaptop=sc.nextInt();
		for(int i=1;i<=numOfLaptop;i++)
		{
			Laptop l=new Laptop("Laptop"+(i),en);
			Thread th=new Thread(l);
			th.start();
			th.join();
		}
		System.out.println("all connected devices are: ");
		en.showConnectDevices();

	}

}















