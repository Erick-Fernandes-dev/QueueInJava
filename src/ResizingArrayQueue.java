import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueue<Item> implements Iterable<Item> {
	
	private Item[] q;
	private int N;
	private int first;
	private int last;
	
	public ResizingArrayQueue() {
		q = (Item[]) new Object[2];
		N = 0;
		first = 0;
		last = 0;
	}
	
	public boolean isEmpty() {
		return N == 0;
		
	}
	
	public int size() {
		return N;
	}
	
	public void resize(int max) {
		assert max >= N;
		
		Item[] temp = (Item[]) new Object[max];
		
		for (int i = 0; i < N; i++) {
			temp[i] = q[(first + i) % q.length];
		}
		
		q = temp;
		first = 0;
		last = N;
	}
	
	public void enqueue(Item item) {
		
		if (N == q.length) resize(2 * q.length);
		q[N++] = item;
		if (last == q.length) last = 0;
		N++;
	}
	

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
//	public static void main(String[] args) {
//		ResizingArrayQueue<String> q = new ResizingArrayQueue<String>();
//		while(!Stdin.isEmpty()) {
//			String item = Stdin.readString();
//			if (!item.equals("-")) q.enqueue(item);
//			else if (!q.isEmpty()) Stdout.print(d.dequeue() + " ");
//		}
//		
//		Stdout.println("(" + q.size() + " left on queue");
//		
//	}
//	
}