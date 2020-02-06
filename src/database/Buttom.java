package database;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Buttom extends JFrame implements ActionListener {
    String account;
    String password;
    String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=STU";
    Connection conR;
    Statement statement;

    JPanel jpl = new JPanel(null);
    JButton JB_add = new JButton("INSERT STUDENTS INFO");
    JButton JB_sc = new JButton("INSERT STUDENT GRADE");
    JButton JB_search = new JButton("SEARCH");
    JButton JB_searchsc = new JButton("SEARCH FOR CLASSES");
    JButton JB_searchpro = new JButton("SEARCH FOR PROFS");
    JButton JB_searchfire = new JButton("DROP OUT LIST");

    JTextField jtid;
    JTextField jtname;
    JTextField jtsex;
    JTextField jtbirth;
    JTextField jtclass;
    JTextField jtclnum;
    JTextField jtsc;
    JTextField jtmaj;

    JTextArea jtinfor;
    JScrollPane jsinfor;

    String id = null;
    String name = null;
    String sex = null;
    String birth = null;
    String clas = null;
    String cno = null;
    String grade = null;
    String cname = null;
    String prop = null;
    String per = null;
    String credit = null;
    String pro = null;
    String ave = null;

    public Buttom(String ac, String pw) {
        this.setTitle("STUDENTS INFO MANAGEMENT");
        this.setSize(500, 500);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        account = ac;
        password = pw;

        //		CONNECT THE DATABASE
        try {
            Class.forName(JDriver);
            conR = DriverManager.getConnection(connectDB, account, password);
            statement = conR.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            dispose();
        }

        JLabel lb0 = new JLabel("STUDENTS INFO MANAGEMENT");
        this.add(lb0);

        JButton jbt = new JButton();                                    //CHANGE THE ROW
        jbt.setPreferredSize(new Dimension(400, 1));
        jbt.setBorderPainted(false);
        jbt.setContentAreaFilled(false);
        this.add(jbt);

        //		BUTTOM ON MAIN MENU
        JB_add.setBorderPainted(false);
        JB_add.setActionCommand("jbadd");
        JB_add.addActionListener(this);
        this.add(JB_add);

        JB_sc.setBorderPainted(false);
        JB_sc.setActionCommand("jbsc");
        JB_sc.addActionListener(this);
        this.add(JB_sc);

        JB_search.setBorderPainted(false);
        JB_search.setActionCommand("jbsearch");
        JB_search.addActionListener(this);
        this.add(JB_search);

        JB_searchsc.setBorderPainted(false);
        JB_searchsc.setActionCommand("jbsearchsc");
        JB_searchsc.addActionListener(this);
        this.add(JB_searchsc);

        JB_searchpro.setBorderPainted(false);
        JB_searchpro.setActionCommand("jbsearchpro");
        JB_searchpro.addActionListener(this);
        this.add(JB_searchpro);

        JB_searchfire.setBorderPainted(false);
        JB_searchfire.setActionCommand("jbsearchfire");
        JB_searchfire.addActionListener(this);
        this.add(JB_searchfire);

    }

    //	PANEL ON MAIN MENU
    public JPanel createAdd() {                                            //INSERT MENU
        jpl.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        jpl.setPreferredSize(new Dimension(516, 530));

        JLabel lbid = new JLabel("STU ID：");                            //STU ID
        jtid = new JTextField(5);
        jpl.add(lbid);
        jpl.add(jtid);

        JLabel lbna = new JLabel("NAME：");                            //STU ID
        jtname = new JTextField(5);
        jpl.add(lbna);
        jpl.add(jtname);

        JLabel lbse = new JLabel("GENDER：");                            //STU ID
        jtsex = new JTextField(5);
        jpl.add(lbse);
        jpl.add(jtsex);

        JLabel lbbi = new JLabel("BIRTHDAY：");                            //STU ID
        jtbirth = new JTextField(5);
        jpl.add(lbbi);
        jpl.add(jtbirth);

        JLabel lbcl = new JLabel("CLASS：");                            //STU ID
        jtclass = new JTextField(5);
        jpl.add(lbcl);
        jpl.add(jtclass);

        JButton JB_sure = new JButton("OK");
        JB_sure.setBorderPainted(false);                                //OK
        JB_sure.setActionCommand("jbSsure");
        JB_sure.addActionListener(this);
        jpl.add(JB_sure);

        return jpl;
    }

    //	INSERT GRADE MENU
    public JPanel createSCORE() {                                            //INSEART MENU
        jpl.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        jpl.setPreferredSize(new Dimension(516, 530));

        JLabel lbid = new JLabel("STU ID：");                            //STU ID
        jtid = new JTextField(5);
        jpl.add(lbid);
        jpl.add(jtid);

        JLabel lbcl = new JLabel("CNO：");                            //STU ID
        jtclnum = new JTextField(5);
        jpl.add(lbcl);
        jpl.add(jtclnum);

        JLabel lbsc = new JLabel("GRADE：");                            //STU ID
        jtsc = new JTextField(5);
        jpl.add(lbsc);
        jpl.add(jtsc);

        JButton JB_sure = new JButton("OK");
        JB_sure.setBorderPainted(false);                                //OK
        JB_sure.setActionCommand("jbSsure_sc");
        JB_sure.addActionListener(this);
        jpl.add(JB_sure);

        return jpl;
    }

    //	SEARCH MENU
    public JPanel searchall() {                                            //录入界面
        jpl.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        jpl.setPreferredSize(new Dimension(516, 530));

        JButton JB_1 = new JButton("按STU ID查询");
        JB_1.setBorderPainted(false);                                //OK
        JB_1.setActionCommand("jbsure1");
        JB_1.addActionListener(this);
        jpl.add(JB_1);

        JButton JB_2 = new JButton("按NAME查询");
        JB_2.setBorderPainted(false);                                //OK
        JB_2.setActionCommand("jbsure2");
        JB_2.addActionListener(this);
        jpl.add(JB_2);

        JButton JB_3 = new JButton("按专业查询");
        JB_3.setBorderPainted(false);                                //OK
        JB_3.setActionCommand("jbsure3");
        JB_3.addActionListener(this);
        jpl.add(JB_3);

        return jpl;

    }

    //	SEARCH GRADE MENU
    public JPanel search1() {                                            //录入界面
        jpl.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        jpl.setPreferredSize(new Dimension(516, 530));

        JLabel lbid = new JLabel("STU ID：");                            //STU ID
        jtid = new JTextField(5);
        jpl.add(lbid);
        jpl.add(jtid);

        JButton JB_sure = new JButton("OK");
        JB_sure.setBorderPainted(false);                                //OK
        JB_sure.setActionCommand("jbsure_1");
        JB_sure.addActionListener(this);
        jpl.add(JB_sure);

        return jpl;

    }

    public JPanel search2() {                                            //录入界面
        jpl.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        jpl.setPreferredSize(new Dimension(516, 530));

        JLabel lbna = new JLabel("NAME：");                            //STU ID
        jtname = new JTextField(5);
        jpl.add(lbna);
        jpl.add(jtname);

        JButton JB_sure = new JButton("OK");
        JB_sure.setBorderPainted(false);                                //OK
        JB_sure.setActionCommand("jbsure_2");
        JB_sure.addActionListener(this);
        jpl.add(JB_sure);

        return jpl;
    }

    public JPanel search3() {                                            //录入界面
        jpl.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        jpl.setPreferredSize(new Dimension(516, 530));

        JLabel lbmaj = new JLabel("MAJOR：");                            //STU ID
        jtmaj = new JTextField(5);
        jpl.add(lbmaj);
        jpl.add(jtmaj);

        JButton JB_sure = new JButton("OK");
        JB_sure.setBorderPainted(false);                                //OK
        JB_sure.setActionCommand("jbsure_3");
        JB_sure.addActionListener(this);
        jpl.add(JB_sure);

        return jpl;
    }

    //	查询界面
    public JPanel searchsc() {                                            //录入界面
        jpl.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        jpl.setPreferredSize(new Dimension(516, 530));

        JLabel lbid = new JLabel("STU ID：");                            //STU ID
        jtid = new JTextField(5);
        jpl.add(lbid);
        jpl.add(jtid);

        JButton jbt = new JButton();
        jbt.setPreferredSize(new Dimension(400, 0));
        jbt.setBorderPainted(false);
        jbt.setContentAreaFilled(false);
        jpl.add(jbt);

        JButton JB_sure = new JButton("SEARCH FOR CLASSES");
        JB_sure.setBorderPainted(false);                                //OK
        JB_sure.setActionCommand("jbSsure_searchsc");
        JB_sure.addActionListener(this);
        jpl.add(JB_sure);

        JButton JB_sure2 = new JButton("SEARCH FOR GPA");
        JB_sure2.setBorderPainted(false);                                //OK
        JB_sure2.setActionCommand("jbSsure_searchsc2");
        JB_sure2.addActionListener(this);
        jpl.add(JB_sure2);

        return jpl;

    }

    public JPanel searchpro() {                                            //录入界面
        jpl.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        jpl.setPreferredSize(new Dimension(516, 530));

        JLabel lbid = new JLabel("STU ID：");                            //STU ID
        jtid = new JTextField(5);
        jpl.add(lbid);
        jpl.add(jtid);

        JButton jbt = new JButton();
        jbt.setPreferredSize(new Dimension(400, 0));
        jbt.setBorderPainted(false);
        jbt.setContentAreaFilled(false);
        jpl.add(jbt);

        JButton JB_sure = new JButton("OK");
        JB_sure.setBorderPainted(false);                                //OK
        JB_sure.setActionCommand("jbSsurepro");
        JB_sure.addActionListener(this);
        jpl.add(JB_sure);

        return jpl;

    }

    //	“OK”按钮展示面板
    public JPanel createDisplay() {                                        //输出界面
        jpl.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        jpl.setPreferredSize(new Dimension(516, 530));

        JLabel lbinfor = new JLabel("RESULTS：");
        jpl.add(lbinfor);

        jtinfor = new JTextArea(15, 40);
        jtinfor.setText("RESULTS：\n");
        jtinfor.setCaretPosition(0);

        jsinfor = new JScrollPane(jtinfor);
        jpl.add(jsinfor);

        return jpl;
    }

    //	事件触发器
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("jbadd")) {                        //录入操
            jpl.removeAll();
            jpl.repaint();

            jpl = createAdd();
            jpl.setOpaque(false);

            this.add(jpl);
            this.validate();
        }

        if (e.getActionCommand().equals("jbsc")) {                        //录入操
            jpl.removeAll();
            jpl.repaint();

            jpl = createSCORE();
            jpl.setOpaque(false);

            this.add(jpl);
            this.validate();
        }

        if (e.getActionCommand().equals("jbSsure")) {                                //OK操作
            id = jtid.getText();
            name = jtname.getText();
            sex = jtsex.getText();
            birth = jtbirth.getText();
            clas = jtclass.getText();
            String insert =
                    "insert into stu values('" + id + "','" + name + "','" + sex + "','" + birth + "','" + clas + "')";
            try {
                statement.executeUpdate(insert);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "SUCCESS！！！");
        }

        if (e.getActionCommand().equals("jbSsure_sc")) {                                //OK操作
            id = jtid.getText();
            cno = jtclnum.getText();
            grade = jtsc.getText();
            String insert = "insert into enrollment values('" + id + "','" + cno + "','" + grade + "')";
            try {
                statement.executeUpdate(insert);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "SUCCESS！！！");
        }

        if (e.getActionCommand().equals("jbsearch")) {                        //录入操
            jpl.removeAll();
            jpl.repaint();

            jpl = searchall();
            jpl.setOpaque(false);

            this.add(jpl);
            this.validate();
        }

        if (e.getActionCommand().equals("jbsure1")) {                        //录入操
            jpl.removeAll();
            jpl.repaint();

            jpl = search1();
            jpl.setOpaque(false);

            this.add(jpl);
            this.validate();
        }

        if (e.getActionCommand().equals("jbsure2")) {                        //录入操
            jpl.removeAll();
            jpl.repaint();

            jpl = search2();
            jpl.setOpaque(false);

            this.add(jpl);
            this.validate();
        }

        if (e.getActionCommand().equals("jbsure3")) {                        //录入操
            jpl.removeAll();
            jpl.repaint();

            jpl = search3();
            jpl.setOpaque(false);

            this.add(jpl);
            this.validate();
        }

        if (e.getActionCommand().equals("jbsure_1")) {                        //录入操
            String id = jtid.getText();
            String search = "select * from stu where sno='" + id + "'";
            jpl = createDisplay();
            ResultSet result = null;
            try {
                result = statement.executeQuery(search);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                while (result.next()) {
                    id = result.getString("sno");
                    name = result.getString("name");
                    sex = result.getString("sex");
                    birth = result.getString("dob");
                    clas = result.getString("class");

                    jtinfor.append("STU ID：" + id + "\n");
                    jtinfor.append("NAME：" + name + "\n");
                    jtinfor.append("GENDER：" + sex + "\n");
                    jtinfor.append("BIRTHDAY：" + birth + "\n");
                    jtinfor.append("CLASS：" + clas + "\n");
                }
                this.add(jpl);
                this.validate();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getActionCommand().equals("jbsure_2")) {                        //录入操
            String name = jtname.getText();
            String search = "select * from stu where name='" + name + "'";
            jpl = createDisplay();
            ResultSet result = null;
            try {
                result = statement.executeQuery(search);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                while (result.next()) {
                    id = result.getString("sno");
                    name = result.getString("NAME");
                    sex = result.getString("sex");
                    birth = result.getString("dob");
                    clas = result.getString("CLASS");

                    jtinfor.append("STU ID：" + id + "\n");
                    jtinfor.append("NAME：" + name + "\n");
                    jtinfor.append("GENDER：" + sex + "\n");
                    jtinfor.append("BIRTHDAY：" + birth + "\n");
                    jtinfor.append("CLASS：" + clas + "\n");
                }
                this.add(jpl);
                this.validate();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getActionCommand().equals("jbsure_3")) {                        //录入操
            String major = jtmaj.getText();
            String search = "select sno,name,sex,dob,stu.class from stu,classmajor where major='" + major
                    + "' AND stu.class=classmajor.class";
            jpl = createDisplay();
            ResultSet result = null;
            try {
                result = statement.executeQuery(search);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                while (result.next()) {
                    id = result.getString("sno");
                    name = result.getString("NAME");
                    sex = result.getString("sex");
                    birth = result.getString("dob");
                    clas = result.getString("CLASS");

                    jtinfor.append("STU ID：" + id + "\n");
                    jtinfor.append("NAME：" + name + "\n");
                    jtinfor.append("GENDER：" + sex + "\n");
                    jtinfor.append("BIRTHDAY：" + birth + "\n");
                    jtinfor.append("CLASS：" + clas + "\n");
                }
                this.add(jpl);
                this.validate();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getActionCommand().equals("jbsearchsc")) {                        //录入操
            jpl.removeAll();
            jpl.repaint();

            jpl = searchsc();
            jpl.setOpaque(false);

            this.add(jpl);
            this.validate();
        }

        if (e.getActionCommand().equals("jbsearchpro")) {                        //录入操
            jpl.removeAll();
            jpl.repaint();

            jpl = searchpro();
            jpl.setOpaque(false);

            this.add(jpl);
            this.validate();
        }

        if (e.getActionCommand().equals("jbSsure_searchsc")) {                                //OK操作
            String id = jtid.getText();
            String search =
                    "SELECT name,cname,attribute,time,credit,grade FROM stu,classmajor,depplan,enrollment,class "
                            + "WHERE stu.sno='" + id + "' AND stu.sno=enrollment.sno AND enrollment.cno=class.cno AND "
                            + "stu.class=classmajor.class AND classmajor.major=depplan.major AND enrollment.cno=depplan.cno;";
            jpl = createDisplay();
            ResultSet result = null;
            try {
                result = statement.executeQuery(search);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                while (result.next()) {
                    name = result.getString("name");
                    cname = result.getString("cname");
                    prop = result.getString("attribute");
                    per = result.getString("time");
                    credit = result.getString("credit");
                    grade = result.getString("grade");

                    jtinfor.append("NAME：" + name + "\n");
                    jtinfor.append("CLASSNAME：" + cname + "\n");
                    jtinfor.append("PROPERTY：" + prop + "\n");
                    jtinfor.append("PERIOD：" + per + "\n");
                    jtinfor.append("CREDIT：" + credit + "\n");
                    jtinfor.append("GRADE：" + grade + "\n");
                }
                this.add(jpl);
                this.validate();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getActionCommand().equals("jbSsure_searchsc2")) {                                //OK操作
            String id = jtid.getText();
            String search = "SELECT name,sum(grade*credit)/sum(credit) avegrade " + "FROM stu,enrollment,class "
                    + "WHERE stu.sno='" + id + "' AND stu.sno=enrollment.sno AND enrollment.cno=class.cno "
                    + "group by stu.name;";
            jpl = createDisplay();
            ResultSet result = null;
            try {
                result = statement.executeQuery(search);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                while (result.next()) {
                    name = result.getString("name");
                    ave = result.getString("avegrade");

                    jtinfor.append("NAME：" + name + "\n");
                    jtinfor.append("GPA：" + ave + "\n");
                }
                this.add(jpl);
                this.validate();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getActionCommand().equals("jbSsurepro")) {                                //OK操作
            String id = jtid.getText();
            String search = "SELECT name,prof FROM stu,enrollment,prof " + "WHERE stu.sno='" + id
                    + "' AND stu.sno=enrollment.sno AND enrollment.cno=prof.cno AND " + "stu.class=prof.class;";
            jpl = createDisplay();
            ResultSet result = null;
            try {
                result = statement.executeQuery(search);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                while (result.next()) {
                    pro = result.getString("prof");

                    jtinfor.append("PROF：" + pro + "\n");
                }
                this.add(jpl);
                this.validate();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getActionCommand().equals("jbsearchfire")) {
            String search = "select NAME,sum(credit) credit " + "from stu,enrollment,class "
                    + "where stu.sno=enrollment.sno AND enrollment.cno=class.cno " + "AND enrollment.grade<60 "
                    + "group by stu.name " + "having sum(credit)>9;";
            jpl = createDisplay();
            ResultSet result = null;
            try {
                result = statement.executeQuery(search);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                while (result.next()) {
                    name = result.getString("name");
                    credit = result.getString("credit");

                    jtinfor.append("NAME：" + name + "\n");
                    jtinfor.append("DROP OUT CREDITS：" + credit + "\n");
                }
                this.add(jpl);
                this.validate();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Buttom("sa", "123");
    }
}