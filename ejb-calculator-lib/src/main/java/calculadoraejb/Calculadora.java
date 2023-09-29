package calculadoraejb;

import jakarta.ejb.Stateless;

@Stateless(name = "Calculadora")
public class Calculadora implements CalculadoraIF {

    @Override
    public int somar(int a, int b) {
        return a + b;
    }
}
