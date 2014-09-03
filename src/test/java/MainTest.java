import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MainTest {

    @Rule
    public TextFromStandardInputStream systemInMock =
            TextFromStandardInputStream.emptyStandardInputStream();
    @Rule
    public StandardOutputStreamLog systemOutMock = new StandardOutputStreamLog();

    @Test
    public void testMain() throws Exception {
        systemInMock.provideText("2");

        Main.main();

        assertThat(systemOutMock.getLog(), is("4\n"));
    }

}