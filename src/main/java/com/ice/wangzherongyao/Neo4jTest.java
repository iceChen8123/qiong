package com.ice.wangzherongyao;

import org.neo4j.driver.v1.*;

public class Neo4jTest {

  public static void main(String[] args) {
    Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "wangzherongyao"));
    try (Session session = driver.session()) {
      StatementResult rs = session.run("CREATE (n) RETURN n");
    }
    driver.close();
  }

}
