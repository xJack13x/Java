package student;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jacek
 */
public class StudentTest {
    

    @Test
    public void shouldBeAbleToCreateStudent()
    {
        Student s=new Student("Jan","Kowalski","D12333");
        assertEquals(s.getName(), "Jan");
        assertEquals(s.getSurname(), "Kowalski");
        assertEquals(s.getNrId(), "D12333");
    }
    
}
