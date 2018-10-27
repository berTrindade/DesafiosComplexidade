package desafios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SetimoDesafio {

	private Estrutura base;
	HashMap<String, Estrutura> estruturas = new HashMap<>();
	
	public SetimoDesafio(String[] info){
		
		boolean first = true;
		for(String str : info){
			String[] split = str.split(" ");
			Estrutura estrutura = null;
			String estName = split[0];
			if(estruturas.containsKey(estName)){
				estrutura = estruturas.get(estName);
			}else{
				estrutura = new Estrutura(estName, first);
				estruturas.put(estName, estrutura);
				if(first)
					base = estrutura;
				first = false;
			}
			int tamanho = (int) (Math.floor(( Double.parseDouble(split[1])/2.0)));
			
			split =  Arrays.asList(split).subList(2, split.length).toArray(new String[0]);
			for(int i = 0; i < tamanho;i++){
				populate(estrutura.getLeft(), split[i]);
			}
			for(int i = tamanho+1; i < split.length;i++){
				populate(estrutura.getRight(), split[i]);
			}
			estrutura.setMeio(decideEstrutura(split[tamanho]));
		}
		
		base.calculateAsBase();
		
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
				estruturas.put(nomeValor, inner);
			}
		}
		return inner;
	}


	public void getStructures(){
		for(String s : estruturas.keySet()){
			System.out.println(s);
		}
	}
	
	class Estrutura{
		private String name;
		private int value = 0;
		private ArrayList<Estrutura> left = new ArrayList<>();
		private ArrayList<Estrutura> right = new ArrayList<>();
		private Estrutura meio;
		private boolean momentum = false;
		
		public Estrutura(String name, boolean first){
			this.momentum = first;
			this.name = name;
		}
		public void calculateAsBase() {
			int left= 0;
			int right =0;
			meio.calculate();
			for( Estrutura e : this.left){
				left += e.calculate() * ( this.left.size() - this.left.indexOf(e));
			}
			for( Estrutura e : this.right){
				right += e.calculate() * (this.right.indexOf(e)+1);
			}
			if(left == right)
				System.out.println("BASE: "+ name + " IS BALANCED");
		}
		public int calculate() {
			
				if(value > 0)
					return value;
				else{
					int values = 0;
					int left = 0;
					int right = 0;
					for( Estrutura e : this.left){
						left += e.calculate();
					}
					values += left;
					for( Estrutura e : this.right){
						right += e.calculate();
					}
					values += right;
					if(right == left){
						System.out.println(name + " IS BALANCED");
					}
					values += meio.calculate();
					return values;
				}
					
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
		public boolean getMomentum() {
			return momentum;
		}
		public void setMomentum(boolean momentum) {
			this.momentum = momentum;
		}
	}
}
