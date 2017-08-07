package ec.demo.usniffer;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleEdge;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

public class usniffer {
	ArrayList<String> Arraycache = new ArrayList<String>();// 缓存数据集合
	JFrame frame;
	XYSeries series1, series2, series3, series4;
	JList myJlist;
	DatagramSocket server;
	ArrayList<String> devicenamelist = new ArrayList<String>() {
	};

	ArrayList<String> heartdatalist = new ArrayList<String>() {
	};
	ArrayList<String> stepdatalist = new ArrayList<String>() {
	};
	ArrayList<String> temperaturedatalist = new ArrayList<String>() {
	};
	ArrayList<String> rssidatalist = new ArrayList<String>() {
	};
	String[] namelist = new String[3];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		usniffer u = new usniffer();
		JFrame frame = new JFrame("UDPDemo");
		// Setting the width and height of frame
		frame.setSize(1030, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		/*
		 * 创建面板，这个类似于 HTML 的 div 标签 我们可以创建多个面板并在 JFrame 中指定位置
		 * 面板中我们可以添加文本字段，按钮及其他组件。
		 */
		// 添加面板
		frame.getContentPane().add(panel);
		/*
		 * 调用用户定义的方法并添加组件到面板
		 */
		u.placeComponents(panel);

		// 设置界面可见
		frame.setVisible(true);
		// 初始化服务

	}

	public void init(int port) {
		System.out.println(" 服务器端已启动 :");
		try {
			server = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	boolean teststart = true;
	Object obj = null;
	JTextArea textArea;

	public void placeComponents(JPanel panel) {

		/*
		 * 布局部分我们这边不多做介绍 这边设置布局为 null
		 */
		panel.setLayout(null);

		//
		JLabel passwordLabel = new JLabel("端口号：");
		passwordLabel.setBounds(10, 10, 80, 25);
		panel.add(passwordLabel);

		/*
		 * 这个类似用于输入的文本域 但是输入的信息会以点号代替，用于包含密码的安全性
		 */
		JTextField portTest = new JTextField(20);
		portTest.setBounds(68, 10, 111, 25);
		panel.add(portTest);

		// 启动服务按钮
		JButton startservicebutton = new JButton("启动服务");
		startservicebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(portTest.getText().toString());
				init(Integer.parseInt(portTest.getText().toString()));
				getData();
			}
		});
		startservicebutton.setBounds(10, 40, 90, 25);
		panel.add(startservicebutton);

