package str.threads.pkg1;

// @author Isabela Canelas Ett - RA00303107

public class ThreadInt extends Thread {
    private int indexInicio;
    private int indexFim;
    private SomadorVetor sv;
    private int[] vetor;
    private long soma;
    
    public ThreadInt(int indexInicio, int indexFim, SomadorVetor sv, int[] vetor) {
        this.indexInicio = indexInicio;
        this.indexFim = indexFim;
        this.sv = sv;
        this.vetor = vetor;
        this.soma = 0;
    }

    @Override
    public void run() {
        this.sv.preencherVetorInteiro(this.vetor, this.indexInicio, this.indexFim);
        this.soma = this.sv.somarInteiros(this.vetor, this.indexInicio, this.indexFim);
        
        //System.out.println("Thread Int: " + this.getId() + ", indexInicio: " + this.indexInicio + ", indexFim: "+ this.indexFim + ", soma: " + this.soma);
    }
    
    public long getSoma(){
        return this.soma;
    }
}