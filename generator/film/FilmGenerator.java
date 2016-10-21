package viktor.generator.film;

import java.util.ArrayList;
import java.util.Arrays;

import viktor.generator.Media;
import viktor.generator.utils.Utils;

public final class FilmGenerator {
	
	private FilmGenerator() {}
	
	public static Media randomFilm( String resourcesLocation, boolean fromURL ) {
		
		ArrayList<String> filmExtensions = new ArrayList<String>(Arrays.asList(new String[]{
				
			".flv",
			".gif",
			".mkv",
			".mpeg",
			".mpg",
			".mov",
			""
					
		}));
		
		ArrayList<String> filmPostersLocal = new ArrayList<String>(Arrays.asList(new String[]{
				
			resourcesLocation + "/film/filmposter-0.jpg",
			resourcesLocation + "/film/filmposter-1.jpg",
			resourcesLocation + "/film/filmposter-2.jpg",
			resourcesLocation + "/film/filmposter-3.jpg",
			resourcesLocation + "/film/filmposter-4.jpg",
			resourcesLocation + "/film/filmposter-5.jpg"
					
		}));
		
		ArrayList<String> posters = filmPostersLocal;
		
		ArrayList<String> filmPostersRemote = new ArrayList<String>(Arrays.asList(new String[]{
				
			"http://px205.dcs.kcl.ac.uk:8080/mc4/film/filmposter-0.jpg",
			"http://px205.dcs.kcl.ac.uk:8080/mc4/film/filmposter-1.jpg",
			"http://px205.dcs.kcl.ac.uk:8080/mc4/film/filmposter-2.jpg",
			"http://px205.dcs.kcl.ac.uk:8080/mc4/film/filmposter-3.jpg",
			"http://px205.dcs.kcl.ac.uk:8080/mc4/film/filmposter-4.jpg",
			"http://px205.dcs.kcl.ac.uk:8080/mc4/film/filmposter-5.jpg",
					
		}));
		
		if ( fromURL ) posters = filmPostersRemote;
		
		return new Media(addDefinition(addYear(filmName())) + filmExtensions.get((int)(Math.random() * filmExtensions.size())), posters.get((int)(Math.random() * posters.size())), fromURL);
		
	}
	
	private static String filmName() {
		
		String[] NounsNames = {"quack","girl","mouse","boy","banker","talker","cat","baby","giraffe","captain","king","queen","prince","bird","brat","backpacker","hunter","cabinet-maker","hoarder","seeker","fly","pensioner","emperor","thug","skater"};;
		
		String[] Nouns2 = {"bonnet","cradle","gold","debt","ribbon","day","smog","jumper","paper","cup","pen","beard","train"};;
		
		String[] Prepositions = {"onto","during","down","a","aboard","about","amid","at"};
		
		String[] Places = {"Paris","Toronto","Sweden","Australia","Africa","Town","the country-side","Britain","the city","the town"};
		 
		String[] Places2 = {"the country-side","the city","the town","room","The farm"};    
		
		String[] Adjectives = {"slimy","bumpy","red","stinky","sweet","sour","blue","yellow","green","sandy","sleek"};
		 
		String[] personadj = {"fast","slow","young","silly","stupid","retired","eager","handsome","understandable","lanky","genius","normal","reluctant","naked","forever","shadow","witty","shady"};
		
		String[] Verb = {"being","having" , "doing" , "saying" , "seeing" , "making"};
		
		String[] Verbing = {"being","having" , "doing" , "saying" , "playing" , "making"}; 
	
		int NounsNameslist = ((int)(Math.random() * NounsNames.length));
		
		int Nouns2list = ((int)(Math.random() * Nouns2.length));
		
		int Prepositionslist = ((int)(Math.random() * Prepositions.length));
		
		int Adjectiveslist = ((int)(Math.random() * Adjectives.length));
		
		int Verblist = ((int)(Math.random() * Verb.length));
		
		int Verbinglist = ((int)(Math.random() * Verbing.length));
		
		int personadjlist = ((int)(Math.random() * personadj.length));
		
		int Placeslist = ((int)(Math.random() * Places.length));
		
		int Places2list = ((int)(Math.random() * Places2.length));

		String option1 = "The " + Adjectives[Adjectiveslist] + " " + Nouns2[Nouns2list];
		
		String option2 = "The " + personadj[personadjlist] + " " + NounsNames[NounsNameslist];
		
		String option3 = "The " + personadj[personadjlist] + " " + NounsNames[NounsNameslist] + " of " + Places[Placeslist];
		
		String option4 = Verbing[Verbinglist] + " it like a " + NounsNames[NounsNameslist];                  
		
		String option5 = Places2[Places2list] + " of " + Nouns2[Nouns2list]+ "s";
		
		String[] finallist = { option1, option2, option3, option4, option5};
		
		return Utils.capitalise(finallist[((int)(Math.random() * finallist.length))]);
		                        
	}
	
	private static String addYear( String title ) {
		
		if ( Math.random() < 0.5 ) {
			
			return title + " (" + Utils.randomBetween(1980, 2016) + ")";
			
		} else {
			
			return "(" + Utils.randomBetween(1980, 2016) + ") " + title;
		}
		
	}
	
	private static String addDefinition( String title ) {
		
		ArrayList<String> definitions = new ArrayList<String>(Arrays.asList(new String[]{"HD, 1080p", "HD, 720p", "SD, 480p"}));
		
		if ( Math.random() < 0.5 ) {
			
			return title + " (" + definitions.get((int)(Math.random() * definitions.size())) + ")";
			
		} else {
			
			return "(" + definitions.get((int)(Math.random() * definitions.size())) + ") " + title;
		}
		
	}
	
}