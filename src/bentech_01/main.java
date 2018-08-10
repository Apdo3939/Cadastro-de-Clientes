package bentech_01;

import bentech_01_Views.FrmSplash;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class main {

    //Formatar data do sistema
    public static void formatarData() {

        //formatar data
        Date dataSistema = new Date();
        SimpleDateFormat sdp = new SimpleDateFormat("ddMMyyyy");
        String data = sdp.format(dataSistema);

        //pegar a hora do sistema
        Calendar horaSistema = Calendar.getInstance();
        System.out.println(String.format("%1$tH%1$tM%1$ts" + data, horaSistema));
        
    }    
    
    public static void main(String[] args) {
        
        FrmSplash splash = new FrmSplash();
        splash.setVisible(true);
        
    }
    
}
