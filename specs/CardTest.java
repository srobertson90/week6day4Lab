import static org.junit.Assert.*;
import org.junit.*;
import cards.*;

public class CardTest {

   Card card; 

   @Before 
   public void before(){
    card = new Card(SuitType.HEARTS, ValueType.TWO);
   }


 @Test
 public void canGetSuit(){
  assertEquals(SuitType.HEARTS, card.getSuit());
 }
}