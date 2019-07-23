package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;

public class Matches extends JFrame {

	public JPanel contentPanel = new JPanel();
	public JButton botonok;
	private final JScrollPane scrollPane = new JScrollPane();
	public JTextArea textArea = new JTextArea();
	
	public Matches() {
		setSize(503, 302);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			contentPanel.add(scrollPane, BorderLayout.CENTER);
		}{
			textArea.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			textArea.setEditable(false);
			textArea.setLineWrap(true);
			scrollPane.setViewportView(textArea);
		}{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);{
				botonok = new JButton("OK");
				botonok.setBackground(new Color(192, 192, 192));
				buttonPane.add(botonok);
			}
		}
	}

}
