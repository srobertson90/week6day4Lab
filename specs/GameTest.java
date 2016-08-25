import static org.junit.Assert.*;
import org.junit.*;
import player.*;
import deck.*;
import game.*;

public class GameTest {


Player player1;
Player player2;
Player player3;
Card card1;
Card card2;
Card card3;
Card card4;
Game game;

@Before
public void before(){
  player1 = new Player("Gillian");
  player2 = new Player("Stuart");
  player3 = new Player("Emma");
  card1 = new Card(SuitType.DIAMONDS, ValueType.THREE);
  card2 = new Card(SuitType.HEARTS, ValueType.KING);
  card3 = new Card(SuitType.CLUBS, ValueType.QUEEN);
  card4 = new Card(SuitType.SPADES, ValueType.SEVEN);
  game = new Game();
}

@Test
public void checkPileStartsEmpty(){
  assertEquals(0, game.cardPileSize());
}

@Test
public void canAddCardToCardPile(){
 game.addToCardPile(card1);
 assertEquals(1, game.cardPileSize());

}

@Test
public void canClearCardPile(){
  game.addToCardPile(card1);
  assertEquals(1, game.cardPileSize());
  game.clearCardPile();
  assertEquals(0, game.cardPileSize());
}

@Test 
public void canRemoveCardPile() {
  game.addToCardPile(card1);
  assertEquals(1, game.cardPileSize());
  game.removeFromCardPile(card1);
  assertEquals(0, game.cardPileSize());
}

@Test
public void returnsCardOnRemoval() {
  game.addToCardPile(card1);
  assertEquals(1, game.cardPileSize());
  Card card = game.removeFromCardPile(card1);
  assertEquals(SuitType.DIAMONDS, card.getSuit());
}

@Test
public void canDealCardToPlayer() {
  game.addToCardPile(card1);
  game.dealCard(player1, card1);
  assertEquals(1, player1.handCount());
  assertEquals(0, game.cardPileSize());
}

@Test
public void canTakeCardFromPlayer(){
  player1.handAdd(card1);
  game.returnToDeck(player1, card1);
  assertEquals(0, player1.handCount());
  assertEquals(1, game.cardPileSize());
}

@Test
public void canMoveCardBetweenPLayers(){
  player1.handAdd(card1);
  game.moveCardBetweenPlayers(player1, player2, card1);
  assertEquals(0, player1.handCount());
  assertEquals(1, player2.handCount());
}

}