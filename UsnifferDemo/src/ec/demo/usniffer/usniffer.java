package ec.demo.usniffer;


import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Minute;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
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
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class usniffer implements ActionListener{
	  static Timer timer,timer2;  
	 JFrame frame;
	 static XYSeries series1,series2,series3;
     static JList myJlist;
     static DatagramSocket server;
     static ArrayList<String> devicenamelist = new ArrayList<String>() { };
     
     static ArrayList<String> heartdatalist = new ArrayList<String>() { };
     static ArrayList<String> stepdatalist = new ArrayList<String>() { };
     static ArrayList<String> temperaturedatalist = new ArrayList<String>() { };
     String[] namelist=new String[3];
	/**
	 * Launch the application.
	 */
     public usniffer(){
    	 timer = new Timer(5, this);  
    	 timer.start(); 
     }
	public static void main(String[] args) {
		 JFrame frame = new JFrame("UDPDemo");
	        // Setting the width and height of frame
	        frame.setSize(900, 660);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        JScrollPane  panel = new JScrollPane ();
	        /* 创建面板，这个类似于 HTML 的 div 标签
	         * 我们可以创建多个面板并在 JFrame 中指定位置
	         * 面板中我们可以添加文本字段，按钮及其他组件。
	         */
	        
	        // 添加面板
	        frame.getContentPane().add(panel);
	        /* 
	         * 调用用户定义的方法并添加组件到面板
	         */
	        placeComponents(panel);

	        // 设置界面可见
	        frame.setVisible(true);
	        //初始化服务
	    	
	        
	}
     public static void init(int port){
    	 System.out.println(" 服务器端已启动 :");
    	 usniffer u =new  usniffer();
    	    try {
				server = new DatagramSocket(port);
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     }
     static int j ;
	 public static void placeComponents(JScrollPane  panel) {

	        /* 布局部分我们这边不多做介绍
	         * 这边设置布局为 null
	         */
	        panel.setLayout(null);

	        // 输入密码的文本域
	        JLabel passwordLabel = new JLabel("端口号：");
	        passwordLabel.setBounds(10,10,80,25);
	        panel.add(passwordLabel);

	        /* 
	         *这个类似用于输入的文本域
	         * 但是输入的信息会以点号代替，用于包含密码的安全性
	         */
//	        JPasswordField portTest = new JPasswordField(20);
	        JTextField portTest = new JTextField(20);
	        portTest.setBounds(68,10,111,25);
	        panel.add(portTest);

	        // 启动服务按钮
	        JButton startservicebutton = new JButton("启动服务");
	        startservicebutton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		System.out.println( portTest.getText().toString());
	        		 init(Integer.parseInt(portTest.getText().toString()));
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
	        		se1 =1;
	        		se2 =1;
	        		se3 =1;
	        		if(timer2  !=null ){
	        			timer2.stop();
	        		}
	        		j =0;
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
						address = InetAddress.getByName("192.168.1.75");
						int port = 6001;
	        	        byte[] data = new byte[] { 5, 1, (byte) 255, (byte) 255, (byte) 255, (byte) 255, 32, 2, 3, 8, 66, 50, 26, (byte) 255, 25, 25, 25, 25, 25, 25, 25, 25, 1, 52, 20, 0, 2, 2, 2, 0, 0, 2, 2, 0, 2, 33, 51, 114, 63 };
	        	        byte[] array1 = new byte[] { 5, 1, (byte) 255, (byte) 255, (byte) 255, (byte) 255, 32, 2, 3, 8, 66, 50, 26, (byte) 255, 19, 19, 19, 19, 19, 19, 19, 19, 1, 52, 10, 0, 1, 1, 1, 0, 0, 1, 1, 0, 2, 33, 51, 114, 63 };
	        	        // 2.创建数据报，包含了发送的信息
	        	        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
	        	        DatagramPacket packet2 = new DatagramPacket(array1, array1.length, address, port);
	        	        // 3.创建 DatagramSocket
	        	        DatagramSocket client;
						try {
							client = new DatagramSocket();
							 try {
								 for (int i = 0; i <4; i++)
						            {
									 client.send(packet);
									 client.send(packet2);
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
	        listviewLabel.setBounds(189, 0,80,25);
	        panel.add(listviewLabel);
	        
	        ListModel jListModel =  new DefaultComboBoxModel(new String[] {});  //数据模型
	        myJlist = new JList();
	        myJlist.setModel(jListModel);
	        myJlist.setVisibleRowCount(2);
	        myJlist.setBounds(189, 24, 140, 150);
	        myJlist.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
//                    if(e.getClickCount() == 2){
                        System.out.println("双击");
                        JList myList = (JList) e.getSource();
                        int index = myList.getSelectedIndex();    //已选项的下标
                        Object obj = myList.getModel().getElementAt(index);  //取出数据
//                        System.out.println(obj.toString());
                        //暂时没想到什么更好的写法......

								timer2 =new Timer(5, new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent arg0) {
										for (int i = 0; i < devicenamelist.size(); i++)
						                {
						                    if (obj.toString().equals(devicenamelist.get(i)))
						                    {
						                        getdatashow(obj.toString(), j);
						                        if (j < heartdatalist.size()) {
							                        j++;
							                    }
						                    }
						                }
									}
								});
		                        timer2.start();
                    }
//                }
            });
	        JScrollPane jsc =new JScrollPane(myJlist);
	        jsc.setBounds(189,24,141,150);
	        panel.add(jsc);
	     
//	        series1 = new XYSeries("");  
//	        XYSeriesCollection dataset = new XYSeriesCollection();  
//	        ChartPanel chartPanel = new ChartPanel(createChart(dataset,"心率")); 
//	        dataset.addSeries(series1);
//	        chartPanel.setBounds(0,250,420,300);
//	        panel.add(chartPanel);  
	        
	        
	        series1 = new XYSeries("Random Data 2");
	        XYSeriesCollection dataset1 = new XYSeriesCollection();
	        dataset1.addSeries(series1);
	        XYDataset datasetDataset1 = dataset1;
	        JFreeChart chart1 = createChart1(datasetDataset1,"心率");
	        ChartPanel chartPanel1= new ChartPanel(chart1);
	        chartPanel1.setBounds(0,250,420,300);
	        panel.add(chartPanel1);  
	        
	        
	       
	        
	        
	        series2 = new XYSeries("test");
	        XYSeriesCollection dataset2 = new XYSeriesCollection();
	        dataset2.addSeries(series2);
	        XYDataset datasetDataset2 = dataset2;
	        JFreeChart chart2 = createChart1(datasetDataset2,"步数");
	        ChartPanel chartPanel2= new ChartPanel(chart2);
	        chartPanel2.setBounds(430,300,420,300);
	        panel.add(chartPanel2);  
	        
	        
	        series3 = new XYSeries("test");
	        XYSeriesCollection dataset3 = new XYSeriesCollection();
	        dataset3.addSeries(series3);
	        XYDataset datasetDataset3 = dataset3;
	        JFreeChart chart3 = createChart1(datasetDataset3,"体温");
	        ChartPanel chartPanel3= new ChartPanel(chart3);
	        chartPanel3.setBounds(430,0,420,300);
	        panel.add(chartPanel3);  
	        
//	        series2 = new TimeSeries("", Millisecond.class);  
//	        TimeSeriesCollection dataset2 = new TimeSeriesCollection(series2);  
//	        ChartPanel chartPanel2 = new ChartPanel(createChart(dataset2,"步数"));  
//	        chartPanel2.setBounds(430,300,420,300);
//	        panel.add(chartPanel2);  
//	        
//	        series3 = new TimeSeries("", Millisecond.class);  
//	        TimeSeriesCollection dataset3 = new TimeSeriesCollection(series3);  
//	        ChartPanel chartPanel3 = new ChartPanel(createChart(dataset3,"体温"));  
//	        chartPanel3.setBounds(430,0,420,300);
//	        panel.add(chartPanel3);  
	        
	        
	        
	    }
	  private static JFreeChart createChart1(XYDataset dataset,String titlename ) {
	        JFreeChart chart = ChartFactory.createXYLineChart(
	            "实时"+titlename+"曲线图", 
	            "时间", 
	            titlename,
	            dataset, 
	            PlotOrientation.VERTICAL,
	            false,     // legend? no, we'll create our own
	            false,      // tooltips?
	            false      // URLs?
	        );
	        
	        XYPlot plot = (XYPlot) chart.getPlot();
	        NumberAxis axis1 = (NumberAxis) plot.getRangeAxis();
	        //删除小数点的显示
	        axis1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
	        axis1.setAutoRangeIncludesZero(false);
	        XYLineAndShapeRenderer renderer 
	                = (XYLineAndShapeRenderer) plot.getRenderer();
//	        renderer.setShapesVisible(true);
//	        renderer.setShapesFilled(true);
	        BlockContainer container = new BlockContainer(new BorderArrangement());
	        container.add(new EmptyBlock(100, 0));
	        CompositeTitle legends = new CompositeTitle(container);
	        legends.setPosition(RectangleEdge.BOTTOM);
	        chart.addSubtitle(legends);
	        return chart;
	    }
	  private static XYDataset createDataset1(XYSeries series) {

		    series = new XYSeries("test");
//		    series1.add(1.0, 181.8);
//		    series1.add(2.0, 167.3);
//		    series1.add(3.0, 153.8);
	        XYSeriesCollection dataset = new XYSeriesCollection();
	        dataset.addSeries(series);
	        return dataset;
	    }
	 
	   static int se1 =1;
	   static int se2 =1;
	   static int se3 =1;
	 
	    //添加数据进图表
		private static void getdatashow(String name, int data) {
			 if (data < heartdatalist.size()) {
	                if (name.equals(getname(heartdatalist.get(data))))
	                {
	                	//删除显示的数据，只保持有60条
	                	 if(series1.getItemCount() >60){
	                		 series1.remove(0);
	                	 }
	                	 new Thread(new Runnable() {
							
							@Override
							public void run() {
								series1.add(se1, getdata(heartdatalist.get(data))); 
								se1 ++;
								try {
									Thread.currentThread().sleep(100);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
							}
						}).start();
	                }
	            }
	            if (data < temperaturedatalist.size())
	            {
	                if (name.equals(getname(temperaturedatalist.get(data))))
	                {
	                	 if(series3.getItemCount() >60){
	                		 series3.remove(0);
	                	 }
	                	series3.add(se2, getdata(temperaturedatalist.get(data)));
	                	se2++;
	                	try {
	    					Thread.currentThread().sleep(100);
	    				} catch (InterruptedException e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				} 
	                	
	                }
	            }
	            if (data < stepdatalist.size())
	            {
	                if (name.equals(getname(stepdatalist.get(data))))
	                {
	                	 if(series2.getItemCount() >60){
	                		 series2.remove(0);
	                	 }
	                	series2.add(se3, getdata(stepdatalist.get(data))); 
	                	se3++;
	                	try {
	    					Thread.currentThread().sleep(100);
	    				} catch (InterruptedException e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				} 
	                
	                }
	            }
	            
		}
		
	public static String getname(String name) {
            int counts = name.indexOf(":");
            String tempname = name.substring(0, counts);
            return tempname;
        }
    public static int getdata(String name)
    {
        int counts = name.indexOf(":");
        String tempname = name.substring(counts+1);
        return Integer.parseInt(tempname);
    }
//	 //更新图标
//	 private static void refreshchart() {
//			// TODO Auto-generated method stub
//			
//		}
//	 /** 
//	     * 根据结果集构造JFreechart报表对象 
//	     *  
//	     * @param dataset 
//	     * @return 
//	     */  
//	    private static JFreeChart createChart(XYDataset dataset,String name ) {  
//	        JFreeChart result = ChartFactory.createTimeSeriesChart("实时"+name+"折线图", "时间",  
//	        		name, dataset, true, true, false);  
//	        XYPlot plot = (XYPlot) result.getPlot();  
//	        ValueAxis axis = plot.getDomainAxis();  
//	        axis.setAutoRange(true);  
//	        axis.setFixedAutoRange(60000.0);  
//	        axis = plot.getRangeAxis();  
////	        axis.setRange(0.0, 200.0);  
//	        return result;  
//	    }  

	@Override
	public void actionPerformed(ActionEvent e) {
//		 DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//	        Date date = new Date();  
//	        jlTime.setText(format.format(date)); 
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				byte[] bytes = new byte[1024];
		          DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
		      	try {
					server.receive(packet);
					 // 1.定义客户端的地址，端口号，数据
					
//		            String address = packet.getAddress().toString();
//		            int port = packet.getPort();
//		            System.out.println("ip "+address+"  port "+port);
					 for (int i = 0; i < 39; i++)
		             {
		                 System.out.print( bytes[i]+", ");
		             }
					 System.out.println("  ");
					 
					// 4.读取数据
				        byte[] buf = new byte[39];
				        System.arraycopy(bytes, 0, buf, 0, 39);
				        //buf = System.Text.Encoding.Default.GetBytes(message);
				        //判断心跳包与数据包

				        byte[] data = new byte[31];
				        if (buf[1] == 3)
				        {
				            //心跳包
				        }
				        else if (buf[1] == 1)
				        {
				            //获取到有用的数据包
				        	System.arraycopy(buf, 8, data, 0, 30);
				        }
				        
				        if (data[0] == 0x03 && data[1] == 0x08 && data[2] == 0x42 && data[3] == 0x32
			                    && data[4] == 0x1A && (data[5]& 0xff) == 0xFF)
			                {
			                    //设置固定UUID后的处理办法
			                    byte[] devicedata = new byte[8];
			                    System.arraycopy(data, 6, devicedata, 0, 8);
			                    //处理发送方ip地址
			                   
			                    String devicename =bytetoint16(devicedata[0])+ "," +
			                    		bytetoint16(devicedata[1])+ "," + bytetoint16(devicedata[2]) + "," +
			                    		bytetoint16(devicedata[3])+ "," + bytetoint16(devicedata[4]) + "," +
			                    		bytetoint16(devicedata[5])+ "," + bytetoint16(devicedata[6]) + "," +
			                    		bytetoint16(devicedata[7]);
			                    System.out.println("devicename : " + devicename);
			                    devicenameadd(devicename);//加入集合
			                    int heart = (data[16] & 0xff); //心率数据
			                    System.out.println("心率数据 : " + heart);
			                    deivceTest(devicename, heart);
			                    int step = (((int)(data[18] & 0xff) & 0x7f) << 10)
			                    | (((int)(data[19] & 0xff)) << 2) | ((data[20] & 0xff) >> 6); //运动步数
			                    System.out.println("运动步数 : " + step);
			                    deivceTest3(devicename, step);
			                    int temp = ((int)(data[23] & 0xff) & 0x7f) << 4 | ((data[24] & 0xff) >> 4); //环境温度，放大十倍 
			                    System.out.println("环境温度: " + temp/10);
			                    deivceTest5(devicename, temp/10);
			                     
			                }
			                else
			                {
			                    System.out.println("数据包不对: ");
			                }
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}).start();
		  
        
		
	}
	  //环境温度
	private void deivceTest5(String name, int i) {
		 temperaturedatalist.add(name + ":" + i);
	}
	 //运动步数
	private void deivceTest3(String name, int hea) {
		stepdatalist.add(name + ":" + hea);
	}
	//心率数据
	private void deivceTest(String name, int hear) {
		  heartdatalist.add(name+":"+ hear);
	}
	public String bytetoint16(byte by){
		 int xx = by & 0xff;
		return Integer.toHexString(xx);
	} 
	private void devicenameadd(String name) {
		 if (devicenamelist.size() == 0) {
             devicenamelist.add(name);
             adddatatolistview(name);
         }
         for (int i = 0; i < devicenamelist.size(); i++)
         {
             if (name.equals(devicenamelist.get(i)))
             {
                 return;
                 
             }else if (i == devicenamelist.size() - 1 )
             {
                 devicenamelist.add(name);
                 adddatatolistview(name);
             }
         }
	}
	//向Jlist中添加数据
	private void adddatatolistview(String name) {
		 if (namelist[0] == null) {
			 namelist[0] =name;
         }
         for (int i = 0; i < namelist.length; i++)
         {
             if (name.equals(namelist[i]))
             {
                 break;
                 
             }else if (i == namelist.length - 1 )
             {
            	 namelist[i] =name;
             }else if (namelist[i] == null){
            	 namelist[i] =name;
            	 break;
             }
         }
		ListModel jListModel =  new DefaultComboBoxModel(namelist);  //
		myJlist.setModel(jListModel);
	}  
}
