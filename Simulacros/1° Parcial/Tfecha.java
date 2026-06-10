public class Tfecha {
    private int dia;
    private int mes;
    private int anio;
    
    public Tfecha(int d, int f, int a){
        this.dia = d;
        this.mes = f;
        this.anio = a;
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAnio() {
        return this.anio;
    }

    public boolean esBisiesto() {
        boolean esBisiesto = esBisiesto(this.anio);
        return esBisiesto;
    }

    public static boolean esBisiesto(int unAnio) {
        boolean esBisiesto = false;

        if ((unAnio % 4 == 0 && unAnio % 100 != 0) || unAnio % 400 == 0) {
            esBisiesto = true;
        }

        return esBisiesto;
    }

    public static boolean esValido(int unDia, int unMes, int unAnio){
        int[] diasMes = {31,28,31,30,31,30,31,31,30,31,30,31};
        boolean esValido = true;

        if (esBisiesto(unAnio)) {
            diasMes[1] = 29;
        }
        if (!(unMes > 0 && unMes <= 12) || (unDia > diasMes[unMes - 1])){
            esValido = false;
        }
        
        return esValido;
    }

    // devuelve la diferencia de días entre las fechas
    // devuelve un número negativo si la fecha receptora está después de la fecha this
    // suma la cantidad de días que transcurrieron en su año (depende de si es bisiesto o no)
    // resta la suma con otra suma de días en el año de la fecha receptora
    public int difDias(Tfecha unaFecha) {
        int[] diasMes = {31,28,31,30,31,30,31,31,30,31,30,31};
        int resultado = 0, i, auxMayMes = 0, auxMinMes = 0, auxMinDia = 0, auxMayDia = 0;

        if (unaFecha.getMes() > this.mes) {
            auxMinMes = this.mes;
            auxMayMes = unaFecha.getMes();
        } else {
            auxMinMes = unaFecha.getMes();
            auxMayMes = this.mes;
        }

        if (unaFecha.getDia() > this.dia) {
            auxMinDia = this.dia;
            auxMayDia = unaFecha.getDia();
        } else {
            auxMinDia = unaFecha.getDia();
            auxMinDia = this.dia;
        }

        for (i = auxMinMes - 1; i < auxMayMes - 1; i++) {
            resultado += diasMes[i];
        }

        resultado += auxMayDia - auxMinDia + 365 * (this.getAnio() - unaFecha.getAnio());

        // la diferencia entre los años debe considerar los años bisiestos
        for (int j = 0; j < this.getAnio() - unaFecha.getAnio(); j++) {
            
        }
        
        // main:
        // fecha1 = new Tfecha(27, 2, 2026)
        // fecha2 = new Tfecha(24, 4, 2026)
        // fecha2.difDias(fecha1) --> cantidad de días de diferencia entre las fechas
       

        return resultado;
    }
}




// when rindes cálculo but desapruebas ¨ eso no me lo esperaba:,V
// ⢀⡴⠑⡄⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ 
// ⠸⡇⠀⠿⡀⠀⠀⠀⣀⡴⢿⣿⣿⣿⣿⣿⣿⣿⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀ 
// ⠀⠀⠀⠀⠑⢄⣠⠾⠁⣀⣄⡈⠙⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀ 
// ⠀⠀⠀⠀⢀⡀⠁⠀⠀⠈⠙⠛⠂⠈⣿⣿⣿⣿⣿⠿⡿⢿⣆⠀⠀⠀⠀⠀⠀⠀ 
// ⠀⠀⠀⢀⡾⣁⣀⠀⠴⠂⠙⣗⡀⠀⢻⣿⣿⠭⢤⣴⣦⣤⣹⠀⠀⠀⢀⢴⣶⣆ 
// ⠀⠀⢀⣾⣿⣿⣿⣷⣮⣽⣾⣿⣥⣴⣿⣿⡿⢂⠔⢚⡿⢿⣿⣦⣴⣾⠁⠸⣼⡿ 
// ⠀⢀⡞⠁⠙⠻⠿⠟⠉⠀⠛⢹⣿⣿⣿⣿⣿⣌⢤⣼⣿⣾⣿⡟⠉⠀⠀⠀⠀⠀ 
// ⠀⣾⣷⣶⠇⠀⠀⣤⣄⣀⡀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ 
// ⠀⠉⠈⠉⠀⠀⢦⡈⢻⣿⣿⣿⣶⣶⣶⣶⣤⣽⡹⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ 
// ⠀⠀⠀⠀⠀⠀⠀⠉⠲⣽⡻⢿⣿⣿⣿⣿⣿⣿⣷⣜⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ 
// ⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣷⣶⣮⣭⣽⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀ 
// ⠀⠀⠀⠀⠀⠀⣀⣀⣈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀ 
// ⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀ 
// ⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀ 
// ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠻⠿⠿⠿⠿⠛⠉ ¨