package endava4.students;

public class Main {
    public static void main(String[] args) {
        insertSpaces();

        String messageToSplit = "jdbc:some_Sql-Driver!Here://localhost:5432/new_Database... just saying";
        String[] splitedMessage = messageToSplit.split("[;:_.!?/-]");
        System.out.print("My property is: ");
        for (String message: splitedMessage) {
            if (!message.isEmpty() || !message.isBlank()) {
                System.out.print(message + " ");
            }
        }

        insertSpaces();
    }

    public static void insertSpaces() {
        System.out.println();
        System.out.println();
    }

}
