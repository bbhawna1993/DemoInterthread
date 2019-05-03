
public class ThreadA {

	public static void main(String[] args) throws InterruptedException {
		ThreadB b=new ThreadB();
		b.start();

		/*1.mandate to be synchronized
		 * 2.synchronized block on the object of thread b
		 * 3.synchronized(object name)=object name.wait()
		 * 4.object on which you call wait will be same as synchronized block
		 */

		/*main thread sleeps so that chit ld thread gets the chance to execute.
	     because if it does not sleeps then scheduler may give the chance to
	     main thread or to child thread to execute.
		 */
		Thread.sleep(10000);
		synchronized(b)
		{
			System.out.println("main thread trying to call wait method");
			b.wait(1000);
		}
		System.out.println("main thread got notification"); 
		System.out.println(b.total);
	}
}
