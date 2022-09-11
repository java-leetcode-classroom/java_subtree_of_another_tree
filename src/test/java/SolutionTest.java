import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final private Solution sol = new Solution();
  @Test
  void isSubtreeExample1() {
    assertTrue(sol.isSubtree(sol.createBinaryTree(new String[]{"3", "4", "5", "1", "2"}),
        sol.createBinaryTree(new String[]{"4", "1", "2"})
    ));
  }
  @Test
  void isSubtreeExample2() {
    assertFalse(sol.isSubtree(sol.createBinaryTree(new String[]{"3", "4", "5", "1", "2","null", "null", "null", "null", "0"}),
        sol.createBinaryTree(new String[]{"4", "1", "2"})
    ));
  }
}