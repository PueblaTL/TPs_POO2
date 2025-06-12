Ejercicio: Daño de Ataques Pokémon
Supongamos que estás haciendo un sistema de combate Pokémon.
Cada ataque inflige daño de acuerdo a una serie de factores: tipo de ataque, resistencia del oponente, clima, bonificaciones especiales, etc.
Tenés la siguiente clase que calcula el daño de forma muy procedural.

 1. Refactorizar aplicando polimorfismo.
 2. Aplique Template method para quitar código duplicado.
 3. Modifique el main para que funcione de acuerdo al refactor realizado.

enum TipoAtaque {
    FUEGO,
    AGUA,
    PLANTA,
    ELECTRICO
}

class Ataque {
    public TipoAtaque tipo;
    public int poderBase;
    public boolean climaAFavor;
    public int defensaOponente;

    public Ataque(TipoAtaque tipo, int poderBase, boolean climaAFavor, int defensaOponente) {
        this.tipo = tipo;
        this.poderBase = poderBase;
        this.climaAFavor = climaAFavor;
        this.defensaOponente = defensaOponente;
    }

    public double calcularDanio() {
        double modificadorTipo = 1.0;
        double bonificacionClima = 1.0;
        double defensa = defensaOponente;

        if (tipo == TipoAtaque.FUEGO) {
            modificadorTipo = 1.2;
            if (climaAFavor) bonificacionClima = 1.5;
        } else if (tipo == TipoAtaque.AGUA) {
            modificadorTipo = 1.1;
            if (climaAFavor) bonificacionClima = 1.3;
        } else if (tipo == TipoAtaque.PLANTA) {
            modificadorTipo = 1.0;
            if (climaAFavor) bonificacionClima = 1.2;
        } else if (tipo == TipoAtaque.ELECTRICO) {
            modificadorTipo = 1.3;
            if (climaAFavor) bonificacionClima = 1.1;
        }

        double danioBase = poderBase * modificadorTipo * bonificacionClima;
        return danioBase - defensa * 0.5;
    }
}

Luego aplicar los siguientes patrones:

🎨 1. Decorator – Ataques con efectos adicionales
Consigna: Implementá un sistema de decoradores que permita agregar efectos especiales a un ataque ya existente, como "Golpe Crítico", "Envenenamiento", "Quema", o "Rebote". Cada decorador puede alterar el daño calculado o aplicar un efecto adicional.

Ataque ataqueConCritico = new GolpeCriticoDecorator(new AtaqueFuego(...));


🌳 2. Composite – Ataques combinados
Consigna: Permití crear un ataque compuesto que contenga múltiples ataques individuales (por ejemplo, “Triple Combo” o “Doble Rayo”). El daño total debe ser la suma de los daños de cada ataque individual.

Ataque combo = new ComboAtaque(List.of(
    new AtaqueFuego(...),
    new AtaqueElectrico(...)
));
🧰 3. Adapter – Bonificación externa de tipo
Consigna: Supongamos que el motor de cálculo de bonificaciones de tipo está en una librería externa con una interfaz diferente. Usá un patrón Adapter para integrarla al sistema sin modificar la lógica del ataque.

class SistemaExternoBonificaciones {
    double calcularBonus(String tipo, boolean clima);
}
Tu adapter debería permitir que el sistema actual lo use sin conocer esa API externa.

⚔️ 4. Strategy – Estrategias de cálculo de bonificación
Consigna: Extraé la lógica de bonificación por tipo o clima a una familia de estrategias intercambiables (por ejemplo: estrategia “ofensiva”, “clima dinámico”, “sin bonificación”). Permití cambiar la estrategia en tiempo de ejecución.

Ataque ataque = new AtaqueFuego(...);
ataque.setEstrategiaBonificacion(new BonificacionOfensiva());

👁️ 5. Observer – Notificar a los espectadores del combate
Consigna: Implementá un patrón Observer donde observadores (como la interfaz de usuario o el registro del combate) sean notificados cada vez que un ataque se ejecuta y produce daño.

ataque.agregarObservador(new RegistroCombate());
ataque.calcularDanio(); // → el observador recibe el evento con el daño


🛡️ 6. Proxy – Ataque controlado con acceso condicional
Consigna: Creá un AtaqueProxy que controle el acceso al ataque original. Por ejemplo, solo se puede ejecutar el ataque si el Pokémon tiene suficiente energía, o si está habilitado por una condición externa.

Ataque ataqueReal = new AtaqueElectrico(...);
Ataque ataqueControlado = new AtaqueProxy(ataqueReal, energiaActual);

🎮 Main de ejemplo esperado
public class Main {
    public static void main(String[] args) {
        Ataque simple = new AtaqueFuego(100, true, 30);
        Ataque conCritico = new GolpeCriticoDecorator(simple);
        Ataque combinado = new ComboAtaque(List.of(
            conCritico,
            new AtaqueAgua(80, false, 25)
        ));

        combinado.agregarObservador(new RegistroCombate());

        System.out.println("Daño total: " + combinado.calcularDanio());
    }
}
