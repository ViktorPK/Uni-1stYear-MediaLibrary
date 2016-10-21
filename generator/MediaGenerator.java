package viktor.generator;

import java.util.ArrayList;
import java.util.Collections;

import viktor.generator.film.FilmGenerator;
import viktor.generator.track.TrackGenerator;

public final class MediaGenerator {

	private MediaGenerator() {}
	
	public static ArrayList<Media> getMedia() {
		
		return getMedia("resources");
		
	}
	
	public static ArrayList<Media> getMedia( boolean fromURL ) {
		
		return getMedia("resources", fromURL);
		
	}
	
	public static ArrayList<Media> getMedia( String resourcesLocation ) {
		
		return getMedia(resourcesLocation, false);
		
	}
	
	private static ArrayList<Media> getMedia( String resourcesLocation, boolean fromURL ) {
		
		ArrayList<Media> mediaList = new ArrayList<Media>();
		
		for ( int i = 0; i < 10; i++ ) {
			
			mediaList.add(FilmGenerator.randomFilm( resourcesLocation, fromURL ));
			
		}
		
		for ( int i = 0; i < 10; i++ ) {
			
			mediaList.add(TrackGenerator.randomTrack( resourcesLocation, fromURL ));
			
		}
		
		//Collections.shuffle(mediaList);
		
		return mediaList;
		
	}

}
