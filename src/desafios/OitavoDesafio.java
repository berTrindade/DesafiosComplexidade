package desafios;

import java.util.ArrayList;


public class OitavoDesafio {

	public static void main() {
		int[] quadrado = {5,3,12,10};
		ArrayList<Integer[]> coordenadas = new ArrayList<Integer[]>();
		int nQuadrados = 4;
		Integer[][] quadrados = {{1,7,8,14},{7,5,11,13},{10,7,17,14},{9,1,17,6}};
		
		
		for(int i = quadrado[0]; i<=quadrado[2];i++){
			for(int j = quadrado[1]; j<=quadrado[3];j++){
				Integer[] arr = {i, j};
				coordenadas.add(arr);
			}
		}
		System.out.println("tamanho: "+coordenadas.size());
		for(int square = 0; square<nQuadrados;square++){
			for(int i = quadrados[square][0]; i<=quadrados[square][2];i++){
				for(int j = quadrados[square][1]; j<=quadrados[square][3];j++){
					int index = 0;
					for(int xy= 0; xy< coordenadas.size();xy++){
						if(coordenadas.get(xy)[0] ==i && coordenadas.get(xy)[1] == j){
							index = xy;
						}
						if(index != 0){
							Integer[] element = coordenadas.remove(index);
						}
					}
				}
			}	
		}
		if(coordenadas.isEmpty()){
			System.out.println("não sobraram campos visiveis");
		}else{
			System.out.println("sobraram campos visiveis");
		}
	}
}
