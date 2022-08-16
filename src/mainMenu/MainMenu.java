package mainMenu;

public class MainMenu {
    public MainMenu() {
        MainMenuModel model = new MainMenuModel();
        model.setMenuOptions();
        MainMenuView view = new MainMenuView(model.getMenuOptions());
        MainMenuController controller = new MainMenuController(model, view);

        controller.requestUserInput();
    }
}
