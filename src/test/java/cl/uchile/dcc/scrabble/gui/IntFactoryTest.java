package cl.uchile.dcc.scrabble.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntFactoryTest {

  @BeforeEach
  void setUp() {
  }

  @Test
  void getInt() {
  }

  @Test
  void testFactory() {
    IntFactory f = new IntFactory();
    ScrabbleInt n1 = f.getInt(0, 15);
    ScrabbleInt n2 = f.getInt(0, 15);
    assertEquals(n1, n2);
    assertTrue(n1 == n2);
  }


}
