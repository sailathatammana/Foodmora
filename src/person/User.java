package person;

import java.util.List;

public class User extends Person {
    public final List<String> menuOptions = List.of("List my weeks", "List recipes", "View recipe", "Generate a new week", "Quit");

    public List<String> getMenuOptions() {
        return menuOptions;
    }


    public void handleOption(int selectedOption) {
        switch (selectedOption) {
            case 1 -> System.out.println("List my weeks");
            case 2 -> System.out.println("List recipes");
            case 3 -> System.out.println("View recipe");
            case 4 -> System.out.println("Generate a new week");
            case 5 -> {
                System.out.println("Good Bye");
               System.exit(1);
            }
            default -> throw new IndexOutOfBoundsException();
        }
    }
}
