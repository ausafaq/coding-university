package Jukebox;

public class CDPlayer {
    private Playlist playlist;
    private CD cd;

    // Constructors
    public CDPlayer(CD cd, Playlist playlist) {
        this.cd = cd;
        this.playlist = playlist;
    }

    public CDPlayer(CD cd) {
        this.cd = cd;
    }

    public CDPlayer(Playlist playlist) {
        this.playlist = playlist;
    }

    public void playSong(Song song) {
        // play a song
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }

}
