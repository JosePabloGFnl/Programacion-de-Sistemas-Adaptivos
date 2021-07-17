
import com.fuzzylite.*;
import com.fuzzylite.activation.*;
import com.fuzzylite.defuzzifier.*;
import com.fuzzylite.factory.*;
import com.fuzzylite.hedge.*;
import com.fuzzylite.imex.*;
import com.fuzzylite.norm.*;
import com.fuzzylite.norm.s.*;
import com.fuzzylite.norm.t.*;
import com.fuzzylite.rule.*;
import com.fuzzylite.term.*;
import com.fuzzylite.variable.*;


public class casoA{

private Engine engine;

public casoA()
{
	setEngine();

	
}
public void setEngine()
{

 engine = new Engine();
engine.setName("Casoa");
engine.setDescription(" CASO A ");


InputVariable Tamano = new InputVariable();
Tamano.setName("Tamano");
Tamano.setDescription("tamano de la serpiente");
Tamano.setEnabled(true);
Tamano.setRange(0, 100);
Tamano.setLockValueInRange(false);
Tamano.addTerm(new Ramp("CORTO", 5, 15));
Tamano.addTerm(new Trapezoid("MEDIANO", 10, 20, 25, 35));
Tamano.addTerm(new Ramp("LARGO", 30, 45));
engine.addInputVariable(Tamano);

InputVariable Velocidad = new InputVariable();
Velocidad.setName("Velocidad");
Velocidad.setDescription(" velocidad de la serpiente ");
Velocidad.setEnabled(true);
Velocidad.setRange(0, 50);
Velocidad.setLockValueInRange(false);
Velocidad.addTerm(new Ramp("LENTA", 10, 50));
Velocidad.addTerm(new Trapezoid("MODERADA", 40, 55, 70, 85));
Velocidad.addTerm(new Ramp("RAPIDA", 80, 95));
engine.addInputVariable(Velocidad);

OutputVariable Dificultad = new OutputVariable();
Dificultad.setName("Dificultad");
Dificultad.setDescription("dificultad del juego");
Dificultad.setEnabled(true);
Dificultad.setRange(0, 100);
Dificultad.setLockValueInRange(false);
Dificultad.setAggregation(new Maximum());
Dificultad.setDefuzzifier(new Centroid());
Dificultad.setDefaultValue(Double.NaN);
Dificultad.setLockPreviousValue(false);
Dificultad.addTerm(new Ramp("FACIL", 10, 35));
Dificultad.addTerm(new Trapezoid("NORMAL", 30, 55, 60, 75));
Dificultad.addTerm(new Ramp("DIFICIL", 70, 95));
engine.addOutputVariable(Dificultad);

RuleBlock mamdani = new RuleBlock();
mamdani.setName("mamdani");
mamdani.setDescription("Min Max");
mamdani.setEnabled(true);
mamdani.setConjunction(new Minimum());
mamdani.setDisjunction(null);
mamdani.setImplication(new Minimum());
mamdani.setActivation(new General());
mamdani.addRule(Rule.parse("if Tamano is CORTO and Velocidad is LENTA then Dificultad is FACIL", engine));
mamdani.addRule(Rule.parse("if Tamano is MEDIANO and Velocidad is LENTA then Dificultad is FACIL", engine));
mamdani.addRule(Rule.parse("if Tamano is LARGO and Velocidad is LENTA then Dificultad is NORMAL", engine));
mamdani.addRule(Rule.parse("if Tamano is CORTO and Velocidad is MODERADA then Dificultad is FACIL", engine));
mamdani.addRule(Rule.parse("if Tamano is MEDIANO and Velocidad is MODERADA then Dificultad is NORMAL", engine));
mamdani.addRule(Rule.parse("if Tamano is LARGO and Velocidad is MODERADA then Dificultad is DIFICIL", engine));
mamdani.addRule(Rule.parse("if Tamano is CORTO and Velocidad is RAPIDA then Dificultad is NORMAL", engine));
mamdani.addRule(Rule.parse("if Tamano is MEDIANO and Velocidad is RAPIDA then Dificultad is DIFICIL", engine));
mamdani.addRule(Rule.parse("if Tamano is LARGO and Velocidad is RAPIDA then Dificultad is DIFICIL", engine));
engine.addRuleBlock(mamdani);
}
//Uso del sistema
public Engine getEngine()
{
	return engine;
}
}
