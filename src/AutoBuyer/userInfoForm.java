package AutoBuyer;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class userInfoForm extends JPanel {

    static final JTextField em1 = new JTextField("youremail@domain.com");
    static String email;
    static final JTextField name1 = new JTextField("First");
    static String fname;
    static final JTextField last1 = new JTextField("Last");
    static String lname;
    static final JTextField add1 = new JTextField("999 Upper Wentworth St");
    static String addy;
    static final JTextField post = new JTextField("L9A 4X5");
    static String postal;
    static String prov;
    static final JTextField phone1 = new JTextField("9053874455");
    static String phone;
    static final JTextField ccInfo1 = new JTextField("4111111111111111");
    static String cc;
    static String emonth;
    static String eyear;
    static final JTextField ccv1 = new JTextField("123");
    static String cvv;
    static final JTextField townl = new JTextField("Hamilton");
    static String city;



    public userInfoForm(){
        JFrame frame = new JFrame("Item Selection");
        frame.setBounds(300,0,400,500);
        frame.add(this);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        buildForm();
        frame.setVisible(true);
    }

    private void buildForm(){

        JLabel name = new JLabel("First Name: ");
        name.setBounds(20,30,250,30) ;
        name1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                name1.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        name1.setBounds(100,30,250,30);

        JLabel last_name = new JLabel("Last Name");
        last_name.setBounds(20,60,250,30);
        last1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                last1.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        last1.setBounds(100,60,250,30);

        JLabel uaddress = new JLabel("Address: ");
        uaddress.setBounds(20,90,250,30);
        add1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                add1.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        add1.setBounds(100,90,250,30);

        String[] provinces = {"Alberta","British Columbia","Manitoba", "New Brunswick", "Newfoundland and Labrador", "Nova Scotia",
                "Ontario","Prince Edward Island","Quebec","Saskatchewan","Northwest Territories","Nunavut","Yukon"};
        JLabel uprovince = new JLabel("Province");
        uprovince.setBounds(20,120,250,30);
        JComboBox<String> prov1 = new JComboBox<>(provinces);
        prov1.setBounds(100,120,250,30);

        JLabel town = new JLabel("City");
        town.setBounds(20,150,250,30);
        townl.setBounds(100,150,250,30);
        townl.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                townl.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        JLabel postalCode = new JLabel("Postal Code");
        postalCode.setBounds(20,180,250,30);
        post.setBounds(100,180,250,30);
        post.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                post.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        JLabel uphone = new JLabel("Phone Number");
        uphone.setBounds(20,210,250,30);
        phone1.setBounds(100,210,250,30);
        phone1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                phone1.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        JLabel ccInfo = new JLabel("Credit Card #");
        ccInfo.setBounds(20,240,250,30);
        ccInfo1.setBounds(100,240,250,30);
        ccInfo1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                ccInfo1.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        String[] month = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        JLabel expMonth = new JLabel("Exp");
        expMonth.setBounds(20,270,250,30);
        JComboBox<String> expMonth1 = new JComboBox<>(month);
        expMonth1.setBounds(100,270,50,30);

        String[] year = {"20","21","22","23","24","25","26","27","28","29","30","31"};
        JComboBox<String> expYear1 = new JComboBox<>(year);
        expYear1.setBounds(150,270,50,30);

        JLabel ccv = new JLabel("ccv");
        ccv.setBounds(20,300,250,30);
        ccv1.setBounds(100,300,250,30);
        ccv1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                ccv1.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        JLabel em = new JLabel("email");
        em.setBounds(20,330,250,30);
        em1.setBounds(100,330,250,30);
        em1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                em1.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {

            }
        });


        JButton button = new JButton("Submit");
        button.setBounds(100,370,100,30);
        button.addActionListener(e -> {
            fname = name1.getText();
            lname = last1.getText();
            addy = add1.getText();
            postal = post.getText();
            prov = (String)prov1.getSelectedItem();
            phone = phone1.getText();
            email = em1.getText();
            cc = ccInfo1.getText();
            emonth = (String)expMonth1.getSelectedItem();
            eyear = "20"+(String)expYear1.getSelectedItem();
            cvv = ccv1.getText();
            city = townl.getText();
            itemSelection item = new itemSelection();
        });

        add(name);
        add(last_name);
        add(uaddress);
        add(uprovince);
        add(postalCode);
        add(uphone);
        add(name1);
        add(last1);
        add(add1);
        add(prov1);
        add(post);
        add(phone1);
        add(ccInfo);
        add(ccInfo1);
        add(expMonth);
        add(expMonth1);
        add(expYear1);
        add(ccv);
        add(ccv1);
        add(button);
        add(town);
        add(townl);
        add(em);
        add(em1);
    }

    static String getFname(){return fname;}

    static String getLname() {return lname;}

    static String getEmail() {return email;}

    static String getAddy() { return addy;}

    static String getPostal() { return postal;}

    static String getProv() { return prov;}

    static String getCity() { return city;}

    static String getCc() {return cc;}

    static String getEmonth() {return emonth;}

    static String getEyear() {return eyear;}

    static String getCvv() {return cvv;}

    static String getPhone() {return phone; }
}
