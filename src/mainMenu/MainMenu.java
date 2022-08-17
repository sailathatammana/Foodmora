package mainMenu;

public class MainMenu {
    public MainMenu() {
        MainMenuModel model = new MainMenuModel();
        model.setMenuOptions();
        new MainMenuView(model.getMenuOptions());
        MainMenuController controller = new MainMenuController(model);

        controller.requestUserInput();
    }
}
