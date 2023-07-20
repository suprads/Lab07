import javax.swing.*;

public class InvoiceRunner
{
    public static void main(String[] args)
    {
        JFrame frame = new InvoiceFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Invoice Form");
        frame.setVisible(true);
    }
}