package desafios;

public class TerceiroDesafio {

	private int number = 0;
	
	public TerceiroDesafio(int n){
		number = n;
	}

	protected int getNumberOfOddsRow(int rowNumber){
		//a quantidade de numeros impares em uma linha da piramide é igual a 2 elevado ao numero de 1 no numero binário que representa a linha
		//Ex: a linha 0 possui 1 numero impar, pois 0 em base 2 é 0
		int ones = 0;
		ones = countOnes(Integer.toBinaryString(rowNumber).toCharArray());
		
		return (int) Math.pow(2, ones);
	}
	
	public void getNumberOfEvenNumbers(){
		
		long res = 0;
		
		for (int row = 0; row <= this.number; row++) {
			
			res += getNumberOfEvenForRow(row);
		}
		System.out.println("************************************");
		System.out.println("*** Numeros pares até linha: "+this.number);
		System.out.println(res);
		System.out.println("************************************");
	}
	
	
	
	private long getNumberOfEvenForRow(int row) {

		int numberOfElementsInRow = row +1;
		return numberOfElementsInRow - this.getNumberOfOddsRow(row);
	}

	private int countOnes(char[] charArray) {
		int result = 0;
		
		for(char c : charArray){
			if(c == '1')
				result++;
		}
		
		return result;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
}
