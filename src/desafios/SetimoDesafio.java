package desafios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SetimoDesafio {

	HashMap<String, Estrutura> estruturas = new HashMap<>();
	
	public SetimoDesafio(String[] info){
		
		for(String str : info){
			String[] split = str.split(" ");
			Estrutura estrutura = null;
			String estName = split[0];
			if(estruturas.containsKey(estName)){
				estrutura = estruturas.get(estName);
			}else{
				estrutura = new Estrutura(estName);
				estruturas.put(estName, estrutura);
			}
			int tamanho = (int) (Math.floor(( Double.parseDouble(split[1])/2.0)));
			
			split =  Arrays.asList(split).subList(2, split.length).toArray(new String[0]);
			for(int i = 0; i < tamanho;i++){
				populate(estrutura.getLeft(), split[i]);
			}
			for(int i = tamanho+1; i < str.length()-1;i++){
				populate(estrutura.getRight(), split[i]);
			}
			estrutura.setMeio(decideEstrutura(split[tamanho]));
		}
		
		
	}

	private void populate(ArrayList<Estrutura> lado, String nomeValor) {
		Estrutura inner = decideEstrutura(nomeValor);
		lado.add(inner);
	
	}












	private Estrutura decideEstrutura(String nomeValor) {
		Estrutura inner = null;
		if(Character.isDigit(nomeValor.charAt(0))){
			inner = new Estrutura(Integer.parseInt(nomeValor));
		}else{
			if(estruturas.containsKey(nomeValor)){
				inner = estruturas.get(nomeValor);
			}else{
				inner = new Estrutura(nomeValor);
			}
		}
		return inner;
	}












	class Estrutura{
		private String name;
		private int value;
		private ArrayList<Estrutura> left = new ArrayList<>();
		private ArrayList<Estrutura> right = new ArrayList<>();
		private Estrutura meio;
		private int momentum;
		
		public Estrutura(String name, int momentum){
			this.momentum = momentum;
			this.name = name;
		}
		public Estrutura(String name){
			this.name = name;
		}
		
		public Estrutura(int valor){
			this.value = valor;
		}
		
		public Estrutura getMeio() {
			return meio;
		}
		public void setMeio(Estrutura meio) {
			this.meio = meio;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public ArrayList<Estrutura> getLeft() {
			return left;
		}
		public void setLeft(ArrayList<Estrutura> left) {
			this.left = left;
		}
		public ArrayList<Estrutura> getRight() {
			return right;
		}
		public void setRight(ArrayList<Estrutura> right) {
			this.right = right;
		}
		public int getMomentum() {
			return momentum;
		}
		public void setMomentum(int momentum) {
			this.momentum = momentum;
		}
	}
}
