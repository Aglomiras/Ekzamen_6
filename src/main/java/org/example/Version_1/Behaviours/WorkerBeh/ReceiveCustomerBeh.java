package org.example.Version_1.Behaviours.WorkerBeh;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReceiveCustomerBeh extends TickerBehaviour {
    private double workV;
    private int count = 0;
    private long start = 0;

    public ReceiveCustomerBeh(Agent a, long period, String workV) {
        super(a, period);
        this.workV = Double.parseDouble(workV);
    }

    @Override
    public void onStart() {
        this.start = System.currentTimeMillis();
    }

    @Override
    protected void onTick() {
        long finish = System.currentTimeMillis();
        long elapsed = finish - this.start;
        if (elapsed <= this.workV * 1000) {
            sendBet(elapsed / (this.workV * 10));
        } else {
            System.out.println("Работа завершена!");
        }
    }

    public void sendBet(double proc) {
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.setContent(proc + "");
        message.addReceiver(new AID("AgentCustomer", false));
        myAgent.send(message);
    }
}
