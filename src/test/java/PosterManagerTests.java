import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PosterManagerTests {
    PosterManager manager = new PosterManager();

    Poster item1 = new Poster(1, "Бладшот", "боевик", new DatePremiere(12, 3, 2024));
    Poster item2 = new Poster(2, "Вперед", "мультфильм", new DatePremiere(5, 3, 2024));
    Poster item3 = new Poster(3, "Отель Белград", "комедия", new DatePremiere(5, 3, 2024));
    Poster item4 = new Poster(4, "Джентельмены", "боевик", new DatePremiere(13, 2, 2024));
    Poster item5 = new Poster(5, "Человек-невидимка", "ужасы", new DatePremiere(5, 3, 2024));
    Poster item6 = new Poster(6, "Тролли. Мировой тур.", "мультфильм", new DatePremiere(19, 3, 2024));

    @BeforeEach
    public void setup() {
        manager.addNewFilm(item1);
        manager.addNewFilm(item2);
        manager.addNewFilm(item3);
        manager.addNewFilm(item4);
        manager.addNewFilm(item5);
    }

    @Test
    public void getAllFilms() {
        Poster[] expected = {item1, item2, item3, item4, item5};
        Poster[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addFilmInPoster() {
        Poster[] expected = {item1, item2, item3, item4, item5, item6};
        manager.addNewFilm(item6);
        Poster[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getFiveLastFilms() {
        Poster[] expected = {item5, item4, item3, item2, item1};
        Poster[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getLimitLastFilms() {
        PosterManager mng = new PosterManager(3);
        mng.addNewFilm(item1);
        mng.addNewFilm(item2);
        mng.addNewFilm(item3);
        mng.addNewFilm(item4);
        mng.addNewFilm(item5);
        Poster[] expected = {item5, item4, item3};
        Poster[] actual = mng.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getLengthOfArrayIsLessThanLimit() {
        PosterManager mng = new PosterManager(4);
        mng.addNewFilm(item1);
        mng.addNewFilm(item2);
        mng.addNewFilm(item3);
        Poster[] expected = {item3, item2, item1};
        Poster[] actual = mng.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getMoreLimitLastFilms() {
        PosterManager mng = new PosterManager(6);
        Poster[] expected = {item5, item4, item3, item2, item1};
        Poster[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getLimitTest() {
        int expected = 4;
        PosterManager mng = new PosterManager(4);
        int actual = mng.getLimit();
        Assertions.assertEquals(expected, actual);
    }
}
