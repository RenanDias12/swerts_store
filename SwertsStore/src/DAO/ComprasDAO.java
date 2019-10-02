package DAO;

/*
    *** CLASSE COMPRAS DAO ***

Objetivo: Classe para realizar a conexão com o servidor do BANCO DE DADOS, afim de armazenar os dados das compras.  

*/

import model.Compras;
import model.Produto;
import model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class ComprasDAO {

    // objeto responsável pela conexão com o servidor do banco de dados
    Connection con;
    // objeto responsável por preparar as consultas DINAMICAS
    PreparedStatement pst;
    // objeto responsável por executar as consultas STATICAS
    Statement st;
    // objeto responsável por referencia a tabela resultante da busca
    ResultSet rs;

    String database = "swerts_db";
    // String url = "jdbc:mysql://localhost:3307/"+database+"?useTimezone=true&serverTimezone=UTC&useSSL=false";
    String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    String user = "root";
    //Senha do BD
    String password = "root";

    boolean sucesso = false;
    
    
    public void connectToDb() {
        try {
            con = DriverManager.getConnection(url, user, password);

        } catch (SQLException ex) {

            System.out.println("Erro: " + ex.getMessage());

        }
    }

    // Inserir produtos na tabela de Compras
    public boolean inserirProduto(Produto produtoComprado, Usuario usuarioOnline) {
        connectToDb();

        String sql = "INSERT INTO compras(codigo, tipo, preco, marca, modelo, cor, titulo, quantidade, imagem, data_compra, email_usuario)"
                + " values (?,?,?,?,?,?,?,?,?,?,?)";

        Calendar c = Calendar.getInstance(); // Instanciando a classe calendario para pegar a data atual
        String dia;
        String mes;
        String ano;

        // Pegando o dia, mes e ano da data atual
        if (c.get(Calendar.DAY_OF_MONTH) < 10) {
            dia = "0" + String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        } else {
            dia = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        }
        if (c.get(Calendar.MONTH) < 10) {
            mes = "0" + String.valueOf((c.get(Calendar.MONTH) + 1));
        } else {
            mes = String.valueOf((c.get(Calendar.MONTH) + 1));
        }
        ano = String.valueOf(c.get(Calendar.YEAR));

        String dataAtual = dia + "/" + mes + "/" + ano; // Pegando a data atual

        try {
            pst = con.prepareStatement(sql);

            pst.setInt(1, produtoComprado.getCodigo());
            pst.setString(2, produtoComprado.getTipo());
            pst.setFloat(3, produtoComprado.getPreco());
            pst.setString(4, produtoComprado.getMarca());
            pst.setString(5, produtoComprado.getModelo());
            pst.setString(6, produtoComprado.getCor());
            pst.setString(7, produtoComprado.getTitulo());
            pst.setInt(8, produtoComprado.getQuantidadeCompra());
            pst.setBytes(9, produtoComprado.getImagem());
            pst.setString(10, dataAtual);
            pst.setString(11, usuarioOnline.getEmail());

            pst.execute();

            sucesso = true;

        } catch (SQLException ex) {
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "O sistema retornou um erro insperado, tente novamente mais tarde!", "Swerts Store", 0);
            }
        }
        return sucesso;
    }

    // Buscar produtos na tabela de compras sem filtro
    public ArrayList<Compras> buscarProdutosSemFiltro() {
        ArrayList<Compras> listaDeCompras = new ArrayList<>();

        connectToDb();

        String sql = "SELECT compras.*, usuario.nome AS nome_usuario FROM compras, usuario "
                + "WHERE usuario.email = compras.email_usuario ORDER BY compras.data_compra DESC";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Compras compraTemp = new Compras(rs.getInt("codigo"), rs.getString("tipo"), rs.getFloat("preco"),
                        rs.getString("marca"), rs.getString("modelo"), rs.getString("cor"), rs.getString("titulo"),
                        rs.getInt("quantidade"), rs.getBytes("imagem"), rs.getString("nome_usuario"), rs.getString("data_compra"));

                listaDeCompras.add(compraTemp);

            }
            sucesso = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar os produtos!", "Swerts Store", 0);
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar os produtos!", "Swerts Store", 0);
            }

        }
        return listaDeCompras;
    }

    // Buscar usuarios no Banco de Dados com Filtro
    public ArrayList<Compras> buscarComprasComFiltro(String emailUsuario) {
        ArrayList<Compras> listaDeCompras = new ArrayList<>();

        connectToDb();

        String sql = "SELECT * FROM compras WHERE email_usuario = '" + emailUsuario + "'";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Compras comprasTemp = new Compras(rs.getInt("codigo"), rs.getString("tipo"), rs.getFloat("preco"),
                        rs.getString("marca"), rs.getString("modelo"), rs.getString("cor"), rs.getString("titulo"),
                        rs.getInt("quantidade"), rs.getBytes("imagem"), emailUsuario, rs.getString("data_compra"));

                listaDeCompras.add(comprasTemp);

            }
            sucesso = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar as compras!", "Swerts Store", 0);
            System.out.println("Erro:\n" + ex);
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar as compras!", "Swerts Store", 0);
                System.out.println("Erro:\n" + ex);
            }

        }

        return listaDeCompras;
    }

}
