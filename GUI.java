import javax.swing.*;



public  class  GUI  extends  JFrame {

        //attributes  to  store  out  widgets
        private JLabel label;
        private JTextField textField;
        private JButton button;

        public GUI() {
            setLayout(null);     //   turn  off the  default  layout  manager
            //create  components  instances
            label = new JLabel("Enter  some  text:");
            textField = new JTextField(20);
            textField.setToolTipText("Enter  some  text  here!");
            button = new JButton("Press  here!");
            button.setEnabled(false);

            //add the  components  to the  frame
            add(label);
            add(textField);
            add(button);
            //position  the  components  and  size  them
            label.setBounds(10, 20, 300, 50);
            textField.setBounds(110, 30, 200, 30);
            button.setBounds(110, 70, 100, 30);

        }

        public static void main(String[] args) {
            GUI frame = new GUI();
            frame.setTitle("An  example  of a manually  positioned  frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(200, 170, 500, 200);
            frame.setVisible(true);
        }
}

