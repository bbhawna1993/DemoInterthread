
public class ThreadB extends Thread{

	int total=0;
	public void run()
	{/*mandate to call notify in synchronized block*/
		synchronized(this) {
			System.out.println("child thread starts calculation");
			for(int i=0;i<=100;i++)
			{total+=i;}
			System.out.println("child thread will notify main thread");
			this.notify();
		}
	}
}
