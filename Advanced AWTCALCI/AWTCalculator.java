import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

class Close extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent d) {
        System.exit(0);
    }
}

class cal implements ActionListener {

    Frame frame1 = new Frame();

    // create buttons 
    Button btn0 = new Button("0");
    Button btn1 = new Button("1");
    Button btn2 = new Button("2");
    Button btn3 = new Button("3");
    Button btn4 = new Button("4");
    Button btn5 = new Button("5");
    Button btn6 = new Button("6");
    Button btn7 = new Button("7");
    Button btn8 = new Button("8");
    Button btn9 = new Button("9");
    Button btnAdd = new Button("+");
    Button btnSubtract = new Button("-");
    Button btnMultiply = new Button("×");
    Button btnDivide = new Button("÷");
    Button btnEqual = new Button("=");
    Button btnClear = new Button("C");
    Button btnSqRt = new Button("√");
    Button btnDot = new Button(".");
    Button btnNegativeMark = new Button("+/-");
    Button btnPercentage = new Button("%");

    // create textfield for displaying results
    TextField result_textField = new TextField();

    String firstValue, secondValue, operator;
    double firstDoubleValue, secondDoubleValue, Answer;
    int decimalCount = 0, zeroCount = 0;

    //panels
    Panel pannel_north = new Panel();
    Panel pannel_north_sub1 = new Panel();
    Panel pannel_north_sub2 = new Panel();
    Panel pannel_center = new Panel();
    Panel pannel_east = new Panel();
    Panel pannel_west = new Panel();
    Panel pannel_south = new Panel();

    // For History feature
    ArrayList<String> historyList = new ArrayList<>();
    Frame historyFrame = null;
    TextArea historyTextArea = null;

