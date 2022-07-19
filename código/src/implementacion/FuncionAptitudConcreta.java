package implementacion;

import tiposagentes.*;
import Vecindades.VecindadObstaculos;
import core.*;

public class FuncionAptitudConcreta implements FuncionAptitud{

	private double parametroObstaculos = 1;
	@Override
	public double funcionAptitud(double distancia, double pesoObstaculos) {
		// TODO Auto-generated method stub
				
		return (pesoObstaculos + 1)*distancia;
	}

	@Override
	public double pesoObstaculos(VecindadObstaculos obstaculos, AgenteMovil agente, AgenteMovil objetivo) {
		// TODO Auto-generated method stub	
		
		Vector posAgente = agente.getPosicion();
		double distAgenteObstaculo = 0;
		
		double sumatoria = 0;
		
		for(Obstaculo o: obstaculos)
		{
			if(Util.estaEnLineaDeVista(agente, o, objetivo) == false)//si el agente no puede ver al objetivo porque lo tapa el obstaculo
			{
				distAgenteObstaculo = posAgente.distancia(o.getPosicion());
				
				if(distAgenteObstaculo != 0)
				{
					sumatoria = sumatoria + distAgenteObstaculo;
				}
			}
		}
		
		sumatoria = sumatoria*parametroObstaculos;
		return sumatoria;
		}

	@Override
	public double getParametroObstaculo() {
		// TODO Auto-generated method stub
		return parametroObstaculos;
	}

	@Override
	public void setParametroObstaculo(double parametroObstaculo) {
		this.parametroObstaculos = parametroObstaculo;		
	}

}
