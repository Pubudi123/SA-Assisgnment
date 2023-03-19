package convertersubscriber;

import binarysubscriber.BinaryDisplayer;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ConverterMenu extends JFrame  {
	
	
	private JPanel jpanel;
	private JButton decimalBtn,binaryBtn,octalBtn,hexaBtn;
	private JLabel title; 
	private static boolean decimalBtnOnclick = false;
	private static boolean binaryBtnOnclick = false;
	private static boolean octalBtnOnclick = false;
	private static boolean hexaBtnOnclick = false;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterMenu frame = new ConverterMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ConverterMenu() {
		setResizable(false);
		setTitle("Converter");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(80, 50, 550, 470);
		setLocationRelativeTo(null);
		jpanel = new JPanel();
		jpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jpanel);
		jpanel.setLayout(null);
		jpanel.setVisible(true);

		title = new JLabel("Number Converter");
		title.setFont(new Font("Arial", Font.PLAIN, 28));
		title.setBounds(160, 25, 250, 30);
		jpanel.add(title);
		
		
		
		binaryBtn = new JButton("Binary Converter");
		binaryBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		binaryBtn.setFocusable(false);
		binaryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binaryBtnOnclick = Activator.BinaryChecker();
				if (binaryBtnOnclick == true) {
					BinaryDisplayer binaryDisplayer = new BinaryDisplayer();
					binaryDisplayer.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Binary Converter Service is not Started",
							"Error !", JOptionPane.OK_OPTION);
				}
			}
		});
		binaryBtn.setBounds(150, 165, 230, 60);
		binaryBtn.setBackground(Color.CYAN);
		jpanel.add(binaryBtn);


		

		
		
		
	}
	
	

}
