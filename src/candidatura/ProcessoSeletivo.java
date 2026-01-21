package candidatura;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class ProcessoSeletivo {

    public static void main(String[] args) {
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

        // Entrar em contato com cada candidato
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }

        // Imprimir os candidatos selecionados
        imprimirSelecionados();

        // Processo de seleção de candidatos
        selecaoCandidatos();
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean atendeu = false;

        while (tentativasRealizadas <= 3 && !atendeu) {
            atendeu = atender();
            if (atendeu) {
                System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + "ª TENTATIVA");
            } else {
                tentativasRealizadas++;
            }
        }

        if (!atendeu) {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " - NÚMERO MÁXIMO DE TENTATIVAS: " + (tentativasRealizadas - 1));
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados() {
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

        System.out.println("\nImprimindo a lista de candidatos informando o índice:");
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("Índice " + i + ": " + candidatos[i]);
        }

        System.out.println("\nForma abreviada de iteração com for-each:");
        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {
                "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO",
                "MONICA", "PEDRO", "BIANCA", "GABRIELA", "JOAO"
        };

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("\nO candidato " + candidato + " solicitou este valor de salário: R$ " + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            } else {
                System.out.println("O candidato " + candidato + " não foi selecionado");
            }

            analisarCandidato(salarioPretendido);

            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
