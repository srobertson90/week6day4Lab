package game;
import cards.*;
import java.util.*;
import player.*;

public class Game {


 ArrayList<Player> players;
 ArrayList<Card> deck;


public Game(){
  this.players = new ArrayList<Player>();
  this.deck = new ArrayList<Card>();
}

public int deckSize(){
   return deck.size();
}

public void addToDeck(Card card){
 deck.add(card);
}

public void clearDeck(){
  deck.clear();
}

public Card removeFromDeck(Card card){
  if (deck.remove(card)) {
     return card;
  }
  return null;
}

public void dealCard(Player player, Card card){
  removeFromDeck(card);
  player.handAdd(card);
}

public void returnToDeck(Player player, Card card){
  player.handRemove(card);
  addToDeck(card);
}

public void moveCardBetweenPlayers(Player player1, Player player2, Card card){
  player1.handRemove(card);
  player2.handAdd(card);
}

}
