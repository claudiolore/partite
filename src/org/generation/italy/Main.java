package org.generation.italy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ArrayList<String> partite=new ArrayList<String>();
		ArrayList<Integer> golCasa=new ArrayList<>();
		ArrayList<Integer> golOspite=new ArrayList<>();
		String squadra1, squadra2, continua, risposta;
		int punteggio1, punteggio2;
		HashMap<String, Integer> classifica=new HashMap<>(); {{
			classifica.put("lazio", 0);
			classifica.put("roma", 0);
			classifica.put("inter", 0);
			classifica.put("milan", 0);
			classifica.put("juve", 0);
			classifica.put("torino", 0);
		}};
		
		
		do {
			
			System.out.println("inserisci una partita");
			
			System.out.println("squadra in casa?");
			squadra1=sc.nextLine();
		
			if(!classifica.containsKey(squadra1))
			{
				System.out.println("La squadra non esiste.\nVuoi aggiungerla?");
				risposta=sc.nextLine();
				if(risposta.equals("si"))
				{
					classifica.put(squadra1, 0);
				}
				else
				{
					risposta.equals("si");
					continue;
				}
			}
		
			System.out.println("squadra ospite");
			squadra2=sc.nextLine();
		
			if(!classifica.containsKey(squadra2))
			{
				System.out.println("La squadra non esiste.\nVuoi aggiungerla?");
				risposta=sc.nextLine();
				if(risposta.equals("si"))
				{
					classifica.put(squadra2, 0);
				}
				else
				{
					risposta.equals("si");
					continue;
				}
			}
	
			partite.add(squadra1+"-"+squadra2);
			
			System.out.println("Quanti gol ha segnato chi stava in casa?");
			punteggio1=Integer.parseInt(sc.nextLine());
			System.out.println("E chi era fuoricasa?");
			punteggio2=Integer.parseInt(sc.nextLine());
			golCasa.add(punteggio1);
			golOspite.add(punteggio2);
			
				if(punteggio1>punteggio2)
				{
					classifica.put(squadra1, classifica.get(squadra1)+3);
				}
				else if(punteggio1<punteggio2) 
				{
					classifica.put(squadra2, classifica.get(squadra2)+3);
				}
				else if(punteggio1==punteggio2) 
				{
					classifica.put(squadra1,classifica.get(squadra1)+1);
					classifica.put(squadra2,classifica.get(squadra2)+1);
				}
			
			
			System.out.println("Vuoi aggiungere una nuova partita?");
			risposta=sc.nextLine();
		}	
		while(risposta.equals("si"));
		
		System.out.println("Resoconto Partite");
		
		for (int i=0;i<partite.size();i++)
		{
			System.out.println(partite.get(i) + "  " + golCasa.get(i) + "-" + golOspite.get(i));
		}		
		System.out.println("La classifica è:");
		ArrayList<String> prova=new ArrayList<>(classifica.keySet());
		Collections.sort(prova);
		for(String t:classifica.keySet())									//scorre tutte le targhe (chiavi)
			System.out.println(t+" "+classifica.get(t)+" punti");
		
		sc.close();
	}
 
}
