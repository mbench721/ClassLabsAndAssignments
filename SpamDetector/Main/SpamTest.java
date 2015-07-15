import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;


public class SpamTest {

	@Test
	public void testCreatingEmail(){
		Email mail = new Email("jcummings@neumont.edu","bob@neumont.edu", "Howdy, stranger!","What do you think of this new email system?");
		//
		assertEquals("jcummings@neumont.edu",mail.getTo());
		assertEquals("bob@neumont.edu",mail.getFrom());
		assertEquals("Howdy, stranger!",mail.getSubject());
		assertEquals("What do you think of this new email system?",mail.getContent());

		File initialFile = new File("Main/email.txt");
		try {
			InputStream targetStream = new FileInputStream(initialFile);
			Email test = new Email(targetStream);
		} catch (IOException e) {
			System.out.println("Invalid Message");
			e.printStackTrace();
		}
		finally{
			
		}

	}

	@Test
	public void testIsSpam() {
		File initialFile = new File("Main/antispam-table.txt");
		try {
			InputStream targetStream = new FileInputStream(initialFile);
			SpamDetector test = new SpamDetector(targetStream);
			Email mail = new Email("jcummings@neumont.edu","bob@neumont.edu", "Howdy, stranger!","What do you think of this new email system?");
			test.isSpam(mail);
			assertFalse(test.isSpam(mail)); // email should have been false and was
		} catch (IOException e) {
			System.out.println("Invalid Message");
			e.printStackTrace();
		}
		finally{
			
		}
	}
}
