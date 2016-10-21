package viktor.generator.track;

import java.util.ArrayList;
import java.util.Arrays;

import viktor.generator.Media;
import viktor.generator.utils.Utils;

public class TrackGenerator {
	
	private TrackGenerator() {}
	
	public static Media randomTrack( String resourcesLocation, boolean fromURL ) {
		
		ArrayList<String> trackExtensions = new ArrayList<String>(Arrays.asList(new String[]{
				
			".aiff",
			".aac",
			".aax",
			".oog",
			".wav",
			".wma",
			""
						
		}));
		
		ArrayList<String> albumCoversLocal = new ArrayList<String>(Arrays.asList(new String[]{
				
			resourcesLocation + "/music/albumcover-0.jpg",
			resourcesLocation + "/music/albumcover-1.jpg",
			resourcesLocation + "/music/albumcover-2.jpg",
			resourcesLocation + "/music/albumcover-3.jpg",
			resourcesLocation + "/music/albumcover-4.jpg",
			resourcesLocation + "/music/albumcover-5.jpg"
					
		}));
		
		ArrayList<String> covers = albumCoversLocal;
		
		ArrayList<String> albumCoversRemote = new ArrayList<String>(Arrays.asList(new String[]{
				
			"http://px205.dcs.kcl.ac.uk:8080/mc4/music/albumcover-0.jpg",
			"http://px205.dcs.kcl.ac.uk:8080/mc4/music/albumcover-1.jpg",
			"http://px205.dcs.kcl.ac.uk:8080/mc4/music/albumcover-2.jpg",
			"http://px205.dcs.kcl.ac.uk:8080/mc4/music/albumcover-3.jpg",
			"http://px205.dcs.kcl.ac.uk:8080/mc4/music/albumcover-4.jpg",
			"http://px205.dcs.kcl.ac.uk:8080/mc4/music/albumcover-5.jpg",
					
		}));
		
		if ( fromURL ) covers = albumCoversRemote;
		
		return new Media(addArtist(trackName()) + trackExtensions.get((int)(Math.random() * trackExtensions.size())), covers.get((int)(Math.random() * covers.size())), fromURL);
		
	}
	
