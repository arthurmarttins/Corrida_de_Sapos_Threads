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
                int distance = sapo.getDistance();
                for (int i = 0; i < distance; i++) {
                    progresso.append("-");
                }
                progresso.append(sapo.getName());
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
        System.out.println("Sapo vencedor: " + determinarVencedor(sapos).getName());
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
        Sapo vencedor = sapos.get(0);
        for (int i = 1; i < sapos.size(); i++) {
            Sapo sapo = sapos.get(i);
            if (sapo.getDistance() > vencedor.getDistance()) {
                vencedor = sapo;
            }
        }
        return vencedor;
    }
}
