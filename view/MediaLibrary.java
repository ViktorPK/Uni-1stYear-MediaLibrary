package viktor.view;

import javax.swing.*;

import viktor.generator.Media;
import viktor.generator.MediaGenerator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents a MediaLibrary with Movies, Tracks and Unclassified
 * Items. It presents the user with the option to sort the Movies and the Tracks
 * by different categories
 * 
 * @author Viktor
 *
 */
public class MediaLibrary extends JFrame {
	private Dimension minSize;
	private JComboBox filmSort;
	private JComboBox trackSort;
	private JPanel topPanel;
	private JPanel mid;
	private JPanel bot;
	private ScrollPane scroll;
	private static Pattern pFilm = Pattern.compile(".*\\(.*\\..*"); // matches
																	// if its a
																	// film
	private static Pattern theCheck = Pattern.compile("(?<=The ).*"); // matches
																		// if
																		// film
																		// starts
																		// with
																		// the
	private static Pattern pTrack = Pattern.compile("[^(].*\\-\\D*\\..*"); // matches
																			// if
																			// its
																			// a
																			// track
	private static Pattern pUnclassified = Pattern.compile("[^.]*"); // matches
																		// if
																		// its
																		// unclassified
	private static Pattern tName = Pattern.compile("[^-]*"); // matches the name
																// of the track
	private static Pattern tArtist = Pattern.compile("(?<=- )(?:(?!.aac|.oog|.aiff|.wma|.aax|.wav).)*"); // matches
																											// track
																											// artist
	private static Pattern fName = Pattern.compile("(\\w+\\s|\\w+(?=\\.))+"); // matches
																				// film
																				// name
	private static Pattern fDescription2 = Pattern.compile("(?<=\\()\\D\\D"); // matches
																				// film
																				// quality
																				// (letters)
	private static Pattern fDescription1 = Pattern.compile("(?<=\\()\\d\\d\\d\\d"); // matches
																					// film
																					// year
	private static Pattern fPixels = Pattern.compile("(\\d{3,4})p"); // matches
																		// film
																		// quality
																		// (pixels)
	private ArrayList<Media> films;
	private ArrayList<Media> tracks;

