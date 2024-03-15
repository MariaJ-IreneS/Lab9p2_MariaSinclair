package Lab9;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class Fecha_Hora implements Runnable {

    private JLabel hora, fecha;

    public Fecha_Hora(JLabel hora, JLabel fecha) {
        this.hora = hora;
        this.fecha = fecha;
    }

    public void run() {
        while (true) {
            Date hour = new Date();
            DateFormat fech = new SimpleDateFormat("hh:mm:ss");
            DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            hora.setText(fech.format(hour));
            fecha.setText(date.format(hour));
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {

            }
        }
    }

}
