package time;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.Date;

public class Time {

    //VITORIA não sei se o método toSecs está certo, se o professor quer uma método
    //específico, nem sei se existe, mas dá no mesmo. Acredito que esses exercícios
    //estão corretos. Eu só nao testei, se der tempo eu posso testar, mas ai ce me avisa. <3

    private int hora;
    private int minuto;
    private int segundo;

    //Construtor
    public Time(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    // transforma o horário em segundos desde 0:00:00
    private long ToSecs(){
        return hora * 3600;
    }

    //Valida
    private boolean Validate(){
        try {
            LocalTime.of(hora, minuto, segundo);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    // Exibe o horário na tela no formato hh:mm:ss.
    public void Put(){
        System.out.println(LocalTime.of(hora, minuto, segundo));
    }

    // retorna seu componente de horas
    public int Hour(){
        return LocalTime.of(hora, minuto, segundo).getHour();

    }

    // retorna seu componente minutos
    public int Min(){
       return LocalTime.of(hora, minuto, segundo).getMinute();
    }

    // retorna seu componente segundos
    public int Sec(){
        return LocalTime.of(hora, minuto,segundo).getSecond();
    }

    // soma com horas, resulta Time
    public Time Add(int hrs){
        LocalTime horas = LocalTime.of(hora, minuto, segundo);
        int horasAdicionadas  = horas.plusHours(hrs).getHour();

        return new Time(horasAdicionadas, minuto, segundo);
    }

    // subtrai horas, resulta Time
    public Time Sub(int hrs){
        LocalTime horas = LocalTime.of(hora, minuto, segundo);
        int horasAdicionadas  = horas.minusHours(hrs).getHour();

        return new Time(horasAdicionadas, minuto, segundo);
    }

    // subtrai Time, resulta horas
    public int Sub(Time tm){
        Time time = new Time(hora, minuto, segundo);
        time.Sub(tm);
        return time.Hour();
    }
}
