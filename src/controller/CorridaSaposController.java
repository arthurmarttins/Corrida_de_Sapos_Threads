package controller;

import java.util.ArrayList;
import java.util.List;

import model.Sapo;
import view.CorridaSaposView;

public class CorridaSaposController {
    private static final int NUM_SAPOS = 3;

    private List<Sapo> sapos;
    private CorridaSaposView view;

    public CorridaSaposController() {
        sapos = new ArrayList<>();
        view = new CorridaSaposView();
    }

    public void iniciarCorrida() {
        for (int i = 0; i < NUM_SAPOS; i++) {
            Sapo sapo = new Sapo("Sapo " + (i + 1));
            sapos.add(sapo);

            Thread thread = new Thread(sapo);
            thread.start();
        }

        view.exibirCorrida(sapos);
    }

    public static void main(String[] args) {
        CorridaSaposController controller = new CorridaSaposController();
        controller.iniciarCorrida();
    }
}
