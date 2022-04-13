package converter.Panel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import converter.Parts_combined.*;

public class Panel extends JFrame {

    private JLabel labelDecNumber = new JLabel("Decimal Number:");
    private JLabel labelBinNumber = new JLabel("Binary Number: ");
    private JLabel labelHexNumber = new JLabel("Hexadecimal Number:");
    private JLabel labelOctNumber = new JLabel("Octal Number: ");
    private JTextField fieldDecNumber = new JTextField(20);
    private JTextField fieldBinNumber = new JTextField(20);
    private JTextField fieldHexNumber = new JTextField(20);
    private JTextField fieldOctNumber = new JTextField(20);
    private JButton buttonConvertDecimal =      new JButton("Convert");
    private JButton buttonConvertBinary =       new JButton("Convert");
    private JButton buttonConvertHexadecimal =  new JButton("Convert");
    private JButton buttonConvertOctal =        new JButton("Convert");




    public Panel() {
        super("Number Converter");

        // create a new panel with GridBagLayout manager
        JPanel newPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        newPanel.add(labelDecNumber, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        newPanel.add(labelBinNumber, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        newPanel.add(labelHexNumber, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        newPanel.add(labelOctNumber, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        newPanel.add(fieldDecNumber, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        newPanel.add(fieldBinNumber, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        newPanel.add(fieldHexNumber, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        newPanel.add(fieldOctNumber, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        newPanel.add(buttonConvertDecimal, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        newPanel.add(buttonConvertBinary, constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;
        newPanel.add(buttonConvertHexadecimal, constraints);

        constraints.gridx = 2;
        constraints.gridy = 3;
        newPanel.add(buttonConvertOctal, constraints);
        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory
        .createEtchedBorder(), "Type number in correct box"));

        // add the panel to this frame
        add(newPanel);
       
        buttonConvertDecimal.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                String[] arg = new String[3];
                DecTo dec = new DecTo();
                int num;
                try {
                    num = Integer.parseInt(fieldDecNumber.getText()); }
                catch (NumberFormatException f){
                    fieldDecNumber.setText("Input decimal number");
                    return;
                }
                arg = dec.decTo(num);
                fieldBinNumber.setText(arg[0]);
                fieldHexNumber.setText(arg[1]);
                fieldOctNumber.setText(arg[2]);
            }
        });
       
        buttonConvertBinary.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                String[] arg = new String[3];
                BinTo bin = new BinTo();
                int num;
                String quot = fieldBinNumber.getText();
                if(!quot.matches("[01]+")) {
                    fieldBinNumber.setText("Input binary number");
                    return;
                }
                num = Integer.parseInt(quot);
                arg = bin.binTo(num);
                fieldDecNumber.setText(arg[0]);
                fieldHexNumber.setText(arg[1]);
                fieldOctNumber.setText(arg[2]);
            }
        }); 

       buttonConvertHexadecimal.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                String[] arg = new String[3];
                HexTo hex = new HexTo();
                String num = fieldHexNumber.getText();
                if (!num.matches("[0-9A-F]+$")){
                    fieldHexNumber.setText("Input Hexadecimal number");
                    return;
                }
                arg = hex.hexTo(num);
                fieldDecNumber.setText(arg[0]);
                fieldBinNumber.setText(arg[1]);
                fieldOctNumber.setText(arg[2]);
            }
        });
        buttonConvertOctal.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                String[] arg = new String[3];
                OctTo oct = new OctTo();
                int num;
                String quot = fieldOctNumber.getText();
                num = Integer.parseInt(quot);
                //if(quot.matches("[0-8]+$")) {
                //    fieldOctNumber.setText("Input octal number");
                //    return;
                //}
                arg = oct.octTo(num);
                fieldDecNumber.setText(arg[0]);
                fieldBinNumber.setText(arg[1]);
                fieldHexNumber.setText(arg[2]);
            }
        });
        pack();
        setLocationRelativeTo(null);
    }
}
