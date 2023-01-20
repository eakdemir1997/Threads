

public class DenemeThread {

	public static void main(String[] args) {
		
		Data d=new Data();
		d.deger=100;
		d.flag=false;
		Producer producer =new Producer(d);
		Consumer consumer=new Consumer(d);
		
		Thread thread=new Thread(consumer);
		producer.start();
		thread.start();

	}

}

class Producer extends Thread{
	Data d;
	public Producer(Data d) {
		this.d=d;
	}
	public void run() {
		
		for(int i=0;i<10;i++) {
			synchronized (d) {
				d.deger++;
				System.out.println("Producer d.deger="+d.deger);
			}
		
		
		}
	}
}

class Consumer implements Runnable{
	
	Data d;
	
	public Consumer(Data d) {
		this.d=d;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			synchronized (d) {
				d.deger--;
				System.out.println("Consumer d.deger="+d.deger);
			}
		
		}
	}
	
}

class Data{
	int deger;
	boolean flag;
}