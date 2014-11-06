package BagRefactor;

final class BagImpl implements Bag {


	/**
	 * @param bagExample
	 */
	BagImpl() {
	}

	Object o;

	public Object get() {
		return o;
	}

	public void set(Object o) {
		this.o = o;
	}
}