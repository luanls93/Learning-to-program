package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.func;

public class Program {

	public static void main(String[] args) {
		 
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<func> listFun = new ArrayList<func>();
		System.out.println(" Informe quantos funcionarios serão cadastrados");
		int N = sc.nextInt();
		double salary;
		for(int i=1;i<=N;i++) {
			System.out.println();
			System.out.println("Employer #"+i+":");
			System.out.print("ID: ");
			int id = sc.nextInt();
			
			while (hasId(listFun,id)) {
				System.out.println("Esse Id ja foi cadastrado. Tente novamente: ");
				id=sc.nextInt();
			}System.out.print("Name: ");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.println("Salary: ");
			salary= sc.nextDouble();	
			listFun.add(new func(id, salary, name));
			
		}System.out.println("Informe o Id do funcionario que terá aumento:");
		int id= sc.nextInt();
		func funcionario= listFun.stream().filter(x->x.getId()==id).findFirst().orElse(null);
		if(funcionario==null) {
			System.out.println("Funcionario nao existe!");
		}else {
			System.out.println("Informe o percentual: ");
			double percentual = sc.nextDouble();
			funcionario.aumentoSalary(percentual);
		}System.out.println();
		System.out.println(" Funcionarios: ");
		for(func data : listFun) {
			System.out.println(data);
		}
		
		
		sc.close();
	}

	private static boolean hasId(List<func> listFun, int id) {
		func funcionario = listFun.stream().filter(x->x.getId()==id).findFirst().orElse(null);
		return funcionario != null;
	}

}