	private static String trackName() {
		
	    String[] names1 = {"A Way", "A Day", "A Picture", "A Song", "Agent", "All", "Angel", "Apology", "Beauty", "Because", "Best", "Best Day", "Call", "Celebration", "Choice", "City", "Crossroad", "Dance", "Darling", "Date", "Day", "Daydreams", "Days", "Devil", "Devotion", "Door", "Dreaming", "Dreams", "End", "Era", "Fantasy", "Friends", "Gamble", "Gift", "Heart", "Hour", "Images", "Kind", "Legend", "Lessons", "Life", "Light", "Love", "Lover", "Magic", "Man", "Matter", "Melody", "Memories", "Middle", "Minute", "Moment", "Music", "My Kind", "Mystery", "Night", "Out", "Party", "Passion", "Pictures", "Power", "Prayer", "Reflections", "Respect", "Rhythm", "Season", "Seconds", "Shapes", "Sky", "Smiles", "Song", "Songs", "Soul", "Sound", "Speak", "Spring", "Stairway", "Story", "Stranger", "Strings", "Style", "Summer", "Surprise", "Sweet Child", "Talk", "Taste", "The Scent", "Things", "Think", "Thoughts", "Time", "Tired", "Top", "Trip", "Tune", "Whispers", "Wish", "Woman", "World", "Yearning"};
	    
	    String[] names2 = {"", "", "", "", "For A Girl Like You", "For A Thrill", "For An Angel", "For Everything", "For Forever", "For Love", "For Me", "For Money", "For My Baby", "For My Darling", "For No One", "For Old Times", "For Once", "For Sale", "For The Man", "For The Memories", "For The Road", "For Tomorrow", "For Two", "For Us", "For You", "For You And I", "For Yourself", "Of A Bad Romance", "Of A Chance", "Of A Dream", "Of A Man", "Of A Stranger", "Of A Woman", "Of Anything", "Of Dance", "Of Daylight", "Of Days", "Of Diamonds", "Of Dreams", "Of Everything", "Of Fame", "Of Fire", "Of Fireworks", "Of Forever", "Of Freedom", "Of Hearts", "Of Heaven", "Of Home", "Of Ice", "Of Joy", "Of Lazy Days", "Of Lies", "Of Life", "Of Love", "Of Madness", "Of Magic", "Of Me", "Of Mercy", "Of Midnight", "Of Mine", "Of Mirrors", "Of More", "Of My Affection", "Of My Dreams", "Of My Heart", "Of My Life", "Of My Obsession", "Of My Party", "Of My Thoughts", "Of Never", "Of Nothing", "Of Nowhere", "Of Old", "Of Our Time", "Of People", "Of Power", "Of Right Now", "Of Secrets", "Of Somebody", "Of Something", "Of Stars", "Of Style", "Of The Ages", "Of The City", "Of The Evening", "Of The First Time", "Of The Future", "Of The Good Life", "Of The Morning", "Of The Night", "Of The World", "Of Time", "Of Tomorrow", "Of Us", "Of What", "Of Yesterday", "Of You", "Of Your Beauty", "Of Your Smile"};
	    
	    String[] names3 = {"Admiring", "Amused By", "Belong To", "Change", "Cling To", "Compete For", "Copy", "Dance With", "Don't Need", "Dream", "Dream Of", "Enjoy", "Finding", "Forget", "Forget About", "Forgot", "Get", "Getting", "Give", "Giving", "Having", "Imagine", "Joy Of", "Kiss", "Lose", "Love", "Loving", "Need", "Open", "Open Up To", "Out Of", "Reach For", "Reject", "Remember", "Rock", "Search For", "Sleep In", "Talk About", "Think About", "Tickle", "Troubles Of", "Wait For", "Walk With", "Warmth Of", "Whisper", "With", "Without"};
	    
	    String[] names3b = {"My", "My", "His", "Her", "Your"};
	    
	    String[] names4 = {"Affection", "Arms", "Baby", "Bed", "Best Friend", "Dance", "Desire", "Door", "Dreams", "Echo", "Everything", "Eyes", "Fire", "Friends", "Heart", "Home", "Hometown", "Inner Fire", "Kiss", "Life", "Love", "Memory", "Mind", "Music", "Name", "Own", "Own Way", "Party", "Place", "Power", "Right", "Romance", "Shadow", "Smile", "Song", "Soul", "Strength", "Sugar", "Sunshine", "Tears", "Time", "Tomorrow", "Touch", "Troubles", "Voice", "Way", "World"};
	    
	    String[] names5 = {"Beautiful", "Best", "Birthday", "Brave", "Broken", "Crazy", "Dance", "Diamond", "Easy", "Fame", "Fantastic", "Female", "First", "Free", "Golden", "Good", "Goodbye", "Hard", "Home", "Last", "Lazy", "Light", "Love", "Magic", "Male", "Man", "Midnight", "More", "No", "Pretty", "Sleep", "Stop", "Super", "Sure", "Sweet", "Time", "Whatever", "Woman"};
	    
	    String[] names6 = {"Chance", "Chances", "Circus", "Crazy", "Dreams", "Feeling", "Fever", "Fireworks", "Forever", "Game", "Games", "Heart", "Kisses", "Life", "Machine", "Memories", "Mind", "Money", "Moves", "Obsession", "Power", "Promises", "Romance", "Rhythm", "Secrets", "Show", "Smile", "Song", "Story", "Tales", "Tomorrow", "Tonight"};
	    
	    String[] names7 = {"", "", "Baby, ", "Honey, ", "Sweetie, ", "Babe, ", "Darling, "};
	    
	    String[] names8 = {"Come Back", "I Love You", "I'll Love You Forever", "Let's Party", "Let's Go", "Let's Start This Party", "Get Out", "Love Me", "Love Me Like I Love You", "I Need You", "I Need Your Love", "You're My World", "Let's Rock This World", "Let's Do This", "Come With Me", "I'm With You", "I Think I Like You", "I Wish You Were Mine", "Let's Be Free Tonight", "Tonight's The Night", "You're On My Mind", "I Can't Take My Eyes Off You", "I'm Falling For You", "You Broke My Heart", "You're Crazy", "We're Crazy", "We're Crazy In Love", "Smile With Me", "Imagine The Future", "Come On", "Come With Me", "Dance With Me", "Sing With Me", "Stand By Me", "I Want You", "Maybe Tomorrow", "Remember Yesterday?", "Remember The Times", "Do You Remember?", "Do You Like Me?", "I Love You So", "I Miss You", "Let's Be Lazy", "You're My Number One", "You're My One And Only", "Never Let Me Go", "I'll Never Let You Go", "I'll Be There For You", "Nobody Knows", "You're Amazing", "Hold Me", "Oh Baby", "You're Strange", "You're Stange And I Like It", "I Like You A Lot", "Pretty Baby", "Remember Me", "Do You Feel The Rhythm", "You're My Everything", "Let's Be Silly", "Set Me Free", "Smile For Me", "You And I Forever", "Remember Tomorrow", "So Do I", "Take My Breath Away", "Take A Chance With Me", "Thank You", "You're My World", "This Love Of Mine", "Time After Time", "Until I Met You", "I Waited For You", "Wait And See", "We'Ve Only Just Begun", "When You're Smiling", "When You're Gone", "You're Wild", "Let's Go Wild", "Without You", "Wouldn't It Be Nice", "We Got It", "You Make Me Feel So.."};
	    
	    String[] names9 = {"", "", "", "", "I think", "I Love", "She Loves", "He Loves", "He thinks", "She Thinks", "I know", "He knows", "She knows", "I hope", "He Hopes", "She Hopes", "I heard", "He heard", "She heard", "I said", "He said", "She said"};
	    
	    String[] names10 = {"I Like You", "I Am Crazy", "I Love You", "She Loves You", "She's Crazy", "He's Crazy", "He Likes You", "She Likes You", "He Loves You", "I Want You", "He Wants You", "She Wants You", "I Need You", "He Needs You", "She Needs You", "I'm In Love With You", "I Like To Party", "We Like To Party", "She Likes To Party", "He Likes To Party", "I Can Do This", "She Can Do This", "He Can Do This", "We Can Do This", "We're In Love", "I'll Love You Forever", "I'm Falling For You", "You're On My Mind", "She's On My Mind", "He's On My Mind", "You Miss Me", "You're My Everything", "I'm Madly In Love", "I'm A Troublemaker", "She's A Troublemaker", "He's A Troublemaker", "I Don't Care", "She Doesn't Care", "He Doesn't Care", "I'm Bad", "He's Bad", "She's Bad", "I Will Try", "He Will Try", "She Will Try", "I Love Somebody", "I Love It", "We Can't Stop", "I Won't Stop", "I Am Trouble", "You're Trouble", "She's Trouble", "He's Trouble", "They Can't Hold Us", "They Can't Hold Us Down", "We Know", "I Know", "She Knows", "He Knows"};
	    
	    double rnd, rnd2, rnd3;
	    
	    String names = "";
	    
	    for ( int i = 0; i < 10; i++ ) {
	    	
	        if ( i < 2 ) {
	            
	        	rnd = Math.floor(Math.random() * names1.length);
	            
	        	rnd2 = Math.floor(Math.random() * names2.length);
	            
	            names = names1[(int)rnd] + " " + names2[(int)rnd2];
	        
	        } else if (i < 4) {
	            
	        	rnd = Math.floor(Math.random() * names3.length);
	        	
	            rnd2 = Math.floor(Math.random() * names3b.length);
	            
	            rnd3 = Math.floor(Math.random() * names4.length);
	            
	            names = names3[(int)rnd] + " " + names3b[(int)rnd2] + " " + names4[(int)rnd3];
	        
	        } else if ( i < 6 ) {
	        
	        	rnd = Math.floor(Math.random() * names5.length);
	        	
	            rnd2 = Math.floor(Math.random() * names6.length);
	            
	            names = names5[(int)rnd] + " " + names6[(int)rnd2];
	        
	        } else if ( i < 8 ) {
	        	
	            rnd = Math.floor(Math.random() * names7.length);
	            
	            rnd2 = Math.floor(Math.random() * names8.length);
	            
	            names = names7[(int)rnd] + " " + names8[(int)rnd2];
	            
	        } else {
	            
	        	rnd = Math.floor(Math.random() * names9.length);
	        	
	            rnd2 = Math.floor(Math.random() * names10.length);
	            
	            names = names9[(int)rnd] + " " + names10[(int)rnd2];
	        
	        }
	        
	    }
	    
        return Utils.capitalise(names.trim());
	    
	}

	private final static RandomNameGenerator randomNameGenerator = new RandomNameGenerator();
	
	private static String addArtist( String trackName ) {
		
		String artist;
		
		if ( Math.random() < 0.1 ) {
			
			artist = randomNameGenerator.next() + " feat. " + randomNameGenerator.next();
			
		} else {
			
			artist = randomNameGenerator.next();
			
		}
		
		return trackName + " - " + artist; 
		
	}
	
}