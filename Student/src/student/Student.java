package student;

/**
 *
 * @author Jacek
 */
public class Student {
    String name, surname, nrId;

    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public String getNrId(){
        return nrId;
    }
    
    public Student(String name, String surname, String nrId)
    {
        this.name = name;
        this.surname = surname;
        this.nrId = nrId;
    }
    public static void main(String[] args) {
    }    
}
