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
	ArrayList<String> Arraycache = new ArrayList<String>();// �������ݼ���
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
		 * ������壬��������� HTML �� div ��ǩ ���ǿ��Դ��������岢�� JFrame ��ָ��λ��
		 * ��������ǿ�������ı��ֶΣ���ť�����������
		 */
		// ������
		frame.getContentPane().add(panel);
		/*
		 * �����û�����ķ����������������
		 */
		u.placeComponents(panel);

		// ���ý���ɼ�
		frame.setVisible(true);
		// ��ʼ������

	}

	public void init(int port) {
		System.out.println(" �������������� :");
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
		 * ���ֲ���������߲��������� ������ò���Ϊ null
		 */
		panel.setLayout(null);

		//
		JLabel passwordLabel = new JLabel("�˿ںţ�");
		passwordLabel.setBounds(10, 10, 80, 25);
		panel.add(passwordLabel);

		/*
		 * �����������������ı��� �����������Ϣ���Ե�Ŵ��棬���ڰ�������İ�ȫ��
		 */
		JTextField portTest = new JTextField(20);
		portTest.setBounds(68, 10, 111, 25);
		panel.add(portTest);

		// ��������ť
		JButton startservicebutton = new JButton("��������");
		startservicebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(portTest.getText().toString());
				init(Integer.parseInt(portTest.getText().toString()));
				getData();
			}
		});
		startservicebutton.setBounds(10, 40, 90, 25);
		panel.add(startservicebutton);

		// ���ͼ��
		JButton cleardata = new JButton("���ͼ��");
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
		// ��������
		JButton testdata = new JButton("��������");
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
					// 2.�������ݱ��������˷��͵���Ϣ
					DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
					DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
					// 3.���� DatagramSocket
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
					// 4.��������˷�������

				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		testdata.setBounds(10, 100, 90, 25);
		panel.add(testdata);

		// �豸�б�
		JLabel listviewLabel = new JLabel("�豸�б�");
		listviewLabel.setBounds(189, 0, 80, 25);
		panel.add(listviewLabel);

		ListModel jListModel = new DefaultComboBoxModel(new String[] {}); // ����ģ��
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
					// ��ѡ����±�
					obj = null;
					obj = myList.getModel().getElementAt(index); // ȡ������
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
		JFreeChart chart1 = UtilTools.createChart1(datasetDataset1, "����");
		ChartPanel chartPanel1 = new ChartPanel(chart1);
		chartPanel1.setBounds(5, 265, 300, 250);
		panel.add(chartPanel1);

		series2 = new XYSeries("test");
		XYSeriesCollection dataset2 = new XYSeriesCollection();
		dataset2.addSeries(series2);
		XYDataset datasetDataset2 = dataset2;
		JFreeChart chart2 = UtilTools.createChart1(datasetDataset2, "����");
		ChartPanel chartPanel2 = new ChartPanel(chart2);
		chartPanel2.setBounds(338, 265, 300, 250);
		panel.add(chartPanel2);

		series3 = new XYSeries("test");
		XYSeriesCollection dataset3 = new XYSeriesCollection();
		dataset3.addSeries(series3);
		XYDataset datasetDataset3 = dataset3;
		JFreeChart chart3 = UtilTools.createChart1(datasetDataset3, "����");
		ChartPanel chartPanel3 = new ChartPanel(chart3);
		chartPanel3.setBounds(338, 5, 300, 250);
		panel.add(chartPanel3);

		series4 = new XYSeries("test");
		XYSeriesCollection dataset4 = new XYSeriesCollection();
		dataset4.addSeries(series4);
		XYDataset datasetDataset4 = dataset4;
		JFreeChart chart4 = UtilTools.createChart1(datasetDataset4, "�ź�");
		ChartPanel chartPanel4 = new ChartPanel(chart4);
		chartPanel4.setBounds(640, 5, 300, 250);
		panel.add(chartPanel4);

		textArea = new JTextArea("��ӡ��Ϣ��");
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

	// ������ݽ�ͼ��
	private void getdatashow(String name, int data) {
		System.out.println("data:" + data + ",heartdatalist.size:" + heartdatalist.size());
		if (data < heartdatalist.size()) {
			if (name.equals(UtilTools.getname(heartdatalist.get(data)))) {
				// ɾ����ʾ�����ݣ�ֻ������60��
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
			showdatalog();// ʵʱˢ��log����
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
					getdatashow(obj.toString(), j);// ʵʱˢ��ͼ������
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

	// ���յ���վ������������
	byte[] bytes = new byte[1024];
	DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
	byte[] buf = new byte[31];
	byte[] data = new byte[31];
	byte[] devicedata = new byte[8];
	String devicename;

	int heart, step, temp, pager, Electricity, Electricity_data, heart_refresh, sleep_a, sleep_b, te_new, de_status,
			de_clock, de_hang, blood_re, blood_pres;
	byte rssi; // ��������
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
							// ������
						} else if (buf[1] == 1) {
							// ��ȡ�����õ����ݰ�
							System.arraycopy(buf, 0, data, 0, 31);
						}

						if (data[0] == 0x03 && data[1] == 0x01 && data[4] == 0x1A && (data[5] & 0xff) == 0xFF) {
							Cache(data);
							// ���ù̶�UUID��Ĵ���취
							System.arraycopy(data, 6, devicedata, 0, 8);
							devicename = UtilTools.bytetoint16(devicedata[0]) + ","
									+ UtilTools.bytetoint16(devicedata[1]) + "," + UtilTools.bytetoint16(devicedata[2])
									+ "," + UtilTools.bytetoint16(devicedata[3]) + ","
									+ UtilTools.bytetoint16(devicedata[4]) + "," + UtilTools.bytetoint16(devicedata[5])
									+ "," + UtilTools.bytetoint16(devicedata[6]) + ","
									+ UtilTools.bytetoint16(devicedata[7]);
							System.out.println("devicename : " + devicename);
							devicenameadd(devicename);// ���뼯��
							heart = (data[16] & 0xff); // ��������
							System.out.println("�������� : " + heart);
							deivceTest(devicename, heart);
							rssi = (byte) (data[17] & 0xff); // ��������
							System.out.println("�ź� : " + rssi);
							deivceTest2(devicename, rssi);
							step = (((int) (data[18] & 0xff) & 0x7f) << 10) | (((int) (data[19] & 0xff)) << 2)
									| ((data[20] & 0xff) >> 6); // �˶�����
							System.out.println("�˶����� : " + step);
							deivceTest3(devicename, step);
							temp = ((int) (data[23] & 0xff) & 0x7f) << 4 | ((data[24] & 0xff) >> 4); // �����¶ȣ��Ŵ�ʮ��
							System.out.println("�����¶�: " + temp / 10);
							deivceTest5(devicename, temp / 10);
							pager = data[14] & 0xFF;
							System.out.println("һ�ű��ģ�" + pager);
							Electricity = (data[15] & 0xFF) >> 7;
							System.out.println("�������£�" + Electricity);
							Electricity_data = (data[15] & 0xFF) & 0b01111111;
							System.out.println("�������ݣ�" + Electricity_data);
							heart_refresh = (data[18] & 0xFF) >> 7;
							System.out.println("���ʸ��£�" + heart_refresh);
							sleep_a = ((int) (data[20] & 0xFF) & 0b00111111) << 5 | ((data[21] & 0xFF) >> 3);
							System.out.println("������ǳ˯ʱ�䣺" + sleep_a);

							sleep_b = ((int) (data[21] & 0xFF) & 0b00000111) << 8 | (data[22] & 0xFF);
							System.out.println("��������˯ʱ�䣺" + sleep_b);

							te_new = (((data[23] & 0xFF) >> 7));
							System.out.println("�����¶��Ƿ��������ݣ�" + te_new);

							de_status = (((data[24] & 0xFF) >> 3) & 0b00001);
							System.out.println("�豸״̬��" + de_status);
							de_clock = (((data[24] & 0xFF) >> 2) & 0b000001);
							System.out.println("����������" + de_clock);

							de_hang = (((data[24] & 0xFF) >> 1) & 0b0000001);
							System.out.println("�Ƿ������" + de_hang);

							blood_re = ((data[24] & 0xFF) & 0b00000001);
							System.out.println("Ѫѹ���£�" + blood_re);

							blood_pres = ((data[25] & 0xFF));
							System.out.println("��Ѫѹ��" + blood_pres);
						} else {
							System.out.println("���ݰ�����: ");
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

	// �������ݵķ���
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
				// ��ʾ����
				for (int j = (counts - 1) * 31; j < counts * 31 - 1; j++) {
					if (j == (counts * 31 - 2)) {
						displayLogtextBox4("," + Arraycache.get(j), 1);
						if (Arraycache.size() > 1550) {// ֻ����50�����ݰ�,������Զ�ɾ��
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

	// �����¶�
	private void deivceTest5(String name, int i) {
		temperaturedatalist.add(name + ":" + i);
		if (!tlog.isRunning()) {
			tlog.start();
		}
	}

	// �˶�����
	private void deivceTest3(String name, int hea) {
		stepdatalist.add(name + ":" + hea);
	}

	// ��������
	private void deivceTest(String name, int hear) {
		heartdatalist.add(name + ":" + hear);
	}

	// �ź�����
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

	// ��Jlist���������
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
