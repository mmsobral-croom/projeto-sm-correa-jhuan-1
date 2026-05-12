
package sm;

public class CestaMercado implements Comparable<CestaMercado> {
    private String nome;
    private float total;

    public CestaMercado(String nome, float total) {
        this.nome = nome;
        this.total = total;
    }

    @Override
    public int compareTo(CestaMercado outro) {
        return Float.compare(this.total, outro.total);
    }

    @Override
    public String toString() {
        return String.format("%-15s | R$ %.2f", nome, total);
    }
}
