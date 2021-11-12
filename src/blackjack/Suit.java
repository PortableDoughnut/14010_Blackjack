package blackjack;

public enum Suit {
	SPADES("/assets/images/suits/spades.png"), CLUBS("/assets/images/suits/clubs.png"), DIAMONDS("/assets/images/suits/diamonds.png"), HEARTS("/assets/images/suits/hearts.png");

    String imgLocation;
    
    Suit(String imgLocation) {
    	this.imgLocation =  imgLocation;
    }
    
}
