//class to edit the stack
public class CardStack
{
    //global variables for the class-
    private int count; // tracks how many cards are in the stack
    private Card data[] = new Card [100];

    public CardStack ()
    { //creates the card stack
	count = 0;
    }


    public void push (Card addMe)
    { //pushes a card of the stack
	data [count] = addMe;
	count++;
    }


    public boolean isFull ()
    { //makes sure the stack isn't full
	return (count == 40);
    }


    public Card pop ()
    { //removes a card from the stack
	count--;
	return data [count];
    }


    public boolean isEmpty ()
    { //checks if the stack is empty
	return count == 0;
    }


    public void clear ()
    { //clears the array
	count = 0;
    }
}
