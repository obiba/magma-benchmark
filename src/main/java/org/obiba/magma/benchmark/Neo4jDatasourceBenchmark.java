package org.obiba.magma.benchmark;

import org.obiba.magma.Datasource;
import org.obiba.magma.datasource.neo4j.Neo4jDatasourceFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Neo4jDatasourceBenchmark extends AbstractDatasourceBenchmark {

  private final ApplicationContext applicationContext;

  public Neo4jDatasourceBenchmark(int nbVariables, int nbEntities) {
    super(nbVariables, nbEntities);
    this.applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
  }

  public Neo4jDatasourceBenchmark(int nbVariables, int nbEntities, ApplicationContext applicationContext) {
    super(nbVariables, nbEntities);
    this.applicationContext = applicationContext;
  }

  @Override
  protected Datasource createDatasource() {
    return new Neo4jDatasourceFactory("neo4j", applicationContext).create();
  }
}
