package nix;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TextConsumer extends Thread{
    private String path;
    private static final String STOP = "quit";

    private static final Logger logger = LoggerFactory.getLogger(
            TextConsumer.class);

    public TextConsumer(String path){
        this.path = path;
    }

    public void run() {
        String previous = "";
        File file = new File(path);
        while(true){

            if(TextProducer.isSleeping){
                if (Application.input.equals(STOP)) {
                    logger.info("Consumer thread was stopped");
                    System.out.println("Consumer thread was stopped");
                    break;
                }
                else if (Application.input.length() != 0 && !Application.input.equals(previous) && !Application.input.equals(STOP)) {
                    try (PrintWriter write = new PrintWriter(file)) {
                        previous = Application.input;
                            write.println(Application.input);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }


//            }

        }

    }
}
