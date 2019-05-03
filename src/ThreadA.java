
public class ThreadA {

	public static void main(String[] args) throws InterruptedException {
		ThreadB b=new ThreadB();
		b.start();

		/*1.mandate to be synchronized
		 * 2.synchronized block on the object of thread b
		 * 3.synchronized(object name)=object name.wait()
		 * 4.object on which you call wait will be same as synchronized block
		 */
		/*
		 * 1.main thread sleeps so that child thread gets the chance to execute.
	     because if it does not sleeps then scheduler may give the chance to
	     main thread or to child thread to execute.
	     2.till the time,main thread sleeps,child thread runs and may die after that.
	     In that case,main thread will continue waiting for the child thread but since
	     its dead main thread will never get the chance to execute.
	     3.Thus,we can avoid this by limiting the time period to wait.
		 */
		Thread.sleep(1000);

		synchronized(b)
		{
			System.out.println("main thread trying to call wait method");
			b.wait(1000);
		}
		System.out.println("main thread got notification"); 
		System.out.println(b.total);
	}
}
