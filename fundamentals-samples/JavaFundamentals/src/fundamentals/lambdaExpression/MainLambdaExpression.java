package fundamentals.lambdaExpression;

public class MainLambdaExpression {
    public static void main(String[] args) {
        InterfaceFunctional interfaceFunctional = new InterfaceFunctional() {
            @Override
            public void printMessage(String message) {
                System.out.println("Message: " + message);
            }
        };

        interfaceFunctional.printMessage("Hello this is a interface");

        InterfaceFunctional interfaceFunctionalLambda = (message) -> System.out.println("Lambda: " + message);
        InterfaceFunctional interfaceFunctionalLambda2 = (message) -> {
            System.out.println("Lambda: " + message);
        };

        interfaceFunctionalLambda.printMessage("Interface called with lambda");
    }
}
