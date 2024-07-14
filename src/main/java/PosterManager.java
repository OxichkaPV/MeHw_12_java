public class PosterManager {
    private Poster[] films = new Poster[0];
    private int limit;

    public PosterManager() {
        this.limit = 5;
    }

    public PosterManager(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return this.limit;
    }

    public void addNewFilm(Poster item) {
        Poster[] tmp = new Poster[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = item;
        films = tmp;
    }

    public Poster[] findAll() {
        return films;
    }

    public Poster[] findLast() {
        int tmpLength;
        if (films.length < limit) {
            tmpLength = films.length;
        } else {
            tmpLength = limit;
        }
        Poster[] lastTmp = new Poster[tmpLength];
        for (int i = 0; i < tmpLength; i++) {
            lastTmp[i] = films[films.length - 1 - i];
        }
        return lastTmp;
    }
}
