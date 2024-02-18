package org.example.Version_2.Agents;

import jade.core.Agent;
import lombok.extern.slf4j.Slf4j;
import org.example.Version_2.Behaviours.CustomerBeh.ReceiveMsgBeh;
import org.example.Version_2.Behaviours.CustomerBeh.RequestWorkBeh;

@Slf4j
public class AgentCustomer extends Agent {
    @Override
    protected void setup() {
        log.info(this.getLocalName() + " was born!");
        this.addBehaviour(new RequestWorkBeh(100));
        this.addBehaviour(new ReceiveMsgBeh());
    }
}
