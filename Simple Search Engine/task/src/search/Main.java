package search;

public class Main {
    public static void main(String[] args) {

        if (args.length > 0) {
            if (isValidInput(args[0])) {
                SearchEngineApp.runApp(args[1]);
            }
        }
    }

    private static boolean isValidInput(String inp) {
        return "--data".equals(inp);
    }
}
