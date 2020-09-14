package nix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class TextProducer extends Thread {

    private static final String STOP = "quit";
    volatile static public boolean isSleeping = false;

    private static final Logger logger = LoggerFactory.getLogger(
            TextProducer.class);

    public TextProducer(){}

    public void run() {
        Scanner in = new Scanner(System.in);
        String temp="";
        System.out.println("Start entering words:");
        logger.info("Start entering words:");

        while (true){
            temp=in.nextLine();
            if(!temp.equals(STOP)){
                Application.input = temp;
                logger.info("input:  "+Application.input);
            }
            else{
                Application.input = temp;
                System.out.println("Producer thread was stopped");
                logger.info("Producer thread was stopped");
                break;
            }

            try {
                isSleeping = true;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
