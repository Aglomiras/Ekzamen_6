package org.example.Version_2.Agents;

import jade.core.Agent;
import lombok.extern.slf4j.Slf4j;
import org.example.Version_2.Behaviours.WorkerBeh.ReceiveAcceptBeh;

@Slf4j
public class AgentWorker extends Agent {
    @Override
    protected void setup() {
        log.info(this.getLocalName() + " was born!");
        this.addBehaviour(new ReceiveAcceptBeh());
    }
}
