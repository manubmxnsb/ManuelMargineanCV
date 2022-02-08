package exercises.ex2;

import javax.swing.*;

//ProductInterface is the view from MVC design pattern
public class ProductInterface {
    private JTextField nameField;
    private JTextField qtyField;
    private JTextField priceField;
    private JButton addNewProductButton;
    private JList productsList;
    private JButton deleteButton;
    private JTextField qtyModifyField;
    private JButton updateSelectedProductSButton;
    public JPanel asd;
    private JButton updatePriceButton;
    private JTextField newPriceField;

    public JButton getUpdatePriceButton() {
        return updatePriceButton;
    }

    public JTextField getNewPriceField() {
        return newPriceField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getQtyField() {
        return qtyField;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public JButton getAddNewProductButton() {
        return addNewProductButton;
    }

    public JList getProductsList() {
        return productsList;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JTextField getQtyModifyField() {
        return qtyModifyField;
    }

    public JButton getUpdateSelectedProductSButton() {
        return updateSelectedProductSButton;
    }

    //    public static void main(String[] args) {
//        JFrame frame = new JFrame("ProductInterface");
//        frame.setContentPane(new ProductInterface().asd);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
}
