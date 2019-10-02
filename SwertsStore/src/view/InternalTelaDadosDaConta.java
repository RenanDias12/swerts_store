package view;

import DAO.UsuarioDAO;
import model.Usuario;
import java.awt.Color;
import java.awt.Cursor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class InternalTelaDadosDaConta extends javax.swing.JInternalFrame {

    Usuario usuarioOnline = new Usuario(); // Instanciando usuario para guardar o usuario online e utilizar nesta classe
    TelaPrincipal telaPrincipalThis;

    public InternalTelaDadosDaConta(Usuario usuario, TelaPrincipal telaPrincipalThis) {
        initComponents();

        this.telaPrincipalThis = telaPrincipalThis;

        // Pegando as informaçoes iniciais do usuario
        usuarioOnline = usuario;
        textoEmail.setText(usuarioOnline.getEmail());
        textoSenha.setText(usuarioOnline.getSenha());
        textoNome.setText(usuarioOnline.getNome());
        textoSobrenome.setText(usuarioOnline.getSobrenome());
        textoCpf.setText(usuarioOnline.getCpf());
        boxSexo.setSelectedItem(usuarioOnline.getSexo());
        textoDataNascimento.setText(usuarioOnline.getDataDeNascimento());
        textoTelefone.setText(usuarioOnline.getTelefone());
        textoRua.setText(usuarioOnline.getRua());
        textoBairro.setText(usuarioOnline.getBairro());
        textoCep.setText(usuarioOnline.getCep());
        textoNumero.setText(String.valueOf(usuarioOnline.getNumero()));
        textoComplemento.setText(usuarioOnline.getComplemento());
        textoCidade.setText(usuarioOnline.getCidade());
        textoEstado.setText(usuarioOnline.getEstado());
    }

    public boolean isDateValid(String strDate) {
        String dateFormat = "dd/MM/uuuu";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern(dateFormat)
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
            return true;

        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean verificaDadosInseridos() {
        // Verificando se todos os campos foram preenchidos de forma adqueada
        if (textoNome.getText().equals("") || textoNome.getText().equals("Ex: João")
                || textoSobrenome.getText().equals("") || textoSobrenome.getText().equals("Ex: Silva")
                || textoCpf.getText().equals("") || textoCpf.getText().equals("")
                || boxSexo.getSelectedItem().equals("Selecione")
                || textoDataNascimento.getText().equals("") || textoDataNascimento.getText().equals("")
                || textoTelefone.getText().equals("") || textoTelefone.getText().equals("")
                || textoEmail.getText().equals("") || textoEmail.getText().equals("Ex: renzo@gmail.com")
                || textoSenha.getText().equals("") || textoSenha.getText().equals("DigiteUmaSenha")
                || textoRua.getText().equals("") || textoRua.getText().equals("Ex: Rua São Benedito")
                || textoBairro.getText().equals("") || textoBairro.getText().equals("")
                || textoCep.getText().equals("") || textoCep.getText().equals("")
                || textoCidade.getText().equals("") || textoCidade.getText().equals("")
                || textoEstado.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos de forma válida!", "Swerts Store", 0);
            return false;
        } // Se o email digitado nao for "valido"
        else if (textoEmail.getText().contains("@") == false || textoEmail.getText().contains(".") == false) {
            JOptionPane.showMessageDialog(null, "Email inválido!", "Swerts Store", 0);
            return false;
        } else if (!textoNome.getText().matches("[A-Z a-z Çç]{" + textoNome.getText().length() + "}")
                || textoNome.getText().matches(".")) {
            JOptionPane.showMessageDialog(null, "Nome inválido!", "Swerts Store", 0);
            return false;

        } else if (!textoSobrenome.getText().toString().matches("[A-Z a-z Çç]{" + textoSobrenome.getText().toString().length()
                + "}") || textoSobrenome.getText().toString().matches(".")) {
            JOptionPane.showMessageDialog(null, "Sobrenome inválido!", "Swerts Store", 0);
            return false;

        } else if (textoNumero.getText().toString().matches("[A-Z a-z Çç]{" + textoNumero.getText().toString().length() + "}")) {
            JOptionPane.showMessageDialog(null, "Número inválido!", "Swerts Store", 0);
            return false;

        } else if (textoCpf.getText().equals("000.000.000-00") || textoCpf.getText().equals("111.111.111-11") || textoCpf.getText().equals("222.222.222.22") || textoCpf.getText().equals("333.333.333-33")
                || textoCpf.getText().equals("444.444.444-44") || textoCpf.getText().equals("555.555.555-55") || textoCpf.getText().equals("666.666.666-66") || textoCpf.getText().equals("777.777.777-77")
                || textoCpf.getText().equals("888.888.888-88") || textoCpf.getText().equals("999.999.999-99")) {
            JOptionPane.showMessageDialog(null, "CPF inválido!", "Swerts Store", 0);
            return false;
        } else if (textoTelefone.getText().equals("(11) 11111-1111") || textoTelefone.getText().equals("(22) 22222-2222") || textoTelefone.getText().equals("(33) 33333-3333") || textoTelefone.getText().equals("(44) 44444-4444")
                || textoTelefone.getText().equals("(55) 55555-5555") || textoTelefone.getText().equals("(66) 66666-6666") || textoTelefone.getText().equals("(77) 77777-7777") || textoTelefone.getText().equals("(88) 88888-8888")
                || textoTelefone.getText().equals("(99) 99999-9999") || textoTelefone.getText().equals("(00) 00000-0000")) {
            JOptionPane.showMessageDialog(null, "Telefone inválido!", "Swerts Store", 0);
            return false;

        } else if (!isDateValid(textoDataNascimento.getText().toString())) {
            JOptionPane.showMessageDialog(null, "Data inválida!", "Swerts Store", 0);
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTelaDadosDaConta = new javax.swing.JPanel();
        painelDadosConta = new javax.swing.JPanel();
        editarInfosConta = new javax.swing.JLabel();
        labelDadosConta = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        textoSenha = new javax.swing.JPasswordField();
        labelSenha = new javax.swing.JLabel();
        textoEmail = new javax.swing.JTextField();
        labelMostrarSenha = new javax.swing.JLabel();
        painelDadosPessoais = new javax.swing.JPanel();
        editarInfosPessoal = new javax.swing.JLabel();
        labelDadosPessoais = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        textoNome = new javax.swing.JTextField();
        labelSobrenome = new javax.swing.JLabel();
        textoSobrenome = new javax.swing.JTextField();
        textoCpf = new javax.swing.JFormattedTextField();
        labelCpf = new javax.swing.JLabel();
        labelSexo = new javax.swing.JLabel();
        boxSexo = new javax.swing.JComboBox<>();
        labelDataNascimento = new javax.swing.JLabel();
        textoDataNascimento = new javax.swing.JFormattedTextField();
        labelTelefone = new javax.swing.JLabel();
        textoTelefone = new javax.swing.JFormattedTextField();
        painelDadosEndereco = new javax.swing.JPanel();
        editarInfosEndereco = new javax.swing.JLabel();
        labelDadosEndereco = new javax.swing.JLabel();
        labelRua = new javax.swing.JLabel();
        textoRua = new javax.swing.JTextField();
        labelCep = new javax.swing.JLabel();
        textoCep = new javax.swing.JFormattedTextField();
        labelBairro = new javax.swing.JLabel();
        textoBairro = new javax.swing.JTextField();
        labelCidade = new javax.swing.JLabel();
        textoCidade = new javax.swing.JTextField();
        textoEstado = new javax.swing.JTextField();
        labelEstado = new javax.swing.JLabel();
        textoNumero = new javax.swing.JTextField();
        labelNumero = new javax.swing.JLabel();
        labelComplemento = new javax.swing.JLabel();
        textoComplemento = new javax.swing.JTextField();
        salvarAlteracoes = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setEnabled(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        painelTelaDadosDaConta.setBackground(new java.awt.Color(255, 255, 255));
        painelTelaDadosDaConta.setPreferredSize(new java.awt.Dimension(1346, 650));
        painelTelaDadosDaConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelTelaDadosDaContaMouseClicked(evt);
            }
        });

        painelDadosConta.setBackground(new java.awt.Color(232, 232, 232));

        editarInfosConta.setBackground(new java.awt.Color(0, 0, 238));
        editarInfosConta.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        editarInfosConta.setForeground(new java.awt.Color(255, 255, 255));
        editarInfosConta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarInfosConta.setText("Editar ");
        editarInfosConta.setOpaque(true);
        editarInfosConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarInfosContaMouseClicked(evt);
            }
        });

        labelDadosConta.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        labelDadosConta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDadosConta.setText("Dados da Conta");

        labelEmail.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelEmail.setText("E-mail:");

        textoSenha.setEditable(false);
        textoSenha.setBackground(new java.awt.Color(255, 255, 255));
        textoSenha.setForeground(new java.awt.Color(153, 153, 153));
        textoSenha.setText("DigiteUmaSenha");
        textoSenha.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoSenha.setEchoChar('\u2022');

        labelSenha.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelSenha.setText("Senha:");

        textoEmail.setEditable(false);
        textoEmail.setBackground(new java.awt.Color(255, 255, 255));
        textoEmail.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoEmail.setForeground(new java.awt.Color(153, 153, 153));
        textoEmail.setMargin(new java.awt.Insets(2, 10, 2, 2));

        labelMostrarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/showPassword.png"))); // NOI18N
        labelMostrarSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMostrarSenhaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelDadosContaLayout = new javax.swing.GroupLayout(painelDadosConta);
        painelDadosConta.setLayout(painelDadosContaLayout);
        painelDadosContaLayout.setHorizontalGroup(
            painelDadosContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosContaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDadosConta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosContaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(editarInfosConta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(painelDadosContaLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(painelDadosContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelEmail)
                    .addComponent(labelSenha)
                    .addComponent(textoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelMostrarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        painelDadosContaLayout.setVerticalGroup(
            painelDadosContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosContaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDadosConta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(labelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(labelSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelMostrarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(editarInfosConta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelDadosPessoais.setBackground(new java.awt.Color(232, 232, 232));

        editarInfosPessoal.setBackground(new java.awt.Color(0, 0, 238));
        editarInfosPessoal.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        editarInfosPessoal.setForeground(new java.awt.Color(255, 255, 255));
        editarInfosPessoal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarInfosPessoal.setText("Editar");
        editarInfosPessoal.setOpaque(true);
        editarInfosPessoal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarInfosPessoalMouseClicked(evt);
            }
        });

        labelDadosPessoais.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        labelDadosPessoais.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDadosPessoais.setText("Dados Pessoais");

        labelNome.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelNome.setText("Nome:");

        textoNome.setEditable(false);
        textoNome.setBackground(new java.awt.Color(255, 255, 255));
        textoNome.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoNome.setForeground(new java.awt.Color(153, 153, 153));
        textoNome.setMargin(new java.awt.Insets(2, 10, 2, 2));

        labelSobrenome.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelSobrenome.setText("Sobrenome:");

        textoSobrenome.setEditable(false);
        textoSobrenome.setBackground(new java.awt.Color(255, 255, 255));
        textoSobrenome.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoSobrenome.setForeground(new java.awt.Color(153, 153, 153));
        textoSobrenome.setMargin(new java.awt.Insets(2, 10, 2, 2));

        textoCpf.setEditable(false);
        textoCpf.setBackground(new java.awt.Color(255, 255, 255));
        textoCpf.setForeground(new java.awt.Color(153, 153, 153));
        try {
            textoCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textoCpf.setText("");
        textoCpf.setMargin(new java.awt.Insets(2, 10, 2, 2));

        labelCpf.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelCpf.setText("CPF:");

        labelSexo.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelSexo.setText("Sexo:");

        boxSexo.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
        boxSexo.setForeground(new java.awt.Color(0, 51, 51));
        boxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Feminino", "Masculino" }));
        boxSexo.setEnabled(false);

        labelDataNascimento.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelDataNascimento.setText("Data Nascimento:");

        textoDataNascimento.setEditable(false);
        textoDataNascimento.setBackground(new java.awt.Color(255, 255, 255));
        textoDataNascimento.setForeground(new java.awt.Color(153, 153, 153));
        try {
            textoDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textoDataNascimento.setMargin(new java.awt.Insets(2, 10, 2, 2));

        labelTelefone.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelTelefone.setText("Telefone:");

        textoTelefone.setEditable(false);
        textoTelefone.setBackground(new java.awt.Color(255, 255, 255));
        textoTelefone.setForeground(new java.awt.Color(153, 153, 153));
        try {
            textoTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textoTelefone.setMargin(new java.awt.Insets(2, 10, 2, 2));

        javax.swing.GroupLayout painelDadosPessoaisLayout = new javax.swing.GroupLayout(painelDadosPessoais);
        painelDadosPessoais.setLayout(painelDadosPessoaisLayout);
        painelDadosPessoaisLayout.setHorizontalGroup(
            painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosPessoaisLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(editarInfosPessoal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelDadosPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelCpf)
                            .addComponent(labelNome)
                            .addComponent(labelDataNascimento)
                            .addComponent(textoNome)
                            .addComponent(textoCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(textoDataNascimento))
                        .addGap(33, 33, 33)
                        .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelTelefone)
                            .addComponent(labelSobrenome)
                            .addComponent(textoSobrenome)
                            .addComponent(labelSexo)
                            .addComponent(boxSexo, 0, 198, Short.MAX_VALUE)
                            .addComponent(textoTelefone))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelDadosPessoaisLayout.setVerticalGroup(
            painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(labelSobrenome))
                .addGap(4, 4, 4)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCpf)
                    .addComponent(labelSexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataNascimento)
                    .addComponent(labelTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(editarInfosPessoal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelDadosEndereco.setBackground(new java.awt.Color(232, 232, 232));
        painelDadosEndereco.setPreferredSize(new java.awt.Dimension(400, 430));

        editarInfosEndereco.setBackground(new java.awt.Color(0, 0, 238));
        editarInfosEndereco.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        editarInfosEndereco.setForeground(new java.awt.Color(255, 255, 255));
        editarInfosEndereco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editarInfosEndereco.setText("Editar ");
        editarInfosEndereco.setOpaque(true);
        editarInfosEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarInfosEnderecoMouseClicked(evt);
            }
        });

        labelDadosEndereco.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        labelDadosEndereco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDadosEndereco.setText("Dados de Endereço");

        labelRua.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelRua.setText("Rua:");

        textoRua.setEditable(false);
        textoRua.setBackground(new java.awt.Color(255, 255, 255));
        textoRua.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoRua.setForeground(new java.awt.Color(153, 153, 153));
        textoRua.setMargin(new java.awt.Insets(2, 10, 2, 2));

        labelCep.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelCep.setText("CEP:");

        textoCep.setEditable(false);
        textoCep.setBackground(new java.awt.Color(255, 255, 255));
        textoCep.setForeground(new java.awt.Color(153, 153, 153));
        try {
            textoCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textoCep.setToolTipText("");
        textoCep.setMargin(new java.awt.Insets(2, 10, 2, 2));

        labelBairro.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelBairro.setText("Bairro:");

        textoBairro.setEditable(false);
        textoBairro.setBackground(new java.awt.Color(255, 255, 255));
        textoBairro.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoBairro.setForeground(new java.awt.Color(153, 153, 153));
        textoBairro.setMargin(new java.awt.Insets(2, 10, 2, 2));

        labelCidade.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelCidade.setText("Cidade:");

        textoCidade.setEditable(false);
        textoCidade.setBackground(new java.awt.Color(255, 255, 255));
        textoCidade.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoCidade.setForeground(new java.awt.Color(153, 153, 153));
        textoCidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        textoCidade.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoCidade.setBorder(BorderFactory.createCompoundBorder(textoCidade.getBorder(),
            BorderFactory.createEmptyBorder(2, 10, 2, 2)));

    textoEstado.setEditable(false);
    textoEstado.setBackground(new java.awt.Color(255, 255, 255));
    textoEstado.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
    textoEstado.setForeground(new java.awt.Color(153, 153, 153));
    textoEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
    textoEstado.setMargin(new java.awt.Insets(2, 10, 2, 2));

    labelEstado.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
    labelEstado.setText("Estado:");

    textoNumero.setEditable(false);
    textoNumero.setBackground(new java.awt.Color(255, 255, 255));
    textoNumero.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
    textoNumero.setForeground(new java.awt.Color(153, 153, 153));
    textoNumero.setMargin(new java.awt.Insets(2, 10, 2, 2));

    labelNumero.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
    labelNumero.setText("Número:");

    labelComplemento.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
    labelComplemento.setText("Complemento:");

    textoComplemento.setEditable(false);
    textoComplemento.setBackground(new java.awt.Color(255, 255, 255));
    textoComplemento.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
    textoComplemento.setForeground(new java.awt.Color(153, 153, 153));
    textoComplemento.setToolTipText("");
    textoComplemento.setMargin(new java.awt.Insets(2, 10, 2, 2));

    javax.swing.GroupLayout painelDadosEnderecoLayout = new javax.swing.GroupLayout(painelDadosEndereco);
    painelDadosEndereco.setLayout(painelDadosEnderecoLayout);
    painelDadosEnderecoLayout.setHorizontalGroup(
        painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelDadosEnderecoLayout.createSequentialGroup()
            .addGroup(painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelDadosEnderecoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosEnderecoLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(editarInfosEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(labelDadosEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(painelDadosEnderecoLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textoCidade, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoCep, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(textoRua, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRua, javax.swing.GroupLayout.Alignment.LEADING))
                        .addComponent(labelCep)
                        .addComponent(labelCidade))
                    .addGap(18, 18, 18)
                    .addGroup(painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelDadosEnderecoLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(painelDadosEnderecoLayout.createSequentialGroup()
                                    .addComponent(textoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textoComplemento))
                                .addGroup(painelDadosEnderecoLayout.createSequentialGroup()
                                    .addComponent(labelNumero)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelComplemento)
                                    .addGap(16, 16, 16))
                                .addGroup(painelDadosEnderecoLayout.createSequentialGroup()
                                    .addGroup(painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelBairro)
                                        .addComponent(textoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(painelDadosEnderecoLayout.createSequentialGroup()
                            .addGroup(painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelEstado))
                            .addGap(0, 0, Short.MAX_VALUE)))))
            .addContainerGap())
    );
    painelDadosEnderecoLayout.setVerticalGroup(
        painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosEnderecoLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(labelDadosEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelRua)
                .addComponent(labelBairro))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textoRua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(36, 36, 36)
            .addGroup(painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelCep)
                .addComponent(labelNumero)
                .addComponent(labelComplemento))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textoCep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(30, 30, 30)
            .addGroup(painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelCidade)
                .addComponent(labelEstado))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(painelDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
            .addComponent(editarInfosEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    salvarAlteracoes.setBackground(new java.awt.Color(0, 0, 238));
    salvarAlteracoes.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
    salvarAlteracoes.setForeground(new java.awt.Color(255, 255, 255));
    salvarAlteracoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    salvarAlteracoes.setText("Salvar Alterações");
    salvarAlteracoes.setOpaque(true);
    salvarAlteracoes.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            salvarAlteracoesMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout painelTelaDadosDaContaLayout = new javax.swing.GroupLayout(painelTelaDadosDaConta);
    painelTelaDadosDaConta.setLayout(painelTelaDadosDaContaLayout);
    painelTelaDadosDaContaLayout.setHorizontalGroup(
        painelTelaDadosDaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelTelaDadosDaContaLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addComponent(painelDadosConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(painelTelaDadosDaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(salvarAlteracoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelDadosPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(painelDadosEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(22, Short.MAX_VALUE))
    );
    painelTelaDadosDaContaLayout.setVerticalGroup(
        painelTelaDadosDaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelTelaDadosDaContaLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(painelTelaDadosDaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(painelDadosEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(painelDadosConta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
            .addComponent(salvarAlteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(63, 63, 63))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(painelTelaDadosDaConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(painelTelaDadosDaConta, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarInfosContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarInfosContaMouseClicked
        painelDadosConta.setBackground(new Color(204, 204, 204));
        textoEmail.setEditable(true);
        textoEmail.setFocusable(true);
        textoEmail.setForeground(new Color(79, 79, 9));
        textoSenha.setEditable(true);
        textoSenha.setFocusable(true);
        textoSenha.setForeground(new Color(79, 79, 9));
    }//GEN-LAST:event_editarInfosContaMouseClicked

    private void editarInfosPessoalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarInfosPessoalMouseClicked
        painelDadosPessoais.setBackground(new Color(204, 204, 204));
        textoNome.setEditable(true);
        textoNome.setFocusable(true);
        textoNome.setForeground(new Color(79, 79, 9));
        textoSobrenome.setEditable(true);
        textoSobrenome.setFocusable(true);
        textoSobrenome.setForeground(new Color(79, 79, 9));
        textoCpf.setEditable(true);
        textoCpf.setFocusable(true);
        textoCpf.setForeground(new Color(79, 79, 9));
        textoDataNascimento.setEditable(true);
        textoDataNascimento.setFocusable(true);
        textoDataNascimento.setForeground(new Color(79, 79, 9));
        boxSexo.setEnabled(true);
        boxSexo.setForeground(new Color(79, 79, 9));
        textoTelefone.setEditable(true);
        textoTelefone.setFocusable(true);
        textoTelefone.setForeground(new Color(79, 79, 9));
    }//GEN-LAST:event_editarInfosPessoalMouseClicked

    private void editarInfosEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarInfosEnderecoMouseClicked
        painelDadosEndereco.setBackground(new Color(204, 204, 204));
        textoRua.setEditable(true);
        textoRua.setFocusable(true);
        textoRua.setForeground(new Color(79, 79, 9));
        textoBairro.setEditable(true);
        textoBairro.setFocusable(true);
        textoBairro.setForeground(new Color(79, 79, 9));
        textoCep.setEditable(true);
        textoCep.setFocusable(true);
        textoCep.setForeground(new Color(79, 79, 9));
        textoCidade.setEditable(true);
        textoCidade.setFocusable(true);
        textoCidade.setForeground(new Color(79, 79, 9));
        textoEstado.setEditable(true);
        textoEstado.setFocusable(true);
        textoEstado.setForeground(new Color(79, 79, 9));
        textoComplemento.setEditable(true);
        textoComplemento.setFocusable(true);
        textoComplemento.setForeground(new Color(79, 79, 9));
        textoNumero.setEditable(true);
        textoNumero.setFocusable(true);
        textoNumero.setForeground(new Color(79, 79, 9));
    }//GEN-LAST:event_editarInfosEnderecoMouseClicked

    private void painelTelaDadosDaContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelTelaDadosDaContaMouseClicked
        // Voltando os jTextField e jPanel para seus valores padrões
        painelDadosConta.setBackground(new Color(232, 232, 232));
        painelDadosPessoais.setBackground(new Color(232, 232, 232));
        painelDadosEndereco.setBackground(new Color(232, 232, 232));
        textoEmail.setEditable(false);
        textoEmail.setFocusable(false);
        textoSenha.setEditable(false);
        textoSenha.setFocusable(false);
        textoNome.setEditable(false);
        textoNome.setFocusable(false);
        textoSobrenome.setEditable(false);
        textoSobrenome.setFocusable(false);
        boxSexo.setEnabled(false);
        textoCpf.setEditable(false);
        textoCpf.setFocusable(false);
        textoDataNascimento.setEditable(false);
        textoDataNascimento.setFocusable(false);
        textoTelefone.setEditable(false);
        textoTelefone.setFocusable(false);
        textoRua.setEditable(false);
        textoRua.setFocusable(false);
        textoBairro.setEditable(false);
        textoBairro.setFocusable(false);
        textoCidade.setEditable(false);
        textoCidade.setFocusable(false);
        textoEstado.setEditable(false);
        textoEstado.setFocusable(false);
        textoCep.setEditable(false);
        textoCep.setFocusable(false);
        textoNumero.setEditable(false);
        textoNumero.setFocusable(false);
        textoComplemento.setEditable(false);
        textoComplemento.setFocusable(false);

        telaPrincipalThis.hideComponents(); // Oculta todas as listas dropdowns do menu
    }//GEN-LAST:event_painelTelaDadosDaContaMouseClicked

    private void salvarAlteracoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salvarAlteracoesMouseClicked
        salvarAlteracoes.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Integer textoNumeroInt = null; // Variavel para converter o texto do textoNumero em um inteiro
        boolean convertido = false;

        try {
            //Transformo o valor de textoNumero em Integer e insere em textoNumeroInt.
            textoNumeroInt = Integer.parseInt(textoNumero.getText());
            convertido = true;

            //Aqui pode ocorrer a exceção NumberFormatException, onde o campo de TextField conter algum valor que não seja inteiro.
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Preencha todos os dados de forma válida!", "Swerts Store", 0);
        }

        if (convertido == true) {
            if (verificaDadosInseridos()) {
                Usuario usuarioAlterado = new Usuario(textoNome.getText(), textoSobrenome.getText(), textoCpf.getText(),
                        boxSexo.getSelectedItem().toString(), textoDataNascimento.getText(), textoTelefone.getText(),
                        textoEmail.getText(), textoSenha.getText(), textoRua.getText(), textoBairro.getText(),
                        textoNumeroInt, textoComplemento.getText(), textoCep.getText(),
                        textoCidade.getText(), textoEstado.getText());

                UsuarioDAO alterarDadosUsuario = new UsuarioDAO();
                boolean alterado = alterarDadosUsuario.alterarUsuario(usuarioAlterado, usuarioOnline.getEmail());

                if (alterado == true) {
                    // Prenchendo o objeto usuarioOnline com os dados novos do usuario online
                    usuarioOnline.setNome(textoNome.getText());
                    usuarioOnline.setSobrenome(textoSobrenome.getText());
                    usuarioOnline.setCpf(textoCpf.getText());
                    usuarioOnline.setDataDeNascimento(textoDataNascimento.getText());
                    usuarioOnline.setTelefone(textoTelefone.getText());
                    usuarioOnline.setSexo(boxSexo.getSelectedItem().toString());
                    usuarioOnline.setEmail(textoEmail.getText());
                    usuarioOnline.setSenha(textoSenha.getText());
                    usuarioOnline.setRua(textoRua.getText());
                    usuarioOnline.setBairro(textoBairro.getText());
                    usuarioOnline.setNumero(textoNumeroInt);
                    usuarioOnline.setCep(textoCep.getText());
                    usuarioOnline.setComplemento(textoComplemento.getText());
                    usuarioOnline.setCidade(textoCidade.getText());
                    usuarioOnline.setEstado(textoEstado.getText());

                    // Voltando os jTextField e jPanel para seus valores padrões
                    painelDadosConta.setBackground(new Color(232, 232, 232));
                    painelDadosPessoais.setBackground(new Color(232, 232, 232));
                    painelDadosEndereco.setBackground(new Color(232, 232, 232));
                    textoEmail.setEditable(false);
                    textoEmail.setFocusable(false);
                    textoSenha.setEditable(false);
                    textoSenha.setFocusable(false);
                    textoNome.setEditable(false);
                    textoNome.setFocusable(false);
                    textoSobrenome.setEditable(false);
                    textoSobrenome.setFocusable(false);
                    boxSexo.setEnabled(false);
                    textoCpf.setEditable(false);
                    textoCpf.setFocusable(false);
                    textoDataNascimento.setEditable(false);
                    textoDataNascimento.setFocusable(false);
                    textoTelefone.setEditable(false);
                    textoTelefone.setFocusable(false);
                    textoRua.setEditable(false);
                    textoRua.setFocusable(false);
                    textoBairro.setEditable(false);
                    textoBairro.setFocusable(false);
                    textoCidade.setEditable(false);
                    textoCidade.setFocusable(false);
                    textoEstado.setEditable(false);
                    textoEstado.setFocusable(false);
                    textoCep.setEditable(false);
                    textoCep.setFocusable(false);
                    textoNumero.setEditable(false);
                    textoNumero.setFocusable(false);
                    textoComplemento.setEditable(false);
                    textoComplemento.setFocusable(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao alterar os dados!", "Swerts Store", 0);
                }
            }
        }
        salvarAlteracoes.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_salvarAlteracoesMouseClicked

    private void labelMostrarSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMostrarSenhaMouseClicked
        if (textoSenha.getEchoChar() != '\u2022') {
            textoSenha.setEchoChar('\u2022');
            labelMostrarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/showPassword.png")));
        } else {
            textoSenha.setEchoChar((char) 0);
            labelMostrarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hidePassword.png")));
        }
    }//GEN-LAST:event_labelMostrarSenhaMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        telaPrincipalThis.hideComponents(); // Oculta todas as listas dropdowns do menu
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxSexo;
    private javax.swing.JLabel editarInfosConta;
    private javax.swing.JLabel editarInfosEndereco;
    private javax.swing.JLabel editarInfosPessoal;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelCep;
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelComplemento;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelDadosConta;
    private javax.swing.JLabel labelDadosEndereco;
    private javax.swing.JLabel labelDadosPessoais;
    private javax.swing.JLabel labelDataNascimento;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelMostrarSenha;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelRua;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelSexo;
    private javax.swing.JLabel labelSobrenome;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JPanel painelDadosConta;
    private javax.swing.JPanel painelDadosEndereco;
    private javax.swing.JPanel painelDadosPessoais;
    private javax.swing.JPanel painelTelaDadosDaConta;
    private javax.swing.JLabel salvarAlteracoes;
    private javax.swing.JTextField textoBairro;
    private javax.swing.JFormattedTextField textoCep;
    private javax.swing.JTextField textoCidade;
    private javax.swing.JTextField textoComplemento;
    private javax.swing.JFormattedTextField textoCpf;
    private javax.swing.JFormattedTextField textoDataNascimento;
    private javax.swing.JTextField textoEmail;
    private javax.swing.JTextField textoEstado;
    private javax.swing.JTextField textoNome;
    private javax.swing.JTextField textoNumero;
    private javax.swing.JTextField textoRua;
    private javax.swing.JPasswordField textoSenha;
    private javax.swing.JTextField textoSobrenome;
    private javax.swing.JFormattedTextField textoTelefone;
    // End of variables declaration//GEN-END:variables
}
