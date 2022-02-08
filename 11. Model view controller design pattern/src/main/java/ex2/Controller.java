package exercises.ex2;

import javax.swing.*;
import java.util.Vector;

//Controller is the controller from MVC design pattern
public class Controller {
    public static Vector<Product> products = new Vector<>(0);

    public static void main(String[] args) {
        JFrame frame = new JFrame("Stock Manager App");
        ProductInterface productInterface = new ProductInterface();
        productInterface.getAddNewProductButton().addActionListener(e -> {
            String productName = productInterface.getNameField().getText();
            int productQty;
            try {
                productQty = Integer.parseInt(productInterface.getQtyField().getText());
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(frame, "Only integer values can be accepted for Quantity!\n Quantity set to 1. You can modify that.");
                productQty = 1;
            }
            double productPrice;
            try {
                productPrice = Double.parseDouble(productInterface.getPriceField().getText());
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(frame, "Only numeric values can be accepted for Price, separated with a '.'!\n Price is set to 1. You can modify that.");
                productPrice = 1.0;
            }

            products.add(new Product(productName, productQty, productPrice));
            productInterface.getProductsList().setListData(products);
        });

        productInterface.getUpdatePriceButton().addActionListener(e -> {
            products.get(productInterface.getProductsList().getSelectedIndex()).setPrice(Double.parseDouble(productInterface.getNewPriceField().getText()));
            productInterface.getProductsList().setListData(products);
        });

        productInterface.getDeleteButton().addActionListener(e -> {
            products.remove(productInterface.getProductsList().getSelectedValue());
            productInterface.getProductsList().setListData(products);
        });
        productInterface.getUpdateSelectedProductSButton().addActionListener(e -> {
            products.get(productInterface.getProductsList().getSelectedIndex()).setQuantity(Integer.parseInt(productInterface.getQtyModifyField().getText()));
            productInterface.getProductsList().setListData(products);
        });

        frame.setContentPane(productInterface.asd);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
