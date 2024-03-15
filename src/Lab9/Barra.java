package Lab9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class Barra implements Runnable {

    private JProgressBar jp_barra;
    private JTextArea jt_area;
    private File dato;
    private boolean correr;

    public Barra(JProgressBar jp_barra, JTextArea jt_area, File dato) {
        this.jp_barra = jp_barra;
        this.jt_area = jt_area;
        this.dato = dato;
        this.correr = correr;
    }

    @Override
    public void run() {
        int progreso = 0;
        while (progreso <= 100) {
            jp_barra.setValue(progreso);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progreso += 2;
        }
        cargarArchivo();
    }

    public void cargarArchivo() {
        if (dato != null && jt_area != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(dato))) {
                StringBuilder contenidoArchivo = new StringBuilder();
                String cargar;
                while ((cargar = br.readLine()) != null) {
                    contenidoArchivo.append(cargar).append("\n");
                }

                jt_area.setText(contenidoArchivo.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
