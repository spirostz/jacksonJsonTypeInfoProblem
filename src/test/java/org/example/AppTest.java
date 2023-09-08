package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/** Unit test for simple App. */
public class AppTest extends TestCase {
  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public AppTest(String testName) {
    super(testName);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(AppTest.class);
  }

  public void testApp() throws JsonProcessingException {

    ObjectMapper objectMapper = new ObjectMapper();
    String json = """
        {"type":"FIRST","fieldA":"fA"}
        """;

    Pojo pojo = objectMapper.readValue(json, Pojo.class);
    String result = objectMapper.writeValueAsString(pojo);

    System.out.println(result);
    // Faulty output: {"type":"FIRST","type":"FIRST","fieldA":"fA"}

    int typeFieldsCount = result.split("\"type\":\"FIRST\"").length - 1;

    assertEquals("Should return type field once", 1, typeFieldsCount);

    // PROBLEM: Returns type field 2 times:
    // Fails with: Should return type field once expected:<1> but was:<2>
  }
}
