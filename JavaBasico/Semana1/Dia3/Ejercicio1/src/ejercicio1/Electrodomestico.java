package ejercicio1;


public class Electrodomestico {
    
    private String cod,marca,modelo,consumo,color;
    
    public Electrodomestico(){
        
    }
    
    public Electrodomestico(String cod,String marca,String modelo,String consumo,String color){
        this.cod=cod;
        this.marca=marca;
        this.modelo=modelo;
        this.consumo=consumo;
        this.color=color;
    }

    public String getCod() {
        return cod;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getConsumo() {
        return consumo;
    }

    public String getColor() {
        return color;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" + "cod=" + cod + ", marca=" + marca + ", modelo=" + modelo + ", consumo=" + consumo + ", color=" + color + '}';
    }
    
}
