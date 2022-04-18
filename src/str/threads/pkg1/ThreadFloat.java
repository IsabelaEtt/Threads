package str.threads.pkg1;

// @author Isabela Canelas Ett - RA00303107

public class ThreadFloat extends Thread{
    private int indexInicio;
    private int indexFim;
    private SomadorVetor sv;
    private float[] vetor;
    private double soma;
    
    public ThreadFloat(int indexInicio, int indexFim, SomadorVetor sv, float[] vetor) {
        this.indexInicio = indexInicio;
        this.indexFim = indexFim;
        this.sv = sv;
        this.vetor = vetor;
        this.soma = 0;
    }

    @Override
    public void run() {
        this.sv.preencherVetorFloat(this.vetor, this.indexInicio, this.indexFim);
        this.soma = this.sv.somarFloats(this.vetor, this.indexInicio, this.indexFim);
        
        // System.out.println("Thread Float: " + this.getId() + ", indexInicio: " + this.indexInicio + ", indexFim: "+ this.indexFim + ", soma: " + this.soma);
    }
    
    public double getSoma(){
        return this.soma;
    }
}