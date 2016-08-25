package game;
import deck.*;
import java.util.*;
import player.*;

public class Game {


 ArrayList<Player> players;
 ArrayList<Card> cardPile;


public Game(){
  this.players = new ArrayList<Player>();
  this.cardPile = new ArrayList<Card>();
}

public int cardPileSize(){
   return cardPile.size();
}

public void addToCardPile(Card card){
 cardPile.add(card);
}

public void clearCardPile(){
  cardPile.clear();
}

public Card removeFromCardPile(Card card){
  if (cardPile.remove(card)) {
     return card;
  }
  return null;
}

public void dealCard(Player player, Card card){
  removeFromCardPile(card);
  player.handAdd(card);
}

public void returnToDeck(Player player, Card card){
  player.handRemove(card);
  addToCardPile(card);
}

public void moveCardBetweenPlayers(Player player1, Player player2, Card card){
  player1.handRemove(card);
  player2.handAdd(card);
}



}
