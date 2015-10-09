package com.lrd.inventory.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.*;

import com.lrd.inventory.database.DatabaseConnection;
import com.lrd.inventory.reportui.PurchaseHalfYearlyReport;
import com.lrd.inventory.reportui.PurchaseMonthlyReport;
import com.lrd.inventory.reportui.PurchaseQuartrlyReport;
import com.lrd.inventory.reportui.PurchaseYearlyReport;
import com.lrd.inventory.utility.Calculator;
import com.lrd.inventory.utility.MediaPlayer;
import com.lrd.inventory.utility.NotePad;
import com.lrd.inventory.values.*;
import com.mysql.jdbc.CommunicationsException;

/**
 * @author dharmendra singh
 */
public class MasterHome extends JFrame implements ActionListener {

	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();

	public final static int SALE_BILL = 0;
	public final static int CHALLAN = 1;
	public final static int SALE_ORDER = 2;
	public final static int SALE_QUOTATION = 3;
	// Variables declaration

	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar1;

	private JMenu menu1;
	private JMenu menu2;
	private JMenu menu3;
	private JMenu menu4;
	private JMenu menu5;
	private JMenu menu6;
	private JMenu menu7;
	private JMenu menu8;
	private JMenu menu9;
	private JMenu menu10;
	private JMenu menu12;
	private JMenu menu13;
	private JMenu menu14;
	private JMenu menu15;
	private JMenu menu16;
	private JMenu menu17;
	private JMenu menu18;
	private JMenu menu19;
	private JMenu menu20;
	private JMenu menu21;
	private JMenu menu22;
	private JMenu menu23;
	private JMenu menu24;
	private JMenu menu25;
	private JMenu menu26;
	private JMenu menu27;
	private JMenu menu28;

	private JMenuItem menuItem2;
	private JMenuItem menuItem3;
	private JMenuItem menuItem8;
	private JMenuItem menuItem9;
	private JMenuItem menuItem10;
	private JMenuItem menuItem11;
	private JMenuItem menuItem12;
	private JMenuItem menuItem13;
	private JMenuItem menuItem14;
	private JMenuItem menuItem15;
	private JMenuItem menuItem16;
	private JMenuItem menuItem17;
	private JMenuItem menuItem27;
	private JMenuItem menuItem30;
	private JMenuItem menuItem31;
	private JMenuItem menuItem32;
	private JMenuItem menuItem33;
	private JMenuItem menuItem34;
	private JMenuItem menuItem35;
	private JMenuItem menuItem36;
	private JMenuItem menuItem37;
	private JMenuItem menuItem38;
	private JMenuItem menuItem39;
	private JMenuItem menuItem40;
	private JMenuItem menuItem41;
	private JMenuItem menuItem42;
	private JMenuItem menuItem43;
	private JMenuItem menuItem44;
	private JMenuItem menuItem45;
	private JMenuItem menuItem46;
	private JMenuItem menuItem47;
	private JMenuItem menuItem48;
	private JMenuItem menuItem49;
	private JMenuItem menuItem50;
	private JMenuItem menuItem51;
	private JMenuItem menuItem52;
	private JMenuItem menuItem53;
	private JMenuItem menuItem54;
	private JMenuItem menuItem57;
	private JMenuItem menuItem56;
	private JMenuItem menuItem58;
	private JMenuItem menuItem59;
	private JMenuItem menuItem60;
	private JMenuItem menuItem64;
	private JMenuItem menuItem65;
	private JMenuItem menuItem66;
	private JMenuItem menuItem67;
	private JMenuItem menuItem68;
	private JMenuItem menuItem69;
	private JMenuItem menuItem70;
	private JMenuItem menuItem71;
	private JMenuItem menuItem72;
	private JMenuItem menuItem73;
	private JMenuItem menuItem74;
	private JMenuItem menuItem76;
	private JMenuItem menuItem77;
	private JMenuItem menuItem78;
	private JMenuItem menuItem79;
	private JMenuItem menuItem80;
	private JMenuItem menuItem81;
	private JMenuItem menuItem82;
	private JMenuItem menuItem83;
	private JMenuItem menuItem84;
	private JMenuItem menuItem85;
	private JMenuItem menuItem86;
	private JMenuItem menuItem87;
	private JMenuItem menuItem88;
	private JMenuItem menuItem89;
	private JMenuItem menuItem90;
	private JMenuItem menuItem91;
	private JMenuItem menuItem92;
	private JMenuItem menuItem93;
	private JMenuItem menuItem94;
	private JMenuItem menuItem95;
	private JMenuItem menuItem96;
	private JMenuItem menuItem97;
	private JMenuItem menuItem98;
	private JMenuItem menuItem99;
	private JMenuItem menuItem100;
	private JMenuItem menuItem101;
	private JMenuItem menuItem102;
	private JMenuItem menuItem103;
	private JMenuItem menuItem104;
	private JMenuItem menuItem105;
	private JMenuItem menuItem106;
	private JMenuItem menuItem107;
	private JMenuItem menuItem108;
	private JMenuItem menuItem109;
	private JMenuItem menuItem110;
	private JMenuItem menuItem111;
	private JMenuItem menuItem112;
	private JMenuItem menuItem113;
	private JMenuItem menuItem114;
	private JMenuItem menuItem115;
	private JMenuItem menuItem116;
	private JMenuItem menuItem117;
	private JMenuItem menuItem118;
	private JMenuItem menuItem119;
	private JMenuItem menuItem120;
	private JMenuItem menuItem121;
	private JMenuItem menuItem124;
	private JMenuItem menuItem122;
	private JMenuItem menuItem123;
	private JMenuItem menuItem125;
	private JMenuItem menuItem126;
	private JMenuItem menuItem127;
	private JMenuItem menuItem128;
	private JMenuItem menuItem129;
	private JMenuItem menuItem130;
	private JMenuItem menuItem131;
	private JMenuItem menuItem132;
	private JMenuItem menuItem133;
	private JMenuItem menuItem134;
	private JMenuItem menuItem135;
	private JMenuItem menuItem136;
	private JMenuItem menuItem137;
	private JMenuItem menuItem138;
	private JMenuItem menuItem139;
	private JMenuItem menuItem140;
	private JMenuItem menuItem141;
	private JMenuItem menuItem142;
	private JMenuItem menuItem143;
	private JMenuItem menuItem144;
	private JMenuItem menuItem145;
	private JMenuItem menuItem146;
	private JMenuItem menuItem147;
	private JMenuItem menuItem148;
	private JMenuItem menuItem149;
	private JMenuItem menuItem150;
	private JMenuItem menuItem151;
	private JMenuItem menuItem152;
	private JMenuItem menuItem153;
	private JMenuItem menuItem154;
	private JMenuItem menuItem155;
	private JMenuItem menuItem156;
	private JMenuItem menuItem157;
	private JMenuItem menuItem158;
	private JMenuItem menuItem159;
	private JMenuItem menuItem160;
	private JMenuItem menuItem161;

	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;

	private final int WIDTH;
	private final int HEIGHT;

	DatabaseConnection db_connect;
	Owner owner;
	private String userName;
	Connection connection = null;

	// End of variables declaration