    cal() {

        //set frame properties
        frame1.addWindowListener(new Close());
        frame1.setBackground(Color.WHITE);
        frame1.setExtendedState(Frame.MAXIMIZED_BOTH);        frame1.setTitle("Calculator App");
        frame1.setResizable(false);

        //fonts
        Font Segoe_UI_15 = new Font("Segoe UI", Font.PLAIN, 15);

        //menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.setFont(Segoe_UI_15);

        //menus
        Menu view_menu = new Menu("View");
        Menu history_menu = new Menu("History");
        Menu help_menu = new Menu("Help");

        //menu items
        MenuItem view_menu_item_lightMode = new MenuItem("Light mode");
        MenuItem view_menu_item_Dark_mode = new MenuItem("Dark mode");
        MenuItem history_menu_item_viewHistory = new MenuItem("View History");
        MenuItem help_menu_item_help = new MenuItem("View Help  F1");
        MenuItem help_menu_item_about = new MenuItem("About Calculator");

        //adding menu items to menus
        view_menu.add(view_menu_item_lightMode);
        view_menu.add(view_menu_item_Dark_mode);

        history_menu.add(history_menu_item_viewHistory);

        help_menu.add(help_menu_item_help);
        help_menu.add(help_menu_item_about);

        //adding menus to menu bar
        menuBar.add(view_menu);
        menuBar.add(history_menu);
        menuBar.add(help_menu);

        //add menubar to frame
        frame1.setMenuBar(menuBar);

        //fonts
        Font Segoe_UI_24 = new Font("Segoe UI", 0, 24);
        Font Ebrima_24 = new Font("Ebrima", 0, 24);
        Font Segoe_UI_20 = new Font("Segoe UI", 0, 20);
        Font times_36 = new Font("Times New Roman", 0, 36);
        Font times_48 = new Font("Times New Roman", 0, 48);

        btn0.setFont(Segoe_UI_24);
        btn1.setFont(Segoe_UI_24);
        btn2.setFont(Segoe_UI_24);
        btn3.setFont(Segoe_UI_24);
        btn4.setFont(Segoe_UI_24);
        btn5.setFont(Segoe_UI_24);
        btn6.setFont(Segoe_UI_24);
        btn7.setFont(Segoe_UI_24);
        btn8.setFont(Segoe_UI_24);
        btn9.setFont(Segoe_UI_24);
        btnEqual.setFont(times_36);
        btnAdd.setFont(times_36);
        btnSubtract.setFont(times_48);
        btnNegativeMark.setFont(Segoe_UI_24);
        btnSqRt.setFont(Segoe_UI_20);
        btnDivide.setFont(times_36);
        btnClear.setFont(Segoe_UI_24);
        btnPercentage.setFont(Ebrima_24);
        btnDot.setFont(times_36);
        btnMultiply.setFont(times_36);

        btn0.setBackground(new Color(46, 35, 108));
        btn1.setBackground(new Color(46, 35, 108));
        btn2.setBackground(new Color(46, 35, 108));
        btn3.setBackground(new Color(46, 35, 108));
        btn4.setBackground(new Color(46, 35, 108));
        btn5.setBackground(new Color(46, 35, 108));
        btn6.setBackground(new Color(46, 35, 108));
        btn7.setBackground(new Color(46, 35, 108));
        btn8.setBackground(new Color(46, 35, 108));
        btn9.setBackground(new Color(46, 35, 108));
        btnDot.setBackground(new Color(46, 35, 108));
        btnNegativeMark.setBackground(new Color(46, 35, 108));
        btnEqual.setBackground(new Color(97, 94, 252));
        btnAdd.setBackground(new Color(23, 21, 59));
        btnSubtract.setBackground(new Color(23, 21, 59));
        btnSqRt.setBackground(new Color(23, 21, 59));
        btnDivide.setBackground(new Color(23, 21, 59));
        btnPercentage.setBackground(new Color(23, 21, 59));
        btnClear.setBackground(new Color(23, 21, 59));
        btnMultiply.setBackground(new Color(23, 21, 59));

        btn0.setForeground(Color.WHITE);
        btn1.setForeground(Color.WHITE);
        btn2.setForeground(Color.WHITE);
        btn3.setForeground(Color.WHITE);
        btn4.setForeground(Color.WHITE);
        btn5.setForeground(Color.WHITE);
        btn6.setForeground(Color.WHITE);
        btn7.setForeground(Color.WHITE);
        btn8.setForeground(Color.WHITE);
        btn9.setForeground(Color.WHITE);
        btnDot.setForeground(Color.WHITE);
        btnNegativeMark.setForeground(Color.WHITE);
        btnEqual.setForeground(Color.WHITE);
        btnAdd.setForeground(Color.WHITE);
        btnSubtract.setForeground(Color.WHITE);
        btnSqRt.setForeground(Color.WHITE);
        btnDivide.setForeground(Color.WHITE);
        btnPercentage.setForeground(Color.WHITE);
        btnClear.setForeground(Color.WHITE);
        btnMultiply.setForeground(Color.WHITE);

        //fonts
        Font segeo_55 = new Font("Segoe UI", Font.PLAIN, 55);

        //text field properties
        result_textField.setFont(segeo_55);
        result_textField.setEditable(false);
        result_textField.setBackground(new Color(67, 61, 139));
        result_textField.setForeground(Color.WHITE);
        result_textField.setPreferredSize(new Dimension(370, 70));
        result_textField.setText("0"); // No leading space
        result_textField.setFocusable(false);

        //layouts
        GridLayout grid_centerPanel = new GridLayout(5, 4, 3, 3);
        FlowLayout flow1 = new FlowLayout(FlowLayout.CENTER, 0, 5);
        pannel_north.setLayout(flow1);
        pannel_center.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pannel_north.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pannel_north_sub2.add(result_textField);

        GridLayout grid_sub1 = new GridLayout(1, 2, 10, 3);
        pannel_north_sub1.setLayout(grid_sub1);

        pannel_north.add(pannel_north_sub2);
        pannel_north.add(pannel_north_sub1);
        pannel_center.setLayout(grid_centerPanel);

        //panels properties
        pannel_north.setBackground(new Color(90, 99, 156));
        pannel_center.setBackground(new Color(90, 99, 156));
        pannel_east.setBackground(new Color(90, 99, 156));
        pannel_west.setBackground(new Color(90, 99, 156));
        pannel_south.setBackground(new Color(90, 99, 156));
        pannel_north_sub1.setBackground(new Color(90, 99, 156));
        pannel_north_sub2.setBackground(new Color(90, 99, 156));

        pannel_north.setPreferredSize(new Dimension(300, 150));
        pannel_north_sub1.setPreferredSize(new Dimension(370, 50));

        //add buttons to panels
        pannel_center.add(btnClear);
        pannel_center.add(btnPercentage);
        pannel_center.add(btnSqRt);
        pannel_center.add(btnDivide);
        pannel_center.add(btn7);
        pannel_center.add(btn8);
        pannel_center.add(btn9);
        pannel_center.add(btnMultiply);
        pannel_center.add(btn4);
        pannel_center.add(btn5);
        pannel_center.add(btn6);
        pannel_center.add(btnSubtract);
        pannel_center.add(btn1);
        pannel_center.add(btn2);
        pannel_center.add(btn3);
        pannel_center.add(btnAdd);
        pannel_center.add(btnNegativeMark);
        pannel_center.add(btn0);
        pannel_center.add(btnDot);
        pannel_center.add(btnEqual);

        //add panels to frame
        frame1.add(pannel_north, BorderLayout.NORTH);
        frame1.add(pannel_center, BorderLayout.CENTER);
        frame1.add(pannel_east, BorderLayout.EAST);
        frame1.add(pannel_west, BorderLayout.WEST);
        frame1.add(pannel_south, BorderLayout.SOUTH);

        //add action listeners to menu items
        view_menu_item_Dark_mode.addActionListener(this);
        view_menu_item_lightMode.addActionListener(this);

        history_menu_item_viewHistory.addActionListener(this);

        help_menu_item_help.addActionListener(this);
        help_menu_item_about.addActionListener(this);

        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btnDot.addActionListener(this);
        btnNegativeMark.addActionListener(this);
        btnEqual.addActionListener(this);
        btnAdd.addActionListener(this);
        btnSubtract.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnDivide.addActionListener(this);
        btnSqRt.addActionListener(this);
        btnPercentage.addActionListener(this);
        btnClear.addActionListener(this);

        frame1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ap) {

        Object object1 = ap.getSource();

        if (object1.equals(btn0)) {
            String currentText = result_textField.getText().trim();
            if (currentText.equals("0") || currentText.contains("Error")) {
                // do not allow multiple leading zeros
            } else {
                result_textField.setText(currentText + "0");
                zeroCount++;
            }
        } else if (object1.equals(btn1)) {
            appendDigit("1");
        } else if (object1.equals(btn2)) {
            appendDigit("2");
        } else if (object1.equals(btn3)) {
            appendDigit("3");
        } else if (object1.equals(btn4)) {
            appendDigit("4");
        } else if (object1.equals(btn5)) {
            appendDigit("5");
        } else if (object1.equals(btn6)) {
            appendDigit("6");
        } else if (object1.equals(btn7)) {
            appendDigit("7");
        } else if (object1.equals(btn8)) {
            appendDigit("8");
        } else if (object1.equals(btn9)) {
            appendDigit("9");
        } else if (object1.equals(btnDot) && decimalCount == 0) {
            decimalCount++;
            String currentText = result_textField.getText().trim();
            if (currentText.equals("") || currentText.contains("Error")) {
                result_textField.setText("0.");
            } else {
                result_textField.setText(currentText + ".");
            }
            zeroCount++;
        } else if (object1.equals(btnAdd)) {
            operatorClicked("+");
        } else if (object1.equals(btnSubtract)) {
            operatorClicked("-");
        } else if (object1.equals(btnMultiply)) {
            operatorClicked("×");
        } else if (object1.equals(btnDivide)) {
            operatorClicked("÷");
        } else if (object1.equals(btnSqRt)) {
            try {
                firstValue = result_textField.getText().trim();
                firstDoubleValue = Double.parseDouble(firstValue);
                if (firstDoubleValue < 0) {
                    result_textField.setText(" Error");
                    return;
                }
                Answer = Math.sqrt(firstDoubleValue);
                result_textField.setText(formatAnswer(Answer));
            } catch (Exception e) {
                result_textField.setText(" Error");
            }
            resetFlags();
        } else if (object1.equals(btnPercentage)) {
            try {
                secondValue = result_textField.getText().trim();

                if (firstValue == null) {
                    result_textField.setText("0");
                    return;
                }

                firstDoubleValue = Double.parseDouble(firstValue.trim());
                secondDoubleValue = Double.parseDouble(secondValue);

                if ("÷".equals(operator)) {
                    if (secondDoubleValue == 0) {
                        result_textField.setText(" Error: Divide by zero");
                        resetAll();
                        return;
                    }
                    Answer = (firstDoubleValue / secondDoubleValue) * 100;
                } else {
                    // You can define behavior for % with other operators if desired
                    Answer = (firstDoubleValue * secondDoubleValue) / 100;
                }
                result_textField.setText(formatAnswer(Answer));
                firstValue = null;
                resetFlags();
            } catch (Exception e) {
                result_textField.setText(" Error");
            }
        } else if (object1.equals(btnNegativeMark)) {
            try {
                String currentText = result_textField.getText().trim();
                if (currentText.equals("") || currentText.equals("0") || currentText.contains("Error"))
                    return;
                double val = Double.parseDouble(currentText);
                val = -val;
                result_textField.setText(formatAnswer(val));
            } catch (Exception e) {
                result_textField.setText(" Error");
            }
        } else if (object1.equals(btnEqual)) {
            if (operator == null || firstValue == null) {
                return;
            }
            try {
                secondValue = result_textField.getText().trim();

                firstDoubleValue = Double.parseDouble(firstValue.trim());
                secondDoubleValue = Double.parseDouble(secondValue);

                switch (operator) {
                    case "+":
                        Answer = firstDoubleValue + secondDoubleValue;
                        break;
                    case "-":
                        Answer = firstDoubleValue - secondDoubleValue;
                        break;
                    case "×":
                        Answer = firstDoubleValue * secondDoubleValue;
                        break;
                    case "÷":
                        if (secondDoubleValue == 0) {
                            result_textField.setText(" Error: Divide by zero");
                            resetAll();
                            return;
                        }
                        Answer = firstDoubleValue / secondDoubleValue;
                        break;
                    default:
                        return;
                }
                String expression = firstDoubleValue + " " + operator + " " + secondDoubleValue + " = " + Answer;
                historyList.add(expression);

                result_textField.setText(formatAnswer(Answer));
            } catch (Exception e) {
                result_textField.setText(" Error");
            }

            resetAll();
        } else if (object1.equals(btnClear)) {
            result_textField.setText("0");
            resetAll();
        }

        // Menu actions
        String cmd = ap.getActionCommand();

        if ("Dark mode".equals(cmd)) {
            setDarkModeColors();
            return;
        } else if ("Light mode".equals(cmd)) {
            setLightModeColors();
            return;
        } else if ("View History".equals(cmd)) {
            showHistoryWindow();
            return;
        } else if ("View Help  F1".equals(cmd)) {
            showHelpDialog();
            return;
        } else if ("About Calculator".equals(cmd)) {
            showAboutDialog();
            return;
        }
    }

