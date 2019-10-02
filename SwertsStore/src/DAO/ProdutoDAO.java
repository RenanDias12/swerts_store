package DAO;

/*
    *** CLASSE PRODUTOS DAO ***

Objetivo: Classe para realizar a conexão com o servidor do BANCO DE DADOS, afim de armazenar os dados dos produtos.  

*/

import model.Produto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

// Faz a conexão com o Banco de Dados
public class ProdutoDAO {

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
    String password = "root";

    boolean sucesso = false;

    public void connectToDb() {
        try {
            con = DriverManager.getConnection(url, user, password);

        } catch (SQLException ex) {

            System.out.println("Erro: " + ex.getMessage());

        }
    }

    // Inserir produtos no Banco de Dados
    public boolean inserirProduto(Produto novoProduto) {
        connectToDb();

        String sql = "INSERT INTO produto(codigo, tipo, preco, marca, modelo, cor, titulo, quantidade, imagem) values (?,?,?,?,?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);

            pst.setInt(1, novoProduto.getCodigo());
            pst.setString(2, novoProduto.getTipo());
            pst.setFloat(3, novoProduto.getPreco());
            pst.setString(4, novoProduto.getMarca());
            pst.setString(5, novoProduto.getModelo());
            pst.setString(6, novoProduto.getCor());
            pst.setString(7, novoProduto.getTitulo());
            pst.setInt(8, novoProduto.getQuantidade());
            pst.setBytes(9, novoProduto.getImagem());

            pst.execute();

            sucesso = true;
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Swerts Store", 1);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar cadastrar um produto!", "Swerts Store", 0);
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar cadastrar um produto!", "Swerts Store", 0);
            }
        }
        return sucesso;
    }

    // Buscar produtos no Banco de Dados
    public ArrayList<Produto> buscarProdutosSemFiltro() {
        ArrayList<Produto> listaDeProdutos = new ArrayList<>();

        connectToDb();

        String sql = "SELECT * FROM produto";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Produto produtoTemp = new Produto(rs.getInt("codigo"), rs.getString("tipo"), rs.getFloat("preco"),
                        rs.getString("marca"), rs.getString("modelo"), rs.getString("cor"), rs.getString("titulo"),
                        rs.getInt("quantidade"), rs.getBytes("imagem"));

                listaDeProdutos.add(produtoTemp);

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
        return listaDeProdutos;
    }

    // Buscar produtos no Banco de Dados com Filtro
    public ArrayList<Produto> buscarProdutosComFiltro(String mensagemBusca) {
        ArrayList<Produto> listaDeProdutos = new ArrayList<>();

        connectToDb();

        String sql = "SELECT * FROM produto";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                if(rs.getString("titulo").toLowerCase().contains(mensagemBusca.toLowerCase()) && !"".equals(mensagemBusca)){
                    Produto produtoTemp = new Produto(rs.getInt("codigo"), rs.getString("tipo"), rs.getFloat("preco"),
                            rs.getString("marca"), rs.getString("modelo"), rs.getString("cor"), rs.getString("titulo"),
                            rs.getInt("quantidade"), rs.getBytes("imagem"));

                    listaDeProdutos.add(produtoTemp);
                }
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
        
        return listaDeProdutos;
    }
    
    // Metodo para verificar se a quantidade da compra é igual a quantidade de produto existente no banco de dados
    public boolean verificaProduto(Produto produto, int quantidade) {
        connectToDb();
        CallableStatement callableStatement = null;

        try {
              callableStatement = con.prepareCall("{CALL verificaQuantidadeCompra(" + produto.getCodigo() + "," + quantidade +")}");

            callableStatement.execute();
            
            sucesso = true;

        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;

        } finally {
            try {
                con.close();

            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }

        return sucesso;
    }

}
