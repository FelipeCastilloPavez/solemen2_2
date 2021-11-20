package OBJETOS;

public class lista_precios {
    private String[] cortes = {"Corte+barba","limpieza facial","corte+barba+limpieza"};
    private int[] precios ={ 10000, 5000, 15000};


    public lista_precios(){

    }

    public lista_precios(String[] cortes, int[] precios, int stock) {
        this.cortes = cortes;
        this.precios = precios;

    }

    public String[] getCortes() {
        return cortes;
    }

    public void setCortes(String[] cortes) {
        this.cortes = cortes;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }



}
