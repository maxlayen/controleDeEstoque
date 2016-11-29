package Models;

public class Produto {
    
    private String nome;
    private String unidade;
    private int codigo;
    private int estoqueMinimo;
    private int quantidadeEstoque;
    private double valorAquisicao;
    private double custoUnitario;
    private double custoTotal;
    

    public Produto(String nome, String unidade, int codigo, int estoqueMinimo, int quantidadeEstoque, double valorAquisicao, double custoUnitario, double custoTotal) {
        this.nome = nome;
        this.unidade = unidade;
        this.codigo = codigo;
        this.estoqueMinimo = estoqueMinimo;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valorAquisicao = valorAquisicao;
        this.custoUnitario = custoUnitario;
        this.custoTotal = custoTotal;
        
    }
    
    public Produto(){
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }


    public double getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(double valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public double getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(double custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }
    
    
    
}
