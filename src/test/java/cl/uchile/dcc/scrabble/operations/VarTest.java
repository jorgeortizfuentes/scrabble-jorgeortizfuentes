package cl.uchile.dcc.scrabble.operations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.types.ScrabbleFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class VarTest {

  Var v;

  @BeforeEach
  void setUp() {
    v = new Var("x");

  }


  @RepeatedTest(20)
  void testConstructorA() {
    var expected = new Var("x");
    var noExpected = new Var("y");

    assertEquals(expected, v);
    assertEquals(expected.hashCode(), v.hashCode());

    assertNotEquals(noExpected, v);
    assertNotEquals(v, noExpected);

  }

  @RepeatedTest(20)
  void testConstructorB() {

    var o1 = ScrabbleFactory.getBoolean(true);
    var o2 = ScrabbleFactory.getBoolean(true);
    var o3 = ScrabbleFactory.getString("hola");

    var v1 = new Var("x", o1);
    var v2 = new Var("y", o2);
    var v3 = new Var("x", o3);
    var v4 = new Var("z", o3);

    assertEquals(v, v1);
    assertEquals(v.hashCode(), v1.hashCode());

    assertEquals(v1, v3);
    assertEquals(v1.hashCode(), v3.hashCode());

    assertNotEquals(v1, v2);
    assertNotEquals(v1.hashCode(), v2.hashCode());

    assertNotEquals(v1, v4);
    assertNotEquals(v1.hashCode(), v4.hashCode());

    assertNotEquals(v2, v3);
    assertNotEquals(v2.hashCode(), v3.hashCode());

    assertNotEquals(v, v2);
    assertNotEquals(v.hashCode(), v2.hashCode());

  }

  @RepeatedTest(20)
  void testAssign() {
    var o1 = ScrabbleFactory.getBoolean(true);
    var o2 = ScrabbleFactory.getBoolean(true);
    var o3 = ScrabbleFactory.getString("hola");

    var v1 = new Var("x");
    var v2 = new Var("y");
    var v3 = new Var("z");
    new Var("w");
    Var.assign("w", o2);

    v.assign(o1);
    v1.assign(o1);
    v2.assign(o2);
    v3.assign(o3);

    assertEquals(v, v1);
    assertEquals(v.hashCode(), v1.hashCode());

    assertNotEquals(v, v2);
    assertNotEquals(v.hashCode(), v2.hashCode());

    assertNotEquals(v, v3);
    assertNotEquals(v.hashCode(), v3.hashCode());

    assertEquals(new Var("w").evaluate(), o1);
    assertEquals(new Var("w").evaluate().hashCode(), v1.evaluate().hashCode());
  }

  @RepeatedTest(20)
  void testGetVariable() {
    assertEquals("x", v.getVariable());
    assertNotEquals("y", v.getVariable());

  }


  @RepeatedTest(20)
  void testEvaluate() {
    var o1 = ScrabbleFactory.getBoolean(true);
    var o2 = ScrabbleFactory.getString("hola");

    var v2 = new Var("y");
    v.assign(o1);
    v2.assign(o2);

    assertEquals(o1, v.evaluate());
    assertEquals(o2, v2.evaluate());
    assertNotEquals(o1, v2.getVariable());


  }
}