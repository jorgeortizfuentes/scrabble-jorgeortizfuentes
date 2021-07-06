package cl.uchile.dcc.scrabble.types;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.operations.Var;
import org.junit.jupiter.api.Test;

class ScrabbleFactoryTest {

  @Test
  void getString() {
    ScrabbleFactory f = new ScrabbleFactory();
    ScrabbleString a = f.getString("hola");
    ScrabbleString b = new ScrabbleString("hola");

    System.out.println(f.dict);
    ScrabbleFactory f2 = new ScrabbleFactory();
    System.out.println(f2.dict);

    assertEquals(a,b);

  }

  @Test
  void getInt() {
    ScrabbleFactory f = new ScrabbleFactory();
    ScrabbleInt n1 = f.getInt("x", 15);
    ScrabbleInt n2 = f.getInt("x", 15);
    assertEquals(n1, n2);
    assertTrue(n1 == n2);

    ScrabbleInt n3 = new ScrabbleInt(15);




  }

  @Test
  void getFloat() {
    ScrabbleFactory f = new ScrabbleFactory();
    ScrabbleFloat n1 = f.getFloat("x", 15.1);
    ScrabbleFloat n2 = f.getFloat("x", 15.1);
    assertEquals(n1, n2);
    assertTrue(n1 == n2);

    ScrabbleFloat n3 = f.getFloat(15.1);
    ScrabbleFloat n4 = f.getFloat(15.1);
    assertEquals(n3, n4);
    assertTrue(n3 == n4);

    assertEquals(n1, n4);


  }


  @Test
  void getBinary() {
  }

  @Test
  void getBoolean() {
    ScrabbleFactory f = new ScrabbleFactory();

    Var test = new Var("x", "hola");
    System.out.println(test.evaluate());


  }
}