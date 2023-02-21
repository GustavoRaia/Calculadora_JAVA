package calculadora;

// Imports --------------------------------------
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
    // Definindo labels e botões ----------------
    private double valor1, memoria;
    private String operador;

    private final JTextField txt_valor1, txt_visor, txt_memoria;

    private final JButton btn_MC, btn_MR, btn_mMais, btn_mMenos, btn_desliga;
    private final JButton btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    private final JButton btn_ponto, btn_soma, btn_subtrai, btn_multiplica, btn_divide, btn_igual;
    private final JButton btn_quadrado, btn_raizQuadrada, btn_umSobreValor, btn_inverteSinal, btn_porcentagem;
    private final JButton btn_clear, btn_clearEntry, btn_apaga;

    private final JTextArea txt_historico;
    private final JButton btn_apaga_historico;

    // Criando e posicionando botões ------------
    public Calculadora() {
        // Janela -------------------------------
        super.getContentPane().setLayout(null);
        super.getContentPane().setBackground(new Color(64, 66, 85));
        super.setSize(670, 500);
        super.setTitle("Calculadora JAVA");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocation(500, 300);

        // Valor 1 Label ------------------------
        JLabel lbl_valor1 = new JLabel("VALOR 1");
        lbl_valor1.setBounds(85, 8, 320, 25);
        lbl_valor1.setForeground(new Color(0, 0, 0));
        lbl_valor1.setFont(new Font("Monospaced", Font.BOLD, 14));
        super.getContentPane().add(lbl_valor1);

        // Valor 1 ------------------------------
        txt_valor1 = new JTextField(15);
        txt_valor1.setBounds(150, 10, 145, 20);
        txt_valor1.setBackground(new Color(62, 100, 62));
        txt_valor1.setForeground(new Color(0, 0, 0));
        txt_valor1.setFont(new Font("Monospaced", Font.BOLD, 14));
        txt_valor1.setHorizontalAlignment(SwingConstants.RIGHT);
        super.getContentPane().add(txt_valor1);

        // Visor --------------------------------
        txt_visor = new JTextField(15);
        txt_visor.setBounds(20, 40, 275, 35);
        txt_visor.setBackground(new Color(62, 100, 62));
        txt_visor.setForeground(new Color(0, 0, 0));
        txt_visor.setFont(new Font("Monospaced", Font.BOLD, 20));
        txt_visor.setHorizontalAlignment(SwingConstants.RIGHT);
        super.getContentPane().add(txt_visor);

        // Histórico Label ----------------------
        JLabel lbl_historico = new JLabel("Histórico");
        lbl_historico.setBounds(515, 8, 320, 25);
        lbl_historico.setForeground(new Color(255, 255, 255));
        lbl_historico.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        super.getContentPane().add(lbl_historico);

        // Histórico ----------------------------
        txt_historico = new JTextArea();
        txt_historico.setBackground(new Color(255, 255, 255));
        txt_historico.setForeground(new Color(0, 0, 0));
        txt_historico.setFont(new Font("Arial", Font.BOLD, 19));
        txt_historico.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        txt_historico.setLineWrap(true);
        super.getContentPane().add(txt_historico);

        // Scroll Histórico ---------------------
        JScrollPane scroll_historico = new JScrollPane(txt_historico);
        scroll_historico.setBounds(325,40,305,385);
        scroll_historico.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll_historico.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        super.getContentPane().add(scroll_historico);

        // Btn Apaga Histórico ------------------
        btn_apaga_historico = new JButton("Limpar Histórico");
        btn_apaga_historico.setBounds(500,430,120,20);
        btn_apaga_historico.setFont(new Font("Arial", Font.BOLD, 10));
        super.getContentPane().add(btn_apaga_historico);

        // Memória ------------------------------
        txt_memoria = new JTextField();
        txt_memoria.setBounds(20,12,24,20);
        txt_memoria.setBackground(new Color(62,100,62));
        scroll_historico.setBorder(BorderFactory.createLineBorder(new Color(62, 100, 62)));
        txt_memoria.setForeground(new Color(0, 0, 0));
        txt_memoria.setFont(new Font("Monospaced", Font.BOLD, 12));
        super.getContentPane().add(txt_memoria);

        // LINHA 0 ------------------------------

        btn_MC = new JButton("MC");
        btn_MC.setBounds(20, 100, 50, 50);
        btn_MC.setFont(new Font("Monospaced", Font.BOLD, 14));
        super.getContentPane().add(btn_MC);

        btn_MR = new JButton("MR");
        btn_MR.setBounds(75, 100, 51, 50);
        btn_MR.setFont(new Font("Monospaced", Font.BOLD, 14));
        super.getContentPane().add(btn_MR);

        btn_mMais = new JButton("M+");
        btn_mMais.setBounds(131, 100, 50, 50);
        btn_mMais.setFont(new Font("Monospaced", Font.BOLD, 14));
        super.getContentPane().add(btn_mMais);

        btn_mMenos = new JButton("M-");
        btn_mMenos.setBounds(186, 100, 52, 50);
        btn_mMenos.setFont(new Font("Monospaced", Font.BOLD, 14));
        super.getContentPane().add(btn_mMenos);

        btn_desliga = new JButton("OFF");
        btn_desliga.setBounds(243, 100, 52, 50);
        btn_desliga.setBackground(new Color(208, 57, 74));
        btn_desliga.setFont(new Font("Monospaced", Font.BOLD, 10));
        super.getContentPane().add(btn_desliga);

        // LINHA 1 ------------------------------

        btn_porcentagem = new JButton("%");
        btn_porcentagem.setBounds(20, 160, 65, 40);
        super.getContentPane().add(btn_porcentagem);

        btn_clearEntry = new JButton("CE");
        btn_clearEntry.setBounds(90, 160, 65, 40);
        super.getContentPane().add(btn_clearEntry);

        btn_clear = new JButton("C");
        btn_clear.setBounds(160, 160, 65, 40);
        super.getContentPane().add(btn_clear);

        btn_apaga = new JButton("⌫");
        btn_apaga.setBounds(230, 160, 65, 40);
        super.getContentPane().add(btn_apaga);

        // LINHA 2 ------------------------------

        btn_umSobreValor = new JButton("1/x");
        btn_umSobreValor.setBounds(20, 205, 65, 40);
        super.getContentPane().add(btn_umSobreValor);

        btn_quadrado = new JButton("x²");
        btn_quadrado.setBounds(90, 205, 65, 40);
        super.getContentPane().add(btn_quadrado);

        btn_raizQuadrada = new JButton("√x");
        btn_raizQuadrada.setBounds(160, 205, 65, 40);
        super.getContentPane().add(btn_raizQuadrada);

        btn_divide = new JButton("÷");
        btn_divide.setBounds(230, 205, 65, 40);
        super.getContentPane().add(btn_divide);

        // LINHA 3 ------------------------------

        btn_7 = new JButton("7");
        btn_7.setBounds(20, 250, 65, 40);
        super.getContentPane().add(btn_7);

        btn_8 = new JButton("8");
        btn_8.setBounds(90, 250, 65, 40);
        super.getContentPane().add(btn_8);

        btn_9 = new JButton("9");
        btn_9.setBounds(160, 250, 65, 40);
        super.getContentPane().add(btn_9);

        btn_multiplica = new JButton("*");
        btn_multiplica.setBounds(230, 250, 65, 40);
        super.getContentPane().add(btn_multiplica);

        // LINHA 4 ------------------------------

        btn_4 = new JButton("4");
        btn_4.setBounds(20, 295, 65, 40);
        super.getContentPane().add(btn_4);

        btn_5 = new JButton("5");
        btn_5.setBounds(90, 295, 65, 40);
        super.getContentPane().add(btn_5);

        btn_6 = new JButton("6");
        btn_6.setBounds(160, 295, 65, 40);
        super.getContentPane().add(btn_6);

        btn_subtrai = new JButton("-");
        btn_subtrai.setBounds(230, 295, 65, 40);
        super.getContentPane().add(btn_subtrai);

        // LINHA 5 ------------------------------

        btn_1 = new JButton("1");
        btn_1.setBounds(20, 340, 65, 40);
        super.getContentPane().add(btn_1);

        btn_2 = new JButton("2");
        btn_2.setBounds(90, 340, 65, 40);
        super.getContentPane().add(btn_2);

        btn_3 = new JButton("3");
        btn_3.setBounds(160, 340, 65, 40);
        super.getContentPane().add(btn_3);

        btn_soma = new JButton("+");
        btn_soma.setBounds(230, 340, 65, 40);
        super.getContentPane().add(btn_soma);

        // LINHA 6 ------------------------------

        btn_inverteSinal = new JButton("+/-");
        btn_inverteSinal.setBounds(20, 385, 65, 40);
        super.getContentPane().add(btn_inverteSinal);

        btn_0 = new JButton("0");
        btn_0.setBounds(90, 385, 65, 40);
        super.getContentPane().add(btn_0);

        btn_ponto = new JButton(",");
        btn_ponto.setBounds(160, 385, 65, 40);
        super.getContentPane().add(btn_ponto);

        btn_igual = new JButton("=");
        btn_igual.setBounds(230, 385, 65, 40);
        btn_igual.setBackground(new Color(73, 160, 213));
        super.getContentPane().add(btn_igual);

        this.eventosBtnNumeros();
        this.eventosBtnOperador();
        this.eventosBtnExtra();
        this.eventosBtnMemoria();
    }

    // Funções de botão -------------------------
    private ActionListener btnNum(String num) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txt_visor.getText().equals("0"))
                    txt_visor.setText(num);
                else
                    txt_visor.setText(txt_visor.getText() + num);
            }
        };
    }
    private void eventosBtnNumeros(){ // Adiciona o número selecionado no visor.
        btn_0.addActionListener(btnNum("0"));
        btn_1.addActionListener(btnNum("1"));
        btn_2.addActionListener(btnNum("2"));
        btn_3.addActionListener(btnNum("3"));
        btn_4.addActionListener(btnNum("4"));
        btn_5.addActionListener(btnNum("5"));
        btn_6.addActionListener(btnNum("6"));
        btn_7.addActionListener(btnNum("7"));
        btn_8.addActionListener(btnNum("8"));
        btn_9.addActionListener(btnNum("9"));
    }
    private ActionListener btnOp(String op){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txt_visor.getText().equals("")){
                    msgErroVisor();
                } else{
                    valor1 = Double.parseDouble(txt_visor.getText().replace(",", "."));
                    txt_valor1.setText(String.valueOf(valor1).replace(".", ","));
                    txt_visor.setText("");
                    operador = op;
                }
            }
        };
    }

    private void eventosBtnOperador(){
        btn_soma.addActionListener(btnOp("+"));
        btn_subtrai.addActionListener(btnOp("-"));
        btn_multiplica.addActionListener(btnOp("*"));
        btn_divide.addActionListener(btnOp("/"));
        btn_porcentagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txt_visor.getText().equals(""))
                    msgErroVisor();
                else{
                    double num = Double.parseDouble(txt_visor.getText().replace(",", "."));
                    txt_visor.setText(String.valueOf(valor1*num/100).replace(".", ","));
                }
            }
        });

        btn_quadrado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txt_visor.getText().equals(""))
                    msgErroVisor();
                else{
                    double num = Double.parseDouble(txt_visor.getText().replace(",", "."));
                    txt_visor.setText(String.valueOf(num*num).replace(".", ","));

                    if (txt_historico.getText().equals("")) { // Verifica se o visor está vazio.
                        txt_historico.setText(verificaInt(num*num) + " = " + verificaInt(num) + "²\n\n");
                    } else {
                        txt_historico.setText(txt_historico.getText() + verificaInt(num*num)
                                + " = " + verificaInt(num) + "²\n\n");
                    }
                }
            }
        });
        btn_raizQuadrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txt_visor.getText().equals(""))
                    msgErroVisor();
                else{
                    double num = Double.parseDouble(txt_visor.getText().replace(",", "."));
                    txt_visor.setText(String.valueOf(Math.sqrt(num)).replace(".", ","));

                    if (txt_historico.getText().equals("")) { // Verifica se o visor está vazio.
                        txt_historico.setText(verificaInt(Math.sqrt(num)) + " = " + verificaInt(num) + "√\n\n");
                    } else {
                        txt_historico.setText(txt_historico.getText() + verificaInt(Math.sqrt(num))
                                + " = " + verificaInt(num) + "√\n\n");
                    }
                }
            }
        });

        btn_igual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txt_visor.getText().equals("")){
                    msgErroVisor();
                } else{
                    double valor2 = Double.parseDouble(txt_visor.getText().replace(",", "."));
                    double result;

                    switch (operador) {
                        case "+" -> {
                            result = valor1 + valor2;
                            txt_visor.setText(String.valueOf(result).replace(".", ","));

                            verificaVisor(" + ", valor2, result);
                        }
                        case "-" -> {
                            result = valor1 - valor2;
                            txt_visor.setText(String.valueOf(result).replace(".", ","));

                            verificaVisor(" - ", valor2, result);
                        }
                        case "*" -> {
                            result = valor1 * valor2;
                            txt_visor.setText(String.valueOf(result).replace(".", ","));

                            verificaVisor(" * ", valor2, result);
                        }
                        case "/" -> {
                            if (valor2 == 0) {
                                JOptionPane.showMessageDialog(null, "Não pode dividir por zero!");
                            } else {
                                result = valor1 / valor2;
                                txt_visor.setText(String.valueOf(result).replace(".", ","));

                                verificaVisor(" / ", valor2, result);
                            }
                        }
                    }
                }
            }
        });
    }

    private void eventosBtnExtra(){
        btn_inverteSinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(txt_visor.getText().equals(""))
                    msgErroVisor();
                else{
                    double num = Double.parseDouble(txt_visor.getText().replace(",", "."));
                    txt_visor.setText(String.valueOf(num*-1).replace(".", ","));


                }
            }
        });
        btn_umSobreValor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txt_visor.getText().equals(""))
                    msgErroVisor();
                else{
                    double num = Double.parseDouble(txt_visor.getText().replace(",", "."));
                    txt_visor.setText(String.valueOf(1/num).replace(".", ","));
                }
            }
        });
        btn_clearEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_visor.setText("");
            }
        });
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor1 = 0;
                txt_valor1.setText("");
                txt_visor.setText("");
            }
        });
        btn_apaga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txt_visor.getText().equals(""))
                    txt_visor.setText("");
                else
                    txt_visor.setText(txt_visor.getText().substring(0, txt_visor.getText().length() -1).replace(".", ","));
            }
        });
        btn_ponto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contaVirgulaVisor(txt_visor.getText()) < 1)
                    if(txt_visor.getText().equals("")){
                        txt_visor.setText("0");
                        txt_visor.setText(txt_visor.getText() + ",");
                    } else
                        txt_visor.setText(txt_visor.getText() + ",");
                else
                    txt_visor.setText(txt_visor.getText() + "");
            }
        });
        btn_apaga_historico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_historico.setText("");
            }
        });
        btn_desliga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Fechando Calculadora.");
                dispose();
            }
        });
    }

    private void eventosBtnMemoria(){
        memoria = 0;

        btn_MC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_memoria.setText("");
                memoria = 0;
            }
        });
        btn_MR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_visor.setText(String.valueOf(memoria).replace(".", ","));
            }
        });
        btn_mMais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txt_visor.getText().equals("")){
                    msgErroVisor();
                } else{
                    memoria = memoria + Double.parseDouble(txt_visor.getText().replace(",","."));
                    txt_memoria.setText(" M");
                }
            }
        });
        btn_mMenos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txt_visor.getText().equals("")){
                    msgErroVisor();
                } else{
                    memoria = memoria - Double.parseDouble(txt_visor.getText().replace(",","."));
                    txt_memoria.setText(" M");
                }
            }
        });
    }

    // Funções extra ----------------------------
    private static int contaVirgulaVisor(String texto){ // Auxiliar no uso da virgula no visor.
        int contador = 0;

        for (int i = 0; i < texto.length(); i++){
            char c = texto.charAt(i);
            if (c == ',')
                contador++;
        }
        return contador;
    }
    private void msgErroVisor(){ // Imprime mensagem de erro.
        JOptionPane.showMessageDialog(null, "Insira um valor no visor!");
    }

    private String verificaInt(double num){ // Função que verifica int para imprimir no histórico.
        double result = (num - Math.floor(num));
        if(result>0){ // Caso seja inteiro.
            return String.valueOf(num).replace(".",",");
        }
        else{ // Caso seja inteiro.
            return String.valueOf((int)num);
        }
    }

    private void verificaVisor(String operacao, double valor2, double result){ // Auxilia na impressão no visor das 4 operações básicas.
        if (txt_historico.getText().equals("")) { // Verifica se o visor está vazio.
            txt_historico.setText(verificaInt(valor2) + operacao + verificaInt(valor1)
                    + "\n" + verificaInt(result) + " = " + "\n\n");
        } else {
            txt_historico.setText(txt_historico.getText() + verificaInt(valor2) +
                    operacao + verificaInt(valor1) + "\n" + verificaInt(result) + " = " + "\n\n");
        }
    }

} // Fim da Classe Calculadora