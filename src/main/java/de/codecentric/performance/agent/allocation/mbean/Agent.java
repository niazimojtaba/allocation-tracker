package de.codecentric.performance.agent.allocation.mbean;

import de.codecentric.performance.agent.allocation.AgentLogger;
import de.codecentric.performance.agent.allocation.StaticTracker;

public class Agent implements AgentMBean {

  @Override
  public void start() {
    AgentLogger.log("Agent is now tracking.");
    StaticTracker.startCount();
  }

  @Override
  public void stop() {
    AgentLogger.log("Agent is no longer tracking.");
    StaticTracker.stopCount();
  }

  @Override
  public String printTop(int amount) {
    String topList = StaticTracker.buildTopCountList(amount);
    if (AgentLogger.LOG_TOP_LIST) {
      AgentLogger.log("Agent saw these allocations:");
      AgentLogger.log(topList);
    }
    return topList;
  }

}
