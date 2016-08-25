package player;
import deck.*;
import java.util.*;

public class Player {

 String name;
 ArrayList<Card> hand;


public Player(String name){
  this.name = name;
  this.hand = new ArrayList<Card>();
}

public String getName(){
  return this.name;
}

public int handCount() {
   return hand.size();
}
// add card to hand function, game gives you card for input

public void handAdd(Card card) {
   hand.add(card);

}

public void handClear() {
  hand.clear();
}

public Card handRemove(Card card) {
  if (hand.remove(card)) {
     return card;
  }
  return null;

}


}