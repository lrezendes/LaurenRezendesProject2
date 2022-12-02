public class MessageQueue {
    MessageFragment head;
    MessageFragment tail;
    int size;
    boolean inUse;
    String sendReceive;

    public MessageQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.inUse = false;
        this.sendReceive = null;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.inUse = false;
        this.sendReceive = null;
    }

    public String getStatus(int num) {
        if (inUse) {
            return "Queue #" + num + ": Unavailable";
        } else {
            return "Queue #" + num + ": Available";
        }
    }

    public MessageFragment poll() {
        if (size > 0) {
            MessageFragment currHead = this.head;
            this.head = this.head.nextNode;
            --this.size;
            return currHead;
        } else {
            return null;
        }
    }

    public void enqueue(String message, String sendReceive) throws IllegalStateException {
        if(this.inUse==true) {
            throw new IllegalStateException ("Unavailable");
        } else {
            this.inUse = true;
            this.sendReceive = sendReceive;
            for (char letter : message.toCharArray()) {
                if (this.size==0) {
                    this.head = new MessageFragment(letter, null);
                    this.tail = this.head;
                } else {
                    this.tail.nextNode = new MessageFragment(letter, null);
                    this.tail = this.tail.nextNode;
                }
                ++this.size;
            }
        }
    }
}
