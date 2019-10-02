package view;

import DAO.UsuarioDAO;
import util.BuscaCep;
import model.Usuario;
import util.Webservicecep;
import java.awt.Color;
import java.awt.Cursor;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;
import javax.swing.BorderFactory;

public class TelaCadastro extends javax.swing.JFrame {

    public TelaCadastro() {
        initComponents();
    }
    
    //Método para validação da data
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
                || textoConfirmarSenha.getText().equals("") || textoConfirmarSenha.getText().equals("ConfirmeASenha")
                || textoRua.getText().equals("") || textoRua.getText().equals("Ex: Rua São Benedito")
                || textoBairro.getText().equals("") || textoBairro.getText().equals("")
                || textoCep.getText().equals("") || textoCep.getText().equals("")
                || textoCidade.getText().equals("") || textoCidade.getText().equals("")
                || textoEstado.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos de forma válida!", "Swerts Store", 0);
            return false;
        } // Se a senha nao for confimada corretamente
        else if (textoConfirmarSenha.getText().equals(textoSenha.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Confirmação de senha inválida!", "Swerts Store", 0);
            return false;
        } // Se o email digitado nao for "valido"
        else if (textoEmail.getText().contains("@") == false || textoEmail.getText().contains(".") == false) {
            JOptionPane.showMessageDialog(null, "Email inválido!", "Swerts Store", 0);
            return false;
        } //Verificação se o nome contém apenas letras e não é um caracter único
        else if (!textoNome.getText().matches("[A-Z a-z Çç]{" + textoNome.getText().length() + "}")
                || textoNome.getText().matches(".")) {
            JOptionPane.showMessageDialog(null, "Nome inválido!", "Swerts Store", 0);
            return false;

        } //Verificação se  o sobrenome contém apenas letras e não é um caracter único
        else if (!textoSobrenome.getText().toString().matches("[A-Z a-z Çç]{" + textoSobrenome.getText().toString().length() +
                "}") || textoSobrenome.getText().toString().matches(".")) {
            JOptionPane.showMessageDialog(null, "Sobrenome inválido!", "Swerts Store", 0);
            return false;

        } 
        else if (textoNumero.getText().toString().matches("[A-Z a-z Çç]{" + textoNumero.getText().toString().length() + "}")) {
            JOptionPane.showMessageDialog(null, "Número inválido!", "Swerts Store", 0);
            return false;

        } //Verificação básica do CPF 
        else if (textoCpf.getText().equals("000.000.000-00") || textoCpf.getText().equals("111.111.111-11") || textoCpf.getText().equals("222.222.222.22") || textoCpf.getText().equals("333.333.333-33")
                || textoCpf.getText().equals("444.444.444-44") || textoCpf.getText().equals("555.555.555-55") || textoCpf.getText().equals("666.666.666-66") || textoCpf.getText().equals("777.777.777-77")
                || textoCpf.getText().equals("888.888.888-88") || textoCpf.getText().equals("999.999.999-99")) {
            JOptionPane.showMessageDialog(null, "CPF inválido!", "Swerts Store", 0);
            return false;
        } // Verificação do telefone
        else if (textoTelefone.getText().equals("(11) 11111-1111") || textoTelefone.getText().equals("(22) 22222-2222") || textoTelefone.getText().equals("(33) 33333-3333") || textoTelefone.getText().equals("(44) 44444-4444")
                || textoTelefone.getText().equals("(55) 55555-5555") || textoTelefone.getText().equals("(66) 66666-6666") || textoTelefone.getText().equals("(77) 77777-7777") || textoTelefone.getText().equals("(88) 88888-8888")
                || textoTelefone.getText().equals("(99) 99999-9999") || textoTelefone.getText().equals("(00) 00000-0000")) {
            JOptionPane.showMessageDialog(null, "Telefone inválido!", "Swerts Store", 0);
            return false;
            
        } // Verificação da data - chama a função isDateValid
        else if (!isDateValid(textoDataNascimento.getText().toString())) {
            JOptionPane.showMessageDialog(null, "Data inválida!", "Swerts Store", 0);
            return false;
        }// Verificação da data utilizando REGEX - limitando o ano min para 1900. 
        else if (!textoDataNascimento.getText().toString().matches("(0[1-9]|1[1-9]|2[1-9]|30|31)/(0[1-9]|10|11|12)/19[0-9]{2}$")) {
            JOptionPane.showMessageDialog(null, "Data inválida!", "Swerts Store", 0);
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDeRolagem = new javax.swing.JScrollPane();
        painelCadastro = new javax.swing.JPanel();
        painelDadosAcesso = new javax.swing.JPanel();
        textoEmail = new javax.swing.JTextField();
        textoSenha = new javax.swing.JPasswordField();
        labelEmail = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        textoConfirmarSenha = new javax.swing.JPasswordField();
        labelConfirmarSenha = new javax.swing.JLabel();
        painelEndereco = new javax.swing.JPanel();
        labelCep = new javax.swing.JLabel();
        labelRua = new javax.swing.JLabel();
        textoNumero = new javax.swing.JTextField();
        textoRua = new javax.swing.JTextField();
        labelBairro = new javax.swing.JLabel();
        textoCep = new javax.swing.JFormattedTextField();
        labelEstado = new javax.swing.JLabel();
        textoCidade = new javax.swing.JTextField();
        labelCidade = new javax.swing.JLabel();
        textoBairro = new javax.swing.JTextField();
        textoComplemento = new javax.swing.JTextField();
        labelComplemento = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        textoEstado = new javax.swing.JTextField();
        painelDadosPessoais = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        textoNome = new javax.swing.JTextField();
        textoSobrenome = new javax.swing.JTextField();
        labelSobrenome = new javax.swing.JLabel();
        labelCpf = new javax.swing.JLabel();
        textoCpf = new javax.swing.JFormattedTextField();
        labelSexo = new javax.swing.JLabel();
        labelDataNascimento = new javax.swing.JLabel();
        boxSexo = new javax.swing.JComboBox<>();
        textoDataNascimento = new javax.swing.JFormattedTextField();
        textoTelefone = new javax.swing.JFormattedTextField();
        labelTelefone = new javax.swing.JLabel();
        botaoCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        painelCadastro.setBackground(new java.awt.Color(255, 255, 255));
        painelCadastro.setPreferredSize(new java.awt.Dimension(800, 460));

        painelDadosAcesso.setBackground(new java.awt.Color(255, 255, 255));
        painelDadosAcesso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados De Acesso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI", 1, 12))); // NOI18N
        painelDadosAcesso.setPreferredSize(new java.awt.Dimension(335, 255));

        textoEmail.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoEmail.setForeground(new java.awt.Color(153, 153, 153));
        textoEmail.setText("Ex: renzo@gmail.com");
        textoEmail.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textoEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoEmailFocusLost(evt);
            }
        });

        textoSenha.setForeground(new java.awt.Color(153, 153, 153));
        textoSenha.setText("DigiteUmaSenha");
        textoSenha.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textoSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoSenhaFocusLost(evt);
            }
        });

        labelEmail.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelEmail.setText("E-mail:");

        labelSenha.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelSenha.setText("Senha:");

        textoConfirmarSenha.setForeground(new java.awt.Color(153, 153, 153));
        textoConfirmarSenha.setText("ConfirmeASenha");
        textoConfirmarSenha.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoConfirmarSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textoConfirmarSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoConfirmarSenhaFocusLost(evt);
            }
        });

        labelConfirmarSenha.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelConfirmarSenha.setText("Confirmar senha:");

        javax.swing.GroupLayout painelDadosAcessoLayout = new javax.swing.GroupLayout(painelDadosAcesso);
        painelDadosAcesso.setLayout(painelDadosAcessoLayout);
        painelDadosAcessoLayout.setHorizontalGroup(
            painelDadosAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosAcessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textoEmail)
                    .addComponent(labelEmail)
                    .addComponent(labelSenha)
                    .addComponent(textoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(textoConfirmarSenha)
                    .addComponent(labelConfirmarSenha))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        painelDadosAcessoLayout.setVerticalGroup(
            painelDadosAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosAcessoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(labelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelConfirmarSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        painelEndereco.setBackground(new java.awt.Color(255, 255, 255));
        painelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI", 1, 12))); // NOI18N
        painelEndereco.setMinimumSize(new java.awt.Dimension(696, 200));

        labelCep.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelCep.setText("CEP:");

        labelRua.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelRua.setText("Rua:");

        textoNumero.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoNumero.setForeground(new java.awt.Color(79, 79, 79));
        textoNumero.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textoNumeroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoNumeroFocusLost(evt);
            }
        });

        textoRua.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoRua.setForeground(new java.awt.Color(153, 153, 153));
        textoRua.setText("Ex: Rua São Benedito");
        textoRua.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoRua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textoRuaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoRuaFocusLost(evt);
            }
        });

        labelBairro.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelBairro.setText("Bairro:");

        textoCep.setForeground(new java.awt.Color(79, 79, 79));
        try {
            textoCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textoCep.setToolTipText("");
        textoCep.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textoCepFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoCepFocusLost(evt);
            }
        });

        labelEstado.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        labelEstado.setText("Estado:");

        textoCidade.setEditable(false);
        textoCidade.setBackground(new java.awt.Color(255, 255, 255));
        textoCidade.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        textoCidade.setForeground(new java.awt.Color(79, 79, 79));
        textoCidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        textoCidade.setMargin(new java.awt.Insets(2, 10, 2, 2));
        textoCidade.setBorder(BorderFactory.createCompoundBorder(textoCidade.getBorder(),
            BorderFactory.createEmptyBorder(2, 10, 2, 2)));

    labelCidade.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
    labelCidade.setText("Cidade:");

    textoBairro.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
    textoBairro.setForeground(new java.awt.Color(79, 79, 79));
    textoBairro.setMargin(new java.awt.Insets(2, 10, 2, 2));
    textoBairro.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            textoBairroFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            textoBairroFocusLost(evt);
        }
    });

    textoComplemento.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
    textoComplemento.setForeground(new java.awt.Color(79, 79, 79));
    textoComplemento.setToolTipText("");
    textoComplemento.setMargin(new java.awt.Insets(2, 10, 2, 2));
    textoComplemento.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            textoComplementoFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            textoComplementoFocusLost(evt);
        }
    });

    labelComplemento.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
    labelComplemento.setText("Complemento:");

    labelNumero.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
    labelNumero.setText("Número:");

    textoEstado.setEditable(false);
    textoEstado.setBackground(new java.awt.Color(255, 255, 255));
    textoEstado.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
    textoEstado.setForeground(new java.awt.Color(79, 79, 79));
    textoEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
    textoEstado.setMargin(new java.awt.Insets(2, 10, 2, 2));
    textoEstado.setBorder(BorderFactory.createCompoundBorder(textoEstado.getBorder(),
        BorderFactory.createEmptyBorder(2, 10, 2, 2)));
