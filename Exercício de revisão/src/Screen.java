import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Screen extends JFrame{
	ArvoreBinaria arvore;
	private static final long serialVersionUID = 1L;
	public Screen(ArvoreBinaria arvore) {
		this.arvore = arvore;
		inicial();
		
	}
	
	public void inicial() {
		setVisible(true);
		setSize(1000, 600);
		setTitle("Exercício de revisão de programação");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		JButton botao1 = new JButton("Dada uma habilidade, quem seria o melhor candidato?");
		JButton botao2 = new JButton("Dadas uma habilidade obrigatória e uma importante, quem seria o melhor candidato?");
		JButton botao3 = new JButton("Considerando o conjunto de habilidades, quem seria mais interessante para uma vaga?");
		botao1.setBounds(200, 50, 600, 70);
		botao2.setBounds(200, 200, 600, 70);
		botao3.setBounds(200, 350, 600, 70);

		add(botao1);
		add(botao2);
		add(botao3);
		botao1.addActionListener(this::primeiro);
		botao2.addActionListener(this::segundo);
		botao3.addActionListener(this::terceiro);
	}

	
	public void primeiro(ActionEvent e) {
		//JOptionPane.showMessageDialog(null, "teste1");
		setVisible(false);
		JFrame novaJanela = new JFrame();
		novaJanela.setVisible(true);
		novaJanela.setSize(1000, 600);
		novaJanela.setTitle("Dada uma habilidade, quem seria o melhor candidato");
		novaJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		novaJanela.setResizable(false);
        novaJanela.setLocationRelativeTo(null);
        novaJanela.setLayout(null);
		JLabel texto = new JLabel("Dada uma habilidade, quem seria o melhor candidato");
		texto.setFont(new Font("arial", Font.BOLD, 20));
		texto.setBounds(240, 50, 600, 70);
		novaJanela.add(texto);
		
		String[] optionsToChoose = Habilidades.habilidades;
		JComboBox<String> opcoes = new JComboBox<>(optionsToChoose);
        opcoes.setBounds(240, 150, 300, 40);

        JButton done = new JButton("Done");
        done.setBounds(590, 150, 100, 40);
        
        JButton voltar = new JButton("Return");
        voltar.setBounds(20, 20, 80, 50);
        
        
        JLabel resultado = new JLabel();
        resultado.setBounds(240, 350, 450, 40);

        novaJanela.add(done);
        novaJanela.add(opcoes);
        novaJanela.add(voltar);
        novaJanela.add(resultado);
        
        voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setVisible(true);
            	novaJanela.setVisible(false);
            }
        });
        
        done.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	resultado.setBackground(Color.lightGray);
            	resultado.setOpaque(true);
            	int j =0;
            	String result[] = arvore.umaHabilidade(opcoes.getItemAt(opcoes.getSelectedIndex()));
            	String textoResultado= "O melhor candidato é: ";
            	textoResultado += result[j];
            	j++;
            	while(result[j] != null) {
            		textoResultado += ", ";
            		textoResultado += result[j];
            		j++;
            	}
        		resultado.setText(textoResultado);
            }
        });

		
	}
	public void segundo(ActionEvent e) {
		//JOptionPane.showMessageDialog(null, "teste2");
		setVisible(false);
		JFrame novaJanela = new JFrame();
		novaJanela.setVisible(true);
		novaJanela.setSize(1000, 600);
		novaJanela.setTitle("Dadas uma habilidade obrigatória e uma importante, quem seria o melhor candidato?");
		novaJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		novaJanela.setResizable(false);
        novaJanela.setLocationRelativeTo(null);
        novaJanela.setLayout(null);
		JLabel texto = new JLabel("Dadas uma habilidade obrigatória e uma importante, quem seria o melhor candidato?");
		texto.setFont(new Font("arial", Font.BOLD, 15));
		texto.setBounds(200, 50, 700, 120);
		novaJanela.add(texto);
		
		JLabel textoObrigatorio = new JLabel("Obrigatorio");
		textoObrigatorio.setBounds(240, 120, 200, 40);
		String[] optionsToChooseObrigatorio = Habilidades.habilidades;
		JComboBox<String> opcoesObrigatorio = new JComboBox<>(optionsToChooseObrigatorio);
		opcoesObrigatorio.setBounds(240, 150, 200, 40);
		
		JLabel textoImportante = new JLabel("Importante");
		textoImportante.setBounds(480, 120, 200, 40);
        String[] optionsToChooseImportante = Habilidades.habilidades;
		JComboBox<String> opcoesImportante = new JComboBox<>(optionsToChooseImportante);
		opcoesImportante.setBounds(480, 150, 200, 40);
		
		JButton done = new JButton("Done");
        done.setBounds(400, 230, 100, 40);
        
        JButton voltar = new JButton("Return");
        voltar.setBounds(20, 20, 80, 50);
		
        JLabel resultado = new JLabel();
        resultado.setBounds(240, 350, 450, 40);
        
		novaJanela.add(opcoesObrigatorio);
		novaJanela.add(textoObrigatorio);
		novaJanela.add(opcoesImportante);
		novaJanela.add(textoImportante);
		novaJanela.add(done);
		novaJanela.add(voltar);
		novaJanela.add(resultado);
        
        voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setVisible(true);
            	novaJanela.setVisible(false);
            }
        });
		
		done.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	resultado.setBackground(Color.lightGray);
            	resultado.setOpaque(true);
            	int j =0;
            	String result[] = arvore.umaObrigUmaImp(opcoesObrigatorio.getItemAt(opcoesObrigatorio.getSelectedIndex()), opcoesImportante.getItemAt(opcoesImportante.getSelectedIndex()) );
            	String textoResultado= "O melhor candidato é: ";
            	textoResultado += result[j];
            	j++;
            	while(result[j] != null) {
            		textoResultado += ", ";
            		textoResultado += result[j];
            		j++;
            	}
        		resultado.setText(textoResultado);

            }
        });
		
	}
	public void terceiro(ActionEvent e) {
		//JOptionPane.showMessageDialog(null, "teste3");
		setVisible(false);
		JFrame novaJanela = new JFrame();
		novaJanela.setVisible(true);
		novaJanela.setSize(1000, 600);
		novaJanela.setTitle("Considerando o conjunto de habilidades, quem seria mais interessante para uma vaga?");
		novaJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		novaJanela.setResizable(false);
        novaJanela.setLocationRelativeTo(null);
        novaJanela.setLayout(null);
		JLabel texto = new JLabel("Considerando o conjunto de habilidades, quem seria mais interessante para uma vaga?");
		texto.setFont(new Font("arial", Font.BOLD, 15));
		texto.setBounds(180, 50, 700, 120);
		novaJanela.add(texto);
		
		JButton voltar = new JButton("Return");
	    voltar.setBounds(20, 20, 80, 50);
	    
	    JLabel resultado = new JLabel();
        resultado.setBounds(240, 200, 450, 40);
        
		
		novaJanela.add(voltar);
		novaJanela.add(resultado);
		
		resultado.setBackground(Color.lightGray);
    	resultado.setOpaque(true);
    	String result[] = arvore.conjuntohabili();
    	int j =0;
    	
    	String textoResultado= "O melhor candidato é: ";
    	textoResultado += result[j];
    	j++;
    	while(result[j] != null) {
    		textoResultado += ", ";
    		textoResultado += result[j];
    		j++;
    	}
		resultado.setText(textoResultado);
		
		voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setVisible(true);
            	novaJanela.setVisible(false);
            }
        });
		
	}
	
	
	
	
}
