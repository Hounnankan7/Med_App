package med_app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class App_main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//A revoir
		/*String link; 
		if(args!=null && args[0] != null) 
		{
			System.out.println("ARgument is there......");
			//link = args[0];
		}
		//-------------------------------------------------------------------------------------------*/
		
	FileInputStream fichier = new FileInputStream("symptoms.txt");
	Scanner scan = new Scanner(fichier);
	
	//Variable pour recup contenu sur chaq ligne
	ArrayList<String> listeSymptom = new ArrayList<String>(); 
	
	while(scan.hasNextLine())
	{
		//System.out.println(scan.nextLine());
		String maladie = scan.nextLine();
		listeSymptom.add(maladie);
	}
	System.out.println("--------------------------------------------------- Nombre d'ELEMENT / "+listeSymptom.size() );	
	
	//Hashmap recup des nbr occurence et non symptom
	HashMap<String, Integer> symptom = new HashMap<String, Integer>();
	
	for(int i = 0; i < listeSymptom.size(); i++)
	{
		String symptom_Actuel = listeSymptom.get(i);
	
		if(symptom.containsKey(symptom_Actuel)) 
		{
			symptom.put(symptom_Actuel, symptom.get(symptom_Actuel)+1);
		}
		else
		{
			symptom.put(symptom_Actuel, 1);
		}
		
	}
	
	//Creation d'un  fichier
	String donnee_rapport;
	FileOutputStream new_fichier = new FileOutputStream("Rapport.txt");
	
	
	for(String i : symptom.keySet())
	{
		//System.out.println("Pour le symptome : "+i+" on a "+symptom.get(i)+" occurrence (s)");
		donnee_rapport = "Pour le symptome : "+i+" on a "+symptom.get(i)+" occurrence (s)\n";
		new_fichier.write(donnee_rapport.getBytes());
		
	}
	
	
	
	
	scan.close();
	new_fichier.close();
	}

}






/*for(int i =0; i < listeSymptom.size(); i++) //Boucle affichage les noms
{
	System.out.println(listeSymptom.get(i));	
}*/
