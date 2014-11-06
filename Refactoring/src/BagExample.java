public class BagExample {
	void processMessage(String msg) {
		Bag bag = new BagImpl(this);
		bag.set(msg);
		MessagePipe pipe = new MessagePipe();
		pipe.send(bag);
	}
}