    void appendDigit(String digit) {
        String currentText = result_textField.getText().trim();
        if (currentText.equals("0") || currentText.contains("Error")) {
            result_textField.setText(digit);
            zeroCount = 1;
            decimalCount = 0;
        } else {
            result_textField.setText(currentText + digit);
            zeroCount++;
        }
    }

    void operatorClicked(String op) {
        try {
            if (firstValue == null) {
                firstValue = result_textField.getText().trim();
            } else {
                secondValue = result_textField.getText().trim();

                firstDoubleValue = Double.parseDouble(firstValue);
                secondDoubleValue = Double.parseDouble(secondValue);

                switch (operator) {
                    case "+":
                        Answer = firstDoubleValue + secondDoubleValue;
                        break;
                    case "-":
                        Answer = firstDoubleValue - secondDoubleValue;
                        break;
                    case "×":
                        Answer = firstDoubleValue * secondDoubleValue;
                        break;
                    case "÷":
                        if (secondDoubleValue == 0) {
                            result_textField.setText(" Error: Divide by zero");
                            resetAll();
                            return;
                        }
                        Answer = firstDoubleValue / secondDoubleValue;
                        break;
                }
                firstValue = formatAnswer(Answer);
                result_textField.setText(firstValue);
            }
            operator = op;
            result_textField.setText("");
            resetFlags();
        } catch (Exception e) {
            result_textField.setText(" Error");
            resetAll();
        }
    }

