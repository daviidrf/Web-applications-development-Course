package pokemon_go;

public interface Operaciones {
    public void cazar_Pokemon(Usuario usuario_actual);
    public void listarMochila(Usuario usuario_actual);
    public void transferir_Pokemon(Usuario usuario_actual);
    public void recibir_Pokemon(Usuario usuario_actual);
    public void mostrarRecord();
    public void evolucionar_Pokemon(Usuario usuario_actual);
}
