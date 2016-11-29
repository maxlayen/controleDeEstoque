package Persistence;

import Models.Produto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProdutoDAO {

    private static final String ARQUIVO_DE_PRODUTOS = "produto.txt";

    private static ArrayList<Produto> produtos = new ArrayList<Produto>();

    public void cadastrar(Produto produto) {
        produtos.add(produto);
        gravarArquivo();
    }

    public ArrayList<Produto> listarProdutos() {
        return produtos;
    }
    
    public Produto procurarProduto(int codigoProduto){
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigoProduto) {
                return produto;
            }
        }
        
        return null;
    }
    
    public void atualizarProduto(Produto p){
        // Buscar o produto no arraylist
        Produto produto = procurarProduto(p.getCodigo());
        
        produto.setNome(p.getNome());
        produto.setUnidade(p.getUnidade());
        produto.setEstoqueMinimo(p.getEstoqueMinimo());
        produto.setQuantidadeEstoque(p.getQuantidadeEstoque());
        produto.setValorAquisicao(p.getValorAquisicao());
        produto.setCustoUnitario(p.getCustoUnitario());
        produto.setCustoTotal(p.getCustoTotal());
        
        gravarArquivo();
    }
    
    public void removerProduto(Produto p){
        Produto produto = procurarProduto(p.getCodigo());
        produtos.remove(produto);
        gravarArquivo();
    }
        

    private void gravarArquivo() {
        File f = new File(ARQUIVO_DE_PRODUTOS);

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);

            for (Produto c : produtos) {
                bw.write(c.getNome() + ";" + c.getUnidade() + ";" + c.getCodigo() + ";" + c.getEstoqueMinimo() + ";" + c.getQuantidadeEstoque()
                        + ";" + c.getValorAquisicao() + ";" + c.getCustoUnitario() + ";" + c.getCustoTotal());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        File f = new File(ARQUIVO_DE_PRODUTOS);

        FileReader fr = null;
        BufferedReader br = null;

        try {
            if (!f.exists()) {
                f.createNewFile();
            }

            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                Produto produto = new Produto(dados[0], dados[1], Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Integer.parseInt(dados[4]),
                        Double.parseDouble(dados[5]), Double.parseDouble(dados[6]), Double.parseDouble(dados[7]));
                produtos.add(produto);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
