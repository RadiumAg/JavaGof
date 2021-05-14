
import com.company.JavaGof.BuilderPattern.ConcreteBuilder;
import com.company.JavaGof.BuilderPattern.Director;

import javax.imageio.IIOException;


public class Main {

    public static void main(String[] args) throws IIOException {
        var builder = new ConcreteBuilder();
        var director = new Director(builder);
        var product = director.construct();
        product.show();
    }
}
