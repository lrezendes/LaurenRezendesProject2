public class MessageFragment {
    char letter;
    MessageFragment nextNode;

    public MessageFragment (char newLetter, MessageFragment newMessageFragment) {
	this.letter = newLetter;
    this.nextNode = newMessageFragment;
    }

}
