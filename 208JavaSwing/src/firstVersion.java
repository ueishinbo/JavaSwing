import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class firstVersion {
    private static JFrame frame;
    public static JPanel panel;
    public static void main(String[] args) {
         frame = new JFrame("BOOK HOTEL ROOM");
        // Setting the  width and height of frame
        //frame.setSize(450, 550);
        frame.setSize(700,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置打开窗口的位置
        frame.setLocation(430,160);
        //设置窗口大小固定
        frame.setResizable(false);
        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
         panel = new JPanel();
        // 添加面板
        placeComponents(panel);
        frame.add(panel);


        /*
        设置背景
         */
        background(frame);
        // 设置界面可见

        frame.setVisible(true);
    }

    public static void background(JFrame frame){
        //ImageIcon icon = new ImageIcon("/Users/shinbouei/IdeaProjects/208JavaSwing/src/hotel3.jpeg");
        ImageIcon icon = new ImageIcon("./src/hotel3.jpeg");
        JLabel label = new JLabel(icon);
        label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel)frame.getContentPane();
        j.setOpaque(false);
    }
    private static void placeComponents(JPanel panel1) {
       // panel.setBounds(0,0,20,20);
        panel1.setLayout(null);

        // 创建 JLabel
        JLabel userLabel = new JLabel("Name:");
        userLabel.setBounds(10,20,180,30);
        panel1.add(userLabel);

        /*
         * 创建文本域用于用户输入
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(110,20,165,30);
        //实时获取到输入框中的内容
        /*userText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println(userText.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //System.out.println(userText.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // System.out.println(userText.getText());
            }
        });*/
        panel1.add(userText);

        /**
         * 获取电话信息
         */
        JLabel phoneNumber = new JLabel("Phone Number");
        phoneNumber.setBounds(10,60,100,30);
        panel1.add(phoneNumber);
        JTextField InputPhone = new JTextField(20);
        InputPhone.setBounds(110,60,165,30);
        /*InputPhone.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");

               // System.out.println(InputPhone.getText());
                if ( pattern.matcher(InputPhone.getText()).matches()){
                    System.out.println("对的");
                }else {
                    System.out.println("错的");
                    JLabel faultInfo = new JLabel("错了");
                    faultInfo.setBounds(0,0,180,25);
                    panel1.add(faultInfo);
                    //System.out.println("1");

                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });*/
        panel1.add(InputPhone);
        /**
         * 选择房间类型下拉列表
         */
        JLabel passwordLabel = new JLabel("Room Type:");
        passwordLabel.setBounds(10,100,80,30);
        panel1.add(passwordLabel);
        //选择房间类型下拉列表
        JComboBox cmb=new JComboBox();
        cmb.setBounds(110,100,170,30);
        cmb.addItem("----choose----");    //向下拉列表中添加一项
        cmb.addItem("normal(20$)");
        cmb.addItem("middle(40$)");
        cmb.addItem("  vip(99$)");
        cmb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(cmb.getSelectedItem().toString());
                //new roomTypeImage(cmb.getSelectedItem().toString(),panel);
                new roomTypeImage("aa",panel1);
            }
        });
        panel1.add(cmb);

        //*测试直接加

        /**
         * 选择入住时间
         */
        JLabel checkInData = new JLabel("Check  In  Data:");
        checkInData.setBounds(10,140,100,30);
        panel1.add(checkInData);

        JTextField selectCheckIn = new JTextField(20);
        selectCheckIn.setBounds(110,140,165,30);
        //获取日期组建
        calendarUtil ser = calendarUtil.getInstance();
        //使用日期组建
        ser.register(selectCheckIn);
        panel1.add(selectCheckIn);

        /**
         * 选择退房时间
         */
        JLabel checkOutData = new JLabel("Check Out Data:");
        checkOutData.setBounds(10,180,110,30);
        panel1.add(checkOutData);

        JTextField selectCheckOut = new JTextField(20);
        selectCheckOut.setBounds(110,180,165,30);
        //获取日期组建
        calendarUtil ser1 = calendarUtil.getInstance();
        //使用日期组建
        ser1.register(selectCheckOut);
        panel1.add(selectCheckOut);


        /**
         * 显示入住天数
         */
        JLabel scheduledDay = new JLabel("Schedule Day:");
        scheduledDay.setBounds(10,220,100,30);
        panel1.add(scheduledDay);
        JLabel scheduledDayDetail = new JLabel("0");
        scheduledDayDetail.setBounds(110,220,180,30);

        panel1.add(scheduledDayDetail);

        /**
         *显示总金额
         */
        JLabel showMoney = new JLabel("Total Amount:");
        showMoney.setBounds(10,260,100,30);
        panel1.add(showMoney);
        JLabel showMoneyDetail = new JLabel("0");
        showMoneyDetail.setBounds(110,260,180,30);
        //showMoneyDetail.addAncestorListener();
        panel1.add(showMoneyDetail);

        /**
         * 重新输入按钮
         */
        JButton reset = new JButton("Reset");
        reset.setBounds(100, 320, 180, 30);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("a" + userText.getText());
                userText.setText("");
                cmb.setSelectedItem("----choose----");
                selectCheckOut.setText("");
                selectCheckIn.setText("");
                showMoneyDetail.setText("0");
                scheduledDayDetail.setText("0");
                InputPhone.setText("");
            }
        });
        panel1.add(reset);
        /**
         * 获取所有信息并展示
         */
        JButton getInfo = new JButton("Show Details");
        getInfo.setFont(new Font("Calibri",Font.BOLD,10));
        getInfo.setBounds(180,290,100,25);
        getInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomType = cmb.getSelectedItem().toString();
                String inData = selectCheckIn.getText();
                String outData = selectCheckOut.getText();
                /*System.out.println(roomType);
                System.out.println(inData);
                System.out.println(outData);*/
                scheduledDayDetail.setText(calculateDay(inData,outData));
                showMoneyDetail.setText(calculateMoney(inData,outData,roomType));
            }
        });
        panel1.add(getInfo);
        /**
         * 查看地图按钮
         */
        /*JButton Maps = new JButton("show Map");
        Maps.setBounds(100, 310, 180, 25);
        Maps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("bab");
                //ImageIcon map = new ImageIcon("/Users/shinbouei/IdeaProjects/208JavaSwing/src/map.png");
                JLabel labelMap = new JLabel("hahah");
                labelMap.setBounds(0,0,20,20);
                panel1.add(labelMap);
            }
        });
        panel1.add(Maps);*/
        /**
         * 预定按钮
         */
        // 创建登录按钮
        JButton loginButton = new JButton("confirm");
        loginButton.setBounds(100, 355, 180, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");

                if (!pattern.matcher(InputPhone.getText()).matches()){
                    System.out.println("到了");
                    JOptionPane.showMessageDialog(new JPanel(), "please write correct phone number", "faile",JOptionPane.WARNING_MESSAGE);
                }
                if (scheduledDayDetail.getText().equals("0")){
                    JOptionPane.showMessageDialog(new JPanel(), "please write all info above", "faile",JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(new JPanel(), "Dear " + userText.getText()+",\n your order is successful. "
                            +"\nbooking day: "+ scheduledDayDetail.getText()+"\n amount: " + showMoneyDetail.getText(), "success",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        panel1.add(loginButton);

        /**
         * 地图
         */
        /*JLabel ditu = new JLabel(new ImageIcon("/Users/shinbouei/IdeaProjects/208JavaSwing/src/map.png"));
        ditu.setBounds(10,500,430,215);
        panel.add(ditu);*/

        JPanel map = new imagePanel();
        map.setBounds(10,390,680,325);
        panel1.add(map);

        //设置酒店类型的背景图片
        //new roomTypeImage("aa",panel1);
        JButton room1 = new JButton("normal");
        room1.setBounds(345,235,100,25);

        room1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel a = new JLabel();
                panel.add(a);

                a.setBounds(350,30,300,200);
                a.setIcon(new ImageIcon("./src/normal.jpg"));
                //a.setIcon(new ImageIcon("./normal.jpg"));
            }
        });
        panel.add(room1);

        //设置酒店类型背景图片2
        JButton room2 = new JButton("middle");
        room2.setBounds(445,235,100,25);
        room2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel a = new JLabel();
                panel.add(a);
                a.setBounds(350,30,300,200);
                a.setIcon(new ImageIcon("./src/vip.jpg"));
            }
        });
        panel.add(room2);

        //设置酒店类型背景图片3
        JButton room3 = new JButton("vip");
        room3.setBounds(545,235,100,25);
        panel.add(room3);
        /*level.setBounds(350,30,300,200);
        panel.add(level);*/
        //设置为透明
        panel1.setOpaque(false);
    }

    public static String calculateMoney(String checkInDay,String checkOutDay,String roomType) {
        int roomPrice = 0;
        if (checkInDay.equals("") || checkOutDay.equals("")){
            return "please fill check in/out day";
        }else if (roomType.equals("----choose----")){
            return "please choose room type";
        }
        if (calculate(checkInDay,checkOutDay) <= 0){
            return "illegal choose";
        }
        if (roomType.equals("normal(20$)")){
            roomPrice = 20;
        }else if (roomType.equals("middle(40$)")){
            roomPrice = 40;
        }else if (roomType.equals("  vip(99$)")){
            roomPrice = 99;
        }
        Long result = calculate(checkInDay,checkOutDay) * roomPrice;
        return result.toString();
    }

    public static String calculateDay(String checkInDay,String checkOutDay){
        if (checkInDay.equals("") || checkOutDay.equals("")){
            return "please fill check in/out day";
        }else {
            Long result = calculate(checkInDay,checkOutDay);
            if (result <= 0){
                return "illegal choose";
            }else {
                return result.toString();
            }
        }

    }
    public static long calculate(String day1, String day2){
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date star = dft.parse(day1);//开始时间
            Date endDay=dft.parse(day2);//结束时间
            Long starTime=star.getTime();
            Long endTime=endDay.getTime();
            Long num=endTime-starTime;//时间戳相差的毫秒数
            //System.out.println("相差天数为："+num/24/60/60/1000);//除以一天的毫秒数
            Long a=  num/24/60/60/1000;
            return a;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void roomTyp(){

    }
}
class roomTypeImage extends JPanel{
    roomTypeImage(String roomType,JPanel panel){
        System.out.println(roomType);
        JLabel jl3=new JLabel(new ImageIcon("./src/map.png"));
        jl3.setBounds(350,30,300,200);
        panel.add(jl3);
    }
}
class imagePanel extends JPanel{
    private DragStatus status = DragStatus.Ready;  // 拖拽状态
    File file = new File("./src/map.png");
    Image image = Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath());;// 要显示的图片
    private Point imagePosition = new Point(0, 0), // 图片的当前位置
            imageStartposition = new Point(0, 0),  // 每次拖拽开始时图片的位置（也就是上次拖拽后的位置）
            mouseStartposition;           // 每次拖拽开始时鼠标的位置
    imagePanel(){
        addMouseListener(new MouseListener() {
            // 双击鼠标时打开图片
            public void mouseClicked(MouseEvent e) {

            }
            // 按下鼠标时，更改状态，并且记录拖拽起始位置。
            public void mousePressed(MouseEvent e) {
                if (status == DragStatus.Ready) {
                    status = DragStatus.Dragging;
                    mouseStartposition = e.getPoint();
                    imageStartposition.setLocation(imagePosition.getLocation());
                }
            }
            // 松开鼠标时更改状态
            public void mouseReleased(MouseEvent e) {
                if (status == DragStatus.Dragging) {
                    status = DragStatus.Ready;
                }
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseExited(MouseEvent e) {
            }
        });
        addMouseMotionListener(new MouseMotionListener() {
            // Java 有拖拽事件，在这个事件中移动图片位置
            public void mouseDragged(MouseEvent e) {
                if (status == DragStatus.Dragging) {
                    moveImage(e.getPoint());
                }
            }
            public void mouseMoved(MouseEvent e) {
            }
        });
    }
    private enum DragStatus {
        Ready, Dragging
    }
    private void moveImage(Point point) {
        // 图片的当前位置等于图片的起始位置加上鼠标位置的偏移量。
        imagePosition.setLocation(
                imageStartposition.getX() + (point.getX() - mouseStartposition.getX()),
                imageStartposition.getY() + (point.getY() - mouseStartposition.getY())
        );
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, (int) imagePosition.getX(), (int) imagePosition.getY(), this);
        }
    }
}