package str.threads.pkg1;

// @author Isabela Canelas Ett - RA00303107

public class STRThreads1 {
    public static void main(String[] args) {
        int tamanhoVetor = 100_000_000;
        SomadorVetor sv = new SomadorVetor();
        
        for (int i=0; i<=6; i++) {
            int numeroThreads = potenciaDeDois(i);
            
            System.out.println("\nNúmero de Threads: " + numeroThreads);
            
            somarInteiros(sv, numeroThreads, tamanhoVetor);
            somarFloats(sv, numeroThreads, tamanhoVetor);
            
            System.out.println("=======================================");
        }
    };
    
    
    static void somarInteiros (SomadorVetor sv, int numeroThreads, int tamanhoVetor){
        long tempoInicial = System.currentTimeMillis();

        ThreadInt vetorThreadsInt[] = new ThreadInt[numeroThreads];
        int vetorInt[] = new int[tamanhoVetor];

        int mediaDeItens = tamanhoVetor / numeroThreads;
        int indexInicio = 0;
        int indexFim = mediaDeItens;
        
        for (int i=0; i<numeroThreads; i++) {
            if (i == numeroThreads - 1) { indexFim = tamanhoVetor; } //Proteção para garantir que sempre pegará todas as posições do vetor
            
            ThreadInt newThread = new ThreadInt(indexInicio, indexFim, sv, vetorInt);
            vetorThreadsInt[i] = newThread;
            
            newThread.start();
            
            indexInicio = indexFim;
            indexFim += mediaDeItens;
        }
        
        long somaInt = 0;
        for (ThreadInt thread : vetorThreadsInt) {
            if (thread.isAlive()) {
                try { thread.join();
                } catch(InterruptedException e) {
                    System.out.println("Algo deu errado na execução da ThreadInt" + thread.getId() + e);
                    return;
                }
            }
            
            somaInt += thread.getSoma();
        }
        
        long tempoFinal = System.currentTimeMillis();
        long tempoDeExecucao = tempoFinal - tempoInicial;
        
        System.out.println("\nSoma Int: " + somaInt);
        System.out.println("Executou em " + tempoDeExecucao + " ms");
       
        vetorInt = null;
        vetorThreadsInt = null;
    }
    
    static void somarFloats (SomadorVetor sv, int numeroThreads, int tamanhoVetor) {
        long tempoInicial = System.currentTimeMillis();
        
        ThreadFloat vetorThreadsFloat[] = new ThreadFloat[numeroThreads];
        float vetorFloat[] = new float[tamanhoVetor];

        int mediaDeItens = tamanhoVetor / numeroThreads;
        int indexInicio = 0;
        int indexFim = mediaDeItens;
        
        for (int i=0; i<numeroThreads; i++) {
            if (i == numeroThreads - 1) { indexFim = tamanhoVetor; } //Proteção para garantir que sempre pegará todas as posições do vetor

            ThreadFloat newThread = new ThreadFloat(indexInicio, indexFim, sv, vetorFloat);
            vetorThreadsFloat[i] = newThread;
            
            // System.out.println("Thread Float: " + i + ", indexInicio: " + indexInicio + ", indexFim: "+ indexFim);
            
            newThread.start();
            
            indexInicio = indexFim;
            indexFim += mediaDeItens;
        }
        
        double somaFloat = 0;
        for (ThreadFloat thread : vetorThreadsFloat) {
            if (thread.isAlive()) {
                try { thread.join();
                } catch(InterruptedException e) {
                    System.out.println("Algo deu errado na execução da ThreadFloat" + thread.getId() + e);
                    return;
                }
            }
            somaFloat += thread.getSoma();
        }
        
        long tempoFinal = System.currentTimeMillis();
        long tempoDeExecucao = tempoFinal - tempoInicial;
        
        System.out.println("\nSoma Float: " + somaFloat);
        System.out.println("Executou em " + tempoDeExecucao + " ms\n");
        
        vetorFloat = null;
        vetorThreadsFloat = null;
    }
    
    static int potenciaDeDois (int expoente) {
        int resultado = 1;
        
        for (int i=0; i<expoente; i++) {
            resultado *= 2;
        }
        
        return resultado;
    }
}
