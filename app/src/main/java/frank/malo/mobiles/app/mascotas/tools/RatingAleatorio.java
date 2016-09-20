package frank.malo.mobiles.app.mascotas.tools;

/**
 * Created by Frank on 20/09/2016.
 */
public class RatingAleatorio {
    public static int generarAleatorio(int inicio, int fin){
        return  ((int)(Math.random()*(fin - inicio))+inicio);
    }
}
