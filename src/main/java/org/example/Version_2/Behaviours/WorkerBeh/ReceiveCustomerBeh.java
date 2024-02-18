package org.example.Version_2.Behaviours.WorkerBeh;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReceiveCustomerBeh extends Behaviour {
    private double workV;
    private int count = 0;
    private long start = 0;
    private boolean flag = false;

    public ReceiveCustomerBeh(String workV) {
        this.workV = Double.parseDouble(workV);
    }

    @Override
    public void onStart() {
        this.start = System.currentTimeMillis();
    }

    @Override
    public void action() {
        long finish = System.currentTimeMillis();
        long elapsed = finish - this.start;

        if (count % 10000000 == 0) {
            if (elapsed <= this.workV * 1000) {
                sendBet(elapsed / (this.workV * 10));
            } else {
                System.out.println("Работа завершена!");
                flag = true;
            }
        }
        this.count++;
    }

    @Override
    public boolean done() {
        return flag;
    }

    public void sendBet(double proc) {
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.setContent(proc + "");
        message.addReceiver(new AID("AgentCustomer", false));
        myAgent.send(message);
    }
}