    void showHistoryWindow() {
        if (historyFrame == null) {
            historyFrame = new Frame("Calculation History");
            historyFrame.setSize(300, 400);
            historyFrame.setLayout(new BorderLayout());

            historyTextArea = new TextArea();
            historyTextArea.setEditable(false);
            historyTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            updateHistoryTextArea();

            Button closeHistoryBtn = new Button("Close");
            closeHistoryBtn.addActionListener(e -> historyFrame.setVisible(false));

            historyFrame.add(historyTextArea, BorderLayout.CENTER);
            historyFrame.add(closeHistoryBtn, BorderLayout.SOUTH);

            historyFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    historyFrame.setVisible(false);
                }
            });
        } else {
            updateHistoryTextArea();
        }
        historyFrame.setLocationRelativeTo(frame1);
        historyFrame.setVisible(true);
    }

    void updateHistoryTextArea() {
        StringBuilder sb = new StringBuilder();
        if (historyList.isEmpty()) {
            sb.append("No history yet.");
        } else {
            for (String entry : historyList) {
                sb.append(entry).append("\n");
            }
        }
        historyTextArea.setText(sb.toString());
    }

    void showHelpDialog() {
        java.awt.Dialog helpDialog = new java.awt.Dialog(frame1, "Help", true);
        helpDialog.setLayout(new BorderLayout());
        TextArea helpText = new TextArea(
                "Calculator Usage Instructions:\n\n"
                        + "1. Enter numbers using the number buttons.\n"
                        + "2. Use +, -, ×, ÷ for basic arithmetic operations.\n"
                        + "3. Press = to get the result.\n"
                        + "4. Press C to clear current input.\n"
                        + "5. Use √ button for square root (non-negative input only).\n"
                        + "6. Use +/- to toggle sign of the current number.\n"
                        + "7. View History from History menu to see past calculations.\n"
                        + "8. Use View menu to toggle Dark/Light modes.\n\n"
                        + "Note: Division by zero will show an error message."
        );
        helpText.setEditable(false);
        helpText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        helpDialog.add(helpText, BorderLayout.CENTER);

        Button closeHelpBtn = new Button("Close");
        closeHelpBtn.addActionListener(e -> helpDialog.dispose());
        helpDialog.add(closeHelpBtn, BorderLayout.SOUTH);

        helpDialog.setSize(400, 300);
        helpDialog.setLocationRelativeTo(frame1);
        helpDialog.setVisible(true);
    }

    void showAboutDialog() {
        java.awt.Dialog aboutDialog = new java.awt.Dialog(frame1, "About Calculator", true);
        aboutDialog.setLayout(new BorderLayout());
        TextArea aboutText = new TextArea(
                "AWT Calculator\n"
                        + "Developed by User\n"
                        + "Simple calculator with basic arithmetic functions, history, and dark/light modes."
        );
        aboutText.setEditable(false);
        aboutText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        aboutDialog.add(aboutText, BorderLayout.CENTER);

        Button closeBtn = new Button("Close");
        closeBtn.addActionListener(e -> aboutDialog.dispose());
        aboutDialog.add(closeBtn, BorderLayout.SOUTH);

        aboutDialog.setSize(350, 200);
        aboutDialog.setLocationRelativeTo(frame1);
        aboutDialog.setVisible(true);
    }

    void setDarkModeColors() {
        frame1.setBackground(new Color(67, 61, 139));
        pannel_north.setBackground(new Color(90, 99, 156));
        pannel_center.setBackground(new Color(90, 99, 156));
        pannel_east.setBackground(new Color(90, 99, 156));
        pannel_west.setBackground(new Color(90, 99, 156));
        pannel_south.setBackground(new Color(90, 99, 156));
        pannel_north_sub1.setBackground(new Color(90, 99, 156));
        pannel_north_sub2.setBackground(new Color(90, 99, 156));

        result_textField.setBackground(new Color(67, 61, 139));
        result_textField.setForeground(Color.WHITE);

        Color btnNumberColor = new Color(46, 35, 108);
        Color btnOperatorColor = new Color(23, 21, 59);
        Color btnEqualColor = new Color(97, 94, 252);

        btn0.setBackground(btnNumberColor);
        btn1.setBackground(btnNumberColor);
        btn2.setBackground(btnNumberColor);
        btn3.setBackground(btnNumberColor);
        btn4.setBackground(btnNumberColor);
        btn5.setBackground(btnNumberColor);
        btn6.setBackground(btnNumberColor);
        btn7.setBackground(btnNumberColor);
        btn8.setBackground(btnNumberColor);
        btn9.setBackground(btnNumberColor);
        btnDot.setBackground(btnNumberColor);
        btnNegativeMark.setBackground(btnNumberColor);

        btnEqual.setBackground(btnEqualColor);
        btnAdd.setBackground(btnOperatorColor);
        btnSubtract.setBackground(btnOperatorColor);
        btnSqRt.setBackground(btnOperatorColor);
        btnDivide.setBackground(btnOperatorColor);
        btnPercentage.setBackground(btnOperatorColor);
        btnClear.setBackground(btnOperatorColor);
        btnMultiply.setBackground(btnOperatorColor);

        Color foreColor = Color.WHITE;

        btn0.setForeground(foreColor);
        btn1.setForeground(foreColor);
        btn2.setForeground(foreColor);
        btn3.setForeground(foreColor);
        btn4.setForeground(foreColor);
        btn5.setForeground(foreColor);
        btn6.setForeground(foreColor);
        btn7.setForeground(foreColor);
        btn8.setForeground(foreColor);
        btn9.setForeground(foreColor);
        btnDot.setForeground(foreColor);
        btnNegativeMark.setForeground(foreColor);
        btnEqual.setForeground(foreColor);
        btnAdd.setForeground(foreColor);
        btnSubtract.setForeground(foreColor);
        btnSqRt.setForeground(foreColor);
        btnDivide.setForeground(foreColor);
        btnPercentage.setForeground(foreColor);
        btnClear.setForeground(foreColor);
        btnMultiply.setForeground(foreColor);
    }

    void setLightModeColors() {
        Color bgColor = new Color(240, 240, 240);
        frame1.setBackground(bgColor);
        pannel_north.setBackground(bgColor);
        pannel_center.setBackground(bgColor);
        pannel_east.setBackground(bgColor);
        pannel_west.setBackground(bgColor);
        pannel_south.setBackground(bgColor);
        pannel_north_sub1.setBackground(bgColor);
        pannel_north_sub2.setBackground(bgColor);

        result_textField.setBackground(Color.WHITE);
        result_textField.setForeground(new Color(67, 61, 139));

        Color btnNumberColor = Color.WHITE;
        Color btnOperatorColor = bgColor;
        Color btnEqualColor = new Color(200, 172, 214);
        Color numberForeColor = new Color(67, 61, 139);

        btn0.setBackground(btnNumberColor);
        btn1.setBackground(btnNumberColor);
        btn2.setBackground(btnNumberColor);
        btn3.setBackground(btnNumberColor);
        btn4.setBackground(btnNumberColor);
        btn5.setBackground(btnNumberColor);
        btn6.setBackground(btnNumberColor);
        btn7.setBackground(btnNumberColor);
        btn8.setBackground(btnNumberColor);
        btn9.setBackground(btnNumberColor);
        btnDot.setBackground(btnNumberColor);
        btnNegativeMark.setBackground(btnNumberColor);

        btnEqual.setBackground(btnEqualColor);
        btnAdd.setBackground(btnOperatorColor);
        btnSubtract.setBackground(btnOperatorColor);
        btnSqRt.setBackground(btnOperatorColor);
        btnDivide.setBackground(btnOperatorColor);
        btnPercentage.setBackground(btnOperatorColor);
        btnClear.setBackground(btnOperatorColor);
        btnMultiply.setBackground(btnOperatorColor);

        btn0.setForeground(numberForeColor);
        btn1.setForeground(numberForeColor);
        btn2.setForeground(numberForeColor);
        btn3.setForeground(numberForeColor);
        btn4.setForeground(numberForeColor);
        btn5.setForeground(numberForeColor);
        btn6.setForeground(numberForeColor);
        btn7.setForeground(numberForeColor);
        btn8.setForeground(numberForeColor);
        btn9.setForeground(numberForeColor);
        btnDot.setForeground(numberForeColor);
        btnNegativeMark.setForeground(numberForeColor);

        btnEqual.setForeground(Color.WHITE);
        btnAdd.setForeground(numberForeColor);
        btnSubtract.setForeground(numberForeColor);
        btnSqRt.setForeground(numberForeColor);
        btnDivide.setForeground(numberForeColor);
        btnPercentage.setForeground(numberForeColor);
        btnClear.setForeground(numberForeColor);
        btnMultiply.setForeground(numberForeColor);
    }

    void resetFlags() {
        decimalCount = 0;
        zeroCount = 0;
    }

    void resetAll() {
        resetFlags();
        operator = null;
        firstValue = null;
    }

    String formatAnswer(double ans) {
    if (ans == (int) ans) {
        return Integer.toString((int) ans);
    } else {
        DecimalFormat df = new DecimalFormat("#.####"); // limits to 4 decimal places
        return df.format(ans);
    }
}
}

public class AWTCalculator {

    public static void main(String[] args) {
        new cal();
    }
}
