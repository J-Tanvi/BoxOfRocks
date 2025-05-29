//to store all the cards
public class Card
{
    int cardName; // this reps the card img
    int cardAnswer; // this reps the answers img
    int cardPts[] = {0, 1, 2}; // this reps the questions answer
    //has all the answers to the right questions
    int pts[] = {2, 1, 1, 0, 2, 2, 2, 0, 2, 1, 0, 1, 1,
	1, 2, 1, 1, 2, 1, 1, 0, 1, 2, 2, 1, 1, 0, 0, 1,
	1, 0, 1, 0, 1, 0, 2, 2, 1, 2, 2};
    int ptsB[] = {0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1,
	0, 0, 1, 2, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2,
	1, 0, 0, 2, 0, 0, 0, 1, 2, 1, 1};
    int ptsC[] = {2, 1, 2, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1,
	0, 0, 0, 1, 2, 1, 0, 0, 2, 2, 2, 2, 1, 0, 0, 1,
	1, 0, 1, 2, 2, 1, 1, 1, 0, 2, 2};


    public Card (int number)
    {//syncs up the arrays
	cardName = number - 1;
	cardAnswer = number + 40;

	cardPts [0] = pts [number - 1];
	cardPts [1] = ptsB [number - 1];
	cardPts [2] = ptsC [number - 1];
    }



    public int getCardName ()
    {//returns the card number
	return cardName;
    }


    public int[] getCardPts ()
    {//returns an interger value for the answers
	return cardPts;
    }


    public void setCardName (int n)
    {//sets the name of the images
	cardName = n;
    }


    public String getPicName ()
    {
	String temp = String.valueOf (cardName);
	return temp;
	// return cardName;
    }


    public String getPicAnswer ()
    {
	String temp = String.valueOf (cardAnswer);
	return temp;
	// return cardAnswer;
    }
}


