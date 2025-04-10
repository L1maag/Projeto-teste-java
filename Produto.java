public class Produto {

    private String nome;
    private double preco;
    private int quantidadeEstoque;
    private boolean disponivel;

    public Produto(String nome, double preco, int quantidadeEstoque, boolean disponivel) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.disponivel = disponivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void venderProduto(int quantidade) {
        if (disponivel && quantidade <= quantidadeEstoque) {
            quantidadeEstoque -= quantidade;
            System.out.println(quantidade + " unidade(s) vendida(s) de " + nome);
        } else {
            System.out.println("Venda não realizada. Produto indisponível ou estoque insuficiente.");
        }
    }

    public void reporEstoque(int quantidade) {
        quantidadeEstoque += quantidade;
        System.out.println(quantidade + " unidade(s) reposta(s) de " + nome);
    }

    public void aplicarDesconto(double percentual) {
        preco -= preco * (percentual / 100);
        System.out.println("Desconto de " + percentual + "% aplicado em " + nome);
    }

    public String exibirDetalhes() {
        return "Produto: " + nome +
                "\nPreço: R$ " + preco +
                "\nEstoque: " + quantidadeEstoque +
                "\nDisponível: " + (disponivel ? "Sim" : "Não");
    }
}

