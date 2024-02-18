package org.example.Version_1.Behaviours.CustomerBeh;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestWorkBeh extends OneShotBehaviour {
    public int workV;

    public RequestWorkBeh(int workV) {
        this.workV = workV;
    }

    @Override
    public void action() {
        log.info("Отправляю сообщение с работой!");
        ACLMessage message = new ACLMessage(ACLMessage.AGREE);
        message.setContent(this.workV + "");
        message.addReceiver(new AID("AgentWorker", false));
        myAgent.send(message);
    }
}
