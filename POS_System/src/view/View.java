package POS_System.src.view;

import POS_System.src.controller.Controller;

public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void executeSale() {
        controller.startNewSale();
        controller.enterItem("001");
        controller.enterItem("002");
        controller.enterItem("002");  // Alternative flow 3-4b
        controller.endSale();
        controller.logSale();
        controller.printReceipt();
    }
}
