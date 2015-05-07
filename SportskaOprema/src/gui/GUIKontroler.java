package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import nabavka.Dobavljac;
import prodavnica.Kupac;
import prodavnica.Prodavnica;
import prodavnica.Proizvod;
import sistemskeoperacije.SODodajProizvod;

public class GUIKontroler extends JFrame {

	private JPanel contentPane;
	private static Prodavnica prodavnica = new Prodavnica();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIKontroler frame = new GUIKontroler();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIKontroler() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}
	
	public static Proizvod pronadjiProizvod(String naziv) {
		return prodavnica.pronadjiProizvod(naziv);
	}
	
	public static Kupac pronadjiKupca(String ime) {
		return prodavnica.prondadjiKupca(ime);
	}
	
	public static Dobavljac pronadjiDobavljaca (String ime) {
		return prodavnica.pronadjiDobavljaca(ime);
	}

	public static void dodajProizvod(String Id, String naziv,
			double cena, int kolicina) {
		// kad bude formiran glavni prozor treba napraviti da iskace poruka da je pogresno uneta neka vrednost
			try {
				Proizvod p=new Proizvod();
				p.setId(Id);
				p.setKolicina(kolicina);
				p.setCena(cena);
				p.setNaziv(naziv);
				prodavnica.dodajProizvod(p);
			} catch (Exception e) {
				
			}
		
		
	}
	public static LinkedList<Proizvod> prikaziProizvode(){
		return  prodavnica.prikaziSveProizvode();
	}

	public static void izbrisiProizvod(Proizvod p) {
		prodavnica.izbrisiProizvod(p);
		
	}

}