	/**
	 * class Constructor. Creates the view with a minimum Size of 600x800px
	 */
	public MediaLibrary() {
		super("Media Library");
		films = new ArrayList<Media>();
		tracks = new ArrayList<Media>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 1));
		createMovies();
		createTracks();
		createUnclassified();
		minSize = new Dimension(600, 800);
		setMinimumSize(minSize);
		setVisible(true);
	}

	/**
	 * creates the Movies panel and adds the needed functionality to its
	 * comboBox
	 */
	public void createMovies() { // creates the movies panel
		String[] filmSorter = { "Sort", "Title", "Release Year", "Quality" };
		filmSort = new JComboBox(filmSorter);
		JLabel filmLabel = new JLabel("Films");
		JPanel filmPanel = new JPanel(new BorderLayout());
		topPanel = new JPanel(new GridLayout(0, 2));
		topPanel.add(filmLabel);
		topPanel.add(filmSort);
		filmPanel.add(topPanel, BorderLayout.NORTH);
		JPanel mid = new JPanel();
		getFilms();
		generateFilms(mid);
		JScrollPane scroll = new JScrollPane(mid);
		filmPanel.add(scroll, BorderLayout.CENTER);
		filmPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		scroll.setBorder(null);
		filmSort.addActionListener(new ActionListener() { // adds an action
															// listener for the
															// combo box
			@Override
			public void actionPerformed(ActionEvent e) {
				if (filmSort.getSelectedIndex() != 0) { // if "Sort" do nothing
					mid.removeAll();
					if (filmSort.getSelectedItem() == "Title") {
						sortFilmsByTitle();
						generateFilms(mid);
						repaint();
						revalidate();
					} else if (filmSort.getSelectedItem() == "Release Year") {
						sortFilmsByYear();
						System.out.println("WIN");
						generateFilms(mid);
						repaint();
						revalidate();
					} else if (filmSort.getSelectedItem() == "Quality") {
						sortFilmsByQuality();
						generateFilms(mid);
						repaint();
						revalidate();
					}
				}

			}
		});
		add(filmPanel); // adds itself to the frame
	}

	/**
	 * sorts the Movies by their quality denoted by pixel number
	 */
	protected void sortFilmsByQuality() { // sorts films by quality (pixel
											// number)
		Collections.sort(films, new Comparator<Media>() {
			public int compare(Media film2, Media film1) {
				Matcher m1 = fPixels.matcher(film1.getName());
				m1.find();
				Matcher m2 = fPixels.matcher(film2.getName());
				m2.find();
				Integer a = new Integer(m1.group(1));
				Integer b = new Integer(m2.group(1));
				return a.compareTo(b);
			}
		});

	}

	/**
	 * sorts the Movies by their release year
	 */
	protected void sortFilmsByYear() { // sorts movies by their release year
		Collections.sort(films, new Comparator<Media>() {
			public int compare(Media film2, Media film1) {
				Matcher m2 = fDescription1.matcher(film1.getName());
				m2.find();
				Matcher m1 = fDescription1.matcher(film2.getName());
				m1.find();
				return m2.group(0).compareTo(m1.group(0));
			}
		});

	}

	/**
	 * sorts the Movies by their title name, ignoring "The" in the beginning of
	 * title if present
	 */
	protected void sortFilmsByTitle() { // sorts films by title (ignoring "The"
										// if found in the beginning
		Collections.sort(films, new Comparator<Media>() {
			public int compare(Media film2, Media film1) {

				Matcher m2 = fName.matcher(film1.getName());
				m2.find();
				Matcher m1 = fName.matcher(film2.getName());
				m1.find();
				String a = m1.group();
				String b = m2.group();
				Matcher m3 = theCheck.matcher(a);
				Matcher m4 = theCheck.matcher(b);
				if (m3.find()) {
					if (m4.find()) {
						return m3.group(0).compareTo(m4.group(0));
					} else
						return m3.group(0).compareTo(m2.group());
				} else if (m4.find()) {
					return m1.group(0).compareTo(m4.group());
				}
				return m1.group(0).compareTo(m2.group(0));

			}
		});

	}

	/**
	 * creates the Tracks panel and adds the needed functionality to its
	 * comboBox
	 */
	public void createTracks() { // creates the tracks panel
		String[] trackSorter = { "Sort", "Track Name", "Artist" };
		trackSort = new JComboBox(trackSorter);
		JLabel trackLabel = new JLabel("Music");
		JPanel trackPanel = new JPanel(new BorderLayout());
		topPanel = new JPanel(new GridLayout(0, 2));
		topPanel.add(trackLabel);
		topPanel.add(trackSort);
		trackPanel.add(topPanel, BorderLayout.NORTH);
		JPanel mid = new JPanel();
		getTracks();
		generateTracks(mid);
		JScrollPane scroll = new JScrollPane(mid);
		trackPanel.add(scroll, BorderLayout.CENTER);
		trackPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		scroll.setBorder(null);
		trackSort.addActionListener(new ActionListener() { // adds action
															// listener to the
															// combo box
			@Override
			public void actionPerformed(ActionEvent e) {
				if (trackSort.getSelectedIndex() != 0) {
					mid.removeAll();
					if (trackSort.getSelectedItem() == "Track Name") {
						sortTracksByName();
						generateTracks(mid);
						repaint();
						revalidate();
					} else if (trackSort.getSelectedItem() == "Artist") {
						sortTracksByArtist();
						generateTracks(mid);
						repaint();
						revalidate();
					}

				}

			}
		});
		add(trackPanel);
	}

	/**
	 * sorts the Tracks by performing artist
	 */
	protected void sortTracksByArtist() { // sorts tracks by artist
		Collections.sort(tracks, new Comparator<Media>() {
			public int compare(Media track2, Media track1) {
				Matcher m2 = tArtist.matcher(track2.getName());
				m2.find();
				Matcher m1 = tArtist.matcher(track1.getName());
				m1.find();
				return m2.group(0).compareTo(m1.group());
			}
		});
	}

	/**
	 * sorts the Tracks by their name
	 */
	protected void sortTracksByName() { // sorts tracks by name
		Collections.sort(tracks, new Comparator<Media>() {
			public int compare(Media track2, Media track1) {
				Matcher m2 = tName.matcher(track2.getName());
				m2.find();
				Matcher m1 = tName.matcher(track1.getName());
				m1.find();
				return m2.group(0).compareTo(m1.group());
			}
		});
	}

	/**
	 * creates the Unclassified panel
	 */
	public void createUnclassified() { // creates the panel for the unclassified
										// items
		JLabel ucLabel = new JLabel("Unclassified", SwingConstants.LEFT);
		JPanel ucPanel = new JPanel(new BorderLayout());
		topPanel = new JPanel(new GridLayout(0, 2));
		topPanel.add(ucLabel);
		JPanel mid = new JPanel();
		generateUc(mid);
		JScrollPane scroll = new JScrollPane(mid);
		ucPanel.add(topPanel, BorderLayout.NORTH);
		ucPanel.add(scroll, BorderLayout.CENTER);
		ucPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		scroll.setBorder(null);
		add(ucPanel);
	}

	/**
	 * gets all Media objects that correspond to a Movie
	 */
	public void getFilms() { // adds all movies to an array list
		for (Media a : MediaGenerator.getMedia()) {
			if (pFilm.matcher(a.getName()).matches()) {
				films.add(a);
			}
		}
	}

	/**
	 * Generates all the panels for the separate movies
	 */
	public void generateFilms(JPanel where) { // creates all the media panels
												// for the moies
		for (Media a : films) {
			Matcher m3 = fName.matcher(a.getName());
			Matcher m4 = fDescription2.matcher(a.getName());
			Matcher m5 = fDescription1.matcher(a.getName());
			m4.find();
			m3.find();
			m5.find();
			where.add(newMediaPanel(m3.group(0), m4.group(0) + " - " + m5.group(0), a.getImage()));
		}
	}

	/**
	 * Generates all the panels for the separate unclassified files
	 */
	public void generateUc(JPanel where) { // creates all the media panels for
											// the unclassified items
		for (Media a : MediaGenerator.getMedia()) {
			if (pUnclassified.matcher(a.getName()).matches()) {
				where.add(newMediaPanel(a.getName(), "Unclassified", a.getImage()));
			}
		}
	}

	/**
	 * gets all Media objects that correspond to a Track
	 */
	public void getTracks() { // gets all tracks and puts them in an arraylist
		for (Media a : MediaGenerator.getMedia()) {
			if (pTrack.matcher(a.getName()).matches()) {
				tracks.add(a);
			}
		}
	}

	/**
	 * Generates all the panels for the separate Track files
	 */
	public void generateTracks(JPanel where) { // creates all the media panels
												// for the tracks
		for (Media a : tracks) {
			Matcher m = tName.matcher(a.getName());
			m.find();
			Matcher m1 = tArtist.matcher(a.getName());
			m1.find();
			where.add(newMediaPanel(m.group(0), m1.group(0), a.getImage()));
		}
	}

	/**
	 * Creates a single media panel
	 * 
	 * @param name
	 *            the Name of the Item
	 * @param description
	 *            the Quality and Year of a Movie or the Artist of a Song.
	 *            Unclassified for Unclassified Items
	 * @param image
	 *            the corresponding thumbnail for the item
	 * @return a custom JPanel
	 */
	public JPanel newMediaPanel(String name, String description, JLabel image) { // creates
																					// a
																					// new
																					// mediaPanel
		JPanel mediaPanel = new JPanel(new BorderLayout());
		JPanel bot = new JPanel(new GridLayout(2, 1));
		JLabel dscrptLabel = new JLabel(description);
		Font f = dscrptLabel.getFont();
		bot.add(new JLabel(name));
		bot.add(dscrptLabel);
		dscrptLabel.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
		mediaPanel.add(image, BorderLayout.NORTH);
		mediaPanel.add(bot, BorderLayout.SOUTH);
		return mediaPanel;
	}
}