	public MasterHome(String userName) {

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		WIDTH = screenSize.width;
		HEIGHT = screenSize.height;
		this.userName = userName;

		owner = new Owner();
		db_connect = new DatabaseConnection();
		this.connection = db_connect.getConnection();
		initComponents();
	}

	private void initComponents() {

		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menu10 = new JMenu();
		menuItem64 = new JMenuItem();
		menuItem65 = new JMenuItem();
		menuItem66 = new JMenuItem();
		menuItem67 = new JMenuItem();
		menuItem68 = new JMenuItem();
		menuItem69 = new JMenuItem();
		menuItem70 = new JMenuItem();
		menuItem71 = new JMenuItem();
		menuItem72 = new JMenuItem();
		menuItem73 = new JMenuItem();
		menuItem74 = new JMenuItem();
		menuItem2 = new JMenuItem();
		menuItem3 = new JMenuItem();
		menu12 = new JMenu();
		menu13 = new JMenu();
		menuItem76 = new JMenuItem();
		menuItem81 = new JMenuItem();
		menuItem82 = new JMenuItem();
		menuItem83 = new JMenuItem();
		menuItem84 = new JMenuItem();
		menu14 = new JMenu();
		menuItem77 = new JMenuItem();
		menuItem78 = new JMenuItem();
		menuItem79 = new JMenuItem();
		menuItem80 = new JMenuItem();
		menu2 = new JMenu();
		menuItem8 = new JMenuItem();
		menuItem85 = new JMenuItem();
		menuItem9 = new JMenuItem();
		menuItem10 = new JMenuItem();
		menuItem11 = new JMenuItem();
		menuItem12 = new JMenuItem();
		menuItem13 = new JMenuItem();
		menuItem14 = new JMenuItem();
		menu15 = new JMenu();
		menuItem86 = new JMenuItem();
		menuItem87 = new JMenuItem();
		menu16 = new JMenu();
		menuItem88 = new JMenuItem();
		menuItem89 = new JMenuItem();
		menu3 = new JMenu();
		menuItem15 = new JMenuItem();
		menuItem16 = new JMenuItem();
		menuItem17 = new JMenuItem();
		menu4 = new JMenu();
		menuItem27 = new JMenuItem();
		menu17 = new JMenu();
		menuItem90 = new JMenuItem();
		menuItem91 = new JMenuItem();
		menuItem92 = new JMenuItem();
		menu18 = new JMenu();
		menuItem93 = new JMenuItem();
		menuItem94 = new JMenuItem();
		menuItem95 = new JMenuItem();
		menuItem96 = new JMenuItem();
		menu5 = new JMenu();
		menuItem30 = new JMenuItem();
		menuItem31 = new JMenuItem();
		menuItem32 = new JMenuItem();
		menuItem33 = new JMenuItem();
		menuItem34 = new JMenuItem();
		menuItem35 = new JMenuItem();
		menuItem36 = new JMenuItem();
		menuItem97 = new JMenuItem();
		menu6 = new JMenu();
		menu19 = new JMenu();
		menuItem101 = new JMenuItem();
		menuItem102 = new JMenuItem();
		menuItem103 = new JMenuItem();
		menuItem104 = new JMenuItem();
		menuItem105 = new JMenuItem();
		menuItem106 = new JMenuItem();
		menuItem107 = new JMenuItem();
		menuItem108 = new JMenuItem();
		menuItem109 = new JMenuItem();
		menuItem110 = new JMenuItem();
		menuItem111 = new JMenuItem();
		menuItem112 = new JMenuItem();
		menuItem113 = new JMenuItem();
		menuItem114 = new JMenuItem();
		menuItem115 = new JMenuItem();
		menuItem116 = new JMenuItem();
		menuItem117 = new JMenuItem();
		menuItem118 = new JMenuItem();
		menuItem119 = new JMenuItem();
		menuItem120 = new JMenuItem();
		menuItem121 = new JMenuItem();
		menuItem124 = new JMenuItem();
		menuItem122 = new JMenuItem();
		menuItem123 = new JMenuItem();
		menuItem37 = new JMenuItem();
		menuItem38 = new JMenuItem();
		menuItem39 = new JMenuItem();
		menu20 = new JMenu();
		menuItem125 = new JMenuItem();
		menuItem126 = new JMenuItem();
		menuItem127 = new JMenuItem();
		menuItem128 = new JMenuItem();
		menuItem129 = new JMenuItem();
		menu21 = new JMenu();
		menuItem130 = new JMenuItem();
		menuItem131 = new JMenuItem();
		menuItem132 = new JMenuItem();
		menuItem133 = new JMenuItem();
		menuItem134 = new JMenuItem();
		menu22 = new JMenu();
		menuItem135 = new JMenuItem();
		menuItem136 = new JMenuItem();
		menuItem137 = new JMenuItem();
		menuItem138 = new JMenuItem();
		menuItem139 = new JMenuItem();
		menu23 = new JMenu();
		menuItem140 = new JMenuItem();
		menuItem141 = new JMenuItem();
		menuItem40 = new JMenuItem();
		menuItem41 = new JMenuItem();
		menuItem42 = new JMenuItem();
		menuItem43 = new JMenuItem();
		menuItem98 = new JMenuItem();
		menuItem99 = new JMenuItem();
		menuItem100 = new JMenuItem();
		menu7 = new JMenu();
		menuItem44 = new JMenuItem();
		menu24 = new JMenu();
		menuItem151 = new JMenuItem();
		menu27 = new JMenu();
		menuItem152 = new JMenuItem();
		menuItem153 = new JMenuItem();
		menuItem45 = new JMenuItem();
		menuItem46 = new JMenuItem();
		menuItem47 = new JMenuItem();
		menuItem48 = new JMenuItem();
		menuItem49 = new JMenuItem();
		menu25 = new JMenu();
		menuItem154 = new JMenuItem();
		menuItem155 = new JMenuItem();
		menuItem50 = new JMenuItem();
		menuItem51 = new JMenuItem();
		menuItem142 = new JMenuItem();
		menuItem143 = new JMenuItem();
		menu26 = new JMenu();
		menu28 = new JMenu();
		menuItem157 = new JMenuItem();
		menuItem158 = new JMenuItem();
		menuItem159 = new JMenuItem();
		menuItem160 = new JMenuItem();
		menuItem161 = new JMenuItem();
		menuItem156 = new JMenuItem();
		menuItem144 = new JMenuItem();
		menuItem145 = new JMenuItem();
		menuItem146 = new JMenuItem();
		menuItem147 = new JMenuItem();
		menuItem148 = new JMenuItem();
		menuItem149 = new JMenuItem();
		menuItem150 = new JMenuItem();
		menu9 = new JMenu();
		menuItem52 = new JMenuItem();
		menuItem53 = new JMenuItem();
		menuItem54 = new JMenuItem();
		menu8 = new JMenu();
		menuItem57 = new JMenuItem();
		menuItem56 = new JMenuItem();
		menuItem58 = new JMenuItem();
		menuItem59 = new JMenuItem();
		menuItem60 = new JMenuItem();
		panel1 = new JPanel();
		panel2 = new JPanel();
		label1 = new JLabel();
		panel3 = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		button7 = new JButton();
		button8 = new JButton();
		panel4 = new JPanel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		label8 = new JLabel();
		label9 = new JLabel();
		label10 = new JLabel();
		label11 = new JLabel();

		// ======== this ========
		setTitle("Inventory Control");
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// ======== menuBar1 ========
		{

			// ======== menu1 ========
			{
				menu1.setText(MenuName.menu1);

				// ======== menu10 ========
				{
					menu10.setText(MenuName.menu10);

					// ---- menuItem64 ----
					menuItem64.setText(MenuItemName.MenuItem64);
					menu10.add(menuItem64);

					// ---- menuItem65 ----
					menuItem65.setText(MenuItemName.MenuItem65);
					menu10.add(menuItem65);

					// ---- menuItem66 ----
					menuItem66.setText(MenuItemName.MenuItem66);
					menu10.add(menuItem66);

					// ---- menuItem67 ----
					menuItem67.setText(MenuItemName.MenuItem67);
					menu10.add(menuItem67);

					// ---- menuItem68 ----
					menuItem68.setText(MenuItemName.MenuItem68);
					menu10.add(menuItem68);

					// ---- menuItem69 ----
					menuItem69.setText(MenuItemName.MenuItem69);
					menu10.add(menuItem69);

					// ---- menuItem70 ----
					menuItem70.setText(MenuItemName.MenuItem70);
					menu10.add(menuItem70);

					// ---- menuItem71 ----
					menuItem71.setText(MenuItemName.MenuItem71);
					menu10.add(menuItem71);

					// ---- menuItem72 ----
					menuItem72.setText(MenuItemName.MenuItem72);
					menu10.add(menuItem72);

					// ---- menuItem73 ----
					menuItem73.setText(MenuItemName.MenuItem73);
					menu10.add(menuItem73);

					// ---- menuItem74 ----
					menuItem74.setText(MenuItemName.MenuItem74);
					menu10.add(menuItem74);
				}
				menu1.add(menu10);
				menu1.addSeparator();

				// ---- menuItem2 ----
				menuItem2.setText(MenuItemName.MenuItem2);
				menu1.add(menuItem2);

				// ---- menuItem3 ----
				menuItem3.setText(MenuItemName.MenuItem3);
				menu1.add(menuItem3);
				menu1.addSeparator();

				// ======== menu12 ========
				{
					menu12.setText(MenuName.menu12);

					// ======== menu13 ========
					{
						menu13.setText(MenuName.menu13);

						// ---- menuItem76 ----
						menuItem76.setText(MenuItemName.MenuItem76);
						menu13.add(menuItem76);

						// ---- menuItem81 ----
						menuItem81.setText(MenuItemName.MenuItem81);
						menu13.add(menuItem81);

						// ---- menuItem82 ----
						menuItem82.setText(MenuItemName.MenuItem82);
						menu13.add(menuItem82);

						// ---- menuItem83 ----
						menuItem83.setText(MenuItemName.MenuItem83);
						menu13.add(menuItem83);

						// ---- menuItem84 ----
						menuItem84.setText(MenuItemName.MenuItem84);
						menu13.add(menuItem84);
					}
					menu12.add(menu13);

					// ======== menu14 ========
					{
						menu14.setText(MenuName.menu14);

						// ---- menuItem77 ----
						menuItem77.setText(MenuItemName.MenuItem77);
						menu14.add(menuItem77);

						// ---- menuItem78 ----
						menuItem78.setText(MenuItemName.MenuItem78);
						menu14.add(menuItem78);

						// ---- menuItem79 ----
						menuItem79.setText(MenuItemName.MenuItem79);
						menu14.add(menuItem79);

						// ---- menuItem80 ----
						menuItem80.setText(MenuItemName.MenuItem80);
						menu14.add(menuItem80);
					}
					menu12.add(menu14);
				}
				menu1.add(menu12);
			}
			menuBar1.add(menu1);

			// ======== menu2 ========
			{
				menu2.setText(MenuName.menu2);

				// ---- menuItem8 ----
				menuItem8.setText(MenuItemName.MenuItem8);
				menu2.add(menuItem8);

				// ---- menuItem85 ----
				menuItem85.setText(MenuItemName.MenuItem85);
				menu2.add(menuItem85);

				// ---- menuItem9 ----
				menuItem9.setText(MenuItemName.MenuItem9);
				menu2.add(menuItem9);

				// ---- menuItem10 ----
				menuItem10.setText(MenuItemName.MenuItem10);
				menu2.add(menuItem10);

				// ---- menuItem11 ----
				menuItem11.setText(MenuItemName.MenuItem11);
				menu2.add(menuItem11);

				// ---- menuItem12 ----
				menuItem12.setText(MenuItemName.MenuItem12);
				menu2.add(menuItem12);

				// ---- menuItem13 ----
				menuItem13.setText(MenuItemName.MenuItem13);
				menu2.add(menuItem13);

				// ---- menuItem14 ----
				menuItem14.setText(MenuItemName.MenuItem14);
				menu2.add(menuItem14);

				// ======== menu15 ========
				{
					menu15.setText(MenuName.menu15);

					// ---- menuItem86 ----
					menuItem86.setText(MenuItemName.MenuItem86);
					menu15.add(menuItem86);

					// ---- menuItem87 ----
					menuItem87.setText(MenuItemName.MenuItem87);
					menu15.add(menuItem87);
				}
				menu2.add(menu15);

				// ======== menu16 ========
				{
					menu16.setText(MenuName.menu16);

					// ---- menuItem88 ----
					menuItem88.setText(MenuItemName.MenuItem88);
					menu16.add(menuItem88);

					// ---- menuItem89 ----
					menuItem89.setText(MenuItemName.MenuItem89);
					menu16.add(menuItem89);
				}
				menu2.add(menu16);
			}
			menuBar1.add(menu2);

			// ======== menu3 ========
			{
				menu3.setText(MenuName.menu3);

				// ---- menuItem15 ----
				menuItem15.setText(MenuItemName.MenuItem15);
				menu3.add(menuItem15);

				// ---- menuItem16 ----
				menuItem16.setText(MenuItemName.MenuItem16);
				menu3.add(menuItem16);

				// ---- menuItem17 ----
				menuItem17.setText(MenuItemName.MenuItem17);
				menu3.add(menuItem17);
			}
			menuBar1.add(menu3);

			// ======== menu4 ========
			{
				menu4.setText(MenuName.menu4);

				// ---- menuItem27 ----
				menuItem27.setText(MenuItemName.MenuItem27);
				menu4.add(menuItem27);

				// ======== menu17 ========
				{
					menu17.setText(MenuName.menu17);

					// ---- menuItem90 ----
					menuItem90.setText(MenuItemName.MenuItem90);
					menu17.add(menuItem90);

					// ---- menuItem91 ----
					menuItem91.setText(MenuItemName.MenuItem91);
					menu17.add(menuItem91);

					// ---- menuItem92 ----
					menuItem92.setText(MenuItemName.MenuItem92);
					menu17.add(menuItem92);
				}
				menu4.add(menu17);

				// ======== menu18 ========
				{
					menu18.setText(MenuName.menu18);

					// ---- menuItem93 ----
					menuItem93.setText(MenuItemName.MenuItem93);
					menu18.add(menuItem93);

					// ---- menuItem94 ----
					menuItem94.setText(MenuItemName.MenuItem94);
					menu18.add(menuItem94);

					// ---- menuItem95 ----
					menuItem95.setText(MenuItemName.MenuItem95);
					menu18.add(menuItem95);

					// ---- menuItem96 ----
					menuItem96.setText(MenuItemName.MenuItem96);
					menu18.add(menuItem96);
				}
				menu4.add(menu18);
			}
			menuBar1.add(menu4);

			// ======== menu5 ========
			{
				menu5.setText(MenuName.menu5);

				// ---- menuItem30 ----
				menuItem30.setText(MenuItemName.MenuItem30);
				menu5.add(menuItem30);

				// ---- menuItem31 ----
				menuItem31.setText(MenuItemName.MenuItem31);
				menu5.add(menuItem31);

				// ---- menuItem32 ----
				menuItem32.setText(MenuItemName.MenuItem32);
				menu5.add(menuItem32);

				// ---- menuItem33 ----
				menuItem33.setText(MenuItemName.MenuItem33);
				menu5.add(menuItem33);

				// ---- menuItem34 ----
				menuItem34.setText(MenuItemName.MenuItem34);
				menu5.add(menuItem34);

				// ---- menuItem35 ----
				menuItem35.setText(MenuItemName.MenuItem35);
				menu5.add(menuItem35);

				// ---- menuItem36 ----
				menuItem36.setText(MenuItemName.MenuItem36);
				menu5.add(menuItem36);

				// ---- menuItem97 ----
				menuItem97.setText(MenuItemName.MenuItem97);
				menu5.add(menuItem97);
			}
			menuBar1.add(menu5);

			// ======== menu6 ========
			{
				menu6.setText(MenuName.menu6);

				// ======== menu19 ========
				{
					menu19.setText(MenuName.menu19);

					// ---- menuItem101 ----
					menuItem101.setText(MenuItemName.MenuItem101);
					menu19.add(menuItem101);

					// ---- menuItem102 ----
					menuItem102.setText(MenuItemName.MenuItem102);
					menu19.add(menuItem102);

					// ---- menuItem103 ----
					menuItem103.setText(MenuItemName.MenuItem103);
					menu19.add(menuItem103);

					// ---- menuItem104 ----
					menuItem104.setText(MenuItemName.MenuItem104);
					menu19.add(menuItem104);

					// ---- menuItem105 ----
					menuItem105.setText(MenuItemName.MenuItem105);
					menu19.add(menuItem105);

					// ---- menuItem106 ----
					menuItem106.setText(MenuItemName.MenuItem106);
					menu19.add(menuItem106);

					// ---- menuItem107 ----
					menuItem107.setText(MenuItemName.MenuItem107);
					menu19.add(menuItem107);

					// ---- menuItem108 ----
					menuItem108.setText(MenuItemName.MenuItem108);
					menu19.add(menuItem108);

					// ---- menuItem109 ----
					menuItem109.setText(MenuItemName.MenuItem109);
					menu19.add(menuItem109);

					// ---- menuItem110 ----
					menuItem110.setText(MenuItemName.MenuItem110);
					menu19.add(menuItem110);

					// ---- menuItem111 ----
					menuItem111.setText(MenuItemName.MenuItem111);
					menu19.add(menuItem111);

					// ---- menuItem112 ----
					menuItem112.setText(MenuItemName.MenuItem112);
					menu19.add(menuItem112);

					// ---- menuItem113 ----
					menuItem113.setText(MenuItemName.MenuItem113);
					menu19.add(menuItem113);

					// ---- menuItem114 ----
					menuItem114.setText(MenuItemName.MenuItem114);
					menu19.add(menuItem114);

					// ---- menuItem115 ----
					menuItem115.setText(MenuItemName.MenuItem115);
					menu19.add(menuItem115);

					// ---- menuItem116 ----
					menuItem116.setText(MenuItemName.MenuItem116);
					menu19.add(menuItem116);

					// ---- menuItem117 ----
					menuItem117.setText(MenuItemName.MenuItem117);
					menu19.add(menuItem117);

					// ---- menuItem118 ----
					menuItem118.setText(MenuItemName.MenuItem118);
					menu19.add(menuItem118);

					// ---- menuItem119 ----
					menuItem119.setText(MenuItemName.MenuItem119);
					menu19.add(menuItem119);

					// ---- menuItem120 ----
					menuItem120.setText(MenuItemName.MenuItem120);
					menu19.add(menuItem120);

					// ---- menuItem121 ----
					menuItem121.setText(MenuItemName.MenuItem121);
					menu19.add(menuItem121);

					// ---- menuItem124 ----
					menuItem124.setText(MenuItemName.MenuItem124);
					menu19.add(menuItem124);

					// ---- menuItem122 ----
					menuItem122.setText(MenuItemName.MenuItem122);
					menu19.add(menuItem122);

					// ---- menuItem123 ----
					menuItem123.setText(MenuItemName.MenuItem123);
					menu19.add(menuItem123);
				}
				menu6.add(menu19);

				// ---- menuItem37 ----
				menuItem37.setText(MenuItemName.MenuItem37);
				menu6.add(menuItem37);

				// ---- menuItem38 ----
				menuItem38.setText(MenuItemName.MenuItem38);
				menu6.add(menuItem38);

				// ---- menuItem39 ----
				menuItem39.setText(MenuItemName.MenuItem39);
				menu6.add(menuItem39);

				// ======== menu20 ========
				{
					menu20.setText(MenuName.menu20);

					// ---- menuItem125 ----
					menuItem125.setText(MenuItemName.MenuItem125);
					menu20.add(menuItem125);

					// ---- menuItem126 ----
					menuItem126.setText(MenuItemName.MenuItem126);
					menu20.add(menuItem126);

					// ---- menuItem127 ----
					menuItem127.setText(MenuItemName.MenuItem127);
					menu20.add(menuItem127);

					// ---- menuItem128 ----
					menuItem128.setText(MenuItemName.MenuItem128);
					menu20.add(menuItem128);

					// ---- menuItem129 ----
					menuItem129.setText(MenuItemName.MenuItem129);
					menu20.add(menuItem129);
				}
				menu6.add(menu20);

				// ======== menu21 ========
				{
					menu21.setText(MenuName.menu21);

					// ---- menuItem130 ----
					menuItem130.setText(MenuItemName.MenuItem130);
					menu21.add(menuItem130);

					// ---- menuItem131 ----
					menuItem131.setText(MenuItemName.MenuItem131);
					menu21.add(menuItem131);

					// ---- menuItem132 ----
					menuItem132.setText(MenuItemName.MenuItem132);
					menu21.add(menuItem132);

					// ---- menuItem133 ----
					menuItem133.setText(MenuItemName.MenuItem133);
					menu21.add(menuItem133);

					// ---- menuItem134 ----
					menuItem134.setText(MenuItemName.MenuItem134);
					menu21.add(menuItem134);
				}
				menu6.add(menu21);

				// ======== menu22 ========
				{
					menu22.setText(MenuName.menu22);

					// ---- menuItem135 ----
					menuItem135.setText(MenuItemName.MenuItem135);
					menu22.add(menuItem135);

					// ---- menuItem136 ----
					menuItem136.setText(MenuItemName.MenuItem136);
					menu22.add(menuItem136);

					// ---- menuItem137 ----
					menuItem137.setText(MenuItemName.MenuItem137);
					menu22.add(menuItem137);

					// ---- menuItem138 ----
					menuItem138.setText(MenuItemName.MenuItem138);
					menu22.add(menuItem138);

					// ---- menuItem139 ----
					menuItem139.setText(MenuItemName.MenuItem139);
					menu22.add(menuItem139);
				}
				menu6.add(menu22);

				// ======== menu23 ========
				{
					menu23.setText(MenuName.menu23);

					// ---- menuItem140 ----
					menuItem140.setText(MenuItemName.MenuItem140);
					menu23.add(menuItem140);

					// ---- menuItem141 ----
					menuItem141.setText(MenuItemName.MenuItem141);
					menu23.add(menuItem141);
				}
				menu6.add(menu23);

				// ---- menuItem40 ----
				menuItem40.setText(MenuItemName.MenuItem40);
				menu6.add(menuItem40);

				// ---- menuItem41 ----
				menuItem41.setText(MenuItemName.MenuItem41);
				menu6.add(menuItem41);

				// ---- menuItem42 ----
				menuItem42.setText(MenuItemName.MenuItem42);
				menu6.add(menuItem42);

				// ---- menuItem43 ----
				menuItem43.setText(MenuItemName.MenuItem43);
				menu6.add(menuItem43);

				// ---- menuItem98 ----
				menuItem98.setText(MenuItemName.MenuItem98);
				menu6.add(menuItem98);

				// ---- menuItem99 ----
				menuItem99.setText(MenuItemName.MenuItem99);
				menu6.add(menuItem99);

				// ---- menuItem100 ----
				menuItem100.setText(MenuItemName.MenuItem100);
				menu6.add(menuItem100);
			}
			menuBar1.add(menu6);

			// ======== menu7 ========
			{
				menu7.setText(MenuName.menu7);

				// ---- menuItem44 ----
				menuItem44.setText(MenuItemName.MenuItem44);
				menu7.add(menuItem44);

				// ======== menu24 ========
				{
					menu24.setText(MenuName.menu24);

					// ---- menuItem151 ----
					menuItem151.setText(MenuItemName.MenuItem151);
					menu24.add(menuItem151);

					// ======== menu27 ========
					{
						menu27.setText(MenuName.menu27);

						// ---- menuItem152 ----
						menuItem152.setText(MenuItemName.MenuItem152);
						menu27.add(menuItem152);

						// ---- menuItem153 ----
						menuItem153.setText(MenuItemName.MenuItem153);
						menu27.add(menuItem153);
					}
					menu24.add(menu27);
				}
				menu7.add(menu24);

				// ---- menuItem45 ----
				menuItem45.setText(MenuItemName.MenuItem45);
				menu7.add(menuItem45);

				// ---- menuItem46 ----
				menuItem46.setText(MenuItemName.MenuItem46);
				menu7.add(menuItem46);

				// ---- menuItem47 ----
				menuItem47.setText(MenuItemName.MenuItem47);
				menu7.add(menuItem47);

				// ---- menuItem48 ----
				menuItem48.setText(MenuItemName.MenuItem48);
				menu7.add(menuItem48);

				// ---- menuItem49 ----
				menuItem49.setText(MenuItemName.MenuItem49);
				menu7.add(menuItem49);

				// ======== menu25 ========
				{
					menu25.setText(MenuName.menu25);

					// ---- menuItem154 ----
					menuItem154.setText(MenuItemName.MenuItem154);
					menu25.add(menuItem154);

					// ---- menuItem155 ----
					menuItem155.setText(MenuItemName.MenuItem155);
					menu25.add(menuItem155);
				}
				menu7.add(menu25);

				// ---- menuItem50 ----
				menuItem50.setText(MenuItemName.MenuItem50);
				menu7.add(menuItem50);

				// ---- menuItem51 ----
				menuItem51.setText(MenuItemName.MenuItem51);
				menu7.add(menuItem51);

				// ---- menuItem142 ----
				menuItem142.setText(MenuItemName.MenuItem142);
				menu7.add(menuItem142);

				// ---- menuItem143 ----
				menuItem143.setText(MenuItemName.MenuItem143);
				menu7.add(menuItem143);

				// ======== menu26 ========
				{
					menu26.setText(MenuName.menu26);

					// ======== menu28 ========
					{
						menu28.setText(MenuName.menu28);

						// ---- menuItem157 ----
						menuItem157.setText(MenuItemName.MenuItem157);
						menu28.add(menuItem157);

						// ---- menuItem158 ----
						menuItem158.setText(MenuItemName.MenuItem158);
						menu28.add(menuItem158);

						// ---- menuItem159 ----
						menuItem159.setText(MenuItemName.MenuItem159);
						menu28.add(menuItem159);

						// ---- menuItem160 ----
						menuItem160.setText(MenuItemName.MenuItem160);
						menu28.add(menuItem160);

						// ---- menuItem161 ----
						menuItem161.setText(MenuItemName.MenuItem161);
						menu28.add(menuItem161);
					}
					menu26.add(menu28);

					// ---- menuItem156 ----
					menuItem156.setText(MenuItemName.MenuItem156);
					menu26.add(menuItem156);
				}
				menu7.add(menu26);

				// ---- menuItem144 ----
				menuItem144.setText(MenuItemName.MenuItem144);
				menu7.add(menuItem144);

				// ---- menuItem145 ----
				menuItem145.setText(MenuItemName.MenuItem145);
				menu7.add(menuItem145);

				// ---- menuItem146 ----
				menuItem146.setText(MenuItemName.MenuItem146);
				menu7.add(menuItem146);

				// ---- menuItem147 ----
				menuItem147.setText(MenuItemName.MenuItem147);
				menu7.add(menuItem147);

				// ---- menuItem148 ----
				menuItem148.setText(MenuItemName.MenuItem148);
				menu7.add(menuItem148);

				// ---- menuItem149 ----
				menuItem149.setText(MenuItemName.MenuItem149);
				menu7.add(menuItem149);

				// ---- menuItem150 ----
				menuItem150.setText(MenuItemName.MenuItem150);
				menu7.add(menuItem150);
			}
			menuBar1.add(menu7);

			// ======== menu9 ========
			{
				menu9.setText(MenuName.menu9);

				// ---- menuItem52 ----
				menuItem52.setText(MenuItemName.MenuItem52);
				menu9.add(menuItem52);

				// ---- menuItem53 ----
				menuItem53.setText(MenuItemName.MenuItem53);
				menu9.add(menuItem53);

				// ---- menuItem54 ----
				menuItem54.setText(MenuItemName.MenuItem54);
				menu9.add(menuItem54);
			}
			menuBar1.add(menu9);

			// ======== menu8 ========
			{
				menu8.setText(MenuName.menu8);

				// ---- menuItem57 ----
				menuItem57.setText(MenuItemName.MenuItem57);
				menu8.add(menuItem57);

				// ---- menuItem56 ----
				menuItem56.setText(MenuItemName.MenuItem56);
				menu8.add(menuItem56);

				// ---- menuItem58 ----
				menuItem58.setText(MenuItemName.MenuItem58);
				menu8.add(menuItem58);

				// ---- menuItem59 ----
				menuItem59.setText(MenuItemName.MenuItem59);
				menu8.add(menuItem59);

				// ---- menuItem60 ----
				menuItem60.setText(MenuItemName.MenuItem60);
				menu8.add(menuItem60);
			}
			menuBar1.add(menu8);
		}
		setJMenuBar(menuBar1);

		// ======== panel1 ========
		{
			panel1.setLayout(null);

			// ======== panel2 ========
			{
				panel2.setLayout(null);

				// ---- label1 ----
				label1.setText("Administrator Control Panel");
				label1.setFont(new Font("Segoe Script", label1.getFont()
						.getStyle() | Font.BOLD, 25));
				panel2.add(label1);
				label1.setBounds(55, 25, 415, 50);
			}
			panel1.add(panel2);
			panel2.setBounds(0, 0, WIDTH, 100);

			// ======== panel3 ========
			{
				panel3.setLayout(null);

				// ---- button1 ----
				button1.setText("Category");
				panel3.add(button1);
				button1.setBounds(20, 20, ScreenElementDimention.SM_WIDTH,
						ScreenElementDimention.SM_WIDTH);
				button1.addActionListener(this);

				// ---- button2 ----
				button2.setText("Brand");
				panel3.add(button2);
				button2.setBounds(160, 20, ScreenElementDimention.SM_WIDTH,
						ScreenElementDimention.SM_WIDTH);
				button2.addActionListener(this);

				// ---- button3 ----
				button3.setText("Products");
				panel3.add(button3);
				button3.setBounds(300, 20, ScreenElementDimention.SM_WIDTH,
						ScreenElementDimention.SM_WIDTH);
				button3.addActionListener(this);

				// ---- button4 ----
				button4.setText("Distributors");
				panel3.add(button4);
				button4.setBounds(440, 20, ScreenElementDimention.SM_WIDTH,
						ScreenElementDimention.SM_WIDTH);
				button4.addActionListener(this);

				// ---- button5 ----
				button5.setText("Sale Bill");
				panel3.add(button5);
				button5.setBounds(160, 200, ScreenElementDimention.SM_WIDTH,
						ScreenElementDimention.SM_WIDTH);
				button5.addActionListener(this);

				// ---- button6 ----
				button6.setText("Purchase Bill");
				panel3.add(button6);
				button6.setBounds(300, 200, ScreenElementDimention.SM_WIDTH,
						ScreenElementDimention.SM_WIDTH);
				button6.addActionListener(this);

				// ---- button7 ----
				button7.setText("Due Bill Payment");
				panel3.add(button7);
				button7.setBounds(20, 200, ScreenElementDimention.SM_WIDTH,
						ScreenElementDimention.SM_WIDTH);
				button7.addActionListener(this);

				// ---- button8 ----
				button8.setText("Change Password");
				panel3.add(button8);
				button8.setBounds(440, 200, ScreenElementDimention.SM_WIDTH,
						ScreenElementDimention.SM_WIDTH);
				button8.addActionListener(this);

			}
			panel1.add(panel3);
			panel3.setBounds(0, 100, WIDTH / 2, HEIGHT - 200);

			// ======== panel4 ========
			{
				panel4.setLayout(null);

				// ---- label2 ----
				label2.setText("Owner Name      :");
				panel4.add(label2);
				label2.setBounds(new Rectangle(new Point(30, 20), label2
						.getPreferredSize()));

				// ---- label3 ----
				label3.setText("Address               :");
				panel4.add(label3);
				label3.setBounds(new Rectangle(new Point(30, 70), label3
						.getPreferredSize()));

				// ---- label4 ----
				label4.setText("Contact No          :");
				panel4.add(label4);
				label4.setBounds(new Rectangle(new Point(30, 200), label4
						.getPreferredSize()));

				// ---- label5 ----
				label5.setText(owner.getOwnerName());
				panel4.add(label5);
				label5.setBounds(new Rectangle(new Point(150, 20), label5
						.getPreferredSize()));

				// ---- label6 ----
				label6.setText(owner.getOwnerAddress());
				panel4.add(label6);
				label6.setBounds(new Rectangle(new Point(150, 70), label6
						.getPreferredSize()));

				// ---- label7 ----
				label7.setText(owner.getOwnerAddress());
				panel4.add(label7);
				label7.setBounds(new Rectangle(new Point(150, 90), label7
						.getPreferredSize()));

				// ---- label8 ----
				label8.setText(owner.getOwnerDistrict());
				panel4.add(label8);
				label8.setBounds(new Rectangle(new Point(150, 110), label8
						.getPreferredSize()));

				// ---- label9 ----
				label9.setText(owner.getOwnerState());
				panel4.add(label9);
				label9.setBounds(new Rectangle(new Point(150, 130), label9
						.getPreferredSize()));

				// ---- label10 ----
				label10.setText(owner.getOwnerPin());
				panel4.add(label10);
				label10.setBounds(new Rectangle(new Point(150, 150), label10
						.getPreferredSize()));

				// ---- label11 ----
				label11.setText(owner.getOwnerContact());
				panel4.add(label11);
				label11.setBounds(new Rectangle(new Point(150, 200), label11
						.getPreferredSize()));

			}
			panel1.add(panel4);
			panel4.setBounds(WIDTH / 2, 100, WIDTH / 2, HEIGHT - 200);

		}
		contentPane.add(panel1);
		panel1.setBounds(0, 0, WIDTH, HEIGHT);

		menuItem2.addActionListener(this);
		menuItem3.addActionListener(this);
		menuItem8.addActionListener(this);
		menuItem9.addActionListener(this);
		menuItem10.addActionListener(this);
		menuItem11.addActionListener(this);
		menuItem12.addActionListener(this);
		menuItem13.addActionListener(this);
		menuItem14.addActionListener(this);
		menuItem15.addActionListener(this);
		menuItem16.addActionListener(this);
		menuItem17.addActionListener(this);
		menuItem27.addActionListener(this);
		menuItem30.addActionListener(this);
		menuItem31.addActionListener(this);
		menuItem32.addActionListener(this);
		menuItem33.addActionListener(this);
		menuItem34.addActionListener(this);
		menuItem35.addActionListener(this);
		menuItem36.addActionListener(this);
		menuItem37.addActionListener(this);
		menuItem38.addActionListener(this);
		menuItem39.addActionListener(this);
		menuItem40.addActionListener(this);
		menuItem41.addActionListener(this);
		menuItem42.addActionListener(this);
		menuItem43.addActionListener(this);
		menuItem44.addActionListener(this);
		menuItem45.addActionListener(this);
		menuItem46.addActionListener(this);
		menuItem47.addActionListener(this);
		menuItem48.addActionListener(this);
		menuItem49.addActionListener(this);
		menuItem50.addActionListener(this);
		menuItem51.addActionListener(this);
		menuItem52.addActionListener(this);
		menuItem53.addActionListener(this);
		menuItem54.addActionListener(this);
		menuItem57.addActionListener(this);
		menuItem56.addActionListener(this);
		menuItem58.addActionListener(this);
		menuItem59.addActionListener(this);
		menuItem60.addActionListener(this);
		menuItem64.addActionListener(this);
		menuItem65.addActionListener(this);
		menuItem66.addActionListener(this);
		menuItem67.addActionListener(this);
		menuItem68.addActionListener(this);
		menuItem69.addActionListener(this);
		menuItem70.addActionListener(this);
		menuItem71.addActionListener(this);
		menuItem72.addActionListener(this);
		menuItem73.addActionListener(this);
		menuItem74.addActionListener(this);
		menuItem76.addActionListener(this);
		menuItem77.addActionListener(this);
		menuItem78.addActionListener(this);
		menuItem79.addActionListener(this);
		menuItem80.addActionListener(this);
		menuItem81.addActionListener(this);
		menuItem82.addActionListener(this);
		menuItem83.addActionListener(this);
		menuItem84.addActionListener(this);
		menuItem85.addActionListener(this);
		menuItem86.addActionListener(this);
		menuItem87.addActionListener(this);
		menuItem88.addActionListener(this);
		menuItem89.addActionListener(this);
		menuItem90.addActionListener(this);
		menuItem91.addActionListener(this);
		menuItem92.addActionListener(this);
		menuItem93.addActionListener(this);
		menuItem94.addActionListener(this);
		menuItem95.addActionListener(this);
		menuItem96.addActionListener(this);
		menuItem97.addActionListener(this);
		menuItem98.addActionListener(this);
		menuItem99.addActionListener(this);
		menuItem100.addActionListener(this);
		menuItem101.addActionListener(this);
		menuItem102.addActionListener(this);
		menuItem103.addActionListener(this);
		menuItem104.addActionListener(this);
		menuItem105.addActionListener(this);
		menuItem106.addActionListener(this);
		menuItem107.addActionListener(this);
		menuItem108.addActionListener(this);
		menuItem109.addActionListener(this);
		menuItem110.addActionListener(this);
		menuItem111.addActionListener(this);
		menuItem112.addActionListener(this);
		menuItem113.addActionListener(this);
		menuItem114.addActionListener(this);
		menuItem115.addActionListener(this);
		menuItem116.addActionListener(this);
		menuItem117.addActionListener(this);
		menuItem118.addActionListener(this);
		menuItem119.addActionListener(this);
		menuItem120.addActionListener(this);
		menuItem121.addActionListener(this);
		menuItem124.addActionListener(this);
		menuItem122.addActionListener(this);
		menuItem123.addActionListener(this);
		menuItem125.addActionListener(this);
		menuItem126.addActionListener(this);
		menuItem127.addActionListener(this);
		menuItem128.addActionListener(this);
		menuItem129.addActionListener(this);
		menuItem130.addActionListener(this);
		menuItem131.addActionListener(this);
		menuItem132.addActionListener(this);
		menuItem133.addActionListener(this);
		menuItem134.addActionListener(this);
		menuItem135.addActionListener(this);
		menuItem136.addActionListener(this);
		menuItem137.addActionListener(this);
		menuItem138.addActionListener(this);
		menuItem139.addActionListener(this);
		menuItem140.addActionListener(this);
		menuItem141.addActionListener(this);
		menuItem142.addActionListener(this);
		menuItem143.addActionListener(this);
		menuItem144.addActionListener(this);
		menuItem145.addActionListener(this);
		menuItem146.addActionListener(this);
		menuItem147.addActionListener(this);
		menuItem148.addActionListener(this);
		menuItem149.addActionListener(this);
		menuItem150.addActionListener(this);
		menuItem151.addActionListener(this);
		menuItem152.addActionListener(this);
		menuItem153.addActionListener(this);
		menuItem154.addActionListener(this);
		menuItem155.addActionListener(this);
		menuItem156.addActionListener(this);
		menuItem157.addActionListener(this);
		menuItem158.addActionListener(this);
		menuItem159.addActionListener(this);
		menuItem160.addActionListener(this);
		menuItem161.addActionListener(this);
		pack();
		setVisible(true);
		setLocation(-5, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// setLocationRelativeTo(getOwner());
		setSize(WIDTH + 10, HEIGHT);
	}

	private boolean dbConnected() {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeQuery("select rack_id from rack where rack_id=1");
			return true;
		} catch (CommunicationsException e) {
			// e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == menuItem151) {
			new SettingSingleUser();
			this.dispose();

		}

		if (!dbConnected()) {
			this.connection = db_connect.getConnection();
		}

		if (event.getSource() == button1) {
			new ManageCategory(connection);
			return;
		}

		if (event.getSource() == button2) {
			new ManageBrand(connection);
			return;
		}

		if (event.getSource() == button3) {
			new ProductList(connection);
			return;
		}

		if (event.getSource() == button4) {
			new ManageDistributor(connection);
			return;
		}

		if (event.getSource() == button5) {
			new SalesBill(connection, userName, MasterHome.SALE_BILL);
			return;
		}

		if (event.getSource() == button6) {
			new PurchaseBill(connection);
			return;
		}

		if (event.getSource() == button7) {
			new DueBillPayment(connection);
			return;
		}

		if (event.getSource() == button8) {
			// new ChangePassword(connection);
			// return;
		}

		String temp = event.getActionCommand();
		switch (temp) {
			case MenuItemName.MenuItem64 :
				new ManageRack(connection);
				break;

			case MenuItemName.MenuItem65 :
				new ManageCategory(connection);
				break;

			case MenuItemName.MenuItem66 :
				new ManageBrand(connection);
				break;

			case MenuItemName.MenuItem67 :
				new ManageVat(connection);
				break;

			case MenuItemName.MenuItem68 :
				new ManageProduct(connection);
				break;

			case MenuItemName.MenuItem69 :
				break;

			case MenuItemName.MenuItem70 :
				break;

			case MenuItemName.MenuItem71 :
				break;

			case MenuItemName.MenuItem72 :
				new ManageWarranty(connection);
				break;

			case MenuItemName.MenuItem73 :
				break;

			case MenuItemName.MenuItem74 :
				new ProductList(connection);
				break;

			case MenuItemName.MenuItem2 :
				new CreditCustomer(connection);
				break;

			case MenuItemName.MenuItem3 :
				new ManageDistributor(connection);
				break;

			case MenuItemName.MenuItem76 :
				break;

			case MenuItemName.MenuItem81 :
				break;

			case MenuItemName.MenuItem82 :
				break;

			case MenuItemName.MenuItem83 :
				break;

			case MenuItemName.MenuItem84 :
				break;

			case MenuItemName.MenuItem77 :
				break;

			case MenuItemName.MenuItem78 :
				break;

			case MenuItemName.MenuItem79 :
				break;

			case MenuItemName.MenuItem80 :
				break;

			case MenuItemName.MenuItem8 :
				new SalesBill(connection, userName, MasterHome.SALE_BILL);
				break;

			case MenuItemName.MenuItem85 :
				new SalesBill(connection, userName, MasterHome.CHALLAN);
				break;

			case MenuItemName.MenuItem9 :
				new SalesBill(connection, userName, MasterHome.SALE_ORDER);
				break;

			case MenuItemName.MenuItem10 :
				new SalesBill(connection, userName, MasterHome.SALE_QUOTATION);
				break;

			case MenuItemName.MenuItem11 :
				new SaleReturn(connection);
				break;

			case MenuItemName.MenuItem12 :
				new DueBillPayment(connection);
				break;

			case MenuItemName.MenuItem13 :
				break;

			case MenuItemName.MenuItem14 :
				break;

			case MenuItemName.MenuItem86 :
				break;

			case MenuItemName.MenuItem87 :
				break;

			case MenuItemName.MenuItem88 :
				break;

			case MenuItemName.MenuItem89 :
				break;

			case MenuItemName.MenuItem15 :
				new PurchaseBill(connection);
				break;

			case MenuItemName.MenuItem16 :
				new PurchaseReturn(connection);
				break;

			case MenuItemName.MenuItem17 :
				new PurchaseOrder(connection);
				break;

			case MenuItemName.MenuItem27 :
				break;
			case MenuItemName.MenuItem90 :
				break;
			case MenuItemName.MenuItem91 :
				break;
			case MenuItemName.MenuItem92 :
				break;
			case MenuItemName.MenuItem93 :
				break;
			case MenuItemName.MenuItem94 :
				break;
			case MenuItemName.MenuItem95 :
				break;
			case MenuItemName.MenuItem96 :
				break;
			case MenuItemName.MenuItem30 :
				new BillBookGeneral(connection);
				break;
			case MenuItemName.MenuItem31 :
				new BillBookCredit(connection);
				break;
			case MenuItemName.MenuItem32 :
				new BillBookChallan(connection);
				break;
			case MenuItemName.MenuItem33 :
				new BillBookPurchase(connection);
				break;
			case MenuItemName.MenuItem34 :
				new BillBookPurchaseDue(connection);
				break;
			case MenuItemName.MenuItem35 :
				new BillBookMargin(connection);
				break;
			case MenuItemName.MenuItem36 :
				new BillBookDiscount(connection);
				break;
			case MenuItemName.MenuItem97 :
				new PendingOrder(connection);
				break;
			case MenuItemName.MenuItem101 :
				break;
			case MenuItemName.MenuItem102 :
				break;
			case MenuItemName.MenuItem103 :
				break;
			case MenuItemName.MenuItem104 :
				break;
			case MenuItemName.MenuItem105 :
				break;
			case MenuItemName.MenuItem106 :
				break;
			case MenuItemName.MenuItem107 :
				break;
			case MenuItemName.MenuItem108 :
				break;
			case MenuItemName.MenuItem109 :
				break;
			case MenuItemName.MenuItem110 :
				break;
			case MenuItemName.MenuItem111 :
				break;
			case MenuItemName.MenuItem112 :
				break;
			case MenuItemName.MenuItem113 :
				break;
			case MenuItemName.MenuItem114 :
				break;
			case MenuItemName.MenuItem115 :
				break;
			case MenuItemName.MenuItem116 :
				break;
			case MenuItemName.MenuItem117 :
				break;
			case MenuItemName.MenuItem118 :
				break;
			case MenuItemName.MenuItem119 :
				break;
			case MenuItemName.MenuItem120 :
				break;
			case MenuItemName.MenuItem121 :
				break;
			case MenuItemName.MenuItem122 :
				break;
			case MenuItemName.MenuItem123 :
				break;
			case MenuItemName.MenuItem124 :
				break;
			case MenuItemName.MenuItem37 :
				break;
			case MenuItemName.MenuItem38 :
				break;
			case MenuItemName.MenuItem39 :
				break;
			case MenuItemName.MenuItem125 :
				break;
			case MenuItemName.MenuItem126 :
				new PurchaseMonthlyReport(connection);
				break;
			case MenuItemName.MenuItem127 :
				new PurchaseQuartrlyReport(connection);
				break;
			case MenuItemName.MenuItem128 :
				new PurchaseHalfYearlyReport(connection);
				break;
			case MenuItemName.MenuItem129 :
				new PurchaseYearlyReport(connection);
				break;
			case MenuItemName.MenuItem130 :
				break;
			case MenuItemName.MenuItem131 :
				break;
			case MenuItemName.MenuItem132 :
				break;
			case MenuItemName.MenuItem133 :
				break;
			case MenuItemName.MenuItem134 :
				break;
			case MenuItemName.MenuItem135 :
				break;
			case MenuItemName.MenuItem136 :
				break;
			case MenuItemName.MenuItem137 :
				break;
			case MenuItemName.MenuItem138 :
				break;
			case MenuItemName.MenuItem139 :
				break;
			case MenuItemName.MenuItem140 :
				break;
			case MenuItemName.MenuItem141 :
				break;
			case MenuItemName.MenuItem40 :
				break;
			case MenuItemName.MenuItem41 :
				break;
			case MenuItemName.MenuItem42 :
				break;
			case MenuItemName.MenuItem43 :
				break;
			case MenuItemName.MenuItem98 :
				break;
			case MenuItemName.MenuItem99 :
				break;
			case MenuItemName.MenuItem100 :
				break;
			case MenuItemName.MenuItem44 :
				break;
			case MenuItemName.MenuItem151 :

				break;
			case MenuItemName.MenuItem152 :
				break;
			case MenuItemName.MenuItem153 :
				break;
			case MenuItemName.MenuItem45 :
				break;
			case MenuItemName.MenuItem46 :
				break;
			case MenuItemName.MenuItem47 :
				break;
			case MenuItemName.MenuItem48 :
				break;
			case MenuItemName.MenuItem49 :
				break;
			case MenuItemName.MenuItem154 :
				break;
			case MenuItemName.MenuItem155 :
				break;
			case MenuItemName.MenuItem50 :
				break;
			case MenuItemName.MenuItem51 :
				break;
			case MenuItemName.MenuItem142 :
				break;
			case MenuItemName.MenuItem143 :
				break;
			case MenuItemName.MenuItem157 :
				break;
			case MenuItemName.MenuItem158 :
				break;
			case MenuItemName.MenuItem159 :
				break;
			case MenuItemName.MenuItem160 :
				break;
			case MenuItemName.MenuItem161 :
				break;
			case MenuItemName.MenuItem156 :
				break;
			case MenuItemName.MenuItem144 :
				break;
			case MenuItemName.MenuItem145 :
				break;
			case MenuItemName.MenuItem146 :
				break;
			case MenuItemName.MenuItem147 :
				break;
			case MenuItemName.MenuItem148 :
				new StoreRegistration(connection);
				break;
			case MenuItemName.MenuItem149 :
				break;
			case MenuItemName.MenuItem150 :
				break;
			case MenuItemName.MenuItem57 :
				break;
			case MenuItemName.MenuItem56 :
				break;
			case MenuItemName.MenuItem58 :
				break;
			case MenuItemName.MenuItem59 :
				break;
			case MenuItemName.MenuItem60 :
				break;
			case MenuItemName.MenuItem52 :
				new Calculator();
				break;
			case MenuItemName.MenuItem53 :
				new NotePad();
				break;
			case MenuItemName.MenuItem54 :
				new MediaPlayer();
				break;

		}

	}
}
