import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class CircularArrayRing<E> extends AbstractCollection<E> implements Ring<E> {
	private Object[] queueArray;
	private int head;
	private int size;
	
	public CircularArrayRing(int N) {
		queueArray = new Object[N];
		head = 0;
		size = 0;
	}
	
	public CircularArrayRing() {
		this(10);
	}
	
	public boolean add(E e) {
		size++;
		head = (head + 1) % queueArray.length;
		queueArray[head] = e;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index) throws IndexOutOfBoundsException {
		if(index >= this.size() || index < 0)
			throw new IndexOutOfBoundsException();
		return (E) queueArray[(queueArray.length + (head - index)) % queueArray.length];
	}

	public Iterator<E> iterator() {
		Iterator<E> it = new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size() && queueArray[currentIndex] != null;
            }

			@Override
            public E next() throws NoSuchElementException {
            	if(currentIndex >= size() || currentIndex < 0)
            		throw new NoSuchElementException();
                return get(currentIndex++);
            }

            @Override
            public void remove() throws UnsupportedOperationException {
                throw new UnsupportedOperationException();
            }
        };
        return it;
	}

	public int size() {
		if(size < queueArray.length)
			return size;
		else
			return queueArray.length;
	}
}