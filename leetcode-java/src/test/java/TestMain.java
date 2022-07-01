import dwd.Solution;
import org.junit.jupiter.api.Test;

public class TestMain {

    @Test
    public void Test01(){
       Solution s =  new Solution();

        System.out.println(s.divide(-2147483648,2));
    }
}
