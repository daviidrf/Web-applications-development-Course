package objetos_spotproven;

public class Cancion {

    private String titulo_cancion;
    private String interprete;
    private String album;
    private int duracion;

    /**
     * *************CONSTRUCTORES**************
     */
    public Cancion() {
        this.titulo_cancion = "";
        this.interprete = "";
        this.album = "";
        setDuracion(duracion);
    }

    public Cancion(String titulo_cancion, String interprete) {
        this.titulo_cancion = titulo_cancion;
        this.interprete = interprete;
    }

    public Cancion(String titulo_cancion, String interprete, String album, int duracion) {
        this.titulo_cancion = titulo_cancion;
        this.interprete = interprete;
        this.album = album;
        setDuracion(duracion);
    }

    /**
     * *************GETTERS I SETTERS**************
     */
    public String getTitulo_cancion() {
        return titulo_cancion;
    }

    public void setTitulo_cancion(String titulo_cancion) {
        this.titulo_cancion = titulo_cancion;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
        if (duracion > 0) {
            this.duracion = duracion;
        } else {
            this.duracion = 0;
        }
    }

    /**
     * *************FUNCIONES**************
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cancion other = (Cancion) obj;
        if (this.titulo_cancion != other.titulo_cancion && this.interprete != other.interprete) {
            return false;
        }
        return true;
    }

}
