import javax.accessibility.AccessibleIcon;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvoiceFrame extends JFrame
{
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 1000;

    private JTextField nameTextField;
    private JTextField streetTextField;
    private JTextField cityTextField;
    private JTextField stateTextField;
    private JTextField zipTextField;
    private JLabel label;
    private JTextArea receiptTextArea;
    private JButton printButton;
    private ActionListener listener;
    private double sizePrice = 0.00;
    private double crustPrice = 0.00;
    private int toppingAmt = 0;
    private String crustType = "";
    private double toppingPrice = toppingAmt;
    private double subtotal = sizePrice + toppingPrice;
    private double tax = 0.7;
    private double total = subtotal + (subtotal * tax);


    /**
     Constructs the frame.
     */
    public InvoiceFrame()
    {
        // This listener is shared among all components
        listener = new ChoiceListener();

        createControlPanel();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    class ChoiceListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {

        }
    }

    public void createControlPanel()
    {
        JPanel addressPanel = createAddress();
        JPanel lineItemPanel = createLineItems();
        JPanel productPanel = createProducts();
        JPanel invoicePrintPanel = createInvoicePrint();

        // Line up component panels

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(5, 1));
        controlPanel.add(addressPanel);
        controlPanel.add(lineItemPanel);
        controlPanel.add(productPanel);
        controlPanel.add(invoicePrintPanel);

        // Add panels to content pane

        add(controlPanel, BorderLayout.SOUTH);
    }

    public JPanel createAddress()
    {
        nameTextField = new JTextField();
        streetTextField = new JTextField();
        cityTextField = new JTextField();
        stateTextField = new JTextField();
        zipTextField = new JTextField();

        JPanel panel = new JPanel();
        panel.add(nameTextField);
        panel.add(streetTextField);
        panel.add(cityTextField);
        panel.add(stateTextField);
        panel.add(zipTextField);
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Address"));

        return panel;
    }


    public JPanel createLineItems()
    {
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Line Items"));

        return panel;
    }

    public JPanel createProducts()
    {


        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Products"));

        return panel;
    }

    public JPanel createInvoicePrint()
    {
        label = new JLabel("Price:");
        receiptTextArea = new JTextArea();
        receiptTextArea.setSize(300,200);
        receiptTextArea.add(label);


        JPanel panel = new JPanel();
        panel.add(receiptTextArea);
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Invoice"));

        return panel;
    }

}
