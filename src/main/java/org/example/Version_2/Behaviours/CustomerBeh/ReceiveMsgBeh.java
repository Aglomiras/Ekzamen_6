package org.example.Version_2.Behaviours.CustomerBeh;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ReceiveMsgBeh extends Behaviour {
    private MessageTemplate messageTemplate;

    @Override
    public void onStart() {
        messageTemplate = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
    }

    @Override
    public void action() {
        ACLMessage receive = myAgent.receive(messageTemplate);
        if (receive != null) {
            System.out.println(receive.getContent() + "%");
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
