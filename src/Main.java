
import java.util.ArrayList;

// clase que representa una canción
class Cancion {

    // atributos
    private String titulo;
    private String artista;
    private String genero;
    private int duracion;

    // constructor
    public Cancion(String titulo, String artista,
                   String genero, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
    }

    // método para mostrar la información de la canción
    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Artista: " + artista);
        System.out.println("Género: " + genero);
        System.out.println("Duración: " + duracion + " segundos");
    }

    // método para obtener el título
    public String getTitulo() {
        return titulo;
    }
}

// clase que representa una playlist
class Playlist {

    // atributos
    private String nombre;
    private ArrayList<Cancion> canciones;

    // Constructor
    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    // Método para agregar canciones
    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);

        System.out.println("Se agregó \""
                + cancion.getTitulo()
                + "\" a la playlist " + nombre);
    }

    // Método para mostrar las canciones de la playlist
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

// clase principal
public class Main {

    public static void main(String[] args) {

        // Crear canciones
        Cancion cancion1 = new Cancion(
                "the cure", "Olvia Rodrigo", "Pop", 247
        );

        Cancion cancion2 = new Cancion(
                "Lateralus", "Tool",
                "Metal progresivo", 363
        );

        Cancion cancion3 = new Cancion(
                "A Forest", "The Cure",
                "Post Punk", 240
        );

        // mostrar el catálogo
        System.out.println("=== CATÁLOGO MUSICAL ===\n");

        cancion1.mostrarInformacion();

        System.out.println("\n----------------------\n");

        cancion2.mostrarInformacion();

        System.out.println("\n----------------------\n");

        cancion3.mostrarInformacion();

        // Crear una playlist
        Playlist playlist1 = new Playlist("Favoritas");

        // Agregar canciones a la playlist
        System.out.println("\n=== CREANDO PLAYLIST ===");

        playlist1.agregarCancion(cancion1);
        playlist1.agregarCancion(cancion2);
        playlist1.agregarCancion(cancion3);

        // Mostrar la playlist
        System.out.println("\n=== CONTENIDO DE LA PLAYLIST ===");

        playlist1.mostrarPlaylist();
    }
}
