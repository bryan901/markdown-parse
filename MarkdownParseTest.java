import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testMarkdownParse() throws IOException{
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://something.com", "some-page.html"), links);
    }
    @Test
    public void testMarkdownParse2() throws IOException{
        Path fileName = Path.of("test-file-2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("something.com"), links);
    }
    @Test
    public void testMarkdownParse3() throws IOException{
        Path fileName = Path.of("test-file-3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("rsgrs.com", "rrs.com", "rs.com"), links);
    }
    @Test
    public void testMarkdownParse4() throws IOException{
        Path fileName = Path.of("test-file-4.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of(), links);
    }
}