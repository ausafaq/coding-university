package Jukebox;

import java.util.Set;

public class Jukebox {

    class SongSelector {
        public Song getCurrentSong() {
            return null;
        }
    }

    private CDPlayer cdPlayer;
    private User user;
    private Set<CD> cdCollection;
    private SongSelector ts;

    public Jukebox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, SongSelector ts) {
        // initialize jukebox
    }

    public Song getCurrentSong() {
        return ts.getCurrentSong();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
