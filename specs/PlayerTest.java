import static org.junit.Assert.*;
import org.junit.*;
import player.*;
import cards.*;

public class PlayerTest {

  Player player;
  Card card;

  @Before
  public void before(){
    player = new Player("Player 1");
    card = new Card(SuitType.DIAMONDS, ValueType.THREE);
  }

  @Test
  public void canGetName(){
   assertEquals("Player 1", player.getName());
  }

  @Test
  public void startsWithEmptyHand() {
    assertEquals(0, player.handCount());
  }

  @Test
  public void canAddCardtoHand() {
    player.handAdd(card);
    assertEquals(1, player.handCount());
  }

  @Test
  public void clearHand() {
    player.handAdd(card);
    assertEquals(1, player.handCount());
    player.handClear();
    assertEquals(0, player.handCount());
  }

  @Test
  public void canRemoveCardfromHand(){
    player.handAdd(card);
    assertEquals(1, player.handCount());
    player.handRemove(card);
    assertEquals(0, player.handCount());
  }

  @Test
  public void canReturnCardOnRemove(){
    player.handAdd(card);
    Card returnedCard = player.handRemove(card);
    assertEquals(SuitType.DIAMONDS, returnedCard.getSuit());
  }

}