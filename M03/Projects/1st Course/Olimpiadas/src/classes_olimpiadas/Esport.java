package classes_olimpiadas;

enum TipoDeporte {
    ATLETISMO, CICLISMO, NATACION, MARCIALES
}

public class Esport {
    TipoDeporte nom_deporte;
    Atleta[] participantes;;
    int[] medallas; 
    int cont_participantes; //Contador de atleteas de ese deporte.
}
