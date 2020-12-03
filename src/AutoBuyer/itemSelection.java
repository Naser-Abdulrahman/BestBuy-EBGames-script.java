package AutoBuyer;

import javax.swing.*;
import java.util.Enumeration;

public class itemSelection extends JPanel{
    public final int w = 400;
    public final int h = 600;
    ButtonGroup type = new ButtonGroup();
    ButtonGroup linky = new ButtonGroup();
    JRadioButton digital  = new JRadioButton("digital");
    JRadioButton tray = new JRadioButton("ps5");
    JRadioButton serX = new JRadioButton("serX");
    JRadioButton serS = new JRadioButton("serS");
    JRadioButton other = new JRadioButton("other");
    JRadioButton bbLink = new JRadioButton("BestBuy");
    JRadioButton ebLink = new JRadioButton("EB Games");
    JRadioButton digitalBundle = new JRadioButton("DB");
    JRadioButton consoleBundle = new JRadioButton("CB");
    JLabel source = new JLabel("Please select the domain of the link below");
    JTextField link = new JTextField();
    JLabel bb = new JLabel("BestBuy");
    JLabel eb = new JLabel("EB Games");
    final String ps5DBestBuy = "https://www.bestbuy.ca/en-ca/product/playstation-5-digital-edition-console-online-only/14962184";
    final String ps5BestBuy = "https://www.bestbuy.ca/en-ca/product/playstation-5-console-online-only/14962185";
    final String ps5DEBgames = "https://www.ebgames.ca/PS5/Games/877523";
    final String ps5EBGames = "https://www.ebgames.ca/PS5/Games/877522";
    final String xboxXBestBuy  = "https://www.bestbuy.ca/en-ca/product/xbox-series-x-1tb-console-new-model-online-only/14964951";
    final String xboxSBestBuy = "https://www.bestbuy.ca/en-ca/product/xbox-series-s-512gb-console-new-model-online-only/14964950";
    final String xboxSEBGames = "https://www.ebgames.ca/Xbox%20Series%20X/Games/877780";
    final String xboxXEBGames = "https://www.ebgames.ca/Xbox%20Series%20X/Games/877779";
    final String ps5DBundle = "https://www.ebgames.ca/PS5/Games/877753/";
    final String ps5Bundle = "https://www.ebgames.ca/PS5/Games/877752/";

    public itemSelection() {
        JFrame frame = new JFrame("Item Selection");
        frame.setBounds(300,0,w,h);
        frame.add(this);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        buildGUI();
    }

    public ButtonModel needs() {
        return type.getSelection();
    }

    public void testtt() {
        Enumeration<AbstractButton> needy = type.getElements();
        while (needy.hasMoreElements()){
            JRadioButton temp = (JRadioButton)needy.nextElement();
            if (temp.isSelected()){
                switch (temp.getText()) {
                    case "digital":
                        ps5Digital();
                        break;
                    case "ps5":
                        ps5();
                        break;
                    case "serS":
                        seriesS();
                        break;
                    case "serX":
                        seriesX();
                        break;
                    case ("other"):
                        other();
                        break;
                    case ("DB"):
                        dBundle();
                        break;
                    case ("CB"):
                        cBundle();
                        break;
                }
            }
        }
    }

