package calculadoraejb;

import jakarta.ejb.Remote;

@Remote
public interface CalculadoraIF {

    public int somar(int a, int b);
}
