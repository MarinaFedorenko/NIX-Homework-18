package nix;

public class Application {
    volatile public static  String input;
    static TextProducer tProducer;
    static TextConsumer tConsumer;

    public static void main(String[] args) {
        input = "";
        String path = "output.txt";

        tProducer = new TextProducer();
        tConsumer = new TextConsumer(path);

        tProducer.start();
        tConsumer.start();

    }
}
