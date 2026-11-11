import java.util.ArrayList;

// CLASE BASE
class Cancion {

    // atributos protegidos para que las clases hijas puedan utilizarlos
    protected String titulo;
    protected String artista;
    protected String genero;
    protected int duracion;

    // Constructor
    public Cancion(String titulo, String artista,
                   String genero, int duracion) {

        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
    }

    // metodo que puede ser heredado o sobrescrito
    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Artista: " + artista);
        System.out.println("Género: " + genero);
        System.out.println("Duración: " + duracion + " segundos");
    }

    public String getTitulo() {
        return titulo;
    }
}

// CLASE DERIVADA: Cancion Pop
class CancionPop extends Cancion {

    private String ranking;

    public CancionPop(String titulo, String artista,
                      String genero, int duracion,
                      String ranking) {

        // llamada al constructor de la clase base
        super(titulo, artista, genero, duracion);
        this.ranking = ranking;
    }

    //sobrescritura del metodo de la clase base
    @Override
    public void mostrarInformacion() {

        super.mostrarInformacion();

        System.out.println("Ranking: " + ranking);
    }

    // Metodo exclusivo de la subclase
    public void mostrarPopularidad() {
        System.out.println(
                titulo + " se encuentra en el ranking "
                        + ranking);
    }
}

// CLASE DERIVADA: Canción Rock
class CancionRock extends Cancion {

    private boolean guitarraSolo;

    public CancionRock(String titulo, String artista,
                       String genero, int duracion,
                       boolean guitarraSolo) {

        super(titulo, artista, genero, duracion);
        this.guitarraSolo = guitarraSolo;
    }

    // Sobrescritura del método de la clase base
    @Override
    public void mostrarInformacion() {

        super.mostrarInformacion();

        System.out.println("Tiene solo de guitarra: "
                + (guitarraSolo ? "Sí" : "No"));
    }

    // Método exclusivo de la subclase
    public void tocarSolo() {
        System.out.println(
                titulo + " incluye un solo de guitarra destacado.");
    }
}

// Clase Playlist
class Playlist {

    private String nombre;
    private ArrayList<Cancion> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {

        canciones.add(cancion);

        System.out.println("Se agregó \""
                + cancion.getTitulo()
                + "\" a la playlist "
                + nombre);
    }

    public void mostrarPlaylist() {

        System.out.println("\nPlaylist: " + nombre);

        if (canciones.isEmpty()) {
            System.out.println("La playlist está vacía.");
            return;
        }

        for (Cancion cancion : canciones) {
            System.out.println("- " + cancion.getTitulo());
        }
    }
}

// CLASE PRINCIPAL
public class Main {

    public static void main(String[] args) {

        // Objetos de las clases derivadas
        CancionPop cancion1 = new CancionPop(
                "The Cure",
                "Olivia Rodrigo",
                "Pop",
                247,
                "Top 10"
        );

        CancionRock cancion2 = new CancionRock(
                "Lateralus",
                "Tool",
                "Metal Progresivo",
                363,
                true
        );

        CancionRock cancion3 = new CancionRock(
                "A Forest",
                "The Cure",
                "Post Punk",
                240,
                false
        );

        System.out.println("=== CATÁLOGO MUSICAL ===\n");

        cancion1.mostrarInformacion();

        System.out.println("\n-------------------\n");

        cancion2.mostrarInformacion();

        System.out.println("\n-------------------\n");

        cancion3.mostrarInformacion();

        // Uso de métodos exclusivos
        System.out.println("\n=== MÉTODOS PROPIOS DE LAS SUBCLASES ===");

        cancion1.mostrarPopularidad();
        cancion2.tocarSolo();

        // Crear playlist
        Playlist playlist1 = new Playlist("Favoritas");

        System.out.println("\n=== CREANDO PLAYLIST ===");

        playlist1.agregarCancion(cancion1);
        playlist1.agregarCancion(cancion2);
        playlist1.agregarCancion(cancion3);

        System.out.println("\n=== CONTENIDO DE LA PLAYLIST ===");

        playlist1.mostrarPlaylist();
    }
}