    public void buildGUI(){
        JLabel DB = new JLabel("Digital Bundle ~598.98");
        DB.setBounds(60, 190, 150, 20);
        digitalBundle.setBounds(30, 190, 20, 20);
        digitalBundle.addActionListener(e -> {
            if (other.isSelected()){
                link.setVisible(true);
                bbLink.setVisible(true);
                ebLink.setVisible(true);
                source.setVisible(true);
                bb.setVisible(true);
                eb.setVisible(true);
            }
            else {
                link.setVisible(false);
                bbLink.setVisible(false);
                ebLink.setVisible(false);
                source.setVisible(false);
                bb.setVisible(false);
                eb.setVisible(false);
            }
        });
        JLabel CB = new JLabel("Console Bundle ~$719.98");
        CB.setBounds(200,190,150,20);
        consoleBundle.setBounds(180,20,20,20);
        consoleBundle.addActionListener(e -> {
            if (other.isSelected()){
                link.setVisible(true);
                bbLink.setVisible(true);
                ebLink.setVisible(true);
                source.setVisible(true);
                bb.setVisible(true);
                eb.setVisible(true);
            }
            else {
                link.setVisible(false);
                bbLink.setVisible(false);
                ebLink.setVisible(false);
                source.setVisible(false);
                bb.setVisible(false);
                eb.setVisible(false);
            }
        });

        JLabel ps5D = new JLabel("Playstation 5 Digital");
        ps5D.setBounds(60,20,150,20);
        digital.setBounds(30,20,20,20);
        digital.addActionListener(e -> {
            if (other.isSelected()){
                link.setVisible(true);
                bbLink.setVisible(true);
                ebLink.setVisible(true);
                source.setVisible(true);
                bb.setVisible(true);
                eb.setVisible(true);
            }
            else {
                link.setVisible(false);
                bbLink.setVisible(false);
                ebLink.setVisible(false);
                source.setVisible(false);
                bb.setVisible(false);
                eb.setVisible(false);
            }
        });

        JLabel ps5 = new JLabel("Playstation 5 non-Digital");
        ps5.setBounds(200,20,150,20);
        tray.setBounds(180,20,20,20);
        tray.addActionListener(e -> {
            if (other.isSelected()){
                link.setVisible(true);
                bbLink.setVisible(true);
                ebLink.setVisible(true);
                source.setVisible(true);
                bb.setVisible(true);
                eb.setVisible(true);
            }
            else {
                link.setVisible(false);
                bbLink.setVisible(false);
                ebLink.setVisible(false);
                source.setVisible(false);
                bb.setVisible(false);
                eb.setVisible(false);
            }
        });

        JLabel xbs = new JLabel("XBOX Series S");
        xbs.setBounds(60,60,150,20);
        serS.setBounds(30,60,20,20);
        serS.addActionListener(e -> {
            if (other.isSelected()){
                link.setVisible(true);
                bbLink.setVisible(true);
                ebLink.setVisible(true);
                source.setVisible(true);
                bb.setVisible(true);
                eb.setVisible(true);
            }
            else {
                link.setVisible(false);
                bbLink.setVisible(false);
                ebLink.setVisible(false);
                source.setVisible(false);
                bb.setVisible(false);
                eb.setVisible(false);
            }
        });

        JLabel xbx = new JLabel("XBOX Series X");
        xbx.setBounds(200,60,150,20);
        serX.setBounds(180,60,20,20);
        serX.addActionListener(e -> {
            if (other.isSelected()){
                link.setVisible(true);
                bbLink.setVisible(true);
                ebLink.setVisible(true);
                source.setVisible(true);
                bb.setVisible(true);
                eb.setVisible(true);
            }
            else {
                link.setVisible(false);
                bbLink.setVisible(false);
                ebLink.setVisible(false);
                source.setVisible(false);
                bb.setVisible(false);
                eb.setVisible(false);
            }
        });

        JLabel ot = new JLabel("Other :");
        link.setBounds(120,100,250,20);
        link.setEditable(false);
        ot.setBounds(60,100,100,20);
        other.setBounds(30,100,20,20);
        other.addActionListener(e -> {
            if (other.isSelected()){
                link.setVisible(true);
                bbLink.setVisible(true);
                ebLink.setVisible(true);
                source.setVisible(true);
                bb.setVisible(true);
                eb.setVisible(true);
            }
            else {
                link.setVisible(false);
                bbLink.setVisible(false);
                ebLink.setVisible(false);
                source.setVisible(false);
                bb.setVisible(false);
                eb.setVisible(false);
            }
        });

        source.setBounds(60,130,250,20);
        bb.setBounds(60,160,50,20);
        bbLink.setBounds(30,160,20,20);
        eb.setBounds(150,160,80,20);
        ebLink.setBounds(120,160,20,20);
        bb.setVisible(false);
        eb.setVisible(false);
        ebLink.setVisible(false);
        bbLink.setVisible(false);

        JButton button = new JButton("Submit");
        button.setBounds(100,260,100,30);
        button.addActionListener( e -> testtt());
        type.add(digital);
        type.add(tray);
        type.add(serS);
        type.add(serX);
        type.add(other);
        type.add(digitalBundle);
        type.add(consoleBundle);
        linky.add(bbLink);
        linky.add(ebLink);
        add(digital);
        add(tray);
        add(serS);
        add(serX);
        add(other);
        add(bbLink);
        add(ebLink);
        add(ps5D);
        add(ps5);
        add(xbs);
        add(xbx);
        add(ot);
        add(eb);
        add(bb);
        add(link);
        add(source);
        add(button);
        add(digitalBundle);
        add(consoleBundle);
        add(CB);
        add(DB);
    }

    public void ps5Digital() {
        script.url = ps5DBestBuy;
        script.url2 = ps5DEBgames;
        script.refresher();
    }

    public void ps5() {
        script.url = ps5BestBuy;
        script.url2 = ps5EBGames;
        script.refresher();
    }

    public void seriesS() {
        script.url = xboxSBestBuy;
        script.url2 = xboxSEBGames;
        script.refresher();
    }

    public void seriesX() {
        script.url = xboxXBestBuy;
        script.url2 = xboxXEBGames;
        script.refresher();
    }

    public void other() {
        Enumeration<AbstractButton> extraNeedy = linky.getElements();
        while (extraNeedy.hasMoreElements()){
            JRadioButton temp = (JRadioButton)extraNeedy.nextElement();
            if (temp.getText().equals("BestBuy")) {
                script.url = link.getText();
                script.oBB();
            }
            if (temp.getText().equals("EB Games")) {
                script.url2 = link.getText();
                script.oEB();
            }
        }
    }

    public void dBundle() {
        script.url2 = ps5DBundle;
        script.bundleAdd();
    }
    public void cBundle(){
        script.url2 = ps5Bundle;
        script.bundleAdd();
    }
}
