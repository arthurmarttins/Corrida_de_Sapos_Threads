package view;

import java.util.List;

import model.Sapo;

public class CorridaSaposView {
    public void exibirCorrida(List<Sapo> sapos) {
        System.out.println("Corrida de Sapos\n");

        for (Sapo sapo : sapos) {
            System.out.println(sapo.getName());
        }
        System.out.println();

        while (!corridaFinalizada(sapos)) {
            for (Sapo sapo : sapos) {
            	StringBuilder progresso = new StringBuilder();
            	int hyphens = sapo.getDistance();
            	for (int i = 0; i < hyphens; i++) {
            	    progresso.append("-");
            	}
            	progresso.append("🐸"); // Caractere de sapo
            	System.out.println(progresso);
            }

            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Corrida finalizada!");

        Sapo vencedor = determinarVencedor(sapos);
        if (vencedor != null) {
            System.out.println(vencedor.getName() + " gritou 🐸: IHHUP EU VENCI, SEUS LERDOS!");
        } else {
            System.out.println("Nenhum sapo completou a corrida.");
        }
    }

    private boolean corridaFinalizada(List<Sapo> sapos) {
        for (Sapo sapo : sapos) {
            if (sapo.getDistance() >= Sapo.MAX_DISTANCE) {
                return true;
            }
        }
        return false;
    }

    private Sapo determinarVencedor(List<Sapo> sapos) {
        Sapo vencedor = null;
        int maxHyphens = -1;

        for (Sapo sapo : sapos) {
            int hyphens = sapo.getDistance();
            if (hyphens > maxHyphens) {
                maxHyphens = hyphens;
                vencedor = sapo;
            }
        }

        return vencedor;
    }

    
    
}
