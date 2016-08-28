import static org.junit.Assert.*;
import org.junit.*;
import player.*;
import cards.*;
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
    card1 = new Card(SuitType.DIAMONDS, RankType.THREE);
    card2 = new Card(SuitType.HEARTS, RankType.KING);
    card3 = new Card(SuitType.CLUBS, RankType.QUEEN);
    card4 = new Card(SuitType.SPADES, RankType.SEVEN);
    game = new Game();
  }

  @Test
  public void deckStartsEmpty(){
    assertEquals(0, game.deckSize());
  }

  @Test
  public void canAddCardToDeck(){
    game.addToDeck(card1);
    assertEquals(1, game.deckSize());
  }

  @Test
  public void canClearDeck(){
    game.addToDeck(card1);
    game.clearDeck();
    assertEquals(0, game.deckSize());
  }

  @Test 
  public void canRemoveCardPile() {
    game.addToDeck(card1);
    game.removeFromDeck(card1);
    assertEquals(0, game.deckSize());
  }

  @Test
  public void returnsCardOnRemoval() {
    game.addToDeck(card1);
    Card card = game.removeFromDeck(card1);
    assertEquals(SuitType.DIAMONDS, card.getSuit());
  }

  @Test
  public void canDealCardToPlayer() {
    game.addToDeck(card1);
    game.dealCard(player1, card1);
    assertEquals(1, player1.handCount());
    assertEquals(0, game.deckSize());
  }

  @Test
  public void canTakeCardFromPlayer(){
    player1.handAdd(card1);
    game.returnToDeck(player1, card1);
    assertEquals(0, player1.handCount());
    assertEquals(1, game.deckSize());
  }

  @Test
  public void canMoveCardBetweenPLayers(){
    player1.handAdd(card1);
    game.moveCardBetweenPlayers(player1, player2, card1);
    assertEquals(0, player1.handCount());
    assertEquals(1, player2.handCount());
  }

  @Test
  public void deckCanPopulate(){
    game.clearDeck();
    game.fullDeck();
    assertEquals(52, game.deckSize());
  }

}