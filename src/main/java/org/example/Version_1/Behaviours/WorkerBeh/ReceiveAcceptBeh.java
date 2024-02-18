package org.example.Version_1.Behaviours.WorkerBeh;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReceiveAcceptBeh extends Behaviour {
    private MessageTemplate messageTemplate;

    @Override
    public void onStart() {
        messageTemplate = MessageTemplate.MatchPerformative(ACLMessage.AGREE);
    }

    @Override
    public void action() {
        ACLMessage receive = myAgent.receive(messageTemplate);
        if (receive != null) {
            log.info("Принимаю работу!");
            this.myAgent.addBehaviour(new ReceiveCustomerBeh(this.myAgent, 1000, receive.getContent()));
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
