public class Poster {
    private int idFilm;
    private String titleFilm;
    private String genre;
    private DatePremiere date;

    public Poster(int idFilm, String titleFilm, String genre, DatePremiere date) {
        this.idFilm = idFilm;
        this.titleFilm = titleFilm;
        this.genre = genre;
        this.date = date;
    }
}
