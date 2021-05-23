package dps.hoffmann.dockerized_mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
                propertyName = "destinationLookup",
                propertyValue = "java:jboss/exported/jms/queue/ipQueue"),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Queue") })
public class JmsConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("something is happening!!!!!!!!!!!!!!!!!!!");
    }

}