textoEstado.setMargin(new java.awt.Insets(2, 10, 2, 2));

javax.swing.GroupLayout painelEnderecoLayout = new javax.swing.GroupLayout(painelEndereco);
painelEndereco.setLayout(painelEnderecoLayout);
painelEnderecoLayout.setHorizontalGroup(
    painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(painelEnderecoLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEnderecoLayout.createSequentialGroup()
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelEnderecoLayout.createSequentialGroup()
                        .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoCep, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoRua, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelEnderecoLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(painelEnderecoLayout.createSequentialGroup()
                                        .addComponent(labelBairro)
                                        .addGap(190, 190, 190))
                                    .addGroup(painelEnderecoLayout.createSequentialGroup()
                                        .addComponent(textoBairro)
                                        .addGap(24, 24, 24))))
                            .addGroup(painelEnderecoLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCidade)
                                    .addComponent(textoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))))
                    .addComponent(labelRua))
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelEstado)
                    .addComponent(textoNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(labelNumero)
                    .addComponent(textoEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelComplemento)))
            .addComponent(labelCep))
        .addGap(32, 32, 32))
    );
    painelEnderecoLayout.setVerticalGroup(
        painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelEnderecoLayout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelRua)
                .addComponent(labelBairro)
                .addComponent(labelNumero)
                .addComponent(labelComplemento))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textoRua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(labelCep)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCidade)
                    .addComponent(labelEstado)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(textoCep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 37, Short.MAX_VALUE))
    );

    painelDadosPessoais.setBackground(new java.awt.Color(255, 255, 255));
    painelDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI", 1, 12))); // NOI18N
    painelDadosPessoais.setPreferredSize(new java.awt.Dimension(335, 255));

    labelNome.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
    labelNome.setText("Nome:");

    textoNome.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
    textoNome.setForeground(new java.awt.Color(153, 153, 153));
    textoNome.setText("Ex: João");
    textoNome.setMargin(new java.awt.Insets(2, 10, 2, 2));
    textoNome.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            textoNomeFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            textoNomeFocusLost(evt);
        }
    });

    textoSobrenome.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
    textoSobrenome.setForeground(new java.awt.Color(153, 153, 153));
    textoSobrenome.setText("Ex: Silva");
    textoSobrenome.setMargin(new java.awt.Insets(2, 10, 2, 2));
    textoSobrenome.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            textoSobrenomeFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            textoSobrenomeFocusLost(evt);
        }
    });

    labelSobrenome.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
    labelSobrenome.setText("Sobrenome:");

    labelCpf.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
    labelCpf.setText("CPF:");

    textoCpf.setForeground(new java.awt.Color(153, 153, 153));
    try {
        textoCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
    } catch (java.text.ParseException ex) {
        ex.printStackTrace();
    }
    textoCpf.setText("");
    textoCpf.setMargin(new java.awt.Insets(2, 10, 2, 2));
    textoCpf.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            textoCpfFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            textoCpfFocusLost(evt);
        }
    });

    labelSexo.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
    labelSexo.setText("Sexo:");

    labelDataNascimento.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
    labelDataNascimento.setText("Data Nascimento:");

    boxSexo.setFont(new java.awt.Font("Leelawadee", 0, 11)); // NOI18N
    boxSexo.setForeground(new java.awt.Color(0, 51, 51));
    boxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Feminino", "Masculino" }));

    textoDataNascimento.setForeground(new java.awt.Color(153, 153, 153));
    try {
        textoDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
    } catch (java.text.ParseException ex) {
        ex.printStackTrace();
    }
    textoDataNascimento.setMargin(new java.awt.Insets(2, 10, 2, 2));
    textoDataNascimento.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            textoDataNascimentoFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            textoDataNascimentoFocusLost(evt);
        }
    });

    textoTelefone.setForeground(new java.awt.Color(153, 153, 153));
    try {
        textoTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
    } catch (java.text.ParseException ex) {
        ex.printStackTrace();
    }
    textoTelefone.setMargin(new java.awt.Insets(2, 10, 2, 2));
    textoTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            textoTelefoneFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            textoTelefoneFocusLost(evt);
        }
    });

    labelTelefone.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
    labelTelefone.setText("Telefone:");

    javax.swing.GroupLayout painelDadosPessoaisLayout = new javax.swing.GroupLayout(painelDadosPessoais);
    painelDadosPessoais.setLayout(painelDadosPessoaisLayout);
    painelDadosPessoaisLayout.setHorizontalGroup(
        painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
            .addGap(22, 22, 22)
            .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(labelCpf)
                .addComponent(labelNome)
                .addComponent(labelDataNascimento)
                .addComponent(textoCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addComponent(textoNome)
                .addComponent(textoDataNascimento))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
            .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosPessoaisLayout.createSequentialGroup()
                    .addComponent(textoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(61, 61, 61))
                .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                    .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelSobrenome)
                        .addComponent(textoSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelSexo)
                        .addComponent(boxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelTelefone))
                    .addContainerGap())))
    );
    painelDadosPessoaisLayout.setVerticalGroup(
        painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelNome)
                .addComponent(labelSobrenome))
            .addGap(4, 4, 4)
            .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textoSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelCpf)
                .addComponent(labelSexo))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(boxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelDataNascimento)
                .addComponent(labelTelefone))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textoDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(31, Short.MAX_VALUE))
    );

    botaoCadastrar.setBackground(new java.awt.Color(0, 0, 238));
    botaoCadastrar.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
    botaoCadastrar.setForeground(new java.awt.Color(255, 255, 255));
    botaoCadastrar.setText("Cadastrar");
    botaoCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            botaoCadastrarMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout painelCadastroLayout = new javax.swing.GroupLayout(painelCadastro);
    painelCadastro.setLayout(painelCadastroLayout);
    painelCadastroLayout.setHorizontalGroup(
        painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelCadastroLayout.createSequentialGroup()
            .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelCadastroLayout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(painelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelCadastroLayout.createSequentialGroup()
                            .addComponent(painelDadosAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(painelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(painelCadastroLayout.createSequentialGroup()
                    .addGap(267, 267, 267)
                    .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 100, Short.MAX_VALUE))
    );
    painelCadastroLayout.setVerticalGroup(
        painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(painelCadastroLayout.createSequentialGroup()
            .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelDadosAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(painelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(6, 6, 6)
            .addComponent(painelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(34, Short.MAX_VALUE))
    );

    painelDeRolagem.setViewportView(painelCadastro);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(painelDeRolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(painelDeRolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoCadastrarMouseClicked
        //Caso botão cadastrar for cliclado - cria-se novo Usuário e salva os dados  
        botaoCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Integer textoNumeroInt = null;
        boolean convertido = false;
        
        try {
            //Transformo o valor de valorTextField em Integer e insiro em valorIntegerTextField.
            textoNumeroInt = Integer.parseInt(textoNumero.getText());
            convertido = true;

            //Aqui pode ocorrer a exceção NumberFormatException, onde o campo de TextField conter algum valor que não seja inteiro.
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos de forma válida!", "Swerts Store", 0);
        }

        if (convertido == true) {
            if (verificaDadosInseridos()) {
                try {
                    // Instanciando um novo usuario
                    Usuario novoUsuario = new Usuario(textoNome.getText(), textoSobrenome.getText(), textoCpf.getText(),
                            boxSexo.getSelectedItem().toString(), textoDataNascimento.getText(), textoTelefone.getText(),
                            textoEmail.getText(), textoSenha.getText(), textoRua.getText(), textoBairro.getText(),
                            textoNumeroInt, textoComplemento.getText(), textoCep.getText(),
                            textoCidade.getText(), textoEstado.getText());

                    UsuarioDAO usuarioDAO = new UsuarioDAO(); // Instanciando classe DAO para inserir um novo usuario
                    boolean inserido = usuarioDAO.inserirUsuario(novoUsuario); // Inserindo novo usuario no Banco de Dados

                    if (inserido == true) {
                        dispose(); // Fechando a tela cadastro
                    }
                } catch (Exception ex) {
                    System.out.println("Erro = " + ex);
                }
            }

        }
        botaoCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botaoCadastrarMouseClicked

    private void textoEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoEmailFocusGained
        if (textoEmail.getText().equals("Ex: renzo@gmail.com")) {
            textoEmail.setText("");
            textoEmail.setForeground(new Color(79, 79, 79));
        }
    }//GEN-LAST:event_textoEmailFocusGained

    private void textoEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoEmailFocusLost
        if (textoEmail.getText().equals("")) {
            textoEmail.setText("Ex: renzo@gmail.com");
            textoEmail.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoEmailFocusLost

    private void textoSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoSenhaFocusGained
        if (textoSenha.getText().equals("DigiteUmaSenha")) {
            textoSenha.setText("");
            textoSenha.setForeground(new Color(79, 79, 79));
        }
    }//GEN-LAST:event_textoSenhaFocusGained

    private void textoSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoSenhaFocusLost
        if (textoSenha.getText().equals("")) {
            textoSenha.setText("DigiteUmaSenha");
            textoSenha.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoSenhaFocusLost

    private void textoConfirmarSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoConfirmarSenhaFocusGained
        if (textoConfirmarSenha.getText().equals("ConfirmeASenha")) {
            textoConfirmarSenha.setText("");
            textoConfirmarSenha.setForeground(new Color(79, 79, 79));
        }
    }//GEN-LAST:event_textoConfirmarSenhaFocusGained

    private void textoConfirmarSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoConfirmarSenhaFocusLost
        if (textoConfirmarSenha.getText().equals("")) {
            textoConfirmarSenha.setText("ConfirmeASenha");
            textoConfirmarSenha.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoConfirmarSenhaFocusLost

    private void textoNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoNomeFocusGained
        if (textoNome.getText().equals("Ex: João")) {
            textoNome.setText("");
            textoNome.setForeground(new Color(79, 79, 79));
        }
    }//GEN-LAST:event_textoNomeFocusGained

    private void textoNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoNomeFocusLost
        if (textoNome.getText().equals("")) {
            textoNome.setText("Ex: João");
            textoNome.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoNomeFocusLost

    private void textoSobrenomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoSobrenomeFocusGained
        if (textoSobrenome.getText().equals("Ex: Silva")) {
            textoSobrenome.setText("");
            textoSobrenome.setForeground(new Color(79, 79, 79));
        }
    }//GEN-LAST:event_textoSobrenomeFocusGained

    private void textoSobrenomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoSobrenomeFocusLost
        if (textoSobrenome.getText().equals("")) {
            textoSobrenome.setText("Ex: Silva");
            textoSobrenome.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoSobrenomeFocusLost

    private void textoRuaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoRuaFocusGained
        textoRua.setForeground(new Color(79, 79, 79));
        if (textoRua.getText().equals("Ex: Rua São Benedito")) {
            textoRua.setText("");

        }
    }//GEN-LAST:event_textoRuaFocusGained

    private void textoRuaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoRuaFocusLost
        if (textoRua.getText().equals("")) {
            textoRua.setText("Ex: Rua São Benedito");
            textoRua.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoRuaFocusLost

    private void textoCepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoCepFocusGained
        textoCep.setForeground(new Color(79, 79, 79));
    }//GEN-LAST:event_textoCepFocusGained

    private void textoCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoCepFocusLost
        if (textoCep.getText() == "     -   ") {
            textoCep.setForeground(new Color(153, 153, 153));
        }
        
        // Instanciando classes para a pesquisa do CEP 
        Webservicecep ws = new Webservicecep(); // Instanciando classe Webservecep para guardar informacoes do cep buscado
        BuscaCep buscandoCep = new BuscaCep(); // Instanciando classe BuscaCep para buscar a cidade e estado do cep inserido

        try {
            ws = BuscaCep.getEndereco(textoCep.getText()); // Guardando informacoes do cep inserido no objeto ws
        } catch (JAXBException ex) {
            System.out.println("Erro = " + ex);
        } catch (MalformedURLException ex) {
            System.out.println("Erro = " + ex);
        }
        
        //Conferindo se o CEP é válido - retorno igual a "0" caso seja válido. 
        if (!"0".equals(ws.getResultado())) {
            // Setando cidade, estado, bairro e rua retornadas pelo Cep inserido
            if (ws.getCidade().equals("") == false) {
                textoCidade.setText(ws.getCidade());
            }
            if (ws.getUf().equals("") == false) {
                textoEstado.setText(ws.getUf());
            }
            if (ws.getBairro().equals("") == false) {
                textoBairro.setText(ws.getBairro());
            }
            if (ws.getLogradouro().equals("") == false) {
                textoRua.setText(ws.getLogradouro());
                textoRua.setForeground(new Color(79, 79, 79));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digite um CEP válido!", "Swerts Store", 0);
        }
    }//GEN-LAST:event_textoCepFocusLost

    private void textoCpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoCpfFocusGained
        textoCpf.setForeground(new Color(79, 79, 79));
    }//GEN-LAST:event_textoCpfFocusGained

    private void textoCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoCpfFocusLost
        if (textoCpf.getText() == "") {
            textoCpf.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoCpfFocusLost

    private void textoDataNascimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoDataNascimentoFocusGained
        textoDataNascimento.setForeground(new Color(79, 79, 79));
    }//GEN-LAST:event_textoDataNascimentoFocusGained

    private void textoDataNascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoDataNascimentoFocusLost
        if (textoDataNascimento.getText() == "  /  /    ") {
            textoDataNascimento.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoDataNascimentoFocusLost

    private void textoTelefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoTelefoneFocusGained
        textoTelefone.setForeground(new Color(79, 79, 79));
    }//GEN-LAST:event_textoTelefoneFocusGained

    private void textoTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoTelefoneFocusLost
        if (textoDataNascimento.getText() == "(  )      -    ") {
            textoTelefone.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoTelefoneFocusLost

    private void textoBairroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoBairroFocusGained
        textoBairro.setForeground(new Color(79, 79, 79));
    }//GEN-LAST:event_textoBairroFocusGained

    private void textoBairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoBairroFocusLost
        if (textoBairro.getText() == "") {
            textoBairro.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoBairroFocusLost

    private void textoNumeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoNumeroFocusGained
        textoNumero.setForeground(new Color(79, 79, 79));
    }//GEN-LAST:event_textoNumeroFocusGained

    private void textoNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoNumeroFocusLost
        if (textoNumero.getText() == "") {
            textoNumero.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoNumeroFocusLost

    private void textoComplementoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoComplementoFocusGained
        textoComplemento.setForeground(new Color(79, 79, 79));

    }//GEN-LAST:event_textoComplementoFocusGained

    private void textoComplementoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoComplementoFocusLost
        if (textoComplemento.getText() == "") {
            textoComplemento.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_textoComplementoFocusLost

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JComboBox<String> boxSexo;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelCep;
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelComplemento;
    private javax.swing.JLabel labelConfirmarSenha;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelDataNascimento;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelRua;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelSexo;
    private javax.swing.JLabel labelSobrenome;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JPanel painelDadosAcesso;
    private javax.swing.JPanel painelDadosPessoais;
    private javax.swing.JScrollPane painelDeRolagem;
    private javax.swing.JPanel painelEndereco;
    private javax.swing.JTextField textoBairro;
    private javax.swing.JFormattedTextField textoCep;
    private javax.swing.JTextField textoCidade;
    private javax.swing.JTextField textoComplemento;
    private javax.swing.JPasswordField textoConfirmarSenha;
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
