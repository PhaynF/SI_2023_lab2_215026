import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    public void EveryBranch() {
        RuntimeException ex;

        User u1= new User(null,"12345678@","user@email.com");
        User u2= new User("12345678@","1234568@","user@email.com");
        ArrayList<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        ex = assertThrows(RuntimeException.class,()->SILab2.function(null,users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        assertEquals(SILab2.function(u1,users),false);
        assertEquals(SILab2.function(u2,users),false);
        assertEquals(SILab2.function(new User("12345678@","12345678","user@email.com"),users),false);
        assertEquals(SILab2.function(new User("12345678@","1234567 8","useremailcom"),users),false);
    }
    @Test
    public void MultipleCondition(){
        RuntimeException ex;
        User u1 = new User("Filip","12345678@","filip@email.com");
        User u2 = new User("Phayn","followmeoninsta","phaynarts@instagram.com");
        ArrayList<User> users = new ArrayList<>();
        users.add(u1); users.add(u2);

        // T||T||T-user=null
        ex=assertThrows(RuntimeException.class,()->SILab2.function(null,users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // F||T||T user(Filip,null,null)
        ex=assertThrows(RuntimeException.class,()->SILab2.function(new User("Filip",null,null),users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //F||F||T user(Filip,password123,null)
        ex=assertThrows(RuntimeException.class,()->SILab2.function(new User("Filip","12345678",null),users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // ALL FALSE
        assertEquals(SILab2.function(new User("Filip","password123","filip@email.com"),users),false);
    }
}