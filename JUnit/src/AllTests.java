import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestMovieListWithEmptyList.class,
	TestMovieListWithOneMovie.class,
	TestMovieListWithTwoMovies.class
})

public class AllTests{
}
