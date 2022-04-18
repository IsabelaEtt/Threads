package str.threads.pkg1;

// @author Isabela Canelas Ett - RA00303107

public class SomadorVetor {
    long somarInteiros(int[] vetor, int indexInicio, int indexFim) {
        if (vetor == null) {
            return 0;
        }
        
        if (vetor.length == 0) {
            return 0;
        }
        
        long soma = 0;
        for (int i = indexInicio; i < indexFim; i++) {
            soma += vetor[i];
        }
        
        return soma;
    }

    double somarFloats(float[] vetor, int indexInicio, int indexFim) {
        if (vetor == null) {
            return 0;
        }
        
        if (vetor.length == 0) {
            return 0;
        }
        
        double soma = 0;
        for (int i = indexInicio; i < indexFim; i++) {
            soma += vetor[i];
        }
        
        return soma;
    }

    void preencherVetorInteiro(int[] vetor, int indexInicio, int indexFim) {
        if (vetor == null) {
            return;
        }
        
        if (vetor.length == 0) {
            return;
        }

        for (int i = indexInicio; i < indexFim; i++) {
            vetor[i] = i;
        }
    }

    void preencherVetorFloat(float[] vetor, int indexInicio, int indexFim) {
        if (vetor == null) {
            return;
        }
        
        if (vetor.length == 0) {
            return;
        }

        for (int i = indexInicio; i < indexFim; i++) {
            vetor[i] = i;
        }
    }
}