		// 清空图表
		JButton cleardata = new JButton("清空图表");
		cleardata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				series1.clear();
				series2.clear();
				series3.clear();
				series4.clear();
				se1 = 1;
				se2 = 1;
				se3 = 1;
				se4 = 1;
				j = 0;
				is_need_refreshChartData = false;
				tchart.stop();
			}
		});
		cleardata.setBounds(10, 70, 90, 25);
		panel.add(cleardata);
		// 测试数据
		JButton testdata = new JButton("测试数据");
		testdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InetAddress address;
				try {
					address = InetAddress.getByName("192.168.1.51");
					int port = 6001;
					byte[] data = new byte[] { 3, 1, 0, 0, 26, (byte) 255, (byte) 255, (byte) 255, (byte) 255,
							(byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, 1, 36, 61, (byte) 159, 0, 0, 2,
							64, 72, 18, 48, 0, 36, 56, 49, 89, (byte) 164 };

					byte[] data2 = new byte[] { 3, 1, 0, 0, 26, (byte) 255, (byte) 255, (byte) 255, (byte) 255,
							(byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, 12, 22, 84, (byte) 159, 0, 0, 2,
							68, 72, 18, 48, 0, 36, 56, 49, 89, (byte) 164 };
					// 2.创建数据报，包含了发送的信息
					DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
					DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
					// 3.创建 DatagramSocket
					DatagramSocket client;
					try {
						client = new DatagramSocket();
						try {
							for (int i = 0; i < 3; i++) {

								if (i > 980) {
									client.send(packet2);
								} else {
									client.send(packet);
								}
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (SocketException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// 4.向服务器端发送数据

				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		testdata.setBounds(10, 100, 90, 25);
		panel.add(testdata);

		// 设备列表
		JLabel listviewLabel = new JLabel("设备列表：");
		listviewLabel.setBounds(189, 0, 80, 25);
		panel.add(listviewLabel);

		ListModel jListModel = new DefaultComboBoxModel(new String[] {}); // 数据模型
		myJlist = new JList();
		myJlist.setModel(jListModel);
		myJlist.setVisibleRowCount(2);
		myJlist.setBounds(189, 24, 140, 150);

		myJlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!myJlist.getValueIsAdjusting()) {
					JList myList = (JList) e.getSource();
					int index = myList.getSelectedIndex();
					// 已选项的下标
					obj = null;
					obj = myList.getModel().getElementAt(index); // 取出数据
					series1.clear();
					series2.clear();
					series3.clear();
					series4.clear();
					se1 = 1;
					se2 = 1;
					se3 = 1;
					se4 = 1;
					j = 0;
					is_need_refreshChartData = true;
					if (tchart.isRunning()) {
						tchart.stop();
						tchart.start();
					} else {
						tchart.start();
					}
				}
			}
		});
		JScrollPane jsc = new JScrollPane(myJlist);
		jsc.setBounds(189, 24, 141, 150);
		panel.add(jsc);
		series1 = new XYSeries("Random Data 2");
		XYSeriesCollection dataset1 = new XYSeriesCollection();
		dataset1.addSeries(series1);
		XYDataset datasetDataset1 = dataset1;
		JFreeChart chart1 = UtilTools.createChart1(datasetDataset1, "心率");
		ChartPanel chartPanel1 = new ChartPanel(chart1);
		chartPanel1.setBounds(5, 265, 300, 250);
		panel.add(chartPanel1);

		series2 = new XYSeries("test");
		XYSeriesCollection dataset2 = new XYSeriesCollection();
		dataset2.addSeries(series2);
		XYDataset datasetDataset2 = dataset2;
		JFreeChart chart2 = UtilTools.createChart1(datasetDataset2, "步数");
		ChartPanel chartPanel2 = new ChartPanel(chart2);
		chartPanel2.setBounds(338, 265, 300, 250);
		panel.add(chartPanel2);

		series3 = new XYSeries("test");
		XYSeriesCollection dataset3 = new XYSeriesCollection();
		dataset3.addSeries(series3);
		XYDataset datasetDataset3 = dataset3;
		JFreeChart chart3 = UtilTools.createChart1(datasetDataset3, "体温");
		ChartPanel chartPanel3 = new ChartPanel(chart3);
		chartPanel3.setBounds(338, 5, 300, 250);
		panel.add(chartPanel3);

		series4 = new XYSeries("test");
		XYSeriesCollection dataset4 = new XYSeriesCollection();
		dataset4.addSeries(series4);
		XYDataset datasetDataset4 = dataset4;
		JFreeChart chart4 = UtilTools.createChart1(datasetDataset4, "信号");
		ChartPanel chartPanel4 = new ChartPanel(chart4);
		chartPanel4.setBounds(640, 5, 300, 250);
		panel.add(chartPanel4);

		textArea = new JTextArea("打印信息：");
		scrollPane = new JScrollPane();
		scrollPane.setBounds(645, 265, 330, 250);
		scrollPane.setViewportView(textArea);
		scrollPane.setAutoscrolls(true);
		panel.add(scrollPane, BorderLayout.CENTER);
	}

	private JScrollPane scrollPane;
	static StringBuilder tempselect = new StringBuilder();

	public void displayLogtextBox4(String log, int i) {
		if (i == 2) {
			textArea.append(log);
		} else if (i == 1) {
			textArea.append(log + "\n");
		}
	}

	int se1 = 1;
	int se2 = 1;
	int se3 = 1;
	int se4 = 1;
	int j = 0;

	// 添加数据进图表
	private void getdatashow(String name, int data) {
		System.out.println("data:" + data + ",heartdatalist.size:" + heartdatalist.size());
		if (data < heartdatalist.size()) {
			if (name.equals(UtilTools.getname(heartdatalist.get(data)))) {
				// 删除显示的数据，只保持有60条
				if (teststart) {
					series1.add(se1, UtilTools.getdata(heartdatalist.get(data)));
					se1++;
				}
				if (series1.getItemCount() > 60) {
					series1.remove(0);
				}
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (data < temperaturedatalist.size()) {
			if (name.equals(UtilTools.getname(temperaturedatalist.get(data)))) {

				if (teststart) {
					series3.add(se2, UtilTools.getdata(temperaturedatalist.get(data)));
					se2++;
				}
				if (series3.getItemCount() > 60) {
					series3.remove(0);
				}
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		if (data < stepdatalist.size()) {
			if (name.equals(UtilTools.getname(stepdatalist.get(data)))) {

				if (teststart) {
					series2.add(se3, UtilTools.getdata(stepdatalist.get(data)));
					se3++;
				}
				if (series2.getItemCount() > 60) {
					series2.remove(0);
				}
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		if (data < rssidatalist.size()) {
			if (name.equals(UtilTools.getname(rssidatalist.get(data)))) {

				if (teststart) {
					series4.add(se4, UtilTools.getdata(rssidatalist.get(data)));
					se4++;
				}
				if (series4.getItemCount() > 60) {
					series4.remove(0);
				}
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	Timer tlog = new Timer(600, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			showdatalog();// 实时刷新log数据
		}
	});
	Timer tchart = new Timer(100, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			showchartData();
		}
	});

	private void showchartData() {
		if (is_need_refreshChartData) {
			for (int i = 0; i < devicenamelist.size(); i++) {
				if (obj != null && obj.toString().equals(devicenamelist.get(i)) && teststart)
					getdatashow(obj.toString(), j);// 实时刷新图表数据
				if(heartdatalist.size() >60){
					heartdatalist.remove(0);
					temperaturedatalist.remove(0);
					rssidatalist.remove(0);
					stepdatalist.remove(0);
					j--; 
				}
				if (j < heartdatalist.size()) {
					j++;
				}
			}
		}

	}

	// 接收到基站发过来的数据
	byte[] bytes = new byte[1024];
	DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
	byte[] buf = new byte[31];
	byte[] data = new byte[31];
	byte[] devicedata = new byte[8];
	String devicename;

	int heart, step, temp, pager, Electricity, Electricity_data, heart_refresh, sleep_a, sleep_b, te_new, de_status,
			de_clock, de_hang, blood_re, blood_pres;
	byte rssi; // 心率数据
	boolean is_start = true, is_need_reshowdatalog = true, is_need_refreshChartData = true;

	public void getData() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (is_start) {
					try {
						server.receive(packet);
						for (int i = 0; i < 31; i++) {

							System.out.print(UtilTools.bytetoint16(bytes[i]) + ", ");
						}
						System.out.println("  ");

						System.arraycopy(bytes, 0, buf, 0, 31);
						if (buf[1] == 3) {
							// 心跳包
						} else if (buf[1] == 1) {
							// 获取到有用的数据包
							System.arraycopy(buf, 0, data, 0, 31);
						}

						if (data[0] == 0x03 && data[1] == 0x01 && data[4] == 0x1A && (data[5] & 0xff) == 0xFF) {
							Cache(data);
							// 设置固定UUID后的处理办法
							System.arraycopy(data, 6, devicedata, 0, 8);
							devicename = UtilTools.bytetoint16(devicedata[0]) + ","
									+ UtilTools.bytetoint16(devicedata[1]) + "," + UtilTools.bytetoint16(devicedata[2])
									+ "," + UtilTools.bytetoint16(devicedata[3]) + ","
									+ UtilTools.bytetoint16(devicedata[4]) + "," + UtilTools.bytetoint16(devicedata[5])
									+ "," + UtilTools.bytetoint16(devicedata[6]) + ","
									+ UtilTools.bytetoint16(devicedata[7]);
							System.out.println("devicename : " + devicename);
							devicenameadd(devicename);// 加入集合
							heart = (data[16] & 0xff); // 心率数据
							System.out.println("心率数据 : " + heart);
							deivceTest(devicename, heart);
							rssi = (byte) (data[17] & 0xff); // 心率数据
							System.out.println("信号 : " + rssi);
							deivceTest2(devicename, rssi);
							step = (((int) (data[18] & 0xff) & 0x7f) << 10) | (((int) (data[19] & 0xff)) << 2)
									| ((data[20] & 0xff) >> 6); // 运动步数
							System.out.println("运动步数 : " + step);
							deivceTest3(devicename, step);
							temp = ((int) (data[23] & 0xff) & 0x7f) << 4 | ((data[24] & 0xff) >> 4); // 环境温度，放大十倍
							System.out.println("环境温度: " + temp / 10);
							deivceTest5(devicename, temp / 10);
							pager = data[14] & 0xFF;
							System.out.println("一号报文：" + pager);
							Electricity = (data[15] & 0xFF) >> 7;
							System.out.println("电量更新：" + Electricity);
							Electricity_data = (data[15] & 0xFF) & 0b01111111;
							System.out.println("电量数据：" + Electricity_data);
							heart_refresh = (data[18] & 0xFF) >> 7;
							System.out.println("心率更新：" + heart_refresh);
							sleep_a = ((int) (data[20] & 0xFF) & 0b00111111) << 5 | ((data[21] & 0xFF) >> 3);
							System.out.println("当天总浅睡时间：" + sleep_a);

							sleep_b = ((int) (data[21] & 0xFF) & 0b00000111) << 8 | (data[22] & 0xFF);
							System.out.println("当天总深睡时间：" + sleep_b);

							te_new = (((data[23] & 0xFF) >> 7));
							System.out.println("环境温度是否有新数据：" + te_new);

							de_status = (((data[24] & 0xFF) >> 3) & 0b00001);
							System.out.println("设备状态：" + de_status);
							de_clock = (((data[24] & 0xFF) >> 2) & 0b000001);
							System.out.println("紧急报警：" + de_clock);

							de_hang = (((data[24] & 0xFF) >> 1) & 0b0000001);
							System.out.println("是否佩戴：" + de_hang);

							blood_re = ((data[24] & 0xFF) & 0b00000001);
							System.out.println("血压更新：" + blood_re);

							blood_pres = ((data[25] & 0xFF));
							System.out.println("高血压：" + blood_pres);
						} else {
							System.out.println("数据包不对: ");
						}
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println(e1.toString());
					}
				}
			}
		}).start();
	}

	StringBuffer sb = new StringBuffer();
	int counts = 1;

	// 缓存数据的方法
	private void Cache(byte[] arr) {
		for (int j = 0; j < 31; j++) {
			Arraycache.add(UtilTools.bytetoint16(arr[j]));
		}
	}

	boolean testfinish = true;

	private void showdatalog() {
		if (Arraycache.size() == 0) {
			return;
		}
		if (testfinish) {
			if (Arraycache.size() < 30) {
				testfinish = true;
				return;
			} else if (Arraycache.size() >= 31 * counts) {
				testfinish = false;
				displayLogtextBox4(UtilTools.getDate() + "\n", 2);
				// 显示数据
				for (int j = (counts - 1) * 31; j < counts * 31 - 1; j++) {
					if (j == (counts * 31 - 2)) {
						displayLogtextBox4("," + Arraycache.get(j), 1);
						if (Arraycache.size() > 1550) {// 只缓存50个数据包,多余的自动删除
							for (int i = 0; i < 31; i++) {
								Arraycache.remove(i);
							}
						}
					} else {
						displayLogtextBox4("," + Arraycache.get(j), 2);
					}
				}
				testfinish = true;
				counts++;
			}
		}
	}

	// 环境温度
	private void deivceTest5(String name, int i) {
		temperaturedatalist.add(name + ":" + i);
		if (!tlog.isRunning()) {
			tlog.start();
		}
	}

	// 运动步数
	private void deivceTest3(String name, int hea) {
		stepdatalist.add(name + ":" + hea);
	}

	// 心率数据
	private void deivceTest(String name, int hear) {
		heartdatalist.add(name + ":" + hear);
	}

	// 信号数据
	private void deivceTest2(String name, byte hear) {
		rssidatalist.add(name + ":" + hear);
	}

	private void devicenameadd(String name) {
		if (devicenamelist.size() == 0) {
			devicenamelist.add(name);
			adddatatolistview(name);
		}
		for (int i = 0; i < devicenamelist.size(); i++) {
			if (name.equals(devicenamelist.get(i))) {
				return;

			} else if (i == devicenamelist.size() - 1) {
				devicenamelist.add(name);
				adddatatolistview(name);
			}
		}
	}

	// 向Jlist中添加数据
	private void adddatatolistview(String name) {
		if (namelist[0] == null) {
			namelist[0] = name;
		}
		for (int i = 0; i < namelist.length; i++) {
			if (name.equals(namelist[i])) {
				break;

			} else if (i == namelist.length - 1) {
				namelist[i] = name;
			} else if (namelist[i] == null) {
				namelist[i] = name;
				break;
			}
		}
		ListModel jListModel = new DefaultComboBoxModel(namelist); //
		myJlist.clearSelection();
		myJlist.setModel(jListModel);
	}
}
